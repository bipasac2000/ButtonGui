public class PrimeHandler extends Handler{
	
	ServerProxy PP = new ServerProxy (1); 
	
	public void process (int input) {
		popUp(PP.handle(input, 1)); 
	}

}
