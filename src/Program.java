import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import StatMethod.*;
import java.io.*;

public class Program {
	static String defalOutputFile="result.txt";
	static String outputFile;
	
	public static void main(String[] args) throws IOException {
	    
	
		//String[] s= {"sad","-w","-c","-l","-a","-s","input.c","-e","stoplist.txt","-o","test.txt"};
		if (args.length<=1) { System.out.println("输入参数不合法");return ;}
		InputHandler input=new InputHandler(args);
		
		ArrayList<Statistics> Stats=input.GetStatMethods();
		
		
		//System.out.println(Stats.size());
		ArrayList<File> files=input.GetInputFile();
		
	
		  
		  
		for(int i=0;i<files.size();i++)
		{
			File file=files.get(i);
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
		                	 
		                	 for(int j=0;j<Stats.size();j++)
		                	 {
		                		 Stats.get(j).Stat((char) tempchar);
		                	 }
		                	 
		                 }
		             }
		           System.out.println(input.Print(file.getName())); 
		            input.BuildOutPutString(file.getName());
		             reader.close();
		         } catch (Exception e) {
		             e.printStackTrace();
		         }
		         
		         String outputFileName=input.GetOutputFile();
		         String message=input.GetOutputMessage();
		         
		         File outFile=new File(outputFileName);
		         
		         FileOutputStream out = null;
		         try {
		             //经过测试：FileOutputStream执行耗时:17，6，10 毫秒
		             out = new FileOutputStream(outFile);
		        
		          
		                 out.write(message.getBytes());
		             
		             out.close();
		         }
		 catch (Exception e) {
	            e.printStackTrace();
	        }
		}
		

	    

	
	
	   
	   return ;

	}
	
	static String[] stopWordList;
	
	
	
	
	//查找输入字符串数组中是否存在某字符串
	static boolean StringsContain(String[] ss,String s)
	{
		for(int i=0;i<ss.length;i++)
		{
			if(ss[i].equals(s)){return true;}
		}
		return false;
	}
	
}
