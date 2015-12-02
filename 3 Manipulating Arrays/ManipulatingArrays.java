//
// ManipulatingArrays.java
// JavaProject
// Created by Jennifer Hsu.
//

import java.util.*;

public class ManipulatingArrays {
	
	public void run()
	{
		Scanner scanner = new Scanner (System.in);
		System.out.print("Enter size of array: ");
		int arraysize = scanner.nextInt();
		System.out.print("Enter entries of array: ");
		int[] array = new int[arraysize];
		for (int x = 0; x < arraysize; x++)
		{
			array[x] = scanner.nextInt();
		}
		displayArray(array);
		int choice = 0;
		String again = "y";
		while (choice != 5)
		{
			System.out.println("MENU");
			System.out.println("1. Search Array");
			System.out.println("2. Switch Entry");
			System.out.println("3. Rotate Array");
			System.out.println("4. Delete Zeros");
			System.out.println("5. Quit");
			System.out.println("Enter your choice: ");
			choice = scanner.nextInt();
			switch (choice)
			{
				case 1: again = "y";
					while (again.equals("Y") || again.equals("y"))
					{
						searchArray(array);
						System.out.print("another search (y/n)? ");
						again = scanner.next();
					}
					break;
				case 2: array = switchEntry(array);
					break;
				case 3: again = "y";
					while (again.equals("Y") || again.equals("y"))
					{
						array = rotateArray(array);
						System.out.print("another search (y/n)? ");
						again = scanner.next();
					}
					break;
				case 4: array = deleteZeros(array);
					break;
			}
		}
	}
	
	public void displayArray(int[] array)
	{
		System.out.println("  size of array: " + array.length);
		System.out.print("array positions: ");
		for (int x = 0; x < array.length; x++)
		{
			
			System.out.print(x + " ");
		}
		System.out.println("");
		System.out.print("  array entries: ");
		for (int x = 0; x < array.length; x++)
		{
			
			System.out.print(array[x] + " ");
		}
		System.out.println("");
	}
	
	public void searchArray(int[] array)
	{
		int entry, status;
		Scanner scanner = new Scanner (System.in);
		System.out.print("         what entry? ");
		entry = scanner.nextInt();
		System.out.print("             status: ");
		status = searchEntry(array, entry);
		if (status == -1)
		{
			System.out.println("not found");
		}
		else
		{
			System.out.println("found at position " + status);
		}
	}
	
	public int searchEntry(int[] array, int entry)
	{
		for (int x = 0; x < array.length; x++)
		{
			if (array[x] == entry)
			{
				return x;
			}
		}
		return -1;
	}
	
	public int[] switchEntry(int[] array)
	{
		int smallest = array[0];
		int position = 0;
		System.out.println("smallest entry first");
		for (int x = 0; x < array.length; x++)
		{
			if (smallest > array[x])
			{
				smallest = array[x];
				position = x;
			}
		}
		array[position] = array[0];
		array[0] = smallest;
		displayArray(array);
		return array;
	}
	
	public int[] rotateArray(int[] array)
	{
                int[] array2 = new int[array.length];
		Scanner scanner = new Scanner (System.in);
		System.out.print("how many steps? ");
		int rotation = scanner.nextInt();
		System.out.println("rotated array");
		rotation = -1 * (rotation % array.length);
		if (rotation < 0)
		{
			rotation = array.length + rotation;
		}
		for (int x = 0; x < array.length; x++)
		{
			if (x + rotation < array.length)
			{
				array2[x] = array[x + rotation];
			}
			else
			{
				array2[x] = array[x + rotation - array.length];
			}
		}
		displayArray(array2);
                return array2;
	}
	
	public int[] deleteZeros(int[] array)
	{
		int zerocount = 0;
		for (int x = 0; x < array.length; x++)
		{
			if (array[x] == 0)
			{
				zerocount++;
			}
		}
		int[] array2 = new int[array.length - zerocount];
		zerocount = 0;
		for (int x = 0; x < array2.length; x++)
		{
			if (array[x + zerocount] == 0)
			{
				zerocount++;
				array2[x] = array[x + zerocount];
				x--;
			}
			else
			{
				array2[x] = array[x + zerocount];	
			}
		}
		displayArray(array2);
		return array2;
	}
}