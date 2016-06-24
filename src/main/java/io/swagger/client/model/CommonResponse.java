package io.swagger.client.model;


import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class CommonResponse  {
  
  @SerializedName("status")
  private Integer status = null;
  @SerializedName("message")
  private String message = null;
  @SerializedName("success")
  private Boolean success = null;

  /**
   * Status code
   **/
  @ApiModelProperty(required = true, value = "Status code")
  public Integer getStatus() {
    return status;
  }
  public void setStatus(Integer status) {
    this.status = status;
  }

  /**
   * Message
   **/
  @ApiModelProperty(value = "Message")
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
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
    CommonResponse commonResponse = (CommonResponse) o;
    return (status == null ? commonResponse.status == null : status.equals(commonResponse.status)) &&
        (message == null ? commonResponse.message == null : message.equals(commonResponse.message)) &&
        (success == null ? commonResponse.success == null : success.equals(commonResponse.success));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (status == null ? 0: status.hashCode());
    result = 31 * result + (message == null ? 0: message.hashCode());
    result = 31 * result + (success == null ? 0: success.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommonResponse {\n");
    
    sb.append("  status: ").append(status).append("\n");
    sb.append("  message: ").append(message).append("\n");
    sb.append("  success: ").append(success).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
