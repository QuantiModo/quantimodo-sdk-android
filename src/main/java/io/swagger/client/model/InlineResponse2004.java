package io.swagger.client.model;

import io.swagger.client.model.Credential;
import java.util.*;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class InlineResponse2004  {
  
  @SerializedName("data")
  private List<Credential> data = null;
  @SerializedName("success")
  private Boolean success = null;

  /**
   **/
  @ApiModelProperty(value = "")
  public List<Credential> getData() {
    return data;
  }
  public void setData(List<Credential> data) {
    this.data = data;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Boolean getSuccess() {
    return success;
  }
  public void setSuccess(Boolean success) {
    this.success = success;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse2004 inlineResponse2004 = (InlineResponse2004) o;
    return (data == null ? inlineResponse2004.data == null : data.equals(inlineResponse2004.data)) &&
        (success == null ? inlineResponse2004.success == null : success.equals(inlineResponse2004.success));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (data == null ? 0: data.hashCode());
    result = 31 * result + (success == null ? 0: success.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse2004 {\n");
    
    sb.append("  data: ").append(data).append("\n");
    sb.append("  success: ").append(success).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
