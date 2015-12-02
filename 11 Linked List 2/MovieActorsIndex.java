// Jennifer Hsu

import java.util.*;
import java.io.*;

public class MovieActorsIndex
{
	LinkedListFromFile movies = new LinkedListFromFile("movies.txt");
	LinkedListFromFile actors = new LinkedListFromFile("actors.txt");
	
	public MovieActorsIndex()
	{
		int choice = 0;
		Scanner input = new Scanner(System.in);
		do
		{
			System.out.println("INTRANET MOVIE DATABASE");
			System.out.println("1. Display list");
			System.out.println("2. Display actors movies");
			System.out.println("3. Display all actors movies");
			System.out.println("4. Quit with file output");
			System.out.print("Choice: ");
			choice = input.nextInt();
			switch (choice)
			{
				case 1: displayList();
						break;
				case 2: input.nextLine();
						System.out.print("Actor's name: ");
						displayActorsMovies(input.nextLine());
						break;
				case 3: displayAllActorsMovies();
						break;
				case 4: quitWithFileOutput();
						break;
			}
		} while (choice != 4);
	}
	
	public void displayList()
	{
		Iterator<String> itrA = actors.iterator();
		while (itrA.hasNext())
		{
			System.out.println(itrA.next());
		}
	}
	
	public void displayActorsMovies(String name)
	{
		ListIterator<String> itrM = movies.listIterator();
		while (itrM.hasNext())
		{
			String element = itrM.next();
			String strA = element.substring(37, 83);
			if (strA.contains(name))
			{
				System.out.println(element.substring(0, 36).trim());
			}
		}
	}
	
	public void displayAllActorsMovies()
	{
		Iterator<String> itrA = actors.iterator();
		
		while (itrA.hasNext())
		{
			String name = itrA.next();
			System.out.println(name);
			displayActorsMovies(name);
		}
	}
	
	public void quitWithFileOutput()
	{
		Iterator<String> itrA = actors.iterator();
		
		while (itrA.hasNext())
		{
			ListIterator<String> itrM = movies.listIterator();
			String name = itrA.next();
			System.out.println(name);
			
			while (itrM.hasNext())
			{
				itrM.next();
			}
			
			while (itrM.hasPrevious())
			{
				String element = itrM.previous();
				String strA = element.substring(37, 83);
				if (strA.contains(name))
				{
					System.out.println(element.substring(0, 36).trim());
				}
			}
		}
	}
}