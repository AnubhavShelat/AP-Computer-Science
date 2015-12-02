//********************************************************************
//  Sorts.java       Author: Jennifer Hsu
//
//  A collection of methods for sorting Arrays.
//********************************************************************

import java.util.*;

 public class Sorts2
{
	
	private static int[] temp;
	
	public static int Insertion(int[] list)
	{
		int move = 0;
		for (int n = 1; n < list.length; n++)
		{
			int listTemp = list[n];
			move++;
			int i = n;
			while (i > 0 && listTemp < list[i-1])
			{
				list[i] = list[i-1];
				i--;
				move++;
			}
			list[i] = listTemp;
			move++;
		}
		
		return move;
	}
	
	public static int Selection(int[] list)
	{
		int move = 0;
		for (int n = list.length; n > 1; n--)
		{
			int iMax = 0;
			for (int i = 1; i < n; i++)
			{
				if (list[i] > list[iMax])
					iMax = i;
			}
			
			swap (list, iMax, n-1);
			move += 3;
		}
		return move;
	}

	public static int Merge(int[] list, int from, int middle, int to)
	{
		int move = 0;
		temp = new int[list.length];
		int i = from, j = middle + 1, k = from;
		
		// While both arrays have elements left unprocessed:
		while (i <= middle && j <= to)
		{
			if (list[i] < list[j])
			{
				temp[k] = list[i];
				move++;
				i++;
			}
			else
			{
				temp[k] = list[j];
				move++;
				j++;
			}
			k++;
		}
		
		while (i <= middle)
		{
			temp[k] = list[i];
			move++;
			i++;
			k++;
		}
		
		while (j <= to)
		{
			temp[k] = list[j];
			move++;
			j++;
			k++;
		}
		
		for (k = from; k <= to; k++)
		{
			list[k] = temp[k];
			move++;
		}
		return move;
	}
	
	public static int recursiveSort(int[] list, int from, int to)
	{
		int move = 0;
		if (to - from < 2)       // Base case: 1 or 2 elements
		{
			if (to > from && list[to] < list[from])
			{
				int listTemp = list[to];
				list[to] = list[from];
				list[from] = listTemp;
				move += 3;
			}
			return move;
		}
		else                     // Recursive case
		{
			int middle = (from + to) / 2;
			move += recursiveSort(list, from, middle);
			move += recursiveSort(list, middle + 1, to);
			move += Merge(list, from, middle, to);
		}
		return move;
	}
	
	public static int Quick(int[] list, int from, int to)
	{
		int move = 0;
		if (from >= to)
			return 0;
		
		int p = from;
		
		int i = from;
		int j = to;
		while (i <= j)
		{
			if (list[i] <= list[p])
			{
				i++;
			}
			else if (list[j] >= list[p])
			{
				j--;
			}
			else
			{
				swap (list, i, j);
				move += 3;
				i++;
				j--;
			}
		}
		
		if (p < j)
		{
			swap (list, j, p);
			move += 3;
			p = j;
		}
		else if (p > i)
		{
			swap (list, i, p);
			move += 3;
			p = i;
		}
		
		move += Quick(list, from, p - 1);
		move += Quick(list, p + 1, to);
		
		return move;
	}
	
	public static int QuickMid(int[] list, int from, int to)
	{
		int move = 0;
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
			}
			else if (list[j] >= list[p])
			{
				j--;
			}
			else
			{
				swap (list, i, j);
				move += 3;
				i++;
				j--;
			}
		}
		
		if (p < j)
		{
			swap (list, j, p);
			move += 3;
			p = j;
		}
		else if (p > i)
		{
			swap (list, i, p);
			move += 3;
			p = i;
		}
		
		move += Quick(list, from, p - 1);
		move += Quick(list, p + 1, to);
		
		return move;
	}
	
	public static int QuickRandom(int[] list, int from, int to)
	{
		int move = 0;
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
			}
			else if (list[j] >= list[p])
			{
				j--;
			}
			else
			{
				swap (list, i, j);
				move += 3;
				i++;
				j--;
			}
		}
		
		if (p < j)
		{
			swap (list, j, p);
			move += 3;
			p = j;
		}
		else if (p > i)
		{
			swap (list, i, p);
			move += 3;
			p = i;
		}
		
		move += QuickRandom(list, from, p - 1);
		move  += QuickRandom(list, p + 1, to);
		
		return move;
	}
	
	private static void swap (int[] list, int a, int b)
	{
		int temp = list[a];
		list[a] = list[b];
		list[b] = temp;
	}
	
}