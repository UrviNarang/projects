package jellyfish;

public class FishPosition extends Position {

	Direction orientation;
	public FishPosition(int xCood, int yCood,Direction orientation) {
		super(xCood, yCood);
		this.orientation=orientation;
		// TODO Auto-generated constructor stub
	}
	public void set(FishPosition pos)
	{
		this.setxCood(pos.getxCood());
		this.setyCood(pos.getyCood());
		this.setOrientation(pos.getOrientation());
	}
	public Direction getOrientation() {
		return orientation;
	}
	public void setOrientation(Direction orientation) {
		this.orientation = orientation;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str;
		str=""+getxCood()+getyCood()+orientation;
		return str;
	}
	
	
	
}
