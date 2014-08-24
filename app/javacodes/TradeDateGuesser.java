package javacodes;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TradeDateGuesser implements ColumnGuesser {


	RowParser parsedRow;
	Row numberOfColumns;
	
	@Override
	public String[] getVal2Compare() {
		// Select Date columns to be compared
		
		Date d1 = new Date();
		Date d2 = new Date();
		Date d3 = new Date();
		
		System.out.println(d1+","+d2+","+d3);
		return null;
		
	}

	public String guessColumn(Row parsedRow) {
		// TODO Auto-generated method stub

		Map<Integer, Date> map = parsedRow.getAllDateColumns();
		Set<Map.Entry<Integer, Date>> set = map.entrySet();
		
//		TreeMap<Integer, Date> treeMap = new TreeMap<Integer, Date>(map);
		
		if(parsedRow.numberOfColumns() == 2){
			
			
		}else if(parsedRow.numberOfColumns() == 3){
			
		}
		
		Map<Integer, Set<String>> guesses;
		
		
		return null;
	}
	
	//des,asc; quicksort
	public void quicksort(TreeMap<Integer, Date> data,int start, int end, int index){
		
	}
	
	public void test(){
		Date date = new Date();
		date.
	}

}
