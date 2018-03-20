package Custom;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import StatMethod.*;
public class InputHandler {
	String[] inputStrings;
	String defaltOutputFile="result.txt";
	
	
	
	public InputHandler(String[] s)
	{
		inputStrings =s;
		SetStopList();
	}
	private void SetStopList()
	{
		WordStat.stopList=new ArrayList<String>();
		int index=StringsContain("-e");
		if(index==-1)return;
		if(inputStrings.length<=index+1)return;
		
		String fileName=inputStrings[index+1];
		
		WordStateIgnoreComma stater=new WordStateIgnoreComma();
		
		File file=new File(fileName);
		   Reader reader = null;
	         try {
	           
	             // 一次读一个字符
	             reader = new InputStreamReader(new FileInputStream(file));
	             int tempchar;
	             while ((tempchar = reader.read()) != -1) {
	                 // 对于windows下，\r\n这两个字符在一起时，表示一个换行。
	                 // 但如果这两个字符分开显示时，会换两次行。
	                 // 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
	                 if (((char) tempchar) != '\r') {
	                	 
	                	 stater.Stat((char)tempchar);
	                	 
	                 }
	             }
	             
	             WordStat.stopList=stater.GetString();
	             reader.close();
	         } catch (Exception e) {
	             e.printStackTrace();
	         }
		
		
	}
	
	
	public String GetOutputFile()
	{
		int index=StringsContain("-o");
		if(index==-1)return defaltOutputFile;
		
		if(inputStrings.length>(index+1))
		{
			return inputStrings[index+1];
		}
		
		return "";
	}
	 boolean statC=false;
	 boolean statW=false;
	 boolean statL=false;
	 boolean statA=false;
	 ArrayList<Statistics> stats;
	public ArrayList<Statistics> GetStatMethods()
	{
		 stats=new ArrayList<Statistics>();
		   if(StringsContain("-c")!=-1)
		   {
			   stats.add(new CharacterStat());
			   statC=true;
			   
		   }
		   if(StringsContain("-w")!=-1)
		   {
			   stats.add(new WordStat());
			   statW=true;
		   }
		   if(StringsContain("-l")!=-1)
		   {
			   stats.add(new LineStat());
			   statL=true;
		   }
		   if(StringsContain("-a")!=-1)
		   {
			   stats.add(new CodeLineStat());
			   stats.add(new NullLineStat());
			   stats.add(new CommentLineStat());
			   statA=true;
		   }
		   return stats;
	}
	public String Print(String fileName)
	{
		String s="";
		
		int index=0;
		if(statC) {s+=(fileName+"," + stats.get(index).GetMethodName()+":"+stats.get(index++).GetCount()+"\r\n");}
		if(statW) {s+=(fileName+"," + stats.get(index).GetMethodName()+":"+stats.get(index++).GetCount()+"\r\n");}
		if(statL) {s+=(fileName+"," + stats.get(index).GetMethodName()+":"+stats.get(index++).GetCount()+"\r\n");}
		
		if(statA) {
				
			
				String  methodNames="代码行/空行/注释行:";
				String counts=String.valueOf(stats.get(index++).GetCount())+"/"+String.valueOf(stats.get(index++).GetCount())
				+"/"+String.valueOf(stats.get(index++).GetCount());
				s+=(fileName+","+methodNames+counts+"\r\n");
				
		}
		
		return s;
	}
	String outputMessage="";
	public void BuildOutPutString(String inputfileName)
	{
		
		outputMessage+=Print(inputfileName);
		for(int i=0;i<stats.size();i++)
		{
			stats.get(i).Reset();
		}
	}
	
	public String GetOutputMessage()
	{
		return outputMessage;
	}
	
	 public ArrayList<File> GetInputFile()
	{
		int i=1;
		for(;i<inputStrings.length;i++)
		{
			if(!IsStatCommand(inputStrings[i]))
				break;
		}
		
		
		String filePath=inputStrings[i];
		String  absoluteFileRootPath="";
		if(filePath.contains(":"))
		{
			int index= filePath.lastIndexOf('\\');
			absoluteFileRootPath=filePath.substring(0, index);
			filePath=filePath.substring(index+1);
		}
		//System.out.println(absoluteFileRootPath+'\\'+filePath);
		
		File[]fileArray ;
		ArrayList<File> files=new ArrayList<File>();
		File rootFile;
		if(StringsContain("-s")!=-1)
		{
			String format=filePath.substring(filePath.indexOf('.'));
			if(absoluteFileRootPath=="")
			{
				rootFile=new File("./");
			}
			else {
				rootFile=new File(absoluteFileRootPath);
			}
			fileArray=rootFile.listFiles();
			if(fileArray.length==0)return null;
			
			SetAllFile(fileArray,files,format);
		}
		else 
		{
			if(absoluteFileRootPath=="")
			{
				files.add(new File(filePath));
			}
			else
			{
				files.add(new File(absoluteFileRootPath+'\\'+filePath));
			}
		}
		
		return files;
	}
	 void SetAllFile(File[] files,ArrayList<File> filelist,String format)
	 {
		 if(files.length==0)return ;
		 for(int j=0;j<files.length;j++)
			{
				
				if(files[j].getName().endsWith(format))
				{
					filelist.add(files[j]);
				}
				else if(files[j].isDirectory())
				{
					SetAllFile(files[j].listFiles(),filelist,format);
				}
			}
	 }
	 
	 int StringsContain(String s)
		{
			for(int i=0;i<inputStrings.length;i++)
			{
				if(inputStrings[i].equals(s)){return i;}
			}
			return -1;
		}
	 boolean IsStatCommand(String s)
	 {
		 if(s.equals("-s")||s.equals("-w")||s.equals("-c")||s.equals("-l")||s.equals("-a"))
		 {
			 return true;
		 }
		 return false;
	 }
	 boolean IsStopListCommand(String s)
	 {
		 if(s.equals("-e"))return true;
		 return false;
	 }
}
