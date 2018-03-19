package StatMethod;
import java.util.ArrayList;
public class WordStat extends Statistics {
	enum State{
		Init,
		CountingChar,
		Skip
	}
	public static ArrayList<String>  stopList;
	State state=State.Init;
	String currentString="";
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
				if(Ignore(currentString)) {count--;}
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
	
	public	int GetCount()
	{
		if(Ignore(currentString))count--;
		currentString="";
		return super.GetCount();
	}
	boolean Ignore(String s)
	{
		//System.out.println("ºöÂÔ²âÊÔµÄ×Ö·û£º"+s);
		for(int i=0;i<stopList.size();i++)
		{
			if (stopList.get(i).equals(s))
			{
				return true;
			}
		}
		return false;
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
	public String GetMethodName()
	{
		return "µ¥´ÊÊý";
	}
}
