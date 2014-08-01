package javacodes;

public class FixedRateGuesser implements ColumnGuesser {
	String regexRate = "[0-9]{0,2}\\.[0-9]+%?";
	
	@Override
	public String[] getVal2Compare() {
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
   	  		
   	  		String[] mRate=null;
   	  		for(int i=0; i< strArray.length; i++){
   	  			if (strArray[i].matches(regexRate)){
   	  				mRate[i] = strArray[i];  
   	  			}
   	  		}return mRate;
   	  	}
	}

	@Override
	public String guessColumn() {
		// Determine fixed rate between selected rates
		String mMax = "";
		for (int j=0; j< mRate.length; j++){
		      if(mRate[j] > mMax)
		    	  mMax = mRate[j];
		      else 
		    	  mMax = mMax;
		}
		return mMax
	}
}
