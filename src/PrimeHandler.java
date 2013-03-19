public class PrimeHandler extends Handler{
	
	ServerProxy PP = new ServerProxy (); 
	
	public void process (int input) {
		popUp(PP.handle(input, 1)); 
	}

}
