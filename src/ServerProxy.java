import java.util.Date;
import java.util.Hashtable;

// Purpose.  Proxy design pattern
// 1. Create a "wrapper" for a remote, or expensive, or sensitive target
// 2. Encapsulate the complexity/overhead of the target in the wrapper
// 3. The client deals with the wrapper
// 4. The wrapper delegates to the target
// 5. To support plug-compatibility of wrapper and target, create an interface

// the server will have a proxy to talk to sockets
// it also implements the same interface as the proxy the client talks to


class ServerProxy implements ServerFace {
/* intercepts calls to the server and decides whether to contact 
	the server or just manage the call itself
*/
	
	class Field{
		long previousTime; 
		String result; 
		Field (long p, String r){
			previousTime = p; 
			result = r;
		}
	}
	Hashtable <Integer, Field> oddResults = new Hashtable <Integer, Field>(); 
  ServerFace CNetSrv; // the target... this one remote
  ServerFace SimpleSrv; // the target... this one local
  ServerProxy(int id){
  	if (id == 3)
  		SimpleSrv = new Server(); 
  	else 
  		CNetSrv = new CNetServer(id); 
  }
  
  public String handle (int input, int id) {
  	if (id == 1){
  		return CNetSrv.handle(input, id)+" : result was computed remotely"; 
  	}
    else if (id ==2){
    	Date date = new Date(); 
    	long time = date.getTime(); 
    	if (oddResults.containsKey(input)){
    		long pTime = oddResults.get(input).previousTime; 
    		if (time-pTime < 30000){
    			System.out.println(time-pTime); 
    			oddResults.get(input).previousTime = time;
    			return oddResults.get(input).result+" : result was obtained from local cache";
    		}
    		else {
    			oddResults.get(input).result = CNetSrv.handle(input, id);
    			oddResults.get(input).previousTime = time; 
    			return (oddResults.get(input).result)+" : result was computed remotely"; 
    		}
    	}
    	else {
    		Field newF = new Field(time, CNetSrv.handle(input, id));
    		oddResults.put(input, newF);
    		return (newF.result)+" : result was computed remotely"; 
    	}
    }
    else if (id == 3)
    	if (input%6 == 0)
    		return "Divisible by 6: -1 : proxy rejected the request"; 
    	else 
    		return SimpleSrv.handle(input, id) + " : result was computed locally";    // wrapper delegates to the target	
  	return "id not found"; 
    
  }	
}








