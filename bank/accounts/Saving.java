package bank.accounts;

public class Saving extends Account {

    private int withdrawLimit;

    /**
     * Class constructor
     * @param initialBalance first deposited balance by the user
     */
    public Saving(double initialBalance) {
        super("Saving", new String[] {"e-Transfer"}, initialBalance);
        this.setInterestRate(0.02);
        this.setReservedAmount(200);
        this.setWithdrawLimit(10);
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
     * compound interest calculator
     * @param n is the number of times that interest is compounded per unit t
     * @param t is the time the money is invested for
     */
    public void calculateInterest(double n, Integer t) {
        this.setCurrentBalance(this.getCurrentBalance() * Math.pow(1 + ( this.getInterestRate() / n), n * t));
    }

    public void resetWithdrawLimit() {
        this.setWithdrawLimit(10);
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