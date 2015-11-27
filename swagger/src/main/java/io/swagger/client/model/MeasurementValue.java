package io.swagger.client.model;


import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;

import java.util.Date;


@ApiModel(description = "")
public class MeasurementValue  {
  
  @SerializedName("start_time")
  private Date startTime = null;
  @SerializedName("value")
  private Float value = null;
  @SerializedName("note")
  private String note = null;

  
  /**
   * When the measurement event occurred . Use ISO 8601 datetime format
   **/
  @ApiModelProperty(required = true, value = "When the measurement event occurred . Use ISO 8601 datetime format")
  public Date getStartTime() {
    return startTime;
  }
  public void setStartTime(Date startTime) {
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

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class MeasurementValue {\n");
    
    sb.append("  startTime: ").append(startTime).append("\n");
    sb.append("  value: ").append(value).append("\n");
    sb.append("  note: ").append(note).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
