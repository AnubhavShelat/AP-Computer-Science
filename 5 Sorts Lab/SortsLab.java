//********************************************************************
//  SortsLab.java       Author: Jennifer Hsu
//
//  Driver to exercise the use of several Sorting Arrays methods.
//********************************************************************


public class SortsLab
{
	static final int MAX = 1000;
	int[] list = new int[MAX], list2 = new int[MAX], list3 = new int[MAX], list4 = new int[MAX], list5 = new int[MAX], list6 = new int[MAX], list7 = new int[MAX];
	int icount=0, scount=0, mcount=0, qcount=0, qcountm=0, qcountr=0;
	
	public SortsLab()
	{
			System.out.println("             i   s   m   q(f) q(m) q(r)");
		////////////////////////////////////////Random Order//////////////////
			System.out.print("Random    : ");
			ListSetup.MakeRandom (list);
			displayTable();
			System.out.print("Moves     : ");
			displayMoves();
		///////////////////////////////////////Ascending Order//////////////////
			System.out.print("Ascending : ");
			ListSetup.MakeInOrder(list);
			displayTable();
			System.out.print("Moves     : ");
			displayMoves();
		////////////////////////////////////////Descending Order//////////////////
			System.out.print("Descending: ");
			ListSetup.MakeReverse(list);
			displayTable();
			System.out.print("Moves     : ");
			displayMoves();
	}
	
	public void displayLists()
	{
		////////////////////////////////////////Copy List//////////////////
			ListSetup.Copy (list,list2);
			ListSetup.Copy (list,list3);
			ListSetup.Copy (list,list4);
			ListSetup.Copy (list,list5);
			ListSetup.Copy (list,list6);
			ListSetup.Copy (list,list7);
			
			System.out.println("List before sorting:");
			ListSetup.Print (list);
		////////////////////////////////////////Sort and Print//////////////////
			System.out.println("Here is the list after the InsertionSort. ");
			icount = Sorts.Insertion(list2);
			ListSetup.Print (list2);
			System.out.println("There were " + icount + " comparisons.");
			
			System.out.println("Here is the list after the SelectionSort. ");
			scount = Sorts.Selection(list3);
			ListSetup.Print (list3);
			System.out.println("There were " + scount + " comparisons.");
			
			System.out.println("Here is the list after the MergeSort. ");
			mcount = Sorts.recursiveSort(list4, 0, list.length - 1);
			ListSetup.Print (list4);
			System.out.println("There were " + mcount + " comparisons.");
			
			System.out.println("Here is the list after the QuickSort (split first). ");
			qcount = Sorts.Quick(list5, 0, list.length - 1);
			ListSetup.Print (list5);
			System.out.println("There were " + qcount + " comparisons.");
			
			System.out.println("Here is the list after the QuickSort (split middle). ");
			qcountm = Sorts.QuickMid(list6, 0, list.length - 1);
			ListSetup.Print (list6);
			System.out.println("There were " + qcountm + " comparisons.");
			
			System.out.println("Here is the list after the QuickSort (split random). ");
			qcountr = Sorts.QuickRandom(list7, 0, list.length - 1);
			ListSetup.Print (list7);
			System.out.println("There were " + qcountr + " comparisons.");
	}

	public void displayTable()
	{
			ListSetup.Copy (list,list2);
			ListSetup.Copy (list,list3);
			ListSetup.Copy (list,list4);
			ListSetup.Copy (list,list5);
			ListSetup.Copy (list,list6);
			ListSetup.Copy (list,list7);
			
			icount = Sorts.Insertion(list2);
			scount = Sorts.Selection(list3);
			mcount = Sorts.recursiveSort(list4, 0, list.length - 1);
			qcount = Sorts.Quick(list5, 0, list.length - 1);
			qcountm = Sorts.QuickMid(list6, 0, list.length - 1);
			qcountr = Sorts.QuickRandom(list7, 0, list.length - 1);
			System.out.println(icount + " " + scount + " " + mcount + " " + qcount + " " + qcountm + " " + qcountr);
	}
	
	public void displayMoves()
	{
			ListSetup.Copy (list,list2);
			ListSetup.Copy (list,list3);
			ListSetup.Copy (list,list4);
			ListSetup.Copy (list,list5);
			ListSetup.Copy (list,list6);
			ListSetup.Copy (list,list7);
			
			icount = Sorts2.Insertion(list2);
			scount = Sorts2.Selection(list3);
			mcount = Sorts2.recursiveSort(list4, 0, list.length - 1);
			qcount = Sorts2.Quick(list5, 0, list.length - 1);
			qcountm = Sorts2.QuickMid(list6, 0, list.length - 1);
			qcountr = Sorts2.QuickRandom(list7, 0, list.length - 1);
			System.out.println(icount + " " + scount + " " + mcount + " " + qcount + " " + qcountm + " " + qcountr);
	}
}
