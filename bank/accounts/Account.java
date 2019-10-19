package bank.accounts;

public abstract class Account {

    private String accountType;
    private double currentBalance;
    private String[] services;
    private double runningFees;
    private double interestRate;
    private double reservedAmount;

    /**
     * class constructor
     * @param type the type of the concrete account
     * @param services the services that are provided by the concrete account
     * @param initialBalance the first deposited amount upon concrete account creation
     */
    public Account(String type, String[] services, double initialBalance) {
        this.setAccountType(type);
        this.setServices(services);
        this.setCurrentBalance(initialBalance);
    }

    /**
     * 
     * @param amount money that will be inserted to the account
     */
    public void deposite(double amount) {
        this.currentBalance += amount;
    }

    /**
     * should abstact method to be implemented in sub classes
     * 
     * @param withdrawal the amount that will be withdrawn
     */
    public abstract void withdraw(double withdrawal);

    /**
     * @return the accountType
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * @param accountType the accountType to set
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    /**
     * @return the currentBalance
     */
    public double getCurrentBalance() {
        return currentBalance;
    }

    /**
     * @param currentBalance the currentBalance to set
     */
    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    /**
     * @param services the services to set
     */
    public void setServices(String[] services) {
        this.services = services;
    }

    /**
     * @return the services
     */
    public String[] getServices() {
        return services;
    }

    /**
     * @return the reservedAmount
     */
    public double getReservedAmount() {
        return reservedAmount;
    }

    /**
     * @param reservedAmount the reservedAmount to set
     */
    public void setReservedAmount(double reservedAmount) {
        this.reservedAmount = reservedAmount;
    }

    /**
     * @return the interestRate
     */
    public double getInterestRate() {
        return interestRate;
    }
    
    /**
     * @param interestRate the interestRate to set
     */
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * @return the runningFees
     */
    public double getRunningFees() {
        return runningFees;
    }

    /**
     * @param runningFees the runningFees to set
     */
    public void setRunningFees(double runningFees) {
        this.runningFees = runningFees;
    }
}