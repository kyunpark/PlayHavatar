package javacodes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ContractPriceGuesser {


//	public Row getVal2Compare(){
//
//			// TODO Auto-generated method stub
//			// Select Date columns to be compared
//			//HTable table = new HTable(config, "duco_test");		    	  
//			String filepath="D:\\javaProgram\\HbaseClient\\data\\2_rows_future.csv";
//			  int index=0;
//			  int rowNumber=2;
//			  BufferedReader reader; 
//			  Row row = new Row(null);
//			try {
//				reader = new BufferedReader(new FileReader(filepath));
//			    String ss;  
//				//这里读取了第2行
//		   	  	while((ss=reader.readLine()) != null && index<rowNumber)
//		   	  	{
//		   	  	 if(index == rowNumber -1){
//		   	  		 System.out.println(ss);
//		   	  		 row=new RowParser().parseRow(ss);
//		   	  		 //return new RowParser().parseRow(ss);
//		   	  	 }
//		   	  	 index++;
//		   	  	}
//				
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return row;
//			
//	}
	RowParser parsedRow;
	Row getAllNumberColumns;
	
	public Map<Integer, String> guessColumn(Row parsedRow) {
		System.out.println("the Numbers in the row:");
		float mMax=0;
		Integer columnOrder=0;
		Map<Integer,Float> map = parsedRow.getAllFloatColumns();
		Set<Map.Entry<Integer, Float>> set = map.entrySet();
        for (Iterator<Map.Entry<Integer, Float>> it = set.iterator(); it.hasNext();) {
            Map.Entry<Integer, Float> entry = (Map.Entry<Integer, Float>) it.next();
            System.out.println(entry.getKey() + "--->" + entry.getValue());
		    if(mMax<entry.getValue())
		    {
		         mMax = entry.getValue();
		         columnOrder = entry.getKey();
		    }
        }
        System.out.println("Contract Price is the "+columnOrder+"th Column data of the row.");
        System.out.println("with value="+String.valueOf(mMax)+".");
        Map<Integer,Set<String>> guessedMap = new HashMap<Integer,Set<String>>();
        Set<String>  set1=new HashSet<String>();
        set1.add(String.valueOf(mMax));
        guessedMap.put(columnOrder+1,set1);
        return guessedMap;
	}

}
