package com.se.kamp.services.searcherfactory;

import com.se.kamp.services.search.TicketSearch;
import com.se.kamp.services.search.ticketsearch.TicketSearchByAssigneeId;
import com.se.kamp.services.search.ticketsearch.TicketSearchByCreatedAt;
import com.se.kamp.services.search.ticketsearch.TicketSearchByExternalId;
import com.se.kamp.services.search.ticketsearch.TicketSearchById;
import com.se.kamp.services.search.ticketsearch.TicketSearchByPriority;
import com.se.kamp.services.search.ticketsearch.TicketSearchBySubmitterId;

/**
 * A factory class for create ticket searchers according to the user input
 *
 * @author Manori Priyadarshani
 * @since 10/6/2019
 */
public class TicketSearcherFactory
{
  private TicketSearcherFactory()
  {
  }

  /**
   * Create relevant ticket Searcher according to the user choice
   *
   * @param ticketTermChoice according to which criteria tickets going to search
   * @return Specific Ticket Searcher
   */
  public static TicketSearch createSearcher(String ticketTermChoice)
  {
    switch (ticketTermChoice.toLowerCase())
    {
      case "_id":
        return new TicketSearchById();
      case "external_id":
        return new TicketSearchByExternalId();
      case "created_at":
        return new TicketSearchByCreatedAt();
      case "submitter_id":
        return new TicketSearchBySubmitterId();
      case "assignee_id":
        return new TicketSearchByAssigneeId();
      case "priority":
        return new TicketSearchByPriority();
      default:
        System.out.println("Invalid input. please read instructions");
        throw new IllegalStateException("Unexpected value: " + ticketTermChoice);
    }

  }
}
