package StatMethod;
public class LineStat extends Statistics {
 protected String currentLine;
	//������Ҫ���ó�ʼ������
	public LineStat()
	{
	
		currentLine=new String();
	}
	//ͳ�������Ľӿڷ���������Ҫ������д
	public void  Stat(char c) {
		if(c=='\r'||c=='\n')
			LineOver();
		else {
			currentLine+=c;
		}
	}
	//������Ҫ��дά��currentLine
	public void LineOver()
	{
		currentLine="";
		count++;
	}
	//������������ټ�һ�У�����Ҫ������д
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
			if( !TestValid(currentLine.charAt(i)))continue;
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
	
protected	boolean IsOnlyContainOneChar()
	{
		if(GetValidPos(0)==-1)return false;
		
		if(GetValidPos(GetValidPos(0)+1)==-1)return true;
		
		return false;
		
	}
protected boolean IsOneSingleCharCommentLine()
{
	int index=GetValidPos(0);
	if(index==-1)return false;
	
	if(IsOnlyContainOneChar())return false;
	
	int index2=GetValidPos(index+1);
	if(index2==-1)return false;
	
	
	if(currentLine.charAt(index2)!='/')return false;
	
	if(currentLine.length()==index2+1)return false;
	
	if(currentLine.charAt(index2+1)!='/')return false;
	
	
	return true;
}

boolean IsOnlyContainComment()
{
	int index=GetValidPos(0);
	if(index==-1)return false;
	
	if(currentLine.length()>=index+2)
	{
		//System.out.println(currentLine.charAt(index));
		if(currentLine.charAt(index)=='/'&&currentLine.charAt(index+1)=='/')
			return true;
	}
	
	return false;
}

public void Reset()
{
	super.Reset();
	currentLine="";
}
public String GetMethodName()
{
	return "����";
}
}
