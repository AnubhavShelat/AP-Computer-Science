//
// SimpleAlgorithms.java
// JavaProject
// Created by Jennifer Hsu.
//

import java.util.*;

public class SimpleAlgorithms {
	
	public void run()
	{
		int printInt;
		double printDouble;
		int choice = 0;
		while (choice != 8)
		{
			System.out.println("MENU");
			System.out.println("1. Factors");
			System.out.println("2. GCD");
			System.out.println("3. Prime");
			System.out.println("4. Powers");
			System.out.println("5. Nth Digit");
			System.out.println("6. Number column");
			System.out.println("7. Digits counter");
			System.out.println("8. Quit");
			System.out.print("Enter your choice: ");
			Scanner scanner = new Scanner (System.in);
			choice = scanner.nextInt();
			switch(choice)
			{
				case 1:	System.out.print("Enter a number: ");
					factors(scanner.nextInt());
					break;
				case 2:	System.out.print("Enter two numbers: ");
					printInt = gcd(scanner.nextInt(), scanner.nextInt());
					System.out.println("The GCD is " + printInt + ".");
					break;
				case 3:	System.out.print("Enter a number: ");
					printInt = scanner.nextInt();
					System.out.print("The number is ");
					if (prime(printInt) == false)
					{
						System.out.print("not ");
					}
					System.out.println("a prime number.");
					break;
				case 4: System.out.print("Enter a decimal and an integer: ");
					printDouble = power(scanner.nextDouble(), scanner.nextInt());
					System.out.println("The answer is " + printDouble + ".");
					break;
				case 5: System.out.print("Enter two numbers: ");
					printInt = findDigit(scanner.nextInt(), scanner.nextInt());
					System.out.println("The digit is " + printInt + ".");
					break;
				case 6: System.out.print("Enter a number: ");
					downDigits(scanner.nextInt());
					break;
				case 7: System.out.print("Enter a number: ");
					printInt = countDigits(scanner.nextDouble());
					System.out.println("The number of digits to the left of the decimal point is " + printInt + ".");
					break;
			}
		}
	}
	
	public void factors(int num)
	{
		System.out.print("The factors of " + num + " are:");
		for(int x = 1; x <= num; x++)
		{
			if (x == num)
			{
				System.out.print(" "+ x + ".");
			}
			else if (num % x == 0)
			{
				System.out.print(" " + x + ",");
			}
		}
	}
	
	public int gcd(int a, int b)
	{
		if (a < b)
		{
			for (int x = a; x > 0; x--)
			{
				if (a % x == 0 && b % x == 0)
				{
					return x;
				}
			}
		}
		else if (a == b)
		{
			return a;
		}
		else
		{
			return gcd(b, a);
		}
		return 0;
	}
	
	public boolean prime(int num)
	{
		if (num > 1)
		{
			for (int x = num - 1; x > 0; x--)
			{
				if (x == 1)
				{
					return true;
				}
				if (num % x == 0)
				{
					return false;
				}
			}
		}
		return false;
	}
	
	public double power(double base, int exponent)
	{
		double total = 1.0;
		if (exponent > 0)
		{
			for(int x = 0; x < exponent; x++)
			{
				total = total * base;
			}
		}
		else if (exponent != 0)
			for (int x = 0; x < (-1 * exponent); x++)
			{
				total = total / base;
			}
		return total;
	}

	// For integer powers
	public int power(int base, int exponent)
	{
		int total = 1;
		if (exponent > 0)
		{
			for(int x = 0; x < exponent; x++)
			{
				total = total * base;
			}
		}
		else if (exponent != 0)
			for (int x = 0; x < (-1 * exponent); x++)
			{
				total = total / base;
			}
		return total;
	}
	
	public int findDigit(int num, int n)
	{
		int digit;
		if (num >= 0){
			int exponent = power(10, n);
			digit = (((num % exponent) - (num % (exponent / 10))) / (exponent / 10));
			return digit;
		}
		else {
			digit = findDigit(-1 * num, n);
		}
		return digit;
	}
	
	public void downDigits(int num)
	{
		int x = 0;
		int numdigits = 0;
		int digit;
		while (x <= num){
			if (x == 0)
			{
				x = 1;
			}
			x = x * 10;
			numdigits++;
		}
		System.out.println("The digits of " + num + " are:");
		for (x = numdigits; x > 0; x--)
		{
			digit = findDigit(num, x);
			System.out.println(digit);
		}
	}
	
	public int countDigits(double num)
	{
		int x = 0;
		int count = 0;
		while (x < num){
			if (x == 0)
			{
				x = 1;
			}
			x = x * 10;
			count++;
		}
		return count;
	}
}