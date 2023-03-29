package lab;

public class TextLine implements TextBlock {
	  
	  String line;

	  public TextLine(String line) {
	    this.line = line;
	  } 

	  public String GetTextFromrow(int i) throws Exception {
	    if (i != 0) {
	      throw new Exception("Invalid row " + i);
	    }
	    return this.line;
	  } 

	 
	  public int height() {
	    return 1;
	  } 

	  
	  public int width() {
	    return this.line.length();
	  }
	  public double getArea(){
		  return this.line.length();
	  }


}
