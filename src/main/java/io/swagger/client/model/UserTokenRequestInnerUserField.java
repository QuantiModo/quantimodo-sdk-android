package io.swagger.client.model;


import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class UserTokenRequestInnerUserField  {
  
  @SerializedName("id")
  private Integer id = null;

  /**
   * WordPress user ID
   **/
  @ApiModelProperty(value = "WordPress user ID")
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserTokenRequestInnerUserField userTokenRequestInnerUserField = (UserTokenRequestInnerUserField) o;
    return (id == null ? userTokenRequestInnerUserField.id == null : id.equals(userTokenRequestInnerUserField.id));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (id == null ? 0: id.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserTokenRequestInnerUserField {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
