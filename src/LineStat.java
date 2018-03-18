
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
