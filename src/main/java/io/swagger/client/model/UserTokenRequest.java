package io.swagger.client.model;

import io.swagger.client.model.UserTokenRequestInnerUserField;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class UserTokenRequest  {
  
  @SerializedName("user")
  private UserTokenRequestInnerUserField user = null;
  @SerializedName("organizationAccessToken")
  private String organizationAccessToken = null;

  /**
   **/
  @ApiModelProperty(value = "")
  public UserTokenRequestInnerUserField getUser() {
    return user;
  }
  public void setUser(UserTokenRequestInnerUserField user) {
    this.user = user;
  }

  /**
   * Organization Access token
   **/
  @ApiModelProperty(required = true, value = "Organization Access token")
  public String getOrganizationAccessToken() {
    return organizationAccessToken;
  }
  public void setOrganizationAccessToken(String organizationAccessToken) {
    this.organizationAccessToken = organizationAccessToken;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserTokenRequest userTokenRequest = (UserTokenRequest) o;
    return (user == null ? userTokenRequest.user == null : user.equals(userTokenRequest.user)) &&
        (organizationAccessToken == null ? userTokenRequest.organizationAccessToken == null : organizationAccessToken.equals(userTokenRequest.organizationAccessToken));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (user == null ? 0: user.hashCode());
    result = 31 * result + (organizationAccessToken == null ? 0: organizationAccessToken.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserTokenRequest {\n");
    
    sb.append("  user: ").append(user).append("\n");
    sb.append("  organizationAccessToken: ").append(organizationAccessToken).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
