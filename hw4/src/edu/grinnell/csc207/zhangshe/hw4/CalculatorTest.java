package edu.grinnell.csc207.zhangshe.hw4;
import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void test() throws Exception {
	    Fraction a = new Fraction(new BigInteger("2"), new BigInteger("3"));
	    Calculator.eval0("2/3 + 1/3");
	    //assertEquals ()
	    
/*	    assertEquals (BigInteger.valueOf (0), Calculator.eval0 ("0"));
	    assertEquals (BigInteger.valueOf (1048576), Calculator.eval0 ("2 ^ 10 ^ 2"));
	    assertEquals (BigInteger.valueOf (2), Calculator.eval0 ("1 + 1"));
	    assertEquals (BigInteger.valueOf (4), Calculator.eval0 ("1 + 2 + 1"));
	    assertEquals (BigInteger.valueOf (9), Calculator.eval0 ("1 + 2 * 3"));
	    assertEquals (BigInteger.valueOf (0), Calculator.eval0 ("1 / 2"));
	    assertEquals (BigInteger.valueOf (0), Calculator.eval0 ("1 / 2 * 3"));
	    assertEquals (BigInteger.valueOf (6), Calculator.eval0 ("1 * 2 * 3"));
	    assertEquals (BigInteger.valueOf (396399), Calculator.eval0 ("132131 + 2 * 3"));
	    assertEquals (BigInteger.valueOf (-10), Calculator.eval0 ("-10"));
	    assertEquals (BigInteger.valueOf (0), Calculator.eval0 ("-10 + 5 + 5 * -10"));
	    assertEquals (a.pow(64).add(new BigInteger("1")), Calculator.eval0 ("2 ^ 64 + 1"));*/
	}

}
