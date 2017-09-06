package kd;

import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

import kd.Square.TerrainType;

public class GameState {
	
	//variable representing the supply of unplayed dominos
	static Domino[] theSupply = new Domino[48];
	
	//variable representing the dominos in one turn
	static Domino[] theTurn = new Domino[4];
	
	//sets up the initial supply of dominos to be chosen and placed
	public static void setUpSupply() {
		
		for (int i = 0; i < theSupply.length; i++) {
			
			theSupply[i] = new Domino();
			if (i == 0 || i == 1 || i == 12 || i == 13 || i == 14 || i == 15 || i == 18 || i == 19 || i == 20 || i == 21
					|| i == 22 || i == 35 || i == 37 || i == 40 || i == 42 || i == 47) {
				theSupply[i].setLeft(new Square(TerrainType.FARM));
			}
			if (i == 0 || i == 1 || i == 23 || i == 24 || i == 25 || i == 26 || i == 29 || i == 30 || i == 39
					|| i == 44) {
				theSupply[i].setRight(new Square(TerrainType.FARM));
			}
			if (i == 2 || i == 3 || i == 4 || i == 5 || i == 16 || i == 17 || i == 23 || i == 24 || i == 25 || i == 26
					|| i == 27 || i == 28) {
				theSupply[i].setLeft(new Square(TerrainType.FOREST));
			}
			if (i == 2 || i == 3 || i == 4 || i == 5 || i == 12 || i == 18 || i == 31 || i == 32 || i == 33
					|| i == 34) {
				theSupply[i].setRight(new Square(TerrainType.FOREST));
			}
			if (i == 6 || i == 7 || i == 8 || i == 29 || i == 30 || i == 31 || i == 32 || i == 33 || i == 34 || i == 36
					|| i == 41) {
				theSupply[i].setLeft(new Square(TerrainType.WATER));
			}
			if (i == 6 || i == 7 || i == 8 || i == 13 || i == 16 || i == 19 || i == 27) {
				theSupply[i].setRight(new Square(TerrainType.WATER));
			}
			if (i == 9 || i == 10 || i == 38 || i == 43) {
				theSupply[i].setLeft(new Square(TerrainType.PLAIN));
			}
			if (i == 9 || i == 10 || i == 14 || i == 17 || i == 20 || i == 28 || i == 35 || i == 36 || i == 40
					|| i == 41) {
				theSupply[i].setRight(new Square(TerrainType.PLAIN));
			}
			if (i == 11 || i == 45 || i == 46) {
				theSupply[i].setLeft(new Square(TerrainType.SWAMP));
			}
			if (i == 11 || i == 15 || i == 21 || i == 37 || i == 38 || i == 42 || i == 43) {
				theSupply[i].setRight(new Square(TerrainType.SWAMP));
			}
			if (i == 39 || i == 44) {
				theSupply[i].setLeft(new Square(TerrainType.MINE));
			}
			if (i == 22 || i == 45 || i == 46 || i == 47) {
				theSupply[i].setRight(new Square(TerrainType.MINE));
			}
			if (i >= 0 && i <= 17) {
				theSupply[i].setLeftCrowns(0);
				theSupply[i].setRightCrowns(0);
			}
			if ((i >= 18 && i <= 34) || i == 39) {
				theSupply[i].setLeftCrowns(1);
				theSupply[i].setRightCrowns(0);

			}
			if (i >= 35 && i <= 38) {
				theSupply[i].setLeftCrowns(0);
				theSupply[i].setRightCrowns(1);

			}
			if ((i >= 40 && i <= 43) || i == 45 || i == 46) {
				theSupply[i].setLeftCrowns(0);
				theSupply[i].setRightCrowns(2);
			}
			if (i == 44) {
				theSupply[i].setLeftCrowns(2);
				theSupply[i].setRightCrowns(0);
			}
			if (i == 47) {

				theSupply[i].setLeftCrowns(0);
				theSupply[i].setRightCrowns(3);
			}

			theSupply[i].setNumber(i + 1);

		}
	
	}

	// each turn, 4 new dominoes are layed out in descending order, these next
	// to methods do that
	// (bubble sort is used cause the array to be sorted is 3 or 4 elements
	public static void sortTheTurn(Domino[] array) {
		int n = array.length;
		Domino temp;

		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (array[j - 1].getNumber() > array[j].getNumber()) {
					// swap elements
					temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}
			}

		}
		
	}

	public static Domino[] setUpTurn(Domino[] array) {
		Domino[] theTurn = new Domino[4];
		for (int i = 0; i < 4;) {
			int rnd = new Random().nextInt(array.length);
			if (array[rnd].getPlayed() == false) {
				theTurn[i] = array[rnd];
				array[rnd].setPlayed();
				i++;
			}

		}
		sortTheTurn(theTurn);
		return theTurn;
	}

	public static void main(String[] args) {

		setUpSupply();
		Domino[] theTurn = setUpTurn(theSupply);
		for (int i = 0; i < theTurn.length; i++) {
		
			theTurn[i].printADomino();
			System.out.println("");
		}

	}
}
