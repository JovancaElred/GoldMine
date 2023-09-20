package GoldMine;

public class piece {
	
	private int posx, posy;
	private char icon;
	
	public piece(int posx, int posy, char icon) {
		super();
		this.posx = posx;
		this.posy = posy;
		this.icon = icon;
	}

	public int getPosx() {
		return posx;
	}

	public void setPosx(int posx) {
		this.posx = posx;
	}

	public int getPosy() {
		return posy;
	}

	public void setPosy(int posy) {
		this.posy = posy;
	}

	public char getIcon() {
		return icon;
	}

	public void setIcon(char icon) {
		this.icon = icon;
	}
	
	
}
