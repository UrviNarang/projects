package jellyfish;
import java.util.ArrayList;
//Singleton class
public class JellyFishTank {
	
	private static ArrayList<Position> tankWall;
	private static Position topRightPosition;
	
	private static JellyFishTank fishTank=new JellyFishTank();
	private JellyFishTank()
	{
		tankWall=new ArrayList<Position>();
	}
	public static void setTopRightPosition(Position pos)
	{
		topRightPosition=pos;
		
	}	
	public static boolean isJellyFishLost(JellyFish jellyFish)
	{
		return !Utility.isBounded(jellyFish.currPos, topRightPosition);
	}
	public static void leaveScent(JellyFish jellyFish) {
		// TODO Auto-generated method stub
		tankWall.add(jellyFish.lastPos);
	}
	public static boolean hasJellyFishReachedTheGrid(JellyFish jellyFish) {
		// TODO Auto-generated method stub
		for (Position position : tankWall) {
			if(position.equals(jellyFish.currPos))
				return true;			
		}
		return false;
	}
}
