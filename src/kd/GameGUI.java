package kd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameGUI extends JFrame implements ActionListener {

	JButton drawTurn = new JButton();
	TurnCanvas turnPanel = new TurnCanvas();
	public GameGUI() {

		JPanel parent = new JPanel();
		parent.setLayout(new BoxLayout(parent, BoxLayout.X_AXIS));
		add(parent);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(null);

		drawTurn.setSize(100, 100);
		buttonPanel.add(drawTurn);
		parent.add(buttonPanel);

		drawTurn.addActionListener(this);

	
		parent.add(turnPanel);
	}
	
	public void actionPerformed(ActionEvent e){
		turnPanel.removeAll();
		turnPanel.revalidate();
		turnPanel.repaint();
		turnPanel.displayNewTurn();
		System.out.println("");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameGUI theGUI = new GameGUI();
		theGUI.setSize(500, 500);
		theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		theGUI.setVisible(true);
	}

}
