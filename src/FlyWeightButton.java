

import java.awt.*;
import javax.swing.JFrame;

	
	class FlyWeightButton {
	   public static final int NUM = 15;

	   public static void main( String[] args ) {
	      JFrame frame = new JFrame( "Flyweight Demo" );
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.setLayout( new GridLayout( NUM, NUM ) );
	      for (int i=0; i < NUM * NUM; i++)
	            frame.add( FlyWeightFactory.makeButton( Integer.toString(i) ) );
	      frame.pack();
	      frame.setVisible( true );
	}
}

