package io.swagger.client.model;

import io.swagger.client.model.TrackingReminder;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class InlineResponse2002  {
  
  @SerializedName("success")
  private Boolean success = null;
  @SerializedName("data")
  private TrackingReminder data = null;

  /**
   **/
  @ApiModelProperty(value = "")
  public Boolean getSuccess() {
    return success;
  }
  public void setSuccess(Boolean success) {
    this.success = success;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public TrackingReminder getData() {
    return data;
  }
  public void setData(TrackingReminder data) {
    this.data = data;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse2002 inlineResponse2002 = (InlineResponse2002) o;
    return (success == null ? inlineResponse2002.success == null : success.equals(inlineResponse2002.success)) &&
        (data == null ? inlineResponse2002.data == null : data.equals(inlineResponse2002.data));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (success == null ? 0: success.hashCode());
    result = 31 * result + (data == null ? 0: data.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse2002 {\n");
    
    sb.append("  success: ").append(success).append("\n");
    sb.append("  data: ").append(data).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
