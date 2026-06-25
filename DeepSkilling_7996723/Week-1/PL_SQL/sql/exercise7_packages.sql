-- Exercise 7: Packages
-- Scenario 1: Group customer-related procedures and functions
-- Scenario 2: Create package to manage employee data
-- Scenario 3: Group account-related operations

CREATE OR REPLACE PACKAGE CustomerPkg IS
    PROCEDURE PromoteVip;
    PROCEDURE ListSeniorLoanDiscounts;
    FUNCTION GetAge(p_customer_id IN NUMBER) RETURN NUMBER;
END CustomerPkg;
/
CREATE OR REPLACE PACKAGE BODY CustomerPkg IS
    PROCEDURE PromoteVip IS
    BEGIN
        UPDATE Customers
        SET Status = 'VIP'
        WHERE Balance >= 5000;
        COMMIT;
    END PromoteVip;

    PROCEDURE ListSeniorLoanDiscounts IS
        v_age NUMBER;
    BEGIN
        FOR r IN (SELECT c.CustomerID, c.Name, c.DOB, l.LoanID FROM Customers c JOIN Loans l ON c.CustomerID = l.CustomerID) LOOP
            v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, r.DOB) / 12);
            IF v_age > 60 THEN
                DBMS_OUTPUT.PUT_LINE('Senior loan discount candidate: ' || r.Name || ' LoanID=' || r.LoanID);
            END IF;
        END LOOP;
    END ListSeniorLoanDiscounts;

    FUNCTION GetAge(p_customer_id IN NUMBER) RETURN NUMBER IS
        v_dob DATE;
    BEGIN
        SELECT DOB INTO v_dob FROM Customers WHERE CustomerID = p_customer_id;
        RETURN TRUNC(MONTHS_BETWEEN(SYSDATE, v_dob) / 12);
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN NULL;
    END GetAge;
END CustomerPkg;
/

CREATE OR REPLACE PACKAGE EmployeePkg IS
    PROCEDURE GiveBonus;
    PROCEDURE UpdateSalary(p_employee_id IN NUMBER, p_new_salary IN NUMBER);
END EmployeePkg;
/
CREATE OR REPLACE PACKAGE BODY EmployeePkg IS
    PROCEDURE GiveBonus IS
    BEGIN
        FOR emp IN (SELECT EmployeeID, Position FROM Employees) LOOP
            IF emp.Position = 'Manager' THEN
                UPDATE Employees SET Salary = Salary * 1.05 WHERE EmployeeID = emp.EmployeeID;
            ELSIF emp.Position = 'Developer' THEN
                UPDATE Employees SET Salary = Salary * 1.03 WHERE EmployeeID = emp.EmployeeID;
            ELSE
                UPDATE Employees SET Salary = Salary * 1.02 WHERE EmployeeID = emp.EmployeeID;
            END IF;
        END LOOP;
        COMMIT;
    END GiveBonus;

    PROCEDURE UpdateSalary(p_employee_id IN NUMBER, p_new_salary IN NUMBER) IS
    BEGIN
        UPDATE Employees
        SET Salary = p_new_salary
        WHERE EmployeeID = p_employee_id;
        COMMIT;
    END UpdateSalary;
END EmployeePkg;
/

CREATE OR REPLACE PACKAGE AccountPkg IS
    PROCEDURE ApplyAnnualFee;
    PROCEDURE TransferBetweenAccounts(p_from_account IN NUMBER, p_to_account IN NUMBER, p_amount IN NUMBER);
END AccountPkg;
/
CREATE OR REPLACE PACKAGE BODY AccountPkg IS
    PROCEDURE ApplyAnnualFee IS
    BEGIN
        UPDATE Accounts SET Balance = Balance - 25, LastModified = SYSDATE;
        COMMIT;
    END ApplyAnnualFee;

    PROCEDURE TransferBetweenAccounts(p_from_account IN NUMBER, p_to_account IN NUMBER, p_amount IN NUMBER) IS
        v_from_balance NUMBER;
    BEGIN
        SELECT Balance INTO v_from_balance FROM Accounts WHERE AccountID = p_from_account;
        IF v_from_balance < p_amount THEN
            RAISE_APPLICATION_ERROR(-20010, 'Insufficient funds for transfer.');
        END IF;
        UPDATE Accounts SET Balance = Balance - p_amount, LastModified = SYSDATE WHERE AccountID = p_from_account;
        UPDATE Accounts SET Balance = Balance + p_amount, LastModified = SYSDATE WHERE AccountID = p_to_account;
        COMMIT;
    END TransferBetweenAccounts;
END AccountPkg;
/
