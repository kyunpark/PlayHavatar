package javacodes;

public class FixedRateGuesser implements ColumnGuesser {
	String regexRate = "[0-9]{0,2}\\.[0-9]+%?";
	
	@Override
	public String getVal2Compare() {
		// Select rate columns to be compared
   	  
   	  	HTable table = new HTable(config, "duco_test");		    	  
   	  
   	  	String[] strArray=null;
	    String ss;
	    int count =0;
   	  	while((ss=reader.readLine()) != null){
   	  		strArray= ss.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"); 
   	  		//splitting-a-comma-separated-string-but-ignoring-commas-in-quotes
   		  
   	  		for(int i=0; i< strArray.length; i++){
   	  			strArray[i].trim();
   	  		}
   	  		
   	  		String mRate="";
   	  		for(int i=0; i< strArray.length; i++){
   	  			if (strArray[i].matches(regexRate)){
   	  				mRate = strArray[i];  
   	  			}
   	  		}return mRate;
   	  	}
	}

	@Override
	public int guessColumn(mRate) {
		// Determine fixed rate between selected rates
		for (int j=0; j< mRate.length; j++){
		      if(mRate[j] > mRate[j+1])
		    	  return mRate[j];
		      else 
		    	  return mRate[j+1];
		}
	}
}