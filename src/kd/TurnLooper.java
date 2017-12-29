package kd;

import java.util.Random;
import java.util.Scanner;

import kd.Square.TerrainType;

public class TurnLooper {

	private Player[] thePlayers;
	private Turn theTurn = new Turn();
	private Scanner reader = new Scanner(System.in);
	private int playerCount;
	int[] turnOrder;
	int turnIncrement = 0;

	// This method lets the user input how many players are going to be playing
	// the game. If they choose an invalid number of players, they are prompted to try again.
	public void setPlayerCount() {
		System.out.println("How many players (2,3,4)?");
		while (true) {
			playerCount = reader.nextInt();
			if (playerCount < 2 || playerCount > 4) {
				System.out.println("Invalid number of players, try again. Choose either 2, 3, or 4.");
			} else {
				break;
			}
		}
		thePlayers = new Player[playerCount];
		for (int i = 0; i < thePlayers.length; i++) {
			thePlayers[i] = new Player();

		}
		turnOrder = new int[playerCount];
		for (int i = 0; i < turnOrder.length; i++) {
			turnOrder[i] = i;
		}
		theTurn.setTurnSize(playerCount);
	}

	public void doNewGame() {
		setPlayerCount();
		loopThroughTurns();
	}

	public void printTheTurn() {
		for (int i = 0; i < theTurn.getToBeChosenFrom().length; i++) {
			theTurn.getToBeChosenFrom()[i].printADomino();
		}
	}

	// This method returns a domino chosen by a player, from the current ones
	// available to be chosen. If a player
	// tries to choose a domino that had already been chosen by another player,
	// they are notified to chose another.
	public Domino chooseADomino() {

		int theChoice;
		boolean validChoice = false;
		printTheTurn();
		System.out.println("Which domino would you like to choose?");
		theChoice = reader.nextInt();
		while (!validChoice) {
			if (!theTurn.getToBeChosenFrom()[theChoice - 1].isChosen()) {
				theTurn.getToBeChosenFrom()[theChoice - 1].setChosen();
				validChoice = true;
			} else {
				System.out.print("This domino has already been chosen by another player, please choose another.");
				theChoice = reader.nextInt();
			}

		}
		turnOrder[turnIncrement] = theChoice - 1;
		turnIncrement += 1;
		return theTurn.getToBeChosenFrom()[theChoice - 1];
	}
	
	//Set up a new round of the game.
	public void doNewRound() {

		for (int i = 0; i < thePlayers.length; i++) {
			thePlayers[i].getPlayArea().setBoardBounds();
			thePlayers[i].getPlayArea().printBoard();
		}
		theTurn.setToBeChosenFrom();

		doTheTurns();
		turnIncrement = 0;

	}

	// This method loops through all of the player's turns in the correct turn
	// order.
	public void doTheTurns() {
		for (int i = 0; i < turnOrder.length; i++) {
			System.out.println("Player" + (turnOrder[i] + 1) + "'s turn");
			thePlayers[turnOrder[i]].doTurn(chooseADomino());
		}

	}

	// This method loops the display turn method 12 times (the number of turns
	// in a game of KingDomino), then scored the board once the game is done
	public void loopThroughTurns() {

		for (int i = 0; i < 12; i++) {
			doNewRound();
		}
		for (int i = 0; i < thePlayers.length; i++) {
			thePlayers[i].getPlayArea().scoreTheBoard();
		}

	}

	public static void main(String[] args) {
		TurnLooper x = new TurnLooper();

		x.doNewGame();

		// TODO Auto-generated method stub

	}

}
