-- Exercise 5: Triggers
-- Scenario 1: Automatically update LastModified on customer updates
-- Scenario 2: Maintain a transaction audit log
-- Scenario 3: Enforce business rules on deposits and withdrawals

CREATE OR REPLACE TRIGGER trg_customers_last_modified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END trg_customers_last_modified;
/

CREATE OR REPLACE TRIGGER trg_transactions_audit
AFTER INSERT OR UPDATE OR DELETE ON Transactions
FOR EACH ROW
BEGIN
    IF INSERTING THEN
        INSERT INTO TransactionAudit (AuditID, TransactionID, AuditDate, Operation, AccountID, Amount, TransactionType)
        VALUES (TransactionAudit_seq.NEXTVAL, :NEW.TransactionID, SYSDATE, 'INSERT', :NEW.AccountID, :NEW.Amount, :NEW.TransactionType);
    ELSIF UPDATING THEN
        INSERT INTO TransactionAudit (AuditID, TransactionID, AuditDate, Operation, AccountID, Amount, TransactionType)
        VALUES (TransactionAudit_seq.NEXTVAL, :NEW.TransactionID, SYSDATE, 'UPDATE', :NEW.AccountID, :NEW.Amount, :NEW.TransactionType);
    ELSIF DELETING THEN
        INSERT INTO TransactionAudit (AuditID, TransactionID, AuditDate, Operation, AccountID, Amount, TransactionType)
        VALUES (TransactionAudit_seq.NEXTVAL, :OLD.TransactionID, SYSDATE, 'DELETE', :OLD.AccountID, :OLD.Amount, :OLD.TransactionType);
    END IF;
END trg_transactions_audit;
/

CREATE OR REPLACE TRIGGER trg_transactions_business_rules
BEFORE INSERT OR UPDATE ON Transactions
FOR EACH ROW
DECLARE
    v_balance NUMBER;
BEGIN
    IF :NEW.Amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20008, 'Transaction amount must be positive.');
    END IF;

    IF :NEW.TransactionType = 'Withdrawal' THEN
        SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = :NEW.AccountID;
        IF v_balance < :NEW.Amount THEN
            RAISE_APPLICATION_ERROR(-20009, 'Insufficient balance for withdrawal.');
        END IF;
    END IF;
END trg_transactions_business_rules;
/
