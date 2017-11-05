package kd;

import java.util.ArrayList;
import java.util.List;

import kd.Square.TerrainType;

public class Player {
	private List<Domino> dominos;
	private Domino chosenDomino;
	private Domino toBePlaced;
	private Square[][] playerBoard = new Square[10][10];
	private int totalBoardScore = 0;
	private Square[][] testBoard = new Square[10][10];

	public Player() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if ((i == 4) && (j == 4)) {
					this.playerBoard[j][i] = new Square(TerrainType.CASTLE);
				} else {
					this.playerBoard[j][i] = new Square(TerrainType.BLANK);
				}
			}
		}
	}

	public void populateTestBoard() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if ((j == 3 && i == 3) || j == 4 && i == 3) {
					playerBoard[j][i] = new Square(TerrainType.WATER);
					playerBoard[j][i].setCrowns(1);
				} else if (j == 4 && i == 4) {
					playerBoard[j][i] = new Square(TerrainType.CASTLE);
				} else if (i <= 1 || j <= 1 || i >= 7 || j >= 7) {

				} else if (j <= 6) {
					playerBoard[j][i] = new Square(TerrainType.FOREST);
					playerBoard[j][i].setCrowns(1);
				}

			}
		}

	}

	public void setBoardBounds() {
		int minX = 9;
		int maxX = 0;
		int minY = 9;
		int maxY = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (this.playerBoard[j][i].getName() != "B" && this.playerBoard[j][i].getName() != "X") {
					if (j < minX) {
						minX = j;
					}
					if (j > maxX) {
						maxX = j;
					}
					if (i < minY) {
						minY = i;
					}
					if (i > maxY) {
						maxY = i;
					}
				}

			}
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (j > minX + 4) {
					this.playerBoard[j][i] = new Square(TerrainType.OUTOFBOUNDS);
				}
				if (j < maxX - 4) {
					this.playerBoard[j][i] = new Square(TerrainType.OUTOFBOUNDS);
				}
				if (i > minY + 4) {
					this.playerBoard[j][i] = new Square(TerrainType.OUTOFBOUNDS);
				}
				if (i < maxY - 4) {
					this.playerBoard[j][i] = new Square(TerrainType.OUTOFBOUNDS);
				}
			}
		}
	}

	List<Square> theZone = new ArrayList<Square>();

	public void findAZone(int x, int y) {

		System.out.println(x + " " + y);
		if (!(this.playerBoard[x][y].isScoredYet())) {
			if (this.playerBoard[x][y].getName() == "X" || this.playerBoard[x][y].getName() == "B") {

			} else {
				theZone.add(this.playerBoard[x][y]);
				this.playerBoard[x][y].setScoredYet(true);
				if (this.playerBoard[x + 1][y].getName() == this.playerBoard[x][y].getName() && (x + 1 != 10)
						&& !this.playerBoard[x + 1][y].isScoredYet()) {

					findAZone(x + 1, y);
					System.out.println("R");

				}

				if ((this.playerBoard[x - 1][y].getName() == this.playerBoard[x][y].getName()) && (x - 1 != -1)
						&& !this.playerBoard[x - 1][y].isScoredYet()) {
					findAZone(x - 1, y);
					System.out.println("L");

				}

				if (this.playerBoard[x][y + 1].getName() == this.playerBoard[x][y].getName() && (y + 1 != 10)
						&& !this.playerBoard[x][y + 1].isScoredYet()) {
					findAZone(x, y + 1);
					System.out.println("D");

				}

				if (this.playerBoard[x][y - 1].getName() == this.playerBoard[x][y].getName() && (y - 1 != -1)
						&& !this.playerBoard[x][y - 1].isScoredYet()) {
					findAZone(x, y - 1);
					System.out.println("U");

				}

			}

		}

	}



	public void scoreAZone(int x, int y) {

		findAZone(x, y);
		int numCrowns = 0;
		for (int i = 0; i < theZone.size(); i++) {
			numCrowns += theZone.get(i).getCrowns();
		}
		this.totalBoardScore += (theZone.size() * numCrowns);
		theZone = new ArrayList<Square>();
		// System.out.print(" " + numCrowns + " ");
		// System.out.print(theZone.size());

		// System.out.print("Scored");

	}

	public void scoreTheBoard() {

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				scoreAZone(j, i);
			}
		}

		System.out.print(this.totalBoardScore);
	}

	public void printBoard() {
		System.out.println("");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (playerBoard[j][i].getName() == "B")
					System.out.print(playerBoard[j][i].getName() + "" + j + "" + i + " ");
				else if (playerBoard[j][i].getName() == "X")
					System.out.print(playerBoard[j][i].getName() + "   ");
				else
					System.out.print(playerBoard[j][i].getName() + "" + playerBoard[j][i].getCrowns() + "  ");

			}
			System.out.println("");

		}
		System.out.println("");
	}

	public void printTestBoard() {
		System.out.println("");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (testBoard[j][i].getName() == "B")
					System.out.print(testBoard[j][i].getName() + "" + j + "" + i + " ");
				else if (testBoard[j][i].getName() == "X")
					System.out.print(testBoard[j][i].getName() + "   ");
				else
					System.out.print(testBoard[j][i].getName() + "" + testBoard[j][i].getCrowns() + "  ");

			}
			System.out.println("");

		}
		System.out.println("");
	}

	public Square[][] getPlayerBoard() {
		return this.playerBoard;
	}

	public void addDomino(Domino domino) {
		this.dominos.add(domino);
	}

	public void setChosenDomino(Domino chosenDomino) {
		this.chosenDomino = chosenDomino;
	}
}
