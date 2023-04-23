package GraphicPart;
import skyjo.*;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EndScreen{
	private JLabel label;
	private JLabel pointLabel;
	private JButton buttonYes;
    private JButton buttonNo;

    public EndScreen(PointManager point) {
        JFrame frame = new JFrame("Skyjo - End"); // Create an object JFrame to create the frame 
        

        pointLabel = new JLabel(point.diplayGraphic()); // create an object pointLabel which will allow 
        												// to display the leaderboard at the end of the game 

        label = new JLabel("Do you want to replay "); // create an object label which allow to display the question ask to players
        
        // Define the properties of the yes button
        buttonYes = new JButton("Yes"); // Create an object corresponding to the button
        buttonYes.setBounds(50,50, 150,20); // Define the dimension and the position of the button
        buttonYes.addActionListener(new ActionListener(){ // Define an action is the button is clicked
        	public void actionPerformed(ActionEvent e) {
        		frame.dispose(); // close current Window
	            StartWindow game = new StartWindow();// Open the window to restart 
        	}
        } );
        
        // Define the properties of the no button
        buttonNo = new JButton("No"); // Create an object corresponding to the button
        buttonNo.setBounds(50,50, 300,20);
        buttonYes.addActionListener(new ActionListener(){ // Define an action is the button is clicked 
        	public void actionPerformed(ActionEvent e) {
        		frame.dispose(); // close current Window
        	}
        } );
        
        // Add all the different object to the frame 
        frame.add(pointLabel);
        frame.add(label);
        frame.add(buttonYes);
        frame.add(buttonNo);

        frame.setSize(400,400); // Set the size 
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
