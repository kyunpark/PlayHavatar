package javacodes;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;

public class FixedRateGuesser implements ColumnGuesser {
	
	String regexRate = "[0-9]{0,2}\\.[0-9]+%?";
  	String mRate="";
	private BufferedReader reader = null;
	org.apache.hadoop.conf.Configuration config = HBaseConfiguration.create();
	
	@Override
	public String getVal2Compare() {
		// Select rate columns to be compared
   	  
   	  	String[] strArray = null;
	    String ss;
	    int count = 0;

   	  	while((ss = reader.readLine()) != null)
   	  	{
   	  		strArray = ss.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"); 
   	  		//splitting-a-comma-separated-string-but-ignoring-commas-in-quotes
   		  
   	  		for(int i = 0; i < strArray.length; i++)
   	  		{
   	  			strArray[i].trim();
   	  		}
   	  		
   	  		for(int i = 0; i < strArray.length; i++)
   	  		{
   	  			if (strArray[i].matches(regexRate))
   	  			{
   	  				mRate = strArray[i];  
   	  			}
   	  		}
   	  		return mRate;
   	  	}
	}

	@Override
	public String guessColumn() {
		// Determine fixed rate between selected rates
		for (int j=0; j< mRate.length; j++){
		      if(mRate[j] > mRate[j+1])
		    	  return mRate[j];
		      else 
		    	  return mRate[j+1];
		}
	}

	@Override
	public String guessColumn(List<Object> row) {
		// TODO Auto-generated method stub
		return null;
	}
}