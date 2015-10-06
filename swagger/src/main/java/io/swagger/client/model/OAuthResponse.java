package io.swagger.client.model;


import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class OAuthResponse  {
  
  @SerializedName("access_token")
  private String accessToken = null;
  @SerializedName("expires_in")
  private Integer expiresIn = null;
  @SerializedName("refresh_token")
  private String refreshToken = null;

  
  /**
   * Access token
   **/
  @ApiModelProperty(required = true, value = "Access token")
  public String getAccessToken() {
    return accessToken;
  }
  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  
  /**
   * Access token expire time
   **/
  @ApiModelProperty(required = true, value = "Access token expire time")
  public Integer getExpiresIn() {
    return expiresIn;
  }
  public void setExpiresIn(Integer expiresIn) {
    this.expiresIn = expiresIn;
  }

  
  /**
   * New refresh token
   **/
  @ApiModelProperty(value = "New refresh token")
  public String getRefreshToken() {
    return refreshToken;
  }
  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class OAuthResponse {\n");
    
    sb.append("  accessToken: ").append(accessToken).append("\n");
    sb.append("  expiresIn: ").append(expiresIn).append("\n");
    sb.append("  refreshToken: ").append(refreshToken).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
