
public class Server implements ServerFace {  
                                      																									
   public String handle (int input, int id) {
  	 if(id == 1)
  		 return "Square: " + input * input;
  	 else if (id == 2){
  		 return "Multiplied by rand(1, 10): " + input * Math.ceil(Math.random() * 10); 
  	 }
  	 else if (id == 3){
  		 return "Divided by 2: " + input/2; 
  	 }
  	 return ""; 
	}	
}
