package io.swagger.client.model;


import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class MeasurementRange  {
  
  @SerializedName("lowerLimit")
  private Integer lowerLimit = null;
  @SerializedName("upperLimit")
  private Integer upperLimit = null;

  /**
   * The timestamp of the earliest measurement for a user.
   **/
  @ApiModelProperty(required = true, value = "The timestamp of the earliest measurement for a user.")
  public Integer getLowerLimit() {
    return lowerLimit;
  }
  public void setLowerLimit(Integer lowerLimit) {
    this.lowerLimit = lowerLimit;
  }

  /**
   * The timestamp of the most recent measurement for a user.
   **/
  @ApiModelProperty(value = "The timestamp of the most recent measurement for a user.")
  public Integer getUpperLimit() {
    return upperLimit;
  }
  public void setUpperLimit(Integer upperLimit) {
    this.upperLimit = upperLimit;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MeasurementRange measurementRange = (MeasurementRange) o;
    return (lowerLimit == null ? measurementRange.lowerLimit == null : lowerLimit.equals(measurementRange.lowerLimit)) &&
        (upperLimit == null ? measurementRange.upperLimit == null : upperLimit.equals(measurementRange.upperLimit));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (lowerLimit == null ? 0: lowerLimit.hashCode());
    result = 31 * result + (upperLimit == null ? 0: upperLimit.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class MeasurementRange {\n");
    
    sb.append("  lowerLimit: ").append(lowerLimit).append("\n");
    sb.append("  upperLimit: ").append(upperLimit).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
