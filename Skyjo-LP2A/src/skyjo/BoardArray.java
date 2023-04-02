package skyjo;

import java.util.LinkedList;

/*! @brief class that boards of all the players
 */
public class BoardArray extends LinkedList<BoardSet> {
	
	private static final long serialVersionUID = 1L;
	private int nbPlayer; // Number of player
	
	/*---------------- Constructors ----------------*/
	BoardArray(int nbPlayer, Deck deck) {
		
		super(); // Initialise a linked list
		
		if (nbPlayer < 2 || nbPlayer > 8) { // Acquisition control
			System.out.println("Error players must be between 2 and 8 !");
			this.nbPlayer = 2; // By default we put two 
		}else {
			this.nbPlayer = nbPlayer;
		}
		
		BoardSet boards; // Initialise a board set
		for(int i = 0; i < this.nbPlayer; i++) {
			boards = new BoardSet(deck); // construct our BoardSet
			super.add(boards); // Add it to the linked list
		}
		
	}
	
	/*---------------- Methods ----------------*/
	
	/*! @brief : Reverse a card from a specific boardSet
	 */
	public boolean cardReverse(int indexRow, int indexColumn, int player) {
		if (indexColumn >= super.get(player).getColumn() || indexColumn < 0 || indexRow >= 4 || indexRow < 0) {
			return false;
		}
		
		super.get(player).getBoard()[indexRow][indexColumn].setHidden(false);
		
		return true;

	}

	
	/*! @brief : Check if one of the boardSet got all his card reversed
	 */
	public boolean isNotHidden() {
		for (int i = 0; i < nbPlayer ; i++) { // Iterate over the linked list of boards set
			if (super.get(i).boardNotHidden()) { // Check if the boardSet's card are all reversed
				return true; // If yes return true
			}
		}
		return false;
	}
	/*! @brief : The goal of this method is to print a specific board
	 */
	public void displayTargetBoard(int index) {
		if ( index < 0 || index >= 8) { // Acquisition control
			System.out.println("Error index out of range");
			return;
		}
		System.out.println("Player "+ (index+1) + " :" );
		super.get(index).displayBoardSet(); // Print the BoardSet
	}
	
	/*! @brief : The aim of this method is to display the board of all the player present
	 * */
	public void displayBoards() {
		for(int i = 0; i < nbPlayer; i++) { // Iterate over the BoardSet LinkedList
			System.out.println("Player " + (i+1) + " board :");
			super.get(i).displayBoardSet(); // Print the BoardSet
			System.out.println("\n");
		}
	}
	
}
