package javacodes;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TradeDateGuesser {


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

	public Map<Integer, String> guessColumn(Row parsedRow) {
		// TODO Auto-generated method stub
		String TD;

		Map<Integer, Date> map = parsedRow.getAllDateColumns();
		Set<Map.Entry<Integer, Date>> set = map.entrySet();
		//Collection of guesses after guessing
		Map<Integer, String> cg = new HashMap<Integer, String>();
		
//		TreeMap<Integer, Date> treeMap = new TreeMap<Integer, Date>(map);
		for (Iterator<Map.Entry<Integer, Date>> it = set.iterator(); it.hasNext();) {
            
			Map.Entry<Integer, Date> entry = (Map.Entry<Integer, Date>) it.next();
			//Should I use For loops to get Date values to be compared?? 
			if (parsedRow.numberOfColumns() == 2) {
				Date d1 = entry.getValue();
				Date d2 = entry.getValue();
				
				if (d1.before(d2)) {
					//Annotate d1 column with TD into Map<> cg
				}
				else {
					//Annotate d2 column with TD into Map<> cg
				}
				
			}
			else if(parsedRow.numberOfColumns() == 3) {
				Date d1 = entry.getValue();
				Date d2 = entry.getValue();
				Date d3 = entry.getValue();
				
				if (d1.before(d2)) {
					if (d1.before(d3)) {
						//Annotate d1 column with TD into Map<> cg
					}
					else {
						//Annotate d3 column with TD into Map<> cg
						}
					}
				else {
					if (d2.before(d3)) {
						//Annotate d2 column with TD into Map<> cg
					}
					else {
						//Annotate d3 column with TD into Map<> cg
					}
				}
			}
			
		}
		
		Map<Integer, String> guesses;
		
		
		return null;
	}
	
	//des,asc; quicksort
//	public void quicksort(TreeMap<Integer, Date> data,int start, int end, int index){
//		
//	}
//	
//	public void test(){
//		Date date = new Date();
//		date.
//	}

}
