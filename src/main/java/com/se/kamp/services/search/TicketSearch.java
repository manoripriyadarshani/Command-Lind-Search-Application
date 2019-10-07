package com.se.kamp.services.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.se.kamp.data.Organization;
import com.se.kamp.data.Ticket;
import com.se.kamp.data.User;
import com.se.kamp.data.wrappers.TicketWrapper;
import com.se.kamp.datastore.DataStore;

/**
 * A class to handle common logic for all ticket searches
 *
 * @author Manori Priyadarshani
 * @since 10/5/2019
 */
public abstract class TicketSearch implements Search<TicketWrapper>
{

  protected final  DataStore dataStore = DataStore.getInstance();

  /**
   * Search tickets for given value and  fetch data by joining relevant other type objects(Organization, User)
   *
   * @param value the search value entered by the user as a string
   * @return List of matching TicketWrappers (a wrapper includes ticket object + required fields which are collected by
   * relevant other type objects)
   */
  @Override
  public List<TicketWrapper> search(String value)
  {
    List<TicketWrapper> matchingTicketWrappers = new ArrayList<>();

    for (Ticket ticket : getMatchingTickets(value))
    {
      String assigneeName = getAssigneeName(ticket);
      String submitterName = getSubmitterName(ticket);
      String orgName = getOrgName(ticket);

      matchingTicketWrappers.add(new TicketWrapper(ticket, assigneeName, orgName, submitterName));
    }
    return matchingTicketWrappers;
  }

  /**
   * Collect a list of matching tickets for given value
   *
   * @param value The value entered by the user
   * @return List of matching tickets
   */
  protected abstract List<Ticket> getMatchingTickets(String value);

  private String getOrgName(Ticket ticket)
  {
    List<Organization> orgs = dataStore.orgById.get(ticket.getOrganizationId());
    return Objects.isNull(orgs) ? "" : orgs.get(0).getName();
  }

  private String getSubmitterName(Ticket ticket)
  {
    List<User> submitters = dataStore.userById.get(ticket.getSubmitterId());
    return Objects.isNull(submitters) ? "" : submitters.get(0).getName();
  }

  private String getAssigneeName(Ticket ticket)
  {
    List<User> assignees = dataStore.userById.get(ticket.getAssigneeId());
    return Objects.isNull(assignees) ? "" : assignees.get(0).getName();
  }

}
