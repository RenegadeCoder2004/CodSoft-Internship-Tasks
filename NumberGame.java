import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    private static int Max_Attempts;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("Welcome to the Number Game!");
            System.out.print("Enter the Number of chances you required: ");
            int Max_Attempts = scanner.nextInt();
            System.out.println("Guess a number between 1 and 100. You have " + Max_Attempts + " attempts.");

            while (attempts < Max_Attempts && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    hasGuessedCorrectly = true;
                    int chance = Max_Attempts - attempts;
                    score += Max_Attempts - attempts + 1;       // Additional points for fewer attempts
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + numberToGuess);
            }

            System.out.println("Your score: " + score);
            System.out.print("Do you want to play again? Enter (yes/no): ");
            scanner.nextLine(); // Consume newline
            String response = scanner.nextLine();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing! Your final score is: " + score);
        scanner.close();
    }
}