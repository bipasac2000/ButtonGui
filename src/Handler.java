import javax.swing.JFrame;
import javax.swing.JLabel;


public abstract class Handler {
	
	void process(int input){}
	
	public void popUp (String msg){
  	JFrame frame = new JFrame( "Result" );
    //JButton button = new JButton("OK"); 
    frame.add( new JLabel(msg));
    frame.pack();
    frame.setVisible( true );
  }
}
