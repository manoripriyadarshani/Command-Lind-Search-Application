package com.se.kamp;

import java.util.List;

import com.se.kamp.data.wrappers.OrganizationWrapper;
import com.se.kamp.data.wrappers.TicketWrapper;
import com.se.kamp.data.wrappers.UserWrapper;
import com.se.kamp.services.searcherfactory.OrgSearcherFactory;
import com.se.kamp.services.searcherfactory.TicketSearcherFactory;
import com.se.kamp.services.searcherfactory.UserSearcherFactory;
import com.se.kamp.utils.PreferenceCollector;
import com.se.kamp.utils.print.printors.ConsolePrinter;
import com.se.kamp.utils.print.stringGeneraters.AsciiTableStringGenerator;
import com.se.kamp.utils.print.stringGeneraters.SearchOptionStringsGenerator;

/**
 * A class for conduct searching while collecting user inputs
 *
 * @author Manori Priyadarshani
 * @since 10/5/2019
 */
public class SearchCLI
{

  private final PreferenceCollector preferenceCollector;

  private final AsciiTableStringGenerator asciiTableStringGenerator;

  private final ConsolePrinter consolePrinter;

  public SearchCLI()
  {
    preferenceCollector = new PreferenceCollector();
    asciiTableStringGenerator = new AsciiTableStringGenerator();
    consolePrinter = new ConsolePrinter();
  }

  /**
   * when user in the continue state, show preferences to user and direct to relevant task
   */
  public void continueProcess()
  {
    String option = preferenceCollector.getPreferenceMandatory(
        "Select search options :\n \u2022 Press 1 to Search \n \u2022 Press 2 to view a list of available fields \n \u2022 Type 'Quit' to exit ");

    switch (option.toUpperCase())
    {
      case "1":
        performSearch();
        break;
      case "2":
        performListShow();
        break;
      case "QUIT":
        System.exit(0);
        break;
      default:
        exitWithWarning(option);
    }
  }

  /**
   * print all available search options
   */
  private void performListShow()
  {
    consolePrinter.print(new SearchOptionStringsGenerator().getAvailableSearchOptions());
  }

  /**
   * when user in the searching state, show preferences available and according to the choice direct to relevant task
   */
  private void performSearch()
  {
    String searchCategory = preferenceCollector.getPreferenceMandatory("Select 1)Users 2)Tickets 3)Organizations");
    checkForQuit(searchCategory);
    String searchTerm = preferenceCollector.getPreferenceMandatory("Enter search term");
    checkForQuit(searchTerm);
    String searchValue = preferenceCollector.getPreference("Enter search value");
    checkForQuit(searchValue);

    System.out.println("Searching user for " + searchTerm + " with a value of " + searchValue);

    switch (searchCategory)
    {
      case "1":
        performUserSearch(searchTerm, searchValue);
        break;
      case "2":
        performTicketSearch(searchTerm, searchValue);
        break;
      case "3":
        performOrgSearch(searchTerm, searchValue);
        break;
      default:
        exitWithWarning(searchCategory);
    }

  }

  /**
   * check whether user input is quit or not
   * If it is quit exit the application otherwise continue
   *
   * @param userInput
   */
  private void checkForQuit(String userInput)
  {
    if (userInput.equalsIgnoreCase("quit"))
    {
      System.out.println("Application is about to terminate. Bye Bye");
      System.exit(0);
    }
  }

  /**
   * search organizations according to user input and display results
   *
   * @param searchTerm
   * @param searchValue
   */
  private void performOrgSearch(String searchTerm, String searchValue)
  {
    List<OrganizationWrapper> orgs = OrgSearcherFactory.createSearcher(searchTerm).search(searchValue);
    String printString = asciiTableStringGenerator.getOrgPrintString(orgs);
    print(printString);
  }

  /**
   * search tickets according to user input and display results
   *
   * @param searchTerm
   * @param searchValue
   */
  private void performTicketSearch(String searchTerm, String searchValue)
  {
    List<TicketWrapper> tickets = TicketSearcherFactory.createSearcher(searchTerm).search(searchValue);
    String printString = asciiTableStringGenerator.getTicketPrintString(tickets);
    print(printString);
  }

  /**
   * search users according to user input and display results
   *
   * @param searchTerm
   * @param searchValue
   */
  private void performUserSearch(String searchTerm, String searchValue)
  {
    List<UserWrapper> users = UserSearcherFactory.createSearcher(searchTerm).search(searchValue);
    String printStrings = asciiTableStringGenerator.getUserPrintString(users);
    print(printStrings);
  }

  private void print(String printStrings)
  {
    if (printStrings.isEmpty())
    {
      System.out.println("No results. Press enter to continue");
    }
    else
    {
      consolePrinter.print(printStrings);
    }
  }

  private void exitWithWarning(String searchCategory)
  {
    System.out.println("Invalid input. please read instructions");
    throw new IllegalStateException("Unexpected value: " + searchCategory);
  }

}
