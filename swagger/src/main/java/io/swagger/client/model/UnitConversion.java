package io.swagger.client.model;

import java.util.Date;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class UnitConversion  {
  
  @SerializedName("unit_id")
  private Integer unitId = null;
  @SerializedName("step_number")
  private Boolean stepNumber = null;
  @SerializedName("operation")
  private Boolean operation = null;
  @SerializedName("value")
  private Float value = null;
  @SerializedName("created_at")
  private Date createdAt = null;
  @SerializedName("updated_at")
  private Date updatedAt = null;

  
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
   * step in the conversion process
   **/
  @ApiModelProperty(required = true, value = "step in the conversion process")
  public Boolean getStepNumber() {
    return stepNumber;
  }
  public void setStepNumber(Boolean stepNumber) {
    this.stepNumber = stepNumber;
  }

  
  /**
   * 0 is add and 1 is multiply
   **/
  @ApiModelProperty(required = true, value = "0 is add and 1 is multiply")
  public Boolean getOperation() {
    return operation;
  }
  public void setOperation(Boolean operation) {
    this.operation = operation;
  }

  
  /**
   * number used in the operation
   **/
  @ApiModelProperty(required = true, value = "number used in the operation")
  public Float getValue() {
    return value;
  }
  public void setValue(Float value) {
    this.value = value;
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
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class UnitConversion {\n");
    
    sb.append("  unitId: ").append(unitId).append("\n");
    sb.append("  stepNumber: ").append(stepNumber).append("\n");
    sb.append("  operation: ").append(operation).append("\n");
    sb.append("  value: ").append(value).append("\n");
    sb.append("  createdAt: ").append(createdAt).append("\n");
    sb.append("  updatedAt: ").append(updatedAt).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
