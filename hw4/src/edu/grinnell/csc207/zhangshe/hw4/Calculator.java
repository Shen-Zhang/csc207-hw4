package edu.grinnell.csc207.zhangshe.hw4;

import java.math.BigInteger;

public class Calculator
{

  /**
   * 
   * @param str
   *          a string which only contains integers, +, /, *, -
   * @return a BigInteger, whose value is computed based on the given string
   * @throws Exception
   */
  public static void
    eval0 (String str)
      throws Exception
  {
    Fraction soFar = new Fraction (BigInteger.ZERO, BigInteger.ONE);
    Fraction newVal = new Fraction (BigInteger.ZERO, BigInteger.ONE);
    int space = str.indexOf (' ');
    String copy = str;

    if (space < 0)
      {
        System.out.println (str);

      }// return the value of the string if
       // there is no space
    if (space >= 0)
      {
        String temp = copy.substring (0, space);
        int slash = temp.indexOf ("/");
        Fraction newFrac = new Fraction (BigInteger.ZERO, BigInteger.ONE);
        if (slash >= 0)
          {
            Fraction f = checkFrac (temp);
          }
        else
          {
            newFrac = new Fraction (new BigInteger (temp), BigInteger.ONE);
          }
        soFar = soFar.add (newFrac);
        // soFar gets the value of the first fraction
        copy = copy.substring (space);
        space = copy.indexOf (' ');
        char command = copy.charAt (space + 1); // get the evaluation
        int newSpace = copy.indexOf (' ', space + 3); //get the location of the next space
        
        while (newSpace >= 0)
          {
            newVal = newVal.add (new Fraction (
                                               new BigInteger (
                                                               copy.substring (space + 3,
                                                                               newSpace)),
                                               BigInteger.ONE)); // get the
            // value
            // of the second integer

            soFar = compute (soFar, newVal, command); // call compute
            newVal = new Fraction (BigInteger.ZERO, BigInteger.ONE); // set
            // the
            // second
            // integer
            // back
            // to
            // 0
            copy = copy.substring (newSpace);
            space = 0; // set space to 0;
            command = copy.charAt (space + 1);
            newSpace = copy.indexOf (' ', space + 3);
          } // while
        newVal = newVal.add (new Fraction (
                                           new BigInteger (
                                                           copy.substring (space + 3,
                                                                           newSpace)),
                                           BigInteger.ONE)); // the
        // last
        // integer

        soFar = compute (soFar, newVal, command);
        System.out.println (soFar);
      } // if space >= 0
  } // eval0

  public static Fraction
    checkFrac (String str)
  {
    Fraction frac = Fraction.toFraction (str);
    return frac;
  }

  /**
   * 
   * @param soFar
   *          a BigInteger
   * @param newVal
   *          a BigInteger
   * @param command
   *          a character
   * @return a BigInteger
   * @throws Exception
   * 
   * @precondition command can only be +, -, *, / or ^
   * @postcondition BigInteger.divide will truncate any number after the decimal
   *                points
   */
  public static Fraction
    compute (Fraction soFar, Fraction newVal, char command)
      throws Exception
  {
    switch (command)
      {
        case '+': // add
          soFar = soFar.add (newVal);
          break;
        case '-': // subtract
          soFar = soFar.subtract (newVal);
          break;
        case '*': // multiply
          soFar = soFar.multiplyFraction (newVal);
          break;
        case '/': // divide
          soFar = soFar.divide (newVal);
          break;
      } // switch
    return soFar;
  } // compute (BigInteger soFar, BigInteger newVal, char command)

} // class Calculator