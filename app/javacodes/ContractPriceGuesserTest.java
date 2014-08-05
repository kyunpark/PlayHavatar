package javacodes;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContractPriceGuesserTest {

	@Test
	public void testGetVal2Compare() {
		//fail("Not yet implemented");
		ContractPriceGuesser cpg = new ContractPriceGuesser();
		String [] strArray=cpg.getVal2Compare();
		cpg.guessColumn(strArray);
	}

	@Test
	public void testGuessColumn() {
		fail("Not yet implemented");
	}

}
