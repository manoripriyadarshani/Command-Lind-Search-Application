package com.se.kamp.utils.print.stringGeneraters;


import java.util.List;

import com.se.kamp.data.Organization;
import com.se.kamp.data.Ticket;
import com.se.kamp.data.User;
import com.se.kamp.data.wrappers.OrganizationWrapper;
import com.se.kamp.data.wrappers.TicketWrapper;
import com.se.kamp.data.wrappers.UserWrapper;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestWord;

/**
 * A class for generate search results in a user friendly table format
 *
 * @author Manori Priyadarshani
 * @since 10/4/2019
 */
public final class AsciiTableStringGenerator
{

  private AsciiTable asciiTable;

  public AsciiTableStringGenerator()
  {
    this.asciiTable = getAsciiTable();
  }

  private AsciiTable getAsciiTable()
  {
    AsciiTable table = new AsciiTable();
    table.getRenderer().setCWC(new CWC_LongestWord());

    return table;
  }

  /**
   * Turn an organization data into printable string
   *
   * @param orgWrappers a list of object with all required data about organisation for printing
   * @return orgWrappers   as a displayable string
   */
  public String getOrgPrintString( List<OrganizationWrapper> orgWrappers)
  {
    StringBuilder string = new StringBuilder();
    for (OrganizationWrapper orgWrapper : orgWrappers)
    {
      string.append("\n");
      string.append(getPrintString(orgWrapper));
    }
    return String.valueOf(string);
  }

  /**
   * Turn list of ticket data into printable string
   *
   * @param ticketWrappers a list of objects with all required data about ticket for printing
   * @return ticketWrappers   as a displayable string
   */
  public String getTicketPrintString(List<TicketWrapper> ticketWrappers)
  {
    StringBuilder string = new StringBuilder();
    for (TicketWrapper ticketWrapper : ticketWrappers)
    {
      string.append("\n");
      string.append(getPrintString(ticketWrapper));
    }
    return String.valueOf(string);
  }

  /**
   * Turn list of user data into printable string
   *
   * @param userWrappers a list of objects with all required data about user for printing
   * @return UserWrapper   as a displayable string
   */
  public String getUserPrintString(List<UserWrapper> userWrappers)
  {
    StringBuilder string = new StringBuilder();
    for (UserWrapper userWrapper : userWrappers)
    {
      string.append("\n");
      string.append(getPrintString(userWrapper));
    }
    return String.valueOf(string);
  }

  private String getPrintString( OrganizationWrapper orgWrapper)
  {
    Organization org = orgWrapper.getOrganization();
    asciiTable = getAsciiTable();
    asciiTable.addRule();
    asciiTable.addRow("_id", org.getId());
    asciiTable.addRow("url", org.getUrl());
    asciiTable.addRow("externalId", org.getExternalId());
    asciiTable.addRow("name", org.getName());
    asciiTable.addRow("domain_names", getVisibleString(org.getDomainNames()));
    asciiTable.addRow("created_at", org.getCreatedAt());
    asciiTable.addRow("details", org.getDetails());
    asciiTable.addRow("shared_tickets", org.getSharedTickets());
    asciiTable.addRow("tags", getVisibleString(org.getTags()));
    addRowByListExpanding("ticketSubject_", asciiTable, orgWrapper.getTicketSubjects());
    addRowByListExpanding("user_", asciiTable, orgWrapper.getUserNames());
    asciiTable.addRule();

    return asciiTable.render();
  }

  private String getPrintString(TicketWrapper ticketWrapper)
  {
    Ticket ticket = ticketWrapper.getTicket();
    asciiTable = getAsciiTable();
    asciiTable.addRule();
    asciiTable.addRow("_id", ticket.getId());
    asciiTable.addRow("url", ticket.getUrl());
    asciiTable.addRow("externalId", ticket.getExternalId());
    asciiTable.addRow("created_at", ticket.getCreatedAt());
    asciiTable.addRow("type", ticket.getType());
    asciiTable.addRow("subject", ticket.getSubject());
    asciiTable.addRow("description", ticket.getDescription());
    asciiTable.addRow("priority", ticket.getPriority());
    asciiTable.addRow("status", ticket.getStatus());
    asciiTable.addRow("submitter_id", ticket.getSubmitterId());
    asciiTable.addRow("assignee_id", ticket.getAssigneeId());
    asciiTable.addRow("organization_id", ticket.getOrganizationId());
    asciiTable.addRow("tags", getVisibleString(ticket.getTags()));
    asciiTable.addRow("has_incidents", ticket.hasIncidents());
    asciiTable.addRow("due_at", ticket.getDueAt());
    asciiTable.addRow("via", ticket.getVia());
    asciiTable.addRow("assigneeName", ticketWrapper.getAssigneeName());
    asciiTable.addRow("organizationName", ticketWrapper.getOrganizationName());
    asciiTable.addRow("submitterName", ticketWrapper.getSubmitterName());
    asciiTable.addRule();

    return asciiTable.render();
  }

  private String getPrintString( UserWrapper userWrapper)
  {
    User user = userWrapper.getUser();
    asciiTable = getAsciiTable();
    asciiTable.addRule();
    asciiTable.addRow("_id", user.getId());
    asciiTable.addRow("url", user.getUrl());
    asciiTable.addRow("externalId", user.getExternalId());
    asciiTable.addRow("name", user.getName());
    asciiTable.addRow("alias", user.getAlias());
    asciiTable.addRow("created_at", user.getCreatedAt());
    asciiTable.addRow("active", user.isActive());
    asciiTable.addRow("verified", user.isVerified());
    asciiTable.addRow("shared", user.isShared());
    asciiTable.addRow("locale", user.getLocale());
    asciiTable.addRow("timezone", "" + user.getTimezone());
    asciiTable.addRow("last_login_at", user.getLastLoginAt());
    asciiTable.addRow("email", user.getEmail());
    asciiTable.addRow("phone", user.getPhone());
    asciiTable.addRow("signature", user.getSignature());
    asciiTable.addRow("organization_id", user.getOrganizationId());
    asciiTable.addRow("tags", getVisibleString(user.getTags()));
    asciiTable.addRow("suspend", user.isSuspended());
    asciiTable.addRow("role", user.getRole());
    addRowByListExpanding("assigneeTicket_", asciiTable, userWrapper.getAssigneeTicketSubjects());
    addRowByListExpanding("organizationName_", asciiTable, userWrapper.getOrganizationNames());
    addRowByListExpanding("assigneeTicket_", asciiTable, userWrapper.getSubmittedTicketSubjects());
    asciiTable.addRule();

    return asciiTable.render();
  }

  /**
   * get the given list in user friendly coma separated  format
   *
   * @param list
   * @return
   */
  private String getVisibleString(List<String> list)
  {
    StringBuilder string = new StringBuilder();
    list.forEach(a -> string.append(a).append(','));

    return String.valueOf(string);
  }

  /**
   * Add given list to the table as separate rows for each list element
   *
   * @param typePrefix
   * @param asciiTable
   * @param ticketSubjects
   */
  private void addRowByListExpanding(String typePrefix, AsciiTable asciiTable,
                                     List<String> ticketSubjects)
  {
    int currentIndex = 0;
    for (String tSubject : ticketSubjects)
    {
      asciiTable.addRow(typePrefix + String.valueOf(currentIndex), tSubject);
      currentIndex++;
    }
  }

}
