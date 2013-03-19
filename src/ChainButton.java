
public class ChainButton {
	
	private static PrimeHandler PH = new PrimeHandler();  
	private static OddHandler OH = new OddHandler(); 
	private static EvenHandler EH = new EvenHandler(); 
	
	static class Prime {
		static boolean isPrime(int n) {
			if (n==1) return false; 
			if (n==2) return true; 
	    //check if n is a multiple of 2
	    if (n%2==0) return false;
	    //if not, then just check the odds
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
	}
	
	static class Processor {
  
    private Processor next;  
    int id;
    
    Processor(int i){
    	next = null; 
    	id = i; 
    }
    
    public void add(Processor nextP){
    	if (next != null) next.add( nextP);
      else {next = nextP;}
    }
    
    public void handle( int input ) { 
    	if (Prime.isPrime(input) && id == 1)
    		PH.process(input);  
    	else if (input%2 !=0 && id == 2)
    		OH.process(input);  
    	else if (input%2 == 0 && id == 3)
    		EH.process(input); 
    	else
    		next.handle(input);
    	}
   }  

 static public Processor setUpChain(int num) {
    Processor root = new Processor(1); 
    for (int i=2; i <= num; i++) root.add( new Processor(i));
    return root;
 }
}
