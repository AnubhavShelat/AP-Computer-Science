// Jennifer Hsu
import java.util.*;
public class QueueLab {
	
	Queue<String> human = new LinkedList<String>();
	Queue<String> puppy = new LinkedList<String>();
	String name = "";
	
	public QueueLab()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Pick - A - Pup Exclusive Puppy Adoption Service");
		
		do
		{
			System.out.print("Client Name: ");
			name = input.nextLine();
			if (name.equals("BBB"))
				System.out.println("Because of the Better Business Bureau, we left town.");
			else if (name.equals("SPCA"))
				System.out.println("Because of the Society for the Prevention of Cruelty to Animals, we left town.");
			else
			{
				System.out.print("Please type Human or Puppy ");
				if (input.nextLine().equals("Human"))
					human.add(name);
				else
					puppy.add(name);
					
				if (human.isEmpty() || puppy.isEmpty())
				{
					System.out.println("We don't have a match for you right now,");
					System.out.println("but one is sure to turn up soon.");
				}
				else
					System.out.println("* * * * * We have a match ! " + human.poll() + " can adopt " + puppy.poll());
			} 
		} while (name.equals("BBB") == false && name.equals("SPCA") == false);
	}
}
