package io.swagger.client.model;


import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class Permission  {
  
  @SerializedName("target")
  private Integer target = null;
  @SerializedName("variableName")
  private String variableName = null;
  @SerializedName("minTimestamp")
  private Integer minTimestamp = null;
  @SerializedName("maxTimestamp")
  private Integer maxTimestamp = null;
  @SerializedName("minTimeOfDay")
  private Integer minTimeOfDay = null;
  @SerializedName("maxTimeOfDay")
  private Integer maxTimeOfDay = null;
  @SerializedName("week")
  private String week = null;

  /**
   * Grant permission to target user or public so they may access measurements within the given parameters. TODO: Rename target to something more intuitive.
   **/
  @ApiModelProperty(required = true, value = "Grant permission to target user or public so they may access measurements within the given parameters. TODO: Rename target to something more intuitive.")
  public Integer getTarget() {
    return target;
  }
  public void setTarget(Integer target) {
    this.target = target;
  }

  /**
   * ORIGINAL Variable name
   **/
  @ApiModelProperty(required = true, value = "ORIGINAL Variable name")
  public String getVariableName() {
    return variableName;
  }
  public void setVariableName(String variableName) {
    this.variableName = variableName;
  }

  /**
   * Earliest time when measurements will be accessible in epoch seconds
   **/
  @ApiModelProperty(required = true, value = "Earliest time when measurements will be accessible in epoch seconds")
  public Integer getMinTimestamp() {
    return minTimestamp;
  }
  public void setMinTimestamp(Integer minTimestamp) {
    this.minTimestamp = minTimestamp;
  }

  /**
   * Latest time when measurements will be accessible in epoch seconds
   **/
  @ApiModelProperty(required = true, value = "Latest time when measurements will be accessible in epoch seconds")
  public Integer getMaxTimestamp() {
    return maxTimestamp;
  }
  public void setMaxTimestamp(Integer maxTimestamp) {
    this.maxTimestamp = maxTimestamp;
  }

  /**
   * Earliest time of day when measurements will be accessible in epoch seconds
   **/
  @ApiModelProperty(required = true, value = "Earliest time of day when measurements will be accessible in epoch seconds")
  public Integer getMinTimeOfDay() {
    return minTimeOfDay;
  }
  public void setMinTimeOfDay(Integer minTimeOfDay) {
    this.minTimeOfDay = minTimeOfDay;
  }

  /**
   * Latest time of day when measurements will be accessible in epoch seconds
   **/
  @ApiModelProperty(required = true, value = "Latest time of day when measurements will be accessible in epoch seconds")
  public Integer getMaxTimeOfDay() {
    return maxTimeOfDay;
  }
  public void setMaxTimeOfDay(Integer maxTimeOfDay) {
    this.maxTimeOfDay = maxTimeOfDay;
  }

  /**
   * Maybe specifies if only weekday measurements should be accessible
   **/
  @ApiModelProperty(required = true, value = "Maybe specifies if only weekday measurements should be accessible")
  public String getWeek() {
    return week;
  }
  public void setWeek(String week) {
    this.week = week;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Permission permission = (Permission) o;
    return (target == null ? permission.target == null : target.equals(permission.target)) &&
        (variableName == null ? permission.variableName == null : variableName.equals(permission.variableName)) &&
        (minTimestamp == null ? permission.minTimestamp == null : minTimestamp.equals(permission.minTimestamp)) &&
        (maxTimestamp == null ? permission.maxTimestamp == null : maxTimestamp.equals(permission.maxTimestamp)) &&
        (minTimeOfDay == null ? permission.minTimeOfDay == null : minTimeOfDay.equals(permission.minTimeOfDay)) &&
        (maxTimeOfDay == null ? permission.maxTimeOfDay == null : maxTimeOfDay.equals(permission.maxTimeOfDay)) &&
        (week == null ? permission.week == null : week.equals(permission.week));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (target == null ? 0: target.hashCode());
    result = 31 * result + (variableName == null ? 0: variableName.hashCode());
    result = 31 * result + (minTimestamp == null ? 0: minTimestamp.hashCode());
    result = 31 * result + (maxTimestamp == null ? 0: maxTimestamp.hashCode());
    result = 31 * result + (minTimeOfDay == null ? 0: minTimeOfDay.hashCode());
    result = 31 * result + (maxTimeOfDay == null ? 0: maxTimeOfDay.hashCode());
    result = 31 * result + (week == null ? 0: week.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Permission {\n");
    
    sb.append("  target: ").append(target).append("\n");
    sb.append("  variableName: ").append(variableName).append("\n");
    sb.append("  minTimestamp: ").append(minTimestamp).append("\n");
    sb.append("  maxTimestamp: ").append(maxTimestamp).append("\n");
    sb.append("  minTimeOfDay: ").append(minTimeOfDay).append("\n");
    sb.append("  maxTimeOfDay: ").append(maxTimeOfDay).append("\n");
    sb.append("  week: ").append(week).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
