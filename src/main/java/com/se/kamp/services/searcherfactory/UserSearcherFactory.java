package com.se.kamp.services.searcherfactory;

import com.se.kamp.services.search.UserSearch;
import com.se.kamp.services.search.usersearch.UserSearchByExternalId;
import com.se.kamp.services.search.usersearch.UserSearchById;
import com.se.kamp.services.search.usersearch.UserSearchByLocale;
import com.se.kamp.services.search.usersearch.UserSearchByName;
import com.se.kamp.services.search.usersearch.UserSearchByOrgId;

/**
 * A factory class for create User searchers according to the user input
 *
 * @author Manori Priyadarshani
 * @since 10/6/2019
 */
public class UserSearcherFactory
{

  private UserSearcherFactory()
  {
  }

  /**
   * Create relevant User Searcher according to the user choice
   *
   * @param userTermChoice according to which criteria users going to search
   * @return Specific Searcher
   */
  public static UserSearch createSearcher(String userTermChoice)
  {
    switch (userTermChoice)
    {
      case "_id":
        return new UserSearchById();
      case "external_id":
        return new UserSearchByExternalId();
      case "name":
        return new UserSearchByName();
      case "organization_id":
        return new UserSearchByOrgId();
      case "locale":
        return new UserSearchByLocale();
      default:
        System.out.println("Invalid input. please read instructions");
        throw new IllegalStateException("Unexpected value: " + userTermChoice);
    }

  }
}
