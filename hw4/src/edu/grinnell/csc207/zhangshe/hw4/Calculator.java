package edu.grinnell.csc207.zhangshe.hw4;

import java.math.BigInteger;

public class Calculator {

	static Fraction[] rArray = new Fraction[8];

	/**
	 * 
	 * @param str
	 *            a string which only contains integers, +, /, *, -, or a
	 *            storage name (r0-r7) if a storage assignment is being made,
	 *            the string must begin with the assignment (r'i' = ....)
	 * @return a BigInteger, whose value is computed based on the given string
	 * @throws Exception
	 * 
	 *             Citations: - Earnest's mentor session on 10 Feb.
	 */
	public static Fraction eval0(String str) throws Exception {
		String[] strArray = str.split(" ");

		int start = 1;
		int assign = 0;
		Fraction soFar = new Fraction(0, 1);
		boolean sto = false;
		if (strArray[1].compareTo("=") == 0) {
			assign = new Integer((strArray[0]).substring(1));
			sto = true;
			start = 3;
			if (strArray[2].charAt(0) == 'r') {
				soFar = rArray[new Integer(strArray[2].substring(1))];
			} else {
				soFar = Fraction.toFraction(strArray[2]);
			}
		}

		if (!sto) {
			if (strArray[0].charAt(0) == 'r') {
				soFar = rArray[new Integer(strArray[0].substring(1))];
			} else {
				soFar = Fraction.toFraction(strArray[0]);
			}
		}

		Fraction newVal = new Fraction(0, 1);
		for (int i = start; i < (strArray.length - 1); i += 2) {
			if (i + 1 < strArray.length) {
				if (strArray[i + 1].charAt(0) == 'r') {
					newVal = rArray[new Integer(strArray[i + 1].substring(1))];
				} else {
					newVal = Fraction.toFraction(strArray[i + 1]);
				}
				char command = (strArray[i]).charAt(0);

				switch (command) {
				case '+': // add
					soFar = soFar.add(newVal);
					break;
				case '-': // subtract
					soFar = soFar.subtract(newVal);
					break;
				case '*': // multiply
					soFar = soFar.multiplyFraction(newVal);
					break;
				case '/': // divide
					soFar = soFar.divide(newVal);
					break;
				default:
					throw new Exception("invalid input");
				} // switch
			} else {
				break;
			}
		}
		if (sto) {
			rArray[assign] = soFar;
		}

		return soFar;
	}

} // class Calculator