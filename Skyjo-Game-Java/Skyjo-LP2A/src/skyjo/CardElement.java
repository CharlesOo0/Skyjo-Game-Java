package skyjo;

import java.util.Locale;
import java.util.ResourceBundle;

/*!
 * @brief Class that implement the Card element for the deck's LinkedList
 * */

public class CardElement {
	
	private int card;  // Represent the card  i.e. {-2,-1,0,...,12}
	private int card_number; // The number of copy of the card
	
	/*---------------- Constructors ----------------*/
	CardElement() { // By default card element would be set to represent the card "-2"
		this.card = -2;
		this.card_number = 5;
	}
	
	CardElement(int card) {
		
		this.card = card;
		
		if (card == -2) { // If its a -2 there are 5 copy of this card in the deck by default
			this.card_number = 5; 
		}else if (card == 0) { // If its a 0 there are 15 copy of this card in the deck by default
			this.card_number = 15;
		}else { // If its any other card there are 10 copy of this card in the deck by default
			this.card_number = 10;
		}
		
	}

	CardElement(int card, int card_number) {
		this.card = card;
		this.card_number = card_number;
	}
	
	/*---------------- Getters ----------------*/
	public int getCard() {
		return this.card;
	}
	public int getCardNumber() {
		return this.card_number;
	}

	
	/* Methods */
	
	/*!
	 * @brief : Reduce the number of copy
	 * */
	public int lowerCard() {
		if (this.card_number == 0) {
			return -1; // if there no more copy of the card in the deck we send a message to the deck so it delete the element
		}
		
		this.card_number -= 1;
		
		return 0;
	}
	
	public static String getUV(int cardValue) {
		Locale locale = new Locale("");		
		ResourceBundle testProp = ResourceBundle.getBundle("uv", locale);
		return testProp.getString("UV" + cardValue);
	}
	
	
}
