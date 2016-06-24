package io.swagger.client.model;

import io.swagger.client.model.Update;
import java.util.*;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class InlineResponse2006  {
  
  @SerializedName("success")
  private Boolean success = null;
  @SerializedName("data")
  private List<Update> data = null;

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
  public List<Update> getData() {
    return data;
  }
  public void setData(List<Update> data) {
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
    InlineResponse2006 inlineResponse2006 = (InlineResponse2006) o;
    return (success == null ? inlineResponse2006.success == null : success.equals(inlineResponse2006.success)) &&
        (data == null ? inlineResponse2006.data == null : data.equals(inlineResponse2006.data));
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
    sb.append("class InlineResponse2006 {\n");
    
    sb.append("  success: ").append(success).append("\n");
    sb.append("  data: ").append(data).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
