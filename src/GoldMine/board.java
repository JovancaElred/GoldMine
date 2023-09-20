package GoldMine;

import java.util.ArrayList;

public class board {
	
	private int size;
	private char[][] boardMap;
	private player p;
	private gold g;
	private ArrayList<gold> goldList; 
	
	
	public int nGold, currGold;
	
	
	public board(int size) {
		this.size = size;
		boardMap = new char[size][size];
		
		generateBoard();
	}
	
	public void generateBoard() {
		//generate border
		for(int i = 0; i < size;i++) {
			for(int j = 0; j < size;j++) {
				if(i == 0 || i == size-1 || j ==0 || j == size-1) {
					boardMap[i][j] = '=';
				}
				else {
					boardMap[i][j] = ' ';
				}
			}
		}
		//generate player
		p = new player(1,1,'P');
		boardMap[p.getPosy()][p.getPosx()] = p.getIcon();//untuk insert player ke board
		//generate gold
		nGold = size/2;
		currGold = 0;
		int x = -1;
		int y = -1;
		goldList = new ArrayList<>();
		boolean isSame = false;
		while(currGold < nGold) {
			//generate random coordinate for golds
			do {
				isSame = false;
				x = (int) (1 + Math.random() * ((size-1) -1));
				y = (int) (1 + Math.random() * ((size-1) -1));
				
				//Loop for each goldList
				for (gold g : goldList) {
					//check if there is any gold that has same position
					if(g.getPosy() == y && g.getPosx() == x) {
						isSame = true;
						break;
					}
				}
			}while(isSame == true || (x == 1 && y == 1));
			g = new gold(x,y,'G');
			goldList.add(g);
			boardMap[g.getPosy()][g.getPosx()] = g.getIcon();
			currGold++;
		}
	}
	
	public void displayBoard() {
		for(int i = 0; i < size;i++) {
			for(int j = 0; j < size;j++) {
				System.out.print(boardMap[i][j]);
			}
			System.out.println();
		}
	}
	
	public void move(char input) {
		boardMap[p.getPosy()][p.getPosx()] = ' ';
		switch (input) {
		case 'w':
			if(boardMap[p.getPosy()-1][p.getPosx()]!= '=') {
				p.setPosy(p.getPosy()-1);
			}

			break;
		case 'a':
			if(boardMap[p.getPosy()][p.getPosx()-1]!= '=') {
				p.setPosx(p.getPosx()-1);
			}
			break;
		case 's':
			if(boardMap[p.getPosy()+1][p.getPosx()]!= '=') {
				p.setPosy(p.getPosy()+1);
			}
			break;
		case 'd':
			if(boardMap[p.getPosy()][p.getPosx()+1]!= '=') {
				p.setPosx(p.getPosx()+1);
			}
			
			break;
		}
		//check if player collide with gold
		if(boardMap[p.getPosy()][p.getPosx()] == 'G') {
			currGold -=1;
		}
		
		boardMap[p.getPosy()][p.getPosx()] = p.getIcon();
	}
}
