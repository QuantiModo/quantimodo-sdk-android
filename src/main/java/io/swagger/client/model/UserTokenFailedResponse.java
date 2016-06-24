package io.swagger.client.model;


import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class UserTokenFailedResponse  {
  
  @SerializedName("code")
  private Integer code = null;
  @SerializedName("message")
  private String message = null;
  @SerializedName("success")
  private Boolean success = null;

  /**
   * Status code
   **/
  @ApiModelProperty(required = true, value = "Status code")
  public Integer getCode() {
    return code;
  }
  public void setCode(Integer code) {
    this.code = code;
  }

  /**
   * Message
   **/
  @ApiModelProperty(required = true, value = "Message")
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
    UserTokenFailedResponse userTokenFailedResponse = (UserTokenFailedResponse) o;
    return (code == null ? userTokenFailedResponse.code == null : code.equals(userTokenFailedResponse.code)) &&
        (message == null ? userTokenFailedResponse.message == null : message.equals(userTokenFailedResponse.message)) &&
        (success == null ? userTokenFailedResponse.success == null : success.equals(userTokenFailedResponse.success));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (code == null ? 0: code.hashCode());
    result = 31 * result + (message == null ? 0: message.hashCode());
    result = 31 * result + (success == null ? 0: success.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserTokenFailedResponse {\n");
    
    sb.append("  code: ").append(code).append("\n");
    sb.append("  message: ").append(message).append("\n");
    sb.append("  success: ").append(success).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
