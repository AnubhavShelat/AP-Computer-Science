import java.util.*;
import java.io.*;

public class SetsOfLetters
{
	Set<Character> lower = new HashSet<Character>();
	Set<Character> upper = new HashSet<Character>();
	Set<Character> other = new HashSet<Character>();
	
	Set<Character> lowerC = new HashSet<Character>();
	Set<Character> upperC = new HashSet<Character>();
	Set<Character> otherC = new HashSet<Character>();
	
	public SetsOfLetters()
	{
		Scanner input = null;
		String path = "declarationLast.txt";
		File file = new File (path);
		try
		{
			input = new Scanner(file);
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("** can't find ** " + path);
			System.exit(1);
		}
		
		boolean first = true;
		
		while (input.hasNextLine() == true)
		{
			String text = input.nextLine();
			setFromString(text);
			
			if (first)
			{
				lowerC = lower;
				upperC = upper;
				otherC = other;
				first = false;
			}
			else
			{
				lowerC.retainAll(lower);
				upperC.retainAll(upper);
				otherC.retainAll(other);
			}
		}
		
		System.out.println("Characters in every line:");
		if (!lowerC.isEmpty())
		{
			System.out.print("Lower case: ");
			printSet(lowerC);
		}
		if (!upperC.isEmpty())
		{
			System.out.print("Upper case: ");
			printSet(upperC);
		}
		if (!otherC.isEmpty())
		{
			System.out.print("Other: ");
			printSet(otherC);
		}
	}
	
	public void setFromString(String str)
	{
		lower = new HashSet<Character>();
		upper = new HashSet<Character>();
		other = new HashSet<Character>();
		
		for(int a = 0; a < str.length(); a++)
		{
			char c = str.charAt(a);
			if (c >= 'a' && c <= 'z')
			{
				lower.add(c);
			}
			else if (c >= 'A' && c <= 'Z')
			{
				upper.add(c);
			}
			else if (c != ' ')
			{
				other.add(c);
			}
		}
		System.out.println(str);
		printAllSets();
		System.out.println();
	}
	
	public void printAllSets()
	{
		if (!lower.isEmpty())
		{
			System.out.print("Lower case: ");
			printSet(lower);
		}
		if (!upper.isEmpty())
		{
			System.out.print("Upper case: ");
			printSet(upper);
		}
		if (!other.isEmpty())
		{
			System.out.print("Other: ");
			printSet(other);
		}
	}
	
	public void printSet(Set<Character> s)
	{
		Set<Character> t = new TreeSet<Character>(s);
		Iterator it = t.iterator();
		while(it.hasNext())
		{
			System.out.print(it.next() + " ");
		}
		System.out.println();
	}
}

/*
	public void ex1()
	{
		 Set<String> s = new HashSet<String>();
		 s.add("Mary");
		 s.add("Joan");
		 s.add("Mary");
		 s.add("Dennis");
		 System.out.println("Size: " + s.size());
		 Iterator it = s.iterator();
		 while(it.hasNext())
		 {
			System.out.print(it.next() + " ");
		 }
		 System.out.println();
		 Set<String> t = new TreeSet<String>(s);
		 it = t.iterator();
		 while (it.hasNext())
		 {
			System.out.print(it.next() + " ");
		 }
		 System.out.println(s);							 
	}
							 
	public void ex2()
	{
		Map<String, String> h = new HashMap<String, String>();
		h.put("Othello", "green");
		h.put("MacBeth", "red");
		h.put("Hamlet", "blue");
		if(!h.containsKey("Lear"))
		h.put("Lear", "black");
		System.out.println(h.containsKey("Othello"));
		System.out.println(h.keySet());
		Map<String, String> t = new TreeMap<String, String> (h);
		System.out.println(t.keySet());
		Iterator it = t.keySet().iterator();
		while(it.hasNext())
		{
			System.out.print(t.get(it.next()));
		}
	 }
*/