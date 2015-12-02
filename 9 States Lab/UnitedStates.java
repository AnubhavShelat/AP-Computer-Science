// UnitedStates
// Jennifer Hsu

import java.util.*;
import java.io.*;

public class UnitedStates
{
	String path = "States.txt";
	File file = new File (path);
	Scanner input = null;
	
	List<String> list = new ArrayList<String>(0);
	
	public UnitedStates()
	{
		getList();
		
		while(true)
		{
			System.out.println("MENU");
			System.out.println("1. displayList");
			System.out.println("2. insertItem");
			System.out.println("3. removeItem");
			System.out.println("4. saveList");
			System.out.println("5. quit");
			System.out.print("Enter choice: ");
			
			input = new Scanner(System.in);
			switch ((input.nextLine()).charAt(0))
			{
				case '1': displayList();
						break;
				case '2': System.out.print("What state? ");
						insertItem(input.nextLine());
						break;
				case '3': System.out.print("What state? ");
						removeItem(input.nextLine());
						break;
				case '4': saveList();
						break;
				case '5': saveList();
						System.exit(0);
						break; 
			}
		}
	}
	
	public void getList()
	{
		try
		{
			input = new Scanner(file);
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("Can't find " + path);
			System.exit(1);
		}
		
		while (input.hasNextLine())
		{
			insertItem(input.nextLine());
		}
	}
	
	public void displayList()
	{
		for (String it : list)
			System.out.println(it);
	}
	
	public void insertItem(String x)
	{
		if (list.contains(x))
		{
			System.out.println(x + " is already in list.");
		}
		else
		{
			int i = 0;
			while (i < list.size() && x.compareTo(list.get(i)) > 0)
			{
				i++;
			}
			list.add(i, x);
		}
	}
	
	public void removeItem(String x)
	{
		if (list.contains(x))
		{
			list.remove(x);
		}
		else
		{
			System.out.println(x + " is not in list.");
		}
	}
	
	public void saveList()
	{
		PrintWriter writer = null;
		try
		{
			writer = new PrintWriter(new FileWriter(path));
		}
		catch (IOException ex)
		{
			System.out.println("Can't write to " + path);
			System.exit(1);
		}
		
		for (String it : list)
			writer.println(it);
		
		writer.close();
		System.out.println("File written to " + path);
	}

}