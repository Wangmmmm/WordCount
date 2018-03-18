
public class CodeLineStat extends LineStat {

	public void LineOver()
	{
		if((!IsOnlyContainOneChar())||GetValidPos(0)==-1)
		count++;
			
			
			
		currentLine="";
	
		
		
	}
	
	boolean IsOnlyContainOneChar()
	{
		if(GetValidPos(0)==-1)return false;
		
		if(GetValidPos(GetValidPos(0)+1)==-1)return true;
		
		return false;
		
	}
}
