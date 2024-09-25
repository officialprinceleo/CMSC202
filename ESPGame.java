/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: ESP game that randomly selects a color and compares it with the user's guess.
 * Due: 09/18/24
 * Platform/compiler:Eclipse
 * independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here:Leoul Hailu Woldeyes
 */

package classassignment1;

import java.util.Random;
import java.util.Scanner;

public class Assign1 {
	
	public static void main(String[] arg) {
	     // Define final constants for color choices
	     final String COLOR1 = "RED";
	     final String COLOR2 = "GREEN";
	     final String COLOR3 = "BLUE";
	     final String COLOR4 = "ORANGE";
	     final String COLOR5 = "YELLOW";
		
	     // Create a Scanner object for user input
		Scanner input = new Scanner(System.in);

		// Prompt for user details
		System.out.println("Please Enter your name: ");
		String name = input.nextLine();
		
		System.out.println("Can you please describe yourself: ");
		String detail = input.nextLine();
		
		System.out.println("Assignment Due: ");
		String due = input.nextLine();
	    
		// Start the ESP game
		System.out.println("CMSC203 Assignment1: Test your ESP skills!\n");

		int correctGuesses = 0;  // Counter for correct guesses
		
		// Loop through 10 rounds
		for (int round = 1; round <= 10; round++) {
			// Randomly select a color
			 Random random = new Random();	
			 int randColor = random.nextInt(5) + 1; // Generates a number between 1 and 5
	            String currentColor = "";
	            
	            // Assign a color based on random number
	            if(randColor == 1) {
	            	currentColor = COLOR1;
	            } else if(randColor == 2) {
	            	currentColor = COLOR2;
	            } else if(randColor == 3) {
	            	currentColor = COLOR3;
	            } else if(randColor == 4) {
	            	currentColor = COLOR4;
	            } else if(randColor == 5) {
	            	currentColor = COLOR5;
	            }

	            // Prompt the user to guess a color
	            System.out.println("Round " + round);
	            System.out.println("I am thinking of a color. Is it Red, Green, Blue, Orange, or Yellow?");
	            System.out.print("Enter your guess: ");
	            String guess = input.nextLine().toUpperCase(); // Convert user input to uppercase for consistency
	            
	            // Compare the user's guess with the randomly selected color
	            if (guess.equals(currentColor)) {
	            	correctGuesses++; // Increment correct guess counter
	            	System.out.println("Correct! I was thinking of " + currentColor + ".");
	            } else {
	            	System.out.println("Wrong. I was thinking of " + currentColor + ".");
	            }
	            
	            System.out.println(); // New line after each round
		}

		// After 10 rounds, display the final results
		System.out.println("Game Over.");
		System.out.println("You guessed " + correctGuesses + " out of 10 colors correctly.");
		System.out.println("Student Name: " + name);
		System.out.println("User Description: " + detail);
		System.out.println("Due Date: " + due);
	}
}
