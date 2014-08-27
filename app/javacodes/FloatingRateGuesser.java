package javacodes;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FloatingRateGuesser {

	RowParser parsedRow;
	Row numberOfColumns;

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

	public Map<Integer, String> guessColumn(Row parsedRow) {
		
		Map<Integer, Float> map = parsedRow.getAllFloatColumns();
		Set<Map.Entry<Integer, Float>> set = map.entrySet();
		//Collection of guesses after guessing
		Map<Integer, String> cg = new HashMap<Integer, String>();
		
		for (Iterator<Map.Entry<Integer, Float>> it = set.iterator(); it.hasNext();) {
			Map.Entry<Integer, Float> entry = (Map.Entry<Integer, Float>) it.next();
			//Compare float columns with regex to find interest rates
		}
		return cg;
		
	}

}
