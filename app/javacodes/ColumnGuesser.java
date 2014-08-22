package javacodes;

import java.util.Map;
import java.util.Set;

public interface ColumnGuesser {
	
	public String[] getVal2Compare();
	
	  public Map<Integer,Set<String>> guessColumn(Row row);


}
