package javacodes;

import java.util.ArrayList;
import java.util.List;

public class RowParser {

	public List<Object> parseRow(String row) {
		List<Object> parsedRow = new ArrayList<>();
		String[]  cells = row.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"); 
		
		for (String string : cells) {
			Object parsedValue
			if (strArray[i].matches(regexDates)) {
				// turn it into a date
				parsedValue = // whjatever i do t make it into a date
			} else if () {// matches a number)
				parsedValue = //whatever I do to make into a numb er
			} else 
				parsedValue = string;
			}
			parsedRow.add(parsedValue);
		
		}
		
		return new Row(parsedRow);
	}
	
}
 