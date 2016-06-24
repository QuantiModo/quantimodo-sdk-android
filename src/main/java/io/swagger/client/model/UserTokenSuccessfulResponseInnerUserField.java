package io.swagger.client.model;


import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class UserTokenSuccessfulResponseInnerUserField  {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("access_token")
  private String accessToken = null;

  /**
   * WordPress user ID
   **/
  @ApiModelProperty(required = true, value = "WordPress user ID")
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * User token
   **/
  @ApiModelProperty(required = true, value = "User token")
  public String getAccessToken() {
    return accessToken;
  }
  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserTokenSuccessfulResponseInnerUserField userTokenSuccessfulResponseInnerUserField = (UserTokenSuccessfulResponseInnerUserField) o;
    return (id == null ? userTokenSuccessfulResponseInnerUserField.id == null : id.equals(userTokenSuccessfulResponseInnerUserField.id)) &&
        (accessToken == null ? userTokenSuccessfulResponseInnerUserField.accessToken == null : accessToken.equals(userTokenSuccessfulResponseInnerUserField.accessToken));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (id == null ? 0: id.hashCode());
    result = 31 * result + (accessToken == null ? 0: accessToken.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserTokenSuccessfulResponseInnerUserField {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  accessToken: ").append(accessToken).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
