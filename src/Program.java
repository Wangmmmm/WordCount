import java.io.IOException;

public class Program {

	public static void main(String[] args) throws IOException {
	    String outputFile="result.txt";
	    if (args.length==0)
	    	{
	    	System.out.println("输入参数不合法");return;
	    	}
	    else  if(args.length==1)
	    {
	    	if(args[0].equals("-s"))
	    	{
	    		System.out.println("-s");
	    		
	    		return;
	    	}
	    	else 
	    	{
	    		System.out.println("输入参数不合法");return;
	    	}
	    }
	    else if(args.length==2)
	    {
	    	String parameter=args[0];
	  	    String input_file_name=args[1];
	  	    System.out.println(parameter);
	  	    System.out.println(input_file_name);
	  	    return;
	    }
	  
	    else 
	    {
	    	
	    	System.out.println("输入参数不合法");
	    	return;
	    }
	    

	}

}
