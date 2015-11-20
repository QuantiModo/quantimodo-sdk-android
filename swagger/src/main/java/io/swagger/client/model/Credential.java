package io.swagger.client.model;

import java.util.Date;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class Credential  {
  
  @SerializedName("user_id")
  private Integer userId = null;
  @SerializedName("connector_id")
  private Integer connectorId = null;
  @SerializedName("attr_key")
  private String attrKey = null;
  @SerializedName("attr_value")
  private String attrValue = null;
  @SerializedName("created_at")
  private Date createdAt = null;
  @SerializedName("updated_at")
  private Date updatedAt = null;

  
  /**
   * ID of user that owns this credential
   **/
  @ApiModelProperty(value = "ID of user that owns this credential")
  public Integer getUserId() {
    return userId;
  }
  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  
  /**
   * The id for the connector data source from which the credential was obtained
   **/
  @ApiModelProperty(required = true, value = "The id for the connector data source from which the credential was obtained")
  public Integer getConnectorId() {
    return connectorId;
  }
  public void setConnectorId(Integer connectorId) {
    this.connectorId = connectorId;
  }

  
  /**
   * Attribute name such as token, userid, username, or password
   **/
  @ApiModelProperty(value = "Attribute name such as token, userid, username, or password")
  public String getAttrKey() {
    return attrKey;
  }
  public void setAttrKey(String attrKey) {
    this.attrKey = attrKey;
  }

  
  /**
   * Encrypted value for the attribute specified
   **/
  @ApiModelProperty(value = "Encrypted value for the attribute specified")
  public String getAttrValue() {
    return attrValue;
  }
  public void setAttrValue(String attrValue) {
    this.attrValue = attrValue;
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
    sb.append("class Credential {\n");
    
    sb.append("  userId: ").append(userId).append("\n");
    sb.append("  connectorId: ").append(connectorId).append("\n");
    sb.append("  attrKey: ").append(attrKey).append("\n");
    sb.append("  attrValue: ").append(attrValue).append("\n");
    sb.append("  createdAt: ").append(createdAt).append("\n");
    sb.append("  updatedAt: ").append(updatedAt).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
