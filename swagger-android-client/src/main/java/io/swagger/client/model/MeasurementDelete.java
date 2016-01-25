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
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class MeasurementDelete {\n");
    
    sb.append("  variableId: ").append(variableId).append("\n");
    sb.append("  startTime: ").append(startTime).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
