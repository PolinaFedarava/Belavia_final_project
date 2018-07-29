package by.htp.belavia_test.run;

import java.util.InputMismatchException;
import java.util.Scanner;


import by.htp.belavia_test.run.ScannerClass;
import by.htp.belavia_test.tests.TestOneWay;


public class UserMenu {
	
private static Scanner scanner = ScannerClass.getScanner();

public static void run() {
	userInterraction();
}
	
	private static void userInterraction() {
		int option = 0;
		boolean repeat = true;
		while (repeat) {
			System.out.println("Welcome!\n " + "1. One way ticket");
				option = scanner.nextInt();
			if (option == 1) {
				repeat = oneWayTicket();
			}  else {
				scanner.close();
				break;
			}

		}
	}
	
	private static boolean oneWayTicket() {
		int option = 0;
		int sort = 0;
		boolean iteration = true;
		while (true) {
			System.out.println("One way ticket\n "
					+ "Sorting tickets by:\n 1. Price\n 2. Departure date");

			try {
				option = scanner.nextInt();
			} catch (InputMismatchException e) {
				option = 0;
			}

			if (option == 1) {
				sort = 0;
				iteration = oneWaySteps(sort);
				break;
			} else if (option == 2) {
				sort = 1;
				iteration = oneWaySteps(sort);
				break;
			} else {
				break;
			}
		}
		return iteration;
	}
	
	private static boolean oneWaySteps(int sort) {
		TestOneWay testOneWay = new TestOneWay();
		testOneWay.initDriver();	
		testOneWay.OneWayInfoTest(sort);
		testOneWay.closeDriver();
		return false;
	}

}
