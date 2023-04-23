package gametool;

import java.util.Scanner;

import skyjo.BoardArray;

public class PlayMethods {
	
	private static Scanner scan = new Scanner(System.in);
	
	public static void firstChoiceOfEachPlayer(BoardArray boards, int nbPlayer) {
		/*--- Every player reverse two card of his board ---*/
		for (int i = 0; i < nbPlayer; i++) {
			
			for (int k = 0 ; k < 2 ; k++) {
				boards.displayTargetBoard(i); // Print the player board
				
				
				System.out.println("Reverse card "+(k+1)+" :");
				
				
				// Scan the choice of the player
				ChoiceCard choicecard = new ChoiceCard(scan);
				
				choicecard.scanRow();
				choicecard.scanColunm(boards.get(i).getColumn());
				
				if (!boards.get(i).getBoard()[choicecard.getRow()-1][choicecard.getColunm()-1].getHidden()) { // Check if card is already reversed
					k -= 1; // If yes we re-ask the user
					System.out.println("Error card is already reversed");
				}else {
					boards.cardReverse(choicecard.getRow()-1, choicecard.getColunm()-1, i); // reverse the card
				}
				
				// Clear screen
				for (int x = 0; x < 50; ++x) System.out.println(); 
				
			}
		}
	}
	/*! 
	 * @brief : ask to the players the card's position who want to show.
	 * Firstly, that print the board of the current player.
	 * Secondly, that create and object ChoiceCard to recover the row and the column.
	 * Finally, that return and integer array with this two information.
	 */
	
	public static int[] askUserChoice(BoardArray boards, int player) {
		
		// Clear screen
		for (int x = 0; x < 50; ++x) System.out.println(); 
		// Print the player board
		boards.displayTargetBoard(player);
		
		ChoiceCard choicecard = new ChoiceCard(scan);
		
		choicecard.scanRow();
		choicecard.scanColunm(boards.get(player).getColumn());
		
		int[] choice = {choicecard.getRow(),choicecard.getColunm()}; // Set up the player choice has an array so it facilitate the return
		return choice;
	}
	
	/*! 
	 * @brief : Acquisition control relative to the page the player is
	 */
	public static int acquisitionControl(int userChoice, int currentPage) {
		
		if (currentPage == 1) {
			
			if (userChoice == 1) {
				return 4;
			}else if (userChoice == 2) {
				return 5;
			}else if (userChoice == 3) {
				return 2;
			}else if (userChoice == 4) {
				return 3;
			}else {
				return 1;
			}
			
		}else if (currentPage == 2) {
			
			if (userChoice == 1) {
				return 1;
			}else if (userChoice == 2) {
				return 3;
			}else {
				return 2;
			}
			
		}else {
			
			if (userChoice == 1) {
				return 1;
			}else if (userChoice == 2) {
				return 2;
			}else {
				return 3;
			}
			
		}
	}
	
		
}
