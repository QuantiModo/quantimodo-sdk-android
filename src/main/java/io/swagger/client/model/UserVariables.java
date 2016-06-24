package io.swagger.client.model;


import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class UserVariables  {
  
  @SerializedName("user")
  private Integer user = null;
  @SerializedName("variableId")
  private Integer variableId = null;
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
  @SerializedName("onsetDelay")
  private Integer onsetDelay = null;
  @SerializedName("experimentStartTime")
  private String experimentStartTime = null;
  @SerializedName("experimentEndTime")
  private String experimentEndTime = null;

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
   * Common variable id
   **/
  @ApiModelProperty(required = true, value = "Common variable id")
  public Integer getVariableId() {
    return variableId;
  }
  public void setVariableId(Integer variableId) {
    this.variableId = variableId;
  }

  /**
   * Estimated duration of time following the onset delay in which a stimulus produces a perceivable effect
   **/
  @ApiModelProperty(value = "Estimated duration of time following the onset delay in which a stimulus produces a perceivable effect")
  public Integer getDurationOfAction() {
    return durationOfAction;
  }
  public void setDurationOfAction(Integer durationOfAction) {
    this.durationOfAction = durationOfAction;
  }

  /**
   * fillingValue
   **/
  @ApiModelProperty(value = "fillingValue")
  public Integer getFillingValue() {
    return fillingValue;
  }
  public void setFillingValue(Integer fillingValue) {
    this.fillingValue = fillingValue;
  }

  /**
   * joinWith
   **/
  @ApiModelProperty(value = "joinWith")
  public String getJoinWith() {
    return joinWith;
  }
  public void setJoinWith(String joinWith) {
    this.joinWith = joinWith;
  }

  /**
   * maximumAllowedValue
   **/
  @ApiModelProperty(value = "maximumAllowedValue")
  public Float getMaximumAllowedValue() {
    return maximumAllowedValue;
  }
  public void setMaximumAllowedValue(Float maximumAllowedValue) {
    this.maximumAllowedValue = maximumAllowedValue;
  }

  /**
   * minimumAllowedValue
   **/
  @ApiModelProperty(value = "minimumAllowedValue")
  public Float getMinimumAllowedValue() {
    return minimumAllowedValue;
  }
  public void setMinimumAllowedValue(Float minimumAllowedValue) {
    this.minimumAllowedValue = minimumAllowedValue;
  }

  /**
   * onsetDelay
   **/
  @ApiModelProperty(value = "onsetDelay")
  public Integer getOnsetDelay() {
    return onsetDelay;
  }
  public void setOnsetDelay(Integer onsetDelay) {
    this.onsetDelay = onsetDelay;
  }

  /**
   * Earliest measurement startTime that should be used in analysis in ISO format
   **/
  @ApiModelProperty(value = "Earliest measurement startTime that should be used in analysis in ISO format")
  public String getExperimentStartTime() {
    return experimentStartTime;
  }
  public void setExperimentStartTime(String experimentStartTime) {
    this.experimentStartTime = experimentStartTime;
  }

  /**
   * Latest measurement startTime that should be used in analysis in ISO format
   **/
  @ApiModelProperty(value = "Latest measurement startTime that should be used in analysis in ISO format")
  public String getExperimentEndTime() {
    return experimentEndTime;
  }
  public void setExperimentEndTime(String experimentEndTime) {
    this.experimentEndTime = experimentEndTime;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserVariables userVariables = (UserVariables) o;
    return (user == null ? userVariables.user == null : user.equals(userVariables.user)) &&
        (variableId == null ? userVariables.variableId == null : variableId.equals(userVariables.variableId)) &&
        (durationOfAction == null ? userVariables.durationOfAction == null : durationOfAction.equals(userVariables.durationOfAction)) &&
        (fillingValue == null ? userVariables.fillingValue == null : fillingValue.equals(userVariables.fillingValue)) &&
        (joinWith == null ? userVariables.joinWith == null : joinWith.equals(userVariables.joinWith)) &&
        (maximumAllowedValue == null ? userVariables.maximumAllowedValue == null : maximumAllowedValue.equals(userVariables.maximumAllowedValue)) &&
        (minimumAllowedValue == null ? userVariables.minimumAllowedValue == null : minimumAllowedValue.equals(userVariables.minimumAllowedValue)) &&
        (onsetDelay == null ? userVariables.onsetDelay == null : onsetDelay.equals(userVariables.onsetDelay)) &&
        (experimentStartTime == null ? userVariables.experimentStartTime == null : experimentStartTime.equals(userVariables.experimentStartTime)) &&
        (experimentEndTime == null ? userVariables.experimentEndTime == null : experimentEndTime.equals(userVariables.experimentEndTime));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (user == null ? 0: user.hashCode());
    result = 31 * result + (variableId == null ? 0: variableId.hashCode());
    result = 31 * result + (durationOfAction == null ? 0: durationOfAction.hashCode());
    result = 31 * result + (fillingValue == null ? 0: fillingValue.hashCode());
    result = 31 * result + (joinWith == null ? 0: joinWith.hashCode());
    result = 31 * result + (maximumAllowedValue == null ? 0: maximumAllowedValue.hashCode());
    result = 31 * result + (minimumAllowedValue == null ? 0: minimumAllowedValue.hashCode());
    result = 31 * result + (onsetDelay == null ? 0: onsetDelay.hashCode());
    result = 31 * result + (experimentStartTime == null ? 0: experimentStartTime.hashCode());
    result = 31 * result + (experimentEndTime == null ? 0: experimentEndTime.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserVariables {\n");
    
    sb.append("  user: ").append(user).append("\n");
    sb.append("  variableId: ").append(variableId).append("\n");
    sb.append("  durationOfAction: ").append(durationOfAction).append("\n");
    sb.append("  fillingValue: ").append(fillingValue).append("\n");
    sb.append("  joinWith: ").append(joinWith).append("\n");
    sb.append("  maximumAllowedValue: ").append(maximumAllowedValue).append("\n");
    sb.append("  minimumAllowedValue: ").append(minimumAllowedValue).append("\n");
    sb.append("  onsetDelay: ").append(onsetDelay).append("\n");
    sb.append("  experimentStartTime: ").append(experimentStartTime).append("\n");
    sb.append("  experimentEndTime: ").append(experimentEndTime).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
