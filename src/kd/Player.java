package kd;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private List<Domino> dominos;
	private Domino chosenDomino;
	private Domino toBePlaced;
	public void addDomino(Domino domino) {
		this.dominos.add(domino);
	}
	
	public void setChosenDomino(Domino chosenDomino){
		this.chosenDomino = chosenDomino;
	}
}
