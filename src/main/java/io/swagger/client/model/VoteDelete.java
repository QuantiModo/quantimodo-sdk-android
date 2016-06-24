package io.swagger.client.model;


import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class VoteDelete  {
  
  @SerializedName("cause")
  private String cause = null;
  @SerializedName("effect")
  private String effect = null;

  /**
   * Cause variable name for the correlation to which the vote pertains
   **/
  @ApiModelProperty(required = true, value = "Cause variable name for the correlation to which the vote pertains")
  public String getCause() {
    return cause;
  }
  public void setCause(String cause) {
    this.cause = cause;
  }

  /**
   * Effect variable name for the correlation to which the vote pertains
   **/
  @ApiModelProperty(required = true, value = "Effect variable name for the correlation to which the vote pertains")
  public String getEffect() {
    return effect;
  }
  public void setEffect(String effect) {
    this.effect = effect;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VoteDelete voteDelete = (VoteDelete) o;
    return (cause == null ? voteDelete.cause == null : cause.equals(voteDelete.cause)) &&
        (effect == null ? voteDelete.effect == null : effect.equals(voteDelete.effect));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (cause == null ? 0: cause.hashCode());
    result = 31 * result + (effect == null ? 0: effect.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class VoteDelete {\n");
    
    sb.append("  cause: ").append(cause).append("\n");
    sb.append("  effect: ").append(effect).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
