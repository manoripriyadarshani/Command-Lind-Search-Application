package com.se.kamp.data;

import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * The User data model
 *
 * @author Manori Priyadarshani
 * @since 10/5/2019
 */
public class User
{

  @SerializedName("_id")
  private int id;

  @SerializedName("url")
  private String url;

  @SerializedName("external_id")
  private String externalId;

  @SerializedName("name")
  private String name;

  @SerializedName("created_at")
  private String createdAt;

  @SerializedName("active")
  private boolean active;

  @SerializedName("shared")
  private boolean shared;

  @SerializedName("phone")
  private String phone;

  @SerializedName("signature")
  private String signature;

  @SerializedName("tags")
  private List<String> tags;

  @SerializedName("suspended")
  private boolean suspended;

  @SerializedName("role")
  private String role;

  @SerializedName("organization_id")
  private int organizationId;

  @SerializedName("verified")
  private boolean verified;

  @SerializedName("alias")
  private String alias;

  @SerializedName("locale")
  private String locale;

  @SerializedName("timezone")
  private String timezone;

  @SerializedName("last_login_at")
  private String lastLoginAt;

  @SerializedName("email")
  private String email;

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

  public String getCreatedAt()
  {
    return createdAt;
  }

  public boolean isActive()
  {
    return active;
  }

  public boolean isShared()
  {
    return shared;
  }

  public String getLastLoginAt()
  {
    return lastLoginAt;
  }

  public String getPhone()
  {
    return phone;
  }

  public String getSignature()
  {
    return signature;
  }

  public List<String> getTags()
  {
    return tags;
  }

  public boolean isSuspended()
  {
    return suspended;
  }

  public String getRole()
  {
    return role;
  }

  public int getOrganizationId()
  {
    return organizationId;
  }

  public boolean isVerified()
  {
    return verified;
  }

  public String getAlias()
  {
    return Objects.isNull(alias) ? "" : alias;
  }

  public String getLocale()
  {
    return Objects.isNull(locale) ? "" : locale;
  }

  public String getTimezone()
  {
   return  Objects.isNull(timezone) ? "" : timezone;
  }

  public String getEmail()
  {
    return Objects.isNull(email) ? "" : email;
  }
}
