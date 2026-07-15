import java.util.Scanner;

public class Main {

    static String numberCheck(Scanner scanner, String number) {
        while (true) {
            if (number.length() == 11 && number.startsWith("01")) {
                char thirdChar = number.charAt(2);
                if (thirdChar == '3' || thirdChar == '5' || thirdChar == '7' || thirdChar == '9' || thirdChar == '8') {
                    break; // Number is valid
                }
            }
            System.out.println("Please enter correct mobile number! Starts with 01 (followed by 3,5,7,8,9) and consists of 11 digits.");
            System.out.print("Enter number again: ");
            number = scanner.nextLine();
        }
        return number;
    }

    static void wrongPinWarning(int cnt){
        if(cnt >= 3){
            System.out.println("Three consecutive wrong attempts. System Reset!");
            return;
        }
        int attemptLeft = 3 - cnt;
        System.out.println("Remaining attempt " + attemptLeft+"!");
        return;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your Account Number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter your contact number: ");
        String mobile = scanner.nextLine();
        mobile = numberCheck(scanner, mobile);

        System.out.print("Enter your pin (5 digits): ");
        int pin = scanner.nextInt();

        while (pin < 10000 || pin > 99999) {
            System.out.print("Wrong Attempt! Enter your pin again (5 digits): ");
            pin = scanner.nextInt();
        }

        scanner.nextLine(); // Clear the input buffer

        int transactionType = -1;
        double balance = 0;

        System.out.println("\n");
        System.out.println("Hello " + name + "!\nYour Account number is: " + accountNumber + "\nContact number: " + mobile);

        while (true) {
            System.out.println("\n\nTransactions\n______________\n0. Exit\n1. Send Money\n2. Cash In\n3. Cash Out\n4. Check Balance");
            System.out.print("\nPlease Enter the transaction type: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }
            transactionType = scanner.nextInt();
            scanner.nextLine(); // Clear the input buffer

            if (transactionType == 0) {
                System.out.println("Thank you for using our service!");
                break;
            }

            if (transactionType == 1) {
                if (balance == 0) {
                    System.out.println("\nYou have insufficient balance! Please Cash In.\n");
                    continue;
                }
                System.out.print("\n1. Send Money\nPlease enter the Receiver Number: ");
                String receiver = scanner.nextLine();
                receiver = numberCheck(scanner, receiver);

                System.out.print("Enter the amount: ");
                int amount = scanner.nextInt();
                scanner.nextLine(); // Clear buffer

                if (amount <= 0) {
                    System.out.println("Invalid amount!");
                    continue;
                }
                if (amount > balance) {
                    System.out.println("\nYou have insufficient balance!");
                    continue;
                }

                System.out.print("Please enter the pin to Confirm: ");
                int pinCheck = scanner.nextInt();
                scanner.nextLine(); // Clear buffer

                int wrongPinCount = 0;
                boolean reset = false;

                while (pin != pinCheck) {
                    wrongPinCount++;
                    wrongPinWarning(wrongPinCount);

                    if (wrongPinCount >= 3) {
                        reset = true;
                        break;
                    }
                    System.out.print("Pin Does Not Match. Enter again: ");
                    pinCheck = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer
                }
                if(reset){
                    continue;
                }
                balance -= amount;
                System.out.println("\n" + amount + " BDT Send Money to " + receiver + " Successful! Remaining Balance: " + balance);

            } else if (transactionType == 2) {
                System.out.println("\n2. Cash In");
                System.out.print("Enter the amount: ");
                int amount = scanner.nextInt();
                scanner.nextLine(); // Clear buffer

                while (amount <= 0) {
                    System.out.print("Please enter valid amount!\nEnter the amount: ");
                    amount = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer
                }

                balance += amount;
                System.out.println("Cash in successful! Your Current Balance is: " + balance);

            } else if (transactionType == 3) {
                System.out.print("\n3. Cash out\nPlease enter Agent Number: ");
                String agent = scanner.nextLine();
                agent = numberCheck(scanner, agent);

                System.out.print("Enter the amount: ");
                int amount = scanner.nextInt();
                scanner.nextLine(); // Clear buffer

                if (amount > balance) {
                    System.out.println("You have insufficient balance! Please Cash In.");
                    continue;
                }

                System.out.print("Please enter the pin to Confirm: ");
                int pinCheck = scanner.nextInt();
                scanner.nextLine(); // Clear buffer

                int wrongPinCount = 0;
                boolean reset = false;

                while (pin != pinCheck) {
                    wrongPinCount++;
                    wrongPinWarning(wrongPinCount);
                    if (wrongPinCount >= 3){
                        reset = true;
                        break;
                    }
                    System.out.print("Pin Does Not Match. Enter again: ");
                    pinCheck = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer
                }

                if (reset) {
                    continue;
                }

                balance -= amount;
                System.out.println(amount + " BDT Cash Out to " + agent + " Successful! New Balance: " + balance);

            } else if (transactionType == 4) {
                System.out.println("\nYour Current Balance is: " + balance + " BDT");
            } else {
                System.out.println("Invalid Transaction Type. Try Again!");
            }
        }
        scanner.close();
    }
}
