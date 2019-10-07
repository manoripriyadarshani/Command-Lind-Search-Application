package com.se.kamp.utils;

import java.util.Scanner;

/**
 * A utility class for display instructions to the user and collect preferences
 *
 * @author Manori Priyadarshani
 * @since 10/5/2019
 */
public final class PreferenceCollector
{

  private Scanner scanner;

  public PreferenceCollector()
  {
    this.scanner = new Scanner(System.in);
  }

  /**
   * get the user preference by displaying the instruction and if user pres enter (empty line) redisplay instructions
   * again and ask to re enter
   * (this method is used to handle 'enter' pressing mistakenly by the user )
   *
   * @param instruction the instruction which need to display  to the user
   * @return user preference
   */
  public String getPreferenceMandatory(String instruction)
  {
    System.out.println(instruction);
    String choice = scanner.nextLine();
    if (!choice.equals(""))
    {
      return choice;
    }
    else
    {
      System.out.println("please enter your choice");
      return getPreferenceMandatory(instruction);
    }
  }

  /**
   * Show the instruction to the user and return preference
   *
   * @param instruction
   * @return
   */
  public String getPreference(String instruction)
  {
    System.out.println(instruction);
    return scanner.nextLine();
  }

  /**
   * Just scan the preference and return
   *
   * @return
   */
  public String getPreference()
  {
    return scanner.nextLine();
  }

}
