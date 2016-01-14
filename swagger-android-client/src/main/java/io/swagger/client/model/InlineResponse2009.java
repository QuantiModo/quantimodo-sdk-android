package io.swagger.client.model;

import io.swagger.client.model.Correlation;
import java.util.*;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class InlineResponse2009  {
  
  @SerializedName("data")
  private List<Correlation> data = null;
  @SerializedName("success")
  private Boolean success = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  public List<Correlation> getData() {
    return data;
  }
  public void setData(List<Correlation> data) {
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
    sb.append("class InlineResponse2009 {\n");
    
    sb.append("  data: ").append(data).append("\n");
    sb.append("  success: ").append(success).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
