package io.swagger.client.model;


import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class PostVote  {
  
  @SerializedName("cause")
  private String cause = null;
  @SerializedName("effect")
  private String effect = null;
  @SerializedName("vote")
  private Boolean vote = null;

  /**
   * Cause variable name
   **/
  @ApiModelProperty(required = true, value = "Cause variable name")
  public String getCause() {
    return cause;
  }
  public void setCause(String cause) {
    this.cause = cause;
  }

  /**
   * Effect variable name
   **/
  @ApiModelProperty(required = true, value = "Effect variable name")
  public String getEffect() {
    return effect;
  }
  public void setEffect(String effect) {
    this.effect = effect;
  }

  /**
   * Vote: 0 (for implausible) or 1 (for plausible)
   **/
  @ApiModelProperty(required = true, value = "Vote: 0 (for implausible) or 1 (for plausible)")
  public Boolean getVote() {
    return vote;
  }
  public void setVote(Boolean vote) {
    this.vote = vote;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PostVote postVote = (PostVote) o;
    return (cause == null ? postVote.cause == null : cause.equals(postVote.cause)) &&
        (effect == null ? postVote.effect == null : effect.equals(postVote.effect)) &&
        (vote == null ? postVote.vote == null : vote.equals(postVote.vote));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (cause == null ? 0: cause.hashCode());
    result = 31 * result + (effect == null ? 0: effect.hashCode());
    result = 31 * result + (vote == null ? 0: vote.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class PostVote {\n");
    
    sb.append("  cause: ").append(cause).append("\n");
    sb.append("  effect: ").append(effect).append("\n");
    sb.append("  vote: ").append(vote).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
