package javacodes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ContractPriceGuesser implements ColumnGuesser {

	@Override
	public String[] getVal2Compare() {

			// TODO Auto-generated method stub
			// Select Date columns to be compared
			//HTable table = new HTable(config, "duco_test");		    	  
			String filepath="D:\\javaProgram\\HbaseClient\\data\\500_rows_future.csv";
			  int index=0;
			  int rowNumber=2;
			  BufferedReader reader; 
			  String[] strArray=null;
			try {
				reader = new BufferedReader(new FileReader(filepath));
				String row = "";
				String regexDates = "((\\d){1,4}-(\\d){1,4}-(\\d){1,4})|((\\d){1,4}/(\\d){1,4}/(\\d){1,4})";
				 
		  
		   	  	
			    String ss;
			  
				
		   	  	while((ss=reader.readLine()) != null && index<rowNumber)
		   	  	{
		   	  	 if(index == rowNumber -1){
		   	  		 System.out.println(ss);
		   	  		 
		   	  		strArray= ss.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"); 
		   	  		//splitting-a-comma-separated-string-but-ignoring-commas-in-quotes
		   		  
		   	  		for(int i=0; i< strArray.length; i++){
		   	  			strArray[i].trim();
		   	  		}
		   	  		
		   	  		int datesCount=0;
		   	  		for(int i=0; i< strArray.length; i++){
		   	  			if (strArray[i].matches(regexDates)){
		   	  				//dates[datesCount] = strArray[i];
		   	  				datesCount++;
		   	  			}
		   	  		}
		   	  	 }
		   	  	 index++;
		   	  	}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return strArray;  
	   	  
			
	}

	public String guessColumn(String[] row) {
		// TODO Auto-generated method stub
		String regexPrice = "(\"(\\d){1,3},(\\d){1,3},(\\d){1,3}\")|(\"(\\d){1,3},(\\d){1,3}\")";
		 
		// TODO Auto-generated method stub
		// Find all the date columns
		int dataLength=0;
		//String regexDates = "((\\d){1,4}-(\\d){1,4}-(\\d){1,4})|((\\d){1,4}/(\\d){1,4}/(\\d){1,4})";
		for(String string : row)
		{
			if(string.matches(regexPrice)){
				dataLength++;
			}
		}
		System.out.println(dataLength);
		String [] dates= new String[dataLength];
		dataLength=0;
		for(String string : row)
		{
			if(string.matches(regexPrice)){
				dates[dataLength]=string;
				dataLength++;
				
			}
		}
		String mMax = "";
		for (int j=0; j< dates.length; j++){
		      if(dates[j].length()>mMax.length())  
		    	  mMax = dates[j];

		}
		System.out.println("Contract Price is:"+mMax);
		return mMax;
	}

	@Override
	public String guessColumn(List<Object> row) {
		// TODO Auto-generated method stub
		return null;
	}

}
