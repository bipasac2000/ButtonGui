
public class OddHandler extends Handler{
	
	ServerProxy OP = new ServerProxy(); 
	
	public void process (int input) {
		popUp(OP.handle(input, 2)); 
	}
}
