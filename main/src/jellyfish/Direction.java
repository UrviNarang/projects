package jellyfish;
/**
 * add enum value in order to define more directions
 * @author DELL
 *
 */
public enum Direction {

	N(0,0,1),E(90,1,0),S(180,0,-1),W(270,-1,0);
	private int degrees;
	private int moveX;
	private int moveY;
	private Direction(int degrees, int moveX, int moveY) {
		this.degrees = degrees;
		this.moveX = moveX;
		this.moveY = moveY;
	}
	public int getDegrees() {
		return degrees;
	}
	public int getMoveX() {
		return moveX;
	}
	public int getMoveY() {
		return moveY;
	}
	
	public static Direction getDirection(int degrees)
	{
		//System.out.println("deg="+degrees);
		while(degrees<0)
			degrees=degrees+360;
		
		while(degrees>=360)
			degrees=degrees-360;
		Direction[] directions=Direction.values();
		for(Direction dir:directions)
		{
			if(degrees==dir.degrees)
				return dir;
		}
		System.out.println("Invalid DIrection");
		return Direction.N;
		
	}
}
