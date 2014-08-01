package javacodes;

import java.util.ArrayList;

public class DeliveryDateGuesser implements ColumnGuesser {
	String regexDates = "((\\d){1,4}-(\\d){1,4}-(\\d){1,4})|((\\d){1,4}/(\\d){1,4}/(\\d){1,4})";
	@Override
	public String[] getVal2Compare() {
		// Select Date columns to be compared
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
   	  		
   	  		String[] dates=null;
   	  		for(int i=0; i< strArray.length; i++){
   	  			if (strArray[i].matches(regexDates)){
   	  				dates[i] = strArray[i];
   	  			}
   	  		}return dates;
   	  	}
	}

	@Override
	public String guessColumn() {
		// Determine delivery date among selected dates
		String mMax = "";
		for (int j=0; j< dates.length; j++){
		      if(mRate[j] > mMax)
		    	  mMax = dates[j];
		      else 
		    	  mMax = dates[j+1];
		}
		return mMax;
	}
	

}
