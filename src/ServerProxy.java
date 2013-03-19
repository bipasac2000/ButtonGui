import java.util.Date;
import java.util.Hashtable;

// Purpose.  Proxy design pattern
// 1. Create a "wrapper" for a remote, or expensive, or sensitive target
// 2. Encapsulate the complexity/overhead of the target in the wrapper
// 3. The client deals with the wrapper
// 4. The wrapper delegates to the target
// 5. To support plug-compatibility of wrapper and target, create an interface

//import java.io.*;   
//import java.net.*;

// the server will have a proxy to talk to sockets
// it also implements the same interface as the proxy the client talks to


class ServerProxy implements ServerFace {
/* intercepts calls to the server and decides whether to contact 
	the server or just manage the call itself
*/
	
	ServerProxy(){}
	class Field{
		long previousTime; 
		String result; 
		Field (long p, String r){
			previousTime = p; 
			result = r;
		}
	}
	Hashtable <Integer, Field> oddResults = new Hashtable <Integer, Field>(); 
  ServerFace CNetSrv = new CNetServer();   // the target... this one remote
  ServerFace SimpleSrv = new Server();    // the target... this one local
  
  
  public String handle (int input, int id) {
  	if (id == 1){
  		return CNetSrv.handle(input, id);
  		//return SimpleSrv.handle(input, id); 
  	}
    else if (id ==2){
    	Date date = new Date(); 
    	long time = date.getTime(); 
    	if (oddResults.containsKey(input)){
    		long pTime = oddResults.get(input).previousTime; 
    		if (time-pTime < 30000){
    			System.out.println(time-pTime); 
    			oddResults.get(input).previousTime = time;
    			return oddResults.get(input).result;
    		}
    		else {
    			oddResults.get(input).result = CNetSrv.handle(input, id);
    			//oddResults.get(input).result = SimpleSrv.handle(input, id);
    			oddResults.get(input).previousTime = time; 
    			return (oddResults.get(input).result); 
    		}
    	}
    	else {
    		Field newF = new Field(time, CNetSrv.handle(input, id));
    		//Field newF = new Field(time, SimpleSrv.handle(input, id));
    		oddResults.put(input, newF);
    		return (newF.result); 
    	}
    }
    else if (id == 3)
    	if (input%6 == 0)
    		return "Divisible by 6: -1"; 
    	else 
    		return SimpleSrv.handle(input, id);    // wrapper delegates to the target	
  	return "id not found"; 
    
  }	
}








