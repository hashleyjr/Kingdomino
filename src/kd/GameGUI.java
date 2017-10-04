package kd;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameGUI extends JFrame{

	JButton drawTurn = new JButton();
	TurnCanvas turnPanel = new TurnCanvas();
	GridBagConstraints c = new GridBagConstraints();
	public GameGUI() {

		JPanel parent = new JPanel();
		parent.setLayout(new GridBagLayout());
		add(parent);

		
		
		JPanel player1Panel = new JPanel();
		JPanel player2Panel = new JPanel();
		JPanel player3Panel = new JPanel();
		JPanel player4Panel = new JPanel();
		
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 1;
		
		c.gridx = 0;
		c.gridy = 0;
		turnPanel.setBackground(Color.CYAN);
		parent.add(turnPanel, c);
		
		c.gridx= 0;
		c.gridy = 1;
		player1Panel.setOpaque(true);
		player1Panel.setBackground(Color.RED);
		parent.add(player1Panel,c);
	
		/*parent.add(player2Panel);
		parent.add(player3Panel);
		parent.add(player4Panel);*/
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameGUI theGUI = new GameGUI();
		theGUI.setSize(1920, 1080);
		theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		theGUI.setVisible(true);
	}

}
