package gametool;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;


/*!
 *  @brief : all functions necessary for start the game
 */

public class StartGame {

	private char choice;
	private static Scanner scan; 
	
	
	/*---------------- Constructor ----------------*/
	public StartGame(Scanner scan) {
		StartGame.scan = scan;
	}
	
	
	/*---------------- Methods ----------------*/
	/*!
	 *  @brief : Create a loop for knowing, if the user want to play.
	 * It check all of the possibility to be sure than the input of the user
	 * is correct. That's why, there is a try/catch in order to do not create errors
	 * y and Y : Yes / n and N : No
	 * */
	
	public void lauchGame(){
		do {
			choice = '\u0000';
			System.out.println("Do you want to play Skyjo ? (Y) Yes (N) No");
			try { // Test if the input is a char 
				choice = StartGame.scan.next().charAt(0); // Read the user input
			} catch (Exception e) {
				System.out.println("You have to enter a char");
				StartGame.scan.next();
			}
		// The users can use upper or lower case the both are check
		} while (choice != 'Y' && choice != 'N' && choice != 'y' && choice != 'n'); // End of the do while loop 
	}
	
	/*! 
	 * @brief : return a boolean according to the user' choice
	*/
	
	public boolean hasSayYes() {
		if (choice != 'Y' || choice != 'y') {
			return true; 
		}
		return false;
		
	}
	
	/*!
	 * @brief : ask to the user the number of players who will play and return it.
	 * This function create a loop which end when the number enter is between 2 and 8.
	 * Moreover, there is a check-up try/catch to be sure than the input of the user is an integer,
	 * that allow not to have errors if it's not the case.
	 * */
	
	public static int askNumberOfPlayers() {
		int nbPlayer;
		do { // Acquisition control
			nbPlayer = 0; // Initialize the default number of player 
			System.out.println("How many player ?");
			try { // Test if the input is a number
				// Read user input
				nbPlayer = scan.nextInt();
			} catch (Exception e){ // If is'nt a number, there're not errors, there is a print for explain the problem
				System.out.println("You have to enter a number");
				scan.next(); // Get the next complete token from the scanner
			}
		} while (nbPlayer < 2 || nbPlayer > 8); // End of the do while loop
		
		return nbPlayer;
	}
	
}
