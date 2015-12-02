// Jennifer Hsu

public class Heaps
{
	static final int MAX = 40;
	int[] list = new int[MAX];
	int count = 0;

	public Heaps()
	{
		System.out.println("Heap Sort");
		System.out.println("Random    : ");
		ListSetup.MakeRandom (list);
		displayLists();
		System.out.println("Ascending : ");
		ListSetup.MakeInOrder(list);
		displayLists();
		System.out.println("Descending: ");
		ListSetup.MakeReverse(list);
		displayLists();
	}
	
	public void displayLists()
	{
		System.out.println("List before sorting:");
		ListSetup.Print(list);
		System.out.println("Here is the list after the HeapSort. ");
		sort(list);
		ListSetup.Print(list);
	}
	
	public void swap(int[] array, int a, int b)
	{
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	public void heapDown(int[] array, int k, int size)
	{
		while (k * 2 + 1 <= size)
		{
			int child = k * 2 + 1;
			if (child + 1 <= size && array[child] < array[child + 1])
				child = child + 1;
			if (array[k] < array[child])
			{
				swap(array, k, child);
				k = child;
			}
			else
				return;
		}
	}

	public void heapify(int[] array, int count)
	{
		int start = (count - 2) / 2;
		while (start >= 0)
		{
			heapDown(array, start, count - 1);
			start--;
		}
	}
	
	public void sort(int[] array)
	{
		heapify(array, array.length);
		int end = array.length - 1;
		while(end > 0)
		{
			swap(array, 0, end);
			end--;
			heapDown(array, 0, end);
		}
	}
}