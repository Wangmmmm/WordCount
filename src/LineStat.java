
public class LineStat extends Statistics {
 String currentLine;
	
	public LineStat()
	{
		currentLine=new String();
	}
	public void  Stat(char c) {
		if(c=='\r'||c=='\n')
			LineOver();
		else {
			//currentLine.
		}
	}
	public void LineOver()
	{
		
	}
}
