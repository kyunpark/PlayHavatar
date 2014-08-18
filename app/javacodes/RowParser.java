package javacodes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RowParser {

	public Row parseRow(String row) throws ParseException {
		List<Object> parsedRow = new ArrayList<>();
		String[] cells = row.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
		String regexDates = "((\\d){1,4}-(\\d){1,4}-(\\d){1,4}) | ((\\d){1,4}/(\\d){1,4}/(\\d){1,4} | ((\\d){1,4}.(\\d){1,4}.(\\d){1,4})";
		Object parsedValue = null;


		for (String cell : cells) {
			if (cell.matches(regexDates)) {
				// turn it into a date
				SimpleDateFormat dateFormat = new SimpleDateFormat(regexDates);
				
				Date date = dateFormat.parse(cell);
				
				parsedValue = date;
			}

			
				if (isInt(cell))	{
					// matches a string with numeric type
					Number num = Integer.valueOf(cell);
					
					parsedValue = num;
				}
				if (isDouble(cell)) {
					// matches a string with numeric type
					Number num = Double.valueOf(cell);
					
					parsedValue = num;
				}
				if (isFloat(cell)) {
					// matches a string with numeric type
					Number num = Float.valueOf(cell);
					
					parsedValue = num;
				}

				// whatever I do to make into a number
			 else {
				
				parsedValue = cell;
			}

			parsedRow.add(parsedValue);
		}


		return new Row(parsedRow);
	}

	public boolean isDouble(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public boolean isFloat(String str) {
		try {
			float f = Float.parseFloat(str);
		} 
		catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
	
	public boolean isInt(String str) {
		try {
			int i = Integer.parseInt(str);
		}
		catch (NumberFormatException nfe) {
			return false;
			
		}
		return true;

	}
}
