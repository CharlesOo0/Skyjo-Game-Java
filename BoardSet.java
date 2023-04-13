package skyjo;

/*! @brief class that implement the board of a player
 */
public class BoardSet {
	private BoardCard[][] board;
	private int columnSize;
	private int rowSize;

	/*---------------- Constructors ----------------*/
	BoardSet(Deck deck) {
		
		this.columnSize = 4; // Default length of a board set
		this.rowSize = 4;    //
		
		board = new BoardCard[rowSize][columnSize];
		for (int i = 0; i < rowSize ; i++) { // Iterate over every box of the array and increment a card from the deck
			for (int j = 0; j < columnSize ; j++) { // to each box
				board[i][j] = new BoardCard(deck.draw(),true);
			}
		}
		
	}
	
	/*---------------- Getters ----------------*/ 

	public BoardCard[][] getBoard() { // Get the BoardCard two dimensionnal array that represent the board of a player
		return this.board;
	}
	
	public BoardCard getBoardBox(int i, int j) { // Get a BoardCard in a specific box of the board
		return this.board[i][j];
	}
	
	public int getColumn() { // Get the size of the column
		return this.columnSize;
	}
	
	/*---------------- Setters ----------------*/
	
	/*! @brief Set the status of a specific BoardCard in the board
	 *  @param hidden This will be the new status of the card
	 *  @param indexRow This represent the target row of the box in the board
	 *  @param indexColumn This represent the target column of the box in the board
	 *
	 * Behavior :
	 * First Check if the box target entered is in range, if it's not print index out of range.
	 * Then simply change the status of the box with setHidden() method from BoardCard.
	 */
	public void setBoxHidden(boolean hidden, int indexRow, int indexColumn) { 
		if (indexRow >= rowSize || indexRow < 0 || indexColumn >= rowSize || indexColumn < 0) { // Acquisition control
			System.out.println("Error index out of range !");
			return;
		}
		
		board[indexRow][indexColumn].setHidden(hidden); // Set the new status of the box
	}
	
	/*---------------- Methods ----------------*/
	
	/*!brief : The aim of this fonction is to erase a precise column of a board
	 * it will be usefull to implemant an important rule of the skyjo
	 */
	public int eraseColumn(int indexColumn) {
		
		if (indexColumn >= columnSize || indexColumn < 0) { // Acquistion control
			System.out.println("Error index out of range !");
			return 999; // Here we return 999 it's équivalent to an error can't use -1 because its a card
		} // This control is useless because our program manage everything so this error can't happen
		// but it stay usefull for the developpement
		
		BoardCard[][] newBoard = new BoardCard[rowSize][columnSize - 1]; // Creating the new board that will one column lower than the oldest
		int columnIndex; // Initialising an index so we know to wich column of the new set we apply our value
		int cardTmp = board[0][indexColumn].getCard(); // We memorise one of the card of the column
		
		for (int i = 0; i < rowSize; i++) { // Iterate over every line of the board
			columnIndex = 0;
			for (int j = 0; j < columnSize; j++) { // Iterate over every column of the board
				if (j != indexColumn) { // If the column we are selecting is different than the one we want to delete
					newBoard[i][columnIndex] = board[i][j]; // then we copy the value of the oldest board
					columnIndex += 1;
				}
			}
		}
		this.columnSize -= 1; // Don't forget to reduce the size of our board
		this.board = newBoard; // The new board is the board of the BoardSet
		
		return cardTmp; // We return the card we memorised so it facilitate the add to the discard
		// Because we only remove column if the three card of the column are the same
		
	}
	
	/*! @brief : The aim of this method is to tell us if a particular column of the board
	 * contain only the same card
	 */
	public boolean checkColumn(int indexColumn) {
		
		if (indexColumn >= columnSize || indexColumn < 0) { // Acquistion control
			System.out.println("Error index out of range !");
			return false;
		} // This control is useless because our program manage everything so this error can't happen
		// but it stay usefull for the developpement
		if( board[0][indexColumn].getHidden() ) { // If the first card hisn't revealed we return false
			return false;
		}
		int cardTmp = board[0][indexColumn].getCard(); // We memorise the first card of the column choiced
		for (int i = 1; i < rowSize; i++) { // We iterate over the column choiced
			if ( cardTmp != board[i][indexColumn].getCard() || board[i][indexColumn].getHidden()) { // If we encounter a different card than the first one or a not reavealed card
				return false; // that means column isn't the same so false
			}
		}
		
		return true;
	}
	
	/*! @brief : The method return the number of point a board represent
	 */
	public int calculatePoint() {
		
		int output = 0; // We initialise our output
		for (int i = 0; i < rowSize; i++) { // Iterate over every line of the board
			for (int j = 0; j < columnSize; j++) { // Iterate over every column of the board
				output += board[i][j].getCard(); // We increment every box of our board into the output
			}
		}
		return output; // We return the output
	}
	
	/*! @brief : Check if every box of a boardSet are hidden or not
	 */
	public boolean boardNotHidden() {
		for (int i = 0; i < rowSize; i++) { // Iterate over every line of the board
			for (int j = 0; j < columnSize; j++) { // Iterate over every column of the board
				if(board[i][j].getHidden()) { // Check if the card of each box is hidden or not
					return false; // If one them is hidden that mean that all the card aren't reversed 
				}
			}
		}
		return true;
	}
	
	/*! @brief : This fonction implement the card switching between deck/discard and player board
	 */
	public int switchCardBoard(int indexRow, int indexColumn, int card) {
		if (indexColumn >= columnSize || indexColumn < 0) { // Acquistion control
			System.out.println("Error index out of range !");
			return 999; // Here 999 is considered as an error
		} // This control is useless because our program manage everything so this error can't happen
		// but it stay usefull for the developpement
		
		int cardTmp = board[indexRow][indexColumn].getCard(); // Memorise the card of the box
		board[indexRow][indexColumn].setCard(card); // Put in the box the card
		if(board[indexRow][indexColumn].getHidden()) { // If the card is hidden 
			board[indexRow][indexColumn].setHidden(false); // Then we set the card as not hidden
		}
		return cardTmp; // Return the memorised card
	}
	
	/*! @brief : Check if BoardSet is empty
	 */
	public boolean isEmpty() {
		if (columnSize == 0) { // If column size equal 0 that means there are no more column so its empty
			return true;
		}
		
		return false;
	}
	
	/*! @brief : display the board set in front of the player
	 */
	public void displayBoardSet() {
		String output; // String where we can increment our card
		
		
		for (int i = 0; i < rowSize; i++) { // Iterate over the line of our bidimensionnal array
			
			/*if (i != 0) { // Esthetic
				output = new String();
				for (int k = 0; k < columnSize; k++) {
					if ( k  != columnSize-1) {
						output += " / /";
					}else {
						output += " /";
					}
				}
				System.out.println(output);
			}*/
			
			output = new String(); // Reinitialise each line the string
			for (int j = 0; j < columnSize; j++) { // Iterate over the column of our bidimensionnal array
				
				if(this.board[i][j].getHidden()) { // If the card is hidden we print an "x"
					output += " x";
				}else { // Else we print the card
					output += " " + this.board[i][j].getCard();
				}
				
				if (j != columnSize - 1) { // Esthetic
					output += " /";
				}
				
			}
			
			System.out.println(output); // We print the column
		
		}
	}
	
}

