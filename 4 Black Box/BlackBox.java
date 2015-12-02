//
// BlackBox.java
// JavaProject
// Created by Jennifer Hsu
//

import java.util.*;

public class BlackBox {
	
	int mirrorsfound = 0;
	
	public void run()
	{
		Scanner scanner = new Scanner(System.in);
		int[][] board = new int[10][10];
		int choice = 1;
		int shotcount = 0;
		int guesscount = 0;
		placeMirrors(board);
		displayBoard(board);
		while (choice != 0 && mirrorsfound < 10)
		{
			System.out.println("Choose:");
			System.out.println("(1) Shoot a laser");
			System.out.println("(2) Guess at a mirror location");
			System.out.println("(0) Quit the game");
			System.out.print("Enter choice: ");
			choice = scanner.nextInt();
			switch(choice)
			{
				case 1: shootLaser(board); shotcount++;
					break;
				case 2: board = guessMirror(board); guesscount++;
					break;
				case 0: break;
				default: System.out.println("Invalid choice"); break;
			}
			displayBoard(board);
			System.out.println("# of shots: " + shotcount);
			System.out.println("# of guesses: " + guesscount);
			if (mirrorsfound == 10)
			{
				System.out.println("You win!");
			}
		}
	}
	
	public void placeMirrors(int[][] board)
	{
		Random random = new Random();
		for (int a = 0; a < 10; a++)
		{
			int x = random.nextInt(10);
			int y = random.nextInt(10);
			int z = random.nextInt(2) + 1;
			if (board[x][y] == 0)
			{
				board[x][y] = z;
			}
			else
			{
				a--;
			}
		}
	}
	
	public void displayBoard(int[][] board)
	{
		System.out.println("   20 21 22 23 24 25 26 27 28 29");
		for (int y = 9; y >= 0; y--)
		{
			System.out.print(y + 10);
			for (int x = 0; x <= 9; x++)
			{
				System.out.print("  ");
				if (board[x][y] == 3)
				{
					System.out.print("/");
				}
				else if (board[x][y] == 4)
				{
					System.out.print("\\");
				}
				else
				{
					System.out.print(".");
				}
			}
			System.out.println(" " + (39 - y));
		}
		System.out.println("    0  1  2  3  4  5  6  7  8  9 ");
	}
	
	public void shootLaser(int[][] board)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Shoot from: ");
		int laser = scanner.nextInt();
		int[] position = new int[3];
		if (laser >= 0 && laser <= 9)
		{
			position[0] = laser;
			position[1] = 0;
			position[2] = 1;
		}
		else if(laser >= 10 && laser <= 19)
		{
			position[0] = 0;
			position[1] = laser - 10;
			position[2] = 2;
		}
		else if(laser >= 20 && laser <= 29)
		{
			position[0] = laser - 20;
			position[1] = 9;
			position[2] = 3;
		}
		else if (laser >= 30 && laser <=39)
		{
			position[0] = 9;
			position[1] = 39 - laser;
			position[2] = 4;
		}
		position = movePosition(position, board);
		System.out.print("The shot was deflected to: ");
		if (position[2] == 1)
			System.out.println(position[0] + 20);
		else if (position[2] == 2)
			System.out.println(39 - position[1]);
		else if (position[2] == 3)
			System.out.println(position[0]);
		else
			System.out.println(position[1] + 10);
	}
	
	public int[] movePosition(int[] position, int[][] board)
	{
		int x = position[0];
		int y = position[1];
		if (x < 0 || x > 9 || y < 0 || y > 9)
		{
			return position;
		}
		else if (board[x][y] == 1 || board[x][y] == 3)
		{
			switch(position[2])
			{
				case 1: position[2] = 2; break;
				case 2: position[2] = 1; break;
				case 3: position[2] = 4; break;
				case 4: position[2] = 3; break;
			}
		}
		else if (board[x][y] == 2 || board[x][y] == 4)
		{
			switch(position[2])
			{
				case 1: position[2] = 4; break;
				case 2: position[2] = 3; break;
				case 3: position[2] = 2; break;
				case 4: position[2] = 1; break;
			}
		}
		switch(position[2])
		{
			case 1: position[1]++; break;
			case 2: position[0]++; break;
			case 3: position[1]--; break;
			case 4: position[0]--; break;
		}
		position = movePosition(position, board);
		return position;
	}
	
	public int[][] guessMirror(int[][] board)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter coordinates: ");
		int x = scanner.nextInt();
		int y = scanner.nextInt() - 10;
		if (board[x][y] == 1)
		{
			System.out.println("You have found a mirror!");
			board[x][y] = 3;
			mirrorsfound++;
		}
		else if (board[x][y] == 2)
		{
			System.out.println("You have found a mirror!");
			board[x][y] = 4;
			mirrorsfound++;
		}
		else if (board[x][y] == 3 || board[x][y] == 4)
		{
			System.out.println("You have already found that mirror!");
		}
		else
		{
			System.out.println("There isn't a mirror there!");
		}
		return board;
	}
}