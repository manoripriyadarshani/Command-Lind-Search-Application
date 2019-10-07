package com.se.kamp.services.search.usersearch;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.se.kamp.data.User;
import com.se.kamp.services.search.UserSearch;

/**
 * A class to handle specific logic for search by name  from user search
 *
 * @author Manori Priyadarshani
 * @since 10/6/2019
 */
public final class UserSearchByName extends UserSearch
{

  @Override
  protected List<User> getMatchingUsers(String value)
  {
    List<User> users = dataStore.userByName.get(value);
    return Objects.isNull(users) ? Collections.emptyList() : users;
  }
}
