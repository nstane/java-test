/**
 * 
 */
package com.naren.online.test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Narender Singh
 *
 */
public class OnlineTest {

	/**
	 * 
	 */
	public OnlineTest() {
		 
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 
		Arrays.asList(args).forEach(e -> System.out.println());
		// 1.... array sort based on no frequency.

		List<Integer> list = Arrays.asList(2, 1, 5, 5, 2, 1, 2, 3, 3, 4, 4, 6);
		Map<Integer, Integer> map = new HashMap<>();

		// A.. Create Frequency Map
		for (Integer i : list) {
			if (map.containsKey(i)) {
				Integer counter = map.get(i);
				map.put(i, counter + 1);
			} else {

				map.put(i, Integer.valueOf(1));
			}
		}
		System.out.println(map);
		List<Entry<Integer, Integer>> sortedEntries = new ArrayList<Entry<Integer, Integer>>(map.entrySet());

		//B.. Create comparator with Accending order
		Comparator<Entry<Integer, Integer>> compareByValue = Comparator.comparing(Entry::getValue);

		//C.. Sort Entry by decending order
 		Collections.sort(sortedEntries, compareByValue.reversed());

		System.out.println(sortedEntries.stream().map(e-> e.getKey()).collect(Collectors.toList()));

		// 2....reverse

		String str = "This is good";
		String strArr[] = str.split(" ");
		String resultString = "";
		for (String sb : strArr) {
			String revString = (new StringBuffer(sb).reverse()).toString();
			resultString += (resultString == "" ? revString : " " + revString);

		}
		// or 1) How to reverse a string in java?
		char revc[] = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = revc.length - 1; i >= 0; i--) {
			sb.append(revc[i]);
		}
		System.out.println(resultString + " & " + sb.toString());
		// 3....find missing parnathisis
		String s = "This is ((3) dummy (test.";
		char c[] = s.toCharArray();
		int letfp = 0;
		int rightp = 0;
		for (char cc : c) {
			if (cc == '(') {
				letfp++;
			} else if (cc == ')') {
				rightp++;
			}
		}
		int lmissing = letfp - rightp;
		System.out.println("missing" + lmissing);
		// 4...power

		int aa = 81;
		int bb = 3;
		@SuppressWarnings("unused")
		boolean flag = false;
		for (int i = 1; i <= (aa / 2); i++) {
			int povV = (int) Math.pow(bb, i);
			// System.out.println(povV);
			if (povV == aa) {
				flag = true;
			}
			if (povV >= aa) {
				break;
			}
		}
		int a1 = 8, b1 = 2;
		boolean flag1 = false;
		for (int i = 1; i <= (a1 / 2); i++) {
			int povV = (int) Math.pow(b1, i);
			if (povV == a1) {
				flag1 = true;
			}
			if (povV >= a1) {
				break;
			}
		}
		System.out.println(flag1);
		// sum of digit
		int num = 891;

		System.out.println(ultimateSum(num));

		// remove white spaces 3) How do you remove all white spaces from a
		// string in java?

		String n = "This is narender        singh  sw eng.";
		n = n.replaceAll("\\s", "");
		System.out.println(n);
		char ccc[] = n.toCharArray();
		@SuppressWarnings("serial")
		Set<Character> set = new HashSet<Character>() {
			{
				add(new Character((char) ccc[0]));
				add(new Character((char) ccc[0]));
				add(new Character((char) ccc[0]));
				add(new Character((char) ccc[0]));
			}
		};
		System.out.println(" HHHHH "+set);
		// is anagram '
		isAnagram("Mother In Law", "Hitler Woman");
		// missing in array
		missingNoInArray();
		// 30) percentage of uppercase, lowercase, digits and special characters
		// in a string
		characterPercentage("Tiger Runs @ The Speed Of 100 km/hour.");
		// 28) Reverse the string with preserving the position of spaces
		reverseString("I Am Not String");
		// 29) Roman equivalent of a decimal number
		romanEqualentDecimal();
		// 27) Selection sort in java
		selectionSort(new int[] { 45, 84, 101, 62, 12, 45 });

		// 24) Decimal To Binary, Decimal To Octal And Decimal To HexaDecimal In
		// Java
		decimal2Octal();
		decimal2Binary();
		decimal2Hexa();
		// 19) How to find intersection of two arrays in java?
		intersectionof2array();
		// 18) How to check whether one string is a rotation of another in java?
		areStringRotation();
	}

	// 5...sum of digits of no
	static int ultimateSum(int num) {
		// 9) How to find sum of all digits of a number in java?
		int sum = 0;

		while (num > 0) {
			sum = sum + num % 10;
			num = num / 10;
		}
		System.out.println(num);
		if (sum < 10)
			return sum;
		return ultimateSum(sum);

	}

	// 6) Anagram program in java
	static void isAnagram(String s1, String s2) {
		// Removing all white spaces from s1 and s2

		String copyOfs1 = s1.replaceAll("\\s", "");

		String copyOfs2 = s2.replaceAll("\\s", "");

		// Initially setting status as true

		boolean status = true;

		if (copyOfs1.length() != copyOfs2.length()) {
			// Setting status as false if copyOfs1 and copyOfs2 doesn't have
			// same length

			status = false;
		} else {
			// Changing the case of characters of both copyOfs1 and copyOfs2 and
			// converting them to char array
			// 5) How do you check the equality of two arrays in java?
			char[] s1Array = copyOfs1.toLowerCase().toCharArray();

			char[] s2Array = copyOfs2.toLowerCase().toCharArray();

			// Sorting both s1Array and s2Array

			Arrays.sort(s1Array);

			Arrays.sort(s2Array);

			// Checking whether s1Array and s2Array are equal

			status = Arrays.equals(s1Array, s2Array);
		}

		// Output

		if (status) {
			System.out.println(s1 + " and " + s2 + " are anagrams");
		} else {
			System.out.println(s1 + " and " + s2 + " are not anagrams");
		}
	}

	// 7) Armstrong number program in java
	public boolean isArmstrongNumber(int number) {
		String strNumber = String.valueOf(number);
		int value = 0;

		for (int i = 0; i < strNumber.length(); i++) {
			value += Math.pow(Integer.parseInt(strNumber.substring(i, i + 1)), strNumber.length());
		}

		return value == number;
	}
	// 32) Find missing number in an array
	// Method to calculate sum of 'n' numbers

	static int sumOfNnumbers(int n) {
		int sum = (n * (n + 1)) / 2;

		return sum;
	}

	// Method to calculate sum of all elements of array

	static int sumOfElements(int[] array) {
		int sum = 0;

		for (int i = 0; i < array.length; i++) {
			sum = sum + array[i];
		}

		return sum;
	}

	public static void missingNoInArray() {
		int n = 8;

		int[] a = { 1, 4, 5, 3, 7, 8, 6 };

		// Step 1

		int sumOfNnumbers = sumOfNnumbers(n);

		// Step 2

		int sumOfElements = sumOfElements(a);

		// Step 3

		int missingNumber = sumOfNnumbers - sumOfElements;

		System.out.println("Missing Number is = " + missingNumber);
	}

	static void characterPercentage(String inputString) {
		// Getting total no of characters in the given string

		int totalChars = inputString.length();

		// Initializing upperCaseLetters, lowerCaseLetters, digits and others
		// with 0

		int upperCaseLetters = 0;

		int lowerCaseLetters = 0;

		int digits = 0;

		int others = 0;

		// Iterating through each character of inputString

		for (int i = 0; i < inputString.length(); i++) {
			char ch = inputString.charAt(i);

			// If ch is in uppercase, then incrementing upperCaseLetters

			if (Character.isUpperCase(ch)) {
				upperCaseLetters++;
			}

			// If ch is in lowercase, then incrementing lowerCaseLetters

			else if (Character.isLowerCase(ch)) {
				lowerCaseLetters++;
			}

			// If ch is a digit, then incrementing digits

			else if (Character.isDigit(ch)) {
				digits++;
			}

			// If ch is a special character then incrementing others

			else {
				others++;
			}
		}

		// Calculating percentage of uppercase letters, lowercase letters,
		// digits and other characters

		double upperCaseLetterPercentage = (upperCaseLetters * 100.0) / totalChars;

		double lowerCaseLetterPercentage = (lowerCaseLetters * 100.0) / totalChars;

		double digitsPercentage = (digits * 100.0) / totalChars;

		double otherCharPercentage = (others * 100.0) / totalChars;

		DecimalFormat formatter = new DecimalFormat("##.##");

		// Printing percentage of uppercase letters, lowercase letters, digits
		// and other characters

		System.out.println("In '" + inputString + "' : ");

		System.out.println("Uppercase letters are " + formatter.format(upperCaseLetterPercentage) + "% ");

		System.out.println("Lowercase letters are " + formatter.format(lowerCaseLetterPercentage) + "%");

		System.out.println("Digits Are " + formatter.format(digitsPercentage) + "%");

		System.out.println("Other Characters Are " + formatter.format(otherCharPercentage) + "%");

		System.out.println("-----------------------------");
	}

	static void reverseString(String inputString) {
		// Converting inputString to char array 'inputStringArray'

		char[] inputStringArray = inputString.toCharArray();

		// Defining a new char array 'resultArray' with same size as
		// inputStringArray

		char[] resultArray = new char[inputStringArray.length];

		// First for loop :
		// For every space in the 'inputStringArray',
		// we insert spaces in the 'resultArray' at the corresponding positions

		for (int i = 0; i < inputStringArray.length; i++) {
			if (inputStringArray[i] == ' ') {
				resultArray[i] = ' ';
			}
		}

		// Initializing 'j' with length of resultArray

		int j = resultArray.length - 1;

		// Second for loop :
		// we copy every non-space character of inputStringArray
		// from first to last at 'j' position of resultArray

		for (int i = 0; i < inputStringArray.length; i++) {
			if (inputStringArray[i] != ' ') {
				// If resultArray already has space at index j then decrementing
				// 'j'

				if (resultArray[j] == ' ') {
					j--;
				}

				resultArray[j] = inputStringArray[i];

				j--;
			}
		}

		System.out.println(inputString + " ---> " + String.valueOf(resultArray));
	}

	public static void romanEqualentDecimal() {
		// String array containing 13 roman symbols

		String[] romanSymbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

		// int array containing 13 decimal numbers

		int[] decimals = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		// Taking input from the user

		System.out.println("Enter The Decimal Number Between 1 and 3999");

		int inputNumber = sc.nextInt();

		// Copying inputNumber into copyOfInputNumber

		int copyOfInputNumber = inputNumber;

		// Initializing 'roman' to empty string

		String roman = "";

		// Generating roman equivalent of inputNumber

		// See the below explanation to see how it works

		if (inputNumber >= 1 && inputNumber <= 3999) {
			for (int i = 0; i < 13; i++) {
				while (inputNumber >= decimals[i]) {
					inputNumber = inputNumber - decimals[i];

					roman = roman + romanSymbols[i];
				}
			}

			System.out.println("Roman Equivalent Of " + copyOfInputNumber + " is : " + roman);
		} else {
			System.out.println("Invalid Number");
		}
	}

	static void selectionSort(int[] inputArray) {
		int temp, pos;

		for (int i = 0; i < inputArray.length - 1; i++) {
			pos = i;

			// finding the position of smallest element between (i+1)th element
			// and last element

			for (int j = i + 1; j < inputArray.length; j++) {
				if (inputArray[j] < inputArray[pos]) {
					pos = j;
				}
			}

			// Swapping inputArray[i] and inputArray[pos]

			temp = inputArray[i];

			inputArray[i] = inputArray[pos];

			inputArray[pos] = temp;
		}

		for (int i = 0; i < inputArray.length; i++) {
			System.out.print(inputArray[i] + " ");
		}

		System.out.println();
	}

	// Java Program To Convert Decimal To HexaDecimal :
	public static void decimal2Hexa() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		// Taking input from the user

		System.out.println("Enter The Decimal Number : ");

		int inputNumber = sc.nextInt();

		// Copying inputNumber into copyOfInputNumber

		int copyOfInputNumber = inputNumber;

		// Initializing hexa to empty string

		String hexa = "";

		// Digits in HexaDecimal Number System

		char hexaDecimals[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

		// Defining rem to store remainder

		int rem = 0;

		// See the below explanation to know how this loop works

		while (inputNumber > 0) {
			rem = inputNumber % 16;

			hexa = hexaDecimals[rem] + hexa;

			inputNumber = inputNumber / 16;
		}

		System.out.println("HexaDecimal Equivalent of " + copyOfInputNumber + " is " + hexa);
	}

	// deceimal to octal

	public static void decimal2Octal() {
		

		// Taking input from the user

		System.out.println("Enter The Decimal Number : ");

		@SuppressWarnings("resource")
		int inputNumber = new Scanner(System.in).nextInt();

		// Copying inputNumber into copyOfInputNumber

		int copyOfInputNumber = inputNumber;

		// Initializing octal to empty string

		String octal = "";

		// Defining rem to store remainder

		int rem = 0;

		// See the below explanation to know how this loop works

		while (inputNumber > 0) {
			rem = inputNumber % 8;

			octal = rem + octal;

			inputNumber = inputNumber / 8;
		}

		System.out.println("Octal Equivalent of " + copyOfInputNumber + " is " + octal);
	}

	// decimal to binary

	public static void decimal2Binary() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		// Taking input from the user

		System.out.println("Enter The Decimal Number : ");

		int inputNumber = sc.nextInt();

		// Copying inputNumber into copyOfInputNumber

		int copyOfInputNumber = inputNumber;

		// Initializing binary to empty string

		String binary = "";

		// Defining rem to store remainder

		int rem = 0;

		// See the below explanation to know how this loop works

		while (inputNumber > 0) {
			rem = inputNumber % 2;

			binary = rem + binary;

			inputNumber = inputNumber / 2;
		}

		System.out.println("Binary Equivalent of " + copyOfInputNumber + " is " + binary);
	}

	// intersection of two array

	public static void intersectionof2array() {
		Integer[] i1 = { 1, 2, 3, 4, 5, 4 };

		Integer[] i2 = { 3, 4, 5, 6, 7, 4 };

		HashSet<Integer> set1 = new HashSet<>(Arrays.asList(i1));

		HashSet<Integer> set2 = new HashSet<>(Arrays.asList(i2));

		set1.retainAll(set2);

		System.out.println(set1); // Output : [3, 4, 5]
	}

	public static void areStringRotation() {
		String s1 = "JavaJ2eeStrutsHibernate";

		String s2 = "StrutsHibernateJavaJ2ee";

		// Step 1

		if (s1.length() != s2.length()) {
			System.out.println("s2 is not rotated version of s1");
		} else {
			// Step 2

			String s3 = s1 + s1;

			// Step 3

			if (s3.contains(s2)) {
				System.out.println("s2 is a rotated version of s1");
			} else {
				System.out.println("s2 is not rotated version of s1");
			}
		}
	}
}
