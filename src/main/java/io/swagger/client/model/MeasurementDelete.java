package io.swagger.client.model;


import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class MeasurementDelete  {
  
  @SerializedName("variableId")
  private Integer variableId = null;
  @SerializedName("startTime")
  private Integer startTime = null;

  /**
   * Variable id of the measurement to be deleted
   **/
  @ApiModelProperty(required = true, value = "Variable id of the measurement to be deleted")
  public Integer getVariableId() {
    return variableId;
  }
  public void setVariableId(Integer variableId) {
    this.variableId = variableId;
  }

  /**
   * Start time of the measurement to be deleted
   **/
  @ApiModelProperty(required = true, value = "Start time of the measurement to be deleted")
  public Integer getStartTime() {
    return startTime;
  }
  public void setStartTime(Integer startTime) {
    this.startTime = startTime;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MeasurementDelete measurementDelete = (MeasurementDelete) o;
    return (variableId == null ? measurementDelete.variableId == null : variableId.equals(measurementDelete.variableId)) &&
        (startTime == null ? measurementDelete.startTime == null : startTime.equals(measurementDelete.startTime));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (variableId == null ? 0: variableId.hashCode());
    result = 31 * result + (startTime == null ? 0: startTime.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class MeasurementDelete {\n");
    
    sb.append("  variableId: ").append(variableId).append("\n");
    sb.append("  startTime: ").append(startTime).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
