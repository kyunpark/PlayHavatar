package javacodes;

import java.text.ParseException;

import org.junit.Test;

public class RowParserTesting {

	@Test
	public void testParseRow() throws ParseException {
		String string="10000000,buy,\"16,020,000\",30/03/2015,\"56,000\",267.0,GBP,3.17,21/02/2019";	
		new RowParser().parseRow(string);
		//fail("Not yet implemented");
	}

}
