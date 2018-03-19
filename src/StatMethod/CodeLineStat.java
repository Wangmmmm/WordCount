package StatMethod;
public class CodeLineStat extends LineStat {

	public void LineOver()
	{
		if((!IsOnlyContainOneChar())&&GetValidPos(0)!=-1)
		{
			if(!IsOneSingleCharCommentLine()&&! IsOnlyContainComment())
			{count++;}
		}
			
		//System.out.println(currentLine);	
		//System.out.println(GetValidPos(0));		
		currentLine="";
	}
	public String GetMethodName()
	{
		return "´úÂëÐÐ";
	}

}
