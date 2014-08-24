package javacodes;

public interface ColumnGuesser {
	
	public Row getVal2Compare();
	
	public String guessColumn(Row parsedRow);

}
