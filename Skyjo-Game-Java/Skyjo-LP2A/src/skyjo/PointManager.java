package skyjo;

import java.util.LinkedList;

/*! @brief class that implement the point managing system for the player
 */
public class PointManager extends LinkedList<Integer>{
	
	private static final long serialVersionUID = 1L;
	int nbPlayer; // Number of player
	
	/*---------------- Constructors ----------------*/	
	public PointManager(int nbPlayer) {
		
		super(); // Initialize a linked list of integer
		
		if (nbPlayer < 2 || nbPlayer > 8) { // Acquisition control
			System.out.println("Error players must be between 2 and 8 !");
			this.nbPlayer = 2; // By default we put two 
		}else {
			this.nbPlayer = nbPlayer; // If the argument pass the test then set it
		}
		
		for (int i = 0; i < nbPlayer ; i++) { // Set the default value of point of every player
			super.add(0);
		}
		
	}
	
	/*---------------- Getters ----------------*/
	/*! @brief : Get the points of a specific player
	 *  @param index int that represent the player choosed
	 *
	 * Behavior :
	 * Check if the argument is not out of range if not return the point.
	 * With the get method of the LinkedList type.
	 * Else return 999 as an error.
	 */
	public int getPoint(int index) {
		if (index > 0 || index < nbPlayer) { // Acquisition control
			return super.get(index);
		}
		return 999; // 999 is equivalent to an error in our program
	}

	/*---------------- Method ----------------*/
	
	/*! @brief : We check if a player has >= 100 points
	 * 
	 * Behavior :
	 * Iterate over every players box. If we encounteur someone that
	 * has >= 100 points we return true. Else we return false.
	 */
	public boolean isHundred() {
		for (int i = 0; i < nbPlayer ; i++) { // Iterate over the linked list 
			if (super.get(i) >= 100) { // If someone has reach 100 or more points
				return true; // isHundred is true
			}
		}
		return false;
	}
	
	/*! @brief : The goal of this method is to display the points of every player
	 * 
	 * Behavior :
	 * Esthetic display of every player points we iterate over the array, that
	 * represent players and print there points plus the it is associated to.
	 */
	public void display() {
		String output = new String();
		
		for (int i = 0; i < nbPlayer ; i++) { // Iterate over our LinkedList
			output += "Player " + (i+1)  + " : " + super.get(i) + "\n";
		}
		
		System.out.println(output);
		
	}
	
	public String diplayGraphic() {
		String output = new String();
		
		for (int i = 0; i < nbPlayer ; i++) { // Iterate over our LinkedList
			output += "Player " + (i+1)  + " : " + super.get(i) + "\n";
		}
		return output;
	}
	
	/*! @brief : This method permit to add point to a specific player
	 *  @param index int that represent the player targeted by the method
	 *  @param point integer that represent the point we want to add to him
	 *
	 * Behavior :
	 * We have chose to put integer type to point to manage in case it's NULL.
	 * First we check if the point we want to add is NULL if it is we had 0.
	 * Then we check if the index picked is in range if not we print and error.
	 * And end the method. If we pass then we just add the point to the specified player.
	 */
	public void addPoint(int index, Integer point) {
			
		if (point == null) {
			point = 0;
		}
		if (index < 0 || index >= nbPlayer) { // Acquisition control
			System.out.println("Erreur index out of range !");
			return;
		}
			
		super.set(index, super.get(index) + point);
	}
	
	/*! @brief : return the index of the player with the lowest point
	 *
	 * Behavior :
	 * We memorise the points of the first player. Then we iterate over
	 * the other player point, if we find a player that has more least point we change
	 * change the lowest player index. Then we return this index.
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
