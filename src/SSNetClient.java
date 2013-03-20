class SSNetClient {
	
	private NetProxy net; 
	SSNetClient(int port){
		net = new NetProxy("127.0.0.1", port, true); 
	}
	
	public void start(ServerFace srv) {
	  //NetProxy net = new NetProxy("127.0.0.1", 9876, true);// true means server side
	  String method;
	  while (true) {
	    method = net.getMessage();
		 if (method.equals("handle")) {
		   String[] input = net.getMessage().split(" ");
			System.out.println("  (net SS) server asked to handle... "+ input[0]);
		   net.sendMessage(srv.handle(Integer.parseInt(input[0]), Integer.parseInt(input[1]))); 
		 } 
	  }
	}
	  
}
