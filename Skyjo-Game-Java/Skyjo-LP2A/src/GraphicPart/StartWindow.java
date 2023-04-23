package GraphicPart;

import javax.swing.*;

import skyjo.BoardArray;
import skyjo.Deck;
import skyjo.Discard;
import skyjo.PointManager;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Menu;
import java.awt.event.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartWindow extends JFrame implements ActionListener {
    private JLabel label;
    private JTextField textField;
    private JButton button;

    public StartWindow() {
        super("Skyjo - Home");

        label = new JLabel("How many are you : ");
        textField = new JTextField(6);
        button = new JButton("Play !");
        button.addActionListener(this);

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(label);
        panel.add(textField);
        panel.add(button);

        setContentPane(panel);
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e) {
    	String input = textField.getText();
        try {
        	int nbPlayer = Integer.parseInt(input);
            if (nbPlayer < 2 || nbPlayer > 8) {
            	JOptionPane.showMessageDialog(this, "Error : You have to chose a number between 2 and 8");
            	dispose(); // close Home Window 
            	StartWindow w = new StartWindow();
            } else {
            	// Initialize a new deck
        		Deck deck = new Deck(); 
        		// Initialize the discard
        		Discard discard = new Discard(); 
        		// Initialize the boards of every player
        		BoardArray boards = new BoardArray(nbPlayer, deck); 
        		// Initialize the system of point
        		PointManager points = new PointManager(nbPlayer); 
        		dispose(); // close Home Window 
            	GameWindow game = new GameWindow(deck, discard, boards, points, 1);
            }
        	
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error : Input unvalid");
        }
    }  
    

    public static void main(String[] args) {
    	StartWindow w = new StartWindow();
    }
}
