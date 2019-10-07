package com.se.kamp.data.wrappers;

import java.util.List;

import com.se.kamp.data.Organization;

/**
 * A class to wrap the Organization with relevant other type data
 * which are collected by joining Other type objects(Ticket, User)
 * This wrapper object is used to print searched organizations to the console at the end
 *
 * @author Manori Priyadarshani
 * @since 10/5/2019
 */
public class OrganizationWrapper
{

  private Organization organization;

  private List<String> userNames;

  private List<String> ticketSubjects;

  public OrganizationWrapper(Organization organization, List<String> userNames, List<String> ticketSubjects)
  {
    this.organization = organization;
    this.userNames = userNames;
    this.ticketSubjects = ticketSubjects;
  }

  public Organization getOrganization()
  {
    return organization;
  }

  public List<String> getUserNames()
  {
    return userNames;
  }

  public List<String> getTicketSubjects()
  {
    return ticketSubjects;
  }
}
