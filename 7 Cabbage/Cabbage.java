// Cabbages Lab
// Cabbage.java
// Jennifer Hsu

import java.util.*;
import java.io.*;

public class Cabbage {
	
	String path = "Cabbages.txt";
	File file = new File (path);
	Scanner input = null;
	String[] words = null;
	int repeats = 0;
	
	public Cabbage()
	{
		findLongest();
		sortArray();
		grep();
	}
	
	public void findLongest()
	{
		try
		{
			input = new Scanner(file);
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("** can't find ** " + path);
			System.exit(1);
		}
		System.out.println("Words found in text --");
		int x = 0;
		int max = 0;
		String longest = "";
		while (input.hasNext())
		{
			String nextline = input.next();
			if (nextline.length() > max)
			{
				max = nextline.length();
				longest = nextline;
			}
			System.out.println("    "+ (x + 1) + " " + nextline);
			x++;
		}
		System.out.println("The longest word in the list is <" + longest + ">.");
		words = new String[x];
	}
	
	public void sortArray()
	{
		try
		{
			input = new Scanner(file);
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("** can't find ** " + path);
			System.exit(1);
		}
		
		int a = 0;
		while(input.hasNext())
		{
			words[a] = input.next();
			words[a] = words[a].toLowerCase();
			words[a] = removePunctuation(words[a]);
			a++;
		}
		Arrays.sort(words);
		for (int x = 1; x < words.length; x++)
		{
			if (words[x].equals(words[x - 1]))
			{
				words[x - 1] = "";
				repeats++;
			}
		}
		Arrays.sort(words);
		if(words[0].equals(""))
		{
			repeats++;
		}
		String[] temp = new String[words.length - repeats];
		for (int x = 0; x < temp.length; x++)
		{
			temp[x] = words[repeats + x];
		}
		words = temp;
                System.out.println("Words sorted alphabetically with duplicates removed --");
		for (int x = 0; x < words.length; x++)
		{
			System.out.println("    " + x + " " + temp[x]);
		}
	}
	
	public String removePunctuation(String word)
	{
		while (findPunctuation(word.charAt(0)) == true && word.length() != 0)
		{
			if (word.length() == 1)
			{
				return "";
			}
			word = word.substring(1, word.length());
		}
		while (findPunctuation(word.charAt(word.length() - 1)) == true && word.length() != 0)
		{
			if (word.length() == 1)
			{
				return "";
			}
			word = word.substring(0, word.length() - 1);
		}
		return word;
	}
	
	public boolean findPunctuation(char c)
	{
		if (c == '"' || c == '-' || c == ',' || c == '.' || c == ':' || c == '!'  || c == '?'  || c == ';')
			return true;
		return false;
	}
	
	public void grep()
	{
		System.out.println("Search for? ");
		Scanner scan = new Scanner(System.in);
                String sequence = scan.nextLine();
		int l = sequence.length();
		boolean find = false;
		String substr = "";
		try
		{
			input = new Scanner(file);
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("** can't find ** " + path);
			System.exit(1);
		}
		int x = 0;
                System.out.println("Instances of <" + sequence + "> --");
		while (input.hasNextLine())
		{
			String lines = input.nextLine();
			for (int a = 0; a < (lines.length() - l); a++)
			{
				substr = lines.substring(a, a + l);
				if (sequence.equalsIgnoreCase(substr))
				{
					String begin = lines.substring(0, a);
					String middle = lines.substring(a, a + l);
					String end = lines.substring(a + l, lines.length());
					System.out.println("Line " + x + ": " + begin + "<" + middle + ">" + end);
					find = true;
				}
				x++;
			}
		}
		if (find == false)
		{
			System.out.println("phrase not found");
		}
	}
}