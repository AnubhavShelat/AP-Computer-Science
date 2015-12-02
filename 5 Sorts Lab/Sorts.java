//********************************************************************
//  Sorts.java       Author: Jennifer Hsu
//
//  A collection of methods for sorting Arrays.
//********************************************************************

import java.util.*;

 public class Sorts
{
	
	private static int[] temp;
	
	public static int Insertion(int[] list)
	{
		int count = 0;
		for (int n = 1; n < list.length; n++)
		{
			// Save the next element to be inserted:
			
			int listTemp = list[n];
			
			// Going backward from list[n-1], shift elements to the
			//   right until you find an element list[i] <= aTemp:
			
			int i = n;
			while (i > 0 && listTemp < list[i-1])
			{
				list[i] = list[i-1];
				i--;
				count ++;
			}
			count++;
			
			// Insert the saved element after a[i]:
			list[i] = listTemp;
			
			// Increment n (accomplished by n++ in the for loop).
		}
		
		return count;
	}
	
	public static int Selection(int[] list)
	{
		int count = 0;
		for (int n = list.length; n > 1; n--)
		{
			// Find the index iMax of the largest element
			//   among list[0], ..., list[n-1]:
			
			int iMax = 0;
			for (int i = 1; i < n; i++)
			{
				if (list[i] > list[iMax])
					iMax = i;
				count++;
			}
			
			swap (list, iMax, n-1);
			
			// int listTemp = list[iMax];
			// list[iMax] = list[n-1];
			// list[n-1] = listTemp;
			
			// Decrement n (accomplished by n-- in the for loop).
		}
		return count;
	}

	public static int Merge(int[] list, int from, int middle, int to)
	{
		int count = 0;
		temp = new int[list.length];
		int i = from, j = middle + 1, k = from;
		
		// While both arrays have elements left unprocessed:
		while (i <= middle && j <= to)
		{
			if (list[i] < list[j])
			{
				temp[k] = list[i];   // Or simply temp[k] = a[i++];
				i++;
			}
			else
			{
				temp[k] = list[j];
				j++;
			}
			k++;
			count ++;
		}
		count++;
		
		// Copy the tail of the first half, if any, into temp:
		while (i <= middle)
		{
			temp[k] = list[i];     // Or simply temp[k++] = a[i++]
			i++;
			k++;
		}
		
		// Copy the tail of the second half, if any, into temp:
		while (j <= to)
		{
			temp[k] = list[j];     // Or simply temp[k++] = a[j++]
			j++;
			k++;
		}
		
		// Copy temp back into a
		for (k = from; k <= to; k++)
			list[k] = temp[k];
		return count;
	}
	
	public static int recursiveSort(int[] list, int from, int to)
	{
		int count = 0;
		if (to - from < 2)       // Base case: 1 or 2 elements
		{
			if (to > from && list[to] < list[from])
			{
				int listTemp = list[to];  // swap a[to] and a[from]
				list[to] = list[from];
				list[from] = listTemp;
			}
			return 1;
		}
		else                     // Recursive case
		{
			int middle = (from + to) / 2;
			count += recursiveSort(list, from, middle);
			count += recursiveSort(list, middle + 1, to);
			count += Merge(list, from, middle, to);
		}
		return count;
	}
	
	public static int Quick(int[] list, int from, int to)
	{
		int count = 0;
		if (from >= to)
			return 0;
		
		// Choose pivot list[p]:
		int p = from;
		// The choice of the pivot location may vary:
		//   you can also use p = from or p = to or use 
		//   a fancier method, say, the median of the above three.
		
		// Partition:
		
		int i = from;
		int j = to;
		while (i <= j)
		{
			if (list[i] <= list[p])
			{
				i++;
				count++;
			}
			else if (list[j] >= list[p])
			{
				j--;
				count += 2;
			}
			else
			{
				swap (list, i, j);
				i++;
				j--;
				count += 2;
			}
		}
		
		// Finish partitioning:
		
		if (p < j)    // place the pivot in its correct position
		{
			swap (list, j, p);
			p = j;
		}
		else if (p > i)
		{
			swap (list, i, p);
			p = i;
		}
		
		// Sort recursively:
		count += Quick(list, from, p - 1);
		count += Quick(list, p + 1, to);
		
		return count;
	}
	
	public static int QuickMid(int[] list, int from, int to)
	{
		int count = 0;
		if (from >= to)
			return 0;
		
		int p = (from + to) / 2;
		
		int i = from;
		int j = to;
		while (i <= j)
		{
			if (list[i] <= list[p])
			{
				i++;
				count ++;
			}
			else if (list[j] >= list[p])
			{
				j--;
				count += 2;
			}
			else
			{
				swap (list, i, j);
				i++;
				j--;
				count += 2;
			}
		}
		
		// Finish partitioning:
		
		if (p < j)    // place the pivot in its correct position
		{
			swap (list, j, p);
			p = j;
		}
		else if (p > i)
		{
			swap (list, i, p);
			p = i;
		}
		
		// Sort recursively:
		count += QuickMid(list, from, p - 1);
		count += QuickMid(list, p + 1, to);
		
		return count;
	}
	
	public static int QuickRandom(int[] list, int from, int to)
	{
		int count = 0;
		if (from >= to)
			return 0;
		
		Random random = new Random();
		int p = random.nextInt(list.length);
		
		int i = from;
		int j = to;
		while (i <= j)
		{
			if (list[i] <= list[p])
			{
				i++;
				count++;
			}
			else if (list[j] >= list[p])
			{
				j--;
				count += 2;
			}
			else
			{
				swap (list, i, j);
				i++;
				j--;
				count += 2;
			}
		}
		
		// Finish partitioning:
		
		if (p < j)    // place the pivot in its correct position
		{
			swap (list, j, p);
			p = j;
		}
		else if (p > i)
		{
			swap (list, i, p);
			p = i;
		}
		
		// Sort recursively:
		count += QuickRandom(list, from, p - 1);
		count += QuickRandom(list, p + 1, to);
		
		return count;
	}
	
	private static void swap (int[] list, int a, int b)
	{
		int temp = list[a];
		list[a] = list[b];
		list[b] = temp;
	}
	
}