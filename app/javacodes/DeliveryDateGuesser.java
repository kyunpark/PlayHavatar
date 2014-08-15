package javacodes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DeliveryDateGuesser implements ColumnGuesser {
	private SimpleDateFormat sdf = new SimpleDateFormat();
	@Override
	public Row getVal2Compare(){
		// TODO Auto-generated method stub
		// Select Date columns to be compared
		//HTable table = new HTable(config, "duco_test");		    	  
		String filepath="D:\\javaProgram\\HbaseClient\\data\\2_rows_future.csv";
		  int index=0;
		  int rowNumber=2;
		  BufferedReader reader; 
		  
		  Row row = new Row(null);
		try {
			reader = new BufferedReader(new FileReader(filepath));
		    String ss;  
			//这里读取了第2行
	   	  	while((ss=reader.readLine()) != null && index<rowNumber)
	   	  	{
	   	  	 if(index == rowNumber -1){
	   	  		 System.out.println(ss);
	   	  		 row=new RowParser().parseRow(ss);
	   	  		 //return new RowParser().parseRow(ss);
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
		return row;
   	  
		
	}

	public String guessColumn(Row row) {
		// TODO Auto-generated method stub
		// Find all the date columns
		System.out.println("the dates in the row:");
		Date mMax=new Date();
		Integer columnOrder=0;
		Map<Integer,Date> map=row.getAllDateColumns();
		Set<Map.Entry<Integer, Date>> set1 = map.entrySet();
		int count=0;
        for (Iterator<Map.Entry<Integer, Date>> it = set1.iterator(); it.hasNext();) {
            Map.Entry<Integer, Date> entry = (Map.Entry<Integer, Date>) it.next();
            System.out.println(entry.getKey() + "--->" + getDateFormat(entry.getValue(),"dd/MM/yyyy"));

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(entry.getValue());

            //每月第3个周四，且为所有日期中最靠后的
            if((calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH)==3 && calendar.get(Calendar.DAY_OF_WEEK)==Calendar.THURSDAY) || count==0){
                 if(mMax.before(entry.getValue())){
                	 mMax=entry.getValue();
                	 columnOrder = entry.getKey();
                 }
            }
            count++;
           
        }
        System.out.println("DeliveryDate is the "+columnOrder+"th Column data of the row.");
        System.out.println("with value="+getDateFormat(mMax,"dd/MM/yyyy")+".");
        return getDateFormat(mMax,"dd/MM/yyyy");
	}

	// 返回日期的相应格式
	private synchronized String getDateFormat(java.util.Date date,
			String pattern) {
		synchronized (sdf) {
			String str = null;
			sdf.applyPattern(pattern);
			str = sdf.format(date);
			return str;
		}
	}

	@Override
	public String guessColumn(List<Object> row) {
		// TODO Auto-generated method stub
		return null;
	}

}
