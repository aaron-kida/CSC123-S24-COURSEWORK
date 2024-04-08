package Scan;

import java.io.IOException;
import java.util.NoSuchElementException;

public class ScannerTest {

	public static void main(String[] args) {
		MyScanner scanner = new MyScanner(132134.09);
		try {
		System.out.print(scanner.nextDouble());
		System.out.print(scanner.next());
		} catch (IOException e) {
			System.out.print("fucker");
		}
	}

}
