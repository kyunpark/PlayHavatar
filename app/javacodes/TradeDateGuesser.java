package javacodes;

import java.util.Date;

public class TradeDateGuesser implements ColumnGuesser {

	@Override
	public void getVal2Compare() {
		// Select Date columns to be compared
		
		Date d1 = new Date();
		Date d2 = new Date();
		Date d3 = new Date();
		
	}

	@Override
	public String guessColumn() {
		//Determine trade date among selected dates
		
		return null;
	}

}
