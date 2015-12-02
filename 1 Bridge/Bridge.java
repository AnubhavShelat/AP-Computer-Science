//
//  Bridge.java
//  JavaProject
//  Created by Jennifer Hsu.
//

import java.util.*;

public class Bridge {
	Random randomGenerator = new Random();
	
	public void run()
	{
		displayBridge();
		displayTable();
	}
	
	public void displayBridge()
	{
		int pos = 0;
		int steps = 0;
		while ((pos < 4) && (pos > -4))
		{
			displayStep(pos, steps);
			if (randomGenerator.nextInt(2) == 0)
				pos += -1;
			else
				pos += 1;
			steps += 1;
		}
                displayStep(pos, steps);
		System.out.println("");
	}

	public void displayStep(int pos, int steps)
	{
		//Formatter fmt = new Formatter();
		//fmt.format("%2d", steps);
		//System.out.print("Step " + fmt + ": ");
		System.out.print("Step " + steps + ": ");
		for (int a = -4; a <= 4; a++)
		{
			if (a == pos)
				System.out.print("*");
			else if (a == -4 || a == 4)
				System.out.print("|");
			else
				System.out.print("-");
		}
		System.out.println("");
	}

	public void displayTable ()
	{
		System.out.println("Length     Average     Largest");
		for(int length = 5; length <= 21; length += 2)
		{
			int max = 0;
			double total = 0.0;
			for( int x = 0; x < 50; x++)
			{
				int steps = 0;
				int pos = 0;
				while ((pos < ((length + 1 ) /2)) && (pos > -1 * ((length + 1 ) /2)))
				{
					if (randomGenerator.nextInt(2) == 0)
						pos += -1;
					else
						pos += 1;
					steps += 1;
				}
				total += steps;
				if (steps > max)
					max = steps;
			}
			//Formatter fmt = new Formatter();
			//fmt.format("%4d %11.1f %9d", length, total/50, max);
			//System.out.println(fmt);
			System.out.println(length + "     " + total/50 + "     " + max);
		}
        }
}