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
   * variable_id
   **/
  @ApiModelProperty(required = true, value = "variable_id")
  public Integer getVariableId() {
    return variableId;
  }
  public void setVariableId(Integer variableId) {
    this.variableId = variableId;
  }

  
  /**
   * source_id
   **/
  @ApiModelProperty(required = true, value = "source_id")
  public Integer getSourceId() {
    return sourceId;
  }
  public void setSourceId(Integer sourceId) {
    this.sourceId = sourceId;
  }

  
  /**
   * unit_id
   **/
  @ApiModelProperty(required = true, value = "unit_id")
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
