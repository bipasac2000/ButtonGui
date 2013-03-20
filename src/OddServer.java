
public class OddServer {
	
	public static void main( String[] args ) {
		 SSNetClient demo = new SSNetClient(9877); // port 9877 is for odd
		 ServerFace srv = new Server();
		 
	   demo.start(srv); 
		 System.out.println("server is finished");
		                              	  
	  }  


}
