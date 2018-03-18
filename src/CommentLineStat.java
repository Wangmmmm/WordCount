
public class CommentLineStat extends LineStat {

	
	public void LineOver()
	{
		
		
		
		if(IsOneSingleCharCommentLine()||IsOnlyContainComment())
		{count++;	}
			
		//System.out.println(currentLine);	
		//System.out.println(GetValidPos(0));		
		currentLine="";
	}

	
	
}
