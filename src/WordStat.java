


public class WordStat extends Statistics {
	enum State{
		Init,
		CountingChar,
		Skip
	}
	
	State state=State.Init;
	
	public void  Stat(char c) {
		//if(c=='\r'||c=='\n')return ;
		//count++;
		
		switch(state)
		{
		
		case Init:
		{
			if(TestValid(c))
			{
				count++;
				state=State.CountingChar;
			}
			break;
		}
		case CountingChar:
		{
			if(TestValid(c))
			{
				break;
			}
			else
			{
				state=State.Skip;
				break;
			}
		
		}
		case Skip:
		{
			if(TestValid(c))
			{
				count++;
				state=State.CountingChar;
			}
			break;
		}
		
		
		default:
			break;
		
		}
		
		
		
		//System.out.println(count);
	}
	boolean TestValid(char c)
	{
		if(c==' '||c=='\r'||c=='\n'||c==','||c=='\t')
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}
