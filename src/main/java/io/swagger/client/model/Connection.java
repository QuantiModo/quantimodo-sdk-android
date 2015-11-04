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
   * user_id
   **/
  @ApiModelProperty(value = "user_id")
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
   * connect_status
   **/
  @ApiModelProperty(value = "connect_status")
  public String getConnectStatus() {
    return connectStatus;
  }
  public void setConnectStatus(String connectStatus) {
    this.connectStatus = connectStatus;
  }

  
  /**
   * connect_error
   **/
  @ApiModelProperty(value = "connect_error")
  public String getConnectError() {
    return connectError;
  }
  public void setConnectError(String connectError) {
    this.connectError = connectError;
  }

  
  /**
   * update_requested_at
   **/
  @ApiModelProperty(value = "update_requested_at")
  public Date getUpdateRequestedAt() {
    return updateRequestedAt;
  }
  public void setUpdateRequestedAt(Date updateRequestedAt) {
    this.updateRequestedAt = updateRequestedAt;
  }

  
  /**
   * update_status
   **/
  @ApiModelProperty(value = "update_status")
  public String getUpdateStatus() {
    return updateStatus;
  }
  public void setUpdateStatus(String updateStatus) {
    this.updateStatus = updateStatus;
  }

  
  /**
   * update_error
   **/
  @ApiModelProperty(value = "update_error")
  public String getUpdateError() {
    return updateError;
  }
  public void setUpdateError(String updateError) {
    this.updateError = updateError;
  }

  
  /**
   * last_successful_updated_at
   **/
  @ApiModelProperty(value = "last_successful_updated_at")
  public Date getLastSuccessfulUpdatedAt() {
    return lastSuccessfulUpdatedAt;
  }
  public void setLastSuccessfulUpdatedAt(Date lastSuccessfulUpdatedAt) {
    this.lastSuccessfulUpdatedAt = lastSuccessfulUpdatedAt;
  }

  
  /**
   * created_at
   **/
  @ApiModelProperty(value = "created_at")
  public Date getCreatedAt() {
    return createdAt;
  }
  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  
  /**
   * updated_at
   **/
  @ApiModelProperty(value = "updated_at")
  public Date getUpdatedAt() {
    return updatedAt;
  }
  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
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
