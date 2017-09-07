package kd;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;

//this class represents the Squares that make up each individual domino (2 per domino). Each Square has a terrain type, and a number of crowns (0, 1, 2 or 3)
public class Square {
	
	private int crowns;
	
	private String name;
	
	
	public enum TerrainType {
		FARM, MINE, WATER, SWAMP, PLAIN, FOREST;
	}
	
	public Square()
	{
		
	}
	
	
	public Square(TerrainType terrainType){
	
		switch (terrainType) {
		case FARM:
			this.name ="Farm";
			break;
		case MINE:
			this.name = "Mine";
			break;
		case WATER:
			this.name = "Water";
			break;
		case SWAMP:
			this.name = "Swamp";
		    break;
		case PLAIN: 
			this.name = "Plain";
		    break;
		case FOREST:
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
	
	
	
}
