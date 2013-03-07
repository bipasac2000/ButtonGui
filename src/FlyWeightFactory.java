

	
	import java.awt.*;
	import java.awt.event.*;

	class FlyWeightFactory  {
	   private static java.util.Hashtable ht = new java.util.Hashtable();
	   private static ButtonListener bl = new ButtonListener();
	   public static Button makeButton( String num ) {
	      if (ht.containsValue( num ))
	         return (Button) ht.get( num );        // 2. Return an existing object
	      Button btn = new Button( num );          // 1. Identify intrinsic state
	      btn.addActionListener( bl );
	      ht.put( num, btn );
	      return btn;                              // 2. Return a new object
	   }
	   public static void report() {
	      System.out.print( "size=" + ht.size() + "   " );
	      for (java.util.Enumeration e = ht.keys(); e.hasMoreElements(); )
	         System.out.print( e.nextElement() + " " );
	      System.out.println();
	   }  
	}

	



