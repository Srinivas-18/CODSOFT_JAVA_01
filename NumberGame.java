import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        // Initialize score and attempts
        int score = 0;
        int attempts = 0;

        // Set the range for the random number
        int minNum = 1;
        int maxNum = 100;

        // Set the maximum number of attempts
        int maxAttempts = 6;

        // Create a Random object to generate random numbers
        Random random = new Random();

        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Ask the user if they want to play again
        boolean playAgain = true;
        while (playAgain) {
            // Generate a random number
            int numberToGuess = random.nextInt(maxNum - minNum + 1) + minNum;

            System.out.println("Welcome to the number game! I'm thinking of a number between " + minNum + " and " + maxNum + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess the number.");

            // Reset attempts for each round
            attempts = 0;

            while (attempts < maxAttempts) {
                // Prompt the user to enter their guess
                System.out.print("Enter your guess: ");
                String userGuessStr = scanner.nextLine();

                // Check if the user's guess is a valid number
                try {
                    int userGuess = Integer.parseInt(userGuessStr);

                    // Check if the user's guess is within the range
                    if (userGuess < minNum || userGuess > maxNum) {
                        System.out.println("Please enter a number between " + minNum + " and " + maxNum + ".");
                        continue;
                    }

                    // Compare the user's guess with the generated number
                    if (userGuess == numberToGuess) {
                        System.out.println(" Congratulations! You guessed the number in " + (attempts + 1) + " attempts.");
                        score++;
                        break;
                    } else if (userGuess < numberToGuess) {
                        System.out.println("Too low! Try again.");
                    } else {
                        System.out.println("Too high! Try again.");
                    }

                    attempts++;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                }
            }

            // Check if the user ran out of attempts
            if (attempts == maxAttempts) {
                System.out.println("Sorry, you didn't guess the number. The number was " + numberToGuess + ".");
            }

            // Ask the user if they want to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainStr = scanner.nextLine();
            playAgain = playAgainStr.equalsIgnoreCase("yes");
        }

        // Display the user's score
        System.out.println("Your final score is " + score + " wins.");
    }
}
