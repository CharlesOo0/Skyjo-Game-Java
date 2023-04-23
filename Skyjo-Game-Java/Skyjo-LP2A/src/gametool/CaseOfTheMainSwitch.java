package gametool;
import java.util.Scanner;

import skyjo.*;

public class CaseOfTheMainSwitch {
	
	private static Scanner scan = new Scanner(System.in);
	private static int userChoice;
	private static int currentPage;
	
	public static int case1(BoardArray boards,Discard discard, Deck deck, int indexPlayer) {
		Pages.page1(boards,discard,deck,indexPlayer); // Display the player board
		scan.nextLine();
		do {
			try {
				userChoice = scan.nextInt(); // Get the player choice
			} catch (Exception e) {
				scan.next();
				userChoice = 0;
			}
		} while (userChoice < 1 || userChoice > 4);
		currentPage = PlayMethods.acquisitionControl(userChoice, currentPage); // Verify what he has chose
		return currentPage;
	}

	public static int case2(BoardArray boards){
		Pages.page2(boards); // Display every boards
		do {
			try {
				userChoice = scan.nextInt(); // Get the player choice
			} catch (Exception e) {
				scan.next();
				userChoice = 0;
			}
		} while (userChoice < 1 || userChoice > 2);
		currentPage = PlayMethods.acquisitionControl(userChoice, currentPage); // Verify what he has chose
		return currentPage;
	}
	
	
	public static int case3(PointManager points) {
		Pages.page3(points); // Display the points of every player
		do {
			try {
				userChoice = scan.nextInt(); // Get the player choice
			} catch (Exception e) {
				scan.next();
				userChoice = 0;
			}
		} while (userChoice < 1 || userChoice > 2);
		currentPage = PlayMethods.acquisitionControl(userChoice, currentPage); // Verify what he has chose
		return currentPage;
	}
	
	public static int[] case4(BoardArray boards, int indexPlayer, int card, Discard discard) {
		char choice;
		int[] userSwitch;
		do {
			choice = '\u0000';
			for (int x = 0; x < 50; ++x) System.out.println(); // Clear screen
			boards.displayTargetBoard(indexPlayer); // Print the player board
			System.out.println("Card : " + CardElement.getUV(card));
			System.out.println("Do you want to switch the card or not ? (Y) Yes (N) No");
			try {
				choice = scan.next().charAt(0);
			} catch (Exception e) {
				System.out.println("You have to enter a char");
				scan.next();
			}
			
		}while (choice != 'Y' && choice != 'N' && choice != 'y' && choice != 'n');
		
		if (choice == 'Y' || choice == 'y') {
			userSwitch = Pages.page4(boards,indexPlayer,card); // Get the card choice of the player for the switch 
			discard.push(boards.get(indexPlayer).switchCardBoard(userSwitch[0]-1, userSwitch[1]-1, card)); // Switch the card drawn and the choice of the player
		}else {
			do { // Implement the rule where if the player don't want to switch
				// With one of his card he has to reverse one of his not revealed card
				userSwitch = PlayMethods.askUserChoice(boards,indexPlayer);
			}while (!boards.get(indexPlayer).getBoardBox(userSwitch[0]-1, userSwitch[1]-1).getHidden()); // Until he chose a card that is not reversed
			boards.get(indexPlayer).getBoardBox(userSwitch[0]-1, userSwitch[1]-1).setHidden(false); // Reverse the card
			discard.push(card); // Put the card not picked in the discard
		}
		return userSwitch;
	}
	
}
