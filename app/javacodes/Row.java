package javacodes;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Row {

	private List<Object> data;
	
	public Row(List<Object> value) {
		this.data = value;
	}
	
	public Object getValue(int columnIndex) {
		return data.get(columnIndex);
	}
	
	public int numberOfColumns() {
		return data.size();
	}
	
	public Map<Integer, Date> getAllDateColumns() {
		Map<Integer,Date> dateColumns = new HashMap<>();
		for(int i = 0; i < data.size(); i++) {
			if(data.get(i) instanceof Date) {
				dateColumns.put(i, (Date)data.get(i));
				
			}
		}
		dateColumns.get(3);
		return dateColumns;
	}
	
}
