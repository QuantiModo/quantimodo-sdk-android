package io.swagger.client.model;


import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class Connector  {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("displayName")
  private String displayName = null;
  @SerializedName("image")
  private String image = null;
  @SerializedName("getItUrl")
  private String getItUrl = null;
  @SerializedName("connected")
  private String connected = null;
  @SerializedName("connectInstructions")
  private String connectInstructions = null;
  @SerializedName("lastUpdate")
  private Integer lastUpdate = null;
  @SerializedName("totalMeasurementsInLastUpdate")
  private Integer totalMeasurementsInLastUpdate = null;
  @SerializedName("noDataYet")
  private Boolean noDataYet = null;

  /**
   * Connector ID number
   **/
  @ApiModelProperty(required = true, value = "Connector ID number")
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
   * True if the authenticated user has this connector enabled
   **/
  @ApiModelProperty(required = true, value = "True if the authenticated user has this connector enabled")
  public String getConnected() {
    return connected;
  }
  public void setConnected(String connected) {
    this.connected = connected;
  }

  /**
   * URL and parameters used when connecting to a service
   **/
  @ApiModelProperty(required = true, value = "URL and parameters used when connecting to a service")
  public String getConnectInstructions() {
    return connectInstructions;
  }
  public void setConnectInstructions(String connectInstructions) {
    this.connectInstructions = connectInstructions;
  }

  /**
   * Epoch timestamp of last sync
   **/
  @ApiModelProperty(required = true, value = "Epoch timestamp of last sync")
  public Integer getLastUpdate() {
    return lastUpdate;
  }
  public void setLastUpdate(Integer lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  /**
   * Number of measurements obtained during latest update
   **/
  @ApiModelProperty(required = true, value = "Number of measurements obtained during latest update")
  public Integer getTotalMeasurementsInLastUpdate() {
    return totalMeasurementsInLastUpdate;
  }
  public void setTotalMeasurementsInLastUpdate(Integer totalMeasurementsInLastUpdate) {
    this.totalMeasurementsInLastUpdate = totalMeasurementsInLastUpdate;
  }

  /**
   * True if user has no measurements for this connector
   **/
  @ApiModelProperty(required = true, value = "True if user has no measurements for this connector")
  public Boolean getNoDataYet() {
    return noDataYet;
  }
  public void setNoDataYet(Boolean noDataYet) {
    this.noDataYet = noDataYet;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Connector connector = (Connector) o;
    return (id == null ? connector.id == null : id.equals(connector.id)) &&
        (name == null ? connector.name == null : name.equals(connector.name)) &&
        (displayName == null ? connector.displayName == null : displayName.equals(connector.displayName)) &&
        (image == null ? connector.image == null : image.equals(connector.image)) &&
        (getItUrl == null ? connector.getItUrl == null : getItUrl.equals(connector.getItUrl)) &&
        (connected == null ? connector.connected == null : connected.equals(connector.connected)) &&
        (connectInstructions == null ? connector.connectInstructions == null : connectInstructions.equals(connector.connectInstructions)) &&
        (lastUpdate == null ? connector.lastUpdate == null : lastUpdate.equals(connector.lastUpdate)) &&
        (totalMeasurementsInLastUpdate == null ? connector.totalMeasurementsInLastUpdate == null : totalMeasurementsInLastUpdate.equals(connector.totalMeasurementsInLastUpdate)) &&
        (noDataYet == null ? connector.noDataYet == null : noDataYet.equals(connector.noDataYet));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (id == null ? 0: id.hashCode());
    result = 31 * result + (name == null ? 0: name.hashCode());
    result = 31 * result + (displayName == null ? 0: displayName.hashCode());
    result = 31 * result + (image == null ? 0: image.hashCode());
    result = 31 * result + (getItUrl == null ? 0: getItUrl.hashCode());
    result = 31 * result + (connected == null ? 0: connected.hashCode());
    result = 31 * result + (connectInstructions == null ? 0: connectInstructions.hashCode());
    result = 31 * result + (lastUpdate == null ? 0: lastUpdate.hashCode());
    result = 31 * result + (totalMeasurementsInLastUpdate == null ? 0: totalMeasurementsInLastUpdate.hashCode());
    result = 31 * result + (noDataYet == null ? 0: noDataYet.hashCode());
    return result;
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
    sb.append("  connected: ").append(connected).append("\n");
    sb.append("  connectInstructions: ").append(connectInstructions).append("\n");
    sb.append("  lastUpdate: ").append(lastUpdate).append("\n");
    sb.append("  totalMeasurementsInLastUpdate: ").append(totalMeasurementsInLastUpdate).append("\n");
    sb.append("  noDataYet: ").append(noDataYet).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
