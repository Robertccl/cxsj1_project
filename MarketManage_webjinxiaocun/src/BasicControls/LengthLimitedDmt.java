package BasicControls;

//import java.awt.*;
//import java.awt.event.*;
//import java.util.*;
//import javax.swing.*;
import javax.swing.text.*;

public class LengthLimitedDmt extends PlainDocument{
   private int limit; 
   
   public LengthLimitedDmt(int limit) 
   {
	   super();
       this.limit = limit;
    }  
   public void insertString(int offset, String  str, AttributeSet attr)
       throws BadLocationException {   
       if (str == null)
       {
        return;
       }
       if ((getLength() + str.length()) <= limit)
       {
       
	      char[] upper = str.toCharArray();
          super.insertString(offset, new String(upper,0,upper.length), attr);
      }
   }
	
}
