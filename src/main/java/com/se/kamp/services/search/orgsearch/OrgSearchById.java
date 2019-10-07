package com.se.kamp.services.search.orgsearch;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.se.kamp.data.Organization;
import com.se.kamp.services.search.OrganizationSearch;

/**
 * A class to handle specific logic of search by Id from organisation search
 *
 * @author Manori Priyadarshani
 * @since 10/5/2019
 */
public final class OrgSearchById extends OrganizationSearch
{

  @Override
  protected List<Organization> getMatchingOrganizations(String value)
  {
    List<Organization> organizations = dataStore.orgById.get(Integer.parseInt(value));
    return Objects.isNull(organizations) ? Collections.emptyList() : organizations;
  }

}
