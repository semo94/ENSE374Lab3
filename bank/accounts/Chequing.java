package bank.accounts;

public class Chequing extends Account {

    /**
     * Class constructor
     * @param initialBalance first deposited balance by the user
     */
    public Chequing(double initialBalance) {
        super("Chequing", new String[] {"Debit Card", "Cheques", "e-Transfer"}, initialBalance);
        this.setRunningFees(10);
    }

    @Override
    public void withdraw(double withdrawal) {
        // check if the withdrawal amount exceeds the reserved amount
        if (this.getCurrentBalance() >= withdrawal) {
            this.setCurrentBalance(this.getCurrentBalance() - withdrawal);
        } else {
            System.out.print("Insufficient fund!");
        }
    }

    public void chargeMonthlyFees() {
        this.setCurrentBalance(this.getCurrentBalance() - this.getRunningFees());
    }
}