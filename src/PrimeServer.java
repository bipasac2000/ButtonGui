
public class PrimeServer {
	
	public static void main( String[] args ) {
		 SSNetClient demo = new SSNetClient(9876); // port number 9876 is for prime
		 ServerFace srv = new Server();
		 
	   demo.start(srv); 
		 System.out.println("server is finished");
		                              	  
	  }  

}
