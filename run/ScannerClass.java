package by.htp.belavia_test.run;

import java.util.Scanner;

public class ScannerClass {
	
	private static Scanner scanner;

	static {
		scanner = new Scanner(System.in);
	}

	private ScannerClass() {

	}

	public static Scanner getScanner() {
		return scanner;
	}
}
