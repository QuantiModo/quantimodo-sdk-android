package io.swagger.client.model;

import java.util.Date;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class Connection  {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("user_id")
  private Integer userId = null;
  @SerializedName("connector_id")
  private Integer connectorId = null;
  @SerializedName("connect_status")
  private String connectStatus = null;
  @SerializedName("connect_error")
  private String connectError = null;
  @SerializedName("update_requested_at")
  private Date updateRequestedAt = null;
  @SerializedName("update_status")
  private String updateStatus = null;
  @SerializedName("update_error")
  private String updateError = null;
  @SerializedName("last_successful_updated_at")
  private Date lastSuccessfulUpdatedAt = null;
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
   * ID of user that owns this correlation
   **/
  @ApiModelProperty(value = "ID of user that owns this correlation")
  public Integer getUserId() {
    return userId;
  }
  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  /**
   * The id for the connector data source for which the connection is connected
   **/
  @ApiModelProperty(required = true, value = "The id for the connector data source for which the connection is connected")
  public Integer getConnectorId() {
    return connectorId;
  }
  public void setConnectorId(Integer connectorId) {
    this.connectorId = connectorId;
  }

  /**
   * Indicates whether a connector is currently connected to a service for a user.
   **/
  @ApiModelProperty(value = "Indicates whether a connector is currently connected to a service for a user.")
  public String getConnectStatus() {
    return connectStatus;
  }
  public void setConnectStatus(String connectStatus) {
    this.connectStatus = connectStatus;
  }

  /**
   * Error message if there is a problem with authorizing this connection.
   **/
  @ApiModelProperty(value = "Error message if there is a problem with authorizing this connection.")
  public String getConnectError() {
    return connectError;
  }
  public void setConnectError(String connectError) {
    this.connectError = connectError;
  }

  /**
   * Time at which an update was requested by a user.
   **/
  @ApiModelProperty(value = "Time at which an update was requested by a user.")
  public Date getUpdateRequestedAt() {
    return updateRequestedAt;
  }
  public void setUpdateRequestedAt(Date updateRequestedAt) {
    this.updateRequestedAt = updateRequestedAt;
  }

  /**
   * Indicates whether a connector is currently updated.
   **/
  @ApiModelProperty(value = "Indicates whether a connector is currently updated.")
  public String getUpdateStatus() {
    return updateStatus;
  }
  public void setUpdateStatus(String updateStatus) {
    this.updateStatus = updateStatus;
  }

  /**
   * Indicates if there was an error during the update.
   **/
  @ApiModelProperty(value = "Indicates if there was an error during the update.")
  public String getUpdateError() {
    return updateError;
  }
  public void setUpdateError(String updateError) {
    this.updateError = updateError;
  }

  /**
   * The time at which the connector was last successfully updated.
   **/
  @ApiModelProperty(value = "The time at which the connector was last successfully updated.")
  public Date getLastSuccessfulUpdatedAt() {
    return lastSuccessfulUpdatedAt;
  }
  public void setLastSuccessfulUpdatedAt(Date lastSuccessfulUpdatedAt) {
    this.lastSuccessfulUpdatedAt = lastSuccessfulUpdatedAt;
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
    Connection connection = (Connection) o;
    return (id == null ? connection.id == null : id.equals(connection.id)) &&
        (userId == null ? connection.userId == null : userId.equals(connection.userId)) &&
        (connectorId == null ? connection.connectorId == null : connectorId.equals(connection.connectorId)) &&
        (connectStatus == null ? connection.connectStatus == null : connectStatus.equals(connection.connectStatus)) &&
        (connectError == null ? connection.connectError == null : connectError.equals(connection.connectError)) &&
        (updateRequestedAt == null ? connection.updateRequestedAt == null : updateRequestedAt.equals(connection.updateRequestedAt)) &&
        (updateStatus == null ? connection.updateStatus == null : updateStatus.equals(connection.updateStatus)) &&
        (updateError == null ? connection.updateError == null : updateError.equals(connection.updateError)) &&
        (lastSuccessfulUpdatedAt == null ? connection.lastSuccessfulUpdatedAt == null : lastSuccessfulUpdatedAt.equals(connection.lastSuccessfulUpdatedAt)) &&
        (createdAt == null ? connection.createdAt == null : createdAt.equals(connection.createdAt)) &&
        (updatedAt == null ? connection.updatedAt == null : updatedAt.equals(connection.updatedAt));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (id == null ? 0: id.hashCode());
    result = 31 * result + (userId == null ? 0: userId.hashCode());
    result = 31 * result + (connectorId == null ? 0: connectorId.hashCode());
    result = 31 * result + (connectStatus == null ? 0: connectStatus.hashCode());
    result = 31 * result + (connectError == null ? 0: connectError.hashCode());
    result = 31 * result + (updateRequestedAt == null ? 0: updateRequestedAt.hashCode());
    result = 31 * result + (updateStatus == null ? 0: updateStatus.hashCode());
    result = 31 * result + (updateError == null ? 0: updateError.hashCode());
    result = 31 * result + (lastSuccessfulUpdatedAt == null ? 0: lastSuccessfulUpdatedAt.hashCode());
    result = 31 * result + (createdAt == null ? 0: createdAt.hashCode());
    result = 31 * result + (updatedAt == null ? 0: updatedAt.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Connection {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  userId: ").append(userId).append("\n");
    sb.append("  connectorId: ").append(connectorId).append("\n");
    sb.append("  connectStatus: ").append(connectStatus).append("\n");
    sb.append("  connectError: ").append(connectError).append("\n");
    sb.append("  updateRequestedAt: ").append(updateRequestedAt).append("\n");
    sb.append("  updateStatus: ").append(updateStatus).append("\n");
    sb.append("  updateError: ").append(updateError).append("\n");
    sb.append("  lastSuccessfulUpdatedAt: ").append(lastSuccessfulUpdatedAt).append("\n");
    sb.append("  createdAt: ").append(createdAt).append("\n");
    sb.append("  updatedAt: ").append(updatedAt).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
