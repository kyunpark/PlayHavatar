package javacodes;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;



public class FixedRateGuesser {
	
	RowParser parsedRow;
	Row getAllFloatColumns;
	String regexRate = "[0-9]{1,2}\\.[0-9]{1,2}+%?";


	public Map<Integer, String> guessColumn(Row parsedRow) {
		// TODO Auto-generated method stub
		Map<Integer, Float> map = parsedRow.getAllFloatColumns();
		Set<Map.Entry<Integer, Float>> set = map.entrySet();
		//Collection of guesses after guessing
		Map<Integer, String> cg = new HashMap<Integer, String>();
		
		for (Iterator<Map.Entry<Integer, Float>> it = set.iterator(); it.hasNext();) {
			Map.Entry<Integer, Float> entry = (Map.Entry<Integer, Float>) it.next();
				if (entry.getValue().toString().equals(regexRate)) {
					//Assuming there are only two columns of rates
					Float r1 = entry.getValue();
					Float r2 = entry.getValue();
					
					if (r1.compare(r1, r2))
				}
		
		return null;
	}
}