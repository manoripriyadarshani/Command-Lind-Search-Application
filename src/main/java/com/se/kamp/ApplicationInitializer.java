package com.se.kamp;

import com.se.kamp.utils.PreferenceCollector;

/**
 * Initialize the application
 *
 * @author Manori Priyadarshani
 * @since 10/5/2019
 */
public class ApplicationInitializer
{

  private static PreferenceCollector preferenceCollector = new PreferenceCollector();

  public static void main(String[] args)
  {
    String option = preferenceCollector.getPreference("type 'quit' to exit at any time, press Enter to continue ");
    SearchCLI searchCLI = new SearchCLI();

    while (!option.equalsIgnoreCase("quit") && option.equals(""))
    {
      searchCLI.continueProcess();
      option = preferenceCollector.getPreference();
    }
    System.out.println("Application is about to terminate. Bye Bye");
    System.exit(0);
  }

}
