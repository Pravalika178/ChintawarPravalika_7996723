-- Exercise 1: Control Structures
-- Scenario 1: Discount loan interest for customers above 60 years old
-- Scenario 2: Promote customers to VIP based on balance
-- Scenario 3: Send reminders for loans due within 30 days

SET SERVEROUTPUT ON;

DECLARE
    v_age NUMBER;
BEGIN
    FOR r IN (SELECT c.CustomerID, c.Name, c.DOB, l.LoanID, l.InterestRate
              FROM Customers c
              JOIN Loans l ON c.CustomerID = l.CustomerID) LOOP
        v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, r.DOB) / 12);
        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = r.LoanID;
            DBMS_OUTPUT.PUT_LINE('Applied senior discount to loan ' || r.LoanID || ' for ' || r.Name);
        END IF;
    END LOOP;

    FOR r IN (SELECT CustomerID, Name, Balance FROM Customers) LOOP
        IF r.Balance >= 5000 THEN
            UPDATE Customers SET Status = 'VIP' WHERE CustomerID = r.CustomerID;
            DBMS_OUTPUT.PUT_LINE('Promoted ' || r.Name || ' to VIP');
        ELSE
            UPDATE Customers SET Status = 'Standard' WHERE CustomerID = r.CustomerID;
        END IF;
    END LOOP;

    FOR r IN (SELECT c.CustomerID, c.Name, l.LoanID, l.EndDate
              FROM Customers c
              JOIN Loans l ON c.CustomerID = l.CustomerID
              WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30) LOOP
        DBMS_OUTPUT.PUT_LINE('Loan due soon for ' || r.Name || ': LoanID=' || r.LoanID || ' due ' || TO_CHAR(r.EndDate, 'YYYY-MM-DD'));
    END LOOP;

    COMMIT;
END;
/
