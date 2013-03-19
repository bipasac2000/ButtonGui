


public class EvenHandler extends Handler{

  ServerFace EP = new ServerProxy(); 
	public void process(int input) {
		popUp(EP.handle(input, 3)); 
	}

}
