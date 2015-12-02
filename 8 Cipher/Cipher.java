// Cipher Lab
// Cipher.java
// Jennifer Hsu

import java.util.*;
import java.io.*;

public class Cipher
{
	Scanner input;
	String path = "Cipher.txt";
	String path2 = "Jabberwocky.txt";
	String path3 = "Replace.txt";
	PrintWriter writer = null;
	File file = new File (path);
	File decoder = new File (path3);
	Record[] records =
	{
		new Record('A'),
		new Record('B'),
		new Record('C'),
		new Record('D'),
		new Record('E'),
		new Record('F'),
		new Record('G'),
		new Record('H'),
		new Record('I'),
		new Record('J'),
		new Record('K'),
		new Record('L'),
		new Record('M'),
		new Record('N'),
		new Record('O'),
		new Record('P'),
		new Record('Q'),
		new Record('R'),
		new Record('S'),
		new Record('T'),
		new Record('U'),
		new Record('V'),
		new Record('W'),
		new Record('X'),
		new Record('Y'),
		new Record('Z'),
	};
	
	public Cipher()
	{
		countFreq();
		Arrays.sort(records);
		assignCode();
		decipher();
		correctCode();
		decipher();
		writeFile();
		writeCode();
	}
	
	public void countFreq()
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
		
		while (input.hasNext() == true)
		{
			String text = input.next();
			for (int a = 0; a < text.length(); a++)
			{
				char b = text.charAt(a);
				int c = getChar(b);
				if (c != -1)
				{
					records[c].incrFreq();
				}
			}
		}
		System.out.println("LETTER/FREQUENCY");
		print();
	}
	
	public void assignCode()
	{
		try
		{
			input = new Scanner(decoder);
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("** can't find ** " + decoder);
			System.exit(1);
		}
		String freq = input.nextLine();
		for (int a = 0; a < 26; a++)
		{
			records[a].setCode(freq.charAt(2*a));
		}
		System.out.println("CODED/DECODED/FREQUENCY");
		print();
	}
	
	public void correctCode()
	{
		for (int a = 1; a < 26; a++)
		{
			if (records[a].getFreq() == records[a-1].getFreq() && records[a].getFreq() != 0)
			{
				System.out.println(records[a - 1].getLetter() + " and " + records[a].getLetter() + " both appear " + records[a].getFreq() + " times.");
				System.out.println("Switch their decoders " + records[a - 1].getCode() + " and " + records[a].getCode() + "(Y/N)? ");
				Scanner scanner = new Scanner(System.in);
				if ((scanner.nextLine()).equals("Y"))
				{
					char temp = records[a].getCode();
					records[a].setCode(records[a -1].getCode());
					records[a - 1].setCode(temp);
				}
			}
		}
		System.out.println("CODED/DECODED/FREQUENCY");
		print();
	}
	
	public void decipher()
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
		while (input.hasNext() == true)
		{
			String text = input.nextLine();
			for (int a = 0; a < text.length(); a++)
			{
				char b = text.charAt(a);
				int c = getChar(b);
				if (c == -1)
				{
					System.out.print(b);
				}
				else
				{
					int d = 0;
					while (records[d].getLetter() != b)
					{
						d++;
					}
					System.out.print(records[d].getCode());
				}
			}
			System.out.println();
		}
	}
	
	public void writeFile()
	{
		try
		{
			writer = new PrintWriter(new FileWriter(path2));
		}
		catch (IOException ex)
		{
			System.out.println("** can't write **" + path2);
			System.exit(1);
		}
		try
		{
			input = new Scanner(file);
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("** can't find ** " + path);
			System.exit(1);
		}
		while (input.hasNext() == true)
		{
			String text = input.nextLine();
			for (int a = 0; a < text.length(); a++)
			{
				char b = text.charAt(a);
				int c = getChar(b);
				if (c == -1)
				{
					writer.print(b);
				}
				else
				{
					int d = 0;
					while (records[d].getLetter() != b)
					{
						d++;
					}
					writer.print(records[d].getCode());
				}
			}
			writer.println();
		}
		writer.println();
		writer.close();
		System.out.println("File written to " + path2);
	}
	
	public void writeCode ()
	{
		try
		{
			writer = new PrintWriter(new FileWriter(path3));
		}
		catch (IOException ex)
		{
			System.out.println("** can't write **" + path3);
			System.exit(1);
		}
		for (int a = 0; a < 26; a++)
		{
			writer.print(records[a].getCode() + " ");
		}
		writer.close();
		System.out.println("File written to " + path3);
	}
	
	public void print()
	{
		for (int a = 0; a < 26; a++)
		{
			records[a].print();
		}
	}
	
	public int getChar(char a)
	{
		switch(a)
		{
			case 'A': return 0;
			case 'B': return 1;
			case 'C': return 2;
			case 'D': return 3;
			case 'E': return 4;
			case 'F': return 5;
			case 'G': return 6;
			case 'H': return 7;
			case 'I': return 8;
			case 'J': return 9;
			case 'K': return 10;
			case 'L': return 11;
			case 'M': return 12;
			case 'N': return 13;
			case 'O': return 14;
			case 'P': return 15;
			case 'Q': return 16;
			case 'R': return 17;
			case 'S': return 18;
			case 'T': return 19;
			case 'U': return 20;
			case 'V': return 21;
			case 'W': return 22;
			case 'X': return 23;
			case 'Y': return 24;
			case 'Z': return 25;
		}
		return -1;
	}
}