package kd;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;
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
