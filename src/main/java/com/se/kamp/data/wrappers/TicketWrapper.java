package com.se.kamp.data.wrappers;

import com.se.kamp.data.Ticket;

/**
 * A class to wrap the Ticket with relevant other type data
 * which are collected by joining Other type objects(Organization, User)
 * This wrapper object is used to print searched tickets to the console at the end
 *
 * @author Manori Priyadarshani
 * @since 10/5/2019
 */
public class TicketWrapper
{

  private Ticket ticket;

  private String assigneeName;

  private String submitterName;

  private String organizationName;

  public TicketWrapper(Ticket ticket, String assigneeName, String organizationName, String submitterName)
  {
    this.ticket = ticket;
    this.assigneeName = assigneeName;
    this.submitterName = submitterName;
    this.organizationName = organizationName;
  }

  public Ticket getTicket()
  {
    return ticket;
  }

  public String getAssigneeName()
  {
    return assigneeName;
  }

  public String getSubmitterName()
  {
    return submitterName;
  }

  public String getOrganizationName()
  {
    return organizationName;
  }
}
