// Jennifer Hsu

import java.util.*;

public class BankSimulation
{
	Random randomGenerator = new Random();
	PriorityQueue<Customer> line = new PriorityQueue<Customer>();
	
	int clock, peopleserved, totalwaitingtime, longestwaitingtime, totalqueue, longestqueue;
	boolean currentlyServing = false;
	int avgpeopleserved = 0;
	int alongestwaitingtime = 0;
	int avgwaitingtime = 0;
	int avgqueue = 0;
	int alongestqueue = 0;
	int days = 10;
	
	public BankSimulation()
	{
		for (int x = 0; x < 10; x++)
		{
			System.out.println("DAY " + x + ":");
			line = new PriorityQueue<Customer>();
			oneDay();
		}
		
		System.out.println((avgpeopleserved / days) + " people were served on average over " + days + " days.");
		System.out.println("The longest waiting time was " + alongestwaitingtime + ".");
		System.out.println("The average waiting time was " + (avgwaitingtime / avgpeopleserved) + ".");
		System.out.println("The longest queue length was " + alongestqueue + ".");
		System.out.println("The average queue length was " + (avgqueue / days) + ".");
	}
	
	public void oneDay()
	{
		clock = 0;
		peopleserved = 0;
		totalwaitingtime = 0;
		longestwaitingtime = 0;
		totalqueue = 0;
		longestqueue = 0;
		currentlyServing = false;
		
		while (clock <= 480 || line.size() > 0)
		{			
			if (randomGenerator.nextInt(9) == 0 && clock <= 480)
			{
				line.add(new Customer(clock));
				peopleserved++;
				
				if (currentlyServing == false)
				{
					serveOne();
					currentlyServing = true;
				}
			}
			
			if (currentlyServing == true && randomGenerator.nextInt(5) == 0)
			{
				currentlyServing = false;
			}
			
			if (currentlyServing == false && line.size() > 0)
			{
				serveOne();
				currentlyServing = true;
			}
			
			totalqueue += line.size();
			if (line.size() > longestqueue)
				longestqueue = line.size();
			displayQueue();
			clock++;
		}
		
		while (line.size() != 0)
		{
			if (randomGenerator.nextInt(5) == 0)
			{
				serveOne();
			}
		}
		
		avgpeopleserved += peopleserved;
		System.out.println(peopleserved + " people were served today.");
		if (alongestwaitingtime < longestwaitingtime)
			alongestwaitingtime = longestwaitingtime;
		System.out.println("The longest waiting time was " + longestwaitingtime + ".");
		avgwaitingtime += totalwaitingtime;
		System.out.println("The average waiting time was " + (totalwaitingtime / peopleserved) + ".");
		
		if (alongestqueue < longestqueue)
			alongestqueue = longestqueue;
		System.out.println("The longest queue length was " + longestqueue + ".");
		avgqueue += totalqueue / 480;
		System.out.println("The average queue length was " + (totalqueue / 480) + ".");
	}
	
	public void displayQueue()
	{ 
		Formatter fmt = new Formatter();
		fmt.format("%3d", clock); 
		System.out.print("Time " + fmt + ": ");
		if (currentlyServing == true)
			System.out.print("O");
		
		PriorityQueue<Customer> lineC = new PriorityQueue<Customer>();
		while(!line.isEmpty())
		{
			Customer x = line.remove();
			System.out.print(x.toStr());
			lineC.add(x);
		}
			
		while(!lineC.isEmpty())
			line.add(lineC.remove());
		System.out.println();
	}
	
	public void serveOne()
	{
		int waittime = clock - line.remove().getTime();
		totalwaitingtime += waittime;
		if (waittime > longestwaitingtime)
			longestwaitingtime = waittime;
	}
}