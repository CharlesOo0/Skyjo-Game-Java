package skyjo;

/*! @brief class that implement the element of the bidimenssionnal array from BoardSet
 */
public class BoardCard {
	private int card;
	private boolean hidden;
	
	/*---------------- Constructors ----------------*/
	BoardCard(int card, boolean hidden) {
		this.card = card;
		this.hidden = hidden;
	}
	
	/*---------------- Getters ----------------*/
	public int getCard() {
		return this.card;
	}
	
	public boolean getHidden() {
		return this.hidden;
	}
	
	/*---------------- Setters ----------------*/
	public void setCard(int card) {
		this.card = card;
	}
	
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	
	public void setBoardCard(int card, boolean hidden) {
		this.card = card;
		this.hidden = hidden;
	}
	
}
