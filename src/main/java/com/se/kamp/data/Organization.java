package com.se.kamp.data;

import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * The organization data model
 *
 * @author Manori Priyadarshani
 * @since 10/5/2019
 */
public class Organization
{

  @SerializedName("_id")
  private int id;

  @SerializedName("url")
  private String url;

  @SerializedName("external_id")
  private String externalId;

  @SerializedName("name")
  private String name;

  @SerializedName("domain_names")
  private List<String> domainNames;

  @SerializedName("created_at")
  private String createdAt;

  @SerializedName("details")
  private String details;

  @SerializedName("shared_tickets")
  private boolean sharedTickets;

  @SerializedName("tags")
  private List<String> tags;

  public int getId()
  {
    return id;
  }

  public String getUrl()
  {
    return url;
  }

  public String getExternalId()
  {
    return externalId;
  }

  public String getName()
  {
    return name;
  }

  public List<String> getDomainNames()
  {
    return domainNames;
  }

  public String getCreatedAt()
  {
    return createdAt;
  }

  public String getDetails()
  {
    return details;
  }

  public boolean getSharedTickets()
  {
    return sharedTickets;
  }

  public List<String> getTags()
  {
    return tags;
  }

}
