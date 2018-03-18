import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
public class Program {
	static String defalOutputFile="result.txt";
	static String outputFile;
	static ArrayList<Statistics> Stats;
	public static void main(String[] args) throws IOException {
	    
		
		Stats=new ArrayList<Statistics>();
		Stats.add(new CodeLineStat());
		
	    if (args.length==0)
	    	{
	    	
	    	
	    	 File file = new File("input.txt");
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
	                	 
	                	 for(int i=0;i<Stats.size();i++)
	                	 {
	                		 Stats.get(i).Stat((char) tempchar);
	                	 }
	                	 
	                	 
	                    
	                 }
	             }
	             for(int i=0;i<Stats.size();i++)
            	 {
      
            		 System.out.print( Stats.get(i).GetCount());
            	 }
	            
	             reader.close();
	         } catch (Exception e) {
	             e.printStackTrace();
	         }
	         
	    	
	    	
	    	System.out.println("输入参数不合法");return;
	    	
	    	
	    	
	    	}
	    
	  

	    
	   if(StringsContain(args,"-s"))
	   {
		   
	   }
	   if(StringsContain(args,"-a"))
	   {
		   
	   }
	   if(StringsContain(args,"-c"))
	   {
		   
	   }
	   if(StringsContain(args,"-w"))
	   {
		   
	   }
	   if(StringsContain(args,"-l"))
	   {
		   
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
