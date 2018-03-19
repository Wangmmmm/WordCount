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
		if (args.length<=1) { System.out.println("����������Ϸ�");return ;}
		InputHandler input=new InputHandler(args);
		
		ArrayList<Statistics> Stats=input.GetStatMethods();
		
		
		//System.out.println(Stats.size());
		ArrayList<File> files=input.GetInputFile();
		
	
		  
		  
		for(int i=0;i<files.size();i++)
		{
			File file=files.get(i);
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
		             //�������ԣ�FileOutputStreamִ�к�ʱ:17��6��10 ����
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
