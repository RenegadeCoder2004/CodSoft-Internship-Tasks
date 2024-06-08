import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

public class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println(" ATM INTERFACE ");
        System.out.println("Welcome to the ATM");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void selectOption(int option) {
        Scanner scanner = new Scanner(System.in);
        switch (option) {
            case 1:
                System.out.println("Your Account Balance is: Rs" + account.getBalance());
                break;
            case 2:
                System.out.print("Enter the Amount To Deposit: ");
                double depositAmount = scanner.nextDouble();
                account.deposit(depositAmount);
                System.out.println("Deposited: Rs" + depositAmount);
                break;
            case 3:
                System.out.print("Enter the Amount To Withdraw: ");
                double withdrawAmount = scanner.nextDouble();
                if (account.withdraw(withdrawAmount)) {
                    System.out.println("Withdrawn: Rs" + withdrawAmount);
                } else {
                    System.out.println("Your Account Balance is Insufficient / Invalid Amount.");
                }
                break;
            case 4:
                System.out.println("Thank you for using the ATM. Goodbye!");
                break;
            default:
                System.out.println("Invalid Option. Please try again.");
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000); // Initial balance of $1000
        ATM atm = new ATM(account);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            atm.displayMenu();
            System.out.print("Please Select an Option: ");
            int option = scanner.nextInt();
            if (option == 4) {
                atm.selectOption(option);
                break;
            }
            atm.selectOption(option);
            System.out.println();
        }
    }
}
