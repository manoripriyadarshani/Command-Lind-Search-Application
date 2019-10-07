package com.se.kamp.services.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.se.kamp.data.Organization;
import com.se.kamp.data.Ticket;
import com.se.kamp.data.User;
import com.se.kamp.data.wrappers.OrganizationWrapper;
import com.se.kamp.datastore.DataStore;

import static java.util.stream.Collectors.toList;

/**
 * A class to handle common logic for all organization searches
 *
 * @author Manori Priyadarshani
 * @since 10/5/2019
 */
public abstract class OrganizationSearch implements Search<OrganizationWrapper>
{

  protected final DataStore dataStore = DataStore.getInstance();

  /**
   * Search organisations for given value and  fetch data by joining relevant other type objects(Ticket, User)
   *
   * @param value the search value entered by user as string
   * @return List of matching OrganizationWrappers (a wrapper includes organisation object + required fields which are
   * collected by relevant other type objects)
   */
  @Override
  public List<OrganizationWrapper> search(String value)
  {
    List<Organization> matchingOrgs = getMatchingOrganizations(value);

    List<OrganizationWrapper> matchingOrgWrappers = new ArrayList<>();
    for (Organization org : matchingOrgs)
    {
      List<String> matchingTicketSubjects = getMatchingTicketSubjects(org);
      List<String> matchingUserNames = getMatchingUserNames(org);

      matchingOrgWrappers.add(new OrganizationWrapper(org, matchingUserNames, matchingTicketSubjects));
    }
    return matchingOrgWrappers;
  }

  /**
   * Collect a list of matching organizations for given value
   *
   * @param value The value entered by the user
   * @return List of matching organizations
   */
  protected abstract List<Organization> getMatchingOrganizations(String value);

  private List<String> getMatchingUserNames(Organization org)
  {
    List<User> matchingUsers = dataStore.userByOrgId.get(org.getId());
    return Objects.isNull(matchingUsers) ? Collections.emptyList() : matchingUsers.stream().map(User::getName)
        .collect(toList());
  }

  private List<String> getMatchingTicketSubjects(Organization org)
  {
    List<Ticket> matchingTickets = dataStore.ticketByOrgId.get(org.getId());
    return Objects.isNull(matchingTickets) ? Collections.emptyList() : matchingTickets.stream().map(Ticket::getSubject)
        .collect(toList());
  }
}
