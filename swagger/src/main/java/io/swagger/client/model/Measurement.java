package io.swagger.client.model;

import java.util.Date;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class Measurement  {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("user_id")
  private Integer userId = null;
  @SerializedName("client_id")
  private String clientId = null;
  @SerializedName("connector_id")
  private Integer connectorId = null;
  @SerializedName("variable_id")
  private Integer variableId = null;
  @SerializedName("source_id")
  private Integer sourceId = null;
  @SerializedName("start_time")
  private String startTime = null;
  @SerializedName("value")
  private Float value = null;
  @SerializedName("unit_id")
  private Integer unitId = null;
  @SerializedName("original_value")
  private Float originalValue = null;
  @SerializedName("original_unit_id")
  private Integer originalUnitId = null;
  @SerializedName("duration")
  private Integer duration = null;
  @SerializedName("note")
  private String note = null;
  @SerializedName("latitude")
  private Float latitude = null;
  @SerializedName("longitude")
  private Float longitude = null;
  @SerializedName("location")
  private String location = null;
  @SerializedName("created_at")
  private Date createdAt = null;
  @SerializedName("updated_at")
  private Date updatedAt = null;
  @SerializedName("error")
  private String error = null;

  
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
   * ID of user that owns this measurement
   **/
  @ApiModelProperty(value = "ID of user that owns this measurement")
  public Integer getUserId() {
    return userId;
  }
  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  
  /**
   * client_id
   **/
  @ApiModelProperty(value = "client_id")
  public String getClientId() {
    return clientId;
  }
  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  
  /**
   * The id for the connector data source from which the measurement was obtained
   **/
  @ApiModelProperty(value = "The id for the connector data source from which the measurement was obtained")
  public Integer getConnectorId() {
    return connectorId;
  }
  public void setConnectorId(Integer connectorId) {
    this.connectorId = connectorId;
  }

  
  /**
   * ID of the variable for which we are creating the measurement records
   **/
  @ApiModelProperty(required = true, value = "ID of the variable for which we are creating the measurement records")
  public Integer getVariableId() {
    return variableId;
  }
  public void setVariableId(Integer variableId) {
    this.variableId = variableId;
  }

  
  /**
   * Application or device used to record the measurement values
   **/
  @ApiModelProperty(required = true, value = "Application or device used to record the measurement values")
  public Integer getSourceId() {
    return sourceId;
  }
  public void setSourceId(Integer sourceId) {
    this.sourceId = sourceId;
  }

  
  /**
   * Start Time for the measurement event. Use ISO 8601
   **/
  @ApiModelProperty(required = true, value = "Start Time for the measurement event. Use ISO 8601")
  public String getStartTime() {
    return startTime;
  }
  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  
  /**
   * The value of the measurement after conversion to the default unit for that variable
   **/
  @ApiModelProperty(required = true, value = "The value of the measurement after conversion to the default unit for that variable")
  public Float getValue() {
    return value;
  }
  public void setValue(Float value) {
    this.value = value;
  }

  
  /**
   * The default unit for the variable
   **/
  @ApiModelProperty(required = true, value = "The default unit for the variable")
  public Integer getUnitId() {
    return unitId;
  }
  public void setUnitId(Integer unitId) {
    this.unitId = unitId;
  }

  
  /**
   * Value of measurement as originally posted (before conversion to default unit)
   **/
  @ApiModelProperty(value = "Value of measurement as originally posted (before conversion to default unit)")
  public Float getOriginalValue() {
    return originalValue;
  }
  public void setOriginalValue(Float originalValue) {
    this.originalValue = originalValue;
  }

  
  /**
   * Unit ID of measurement as originally submitted
   **/
  @ApiModelProperty(value = "Unit ID of measurement as originally submitted")
  public Integer getOriginalUnitId() {
    return originalUnitId;
  }
  public void setOriginalUnitId(Integer originalUnitId) {
    this.originalUnitId = originalUnitId;
  }

  
  /**
   * Duration of the event being measurement in seconds
   **/
  @ApiModelProperty(value = "Duration of the event being measurement in seconds")
  public Integer getDuration() {
    return duration;
  }
  public void setDuration(Integer duration) {
    this.duration = duration;
  }

  
  /**
   * An optional note the user may include with their measurement
   **/
  @ApiModelProperty(value = "An optional note the user may include with their measurement")
  public String getNote() {
    return note;
  }
  public void setNote(String note) {
    this.note = note;
  }

  
  /**
   * Latitude at which the measurement was taken
   **/
  @ApiModelProperty(value = "Latitude at which the measurement was taken")
  public Float getLatitude() {
    return latitude;
  }
  public void setLatitude(Float latitude) {
    this.latitude = latitude;
  }

  
  /**
   * Longitude at which the measurement was taken
   **/
  @ApiModelProperty(value = "Longitude at which the measurement was taken")
  public Float getLongitude() {
    return longitude;
  }
  public void setLongitude(Float longitude) {
    this.longitude = longitude;
  }

  
  /**
   * location
   **/
  @ApiModelProperty(value = "location")
  public String getLocation() {
    return location;
  }
  public void setLocation(String location) {
    this.location = location;
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

  
  /**
   * error
   **/
  @ApiModelProperty(value = "error")
  public String getError() {
    return error;
  }
  public void setError(String error) {
    this.error = error;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Measurement {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  userId: ").append(userId).append("\n");
    sb.append("  clientId: ").append(clientId).append("\n");
    sb.append("  connectorId: ").append(connectorId).append("\n");
    sb.append("  variableId: ").append(variableId).append("\n");
    sb.append("  sourceId: ").append(sourceId).append("\n");
    sb.append("  startTime: ").append(startTime).append("\n");
    sb.append("  value: ").append(value).append("\n");
    sb.append("  unitId: ").append(unitId).append("\n");
    sb.append("  originalValue: ").append(originalValue).append("\n");
    sb.append("  originalUnitId: ").append(originalUnitId).append("\n");
    sb.append("  duration: ").append(duration).append("\n");
    sb.append("  note: ").append(note).append("\n");
    sb.append("  latitude: ").append(latitude).append("\n");
    sb.append("  longitude: ").append(longitude).append("\n");
    sb.append("  location: ").append(location).append("\n");
    sb.append("  createdAt: ").append(createdAt).append("\n");
    sb.append("  updatedAt: ").append(updatedAt).append("\n");
    sb.append("  error: ").append(error).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
