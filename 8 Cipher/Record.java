// Cipher Lab
// Record.java
// Jennifer Hsu

public class Record implements Comparable<Record>
{
	private char letter;
	private char code;
	private int frequency;
	
	public Record(char a)
	{
		letter = a; code = ' '; frequency = 0;
	}
	
	public char getLetter()
	{
		return letter;
	}
	
	public char getCode()
	{
		return code;
	}
	
	public int getFreq()
	{
		return frequency;
	}
	
	public void setCode(char a)
	{
		code = a;
	}
	
	public void incrFreq()
	{
		frequency++;
	}
	
	public void print()
	{
		System.out.println(letter + " " + code + " " + frequency);
	}
	
	public int compareTo(Record other)
	{
		if (frequency > other.getFreq())
			return -1;
		else if (frequency == other.getFreq())
		{
			return 0;
		}
		else
			return 1;
	}
}