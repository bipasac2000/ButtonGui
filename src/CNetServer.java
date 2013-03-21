
class CNetServer implements ServerFace {  
/* this is how the server looks if you want the server
	to live over the net as a separate process
*/															
	NetProxy net; 
	
	CNetServer(int id){
		if (id == 1)
			net = new NetProxy("127.0.0.1", 9876, false); // port 9876 is for prime
		else if (id == 2)
			net = new NetProxy("127.0.0.1", 9877, false); // port 9877 is for odd 
	}
																
   public String handle (int input, int id) {
	   net.sendMessage("handle");
		net.sendMessage(input, id);
		return net.getMessage();
	}	
}
