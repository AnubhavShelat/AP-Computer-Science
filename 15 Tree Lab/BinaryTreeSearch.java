// Jennifer Hsu

import java.util.*;
import java.io.*;

public class BinaryTreeSearch
{
	private TreeNode tree = null;
	Scanner scn = new Scanner(System.in);
	
	public BinaryTreeSearch()
	{
		while(true)
		{
			System.out.println("Binary Search Tree");
			System.out.println("A) Create a tree");
			System.out.println("B) Add a node");
			System.out.println("C) Display the tree sideways");
			System.out.println("D) Display a level");
			System.out.println("E) Display Preorder Traversal");
			System.out.println("F) Display Postorder Traversal");
			System.out.println("G) Display Inorder Traversal");
			System.out.println("H) Display number of nodes");
			System.out.println("I) Display number of leaves");
			System.out.println("J) Display tree height");
			System.out.println("K) Display minimum value");
			System.out.println("L) Display maximum value");
			System.out.println("M) Search for an element in the tree");
			System.out.println("N) Quit");
			System.out.print("Choice: ");
			switch(scn.nextLine().charAt(0))
			{
				case 'A':	System.out.print("Create: ");
							tree = create(tree, scn.nextLine());
							break;
				case 'B':	System.out.print("Insert: ");
							tree = insert(tree, (Comparable) scn.nextLine());
							break;
				case 'C':	displaySideways(tree, 0);
							break;
				case 'D':	System.out.print("Level: ");
							displayLevel(tree, (int) (scn.nextLine().charAt(0)) - 48, 0);
							System.out.println();
							break;
				case 'E':	preorderTraversal(tree, 0);
							System.out.println();
							break;
				case 'F':	postorderTraversal(tree, 0);
							System.out.println();
							break;
				case 'G':	inorderTraversal(tree, 0);
							System.out.println();
							break;
				case 'H':	System.out.println("Nodes: " + nodes(tree));
							break;
				case 'I':	System.out.println("Leaves: " + leaves(tree));
							break;
				case 'J':	System.out.println("Height: " + height(tree));
							break;
				case 'K':	System.out.println("Min: " + min(tree));
							break;
				case 'L':	System.out.println("Max: " + max(tree));
							break;
				case 'M':	System.out.print("Find: ");
							System.out.println("Found: " + find(tree, scn.nextLine()));
							break;
				case 'N':	return;
			}
		}
	}
	
	public TreeNode create(TreeNode t, String str)
	{
		for(int x = 0; x < str.length(); x++)
			t = insert(t, str.charAt(x) + "");
		return t;
	}

	public TreeNode insert(TreeNode t, Comparable item)
	{
		if (t == null)
			t = new TreeNode(item, null, null);
		else if (item.compareTo(t.getValue()) < 0)
			t.setLeft(insert(t.getLeft(), item));
		else if (item.compareTo(t.getValue()) > 0)
			t.setRight(insert(t.getRight(), item));
		return t;
	}
	
	public void displaySideways(TreeNode t, int level)
	{
		if (t == null)
			return;
		displaySideways(t.getRight(), level + 1);
		for(int k = 0; k < level; k++)
			System.out.print("\t");
		System.out.println(t.getValue());
		displaySideways(t.getLeft(), level + 1);
	}
	
	public void displayLevel(TreeNode t, int k, int level)
	{
		if (t == null)
			return;
		else if (level == k)
			System.out.print(t.getValue() + " ");
		else
		{
			displayLevel(t.getRight(), k, level + 1);
			displayLevel(t.getLeft(), k, level + 1);
		}
	}
	
	public void preorderTraversal(TreeNode t, int level)
	{
		if (t == null)
			return;
		System.out.print(t.getValue() + " ");
		preorderTraversal(t.getLeft(), level + 1);
		preorderTraversal(t.getRight(), level + 1);
	}
	
	public void postorderTraversal(TreeNode t, int level)
	{
		if (t == null)
			return;
		postorderTraversal(t.getLeft(), level + 1);
		postorderTraversal(t.getRight(), level + 1);
		System.out.print(t.getValue() + " ");
	}
	
	public void inorderTraversal(TreeNode t, int level)
	{
		if (t == null)
			return;
		inorderTraversal(t.getLeft(), level + 1);
		System.out.print(t.getValue() + " ");
		inorderTraversal(t.getRight(), level + 1);
	}
	
	public boolean find(TreeNode t, Comparable item)
	{
		if (t == null)
			return false;
		if (item.compareTo(t.getValue()) < 0)
			return find(t.getLeft(), item);
		if (item.compareTo(t.getValue()) > 0)
			return find(t.getRight(), item);
		return true;
	}
	
	public int nodes(TreeNode t)
	{
		if (t == null)
			return 0;
		else
			return 1 + nodes(t.getLeft()) + nodes(t.getRight());
	}
	
	public int leaves(TreeNode t)
	{
		if (t == null)
			return 0;
		else if (t.getLeft() == null && t.getRight() == null)
			return 1;
		else
			return leaves(t.getLeft()) + nodes(t.getRight());
	}
	
	public int height(TreeNode t)
	{
		if(t == null)
			return 0;
		else
			return 1 + Math.max(height(t.getLeft()), height(t.getRight()));
	}
	
	public Object min(TreeNode t)
	{
		if (t == null)
			return null;
		if (t.getLeft() == null)
			return t.getValue();
		return max(t.getLeft());
	}
	
	public Object max(TreeNode t)
	{
		if (t == null)
			return null;
		if (t.getRight() == null)
			return t.getValue();
		return max(t.getRight());
	}
}