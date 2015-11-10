package io.swagger.client.model;


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
   * Connector lowercase system name
   **/
  @ApiModelProperty(required = true, value = "Connector lowercase system name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   * Connector pretty display name
   **/
  @ApiModelProperty(required = true, value = "Connector pretty display name")
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
   * Short description
   **/
  @ApiModelProperty(required = true, value = "Short description")
  public String getShortDescription() {
    return shortDescription;
  }
  public void setShortDescription(String shortDescription) {
    this.shortDescription = shortDescription;
  }

  
  /**
   * Long description
   **/
  @ApiModelProperty(required = true, value = "Long description")
  public String getLongDescription() {
    return longDescription;
  }
  public void setLongDescription(String longDescription) {
    this.longDescription = longDescription;
  }

  
  /**
   * enabled
   **/
  @ApiModelProperty(required = true, value = "enabled")
  public Boolean getEnabled() {
    return enabled;
  }
  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  
  /**
   * oauth
   **/
  @ApiModelProperty(required = true, value = "oauth")
  public Boolean getOauth() {
    return oauth;
  }
  public void setOauth(Boolean oauth) {
    this.oauth = oauth;
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
    sb.append("}\n");
    return sb.toString();
  }
}
