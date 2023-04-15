package gametool;

import java.util.Scanner;

import skyjo.BoardArray;

public class PlayMethods {
	
	private static Scanner scan = new Scanner(System.in);
	
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
