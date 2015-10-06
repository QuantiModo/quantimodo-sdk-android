package io.swagger.client.model;


import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class UserVariables  {
  
  @SerializedName("user")
  private Integer user = null;
  @SerializedName("variable")
  private String variable = null;
  @SerializedName("durationOfAction")
  private Integer durationOfAction = null;
  @SerializedName("fillingValue")
  private Integer fillingValue = null;
  @SerializedName("joinWith")
  private String joinWith = null;
  @SerializedName("maximumAllowedValue")
  private Float maximumAllowedValue = null;
  @SerializedName("minimumAllowedValue")
  private Float minimumAllowedValue = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("onsetDelay")
  private Integer onsetDelay = null;
  @SerializedName("unit")
  private String unit = null;

  
  /**
   * User ID
   **/
  @ApiModelProperty(required = true, value = "User ID")
  public Integer getUser() {
    return user;
  }
  public void setUser(Integer user) {
    this.user = user;
  }

  
  /**
   * Variable DISPLAY name
   **/
  @ApiModelProperty(required = true, value = "Variable DISPLAY name")
  public String getVariable() {
    return variable;
  }
  public void setVariable(String variable) {
    this.variable = variable;
  }

  
  /**
   * Estimated duration of time following the onset delay in which a stimulus produces a perceivable effect
   **/
  @ApiModelProperty(required = true, value = "Estimated duration of time following the onset delay in which a stimulus produces a perceivable effect")
  public Integer getDurationOfAction() {
    return durationOfAction;
  }
  public void setDurationOfAction(Integer durationOfAction) {
    this.durationOfAction = durationOfAction;
  }

  
  /**
   * fillingValue
   **/
  @ApiModelProperty(required = true, value = "fillingValue")
  public Integer getFillingValue() {
    return fillingValue;
  }
  public void setFillingValue(Integer fillingValue) {
    this.fillingValue = fillingValue;
  }

  
  /**
   * joinWith
   **/
  @ApiModelProperty(required = true, value = "joinWith")
  public String getJoinWith() {
    return joinWith;
  }
  public void setJoinWith(String joinWith) {
    this.joinWith = joinWith;
  }

  
  /**
   * maximumAllowedValue
   **/
  @ApiModelProperty(required = true, value = "maximumAllowedValue")
  public Float getMaximumAllowedValue() {
    return maximumAllowedValue;
  }
  public void setMaximumAllowedValue(Float maximumAllowedValue) {
    this.maximumAllowedValue = maximumAllowedValue;
  }

  
  /**
   * minimumAllowedValue
   **/
  @ApiModelProperty(required = true, value = "minimumAllowedValue")
  public Float getMinimumAllowedValue() {
    return minimumAllowedValue;
  }
  public void setMinimumAllowedValue(Float minimumAllowedValue) {
    this.minimumAllowedValue = minimumAllowedValue;
  }

  
  /**
   * name
   **/
  @ApiModelProperty(required = true, value = "name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   * onsetDelay
   **/
  @ApiModelProperty(required = true, value = "onsetDelay")
  public Integer getOnsetDelay() {
    return onsetDelay;
  }
  public void setOnsetDelay(Integer onsetDelay) {
    this.onsetDelay = onsetDelay;
  }

  
  /**
   * unit
   **/
  @ApiModelProperty(required = true, value = "unit")
  public String getUnit() {
    return unit;
  }
  public void setUnit(String unit) {
    this.unit = unit;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserVariables {\n");
    
    sb.append("  user: ").append(user).append("\n");
    sb.append("  variable: ").append(variable).append("\n");
    sb.append("  durationOfAction: ").append(durationOfAction).append("\n");
    sb.append("  fillingValue: ").append(fillingValue).append("\n");
    sb.append("  joinWith: ").append(joinWith).append("\n");
    sb.append("  maximumAllowedValue: ").append(maximumAllowedValue).append("\n");
    sb.append("  minimumAllowedValue: ").append(minimumAllowedValue).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  onsetDelay: ").append(onsetDelay).append("\n");
    sb.append("  unit: ").append(unit).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
