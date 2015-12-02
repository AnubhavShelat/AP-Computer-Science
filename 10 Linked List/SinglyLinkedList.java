// Jennifer Hsu

// Implements a singly-linked list.

import java.util.*;

public class SinglyLinkedList implements Iterable<Object>
{
  private ListNode head;
  private int nodeCount;

  // Constructor: creates an empty list
  public SinglyLinkedList()
  {
    head = null;
    nodeCount = 0;
  }

  // Constructor: creates a list that contains
  // all elements from the array values, in the same order
  public SinglyLinkedList(Object[] values)
  {
    ListNode tail = null;
    for (Object value : values) // for each value to insert
    {
      ListNode node = new ListNode(value, null);
      if (head == null)
        head = node;
      else
        tail.setNext(node);
        tail = node;    // update tail
    }

    nodeCount = values.length;
  }
  
  public ListNode getList()
  {
	return head;
  }

  // Returns true if this list is empty; otherwise returns false.
  public boolean isEmpty()
  {
    if (nodeCount == 0)
		return true;
	else
		return false;
  }

  // Returns the number of elements in this list.
  public int size()
  {
    return nodeCount;
  }

  // Returns true if this list contains an element equal to obj;
  // otherwise returns false.
  public boolean contains(Object obj)
  {
	ListNode temp = head;
	
	while (temp.getNext() != null)
	{
		if (obj.equals(temp.getValue()))
		{
			return true;
		}
		temp = temp.getNext();
	}
	
	if (obj.equals(temp.getValue()))
		return true;
	
	return false;
  }

  // Returns the index of the first element in equal to obj;
  // if not found, returns -1.
  public int indexOf(Object obj)
  {
	int index = 0;
	ListNode temp = head;
	
	while (temp.getNext() != null)
	{
		if (obj.equals(temp.getValue()))
		{
			return index;
		}
		temp = temp.getNext();
		index++;
	}
	
	if (obj.equals(temp.getValue()))
	{
		return index;
	}
	
	return -1;
  }

  // Adds obj to this collection.  Returns true if successful;
  // otherwise returns false.
  public boolean add(Object obj)
  {
	if (nodeCount == 0)
	{
		head = new ListNode(obj, null);
	}
	else
	{
		ListNode temp = head;
		while (temp.getNext() != null)
		{
			temp = temp.getNext();
		}
		temp.setNext(new ListNode(obj, null));
		nodeCount++;
	}
	return true;
  }

  // Removes the first element that is equal to obj, if any.
  // Returns true if successful; otherwise returns false.
  public boolean remove(Object obj)
  {
	int loc = indexOf(obj);
	ListNode temp = head;
	
	if (loc < 0)
		return false;
	else if (loc == 0)
		head = head.getNext();
	else
	{
		while (loc > 1)
		{
			temp = temp.getNext();
			loc--;
		}
		temp.setNext((temp.getNext()).getNext());
	}
	nodeCount--;
	return true;
  }

  // Returns the i-th element.               
  public Object get(int i)
  {
    if (nodeCount < i)
		return false;
	ListNode temp = head;
	for (int x = 0; x < i; x++)
	{
		temp = temp.getNext();
	}
	return temp.getValue();
  }

  // Replaces the i-th element with obj and returns the old value.
  public Object set(int i, Object obj)
  {
    if (nodeCount < i)
		return -1;
	ListNode temp = head; 
	for (int x = 0; x < i; x++)
	{
		temp = temp.getNext();
	}
	Object old = temp.getValue();
	temp.setValue(obj);
	return old;
  }

  // Inserts obj to become the i-th element. Increments the size
  // of the list by one.
  public void add(int i, Object obj)
  {
	if (i >= nodeCount)
	{
		add(obj);
	}
	else
	{
		ListNode temp = head;
		for (int x = 0; x < i; x++)
		{
			temp = temp.getNext();
		}
		temp.setNext(new ListNode(temp.getValue(), temp.getNext()));
		temp.setValue(obj);
		nodeCount++;
	}
  }

  // Removes the i-th element and returns its value.
  // Decrements the size of the list by one.
  public Object remove(int i)
  {
    if (nodeCount < i)
		return false;
	ListNode temp = head;
	Object removedObj = null;
	if (i == 0)
	{
		removedObj = head.getValue();
		head = head.getNext();
	}
	else
	{
		for (int x = 0; x < i - 1; x++)
		{
			temp = temp.getNext();
		}
		removedObj = temp.getNext().getValue();
		temp.setNext(temp.getNext().getNext());
	}
	nodeCount--;
	return removedObj;
  }

  // Returns a string representation of this list.
  public String toString()
  {
    String str = "";
	ListNode temp = head;
	if (nodeCount == 0)
	{
		return "";
	}
	while (temp.getNext() != null)
	{
		str = str.concat("  " + temp.getValue());
		temp = temp.getNext();
	}
	str = str.concat("  " + temp.getValue());
	return str;
  }

  // Returns an iterator for this collection.
  public Iterator<Object> iterator()
  {
    return new SinglyLinkedListIterator(head);
  }
  
 // Splits off the first node of a nonempty list and append it to the end.
 public void rotateList()
 {
	ListNode temp = head;
	head = head.getNext();
	add(temp.getValue());
	nodeCount--;
 }
 
 // Return true if a list is in ascending order and return false if it is not.
 public boolean inOrder()
 {
	ListNode temp = head;
	while (temp.getNext() != null)
	{
		if (((String)temp.getValue()).compareTo((String)(temp.getNext()).getValue()) > 0)
			return false;
		temp = temp.getNext();
	}
	return true;
 }
 
 // "Sort" the list by putting the elements in ascending order. Duplicates are allowed, deal with them.
 public void putInOrder()
 {
	ListNode temp = head;
	Object[] list = new Object[nodeCount];
	int x = 0;
	while (temp.getNext() != null)
	{
		list[x] = (String) temp.getValue();
		temp = temp.getNext();
		x++;
	}
	list[x] = temp.getValue();
	
	for (int y = 0; y < nodeCount; y++)
	{
		System.out.print(list[y] + " ");
	}

	Arrays.sort(list);
	SinglyLinkedList newList = new SinglyLinkedList(list);
	head = newList.getList();
 }
}