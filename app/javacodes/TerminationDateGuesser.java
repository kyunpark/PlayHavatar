package javacodes;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TerminationDateGuesser {
	
	RowParser parsedRow;
	Row numberOfColumns;


	public Map<Integer, String> guessColumn(Row parsedRow) {
		// Determine termination date among selected dates
		final String TD = "Termination Date";
		Map<Integer, Date> map = parsedRow.getAllDateColumns();
		Set<Map.Entry<Integer, Date>> set = map.entrySet();
		//Collection of guesses after guessing
		Map<Integer, String> cg = new HashMap<Integer, String>();
		
		if (parsedRow.numberOfColumns() == 2) {
			for (Iterator<Map.Entry<Integer, Date>> it = set.iterator(); it.hasNext();) {
				Map.Entry<Integer, Date> entry = (Map.Entry<Integer, Date>) it.next();
			
				Date d1 = entry.getValue();
				Date d2 = entry.getValue();
				
				if (d1.after(d2)) {
					//Annotate d1 column with TD
					cg.put(entry.getKey(), TD);
				}
				else {
					//Annotate d2 column with TD
					cg.put(entry.getKey(), TD);
				}
			}
		}
		else {
		return null;
		}
	return cg;	
	}

}
