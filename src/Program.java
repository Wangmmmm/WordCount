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
	           
	             // һ�ζ�һ���ַ�
	             reader = new InputStreamReader(new FileInputStream(file));
	             int tempchar;
	             while ((tempchar = reader.read()) != -1) {
	                 // ����windows�£�\r\n�������ַ���һ��ʱ����ʾһ�����С�
	                 // ������������ַ��ֿ���ʾʱ���ỻ�����С�
	                 // ��ˣ����ε�\r����������\n�����򣬽������ܶ���С�
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
	         
	    	
	    	
	    	System.out.println("����������Ϸ�");return;
	    	
	    	
	    	
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
	
	
	
	
	//���������ַ����������Ƿ����ĳ�ַ���
	static boolean StringsContain(String[] ss,String s)
	{
		for(int i=0;i<ss.length;i++)
		{
			if(ss[i].equals(s)){return true;}
		}
		return false;
	}
	
}
