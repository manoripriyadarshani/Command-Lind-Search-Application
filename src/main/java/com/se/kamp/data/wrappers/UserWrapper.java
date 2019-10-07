package com.se.kamp.data.wrappers;

import java.util.List;

import com.se.kamp.data.User;

/**
 * A class to wrap the User with relevant other type data
 * which are collected by joining Other type objects(Organization, Ticket)
 * This wrapper object is used to print searched users to the console at the end
 *
 * @author Manori Priyadarshani
 * @since 10/5/2019
 */
public class UserWrapper
{

  private User user;

  private List<String> assigneeTicketSubjects;

  private List<String> submittedTicketSubjects;

  private List<String> organizationNames;

  public UserWrapper(User user, List<String> assigneeTickets, List<String> submittedTickets,
                     List<String> organizationNames)
  {
    this.user = user;
    this.assigneeTicketSubjects = assigneeTickets;
    this.submittedTicketSubjects = submittedTickets;
    this.organizationNames = organizationNames;
  }

  public User getUser()
  {
    return user;
  }

  public List<String> getAssigneeTicketSubjects()
  {
    return assigneeTicketSubjects;
  }

  public List<String> getSubmittedTicketSubjects()
  {
    return submittedTicketSubjects;
  }

  public List<String> getOrganizationNames()
  {
    return organizationNames;
  }
}
