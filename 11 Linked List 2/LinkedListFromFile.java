// Jennifer Hsu

import java.util.*;
import java.io.*;

public class LinkedListFromFile extends LinkedList{

	public LinkedListFromFile()
	{
		super();
	}
	
	public LinkedListFromFile(String path)
	{
		super();
		File file = new File (path);
		Scanner input = null;
		LinkedList<String> list = new LinkedList();
		
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
			add(input.nextLine());
		}
	}
}