package javacodes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RowParser {

	public Row parseRow(String row) {
		List<Object> parsedRow = new ArrayList<>();
		String[]  cells = row.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"); 
		String regexDates = "((\\d){1,4}-(\\d){1,4}-(\\d){1,4}) | ((\\d){1,4}/(\\d){1,4}/(\\d){1,4} | ((\\d){1,4}.(\\d){1,4}.(\\d){1,4})";
		Number number;
		Object parsedValue = null;
		
		for (String string : cells) {

			if (cells[i].matches(regexDates)) {
				// turn it into a date
				SimpleDateFormat dateFormat = new SimpleDateFormat(regexDates);
				Date date = dateFormat.parse(cells[i]);
				parsedValue = date;
				// whatever i do to make it into a date
			} else if (cells[i].equals(number)) {
				// matches a number
				Number num = Float.valueOf(cells[i]).floatValue();
				parsedValue = num;
				//whatever I do to make into a number
			} else 
				parsedValue = string;
			}
			parsedRow.add(parsedValue);
		
	
		
		return new Row(parsedRow);
	}
	
}
 