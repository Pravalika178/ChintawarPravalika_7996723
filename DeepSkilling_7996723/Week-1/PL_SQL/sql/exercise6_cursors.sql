-- Exercise 6: Cursors
-- Scenario 1: Generate monthly statements for all customers
-- Scenario 2: Apply annual fee to all accounts
-- Scenario 3: Update interest rate for all loans based on a new policy

SET SERVEROUTPUT ON;

DECLARE
    CURSOR c_customers IS
        SELECT c.CustomerID, a.AccountID, a.Balance
        FROM Customers c
        JOIN Accounts a ON c.CustomerID = a.CustomerID;
    v_statement_id NUMBER := 100;
BEGIN
    FOR r IN c_customers LOOP
        INSERT INTO MonthlyStatements (StatementID, CustomerID, AccountID, StatementMonth, Balance, GeneratedDate)
        VALUES (v_statement_id, r.CustomerID, r.AccountID, TO_CHAR(SYSDATE, 'YYYY-MM'), r.Balance, SYSDATE);
        v_statement_id := v_statement_id + 1;
    END LOOP;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Monthly statements generated.');
END;
/

DECLARE
    CURSOR c_accounts IS
        SELECT AccountID FROM Accounts;
BEGIN
    FOR r IN c_accounts LOOP
        UPDATE Accounts
        SET Balance = Balance - 25,
            LastModified = SYSDATE
        WHERE AccountID = r.AccountID;
    END LOOP;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Annual fees applied to all accounts.');
END;
/

DECLARE
    CURSOR c_loans IS
        SELECT LoanID FROM Loans;
BEGIN
    FOR r IN c_loans LOOP
        UPDATE Loans
        SET InterestRate = InterestRate + 0.25
        WHERE LoanID = r.LoanID;
    END LOOP;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Loan interest rates updated for new policy.');
END;
/
