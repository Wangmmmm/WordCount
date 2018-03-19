package Custom;

import java.util.ArrayList;


public class WordStateIgnoreComma  {
	enum State{
		Init,
		CountingChar,
		Skip
	}
	ArrayList<String> stopList;
	public WordStateIgnoreComma()
	{
		stopList=new ArrayList<String>();
	}
	State state=State.Init;
	
	String currentString="";
	
	
	public void  Stat(char c) {
		switch(state)
		{
		
		case Init:
		{
			if(TestValid(c))
			{
				currentString+=c;
				state=State.CountingChar;
			}
			break;
		}
		case CountingChar:
		{
			if(TestValid(c))
			{
				currentString+=c;
				break;
			}
			else
			{
				stopList.add(currentString);
				currentString="";
				state=State.Skip;
				break;
			}
		
		}
		case Skip:
		{
			if(TestValid(c))
			{
				currentString+=c;
				state=State.CountingChar;
			}
			break;
		}
		
		
		default:
			break;
		
		}
		//System.out.println(count);
	}
	public	ArrayList<String> GetString()
	{
		stopList.add(currentString);
		currentString="";
	    return stopList;
	}
	boolean TestValid(char c)
	{
		if(c==' '||c=='\r'||c=='\n'||c=='\t')
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}
