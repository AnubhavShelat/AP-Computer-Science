// Jennifer Hsu

import java.util.*;

public class Customer implements Comparable<Customer>
{
	private int customerType;
	private int timeEntered;
	
	public Customer(int x)
	{
		timeEntered = x;
		Random randomGenerator = new Random();
		int y = randomGenerator.nextInt(10);
		if (y == 0)
			customerType = 1;
		else if (y >= 1 && y <= 3)
			customerType = 2;
		else if (y >= 4 && y <= 7)
			customerType = 3;
		else
			customerType = 4;
	}
	
	public int get()
	{
		return customerType;
	}
	
	public int getTime()
	{
		return timeEntered;
	}
	
	public String toStr()
	{
		switch (customerType)
		{
			case 1: return "A";
			case 2: return "B";
			case 3: return "C";
			case 4: return "D";
		}
		return " ";
	}
	
	public int compareTo(Customer other)
	{
		if (customerType < other.get())
			return -1;
		else if (customerType == other.get())
			return 0;
		else
			return 1;
	}
}