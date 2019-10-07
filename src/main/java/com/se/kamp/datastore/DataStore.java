package com.se.kamp.datastore;

import java.util.List;
import java.util.Map;

import com.se.kamp.data.Organization;
import com.se.kamp.data.Ticket;
import com.se.kamp.data.User;

import static java.util.stream.Collectors.groupingBy;

/**
 * Store the JSON data and keep maps by grouping same type objects with different properties
 *
 * @author Manori Priyadarshani
 * @since 10/5/2019
 */
public final class DataStore
{

  private  List<Ticket> tickets;

  private   List<User> users;

  private   List<Organization> organizations;

  //Maps which are grouped tickets by different criteria
  public Map<String, List<Ticket>> ticketById;

  public Map<Boolean, List<Ticket>> ticketByHasIncidents;

  public Map<String, List<Ticket>> ticketByExternalId;

  public Map<String, List<Ticket>> ticketByCreatedAt;

  public Map<String, List<Ticket>> ticketByPriority;

  public Map<Integer, List<Ticket>> ticketByAssigneeId;

  public Map<Integer, List<Ticket>> ticketBySubmitterId;

  public Map<Integer, List<Ticket>> ticketByOrgId;

  //Maps which are grouped organizations by different criteria
  public Map<Integer, List<Organization>> orgById;

  public Map<String, List<Organization>> orgByExternalId;

  public Map<String, List<Organization>> orgByName;

  public Map<String, List<Organization>> orgByUrl;

  public Map<Boolean, List<Organization>> orgBySharedTickets;

  //Maps which are grouped users by different criteria
  public Map<Integer, List<User>> userById;

  public Map<Integer, List<User>> userByOrgId;

  public Map<String, List<User>> userByExternalId;

  public Map<String, List<User>> userByName;

  public Map<String, List<User>> userByLocale;


  private static class InstanceHolder
  {
     static final DataStore instance = new DataStore();
  }

  public static DataStore getInstance()
  {
    return InstanceHolder.instance;
  }

  private DataStore()
  {
    readJsonFiles();
    groupObjectsWithSearchingFields();
  }

  private void readJsonFiles()
  {
    tickets = new JsonReader<Ticket>("/tickets.json").readData(Ticket[].class);
    users = new JsonReader<User>("/users.json").readData(User[].class);
    organizations = new JsonReader<Organization>("/organizations.json").readData(Organization[].class);
  }

  private void groupObjectsWithSearchingFields()
  {
    userById = users.stream().collect(groupingBy(User::getId));
    userByOrgId = users.stream().collect(groupingBy(User::getOrganizationId));
    userByExternalId = users.stream().collect(groupingBy(User::getExternalId));
    userByName = users.stream().collect(groupingBy(User::getName));
    userByLocale = users.stream().collect(groupingBy(User::getLocale));

    orgById = organizations.stream().collect(groupingBy(Organization::getId));
    orgByExternalId = organizations.stream().collect(groupingBy(Organization::getExternalId));
    orgByName = organizations.stream().collect(groupingBy(Organization::getName));
    orgByUrl = organizations.stream().collect(groupingBy(Organization::getUrl));
    orgBySharedTickets = organizations.stream().collect(groupingBy(Organization::getSharedTickets));

    ticketById = tickets.stream().collect(groupingBy(Ticket::getId));
    ticketByHasIncidents = tickets.stream().collect(groupingBy(Ticket::hasIncidents));
    ticketByExternalId = tickets.stream().collect(groupingBy(Ticket::getExternalId));
    ticketByCreatedAt = tickets.stream().collect(groupingBy(Ticket::getCreatedAt));
    ticketByAssigneeId = tickets.stream().collect(groupingBy(Ticket::getAssigneeId));
    ticketBySubmitterId = tickets.stream().collect(groupingBy(Ticket::getSubmitterId));
    ticketByOrgId = tickets.stream().collect(groupingBy(Ticket::getOrganizationId));
    ticketByPriority = tickets.stream().collect(groupingBy(Ticket::getPriority));
  }
}
