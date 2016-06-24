package io.swagger.client.model;


import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class JsonErrorResponse  {
  
  @SerializedName("status")
  private String status = null;
  @SerializedName("message")
  private String message = null;

  /**
   * Status: \"ok\" or \"error\"
   **/
  @ApiModelProperty(required = true, value = "Status: \"ok\" or \"error\"")
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * Error message
   **/
  @ApiModelProperty(value = "Error message")
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JsonErrorResponse jsonErrorResponse = (JsonErrorResponse) o;
    return (status == null ? jsonErrorResponse.status == null : status.equals(jsonErrorResponse.status)) &&
        (message == null ? jsonErrorResponse.message == null : message.equals(jsonErrorResponse.message));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (status == null ? 0: status.hashCode());
    result = 31 * result + (message == null ? 0: message.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class JsonErrorResponse {\n");
    
    sb.append("  status: ").append(status).append("\n");
    sb.append("  message: ").append(message).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
