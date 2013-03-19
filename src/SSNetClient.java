class SSNetClient {
	
	public void start(ServerFace srv) {
	  NetProxy net = new NetProxy("152.23.22.93", 9876, true);// true means server side
	  String method, param;
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
