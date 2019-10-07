package com.se.kamp.services.searcherfactory;

import com.se.kamp.services.search.orgsearch.OrgSearchByExternalId;
import com.se.kamp.services.search.orgsearch.OrgSearchById;
import com.se.kamp.services.search.orgsearch.OrgSearchByName;
import com.se.kamp.services.search.orgsearch.OrgSearchBySharedTickets;
import com.se.kamp.services.search.orgsearch.OrgSearchByUrl;
import com.se.kamp.services.search.OrganizationSearch;

/**
 * A builder class for create  organization Searchers according to the choice
 *
 * @author Manori Priyadarshani
 * @since 10/6/2019
 */
public class OrgSearcherFactory
{
  private OrgSearcherFactory()
  {
  }

  /**
   * Create relevant organization Searcher according to the user choice
   *
   * @param orgTermChoice according to which criteria organizations going to search
   * @return Specific Ticket Searcher
   */
  public static OrganizationSearch createSearcher(String orgTermChoice)
  {
    switch (orgTermChoice.toLowerCase())
    {
      case "_id":
        return new OrgSearchById();
      case "url":
        return new OrgSearchByUrl();
      case "external_id":
        return new OrgSearchByExternalId();
      case "name":
        return new OrgSearchByName();
      case "shared_tickets":
        return new OrgSearchBySharedTickets();
      default:
        System.out.println("Invalid input. please read instructions");
        throw new IllegalStateException("Unexpected value: " + orgTermChoice);
    }

  }
}
