package com.se.kamp.data;

import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * The ticket data model
 *
 * @author Manori Priyadarshani
 * @since 10/5/2019
 */
public class Ticket
{

  @SerializedName("_id")
  private String id;

  @SerializedName("url")
  private String url;

  @SerializedName("external_id")
  private String externalId;

  @SerializedName("created_at")
  private String createdAt;

  @SerializedName("subject")
  private String subject;

  @SerializedName("description")
  private String description;

  @SerializedName("priority")
  private String priority;

  @SerializedName("status")
  private String status;

  @SerializedName("submitter_id")
  private int submitterId;

  @SerializedName("tags")
  private List<String> tags;

  @SerializedName("has_incidents")
  private boolean hasIncidents;

  @SerializedName("via")
  private String via;

  @SerializedName("assignee_id")
  private int assigneeId;

  @SerializedName("organization_id")
  private int organizationId;

  @SerializedName("type")
  private String type;

  @SerializedName("due_at")
  private String dueAt;

  public String getId()
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

  public String getSubject()
  {
    return subject;
  }

  public String getDescription()
  {
    return description;
  }

  public String getPriority()
  {
    return priority;
  }

  public String getStatus()
  {
    return status;
  }

  public int getSubmitterId()
  {
    return submitterId;
  }

  public List<String> getTags()
  {
    return tags;
  }

  public boolean hasIncidents()
  {
    return hasIncidents;
  }

  public String getVia()
  {
    return via;
  }

  public int getAssigneeId()
  {
    return assigneeId;
  }

  public int getOrganizationId()
  {
    return organizationId;
  }

  public String getCreatedAt()
  {
    return createdAt;
  }

  public String getType()
  {
    return Objects.isNull(type) ? "" : type;
  }

  public String getDueAt()
  {
    return Objects.isNull(dueAt) ? "" : dueAt;
  }

}
