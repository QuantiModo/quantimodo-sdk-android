package io.swagger.client.model;


import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class ConnectorInfoHistoryItem  {
  
  @SerializedName("numberOfMeasurements")
  private Integer numberOfMeasurements = null;
  @SerializedName("success")
  private Boolean success = null;
  @SerializedName("message")
  private String message = null;
  @SerializedName("createdAt")
  private String createdAt = null;

  /**
   * Number of measurements
   **/
  @ApiModelProperty(required = true, value = "Number of measurements")
  public Integer getNumberOfMeasurements() {
    return numberOfMeasurements;
  }
  public void setNumberOfMeasurements(Integer numberOfMeasurements) {
    this.numberOfMeasurements = numberOfMeasurements;
  }

  /**
   * True if the update was successfull
   **/
  @ApiModelProperty(required = true, value = "True if the update was successfull")
  public Boolean getSuccess() {
    return success;
  }
  public void setSuccess(Boolean success) {
    this.success = success;
  }

  /**
   * Error message.
   **/
  @ApiModelProperty(required = true, value = "Error message.")
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * Date and time of the update in UTC time zone
   **/
  @ApiModelProperty(required = true, value = "Date and time of the update in UTC time zone")
  public String getCreatedAt() {
    return createdAt;
  }
  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConnectorInfoHistoryItem connectorInfoHistoryItem = (ConnectorInfoHistoryItem) o;
    return (numberOfMeasurements == null ? connectorInfoHistoryItem.numberOfMeasurements == null : numberOfMeasurements.equals(connectorInfoHistoryItem.numberOfMeasurements)) &&
        (success == null ? connectorInfoHistoryItem.success == null : success.equals(connectorInfoHistoryItem.success)) &&
        (message == null ? connectorInfoHistoryItem.message == null : message.equals(connectorInfoHistoryItem.message)) &&
        (createdAt == null ? connectorInfoHistoryItem.createdAt == null : createdAt.equals(connectorInfoHistoryItem.createdAt));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (numberOfMeasurements == null ? 0: numberOfMeasurements.hashCode());
    result = 31 * result + (success == null ? 0: success.hashCode());
    result = 31 * result + (message == null ? 0: message.hashCode());
    result = 31 * result + (createdAt == null ? 0: createdAt.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConnectorInfoHistoryItem {\n");
    
    sb.append("  numberOfMeasurements: ").append(numberOfMeasurements).append("\n");
    sb.append("  success: ").append(success).append("\n");
    sb.append("  message: ").append(message).append("\n");
    sb.append("  createdAt: ").append(createdAt).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
