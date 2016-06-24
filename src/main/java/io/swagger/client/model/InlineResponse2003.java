package io.swagger.client.model;

import io.swagger.client.model.Connection;
import java.util.*;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class InlineResponse2003  {
  
  @SerializedName("success")
  private Boolean success = null;
  @SerializedName("data")
  private List<Connection> data = null;

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
  public List<Connection> getData() {
    return data;
  }
  public void setData(List<Connection> data) {
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
    InlineResponse2003 inlineResponse2003 = (InlineResponse2003) o;
    return (success == null ? inlineResponse2003.success == null : success.equals(inlineResponse2003.success)) &&
        (data == null ? inlineResponse2003.data == null : data.equals(inlineResponse2003.data));
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
    sb.append("class InlineResponse2003 {\n");
    
    sb.append("  success: ").append(success).append("\n");
    sb.append("  data: ").append(data).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
