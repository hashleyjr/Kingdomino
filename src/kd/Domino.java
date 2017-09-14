package kd;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

//class that represents one domino in a game of KingDomino. One domino is made up of two Squares objects, a left one and a right one, a number 
//used to order them when setting out a new turn, and a boolean to see if the domino is still in the supply, or if it's been played.
public class Domino extends JPanel {

	private Square leftSquare;
	private Square rightSquare;
	private int number;
	private boolean played;

	public Domino() {
		this.played = false;
	}

	public void setPlayed() {
		this.played = true;
	}

	public boolean getPlayed() {
		return this.played;
	}

	public void printADomino() {
		System.out.print(this.leftSquare.getName() + "" + this.leftSquare.getCrowns() + "  "
				+ this.rightSquare.getName() + "" + this.rightSquare.getCrowns() + " " + this.number);
	}

	public void setLeft(Square leftSquare) {
		this.leftSquare = leftSquare;
	}

	public void setRight(Square rightSquare) {
		this.rightSquare = rightSquare;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setLeftCrowns(int num) {
		this.leftSquare.setCrowns(num);
	}

	public void setRightCrowns(int num) {
		this.rightSquare.setCrowns(num);
	}

	public int getLeftCrowns() {
		return this.leftSquare.getCrowns();
	}

	public int getRightCrowns() {
		return this.rightSquare.getCrowns();
	}

	public int getNumber() {
		return this.number;
	}

	public void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		
		g2.setFont(new Font("TimesRoman", Font.BOLD, 20));
		leftSquare.setBounds(0, 0, 100, 100);
		g2.setColor(leftSquare.getColor());
		g2.fill(leftSquare);
		g2.setColor(complementaryColor(g2.getColor()));
		g2.drawString(leftSquare.getCrownsString(), 5, 50);
		g.setColor(Color.black);
		g.drawRect(0, 0, 100, 100);
		
		
		rightSquare.setBounds(100, 0, 100, 100);
		g2.setColor(rightSquare.getColor());
		g2.fill(rightSquare);
		g2.setColor(complementaryColor(g2.getColor()));
		g2.drawString(rightSquare.getCrownsString(), 105, 50);
		g.setColor(Color.black);
		g.drawRect(100, 0, 100, 100);
		
	}

	private static Color complementaryColor(Color color) {
		double y = (299 * color.getRed() + 587 * color.getGreen() + 114 * color.getBlue()) / 1000;
		return y >= 128 ? Color.black : Color.white;
	}

}
