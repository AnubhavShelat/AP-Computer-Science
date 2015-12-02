//
// BlackBox.java
// JavaProject
// Created by Jennifer Hsu
//

import java.util.*;

public class BlackBox2 {
	
	int mirrorsfound = 0;
	
	public void run()
	{
		int[][] board = new int[10][10];
		Scanner scanner = new Scanner(System.in);
		int laser = 0;
		int player = 0;
		int x, y;
		placeMirrors(board);
		displayBoard(board);
		while (mirrorsfound < 10)
		{
			System.out.println("Player " + (player + 1) + ", it's your turn.");
			System.out.println("Shoot a laser");
			
			System.out.print("Shoot from: ");
			laser = scanner.nextInt();
			shootLaser(laser, board);
			
			System.out.println("Guess at a mirror location");
			System.out.print("Enter coordinates: ");
			x = scanner.nextInt();
			y = scanner.nextInt() - 10;
			if (x >= 0 && x <= 9);
			else if (x>=20 && x <= 29);

			guessMirror(x, y, board);
			
			displayBoard(board);
			
			if (mirrorsfound == 10)
			{
				System.out.println("Player " + (player + 1) + "wins!");
			}
			
			if (player == 0)
			{
				player = 1;
			}
			else
			{
				player = 0;
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
				System.out.println(x + " " + y + " " + z);
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
	
	public void shootLaser(int laser, int[][] board)
	{
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
	
	public int[][] guessMirror(int x, int y, int[][] board)
	{
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