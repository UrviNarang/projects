package jellyfish;

public enum JellyFishInstruction {

	L(-90,false),R(90,false),F(0,true);
	private int addDegrees;
	private boolean move;
	private JellyFishInstruction(int addDegrees, boolean move) {
		this.addDegrees = addDegrees;
		this.move= move;
	}
	public int getAddDegrees() {
		return addDegrees;
	}
	public boolean shouldMove() {
		return move;
	}
	
}

