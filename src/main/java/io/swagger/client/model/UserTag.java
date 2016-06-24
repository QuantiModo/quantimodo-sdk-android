package io.swagger.client.model;

import java.math.BigDecimal;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class UserTag  {
  
  @SerializedName("taggedVariableId")
  private Integer taggedVariableId = null;
  @SerializedName("tagVariableId")
  private Integer tagVariableId = null;
  @SerializedName("conversionFactor")
  private BigDecimal conversionFactor = null;

  /**
   * This is the id of the variable being tagged with an ingredient or something.
   **/
  @ApiModelProperty(required = true, value = "This is the id of the variable being tagged with an ingredient or something.")
  public Integer getTaggedVariableId() {
    return taggedVariableId;
  }
  public void setTaggedVariableId(Integer taggedVariableId) {
    this.taggedVariableId = taggedVariableId;
  }

  /**
   * This is the id of the ingredient variable whose value is determined based on the value of the tagged variable.
   **/
  @ApiModelProperty(required = true, value = "This is the id of the ingredient variable whose value is determined based on the value of the tagged variable.")
  public Integer getTagVariableId() {
    return tagVariableId;
  }
  public void setTagVariableId(Integer tagVariableId) {
    this.tagVariableId = tagVariableId;
  }

  /**
   * Number by which we multiply the tagged variable value to obtain the tag variable (ingredient) value
   **/
  @ApiModelProperty(required = true, value = "Number by which we multiply the tagged variable value to obtain the tag variable (ingredient) value")
  public BigDecimal getConversionFactor() {
    return conversionFactor;
  }
  public void setConversionFactor(BigDecimal conversionFactor) {
    this.conversionFactor = conversionFactor;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserTag userTag = (UserTag) o;
    return (taggedVariableId == null ? userTag.taggedVariableId == null : taggedVariableId.equals(userTag.taggedVariableId)) &&
        (tagVariableId == null ? userTag.tagVariableId == null : tagVariableId.equals(userTag.tagVariableId)) &&
        (conversionFactor == null ? userTag.conversionFactor == null : conversionFactor.equals(userTag.conversionFactor));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (taggedVariableId == null ? 0: taggedVariableId.hashCode());
    result = 31 * result + (tagVariableId == null ? 0: tagVariableId.hashCode());
    result = 31 * result + (conversionFactor == null ? 0: conversionFactor.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserTag {\n");
    
    sb.append("  taggedVariableId: ").append(taggedVariableId).append("\n");
    sb.append("  tagVariableId: ").append(tagVariableId).append("\n");
    sb.append("  conversionFactor: ").append(conversionFactor).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
