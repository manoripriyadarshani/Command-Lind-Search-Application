package com.se.kamp.services.search.usersearch;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.se.kamp.data.User;
import com.se.kamp.services.search.UserSearch;

/**
 * A class to handle specific logic for search by id  from user search
 *
 * @author Manori Priyadarshani
 * @since 10/5/2019
 */
public final class UserSearchById extends UserSearch
{

  @Override
  protected List<User> getMatchingUsers(String value)
  {
    List<User> matchingUsers = dataStore.userById.get(Integer.parseInt(value));
    return Objects.isNull(matchingUsers) ? Collections.emptyList() : matchingUsers;
  }
}
