package gametool;

import java.util.Scanner;

import skyjo.*;

public class EndOfTheGame {
	
	private static Scanner scan;
	
	
	/*! @brief : Check if the user that finished first has the lower point
	 */
	public static boolean checkLowest(int[] points, int nbPlayer, int player) {
		
		for (int i = 0; i < nbPlayer ; i++) { // Iterate over every player points
			if (i != player && points[i] < points[player]) { // If we are not currently looking the player that finished first point and if these point
				return false; // are inferior than the player that finished first it's false
			}
		}
		
		return true; 
	}
	
	/*! @brief : Display the victory screen
	 */
	public static void victoryScreen(PointManager points) {
		for (int i = 0; i < 50; ++i) System.out.println(); // clear screen
		points.display(); // Display every player points
		System.out.println("Player " + (points.lowestPoint()+1) + " has won !" );
		System.out.println("Do you want to play again ? (Y) Yes (N) No");
		char choice = scan.next().charAt(0);
		while (choice != 'Y' && choice != 'N') {
			System.out.println("Do you want to play again ? (Y) Yes (N) No");
			choice = scan.next().charAt(0);
		}
		
		if (choice == 'Y') {
			String[] args = {"Re","match"};
			Main.main( args );
			return;
		}
		
		return;
	}
}
