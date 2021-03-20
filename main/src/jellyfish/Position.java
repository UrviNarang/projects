package jellyfish;

public class Position {
	private int xCood;
	private int yCood;
	public Position(int xCood, int yCood) {
		super();
		this.xCood = xCood;
		this.yCood = yCood;
	}
	public int getxCood() {
		return xCood;
	}
	public void setxCood(int xCood) {
		this.xCood = xCood;
	}
	public int getyCood() {
		return yCood;
	}
	public void setyCood(int yCood) {
		this.yCood = yCood;
	}
	
	public boolean equals(Position pos)
	{
		if(this.xCood==pos.xCood && this.yCood==pos.yCood)
			return true;
		else
			return false;
					
	}

}
