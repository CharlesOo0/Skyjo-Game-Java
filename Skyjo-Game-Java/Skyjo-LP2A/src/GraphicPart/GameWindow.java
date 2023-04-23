package GraphicPart;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import gametool.*;
import skyjo.*;

public class GameWindow {
	
	public GameWindow(Deck deck, Discard discard, BoardArray boards, PointManager points, int idPlayer) {

    	JFrame frame = new JFrame("Skyjo - Game");    	
    	
    	JPanel globalPanel = new JPanel(new BorderLayout());
        JLabel player = new JLabel("Player" + idPlayer);
        player.setHorizontalAlignment(JLabel.CENTER);
        globalPanel.add(player, BorderLayout.NORTH);
        
        BoardCard card;
        
        int row, column;
        
        JPanel gamePanel = new JPanel(new GridLayout(4, 4));
        for (int i = 0; i < 16; i++) {
        	if (card.getHidden() == true) {
        		JLabel cardShow = new JLabel(CardElement.getUV(card.getCard()));
        		cardShow.setHorizontalAlignment(JLabel.CENTER);
        		gamePanel.add(cardShow);
        	} else {
        		JButton showCard = new JButton("Hide");
        		showCard.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	
                        card.setHidden(true);
                    }
                });
	            gamePanel.add(showCard);
        	}
            
        }
        
        globalPanel.add(gamePanel, BorderLayout.CENTER);
        
        /*JButton deck = new JButton("Deck");
        deck.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(deck, "deck", null, 0);
            }
        });
        globalPanel.add(deck, BorderLayout.EAST);
        
        JButton discard = new JButton("Deck");
        discard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(this, "[INFO] Discard");
            }
        });
        
        globalPanel.add(discard, BorderLayout.EAST);
*/
        frame.setContentPane(globalPanel);
        frame.setSize(400,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	
	
}
