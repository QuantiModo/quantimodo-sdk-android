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
   * When the measurement event occured in ISO 8601 datetime format \(\"yyyy-MM-ddTHH\:mm\:ss.fffffffzzz\"\)
   **/
  @ApiModelProperty(required = true, value = "When the measurement event occured in ISO 8601 datetime format \(\"yyyy-MM-ddTHH\:mm\:ss.fffffffzzz\"\)")
  public Long getStartTime() {
    return startTime;
  }
  public void setStartTime(Long startTime) {
    this.startTime = startTime;
  }

  
  /**
   * Value for the measurement
   **/
  @ApiModelProperty(required = true, value = "Value for the measurement")
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
