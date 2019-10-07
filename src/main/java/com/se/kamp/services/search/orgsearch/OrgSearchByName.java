package com.se.kamp.services.search.orgsearch;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.se.kamp.data.Organization;
import com.se.kamp.services.search.OrganizationSearch;

/**
 * A class to handle specific logic of search by name from organisation search
 *
 * @author Manori Priyadarshani
 * @since 10/6/2019
 */
public final class OrgSearchByName extends OrganizationSearch
{

  @Override
  protected List<Organization> getMatchingOrganizations(String value)
  {
    List<Organization> organizations = dataStore.orgByName.get(value);
    return Objects.isNull(organizations) ? Collections.emptyList() : organizations;
  }
}
