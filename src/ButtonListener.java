import java.awt.Button;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



// handler 	
	class ButtonListener implements ActionListener {
		
	   public void actionPerformed( ActionEvent e) {
	      Button      btn  = (Button) e.getSource();
	      Component[] btns = btn.getParent().getComponents();
	      float stuff[] = new float[500];
	      int i = 0;
	      for ( ; i < btns.length; i++)
	         if (btn == btns[i]) break;
	      // 4. A third party must compute the extrinsic state (x and y)
	      //    (the Button label is intrinsic state)
	      System.out.println( "label-" + e.getActionCommand()
	         + "  x-" + i/FlyWeightButton.NUM   + "  y-" + i%FlyWeightButton.NUM );  // 1. Identify extrinsic state
	   }  
	}


