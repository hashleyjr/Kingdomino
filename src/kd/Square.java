package kd;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.*;

//this class represents the Squares that make up each individual domino (2 per domino). Each Square has a terrain type, and a number of crowns (0, 1, 2 or 3)
public class Square extends Rectangle {

	private int crowns;

	private String name;
	private Color theColor;
	private boolean scoredYet = false;
	public enum TerrainType {
		FARM, MINE, WATER, SWAMP, PLAIN, FOREST, CASTLE, BLANK, OUTOFBOUNDS;
	}

	public Square(TerrainType terrainType) {

		switch (terrainType) {
		case FARM:
			this.name = "F";
			this.theColor = Color.YELLOW;
			break;
		case MINE:
			this.name = "M";
			this.theColor = Color.BLACK;
			break;
		case WATER:
			this.name = "W";
			this.theColor = Color.BLUE;
			break;
		case SWAMP:
			this.name = "S";
			this.theColor = Color.GRAY;
			break;
		case PLAIN:
			this.name = "P";
			this.theColor = Color.GREEN;
			break;
		case FOREST:
			this.name = "T";
			this.theColor = new Color(0x004d00);
			
			break;
		case CASTLE:
			this.name = "C";
			this.theColor = Color.PINK;
			break;
		case BLANK:
			 this.name = "B";
			this.theColor = Color.WHITE;
			 break;
		case OUTOFBOUNDS:
			this.name = "X";
			break;

		}
	}
	
	public Color getColor() {
		return this.theColor;
	}

	public String getName() {
		return this.name;
	}

	public void setCrowns(int crowns) {
		this.crowns = crowns;
	}

	public int getCrowns() {
		return this.crowns;
	}

	public String getCrownsString() {
		return Integer.toString(this.crowns);
	}
	public boolean isScoredYet() {
		return scoredYet;
	}
	public void setScoredYet(boolean scoredYet) {
		this.scoredYet = scoredYet;
	}
	
	

}
