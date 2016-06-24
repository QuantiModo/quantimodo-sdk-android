package io.swagger.client.model;


import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class HumanTime  {
  
  @SerializedName("date")
  private String date = null;
  @SerializedName("timezone_type")
  private Integer timezoneType = null;
  @SerializedName("timezone")
  private String timezone = null;

  /**
   * date time
   **/
  @ApiModelProperty(value = "date time")
  public String getDate() {
    return date;
  }
  public void setDate(String date) {
    this.date = date;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Integer getTimezoneType() {
    return timezoneType;
  }
  public void setTimezoneType(Integer timezoneType) {
    this.timezoneType = timezoneType;
  }

  /**
   * timezone of date time
   **/
  @ApiModelProperty(value = "timezone of date time")
  public String getTimezone() {
    return timezone;
  }
  public void setTimezone(String timezone) {
    this.timezone = timezone;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HumanTime humanTime = (HumanTime) o;
    return (date == null ? humanTime.date == null : date.equals(humanTime.date)) &&
        (timezoneType == null ? humanTime.timezoneType == null : timezoneType.equals(humanTime.timezoneType)) &&
        (timezone == null ? humanTime.timezone == null : timezone.equals(humanTime.timezone));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (date == null ? 0: date.hashCode());
    result = 31 * result + (timezoneType == null ? 0: timezoneType.hashCode());
    result = 31 * result + (timezone == null ? 0: timezone.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class HumanTime {\n");
    
    sb.append("  date: ").append(date).append("\n");
    sb.append("  timezoneType: ").append(timezoneType).append("\n");
    sb.append("  timezone: ").append(timezone).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
