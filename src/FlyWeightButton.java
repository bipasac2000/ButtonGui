

	import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

	
	class FlyWeightButton {
	   public static final int NUM = 15;
	   public static final int RAN = 10;

	   public static void main( String[] args ) {
	      JFrame frame = new JFrame( "Flyweight Demo" );
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.setLayout( new GridLayout( NUM, NUM ) );
	      for (int i=0; i < NUM * NUM; i++)
	         // for (int j=0; j < NUM; j++)
	            // 3. The client must use the Factory to request objects
	            frame.add( FlyWeightFactory.makeButton( Integer.toString(i) ) );
	      frame.pack();
	      frame.setVisible( true );
	      FlyWeightFactory.report();
	   }  
	}

