-- Exercise 2: Error Handling
-- Scenario 1: Handle exceptions during fund transfers
-- Scenario 2: Manage errors when updating employee salaries
-- Scenario 3: Ensure data integrity when adding a new customer

SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_account_id IN NUMBER,
    p_to_account_id IN NUMBER,
    p_amount IN NUMBER
) AS
    v_from_balance NUMBER;
BEGIN
    SELECT Balance INTO v_from_balance FROM Accounts WHERE AccountID = p_from_account_id;

    IF p_amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Transfer amount must be positive.');
    ELSIF v_from_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20002, 'Insufficient funds for transfer.');
    END IF;

    UPDATE Accounts
    SET Balance = Balance - p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_from_account_id;

    UPDATE Accounts
    SET Balance = Balance + p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_to_account_id;

    INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
    VALUES (Transactions_seq.NEXTVAL, p_from_account_id, SYSDATE, p_amount, 'Withdrawal');

    INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
    VALUES (Transactions_seq.NEXTVAL, p_to_account_id, SYSDATE, p_amount, 'Deposit');

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Transfer completed: ' || p_amount || ' from ' || p_from_account_id || ' to ' || p_to_account_id);
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Account not found. Transfer aborted.');
        ROLLBACK;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
        ROLLBACK;
END TransferFunds;
/

CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_employee_id IN NUMBER,
    p_new_salary IN NUMBER
) AS
BEGIN
    IF p_new_salary <= 0 THEN
        RAISE_APPLICATION_ERROR(-20003, 'Salary must be greater than zero.');
    END IF;

    UPDATE Employees
    SET Salary = p_new_salary
    WHERE EmployeeID = p_employee_id;

    IF SQL%ROWCOUNT = 0 THEN
        RAISE NO_DATA_FOUND;
    END IF;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Salary updated for employee ' || p_employee_id);
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Employee not found: ' || p_employee_id);
        ROLLBACK;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error updating salary: ' || SQLERRM);
        ROLLBACK;
END UpdateSalary;
/

CREATE OR REPLACE PROCEDURE AddCustomer(
    p_customer_id IN NUMBER,
    p_name IN VARCHAR2,
    p_dob IN DATE,
    p_balance IN NUMBER
) AS
BEGIN
    IF p_customer_id IS NULL OR p_name IS NULL OR p_dob IS NULL THEN
        RAISE_APPLICATION_ERROR(-20004, 'Customer ID, name, and DOB are required.');
    END IF;

    INSERT INTO Customers (CustomerID, Name, DOB, Balance, Status, LastModified)
    VALUES (p_customer_id, p_name, p_dob, NVL(p_balance, 0), 'Standard', SYSDATE);

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Customer added: ' || p_name);
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Customer already exists: ' || p_customer_id);
        ROLLBACK;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error adding customer: ' || SQLERRM);
        ROLLBACK;
END AddCustomer;
/
