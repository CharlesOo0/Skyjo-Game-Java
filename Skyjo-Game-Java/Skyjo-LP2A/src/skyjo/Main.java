package skyjo;

import java.util.Scanner;
import gametool.*;

/*!
 * @brief : class make the game run
 */
public class Main {
	
	public static final Scanner scan = new Scanner(System.in);  // Create a Scanner object to read the inputs of the users
	
	
	/*! @brief : This is the main method it glue up every class we have made to make the game
	 */
	public static void main(String[] args) {
		
		// Start the game 
		StartGame startGame = new StartGame(scan); 
		startGame.lauchGame(); // Ask to the user, if he want to play
		
		// Check if the players want play
		if (!startGame.hasSayYes()) { // If he don't want to play the game close itself
			System.out.println("Why have you launch the game then ? Come on try one game !");
			return;
		}
		
		
		// Initialize a new deck
		Deck deck = new Deck(); 
		
		// Initialize the discard
		Discard discard = new Discard(); 
		
		
		// Ask the number of player 
		int nbPlayer = StartGame.askNumberOfPlayers();
		
		// Clear the console
		for (int i = 0; i < 50; ++i) System.out.println();

		// Initialize the boards of every player
		BoardArray boards = new BoardArray(nbPlayer, deck); 
		// Initialize the system of point
		PointManager points = new PointManager(nbPlayer); 
		discard.push(discard.draw());
		
		PlayMethods.firstChoiceOfEachPlayer(boards, nbPlayer);
		
		
		// Game loop
		while (!points.isHundred()) { // The game loop stop if someone has >= 100 points
			
				/*--- Every player reverse two card of his board ---*/
				
				/*--- Every player play turn by turn ---*/
				
				int playerFinishedFirst = 0; // Memorize which player has revealed his board entirely first
				// This variable need to be outside and initialized in case the initialization messed up
				// And there is a board entirely revealed at the beginning
				// Which is theoretically impossible
				// However our program don't know that it is
				
				
				while (!boards.isNotHidden()) {
					
					int currentPage = 1; // Memorize the page
					int[] userSwitch; // Memorize the switch the player want to make
					int card; // Memorize the card
					boolean alreadyFinished = false;
					boolean userPlayed = false; // Boolean that represent if the player has play or not
					
					
					for (int indexPlayer = 0; indexPlayer < nbPlayer; ++indexPlayer) {					
						
						
						while (!userPlayed) { // this loop stop when the player has play
							
							for (int x = 0; x < 50; ++x) System.out.println(); // Clear screen
					
							
							switch (currentPage) { // A switch wherever the page the player is it display it
							case 1 :  
								currentPage = CaseOfTheMainSwitch.case1(boards, discard, deck, indexPlayer);
								break;
							case 2 :
								currentPage = CaseOfTheMainSwitch.case2(boards);
								break;
							case 3 : 
								currentPage = CaseOfTheMainSwitch.case3(points);
								break;
							case 4 : 
								if (deck.isEmpty()) { // If the deck is empty
									System.out.println("The deck is empty !"); // User can't draw a card in the deck
									currentPage = 1; // Put him back in the page 1
									break; // Unlike the discard this control is necessary the deck can be empty even if it's a rare evenement
								}
								card = deck.draw(); // Draw a card
								
								userSwitch = CaseOfTheMainSwitch.case4(boards, indexPlayer, card, discard);
								
								
								// Specific Rules
								if (boards.get(indexPlayer).checkColumn(userSwitch[1]-1)) { // Implement the rule where if all the card of a column are the same
									boards.get(indexPlayer).eraseColumn(userSwitch[1]-1); // We erase the column
									return;
								}
								
								if (!alreadyFinished && boards.get(indexPlayer).boardNotHidden()) { // If no one has already reveal his board entirely and the player is the first
									alreadyFinished = true; // Then someone has finish now
									playerFinishedFirst = indexPlayer; // And we Memorize that he was the first
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
								userSwitch = Pages.page4(boards,indexPlayer,card); // Get the card choice of the player for the switch 
								
								// Specific Rules
								if (boards.get(indexPlayer).checkColumn(userSwitch[1]-1)) { // Implement the rule where if all the card of a column are the same
									boards.get(indexPlayer).eraseColumn(userSwitch[1]-1); // We erase the column
								}
								
								if (!alreadyFinished && boards.get(indexPlayer).boardNotHidden()) { // If no one has already reveal his board entirely and the player is the first
									alreadyFinished = true; // Then someone has finish now
									playerFinishedFirst = indexPlayer; // And we memorize that he was the first
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
				
				if(!EndOfTheGame.checkLowest(pointsArray, nbPlayer, playerFinishedFirst)) { // Implement the rule where if the player that finished first hasn't the lowest point
					pointsArray[playerFinishedFirst] *= 2; // Then we multiply his points by 2
				}
				
				for (int k = 0; k < nbPlayer; k++) { // Increment the points made to the point manager
					points.addPoint(k, pointsArray[k]);
				}
				
				/*--- When every player has play until the of the boards is completely revealed we count the point ---*/
				
			
						
			EndOfTheGame.victoryScreen(points); // Display victory screen
			
		}
		
		
		
		
		scan.close(); // Close the scanner
	}
	
}
