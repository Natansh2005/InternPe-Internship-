import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Random rand = new Random();
        
        boolean playAgain = true;

        while (playAgain) {
            // CRITICAL: Generate the number OUTSIDE the inner loop
            int randNum = rand.nextInt(100) + 1; 
            int guess = -1;
            int tries = 0;

            System.out.println("\n--- I have picked a new number between 1 and 100! ---");

            // This loop stays active for the SAME number
            while (guess != randNum) {
                System.out.print("Enter your guess: ");
                
                if (reader.hasNextInt()) {
                    guess = reader.nextInt();
                    tries++;

                    if (guess == randNum) {
                        System.out.println("Correct! The number was " + randNum);
                        System.out.println("It took you " + tries + " tries.");
                    } else if (guess > randNum) {
                        System.out.println("Too high! Try again.");
                    } else {
                        System.out.println("Too low! Try again.");
                    }
                } else {
                    System.out.println("Invalid input. Enter a number.");
                    reader.next(); 
                }
            }

            System.out.print("Play again? (yes/no): ");
            String response = reader.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for playing!");
        reader.close();
    }
}
