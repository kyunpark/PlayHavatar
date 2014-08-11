package javacodes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class RowParser {
	//public List<Object> parseRow(String row) {
		public Row parseRow(String row){
			//String string="10000000,buy,\"16,020,000\",30/03/2015,\"56,000\",267.0,GBP,3.17,21/02/2019";	
		List<Object> parsedRow = new ArrayList<Object>();
		String[]  cells = row.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"); 
		//date
		String regexDates="((\\d){1,4}-(\\d){1,4}-(\\d){1,4})|((\\d){1,4}/(\\d){1,4}/(\\d){1,4})";
		//number
		String regexNumber="((\\d){1,11})|((\")*(\\d){1,3}(,(\\d){1,3})*(\")*)|((\\d){1,11}.(\\d){1,11})";
		//string
		String regexString="[a-zA-Z]+";
		//String parsedValue="";
		for (String string : cells) {
			//Object parsedValue
			if (string.matches(regexDates)) {
				// turn it into a date
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				//sdf.parse("2008-08-08 12:10:12");
				Date date=new Date();
				try {
					date = sdf.parse(string);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				parsedRow.add(date);
				//parsedValue = "1";// whatever i do t make it into a date
			} else if (string.matches(regexNumber)) {// matches a number)
				String temp=string.replaceAll("[,|\"]", "");
				
				//parsedRow.add(new Float(temp));
				float floatTemp=Float.valueOf(temp);
				parsedRow.add(floatTemp);
				//parsedValue = "2";//whatever I do to make into a numb er
			} else if (string.matches(regexString)){
				//parsedValue = string;
			    parsedRow.add(string);
			}
			else{
				//parsedValue=string;
				parsedRow.add(string);
			}
			
			//parsedRow.add(parsedValue);
		}
		Row rowObject = new Row(parsedRow);
		return rowObject;
	}
}
