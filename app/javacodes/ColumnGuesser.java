package javacodes;

import java.util.List;

public interface ColumnGuesser {
	
	public String[] getVal2Compare();
	
	public String guessColumn(List<Object> row);

}


