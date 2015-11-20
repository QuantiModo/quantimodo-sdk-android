package io.swagger.client.model;

import java.util.Date;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class Connector  {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("display_name")
  private String displayName = null;
  @SerializedName("image")
  private String image = null;
  @SerializedName("get_it_url")
  private String getItUrl = null;
  @SerializedName("short_description")
  private String shortDescription = null;
  @SerializedName("long_description")
  private String longDescription = null;
  @SerializedName("enabled")
  private Boolean enabled = null;
  @SerializedName("oauth")
  private Boolean oauth = null;
  @SerializedName("created_at")
  private Date createdAt = null;
  @SerializedName("updated_at")
  private Date updatedAt = null;

  
  /**
   * Connector ID number
   **/
  @ApiModelProperty(value = "Connector ID number")
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  
  /**
   * Lowercase system name for the data source
   **/
  @ApiModelProperty(required = true, value = "Lowercase system name for the data source")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   * Pretty display name for the data source
   **/
  @ApiModelProperty(required = true, value = "Pretty display name for the data source")
  public String getDisplayName() {
    return displayName;
  }
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  
  /**
   * URL to the image of the connector logo
   **/
  @ApiModelProperty(required = true, value = "URL to the image of the connector logo")
  public String getImage() {
    return image;
  }
  public void setImage(String image) {
    this.image = image;
  }

  
  /**
   * URL to a site where one can get this device or application
   **/
  @ApiModelProperty(required = true, value = "URL to a site where one can get this device or application")
  public String getGetItUrl() {
    return getItUrl;
  }
  public void setGetItUrl(String getItUrl) {
    this.getItUrl = getItUrl;
  }

  
  /**
   * Short description of the service (such as the categories it tracks)
   **/
  @ApiModelProperty(required = true, value = "Short description of the service (such as the categories it tracks)")
  public String getShortDescription() {
    return shortDescription;
  }
  public void setShortDescription(String shortDescription) {
    this.shortDescription = shortDescription;
  }

  
  /**
   * Longer paragraph description of the data provider
   **/
  @ApiModelProperty(required = true, value = "Longer paragraph description of the data provider")
  public String getLongDescription() {
    return longDescription;
  }
  public void setLongDescription(String longDescription) {
    this.longDescription = longDescription;
  }

  
  /**
   * Set to 1 if the connector should be returned when listing connectors
   **/
  @ApiModelProperty(required = true, value = "Set to 1 if the connector should be returned when listing connectors")
  public Boolean getEnabled() {
    return enabled;
  }
  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  
  /**
   * Set to 1 if the connector uses OAuth authentication as opposed to username/password
   **/
  @ApiModelProperty(required = true, value = "Set to 1 if the connector uses OAuth authentication as opposed to username/password")
  public Boolean getOauth() {
    return oauth;
  }
  public void setOauth(Boolean oauth) {
    this.oauth = oauth;
  }

  
  /**
   * When the record was first created. Use ISO 8601 datetime format
   **/
  @ApiModelProperty(value = "When the record was first created. Use ISO 8601 datetime format")
  public Date getCreatedAt() {
    return createdAt;
  }
  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  
  /**
   * When the record in the database was last updated. Use ISO 8601 datetime format
   **/
  @ApiModelProperty(value = "When the record in the database was last updated. Use ISO 8601 datetime format")
  public Date getUpdatedAt() {
    return updatedAt;
  }
  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Connector {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  displayName: ").append(displayName).append("\n");
    sb.append("  image: ").append(image).append("\n");
    sb.append("  getItUrl: ").append(getItUrl).append("\n");
    sb.append("  shortDescription: ").append(shortDescription).append("\n");
    sb.append("  longDescription: ").append(longDescription).append("\n");
    sb.append("  enabled: ").append(enabled).append("\n");
    sb.append("  oauth: ").append(oauth).append("\n");
    sb.append("  createdAt: ").append(createdAt).append("\n");
    sb.append("  updatedAt: ").append(updatedAt).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
