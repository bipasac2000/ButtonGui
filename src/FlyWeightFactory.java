import java.awt.*;
import java.util.Hashtable;

	class FlyWeightFactory  {
	   private static Hashtable<String, Button> ht = new Hashtable<String, Button>();
	   private static ButtonListener bl = new ButtonListener();
	   public static Button makeButton( String num ) {
	      if (ht.containsValue( num ))
	         return (Button) ht.get( num );        
	      Button btn = new Button( num );          
	      btn.addActionListener( bl );
	      ht.put( num, btn );
	      return btn;                             
	   }
	}

	



