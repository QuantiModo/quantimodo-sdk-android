package io.swagger.client.model;

import java.util.Date;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class VariableUserSource  {
  
  @SerializedName("user_id")
  private Integer userId = null;
  @SerializedName("variable_id")
  private Integer variableId = null;
  @SerializedName("source_id")
  private Integer sourceId = null;
  @SerializedName("timestamp")
  private Integer timestamp = null;
  @SerializedName("earliest_measurement_time")
  private Integer earliestMeasurementTime = null;
  @SerializedName("latest_measurement_time")
  private Integer latestMeasurementTime = null;
  @SerializedName("created_at")
  private Date createdAt = null;
  @SerializedName("updated_at")
  private Date updatedAt = null;

  /**
   * ID of User
   **/
  @ApiModelProperty(value = "ID of User")
  public Integer getUserId() {
    return userId;
  }
  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  /**
   * ID of variable
   **/
  @ApiModelProperty(required = true, value = "ID of variable")
  public Integer getVariableId() {
    return variableId;
  }
  public void setVariableId(Integer variableId) {
    this.variableId = variableId;
  }

  /**
   * ID of source
   **/
  @ApiModelProperty(required = true, value = "ID of source")
  public Integer getSourceId() {
    return sourceId;
  }
  public void setSourceId(Integer sourceId) {
    this.sourceId = sourceId;
  }

  /**
   * Time that this measurement occurred Uses epoch minute (epoch time divided by 60)
   **/
  @ApiModelProperty(required = true, value = "Time that this measurement occurred Uses epoch minute (epoch time divided by 60)")
  public Integer getTimestamp() {
    return timestamp;
  }
  public void setTimestamp(Integer timestamp) {
    this.timestamp = timestamp;
  }

  /**
   * Earliest measurement time
   **/
  @ApiModelProperty(required = true, value = "Earliest measurement time")
  public Integer getEarliestMeasurementTime() {
    return earliestMeasurementTime;
  }
  public void setEarliestMeasurementTime(Integer earliestMeasurementTime) {
    this.earliestMeasurementTime = earliestMeasurementTime;
  }

  /**
   * Latest measurement time
   **/
  @ApiModelProperty(required = true, value = "Latest measurement time")
  public Integer getLatestMeasurementTime() {
    return latestMeasurementTime;
  }
  public void setLatestMeasurementTime(Integer latestMeasurementTime) {
    this.latestMeasurementTime = latestMeasurementTime;
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
    VariableUserSource variableUserSource = (VariableUserSource) o;
    return (userId == null ? variableUserSource.userId == null : userId.equals(variableUserSource.userId)) &&
        (variableId == null ? variableUserSource.variableId == null : variableId.equals(variableUserSource.variableId)) &&
        (sourceId == null ? variableUserSource.sourceId == null : sourceId.equals(variableUserSource.sourceId)) &&
        (timestamp == null ? variableUserSource.timestamp == null : timestamp.equals(variableUserSource.timestamp)) &&
        (earliestMeasurementTime == null ? variableUserSource.earliestMeasurementTime == null : earliestMeasurementTime.equals(variableUserSource.earliestMeasurementTime)) &&
        (latestMeasurementTime == null ? variableUserSource.latestMeasurementTime == null : latestMeasurementTime.equals(variableUserSource.latestMeasurementTime)) &&
        (createdAt == null ? variableUserSource.createdAt == null : createdAt.equals(variableUserSource.createdAt)) &&
        (updatedAt == null ? variableUserSource.updatedAt == null : updatedAt.equals(variableUserSource.updatedAt));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (userId == null ? 0: userId.hashCode());
    result = 31 * result + (variableId == null ? 0: variableId.hashCode());
    result = 31 * result + (sourceId == null ? 0: sourceId.hashCode());
    result = 31 * result + (timestamp == null ? 0: timestamp.hashCode());
    result = 31 * result + (earliestMeasurementTime == null ? 0: earliestMeasurementTime.hashCode());
    result = 31 * result + (latestMeasurementTime == null ? 0: latestMeasurementTime.hashCode());
    result = 31 * result + (createdAt == null ? 0: createdAt.hashCode());
    result = 31 * result + (updatedAt == null ? 0: updatedAt.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class VariableUserSource {\n");
    
    sb.append("  userId: ").append(userId).append("\n");
    sb.append("  variableId: ").append(variableId).append("\n");
    sb.append("  sourceId: ").append(sourceId).append("\n");
    sb.append("  timestamp: ").append(timestamp).append("\n");
    sb.append("  earliestMeasurementTime: ").append(earliestMeasurementTime).append("\n");
    sb.append("  latestMeasurementTime: ").append(latestMeasurementTime).append("\n");
    sb.append("  createdAt: ").append(createdAt).append("\n");
    sb.append("  updatedAt: ").append(updatedAt).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
