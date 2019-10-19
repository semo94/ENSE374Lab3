package bank.accounts;

public class MoneyMarket extends Account {

    private int withdrawLimit; 
    
    /**
     * Class constructor
     * @param initialBalance first deposited balance by the user
     */
    public MoneyMarket(double initialBalance) {
        super("MoneyMarket", new String[] {"Cheques", "e-Transfer"}, initialBalance);
        this.setInterestRate(0.03);
        this.setRunningFees(0.25 * this.getInterestRate());
        this.setReservedAmount(5000);
        this.setWithdrawLimit(25);
    }
    
    @Override
    public void withdraw(double withdrawal) {
        // check the remaining allowed withdrawals
        if (this.getWithdrawLimit() > 0) {
            // check if the withdrawal amount exceeds the current balance
            if (this.getCurrentBalance() >= withdrawal) {
                // check if the withdrawal amount exceeds the reserved amount
                if ((this.getCurrentBalance() - withdrawal) >= this.getReservedAmount()) {
                    this.setCurrentBalance(this.getCurrentBalance() - withdrawal);
                    this.setWithdrawLimit(this.getWithdrawLimit() - 1);
                } else {
                    System.out.println("You can't go below the reserved fund!");
                }
            } else {
                System.out.print("Insufficient fund!");
            }
        } else {
            System.out.print("You have reached the maximum allowed withdrawals for this month");
        }
    }

    /** 
     * simple interest calculator
     * @param t is the time the money is invested for
     */
    public void calculateInterest(Integer t) {
        this.setCurrentBalance(this.getCurrentBalance() * (1 + this.getInterestRate() * t));
    }
    
    public void chargeMonthlyFees() {
        this.setCurrentBalance(this.getCurrentBalance() - this.getRunningFees());
    }

    public void resetWithdrawLimit() {
        this.setWithdrawLimit(25);
    }

    /**
     * @return the withdrawLimit
     */
    public int getWithdrawLimit() {
        return withdrawLimit;
    }

    /**
     * @param withdrawLimit the withdrawLimit to set
     */
    private void setWithdrawLimit(int withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }
}