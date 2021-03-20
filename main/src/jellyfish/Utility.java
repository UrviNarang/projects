package jellyfish;

public class Utility {

	/**
	 * pos1 is bounded by pos2 i.e., both the co-ordinates of pos1 are lesser than 
	 * corresponding co-ordinated of pos2
	 * @param pos1
	 * @param pos2
	 * @return
	 */
	public static boolean isBounded(Position pos1,Position pos2)
	{
		if((pos1.getxCood()<=pos2.getxCood())&&(pos1.getyCood()<=pos2.getyCood()))
			return true;
		else 
			return false;
	}
}
