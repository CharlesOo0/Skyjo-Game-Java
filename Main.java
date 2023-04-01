package skyjo;

import java.util.Scanner;

/*! @brief class make the game run
 */
public class Main {
	
	public static void page1(BoardArray boards, Discard discard, int player) {
		boards.displayTargetBoard(player); // Print the player board
		String output = new String();
		if(discard.peek() == 999) { // Check if there is a card in discard
			output = "no card"; // If not we put no card
		}else { // Else we put the value of the card inside the output
			output = Integer.toString(discard.peek());
		}
		System.out.println("Card on top of Discard : "+output+"\n(1)Draw a card in the deck \n(2)Draw a card in the discard \n(3)Look every players boards \n(4)Look points");
	}
	
	
	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		Deck deck = new Deck();
		Discard discard = new Discard();
		
		/*-- Getting the number of player --*/
		System.out.println("How many player ?");
		int nbPlayer = myObj.nextInt();  // Read user input
		while(nbPlayer < 1 || nbPlayer > 8) { // Acquisition control
			System.out.println("How many player ?");
			nbPlayer = myObj.nextInt();
		}
		for (int i = 0; i < 50; ++i) System.out.println();

		BoardArray boards = new BoardArray(nbPlayer, deck);
		PointManager points = new PointManager(nbPlayer);
		
		while(!points.isHundred()) { // The game loop stop if someone has reach 100 points
			
			/*--- Every player reverse two card of his board ---*/
			int row;
			int column;
			for (int i = 0; i < nbPlayer; i++) {
				
				for (int k = 0 ; k < 2 ; k++) {
					boards.displayTargetBoard(i); // Print the player board
					
					// Scan row
					System.out.println("Reverse card "+(k+1)+" :\nEnter row :");
					row = myObj.nextInt();
					while (row < 1 || row > 4) { // Acquisition control
						System.out.println("Enter row (it must be between 1 and 4) :");
						row = myObj.nextInt();
					}
					
					// Scan column
					System.out.println("Enter column :");
					column = myObj.nextInt();
					while (column < 1 || column > boards.get(i).getColumn() + 1 ) { // Acquisition control
						System.out.println("Enter column (it must be between 1 and "+boards.get(i).getColumn()+") :");
						column = myObj.nextInt();
					}
					
					
					if (!boards.get(i).getBoard()[row-1][column-1].getHidden()) { // Check if card is already reversed
						k -= 1; // If yes we reask the user
						System.out.println("Error card is already reversed");
					}else {
						boards.cardReverse(row-1, column-1, i); // reverse the card
					}
					
					for (int j = 0; j < 50; ++j) System.out.println(); // clear screen
					
				}
				i = nbPlayer;
				
			}
			/*--- Every player reverse two card of his board ---*/
			
			
			/*--- Every player play turn by turn ---*/
			while(boards.isNotHidden()) {
				for (int i = 0; i < nbPlayer; i++) {
					
					page1(boards,discard,i);
					
					
					i = nbPlayer;
				}
			}
			
			points.set(0, 1500); // Just to not repeat infinitly
		}
		
		myObj.close();
	}
	
}
