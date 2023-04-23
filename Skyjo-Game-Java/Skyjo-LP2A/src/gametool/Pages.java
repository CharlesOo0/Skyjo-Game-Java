package gametool;

import skyjo.BoardArray;
import skyjo.CardElement;
import skyjo.Deck;
import skyjo.Discard;
import skyjo.PointManager;
import java.util.Scanner;


/*! 
 * @brief : all the different display pages necessary to play correctly */
public class Pages {
	
	private static Scanner scan = new Scanner(System.in);

	
	/*! @brief : Display the first page of the play phase (PLAYER BOARD)
	 *  parm : an object BoardArray named boards corresponding of the boards of all the players 
	 *  	   an object Discard named discard corresponding to the current discard 
	 *   	   an object Deck named deck corresponding to the current deck
	 *         an integer int a primitive type, named player, corresponding to the number of the current player
	 */
	public static void page1(BoardArray boards, Discard discard, Deck deck, int player) {
		boards.displayTargetBoard(player); // Print the player board
		String output = new String();
		if (discard.peek() == 999) { // Check if there is a card in discard
			output = "no card"; // If not we put no card
		}else { // Else we put the value of the card inside the output
			output = Integer.toString(discard.peek());
		}
		System.out.println("Card on top of Discard : " + output ); 
		System.out.println("Number of card remaining in the deck : " + deck.getDeckCard());
		System.out.println("(1)Draw a card in the deck");
		System.out.println("(2)Draw a card in the discard");
		System.out.println("(3)Look every players boards");
		System.out.println("(4)Look points");
	}
	
	/*! @brief : Display the second page of the play phase (EVERY BOARDS)
	 *  parm : an object BoardArray named boards corresponding of the boards of all the players 
	 */
	public static void page2(BoardArray boards) {
		boards.displayBoards(); // Display every player boards
		System.out.println("(1)Look your board");
		System.out.println("(2)Look points");
	}
	
	/*! @brief : Display the third page of the play phase (POINTS)
	 * parm : an object PointManager named points corresponding of the points of all the players 
	 */
	public static void page3(PointManager points) {
		points.display(); // Display the points of every player
		System.out.println("(1)Look your board ");
		System.out.println("(2)Look every player boards");
	}
	
	/*! @brief : Display the fourth page of the play phase (SWITCH CARD)
	 * parm : an object BoardArray named boards corresponding of the boards of all the players 
	 * 		  an integer int a primitive type, named player, corresponding to the number of the current player
	 * 		  an integer int a primitive type, named card, corresponding to the card that the player took
	 */
	public static int[] page4(BoardArray boards, int player, int card) {
		
		boards.displayTargetBoard(player); // Print the player board
		System.out.println("Here the card that you took : "+ CardElement.getUV(card));   // Show the card the player took
		
		// The player choice a card 
		ChoiceCard choicecard = new ChoiceCard(scan);
		
		choicecard.scanRow();
		choicecard.scanColunm(boards.get(player).getColumn());
		
		int[] choice = {choicecard.getRow(),choicecard.getColunm()};   					// Set up the player choice has an array so it facilitate the return
		return choice;
		
	}
}
