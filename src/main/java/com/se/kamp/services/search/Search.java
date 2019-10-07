package com.se.kamp.services.search;

import java.util.List;

/**
 * An interface for searching
 *
 * @author Manori Priyadarshani
 * @since 10/5/2019
 */
public interface Search<T>
{

  /**
   * @param value the value of searching criteria
   * @return List of searched objects
   */
  List<T> search(String value);
}
