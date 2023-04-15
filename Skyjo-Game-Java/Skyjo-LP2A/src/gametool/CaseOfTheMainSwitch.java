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
	
}
