package skyjo;

/*! @brief class that implement the element of the bidimenssionnal array from BoardSet
 */
public class BoardCard {
	private int card; // The card represented i.e. (-2,1,0,1,...) .
	private boolean hidden;  // A boolean true if the card is hidden false if not.
	
	/*---------------- Constructors ----------------*/
	BoardCard(int card, boolean hidden) {
		this.card = card;
		this.hidden = hidden;
	}
	
	/*---------------- Getters ----------------*/
	public int getCard() { // Get the card represented by the obj
		return this.card;
	}
	
	public boolean getHidden() { // Get the status of the card if its hidden or not
		return this.hidden;
	}
	
	/*---------------- Setters ----------------*/
	public void setCard(int card) { // Set the card represented by the obj
		this.card = card;
	}
	
	public void setHidden(boolean hidden) { // Set the status of the card wether it's hidden or not
		this.hidden = hidden;
	}
	
	public void setBoardCard(int card, boolean hidden) { // Set both the card represented and the status
		this.card = card;
		this.hidden = hidden;
	}
	
}
