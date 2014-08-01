package javacodes;

public class FloatingRateGuesser implements ColumnGuesser {
		String regexRate = "[0-9]{0,2}\\.[0-9]+%?";

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
		// Determine Floating Rate between selected rates
		String mMin = "";
		for (int j=0; j< mRate.length; j++){
		      if(mRate[j] < mMin)
		    	  mMin = mRate[j];
		      else 
		    	  mMin = mMin;
		}
		return mMin;
	}

}
