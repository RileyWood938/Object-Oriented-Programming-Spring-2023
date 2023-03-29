package lab;

//import java.io.PrintWriter;

public class TestInterfaces{
	
	 public static void print(TextBlock block) {
		 
		    System.out.println("Printing a new TextBlock:");
		    for (int i = 0; i < block.height(); i++) {
		     
		      try {
		    	  System.out.println(block.GetTextFromrow(i));
		      } catch (Exception e) {
		    	  System.out.println(e);
		      } 
		    } 
		  } 

	

	   public static void main(String[] args) {
		
		
		
		
		TextLine tl = new TextLine("Polymorphism");
		BoxedBlock tb = new BoxedBlock(new TextLine("Interfaces"));
		BoxedBlock tb2 = new BoxedBlock(new BoxedBlock(tl));
				
		
		print(tl);
		print(tb);
		print(tb2);
		
		
		
	}

}
