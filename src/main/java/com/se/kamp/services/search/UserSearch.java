package com.se.kamp.services.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.se.kamp.data.Organization;
import com.se.kamp.data.Ticket;
import com.se.kamp.data.User;
import com.se.kamp.data.wrappers.UserWrapper;
import com.se.kamp.datastore.DataStore;

import static java.util.stream.Collectors.toList;

/**
 * A class to handle common logic for all user searches
 *
 * @author Manori Priyadarshani
 * @since 10/5/2019
 */
public abstract class UserSearch implements Search<UserWrapper>
{

  protected final DataStore dataStore = DataStore.getInstance();

  /**
   * Search users for given value and  fetch data by joining relevant other type objects(Ticket, Organization)
   *
   * @param value The value of search criteria which is entered by the user as a string
   * @return List of matching UserWrappers (a wrapper includes user object + required fields which are
   * collected by relevant other type objects)
   */
  @Override
  public List<UserWrapper> search(String value)
  {
    List<User> matchingUsers = getMatchingUsers(value);

    List<UserWrapper> matchingUserWrappers = new ArrayList<>();
    for (User user : matchingUsers)
    {
      List<String> matchingAssignedTicketSubjects = getMatchingAssignedTicketSubjects(user);
      List<String> matchingSubmittedTicketSubjects = getMatchingSubmittedTicketSubjects(user);
      List<String> matchingOrganizationNames = getMatchingOrganizations(user);

      matchingUserWrappers.add(
          new UserWrapper(user, matchingAssignedTicketSubjects, matchingSubmittedTicketSubjects,
              matchingOrganizationNames));

    }
    return matchingUserWrappers;
  }

  /**
   * Collect a list of matching users for given value
   *
   * @param value The value of search criteria which is entered by the user
   * @return List of matching users
   */
  protected abstract List<User> getMatchingUsers(String value);

  private List<String> getMatchingOrganizations(User user)
  {
    List<Organization> matchingOrganizations = dataStore.orgById.get(user.getOrganizationId());
    return Objects.isNull(matchingOrganizations) ? Collections.emptyList() : matchingOrganizations.stream()
        .map(Organization::getName)
        .collect(toList());
  }

  private List<String> getMatchingAssignedTicketSubjects(User user)
  {
    List<Ticket> matchingAssigneeTickets = dataStore.ticketByAssigneeId.get(user.getId());
    return Objects.isNull(matchingAssigneeTickets) ? Collections.emptyList() : matchingAssigneeTickets.stream()
        .map(Ticket::getSubject).collect(toList());
  }

  private List<String> getMatchingSubmittedTicketSubjects(User user)
  {
    List<Ticket> matchingUserSubmittedTickets = dataStore.ticketBySubmitterId.get(user.getId());
    return Objects.isNull(matchingUserSubmittedTickets) ? Collections.emptyList() : matchingUserSubmittedTickets
        .stream().map(Ticket::getSubject)
        .collect(toList());
  }

}
