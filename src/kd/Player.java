package kd;

import java.util.ArrayList;
import java.util.List;

import kd.Square.TerrainType;

public class Player {
	private List<Domino> dominos;
	private Domino chosenDomino;
	private Domino toBePlaced;
	private Square[][] playerBoard = new Square[10][10];

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
