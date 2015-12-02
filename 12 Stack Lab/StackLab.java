// Jennifer Hsu

import java.util.*;

public class StackLab
{
	public StackLab()
	{
		Scanner input = new Scanner(System.in);
		do {
			System.out.print("Enter a line of text: ");
			System.out.println("Here is the line you entered: " + processText(input.nextLine()) + "\n");
			System.out.print("Again (y/n)? ");
		} while (input.nextLine().charAt(0) == 'y');
	}
	
	public String processText(String input)
	{
		Stack line = new Stack();
		for (int x = 0; x < input.length(); x++)
		{
			if (input.charAt(x) == '$')
				line.clear();
			else if (input.charAt(x) == '-')
			{
				if (line.empty() == false)
					line.pop();
			}
			else
				line.push(input.charAt(x));
			System.out.println(line.toString());
		}
		
		input = "";
		while (line.empty() == false)
		{
			input = line.pop() + input;
		}
		return input;
	}
}