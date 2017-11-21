package kd;

import java.util.Random;
import java.util.Scanner;

import kd.Square.TerrainType;

public class TextVersion {

	Player thePlayer = new Player();
	DominoSupply theSupply = new DominoSupply();
	Scanner reader = new Scanner(System.in);
	int playerCount;
	int x, y;
	DominoPlacement thePlacement;

	public Domino giveRandomDomino() {
		Domino theTurn = new Domino();
		boolean foundflag = true;
		while (foundflag) {
			int rnd = new Random().nextInt(theSupply.length() - 1);
			if (theSupply.getUnplayed()[rnd].getPlayed() == false) {
				theTurn = theSupply.getUnplayed()[rnd];
				theSupply.getUnplayed()[rnd].setPlayed();
				foundflag = false;
			}
		}
		return theTurn;
	}

	public void setPlayerCount() {
		System.out.println("How many players?");
		playerCount = reader.nextInt();
	}

	public void doNewGame() {

	}
//This method takes the placement specifications for the chosen domino. Takes an X,Y coordinate, checks of that space isn't already occupied, takes
	//the heading, and returns a DominoPlacement.
	public DominoPlacement specifyPlacement(Domino toBePlaced) {
		int x = 0, y = 0;

		String heading;
		boolean validXYChoice = false;
		DominoPlacement thePlacement;
		while (!validXYChoice) {
			System.out.println("Specify an X coord");
			x = reader.nextInt();
			System.out.println("Specify a Y coord");
			y = reader.nextInt();
			if (isntOccupied(x, y)) {
				System.out.println("You picked a valid XY location");
				validXYChoice = true;
			} else {
				System.out.println("This spot is already occupied, try again");
			}
		}
		System.out.println("Specify the heading");
		heading = reader.next();
		thePlacement = new DominoPlacement(x, y, toBePlaced, heading);
		return thePlacement;

	}

	//this method places the chosen Domino "toBePlaced" at the specified XY location, facing the direction of the heading. It does not 
	//check if it is a legal placement.
	public void makePlacement(DominoPlacement thePlacement) {
		int x = thePlacement.x;
		int y = thePlacement.y;
		Domino toBePlaced = thePlacement.toBePlaced;
		String heading = thePlacement.heading;
		switch (heading) {

		case ("S"):

			thePlayer.getPlayerBoard()[x][y] = toBePlaced.getPivot();
			thePlayer.getPlayerBoard()[x][y - 1] = toBePlaced.getLeft();

			break;

		case ("N"):
			thePlayer.getPlayerBoard()[x][y] = toBePlaced.getPivot();
			thePlayer.getPlayerBoard()[x][y + 1] = toBePlaced.getLeft();

			break;

		case ("E"):

			thePlayer.getPlayerBoard()[x][y] = toBePlaced.getPivot();
			thePlayer.getPlayerBoard()[x - 1][y] = toBePlaced.getLeft();

			break;
		case ("W"):

			thePlayer.getPlayerBoard()[x][y] = toBePlaced.getPivot();
			thePlayer.getPlayerBoard()[x + 1][y] = toBePlaced.getLeft();

			break;

		}
	}

	// This method gives the player a random domino, lets them specify an XY
	// coordination and a heading, and checks if its a legal placement using the
	// isntOccupied and hasMatchingAdjacentTerrain methods.
	public void placeTheDomino() {

		Domino toBePlaced;

		String heading;
		boolean validXYChoice;
		boolean validChoice;
		DominoPlacement currentPlacement;
		for (int i = 0; i < 12;) {
			thePlayer.setBoardBounds();
			thePlayer.printBoard();
			toBePlaced = giveRandomDomino();

			validChoice = false;
			while (!validChoice) {
				toBePlaced.printADomino();
				currentPlacement = specifyPlacement(toBePlaced);

				if (currentPlacement.heading.equals("U")) {
					System.out.print("Too bad");
					validChoice = true;
					i++;
				} else {
					if (isLegalPlacement(currentPlacement)) {

						makePlacement(currentPlacement);
						validChoice = true;
						i++;
					} else {
						System.out.println("This is not a legal placement.");

					}
				}
				thePlayer.printBoard();
			}
		}
		thePlayer.scoreTheBoard();

	}

	// This method uses the hasMatchingAdjacentTerrain method to check if the tile being
	// placed has adjacent matching terrain, and if the tile isn't overlapping
	// with an already placed tile
	public boolean isLegalPlacement(DominoPlacement thePlacement) {
		int x = thePlacement.x;
		int y = thePlacement.y;
		String heading = thePlacement.heading;
		switch (heading) {
		case "S":
			if (hasMatchingAdjacentTerrain(thePlacement) && isntOccupied(x, y - 1))
				return true;
			else {

				return false;
			}
		case "N":
			if (hasMatchingAdjacentTerrain(thePlacement) && isntOccupied(x, y + 1))
				return true;
			else
				return false;
		case "E":
			if (hasMatchingAdjacentTerrain(thePlacement) && isntOccupied(x - 1, y))
				return true;
			else
				return false;
		case "W":
			if (hasMatchingAdjacentTerrain(thePlacement) && isntOccupied(x + 1, y))
				return true;
			else
				return false;

		}
		return false;

	}

	// This method checks if a certain location on in the player's area is
	// already occupied by a tile. Used when the player is placing a tile, to
	// make sure that the one they are placing doesn't overlap with an already
	// laid tile.
	public boolean isntOccupied(int x, int y) {
		if (thePlayer.getPlayerBoard()[x][y].getName() != "B") {

			return false;
		} else {

			return true;
		}
	}

	// In a game of KingDomino, a tile being laid has to have have at least one
	// of its terrain types matching the terrain type of a tile
	// adjacent to where it's being laid. This method checks for that.
	public boolean hasMatchingAdjacentTerrain(DominoPlacement thePlacement) {
		int x = thePlacement.x;
		int y = thePlacement.y;
		Domino toBePlaced = thePlacement.toBePlaced;
		String heading = thePlacement.heading;
		switch (heading) {
		case "S":

			for (int i = -1; i <= 1; i += 2) {
				if (thePlayer.getPlayerBoard()[x + i][y].getName() == "C"
						|| thePlayer.getPlayerBoard()[x + i][y].getName() == toBePlaced.getPivot().getName()
						|| thePlayer.getPlayerBoard()[x][y + 1].getName() == "C"
						|| thePlayer.getPlayerBoard()[x][y + 1].getName() == toBePlaced.getPivot().getName()) {
					return true;
				} else if (thePlayer.getPlayerBoard()[x + i][y - 1].getName() == "C"
						|| thePlayer.getPlayerBoard()[x + i][y - 1].getName() == toBePlaced.getLeft().getName()
						|| thePlayer.getPlayerBoard()[x][y - 2].getName() == "C"
						|| thePlayer.getPlayerBoard()[x][y - 2].getName() == toBePlaced.getLeft().getName()) {
					return true;
				}

			}
			System.out.println("The terrain types don't match, try again.");
			return false;

		case "N":

			for (int i = -1; i <= 1; i += 2) {
				if (thePlayer.getPlayerBoard()[x + i][y].getName() == "C"
						|| thePlayer.getPlayerBoard()[x + i][y].getName() == toBePlaced.getPivot().getName()
						|| thePlayer.getPlayerBoard()[x][y - 1].getName() == "C"
						|| thePlayer.getPlayerBoard()[x][y - 1].getName() == toBePlaced.getPivot().getName()) {
					return true;
				} else if (thePlayer.getPlayerBoard()[x + i][y + 1].getName() == "C"
						|| thePlayer.getPlayerBoard()[x + i][y + 1].getName() == toBePlaced.getLeft().getName()
						|| thePlayer.getPlayerBoard()[x][y + 2].getName() == "C"
						|| thePlayer.getPlayerBoard()[x][y + 2].getName() == toBePlaced.getLeft().getName()) {
					return true;
				}

			}
			System.out.println("The terrain types don't match, try again.");
			return false;

		case "E":

			for (int i = -1; i <= 1; i += 2) {
				if (thePlayer.getPlayerBoard()[x][y + i].getName() == "C"
						|| thePlayer.getPlayerBoard()[x][y + i].getName() == toBePlaced.getPivot().getName()
						|| thePlayer.getPlayerBoard()[x + 1][y].getName() == "C"
						|| thePlayer.getPlayerBoard()[x + 1][y].getName() == toBePlaced.getPivot().getName()) {
					return true;
				} else if (thePlayer.getPlayerBoard()[x - 1][y + i].getName() == "C"
						|| thePlayer.getPlayerBoard()[x - 1][y + i].getName() == toBePlaced.getLeft().getName()
						|| thePlayer.getPlayerBoard()[x - 2][y].getName() == "C"
						|| thePlayer.getPlayerBoard()[x - 2][y].getName() == toBePlaced.getLeft().getName()) {
					return true;
				}

			}
			System.out.println("The terrain types don't match, try again.");
			return false;

		case "W":

			for (int i = -1; i <= 1; i += 2) {
				if (thePlayer.getPlayerBoard()[x][y + i].getName() == "C"
						|| thePlayer.getPlayerBoard()[x][y + i].getName() == toBePlaced.getPivot().getName()
						|| thePlayer.getPlayerBoard()[x - 1][y].getName() == "C"
						|| thePlayer.getPlayerBoard()[x - 1][y].getName() == toBePlaced.getPivot().getName()) {
					return true;
				} else if (thePlayer.getPlayerBoard()[x + 1][y + i].getName() == "C"
						|| thePlayer.getPlayerBoard()[x + 1][y + i].getName() == toBePlaced.getLeft().getName()
						|| thePlayer.getPlayerBoard()[x + 2][y].getName() == "C"
						|| thePlayer.getPlayerBoard()[x + 2][y].getName() == toBePlaced.getLeft().getName()) {
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
		// x.thePlayer.printBoard();
		x.thePlayer.scoreTheBoard();

		// TODO Auto-generated method stub

	}

}
