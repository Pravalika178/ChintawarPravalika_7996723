-- Exercise 3: Stored Procedures
-- Scenario 1: Process monthly interest for savings accounts
-- Scenario 2: Implement employee bonus scheme
-- Scenario 3: Transfer funds between customer accounts

SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    FOR r IN (SELECT AccountID, Balance FROM Accounts WHERE AccountType = 'Savings') LOOP
        UPDATE Accounts
        SET Balance = Balance + (Balance * 0.005),
            LastModified = SYSDATE
        WHERE AccountID = r.AccountID;
    END LOOP;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Monthly interest processed for savings accounts.');
END ProcessMonthlyInterest;
/

CREATE OR REPLACE PROCEDURE GrantEmployeeBonus IS
BEGIN
    FOR emp IN (SELECT EmployeeID, Salary, Position FROM Employees) LOOP
        IF emp.Position = 'Manager' THEN
            UPDATE Employees SET Salary = Salary * 1.05 WHERE EmployeeID = emp.EmployeeID;
        ELSIF emp.Position = 'Developer' THEN
            UPDATE Employees SET Salary = Salary * 1.03 WHERE EmployeeID = emp.EmployeeID;
        ELSE
            UPDATE Employees SET Salary = Salary * 1.02 WHERE EmployeeID = emp.EmployeeID;
        END IF;
    END LOOP;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Employee bonuses applied.');
END GrantEmployeeBonus;
/

CREATE OR REPLACE PROCEDURE CustomerAccountTransfer(
    p_customer_id IN NUMBER,
    p_from_account_id IN NUMBER,
    p_to_account_id IN NUMBER,
    p_amount IN NUMBER
) AS
    v_from_balance NUMBER;
    v_owner_count NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_owner_count
    FROM Accounts
    WHERE AccountID IN (p_from_account_id, p_to_account_id)
      AND CustomerID = p_customer_id;

    IF v_owner_count < 2 THEN
        RAISE_APPLICATION_ERROR(-20005, 'Both accounts must belong to the same customer.');
    END IF;

    SELECT Balance INTO v_from_balance FROM Accounts WHERE AccountID = p_from_account_id;

    IF p_amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20006, 'Transfer amount must be positive.');
    ELSIF v_from_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20007, 'Insufficient funds in the source account.');
    END IF;

    UPDATE Accounts
    SET Balance = Balance - p_amount, LastModified = SYSDATE
    WHERE AccountID = p_from_account_id;

    UPDATE Accounts
    SET Balance = Balance + p_amount, LastModified = SYSDATE
    WHERE AccountID = p_to_account_id;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Customer transfer completed.');
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
        ROLLBACK;
END CustomerAccountTransfer;
/
