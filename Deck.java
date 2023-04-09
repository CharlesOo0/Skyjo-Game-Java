package skyjo;

import java.util.Stack;

/*!
 * @brief Class that implement the discard in the game
 * 
 * */

public class Discard {
	private Stack<Integer> stack;
	
	/* Constructors */
	Discard() {
		this.stack = new Stack<Integer>(); // Initialise our stack
	}
	
	/* Methods */
	
	/*!
	 * @brief : Return the value on top of the stack
	 * */
	public int peek() {
		if(stack.isEmpty()) {
			return 999;
		}
		
		return stack.peek();
	}
	
	/*!
	 * @brief : Check if our list is empty
	 * */
	public boolean isEmpty() {
		return this.stack.isEmpty(); // Check if stack is empty
	}
	
	
	/*!
	 * @brief : Add an element to our list
	 * */
	public void push(int card) {
		this.stack.push(card); // Add a card to the discard
		return;
	}
	
	
	/*!
	 * @brief : Pop the last element of our list
	 * Only do it if the list is not empty
	 * */
	public int draw() {
		if (this.isEmpty()) { // If stack empty we can not pop 
			return -1; // So we return an error
		}
		
		return this.stack.pop(); // Remove the last element of the stack and return it
	}
	
	/*!
	 * @brief : A to string method
	 * The aim is to display easily our stack
	 * */
	public String toString() { 
		String output = new String(); // Initalise output
		for (int i = 0; i < this.stack.size(); i++) { // Iterate over the pile
			output += " " + this.stack.get(i); // Increment our output to the output
		}
		return output; // Return all the element
	}
	
}
