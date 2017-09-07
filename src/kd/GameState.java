package kd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameState extends JPanel {

	private DominoSupply theSupply = new DominoSupply();
	private Domino[] currentTurn;

	//sets up a new turn of four dominos
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

	//helper method for setUpTurn that sorts the new turn by each domino's numerical value
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
	
	//displays the new turn (displaying text in the console is a placeholder)
	public void displayNewTurn() {

		if (theSupply.isEmpty()) {
			System.out.print("No more dominos to draw from, the game is over");
		
		} else {
			currentTurn = setUpTurn();
			for (int i = 0; i < currentTurn.length; i++) {

				currentTurn[i].printADomino();
				System.out.println("");

			}
		}
	}

	public static void main(String[] args) {
		GameState yea = new GameState();
		JFrame frame = new JFrame("the game");
		JButton button = new JButton("Draw new turn");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display/center the jdialog when the button is pressed

				yea.displayNewTurn();
				System.out.println("");
			}
		});
		button.setBounds(50, 50, 200, 50);
		frame.add(button);

		// Setting Frame size. This is the window size
		frame.setSize(300, 200);

		frame.setLayout(null);
		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
