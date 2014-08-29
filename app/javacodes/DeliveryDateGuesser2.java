package javacodes;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DeliveryDateGuesser2 {
	
	RowParser parsedRow;
	Row numberOfColumns;
	
	public Map<Integer, String> guessColumn(Row parsedRow) {
		
		final String DD = "Delivery Date";

		Map<Integer, Date> map = parsedRow.getAllDateColumns();
		Set<Map.Entry<Integer, Date>> set = map.entrySet();
		//Collection of guesses after guessing
		Map<Integer, String> cg = new HashMap<Integer, String>();
		
		if (parsedRow.numberOfColumns() == 3) {
			for (Iterator<Map.Entry<Integer, Date>> it = set.iterator(); it.hasNext();) {
				Map.Entry<Integer, Date> entry = (Map.Entry<Integer, Date>) it.next();
			
				Date d1 = entry.getValue();
				Date d2 = entry.getValue();
				Date d3 = entry.getValue();
			
				if (d1.after(d2)) {
					if (d1.after(d3)) {
						//Annotate d1 column with DD
						cg.put(entry.getKey(), DD);
					}
					else{
						//Annotate d3 column with TD
						cg.put(entry.getKey(), DD);
					}
				}
				else {
					if (d2.after(d3)) {
						//Annotate d2 column with TD
						cg.put(entry.getKey(), DD);
					}
					else {
						//Annotate d3 column with TD
						cg.put(entry.getKey(), DD);
					}
				}
	
			}
		}
		else {
		
		return null;
	}
	return cg;
	}

}
