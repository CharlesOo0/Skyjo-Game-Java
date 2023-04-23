package skyjo;

import java.util.Stack;

/*!
 * @brief Class that implement the discard in the game
 * 
 * */

public class Discard {
	private Stack<Integer> stack;
	
	/* Constructors */
	public Discard() {
		this.stack = new Stack<Integer>(); // Initialize our stack
	}
	
	/* Methods */
	
	/*! @brief : Return the value on top of the stack
	 *
	 * Behavior :
	 * Use the isEmpty method natively present with the type Stack if it's empty return 999, that's represent an error.
	 * Else just return the peek of the stack with the peek method natively present with the Stack.
	 */
	public int peek() {
		if(stack.isEmpty()) {
			return 999;
		}
		
		return stack.peek();
	}
	
	/*! @brief : Check if our list is empty
	 *  
	 * Behavior : 
	 * Use the native method isEmpty of Stack type and return it.
	 */
	public boolean isEmpty() {
		return this.stack.isEmpty(); // Check if stack is empty
	}
	
	
	/*!
	 * @brief : Add an element to our list
	 * 
	 * Behavior :
	 * Add a card to the discard with the method push that is native to Stack type.
	 */
	public void push(int card) {
		this.stack.push(card); // Add a card to the discard
		return;
	}
	
	
	/*! @brief : Pop the last element of our list
	 *  Only do it if the list is not empty
	 *
	 * Behavior :
	 * Check if the stack is empty if so we return an error 999.
	 * Else we pop the stack with native method of Stack.
	 */
	public int draw() {
		if (this.isEmpty()) { // If stack empty we can not pop 
			return 999; // So we return an error
		}
		
		return this.stack.pop(); // Remove the last element of the stack and return it
	}
	
	/*! @brief : A to string method, the aim is to display easily our stack
	 *
	 * Behavior :
	 * Iterate over the stack with an index from 0 to size of the stack.
	 * And increment value we get from the Stack with a get method to an output string.
	 */
	public String toString() { 
		String output = new String(); // Initialize output
		for (int i = 0; i < this.stack.size(); i++) { // Iterate over the pile
			output += " " + this.stack.get(i); // Increment our output to the output
		}
		return output; // Return all the element
	}
	
}
