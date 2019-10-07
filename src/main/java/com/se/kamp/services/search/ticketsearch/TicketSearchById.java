package com.se.kamp.services.search.ticketsearch;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.se.kamp.data.Ticket;
import com.se.kamp.services.search.TicketSearch;

/**
 * A class to handle specific logic for search by Id  from ticket search
 *
 * @author Manori Priyadarshani
 * @since 10/5/2019
 */
public final class TicketSearchById extends TicketSearch
{

  @Override
  protected List<Ticket> getMatchingTickets(String value)
  {
    List<Ticket> tickets = dataStore.ticketById.get(value);
    return Objects.isNull(tickets) ? Collections.emptyList() : tickets;
  }
}
