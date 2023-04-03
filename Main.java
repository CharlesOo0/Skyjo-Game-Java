package skyjo;

import java.util.Scanner;

import java.io.IOException;

/*! @brief class make the game run
 */
public class Main {
	
	public static final Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	
	/*! @brief : Display the first page of the play phase (PLAYER BOARD)
	 */
	public static void page1(BoardArray boards, Discard discard, Deck deck, int player) {
		boards.displayTargetBoard(player); // Print the player board
		String output = new String();
		if (discard.peek() == 999) { // Check if there is a card in discard
			output = "no card"; // If not we put no card
		}else { // Else we put the value of the card inside the output
			output = Integer.toString(discard.peek());
		}
		System.out.println("Card on top of Discard : "+output+"\nNumber of card remaining in the deck : "+deck.getDeckCard()+"\n(1)Draw a card in the deck \n(2)Draw a card in the discard \n(3)Look every players boards \n(4)Look points");
	}
	
	/*! @brief : Display the second page of the play phase (EVERY BOARDS)
	 */
	public static void page2(BoardArray boards) {
		boards.displayBoards(); // Display every player boards
		System.out.println("(1)Look your board \n(2)Look points");
	}
	
	/*! @brief : Display the third page of the play phase (POINTS)
	 */
	public static void page3(PointManager points) {
		points.display(); // Display the points of every player
		System.out.println("(1)Look your board \n(2)Look every player boards");
	}
	
	/*! @brief : Display the fourth page of the play phase (SWITCH CARD)
	 */
	public static int[] page4(BoardArray boards, int player, int card) {
		int row, column;
		
		boards.displayTargetBoard(player); // Print the player board
		System.out.println("Here the card that you took : "+ card); // Show the card the player took
		
		System.out.println("Enter row : ");
		row = myObj.nextInt();
		while (row < 1 || row > 4) { // Acquisition control
			System.out.println("Enter row (Must be between 1 and 4) : ");
			row = myObj.nextInt();
		}
		
		System.out.println("Enter column : ");
		column = myObj.nextInt();
		while (column < 1 || column > boards.get(player).getColumn()) { // Acquisition control
			System.out.println("Enter column (Must be between 1 and "+boards.get(player).getColumn()+") : ");
			column = myObj.nextInt();
		}
		int[] choice = {row,column}; // Set up the player choice has an array so it facilitate the return
		return choice;
		
	}
	
	/*! @brief : Acquisition control relative to the page the player is
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
	
	/*! @brief : Check if the user that finished first has the lower point
	 */
	public static boolean checkLowest(int[] points, int nbPlayer, int player) {
		
		for (int i = 0; i < nbPlayer ; i++) { // Iterate over every plyer points
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
		char choice = myObj.next().charAt(0);
		while (choice != 'Y' && choice != 'N') {
			System.out.println("Do you want to play again ? (Y) Yes (N) No");
			choice = myObj.next().charAt(0);
		}
		
		if (choice == 'Y') {
			String[] args = {"Re","match"};
			main( args );
			return;
		}
		
		return;
	}
	
	/*! @brief : This is the main method it glue up every class we have made to make the game
	 */
	public static void main(String[] args) {
		
		for (int i = 0; i < 50; ++i) System.out.println(); // clear screen
		
		
		System.out.println("Do you want to play Skyjo ? (Y) Yes (N) No");
		char choice = myObj.next().charAt(0);
		while (choice != 'Y' && choice != 'N') {
			System.out.println("Only answear are Y or N ? (Y) Yes (N) No");
			choice = myObj.next().charAt(0);
		}
		
		if (choice == 'N') {
			System.out.println("Why have you launch the game then ? Come on try one game !");
			return;
		}
		
		Deck deck = new Deck(); // Initialise a new deck
		Discard discard = new Discard(); // Initialise the discard
		
		
		/*-- Getting the number of player --*/
		System.out.println("How many player ?");
		int nbPlayer = myObj.nextInt();  // Read user input
		while (nbPlayer < 2 || nbPlayer > 8) { // Acquisition control
			System.out.println("How many player ?");
			nbPlayer = myObj.nextInt();
		}
		for (int i = 0; i < 50; ++i) System.out.println();

		BoardArray boards = new BoardArray(nbPlayer, deck); // Initialise the boards of every player
		PointManager points = new PointManager(nbPlayer); // Initialise the system of point
		discard.push(discard.draw());
		
		while (!points.isHundred()) { // The game loop stop if someone has >= 100 points
			
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
					
					
					for (int x = 0; x < 50; ++x) System.out.println(); // Clear screen
					
				}
			}
				/*--- Every player reverse two card of his board ---*/
				
				/*--- Every player play turn by turn ---*/
				
				int playerFinishedFirst = 0; // Memorise wich player has revealed his board entirely first
				// This variable need to be outside and initialised in case the initialisation messed up
				// And there is a board entirely revealed at the beginning
				// Which is theorically impossible
				// However our program don't know that it is
				
			
				
			
				while (!boards.isNotHidden()) {
					
					int currentPage = 1; // Memorise the page
					int[] userSwitch; // Memorise the switch the player want to make
					int userChoice; // Variable to read the user choice
					int card; // Memorise the card
					boolean alreadyFinished = false;
					boolean userPlayed = false; // Boolean that represent if the player has play or not
					
					
					for (int indexPlayer = 0; indexPlayer < nbPlayer; ++indexPlayer) {					
						
						
						while (!userPlayed) { // this loop stop when the player has play
							
							for (int x = 0; x < 50; ++x) System.out.println(); // Clear screen
					
							
							switch (currentPage) { // A switch wherever the page the player is it display it
							case 1 :  
								page1(boards,discard,deck,indexPlayer); // Display the player board
								myObj.nextLine();
								userChoice = myObj.nextInt(); // Get the player choice
								currentPage = acquisitionControl(userChoice, currentPage); // Verify what he has chose
								break;
							case 2 :
								page2(boards); // Display every boards
								userChoice = myObj.nextInt(); // Get the player choice
								currentPage = acquisitionControl(userChoice, currentPage); // Verify what he has chose
								break;
							case 3 : 
								page3(points); // Display the points of every player
								userChoice = myObj.nextInt(); // Get the player choice
								currentPage = acquisitionControl(userChoice, currentPage); // Verify what he has chose
								break;
							case 4 : 
								if (deck.isEmpty()) { // If the deck is empty
									System.out.println("The deck is empty !"); // User can't draw a card in the deck
									currentPage = 1; // Put him back in the page 1
									break; // Unlike the discard this control is necessary the deck can be empty even if it's a rare evenement
								}
								card = deck.draw(); // Draw a card
								userSwitch = page4(boards,indexPlayer,card); // Get the card choice of the player for the switch 
								discard.push(boards.get(indexPlayer).switchCardBoard(userSwitch[0]-1, userSwitch[1]-1, card)); // Switch the card drawn and the choice of the player
								
								// Specific Rules
								if (boards.get(indexPlayer).checkColumn(userSwitch[1]-1)) { // Implemant the rule where if all the card of a column are the same
									boards.get(indexPlayer).eraseColumn(userSwitch[1]-1); // We erase the column
									return;
								}
								
								if (!alreadyFinished && boards.get(indexPlayer).boardNotHidden()) { // If no one has alreay reveal his board entirely and the player is the first
									alreadyFinished = true; // Then someone has finish now
									playerFinishedFirst = indexPlayer; // And we memorise that he was the first
								}
								// Specific Rules
								
								userPlayed = true; // Now that user has play we can stop the loop
								break;
							case 5 :
								if (discard.isEmpty()) { // If the discard is empty
									System.out.println("The discard is empty !"); // User can't draw a card in the discard
									currentPage = 1; // Put him back in the page 1
									break; // Discard can not be empty but for development purpose we chose to put this control here
								}
								card = discard.draw(); // Else draw the top card of the discard
								userSwitch = page4(boards,indexPlayer,card); // Get the card choice of the player for the switch 
								
								// Specific Rules
								if (boards.get(indexPlayer).checkColumn(userSwitch[1]-1)) { // Implemant the rule where if all the card of a column are the same
									boards.get(indexPlayer).eraseColumn(userSwitch[1]-1); // We erase the column
								}
								
								if (!alreadyFinished && boards.get(indexPlayer).boardNotHidden()) { // If no one has alreay reveal his board entirely and the player is the first
									alreadyFinished = true; // Then someone has finish now
									playerFinishedFirst = indexPlayer; // And we memorise that he was the first
								}
								// Specific Rules
								
								discard.push(boards.get(indexPlayer).switchCardBoard(userSwitch[0]-1, userSwitch[1]-1, card));
								userPlayed = true;

							} // SWITCH
							
						} // WHILE
						
						// Set up the default value again so the next player can play
						currentPage = 1;
						userPlayed = false;
						

					} // FOR
					
				} // WHILE
				/*--- Every player play turn by turn ---*/
				
				/*--- When every player has play until one of the boards is completely revealed we count the point ---*/
				
				int[] pointsArray = new int[nbPlayer];
				for (int j = 0; j < nbPlayer; j++) {
					pointsArray[j] = boards.get(j).calculatePoint();
				}
				
				if(!checkLowest(pointsArray, nbPlayer, playerFinishedFirst)) { // Implement the rule where if the player that finished first hasn't the lowest point
					pointsArray[playerFinishedFirst] *= 2; // Then we multiply his points by 2
				}
				
				for (int k = 0; k < nbPlayer; k++) { // Increment the points made to the point manager
					points.addPoint(k, pointsArray[k]);
				}
				
				/*--- When every player has play until the of the boards is completely revealed we count the point ---*/
				
			
						
			victoryScreen(points); // Display victory screen
			
		}
		
		
		
		myObj.close(); // Close the scanner
	}
	
}
