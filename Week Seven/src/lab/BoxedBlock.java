package lab;

import java.util.Collections;

public class BoxedBlock implements TextBlock{
	  
	  
	  TextBlock contents;

	  public BoxedBlock(TextBlock contents) {
	    this.contents = contents;
	  } 

	 
	  public String GetTextFromrow(int i) throws Exception {
	  
		int h = this.contents.height();
	    
	    if ((i == 0) || (i == h+1) ) {
	      return "*" + buildTheBorder(this.contents.width()) + "*";
	    }
	   
	    else if ((i > 0) && (i <= h)) {
	      return "*" + this.contents.GetTextFromrow(i-1) + "*";
	    }
	   
	    else {
	      throw new Exception("Invalid row " + i);
	    }
	  } 

	  
	  public int height() {
	    return 2 + this.contents.height();
	  } 

	   public int width() {
	    return 2 + this.contents.width();
	  } 
	 
	  String buildTheBorder(int len) {
		  return String.join("", Collections.nCopies(len, "*"));
	  }

	  public double getArea(){
		  return (height() * width());
	  }


}