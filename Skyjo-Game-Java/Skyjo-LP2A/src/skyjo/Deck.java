package skyjo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Deck {
	private Stack<Integer> stack; // The stack of card
	
	/* Constructors */
	Deck() {
		this.stack = new Stack<Integer>();
        List<Integer> list = Arrays.asList(-2,-2,-2,-2,-2,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3,3,3,4,4,4,4,4,4,4,4,4,4,5,5,5,5,5,5,5,5,5,5,6,6,6,6,6,6,6,6,6,6,7,7,7,7,7,7,7,7,7,7,8,8,8,8,8,8,8,8,8,8,9,9,9,9,9,9,9,9,9,9,10,10,10,10,10,10,10,10,10,10,11,11,11,11,11,11,11,11,11,11,12,12,12,12,12,12,12,12,12,12);
        this.stack.addAll(list); // Initialize a default deck  that is not shuffled
        Collections.shuffle(stack);
	}
	
	/* Setters */
	
	/*! @brief : Set an argument stack as our new deck
	 */
	public void setStack(Stack<Integer> stack) {
		this.stack = stack;
	}
	
	/* Getters */
	
	/*! @brief : Return the number of card in the deck
	 * 
	 *  Behavior :
	 *  Use the size method from Stack type.
	 */
	public int getDeckCard() {
		return stack.size();
	}
	
	/* Method */
	
	/*! @brief : Check if the stack is empty
	 * 
	 *  Behavior :
	 *  Use the isEmpty method from Stack type.
	 */
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	/*! @brief : Draw a card from the deck
	 * 
	 *  Behavior :
	 *  First check if the deck is empty if so we return 999 as an error.
	 *  If it's not we use pop method from Stack type on the deck.
	 */
	public int draw() {
		if(stack.isEmpty()) { // If the deck is empty
			return 999; // We return 999 as an error
		}
		
		return stack.pop(); // Use pop method to take the card on top of the deck
	}
	
	/*! @brief : ToString method return our stack as a String
	 */
	public String toString() {
		return "" + this.stack;
	}
	
}
