//
//  JavaProject.java
//  JavaProject
//  Created by Jennifer Hsu.
//

import java.util.*;

public class JavaProject {
	public static void main (String args[]) {
		SortsLab sl = new SortsLab();
	}
	
	static void run() {
		System.out.println("Programs:");
		System.out.println("1 Bridge walk");
		System.out.println("2 Simple Algorithms");
		System.out.println("3 Manipulating Arrays");
		System.out.println("4 Black Box");
		System.out.println("5 Black Box 2");
		System.out.println("6 Sorts");
		System.out.print("Enter choice: ");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		switch(choice)
		{
			case 1: Bridge b = new Bridge(); b.run(); break;
			case 2: SimpleAlgorithms sa = new SimpleAlgorithms(); sa.run(); break;
			case 3: ManipulatingArrays ma = new ManipulatingArrays(); ma.run(); break;
			case 4: BlackBox bb = new BlackBox(); bb.run(); break;
			case 5: BlackBox2 bb2 = new BlackBox2(); bb2.run(); break;
			case 6: SortsLab sl = new SortsLab(); break;
		}
	}
}