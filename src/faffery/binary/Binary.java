package faffery.binary;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Binary {

	public static void main(String[] args) {
		String ip = "192.243.34.165";
		String binary = ipToBinary(ip);
		System.out.println(binary);
	}

	private static String ipToBinary(String address) {
		int[] numbers = Arrays.stream(address.split("\\.")).mapToInt(addr -> Integer.parseInt(addr)).toArray();
		return ipToBinary(numbers);
	}

	private static String ipToBinary(int... numbers) {
		String binary = String.join(":",
				Arrays.stream(numbers).mapToObj(num -> Integer.toBinaryString(num)).collect(Collectors.toList()));
		return binary;
	}

}
