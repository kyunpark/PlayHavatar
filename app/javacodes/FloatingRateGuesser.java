package javacodes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FloatingRateGuesser {

	RowParser parsedRow;
	Row numberOfColumns;
	String regexRate = "[0-9]{1,2}\\.[0-9]{1,2}+%?";

	public Map<Integer, String> guessColumn(Row parsedRow) {
		
		Map<Integer, Float> map = parsedRow.getAllFloatColumns();
		Set<Map.Entry<Integer, Float>> set = map.entrySet();
		//Collection of guesses after guessing
		Map<Integer, String> cg = new HashMap<Integer, String>();
		
		for (Iterator<Map.Entry<Integer, Float>> it = set.iterator(); it.hasNext();) {
			Map.Entry<Integer, Float> entry = (Map.Entry<Integer, Float>) it.next();
			//Compare float columns with regex to find interest rates
		}
		return cg;
		
	}

}
