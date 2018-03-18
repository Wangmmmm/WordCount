
public class LineStat extends Statistics {
 protected String currentLine;
	//子类需要调用初始化函数
	public LineStat()
	{
	
		currentLine=new String();
	}
	//统计行数的接口方法，不需要子类重写
	public void  Stat(char c) {
		if(c=='\r'||c=='\n')
			LineOver();
		else {
			currentLine+=c;
		}
	}
	//子类需要重写维护currentLine
	public void LineOver()
	{
		currentLine="";
		count++;
	}
	//在输入结束后再加一行，不需要子类重写
	public	int GetCount()
	{
		LineOver();
		return super.GetCount();
	}
	
	protected int GetValidPos(int beginIndex)
	{
		
		if(beginIndex>=currentLine.length())return -1;
		
		for(int i=beginIndex;i<currentLine.length();i++)
		{
			if( TestValid(currentLine.charAt(i)))continue;
			return i;
		}
		
		return -1;
	}
	
	
	
	boolean TestValid(char c)
	{
		if(c==' '||c=='\t')
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}
