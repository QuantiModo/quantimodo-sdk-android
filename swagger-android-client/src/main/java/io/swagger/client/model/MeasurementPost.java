package io.swagger.client.model;

import io.swagger.client.model.MeasurementValue;
import java.util.*;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class MeasurementPost  {
  
  @SerializedName("variable_id")
  private Integer variableId = null;
  @SerializedName("source_id")
  private Integer sourceId = null;
  @SerializedName("unit_id")
  private Integer unitId = null;
  @SerializedName("measurements")
  private List<MeasurementValue> measurements = null;

  
  /**
   * ID of the variable for the measurement as obtained from the GET variables endpoint
   **/
  @ApiModelProperty(required = true, value = "ID of the variable for the measurement as obtained from the GET variables endpoint")
  public Integer getVariableId() {
    return variableId;
  }
  public void setVariableId(Integer variableId) {
    this.variableId = variableId;
  }

  
  /**
   * Source ID of the app or device as obtained from the GET sources endpoint
   **/
  @ApiModelProperty(required = true, value = "Source ID of the app or device as obtained from the GET sources endpoint")
  public Integer getSourceId() {
    return sourceId;
  }
  public void setSourceId(Integer sourceId) {
    this.sourceId = sourceId;
  }

  
  /**
   * Unit id for the measurement value as obtained from the GET units endpoint
   **/
  @ApiModelProperty(required = true, value = "Unit id for the measurement value as obtained from the GET units endpoint")
  public Integer getUnitId() {
    return unitId;
  }
  public void setUnitId(Integer unitId) {
    this.unitId = unitId;
  }

  
  /**
   * measurements
   **/
  @ApiModelProperty(required = true, value = "measurements")
  public List<MeasurementValue> getMeasurements() {
    return measurements;
  }
  public void setMeasurements(List<MeasurementValue> measurements) {
    this.measurements = measurements;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class MeasurementPost {\n");
    
    sb.append("  variableId: ").append(variableId).append("\n");
    sb.append("  sourceId: ").append(sourceId).append("\n");
    sb.append("  unitId: ").append(unitId).append("\n");
    sb.append("  measurements: ").append(measurements).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
