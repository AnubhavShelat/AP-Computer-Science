// Jennifer Hsu

import java.util.*;

public class ListTest
{
	private SinglyLinkedList list = new SinglyLinkedList();
	private Object[] values = {"a", "b", "c", "d", "e"};
	
	public ListTest()
	{
		list = new SinglyLinkedList(values);
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		int pos = 0;
		String obj = "";
		do
		{
			System.out.println("MENU");
			System.out.println("1. isEmpty");
			System.out.println("2. size");
			System.out.println("3. contains");
			System.out.println("4. indexOf");
			System.out.println("5. add obj");
			System.out.println("6. remove obj");
			System.out.println("7. get");
			System.out.println("8. set");
			System.out.println("9. add pos, obj");
			System.out.println("10. remove pos");
			System.out.println("11. toString");
			System.out.println("12. rotateList");
			System.out.println("13. inOrder");
			System.out.println("14. putInOrder");
			System.out.println("15. quit");
			System.out.print("Choice: ");
			choice = scanner.nextInt();
			switch(choice)
			{
				case 1:	System.out.println("It is " + list.isEmpty() + " that the list is empty.");
						break;
				case 2: System.out.println("The size of the list is " + list.size() + ".");
						break;
				case 3: System.out.print("What object? ");
						System.out.println("It is " + list.contains(scanner.next()) + " that that item is in the list.");
						break;
				case 4: System.out.print("What object? ");
						System.out.println("The index of that object is " + list.indexOf(scanner.next()) + ".");
						break;
				case 5: System.out.print("What object? ");
						list.add(scanner.next());
						break;
				case 6: System.out.print("What object? ");
						list.remove(scanner.next());
						break;
				case 7: System.out.print("Which position? ");
						System.out.println("The object at that position is " + list.get(scanner.nextInt()) + ".");
						break;
				case 8: System.out.print("Which position? ");
						pos = scanner.nextInt();
						System.out.print("What object? ");
						obj = scanner.next();
						list.set(pos, obj);
						break;
				case 9: System.out.print("Which position? ");
						pos = scanner.nextInt();
						System.out.print("What object? ");
						obj = scanner.next();
						list.add(pos, obj);
						break;
				case 10: System.out.print("Which position? ");
						System.out.println("The object " + list.remove(scanner.nextInt()) + " was removed.");
						break;
				case 11: System.out.println(list.toString());
						break;
				case 12: list.rotateList();
						break;
				case 13: System.out.println("It is " + list.inOrder() + " that the list is in order."); 
						break;
				case 14: list.putInOrder();
						break; // not working
			}
		} while(choice != 15);
	}
}