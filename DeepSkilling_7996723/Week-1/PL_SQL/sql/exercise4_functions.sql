-- Exercise 4: Functions
-- Scenario 1: Calculate customer age for eligibility checks
-- Scenario 2: Compute monthly installment for a loan
-- Scenario 3: Check account balance sufficiency

CREATE OR REPLACE FUNCTION GetCustomerAge(
    p_customer_id IN NUMBER
) RETURN NUMBER IS
    v_dob DATE;
BEGIN
    SELECT DOB INTO v_dob FROM Customers WHERE CustomerID = p_customer_id;
    RETURN TRUNC(MONTHS_BETWEEN(SYSDATE, v_dob) / 12);
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN NULL;
END GetCustomerAge;
/

CREATE OR REPLACE FUNCTION ComputeMonthlyInstallment(
    p_loan_amount IN NUMBER,
    p_annual_rate IN NUMBER,
    p_period_months IN NUMBER
) RETURN NUMBER IS
    v_monthly_rate NUMBER;
BEGIN
    IF p_loan_amount <= 0 OR p_annual_rate <= 0 OR p_period_months <= 0 THEN
        RETURN NULL;
    END IF;

    v_monthly_rate := (p_annual_rate / 100) / 12;
    RETURN p_loan_amount * v_monthly_rate / (1 - POWER(1 + v_monthly_rate, -p_period_months));
END ComputeMonthlyInstallment;
/

CREATE OR REPLACE FUNCTION HasSufficientBalance(
    p_account_id IN NUMBER,
    p_amount IN NUMBER
) RETURN VARCHAR2 IS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_account_id;
    IF v_balance >= p_amount THEN
        RETURN 'Y';
    ELSE
        RETURN 'N';
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 'N';
END HasSufficientBalance;
/
