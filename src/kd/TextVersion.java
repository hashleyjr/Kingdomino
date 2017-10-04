package kd;

import java.util.Random;
import java.util.Scanner;

public class TextVersion {

	Player thePlayer = new Player();
	DominoSupply theSupply = new DominoSupply();
	Scanner reader = new Scanner(System.in);

	public Domino giveRandomDomino() {
		Domino theTurn = new Domino();

		int rnd = new Random().nextInt(theSupply.length());
		if (theSupply.getUnplayed()[rnd].getPlayed() == false) {
			theTurn = theSupply.getUnplayed()[rnd];
			theSupply.getUnplayed()[rnd].setPlayed();

		}

		return theTurn;
	}

	//This method gives the player a random domino, lets them specify an XY coordination and a heading, and checks if its a legal placement using the isn'tOccupied
	//and hasMatchingTerrain methods.
	public void placeTheDomino() {
		Domino toBePlaced = giveRandomDomino();
		
		int x;
		int y;
		String heading;
		
		toBePlaced.printADomino();
		while (true) {
			System.out.println("Please place this domino, specify x coord");
			x = reader.nextInt();
			System.out.println("Specify y coord");
			y = reader.nextInt();
			if (isntOccupied(x, y)) {
				System.out.println("You picked a valid XY location");
				break;
			} else {
				System.out.println("This spot is already occupied, try again");
			}

		}
		while (true) {
			System.out.println("Specify the heading");
			heading = reader.next();

			if (heading.equals("S") && hasMatchingTerrain(x, y, toBePlaced, heading)) {
				if (isntOccupied(x, y - 1)) {
					thePlayer.getPlayerBoard()[x][y] = toBePlaced.getPivot();
					thePlayer.getPlayerBoard()[x][y - 1] = toBePlaced.getLeft();
					break;
				} else {
					System.out.println("You are overlapping with an already placed piece, try again");
				}
			}
			if (heading.equals("N") && hasMatchingTerrain(x, y, toBePlaced, heading)) {
				if (isntOccupied(x, y + 1)) {

					thePlayer.getPlayerBoard()[x][y] = toBePlaced.getPivot();
					thePlayer.getPlayerBoard()[x][y + 1] = toBePlaced.getLeft();
					break;
				} else {
					System.out.println("You are overlapping with an already placed piece, try again");
				}
			}
			if (heading.equals("E") && hasMatchingTerrain(x, y, toBePlaced, heading)) {
				if (isntOccupied(x - 1, y)) {
					thePlayer.getPlayerBoard()[x][y] = toBePlaced.getPivot();
					thePlayer.getPlayerBoard()[x - 1][y] = toBePlaced.getLeft();
					break;
				} else {
					System.out.println("You are overlapping with an already placed piece, try again");
				}
			}
			if (heading.equals("W") && hasMatchingTerrain(x, y, toBePlaced, heading)) {
				if (isntOccupied(x + 1, y)) {
					thePlayer.getPlayerBoard()[x][y] = toBePlaced.getPivot();
					thePlayer.getPlayerBoard()[x + 1][y] = toBePlaced.getLeft();
					break;
				} else {
					System.out.println("You are overlapping with an already placed piece, try again");
				}
			}
		}

		thePlayer.printBoard();

		// thePlayer.printBoard();
		System.out.println(heading);

	}
	
	//This method checks if a certain location on in the player's area is already occupied by a tile. Used when the player is placing a tile, to make
	//sure that the one they are placing doesn't overlap with an already laid tile.
	public boolean isntOccupied(int x, int y) {
		if (thePlayer.getPlayerBoard()[x][y].getName() != "B") {
			return false;
		} else
			return true;
	}
	
   //In a game of KingDomino, a tile being laid has to have have at least one of its terrain types matching the terrain type of a tile
	//adjacent to where it's being laid. This method checks for that.
	public boolean hasMatchingTerrain(int x, int y, Domino d, String heading) {

		switch (heading) {
		case "S":

			for (int i = -1; i <= 1; i += 2) {
				if (thePlayer.getPlayerBoard()[x + i][y].getName() == "C"
						|| thePlayer.getPlayerBoard()[x + i][y].getName() == d.getPivot().getName()
						|| thePlayer.getPlayerBoard()[x][y + 1].getName() == "C"
						|| thePlayer.getPlayerBoard()[x][y + 1].getName() == d.getPivot().getName()) {
					return true;
				} else if (thePlayer.getPlayerBoard()[x + i][y - 1].getName() == "C"
						|| thePlayer.getPlayerBoard()[x + i][y - 1].getName() == d.getLeft().getName()
						|| thePlayer.getPlayerBoard()[x][y - 2].getName() == "C"
						|| thePlayer.getPlayerBoard()[x][y - 2].getName() == d.getLeft().getName()) {
					return true;
				}

			}
			System.out.println("The terrain types don't match, try again.");
			return false;

		case "N":

			for (int i = -1; i <= 1; i += 2) {
				if (thePlayer.getPlayerBoard()[x + i][y].getName() == "C"
						|| thePlayer.getPlayerBoard()[x + i][y].getName() == d.getPivot().getName()
						|| thePlayer.getPlayerBoard()[x][y - 1].getName() == "C"
						|| thePlayer.getPlayerBoard()[x][y - 1].getName() == d.getPivot().getName()) {
					return true;
				} else if (thePlayer.getPlayerBoard()[x + i][y + 1].getName() == "C"
						|| thePlayer.getPlayerBoard()[x + i][y + 1].getName() == d.getLeft().getName()
						|| thePlayer.getPlayerBoard()[x][y + 2].getName() == "C"
						|| thePlayer.getPlayerBoard()[x][y + 2].getName() == d.getLeft().getName()) {
					return true;
				}

			}
			System.out.println("The terrain types don't match, try again.");
			return false;

		case "E":

			for (int i = -1; i <= 1; i += 2) {
				if (thePlayer.getPlayerBoard()[x][y + i].getName() == "C"
						|| thePlayer.getPlayerBoard()[x][y + i].getName() == d.getPivot().getName()
						|| thePlayer.getPlayerBoard()[x + 1][y].getName() == "C"
						|| thePlayer.getPlayerBoard()[x + 1][y].getName() == d.getPivot().getName()) {
					return true;
				} else if (thePlayer.getPlayerBoard()[x - 1][y + i].getName() == "C"
						|| thePlayer.getPlayerBoard()[x - 1][y + i].getName() == d.getLeft().getName()
						|| thePlayer.getPlayerBoard()[x - 2][y].getName() == "C"
						|| thePlayer.getPlayerBoard()[x - 2][y].getName() == d.getLeft().getName()) {
					return true;
				}

			}
			System.out.println("The terrain types don't match, try again.");
			return false;

		case "W":

			for (int i = -1; i <= 1; i += 2) {
				if (thePlayer.getPlayerBoard()[x][y + i].getName() == "C"
						|| thePlayer.getPlayerBoard()[x][y + i].getName() == d.getPivot().getName()
						|| thePlayer.getPlayerBoard()[x - 1][y].getName() == "C"
						|| thePlayer.getPlayerBoard()[x - 1][y].getName() == d.getPivot().getName()) {
					return true;
				} else if (thePlayer.getPlayerBoard()[x + 1][y + i].getName() == "C"
						|| thePlayer.getPlayerBoard()[x + 1][y + i].getName() == d.getLeft().getName()
						|| thePlayer.getPlayerBoard()[x + 2][y].getName() == "C"
						|| thePlayer.getPlayerBoard()[x + 2][y].getName() == d.getLeft().getName()) {
					return true;
				}

			}
			System.out.println("The terrain types don't match, try again.");
			return false;

		}

		return true;
	}

	public boolean isOutOfBounds(int x, int y) {
		if (x - 1 < 0 || x + 1 > 4 || y - 1 < 0 || y + 1 > 4) {
			return true;
		} else
			return false;
	}

	public static void main(String[] args) {
		TextVersion x = new TextVersion();
		x.thePlayer.printBoard();
		x.placeTheDomino();

		// TODO Auto-generated method stub

	}

}
