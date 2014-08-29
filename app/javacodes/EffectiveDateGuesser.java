package javacodes;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class EffectiveDateGuesser {

	RowParser parsedRow;
	
	
	public Map<Integer, String> guessColumn(Row parsedRow) {
		// TODO Auto-generated method stub
		
		String ED;
		Map<Integer, Date> map = parsedRow.getAllDateColumns();
		Set<Map.Entry<Integer, Date>> set = map.entrySet();
		//Collection of guesses after guessing
		Map<Integer, String> cg = new HashMap<Integer, String>();
		
		for (Iterator<Map.Entry<Integer, Date>> it = set.iterator(); it.hasNext();) {
            
			Map.Entry<Integer, Date> entry = (Map.Entry<Integer, Date>) it.next();
			if (parsedRow.numberOfColumns() == 3) {
				Date d1 = entry.getValue();
				Date d2 = entry.getValue();
				Date d3 = entry.getValue();
				
				if (d1.before(d2) && d2.before(d3) || d3.before(d2) && d2.before(d1)) {
					//Annotate d2 column with ED into Map<> cg
					cg.put(key, ED);
				}
				else if (d2.before(d3) && d3.before(d1) || d1.before(d3) && d3.before(d2)) {
					//Annotate d3 column with ED into Map<> cg
					cg.put(key, ED);
				}
				else {
					//Annotate d1 column with ED into Map<> cg
					cg.put(key, ED);
				}
				
			}	
		}
		return cg;
	}
}