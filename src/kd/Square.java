package kd;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.*;

//this class represents the Squares that make up each individual domino (2 per domino). Each Square has a terrain type, and a number of crowns (0, 1, 2 or 3)
public class Square extends Rectangle{
	
	private int crowns;
	
	private String name;
	private Color theColor;
	
	
	public enum TerrainType {
		FARM, MINE, WATER, SWAMP, PLAIN, FOREST;
	}
	
	public Square()
	{
		
	}
	public Color getColor(){
		return this.theColor;
	}
	
	
	public Square(TerrainType terrainType){
	
		switch (terrainType) {
		case FARM:
			this.name ="Farm";
			this.theColor = Color.YELLOW;
			break;
		case MINE:
			this.name = "Mine";
			this.theColor = Color.BLACK;
			break;
		case WATER:
			this.name = "Water";
			this.theColor = Color.BLUE;
			break;
		case SWAMP:
			this.name = "Swamp";
			this.theColor = Color.GRAY;
		    break;
		case PLAIN: 
			this.name = "Plain";
			this.theColor = Color.GREEN;
		    break;
		case FOREST:
			this.theColor = new Color(0x004d00);
			this.name = "Forest";
			
			
		}
	}
	public String getName(){
		return this.name;
	}
	public void setCrowns(int crowns){
		this.crowns = crowns;
	}
	public int getCrowns(){
		return this.crowns;
	}
	public String getCrownsString(){
		return Integer.toString(this.crowns);
	}
	
	
	
	
	
}
