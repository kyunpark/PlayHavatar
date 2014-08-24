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
		Map<Integer,Date> dateColumns = new HashMap<Integer, Date>();
		for(int i = 0; i < data.size(); i++) {
			if(data.get(i) instanceof Date) {
				dateColumns.put(i, (Date)data.get(i));			
			}
		}
		return dateColumns;
	}
	
	public Map<Integer, Float> getAllFloatColumns() {
		Map<Integer,Float> floatColumns = new HashMap<Integer, Float>();
		for(int i = 0; i < data.size(); i++) {
			if(data.get(i) instanceof Float) {
				floatColumns.put(i, (Float)data.get(i));
			}
		}
		return floatColumns;
	}
	
	public Map<Integer, Integer> getAllIntColumns() {
		Map<Integer,Integer> intColumns = new HashMap<Integer, Integer>();
		for(int i = 0; i < data.size(); i++) {
			if(data.get(i) instanceof Integer) {
				intColumns.put(i, (Integer)data.get(i));
			}
		}
		return intColumns;
	}
	
	public Map<Integer, String> getAllStringColumns() {
		Map<Integer,String> stringColumns = new HashMap<Integer, String>();
		for(int i = 0; i < data.size(); i++) {
			if(data.get(i) instanceof String) {
				stringColumns.put(i, (String)data.get(i));	
			}
		}
		return stringColumns;
	}	
	
}
