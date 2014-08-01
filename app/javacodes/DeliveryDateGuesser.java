package javacodes;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	public String guessColumn(List<Object> row) {
		// Find all the date columns

		
		Collection<Date> dates = dateColumns.values();
		
		Date max = null;
		
		for (Date date : dates) {
			if(max == null) {
				max = date;
				
			} else if (date.after(max)) {
				max = date;
			}
		}
		
		// Determine delivery date among selected dates
		String mMax = "";
		for (int j=0; j< dates.length; j++){
		      if(dates[j] > mMax)
		    	  mMax = dates[j];
		      else 
		    	  mMax = dates[j+1];
		}
		return mMax;
	}
	

}
