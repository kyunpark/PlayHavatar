package javacodes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RowParser {

	public List<Object> parseRow(String row) {
		List<Object> parsedRow = new ArrayList<>();
		String[]  cells = row.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"); 
		String regexDates = "((\\d){1,4}-(\\d){1,4}-(\\d){1,4}) | ((\\d){1,4}/(\\d){1,4}/(\\d){1,4} | ((\\d){1,4}.(\\d){1,4}.(\\d){1,4})";
		
		for (String string : cells) {
			Object parsedValue;
			int i=0;
			if (cells[i].matches(regexDates)) {
				// turn it into a date
				SimpleDateFormat dateFormat = new SimpleDateFormat(regexDates);
				Date date = dateFormat.parse(cells[i]);
				parsedValue = date;// whatever i do to make it into a date
			} else if (cells[i].) {// matches a number)
				parsedValue = //whatever I do to make into a numb er
			} else 
				parsedValue = string;
			}
			parsedRow.add(parsedValue);
		
		}
		
		return new Row(parsedRow);
	}
	
}
 