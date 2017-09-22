package kd;

import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//This class does the work of drawing new tiles from the supply and displaying them, and letting each player choose a dom,
public class TurnCanvas extends JPanel implements ActionListener {

	private DominoSupply theSupply = new DominoSupply();
	private Domino[] currentTurn;
	
	
	

	public TurnCanvas() {
		JButton button = new JButton("Draw new turn");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				displayNewTurn();
				System.out.println("");
			}
		});
		button.setBounds(0, 0, 100, 100);
	

		setLayout(new GridLayout(4, 2, 0, 0));
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		displayNewTurn();
		
	}

	// sets up a new turn of four dominos
	public Domino[] setUpTurn() {
		Domino[] theTurn = new Domino[4];
		for (int i = 0; i < 4;) {
			int rnd = new Random().nextInt(theSupply.length());
			if (theSupply.getUnplayed()[rnd].getPlayed() == false) {
				theTurn[i] = theSupply.getUnplayed()[rnd];
				theSupply.getUnplayed()[rnd].setPlayed();
				i++;
			}

		}
		sortTheTurn(theTurn);
		return theTurn;
	}

	// helper method for setUpTurn that sorts the new turn by each domino's
	// numerical value
	private void sortTheTurn(Domino[] array) {
		int n = array.length;
		Domino temp;

		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (array[j - 1].getNumber() > array[j].getNumber()) {
					temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}
			}

		}

	}

	// displays the new turn (displaying text in the console is a placeholder)
	public void displayNewTurn() {

		if (theSupply.isEmpty()) {
			System.out.print("No more dominos to draw from, the game is over");

		} else {
			currentTurn = setUpTurn();
			for (int i = 0; i < currentTurn.length; i++) {

				currentTurn[i].printADomino();
				System.out.println("");
				add(currentTurn[i]);

			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
