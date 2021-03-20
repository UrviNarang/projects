package jellyfish;

public class JellyFish {
	FishPosition lastPos;
	FishPosition currPos;
	boolean alarmed;
	FishStatus status;
	String instructionStr;
	
	public JellyFish(FishPosition currPos, String instructionStr) {
		super();
		this.currPos = currPos;
		this.lastPos=new FishPosition(0, 0, Direction.N);
		this.status = FishStatus.LIVE;
		this.instructionStr = instructionStr;
	}

	enum FishStatus{
		LIVE,LOST;
	}
	
	public FishPosition move(/*String instruction*/)
	{
		int instLength=instructionStr.length();
		JellyFishInstruction currInst;
		for(int i=0;i<instLength;i++)
		{
			currInst=JellyFishInstruction.valueOf(instructionStr.substring(i, i+1));
			lastPos.set(currPos);
			currPos=move(/*this.currPos,*/currInst);
			if(JellyFishTank.isJellyFishLost(this))
			{				
				if(alarmed)
				{
					currPos.set(lastPos);//set last position as current
				}
				else 
				{
					JellyFishTank.leaveScent(this);//leaveScent
					status=FishStatus.LOST;
					return currPos;
				}
			}	
			if(JellyFishTank.hasJellyFishReachedTheGrid(this))
			{
				//set Alarm
				alarmed=true;
			}
			else
			{
				//put off alarm
				alarmed=false;
			}
			
		}
		return currPos;
	}
	
	private FishPosition move(/*FishPosition pos,*/ JellyFishInstruction inst)
	{
		int degrees=inst.getAddDegrees(); 
		int finalDegrees;
		if(degrees!=0)
		{
			finalDegrees=currPos.getOrientation().getDegrees()+degrees;
			currPos.setOrientation(Direction.getDirection(finalDegrees));
		}
		if(inst.shouldMove())
		{
			Direction currDirection=currPos.getOrientation();
			currPos.setxCood(currPos.getxCood()+currDirection.getMoveX());
			currPos.setyCood(currPos.getyCood()+currDirection.getMoveY());
		}
		return currPos;
		
			
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str;
		if(status==FishStatus.LIVE)
		str=currPos.toString();
		
		else
		str=lastPos.toString()+"LOST";
		return str;
	}
	
}
