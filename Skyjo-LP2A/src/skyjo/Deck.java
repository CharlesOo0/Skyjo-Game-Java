package skyjo;

import java.util.LinkedList;
import java.util.Random;

/*!
 * @brief Class that implement the deck in the game
 * */

public class Deck extends LinkedList<CardElement> {

	private static final long serialVersionUID = 1L;
	private int deck_card; // Number of card in the deck
	private Random rand; // Pick random number
	
	/*---------------- Constructors ----------------*/
	Deck() {
		super();
		this.deck_card = 150; // There are 150 card in the game
		rand = new Random();
		
		for (int i = -2; i < 13; i++) { // Initialise a default deck
			super.add(this.createCard(i)); // Go through all the possible card in the game and increment the default CardElemet
		}								   // relative to them
	}
	
	/*---------------- Methods ----------------*/
	
	/*! @brief : this method facilitate the initialisation of the default deck
	 * by returning the default CardElement relative to a card i.e. card = -2 , CardElement = {-2,5}
	 */
	public CardElement createCard(int card) {
		CardElement obj = new CardElement(card);
		return obj;
	}
	
	/*! @brief : check if our linked list still contain copy of a precise card
	 */
	public int contain(int card) {
		
		for(int i = 0; i < super.size();  i++) { // Iterate over the element of the linked list
			if (super.get(i).getCard() == card) { // If we find the card
				return i; // then we return the index
			}
		}
		
		return -1; // else we return -1, that is equal to "card not found"
	}
	
	
	/*! @brief : toString method that return a string with the number of copy remaining of each card
	 */
	public String toString() {
		String output = new String();
		for(int i = 0; i < super.size(); i++) {
			output += " " + super.get(i).getCard() + " " + super.get(i).getCardNumber() + "\n";
		}
		return output;
	}
	
	
	/*! @brief : Function that draw randomly a card in the deck
	 */
	public int draw() {
		
		if (deck_card == 0) { // If there are no more card in the deck we return 999 wich represent an order to stop our round
			return 999;
		}
		
		int cardPicked = rand.nextInt(1,deck_card + 1); // Pick a random number between 1 and the number of card in the deck
		CardElement chosedCard;
		chosedCard = super.get(cardPicked <= super.get(0).getCardNumber() ? 0:
				cardPicked <= super.get(0).getCardNumber() + super.get(1).getCardNumber() ? 1:
				cardPicked <= super.get(0).getCardNumber() + super.get(1).getCardNumber() + super.get(2).getCardNumber() ? 2:
				cardPicked <= super.get(0).getCardNumber() + super.get(1).getCardNumber() + super.get(2).getCardNumber() + super.get(3).getCardNumber() ? 3:
				cardPicked <= super.get(0).getCardNumber() + super.get(1).getCardNumber() + super.get(2).getCardNumber() + super.get(3).getCardNumber() + super.get(4).getCardNumber() ? 4:
				cardPicked <= super.get(0).getCardNumber() + super.get(1).getCardNumber() + super.get(2).getCardNumber() + super.get(3).getCardNumber() + super.get(4).getCardNumber() + super.get(5).getCardNumber() ? 5:
				cardPicked <= super.get(0).getCardNumber() + super.get(1).getCardNumber() + super.get(2).getCardNumber() + super.get(3).getCardNumber() + super.get(4).getCardNumber() + super.get(5).getCardNumber() + super.get(6).getCardNumber() ? 6:
				cardPicked <= super.get(0).getCardNumber() + super.get(1).getCardNumber() + super.get(2).getCardNumber() + super.get(3).getCardNumber() + super.get(4).getCardNumber() + super.get(5).getCardNumber() + super.get(6).getCardNumber() + super.get(7).getCardNumber() ? 7:
				cardPicked <= super.get(0).getCardNumber() + super.get(1).getCardNumber() + super.get(2).getCardNumber() + super.get(3).getCardNumber() + super.get(4).getCardNumber() + super.get(5).getCardNumber() + super.get(6).getCardNumber() + super.get(7).getCardNumber() + super.get(8).getCardNumber() ? 8:
				cardPicked <= super.get(0).getCardNumber() + super.get(1).getCardNumber() + super.get(2).getCardNumber() + super.get(3).getCardNumber() + super.get(4).getCardNumber() + super.get(5).getCardNumber() + super.get(6).getCardNumber() + super.get(7).getCardNumber() + super.get(8).getCardNumber() + super.get(9).getCardNumber() ? 9:
				cardPicked <= super.get(0).getCardNumber() + super.get(1).getCardNumber() + super.get(2).getCardNumber() + super.get(3).getCardNumber() + super.get(4).getCardNumber() + super.get(5).getCardNumber() + super.get(6).getCardNumber() + super.get(7).getCardNumber() + super.get(8).getCardNumber() + super.get(9).getCardNumber() + super.get(10).getCardNumber() ? 10:
				cardPicked <= super.get(0).getCardNumber() + super.get(1).getCardNumber() + super.get(2).getCardNumber() + super.get(3).getCardNumber() + super.get(4).getCardNumber() + super.get(5).getCardNumber() + super.get(6).getCardNumber() + super.get(7).getCardNumber() + super.get(8).getCardNumber() + super.get(9).getCardNumber() + super.get(10).getCardNumber() + super.get(11).getCardNumber() ? 11:
				cardPicked <= super.get(0).getCardNumber() + super.get(1).getCardNumber() + super.get(2).getCardNumber() + super.get(3).getCardNumber() + super.get(4).getCardNumber() + super.get(5).getCardNumber() + super.get(6).getCardNumber() + super.get(7).getCardNumber() + super.get(8).getCardNumber() + super.get(9).getCardNumber() + super.get(10).getCardNumber() + super.get(11).getCardNumber() + super.get(12).getCardNumber() ? 12:
				cardPicked <= super.get(0).getCardNumber() + super.get(1).getCardNumber() + super.get(2).getCardNumber() + super.get(3).getCardNumber() + super.get(4).getCardNumber() + super.get(5).getCardNumber() + super.get(6).getCardNumber() + super.get(7).getCardNumber() + super.get(8).getCardNumber() + super.get(9).getCardNumber() + super.get(10).getCardNumber() + super.get(11).getCardNumber() + super.get(12).getCardNumber() + super.get(13).getCardNumber() ? 13:
				cardPicked <= super.get(0).getCardNumber() + super.get(1).getCardNumber() + super.get(2).getCardNumber() + super.get(3).getCardNumber() + super.get(4).getCardNumber() + super.get(5).getCardNumber() + super.get(6).getCardNumber() + super.get(7).getCardNumber() + super.get(8).getCardNumber() + super.get(9).getCardNumber() + super.get(10).getCardNumber() + super.get(11).getCardNumber() + super.get(12).getCardNumber() + super.get(13).getCardNumber() + super.get(14).getCardNumber() ? 14:		
				null); // Pick a random car in the deck
		
		chosedCard.lowerCard(); // Lower the number of copy of the card picked
		this.deck_card -= 1; // Lower the number of card in the deck
		
		return chosedCard.getCard(); // Return the card picked
		
	}

}
