package kd;

import kd.Square.TerrainType;

public class BoardData {

	private Domino[] dominoSet = new Domino[48];
	
	public void setUpBoard(){
		for (int i = 0; i< dominoSet.length; i++){
			System.out.println(i);
			dominoSet[i] = new Domino();
			if (i==0 || i==1 || i==12 || i==13 || i==14||i==15||i==18||i==19||i==20||i==21||i==22||i==35||i==37||i==40||i==42||i==47){
				dominoSet[i].setLeft(new Square(TerrainType.FARM));
			}
			if (i==0||i==1||i==23||i==24||i==25||i==26||i==29||i==30||i==39||i==44){
				dominoSet[i].setRight(new Square(TerrainType.FARM));
			}
			if(i==2||i==3||i==4||i==5||i==16||i==17||i==23||i==24||i==25||i==26||i==27||i==28){
				dominoSet[i].setLeft(new Square(TerrainType.FOREST));
			}
			if (i==2||i==3||i==4||i==5||i==12||i==18||i==31||i==32||i==33||i==34){
				dominoSet[i].setRight(new Square(TerrainType.FOREST));
			}
			if (i==6||i==7||i==8||i==29||i==30||i==31||i==32||i==33||i==34||i==36||i==41){
				dominoSet[i].setLeft(new Square(TerrainType.WATER));
			}
			if(i==6||i==7||i==8||i==13||i==16||i==19||i==27){
				dominoSet[i].setRight(new Square(TerrainType.WATER));
			}
			if(i==9||i==10||i==38||i==43){
				dominoSet[i].setLeft(new Square(TerrainType.PLAIN));
			}
			if(i==9||i==10||i==14||i==17||i==20||i==28||i==35||i==36||i==40||i==41){
				dominoSet[i].setRight(new Square(TerrainType.PLAIN));
			}
			if(i==11||i==45||i==46){
				dominoSet[i].setLeft(new Square(TerrainType.SWAMP));
			}
			if(i==11||i==15||i==21||i==37||i==38||i==42||i==43){
				dominoSet[i].setRight(new Square(TerrainType.SWAMP));
			}
			if(i==39||i==44){
				dominoSet[i].setLeft(new Square(TerrainType.MINE));
			}
			if(i==22||i==45||i==46||i==47){
				dominoSet[i].setRight(new Square(TerrainType.MINE));
			}
			if(i>= 0 && i<=17){
				dominoSet[i].setLeftCrowns(0);
				dominoSet[i].setRightCrowns(0);
			}
			if((i>=18 && i<=34)||i==39){
				dominoSet[i].setLeftCrowns(1);
				dominoSet[i].setRightCrowns(0);
				
			}
			if(i>=35 && i<=38){
				dominoSet[i].setLeftCrowns(0);
				dominoSet[i].setRightCrowns(1);
				
			}
			if((i>=40 && i<=43)||i==45||i==46){
				dominoSet[i].setLeftCrowns(0);
				dominoSet[i].setRightCrowns(2);
			}
			if(i==44){
				dominoSet[i].setLeftCrowns(2);
				dominoSet[i].setRightCrowns(0);
			}
			if(i==47){
			
				dominoSet[i].setLeftCrowns(0);
				dominoSet[i].setRightCrowns(3);
			}
			
			
				dominoSet[i].setNumber(i+1);
			
			
		}
		
	}
	
	public static void main(String[] args){
		BoardData yea = new BoardData();
		yea.setUpBoard();
		for (int i = 0; i < yea.dominoSet.length; i++){
		yea.dominoSet[i].printIt();
		System.out.println("");
		}
	}
}
