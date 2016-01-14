package io.swagger.client.model;

import io.swagger.client.model.Connection;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class InlineResponse2006  {
  
  @SerializedName("data")
  private Connection data = null;
  @SerializedName("success")
  private Boolean success = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  public Connection getData() {
    return data;
  }
  public void setData(Connection data) {
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
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse2006 {\n");
    
    sb.append("  data: ").append(data).append("\n");
    sb.append("  success: ").append(success).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
