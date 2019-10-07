package com.se.kamp.utils.print.printors;

/**
 * A class for display text to the user as console output
 *
 * @author Manori Priyadarshani
 * @since 10/5/2019
 */
public final class ConsolePrinter implements Printer
{

  @Override
  public void print(String printText)
  {
    System.out.println(printText);
  }

}
