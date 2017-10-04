package kd;

import java.util.ArrayList;
import java.util.List;

import kd.Square.TerrainType;

public class Player {
	private List<Domino> dominos;
	private Domino chosenDomino;
	private Domino toBePlaced;
	private Square[][] playerBoard = new Square[9][9];
	
	public Player(){
		for (int i = 0; i<9; i++){
			for (int j = 0; j<9; j++){
				if((i==4) && (j==4)){
					this.playerBoard[j][i] = new Square(TerrainType.CASTLE);
				}
				else{
					this.playerBoard[j][i] = new Square(TerrainType.BLANK);
				}
			}
		}
	}
	
	public void printBoard(){
		for (int i = 0; i<9; i++){
			for (int j = 0; j<9; j++){
				System.out.print(playerBoard[j][i].getName() + " ");
				
			}
			System.out.println("");

		}
	}

	
	public Square[][] getPlayerBoard(){
		return this.playerBoard;
	}
	public void addDomino(Domino domino) {
		this.dominos.add(domino);
	}
	
	public void setChosenDomino(Domino chosenDomino){
		this.chosenDomino = chosenDomino;
	}
}
