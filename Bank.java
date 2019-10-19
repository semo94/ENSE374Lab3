import java.util.Scanner;
import bank.ScoreTracker;
import bank.accounts.Chequing;
import bank.accounts.Saving;
import bank.accounts.MoneyMarket;

class Bank {
    public static void main(String[] args) {
        // initiate input scanner object
        Scanner scanner = new Scanner(System.in);
        // ask the user to select the preferred mode
        System.out.println("Enter 1 to run the app or 2 to test the app");
        int option = scanner.nextInt();
        // invoke the chosen mood
        switch (option) {
            case 1:
                Bank.runBank(scanner);
                break;
            case 2:
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
        ScoreTracker chequingScore = new ScoreTracker("chequing");
        ScoreTracker savingScore = new ScoreTracker("saving");
        ScoreTracker moneyMarketScore = new ScoreTracker("moneyMarket");

        // STARTING USER SURVEY TO MATCH THE BEST ACCOUNT...

        // Question 1
        System.out.println("What are the least services you would like to have?");
        System.out.println("1: e-Transfare");
        System.out.println("2: e-Transfare and Cheque Book");
        System.out.println("3: e-Transfare, Cheque Book, and Debit Card");
        switch (scanner.nextInt()) {
            case 1:
                savingScore.setScore(savingScore.getScore() + 1);
                moneyMarketScore.setScore(moneyMarketScore.getScore() + 1);
                chequingScore.setScore(chequingScore.getScore() + 1);
                break;
            case 2:
                moneyMarketScore.setScore(moneyMarketScore.getScore() + 1);
                chequingScore.setScore(chequingScore.getScore() + 1);
                break;
            case 3:
                chequingScore.setScore(chequingScore.getScore() + 1);
                break;
            default:
                System.out.println("Wrong Selection!");
                break;
        }

        // Question 2
        System.out.println("Which one of the following options do you prefer?");
        System.out.println("1: No interest");
        System.out.println("2: 2% compound interest");
        System.out.println("3: 3% simple interest");
        switch (scanner.nextInt()) {
            case 1:
                chequingScore.setScore(chequingScore.getScore() + 1);
                break;
            case 2:
                savingScore.setScore(savingScore.getScore() + 1);
                break;
            case 3:
                moneyMarketScore.setScore(moneyMarketScore.getScore() + 1);
                break;
            default:
                System.out.println("Wrong Selection!");
                break;
        }

        // Question 3
        System.out.println("How much money can you hold as a reserved fund in your account?");
        System.out.println("1: Zero dollar!");
        System.out.println("2: 200$ or more");
        System.out.println("3: 5000$ or more");
        switch (scanner.nextInt()) {
            case 1:
                chequingScore.setScore(chequingScore.getScore() + 1);
                break;
            case 2:
                savingScore.setScore(savingScore.getScore() + 1);
                chequingScore.setScore(chequingScore.getScore() + 1);
                break;
            case 3:
                moneyMarketScore.setScore(moneyMarketScore.getScore() + 1);
                savingScore.setScore(savingScore.getScore() + 1);
                chequingScore.setScore(chequingScore.getScore() + 1);
                break;
            default:
                System.out.println("Wrong Selection!");
                break;
        }
        
        // Question 4
        System.out.println("How many withdrawals are you expecting to make per month?");
        System.out.println("1: Less than or equal to 10");
        System.out.println("2: Between 11 and 25");
        System.out.println("3: More than 25");
        switch (scanner.nextInt()) {
            case 1:
                moneyMarketScore.setScore(moneyMarketScore.getScore() + 1);
                savingScore.setScore(savingScore.getScore() + 1);
                chequingScore.setScore(chequingScore.getScore() + 1);
                break;
            case 2:
                chequingScore.setScore(chequingScore.getScore() + 1);
                moneyMarketScore.setScore(moneyMarketScore.getScore() + 1);
                break;
            case 3:
                chequingScore.setScore(chequingScore.getScore() + 1);
                break;
            default:
                System.out.println("Wrong Selection!");
                break;
        }

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