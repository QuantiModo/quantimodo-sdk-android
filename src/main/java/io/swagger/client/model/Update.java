package io.swagger.client.model;

import java.util.Date;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class Update  {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("user_id")
  private Integer userId = null;
  @SerializedName("connector_id")
  private Integer connectorId = null;
  @SerializedName("number_of_measurements")
  private Integer numberOfMeasurements = null;
  @SerializedName("success")
  private Boolean success = null;
  @SerializedName("message")
  private String message = null;
  @SerializedName("created_at")
  private Date createdAt = null;
  @SerializedName("updated_at")
  private Date updatedAt = null;

  /**
   * id
   **/
  @ApiModelProperty(value = "id")
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * user_id
   **/
  @ApiModelProperty(required = true, value = "user_id")
  public Integer getUserId() {
    return userId;
  }
  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  /**
   * connector_id
   **/
  @ApiModelProperty(required = true, value = "connector_id")
  public Integer getConnectorId() {
    return connectorId;
  }
  public void setConnectorId(Integer connectorId) {
    this.connectorId = connectorId;
  }

  /**
   * number_of_measurements
   **/
  @ApiModelProperty(required = true, value = "number_of_measurements")
  public Integer getNumberOfMeasurements() {
    return numberOfMeasurements;
  }
  public void setNumberOfMeasurements(Integer numberOfMeasurements) {
    this.numberOfMeasurements = numberOfMeasurements;
  }

  /**
   * success
   **/
  @ApiModelProperty(required = true, value = "success")
  public Boolean getSuccess() {
    return success;
  }
  public void setSuccess(Boolean success) {
    this.success = success;
  }

  /**
   * message
   **/
  @ApiModelProperty(required = true, value = "message")
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
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
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Update update = (Update) o;
    return (id == null ? update.id == null : id.equals(update.id)) &&
        (userId == null ? update.userId == null : userId.equals(update.userId)) &&
        (connectorId == null ? update.connectorId == null : connectorId.equals(update.connectorId)) &&
        (numberOfMeasurements == null ? update.numberOfMeasurements == null : numberOfMeasurements.equals(update.numberOfMeasurements)) &&
        (success == null ? update.success == null : success.equals(update.success)) &&
        (message == null ? update.message == null : message.equals(update.message)) &&
        (createdAt == null ? update.createdAt == null : createdAt.equals(update.createdAt)) &&
        (updatedAt == null ? update.updatedAt == null : updatedAt.equals(update.updatedAt));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (id == null ? 0: id.hashCode());
    result = 31 * result + (userId == null ? 0: userId.hashCode());
    result = 31 * result + (connectorId == null ? 0: connectorId.hashCode());
    result = 31 * result + (numberOfMeasurements == null ? 0: numberOfMeasurements.hashCode());
    result = 31 * result + (success == null ? 0: success.hashCode());
    result = 31 * result + (message == null ? 0: message.hashCode());
    result = 31 * result + (createdAt == null ? 0: createdAt.hashCode());
    result = 31 * result + (updatedAt == null ? 0: updatedAt.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Update {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  userId: ").append(userId).append("\n");
    sb.append("  connectorId: ").append(connectorId).append("\n");
    sb.append("  numberOfMeasurements: ").append(numberOfMeasurements).append("\n");
    sb.append("  success: ").append(success).append("\n");
    sb.append("  message: ").append(message).append("\n");
    sb.append("  createdAt: ").append(createdAt).append("\n");
    sb.append("  updatedAt: ").append(updatedAt).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
