
class CNetServer implements ServerFace {  
/* this is how the server looks if you want the server
	to live over the net as a separate process
*/															
	//NetProxy net = new NetProxy("152.23.22.93", 9876, false); // false means client side	
	NetProxy net = new NetProxy("127.0.0.1", 9876, false); // false means client side
																
   public String handle (int input, int id) {
	   net.sendMessage("handle");
		net.sendMessage(input, id);
		return net.getMessage();
	   //return "server got: "+msg;
	}	
}
