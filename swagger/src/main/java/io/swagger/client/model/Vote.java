package io.swagger.client.model;

import java.util.Date;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class Vote  {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("client_id")
  private String clientId = null;
  @SerializedName("user_id")
  private Integer userId = null;
  @SerializedName("cause_id")
  private Integer causeId = null;
  @SerializedName("effect_id")
  private Integer effectId = null;
  @SerializedName("value")
  private Integer value = null;
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
   * client_id
   **/
  @ApiModelProperty(required = true, value = "client_id")
  public String getClientId() {
    return clientId;
  }
  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  
  /**
   * ID of User
   **/
  @ApiModelProperty(required = true, value = "ID of User")
  public Integer getUserId() {
    return userId;
  }
  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  
  /**
   * ID of the predictor variable
   **/
  @ApiModelProperty(required = true, value = "ID of the predictor variable")
  public Integer getCauseId() {
    return causeId;
  }
  public void setCauseId(Integer causeId) {
    this.causeId = causeId;
  }

  
  /**
   * ID of effect variable
   **/
  @ApiModelProperty(required = true, value = "ID of effect variable")
  public Integer getEffectId() {
    return effectId;
  }
  public void setEffectId(Integer effectId) {
    this.effectId = effectId;
  }

  
  /**
   * Value of Vote
   **/
  @ApiModelProperty(required = true, value = "Value of Vote")
  public Integer getValue() {
    return value;
  }
  public void setValue(Integer value) {
    this.value = value;
  }

  
  /**
   * When the measurement record was first created in ISO 8601 datetime format
   **/
  @ApiModelProperty(value = "When the measurement record was first created in ISO 8601 datetime format")
  public Date getCreatedAt() {
    return createdAt;
  }
  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  
  /**
   * When the measurement record in the database was last updated. Use ISO 8601 datetime format
   **/
  @ApiModelProperty(value = "When the measurement record in the database was last updated. Use ISO 8601 datetime format")
  public Date getUpdatedAt() {
    return updatedAt;
  }
  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Vote {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  clientId: ").append(clientId).append("\n");
    sb.append("  userId: ").append(userId).append("\n");
    sb.append("  causeId: ").append(causeId).append("\n");
    sb.append("  effectId: ").append(effectId).append("\n");
    sb.append("  value: ").append(value).append("\n");
    sb.append("  createdAt: ").append(createdAt).append("\n");
    sb.append("  updatedAt: ").append(updatedAt).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
