package io.swagger.client.model;


import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class MeasurementValue  {
  
  @SerializedName("start_time")
  private Long startTime = null;
  @SerializedName("value")
  private Float value = null;

  
  /**
   * start_time
   **/
  @ApiModelProperty(required = true, value = "start_time")
  public Long getStartTime() {
    return startTime;
  }
  public void setStartTime(Long startTime) {
    this.startTime = startTime;
  }

  
  /**
   * value
   **/
  @ApiModelProperty(required = true, value = "value")
  public Float getValue() {
    return value;
  }
  public void setValue(Float value) {
    this.value = value;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class MeasurementValue {\n");
    
    sb.append("  startTime: ").append(startTime).append("\n");
    sb.append("  value: ").append(value).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
