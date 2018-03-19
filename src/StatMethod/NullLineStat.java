package StatMethod;

public class NullLineStat extends LineStat  {
	
	public void LineOver()
	{
		if((IsOnlyContainOneChar())||GetValidPos(0)==-1)
		{count++;}
			
		//System.out.println(currentLine);	
		//System.out.println(GetValidPos(0));		
		currentLine="";
	}
	public String GetMethodName()
	{
		return "¿ÕÐÐ";
	}
}
