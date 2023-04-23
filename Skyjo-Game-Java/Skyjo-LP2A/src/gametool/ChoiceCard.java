package gametool;

import java.util.Scanner;

public class ChoiceCard {
	private int row, column;
	private Scanner scan;
	
	/*---------------- Constructors ----------------*/
	
	public ChoiceCard(Scanner scan) {
		this.scan = scan;
		row = 0;
		column = 0;
	}
	
	/*---------------- Getters ----------------*/
	
	public int getRow() {
		return row;
	}
	
	public int getColunm() {
		return column;
	}
	
	/*! 
	 * @brief : recover the row in which the player want to play.
	 * Create a do while loop to be sure than the number enter by the play is between 1 and 4, 
	 * because he can't go out of the grid play.
	 * Moreover, there is a check-up try/catch to be sure than the input of the user is an integer,
	 * that allow not to have errors if it's not the case.
	 * */
	public void scanRow() {
		// Scan row
		do { // Acquisition control
			this.row = 0; // Initialize the default row number
			System.out.println("Enter row (it must be between 1 and 4) :");
			try { // Test if the input is a number
				// Read user input 
				row = scan.nextInt();
			} catch (Exception e) { 
				System.out.println("You have to enter a number");
				scan.next(); // Get the next complete token from the scanner
			}
			
		} while (row < 1 || row > 4) ; // End of row loop choice
	}
	
	/*! 
	 * @brief : recover the column in which the player want to play.
	 * Create a do while loop to be sure than the number enter by the play is between 1 and 4, 
	 * because he can't go out of the grid play.
	 * Moreover, there is a check-up try/catch to be sure than the input of the user is an integer,
	 * that allow not to have errors if it's not the case.
	 * */
	public void scanColunm(int i ) {
		// Scan column
		do { // Acquisition control
			column = 0; // Initialize the default column number
			System.out.println("Enter column (it must be between 1 and "+ i +") :");
			try { // Test if the input is a number
				// Read user input
				column = scan.nextInt();
			} catch (Exception e) {
				System.out.println("You have to enter a number");
				scan.next(); // Get the next complete token from the scanner
			}
		} while (column < 1 || column > 4 ); // End of column loop choice
		
	}
	
}
