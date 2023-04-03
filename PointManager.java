package skyjo;

import java.util.LinkedList;

/*! @brief class that implement the point managing system for the player
 */
public class PointManager extends LinkedList<Integer>{
	
	private static final long serialVersionUID = 1L;
	int nbPlayer; // Number of player
	
	/*---------------- Constructors ----------------*/	
	PointManager(int nbPlayer) {
		
		super(); // Initialise a linked list of integer
		
		if (nbPlayer < 2 || nbPlayer > 8) { // Acquisition control
			System.out.println("Error players must be between 2 and 8 !");
			this.nbPlayer = 2; // By default we put two 
		}else {
			this.nbPlayer = nbPlayer;
		}
		
		for (int i = 0; i < nbPlayer ; i++) {
			super.add(0);
		}
		
	}
	
	/*---------------- Getters ----------------*/
	public int getPoint(int index) {
		if (index > 0 || index < nbPlayer) { // Acquisition control
			return super.get(index);
		}
		return 999; // 999 is equivalent to an error in our program
	}

	/*---------------- Method ----------------*/
	
	/*!@brief We check if a player has >= 100 points
	 */
	public boolean isHundred() {
		for (int i = 0; i < nbPlayer ; i++) { // Iterate over the linked list 
			if (super.get(i) >= 100) { // If someone has reach 100 or more points
				return true; // isHundred is true
			}
		}
		return false;
	}
	
	/*!@brief The goal of this method is to display the points of every player
	 */
	public void display() {
		String output = new String();
		
		for (int i = 0; i < nbPlayer ; i++) { // Iterate over our LinkedList
			output += "Player " + (i+1)  + " : " + super.get(i) + "\n";
		}
		
		System.out.println(output);
		
	}
	
	/*! @brief This method permit to add point to a specific player
	 */
	public void addPoint(int index, Integer point) {
			
		if (point == null) {
			point = 0;
		}
		if (index < 0 || index >= nbPlayer) { // Acquisition control
			System.out.println("Erreur index out of range !");
			return;
		}
			
		super.set(index, super.get(index)+ point);
	}
	
	/*! @brief : return the index of the player with the lowest point
	 */
	public int lowestPoint() {
		int lowest = this.getPoint(0);
		int player = 0;
		for (int i = 1; i < this.nbPlayer; i++) { // Iterate over every player points
			if (this.getPoint(i) < lowest) { // Find the lowest
				lowest = this.getPoint(i); // Memorise it score
				player = i; // Memorise the player
			}
		}
		
		return player;
	}
}
