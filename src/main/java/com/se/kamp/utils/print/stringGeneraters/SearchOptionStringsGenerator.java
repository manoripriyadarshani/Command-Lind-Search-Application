package com.se.kamp.utils.print.stringGeneraters;

/**
 * A class for generate available search options as a string
 *
 * @author Manori Priyadarshani
 * @since 10/4/2019
 */
public final class SearchOptionStringsGenerator
{

  public String getAvailableSearchOptions()
  {
    StringBuilder instructions = new StringBuilder();
    instructions.append("------------------------\n Search Users with \n");
    instructions.append(getUserSearchOption());
    instructions.append("------------------------\n Search Organisations with \n");
    instructions.append(getOrganizationSearchOption());
    instructions.append(" -----------------------\nSearch Tickets with \n");
    instructions.append(getTicketSearchOption());

    return String.valueOf(instructions);
  }

  private String getUserSearchOption()
  {
    StringBuilder string = new StringBuilder();
    string.append(" _id \n");
    string.append(" external_id\n");
    string.append(" name\n");
    string.append(" organization_id\n");
    string.append(" locale\n");

    return String.valueOf(string);
  }

  private String getOrganizationSearchOption()
  {
    StringBuilder string = new StringBuilder();
    string.append(" _id\n");
    string.append(" url\n");
    string.append(" external_id\n");
    string.append(" name\n");
    string.append(" shared_tickets\n");

    return String.valueOf(string);
  }

  private String getTicketSearchOption()
  {
    StringBuilder string = new StringBuilder();
    string.append(" _id\n");
    string.append(" external_id\n");
    string.append(" created_at\n");
    string.append(" submitter_id\n");
    string.append(" assignee_id\n");
    string.append(" priority\n");

    return String.valueOf(string);
  }
}
