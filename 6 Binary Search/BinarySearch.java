//********************************************************************
//  BinarySearch.java       Author: Jennifer Hsu
//
//  
//********************************************************************

import java.util.*;

public class BinarySearch
{
	int probes = 0;
	
	public BinarySearch()
	{
		Random rand = new Random();
		int[] array = new int[20 + rand.nextInt(31)];
		for(int a = 0; a < array.length; a++)
		{
			array[a] = rand.nextInt(100);
		}
		System.out.println("Original array of " + array.length + " elements:");
		printArray(array);
		Arrays.sort(array);
		System.out.println("Sorted array of " + array.length + " elements:");
		printArray(array);
		System.out.println("Part 2:");
		search(array);
		search(array);
		System.out.println("Part 3:");
		search2(array);
		search2(array);
	}
	
	void printArray(int[] array)
	{
		for (int a = 0; a < array.length; a++)
		{
			System.out.print(array[a] + " ");
			if (a % 10 == 9 || a == array.length - 1)
			{
				System.out.println("");
			}
		}
	}
	
	void search(int[] array)
	{
		System.out.print("What entry: ");
		Scanner scan = new Scanner(System.in);
		int value = scan.nextInt();
		int index = Arrays.binarySearch(array, value);
		if (index >= 0)
		{
			System.out.println("status: found at index " + index + ".");
		}
		else
		{
			System.out.println("status: not found.");
		}
	}
	
	void search2(int[] array)
	{
		System.out.print("What entry: ");
		Scanner scan = new Scanner(System.in);
		int value = scan.nextInt();
		int index = binary(array, 0, array.length - 1, value);
		if (index >= 0)
		{
			System.out.println("status: found at index " + index + " after " + probes + " probes.");
		}
		else
		{
			System.out.println("status: not found after " + probes + " probes.");
		}
	}
	
	int binary(int[] array, int from, int to, int value)
	{
		int mid = (from + to)/2;
		int index = -1;
		if (array[mid] == value)
		{
			probes++;
			return mid;
		}
		else if (array[mid] > value)
		{
			probes += 2;
			index = binary(array, from, mid - 1, value);
		}
		else
		{
			probes += 2;
			if (to - mid  == 0)
			{
				return -1;
			}
			index = binary(array, mid + 1, to, value);
		}
		return index;
	}
}
