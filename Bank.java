import java.util.*;
import bank.ScoreTracker;
import bank.accounts.Account;
import bank.accounts.Chequing;
import bank.accounts.Saving;
import bank.accounts.MoneyMarket;

class Bank {
    public static void main(String[] args) {
        // initiate input scanner object
        Scanner scanner = new Scanner(System.in);
        // ask the user to select the preferred mode
        System.out.println("Enter 1 to run the app or 2 to test the app");
        // invoke the chosen mood
        switch (scanner.next()) {
            case "1":
                Bank.runBank(scanner);
                break;
            case "2":
                Bank.testBank();
                break;
            default:
                System.out.println("Wrong Selection!");
                break;
        }
        scanner.close();
    }

    public static void runBank(Scanner scanner) {
        // initiate score counter for each account type
        ScoreTracker chequingScore = new ScoreTracker("Chequing");
        ScoreTracker savingScore = new ScoreTracker("Saving");
        ScoreTracker moneyMarketScore = new ScoreTracker("Money Market");

        // STARTING USER SURVEY TO MATCH THE BEST ACCOUNT...

        // Question 1
        System.out.println("What are the least services you would like to have?");
        System.out.println("1: e-Transfare");
        System.out.println("2: e-Transfare and Cheque Book");
        System.out.println("3: e-Transfare, Cheque Book, and Debit Card");
        switch (scanner.next()) {
            case "1":
                savingScore.setScore(savingScore.getScore() + 1);
                moneyMarketScore.setScore(moneyMarketScore.getScore() + 1);
                chequingScore.setScore(chequingScore.getScore() + 1);
                break;
            case "2":
                moneyMarketScore.setScore(moneyMarketScore.getScore() + 1);
                chequingScore.setScore(chequingScore.getScore() + 1);
                break;
            case "3":
                chequingScore.setScore(chequingScore.getScore() + 1);
                break;
            default:
                System.out.println("Wrong Selection, BYE!");
                return;
        }

        // Question 2
        System.out.println("Which one of the following options do you prefer?");
        System.out.println("1: No interest");
        System.out.println("2: 2% compound interest");
        System.out.println("3: 3% simple interest");
        switch (scanner.next()) {
            case "1":
                chequingScore.setScore(chequingScore.getScore() + 1);
                break;
            case "2":
                savingScore.setScore(savingScore.getScore() + 1);
                break;
            case "3":
                moneyMarketScore.setScore(moneyMarketScore.getScore() + 1);
                break;
            default:
                System.out.println("Wrong Selection, BYE!");
                return;
        }

        // Question 3
        System.out.println("How much money can you hold as a reserved fund in your account?");
        System.out.println("1: Zero dollar!");
        System.out.println("2: 200$ or more");
        System.out.println("3: 5000$ or more");
        switch (scanner.next()) {
            case "1":
                chequingScore.setScore(chequingScore.getScore() + 1);
                break;
            case "2":
                savingScore.setScore(savingScore.getScore() + 1);
                chequingScore.setScore(chequingScore.getScore() + 1);
                break;
            case "3":
                moneyMarketScore.setScore(moneyMarketScore.getScore() + 1);
                savingScore.setScore(savingScore.getScore() + 1);
                chequingScore.setScore(chequingScore.getScore() + 1);
                break;
            default:
                System.out.println("Wrong Selection, BYE!");
                return;
        }
        
        // Question 4
        System.out.println("How many withdrawals are you expecting to make per month?");
        System.out.println("1: Less than or equal to 10");
        System.out.println("2: Between 11 and 25");
        System.out.println("3: More than 25");
        switch (scanner.next()) {
            case "1":
                moneyMarketScore.setScore(moneyMarketScore.getScore() + 1);
                savingScore.setScore(savingScore.getScore() + 1);
                chequingScore.setScore(chequingScore.getScore() + 1);
                break;
            case "2":
                chequingScore.setScore(chequingScore.getScore() + 1);
                moneyMarketScore.setScore(moneyMarketScore.getScore() + 1);
                break;
            case "3":
                chequingScore.setScore(chequingScore.getScore() + 1);
                break;
            default:
                System.out.println("Wrong Selection, BYE!");
                return;
        }

        // Evaluate the results
        List<ScoreTracker> accountsList = new ArrayList<>();
        accountsList.add(chequingScore);
        accountsList.add(savingScore);
        accountsList.add(moneyMarketScore);
        ScoreTracker recommendedMatch = Collections.max(accountsList, Comparator.comparing(s -> s.getScore()));

        // Provide recommendation
        System.out.println("Based on the provided answers, your ideal account type would be: " + recommendedMatch.getType() + " account");
        System.out.println("1: Confirm the recommended account");
        System.out.println("2: Retake the survey");
        
        // get user confirmation
        switch (scanner.next()) {
            case "1":
                System.out.println("Please insert the initial deposit amount in CAD");
                break;
             case "2":
                Bank.runBank(scanner);
                break;       
            default:
                System.out.println("Wrong Selection, BYE!");
                return;
        }

        // get initial deposite
        double deposit;
        if (scanner.hasNextDouble()) {
           deposit = scanner.nextDouble();
        } else {
            System.out.println("Wrong entered amount, BYE!");
            return;
        }

        // create a new account for the user
        switch (recommendedMatch.getType()) {
            case "Chequing":
                Chequing chequingAccount = new Chequing(deposit);
                Bank.displayResults(chequingAccount, recommendedMatch);
                break;
            case "Saving":
                Saving savingAccount = new Saving(deposit);
                Bank.displayResults(savingAccount, recommendedMatch);
                break;
            case "Money Market":
                MoneyMarket moneyMarketAccount = new MoneyMarket(deposit); 
                Bank.displayResults(moneyMarketAccount, recommendedMatch);
                break;
        }
    }

    public static void displayResults(Account account, ScoreTracker recommendation) {
        System.out.println("Congratulation! your " + recommendation.getType() +
        " account has been created with a current balance of " + account.getCurrentBalance());
        System.out.println("Your account interest rate is: " + account.getInterestRate());
        System.out.println("Your account monthly running fees is: " + account.getInterestRate());
        System.out.println("Your account will provide the following services: " + Arrays.toString(account.getServices()));
    }

    public static void testBank() {
        // open new accounts
        Saving monthlyAccount = new Saving(200);
        Saving biweeklyAccount = new Saving(200);
        // simulate twelve months cycle
        for (int i = 0; i < 12; i++) {
            monthlyAccount.deposite(500);
            biweeklyAccount.deposite(500);
            monthlyAccount.calculateInterest(1, 1);
            biweeklyAccount.calculateInterest(2.2, 1);
        }
        System.out.println("Balance in the Saving account after one year compounded monthly: " + monthlyAccount.getCurrentBalance());
        System.out.println("Balance in the Saving account after one year compounded biweekly: " + biweeklyAccount.getCurrentBalance());
    }
}