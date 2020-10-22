package faffery.lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Calc {

	private static final Map<String, Calculation> calcs = new HashMap<>();

	static {
		calcs.put("+", (a, b) -> a + b);
		calcs.put("-", (int a, int b) -> {
			return a - b;
		});
		calcs.put("*", (a, b) -> a * b);
		calcs.put("/", (a, b) -> a / b);
		calcs.put("%", (a, b) -> a % b);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		do {
			calc(scan);
			System.out.println("Perform another calculation? Y/N");
		} while (scan.nextLine().equalsIgnoreCase("y"));

		scan.close();
	}

	private static int getNumber(Scanner scanner) {
		Integer num = null;

		do {
			try {
				num = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException nfe) {
				System.out.println("Please enter a number!");
			}
		} while (num == null);

		return num;
	}

	private static void calc(Scanner scanner) {
		System.out.println("Num1: ");
		Integer num1 = getNumber(scanner);

		System.out.println("Operation:");
		String operation = scanner.nextLine();

		System.out.println("Num2: ");
		Integer num2 = getNumber(scanner);

		System.out.println(num1 + " " + operation + " " + num2 + " = " + calcs.get(operation).calc(num1, num2));
	}

}
