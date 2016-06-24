package io.swagger.client.model;


import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class UserVariableRelationship  {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("confidence_level")
  private String confidenceLevel = null;
  @SerializedName("confidence_score")
  private Float confidenceScore = null;
  @SerializedName("direction")
  private String direction = null;
  @SerializedName("duration_of_action")
  private Integer durationOfAction = null;
  @SerializedName("error_message")
  private String errorMessage = null;
  @SerializedName("onset_delay")
  private Integer onsetDelay = null;
  @SerializedName("outcome_variable_id")
  private Integer outcomeVariableId = null;
  @SerializedName("predictor_variable_id")
  private Integer predictorVariableId = null;
  @SerializedName("predictor_unit_id")
  private Integer predictorUnitId = null;
  @SerializedName("sinn_rank")
  private Float sinnRank = null;
  @SerializedName("strength_level")
  private String strengthLevel = null;
  @SerializedName("strength_score")
  private Float strengthScore = null;
  @SerializedName("user_id")
  private Integer userId = null;
  @SerializedName("vote")
  private String vote = null;
  @SerializedName("value_predicting_high_outcome")
  private Float valuePredictingHighOutcome = null;
  @SerializedName("value_predicting_low_outcome")
  private Float valuePredictingLowOutcome = null;

  /**
   * id
   **/
  @ApiModelProperty(value = "id")
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Our confidence that a consistent predictive relationship exists based on the amount of evidence, reproducibility, and other factors
   **/
  @ApiModelProperty(required = true, value = "Our confidence that a consistent predictive relationship exists based on the amount of evidence, reproducibility, and other factors")
  public String getConfidenceLevel() {
    return confidenceLevel;
  }
  public void setConfidenceLevel(String confidenceLevel) {
    this.confidenceLevel = confidenceLevel;
  }

  /**
   * A quantitative representation of our confidence that a consistent predictive relationship exists based on the amount of evidence, reproducibility, and other factors
   **/
  @ApiModelProperty(required = true, value = "A quantitative representation of our confidence that a consistent predictive relationship exists based on the amount of evidence, reproducibility, and other factors")
  public Float getConfidenceScore() {
    return confidenceScore;
  }
  public void setConfidenceScore(Float confidenceScore) {
    this.confidenceScore = confidenceScore;
  }

  /**
   * Direction is positive if higher predictor values generally precede higher outcome values. Direction is negative if higher predictor values generally precede lower outcome values.
   **/
  @ApiModelProperty(required = true, value = "Direction is positive if higher predictor values generally precede higher outcome values. Direction is negative if higher predictor values generally precede lower outcome values.")
  public String getDirection() {
    return direction;
  }
  public void setDirection(String direction) {
    this.direction = direction;
  }

  /**
   * Number of seconds over which the predictor variable event is expected to produce a perceivable effect following the onset delay
   **/
  @ApiModelProperty(required = true, value = "Number of seconds over which the predictor variable event is expected to produce a perceivable effect following the onset delay")
  public Integer getDurationOfAction() {
    return durationOfAction;
  }
  public void setDurationOfAction(Integer durationOfAction) {
    this.durationOfAction = durationOfAction;
  }

  /**
   * error_message
   **/
  @ApiModelProperty(value = "error_message")
  public String getErrorMessage() {
    return errorMessage;
  }
  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  /**
   * User estimated (or default number of seconds) after cause measurement before a perceivable effect is observed
   **/
  @ApiModelProperty(value = "User estimated (or default number of seconds) after cause measurement before a perceivable effect is observed")
  public Integer getOnsetDelay() {
    return onsetDelay;
  }
  public void setOnsetDelay(Integer onsetDelay) {
    this.onsetDelay = onsetDelay;
  }

  /**
   * Variable ID for the outcome variable
   **/
  @ApiModelProperty(required = true, value = "Variable ID for the outcome variable")
  public Integer getOutcomeVariableId() {
    return outcomeVariableId;
  }
  public void setOutcomeVariableId(Integer outcomeVariableId) {
    this.outcomeVariableId = outcomeVariableId;
  }

  /**
   * Variable ID for the predictor variable
   **/
  @ApiModelProperty(required = true, value = "Variable ID for the predictor variable")
  public Integer getPredictorVariableId() {
    return predictorVariableId;
  }
  public void setPredictorVariableId(Integer predictorVariableId) {
    this.predictorVariableId = predictorVariableId;
  }

  /**
   * ID for default unit of the predictor variable
   **/
  @ApiModelProperty(required = true, value = "ID for default unit of the predictor variable")
  public Integer getPredictorUnitId() {
    return predictorUnitId;
  }
  public void setPredictorUnitId(Integer predictorUnitId) {
    this.predictorUnitId = predictorUnitId;
  }

  /**
   * A value representative of the relevance of this predictor relative to other predictors of this outcome.  Usually used for relevancy sorting.
   **/
  @ApiModelProperty(required = true, value = "A value representative of the relevance of this predictor relative to other predictors of this outcome.  Usually used for relevancy sorting.")
  public Float getSinnRank() {
    return sinnRank;
  }
  public void setSinnRank(Float sinnRank) {
    this.sinnRank = sinnRank;
  }

  /**
   * Can be weak, medium, or strong based on the size of the effect which the predictor appears to have on the outcome relative to other variable relationship strength scores.
   **/
  @ApiModelProperty(required = true, value = "Can be weak, medium, or strong based on the size of the effect which the predictor appears to have on the outcome relative to other variable relationship strength scores.")
  public String getStrengthLevel() {
    return strengthLevel;
  }
  public void setStrengthLevel(String strengthLevel) {
    this.strengthLevel = strengthLevel;
  }

  /**
   * A value represented to the size of the effect which the predictor appears to have on the outcome.
   **/
  @ApiModelProperty(required = true, value = "A value represented to the size of the effect which the predictor appears to have on the outcome.")
  public Float getStrengthScore() {
    return strengthScore;
  }
  public void setStrengthScore(Float strengthScore) {
    this.strengthScore = strengthScore;
  }

  /**
   * user_id
   **/
  @ApiModelProperty(value = "user_id")
  public Integer getUserId() {
    return userId;
  }
  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  /**
   * vote
   **/
  @ApiModelProperty(value = "vote")
  public String getVote() {
    return vote;
  }
  public void setVote(String vote) {
    this.vote = vote;
  }

  /**
   * Value for the predictor variable (in it's default unit) which typically precedes an above average outcome value
   **/
  @ApiModelProperty(required = true, value = "Value for the predictor variable (in it's default unit) which typically precedes an above average outcome value")
  public Float getValuePredictingHighOutcome() {
    return valuePredictingHighOutcome;
  }
  public void setValuePredictingHighOutcome(Float valuePredictingHighOutcome) {
    this.valuePredictingHighOutcome = valuePredictingHighOutcome;
  }

  /**
   * Value for the predictor variable (in it's default unit) which typically precedes a below average outcome value
   **/
  @ApiModelProperty(required = true, value = "Value for the predictor variable (in it's default unit) which typically precedes a below average outcome value")
  public Float getValuePredictingLowOutcome() {
    return valuePredictingLowOutcome;
  }
  public void setValuePredictingLowOutcome(Float valuePredictingLowOutcome) {
    this.valuePredictingLowOutcome = valuePredictingLowOutcome;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserVariableRelationship userVariableRelationship = (UserVariableRelationship) o;
    return (id == null ? userVariableRelationship.id == null : id.equals(userVariableRelationship.id)) &&
        (confidenceLevel == null ? userVariableRelationship.confidenceLevel == null : confidenceLevel.equals(userVariableRelationship.confidenceLevel)) &&
        (confidenceScore == null ? userVariableRelationship.confidenceScore == null : confidenceScore.equals(userVariableRelationship.confidenceScore)) &&
        (direction == null ? userVariableRelationship.direction == null : direction.equals(userVariableRelationship.direction)) &&
        (durationOfAction == null ? userVariableRelationship.durationOfAction == null : durationOfAction.equals(userVariableRelationship.durationOfAction)) &&
        (errorMessage == null ? userVariableRelationship.errorMessage == null : errorMessage.equals(userVariableRelationship.errorMessage)) &&
        (onsetDelay == null ? userVariableRelationship.onsetDelay == null : onsetDelay.equals(userVariableRelationship.onsetDelay)) &&
        (outcomeVariableId == null ? userVariableRelationship.outcomeVariableId == null : outcomeVariableId.equals(userVariableRelationship.outcomeVariableId)) &&
        (predictorVariableId == null ? userVariableRelationship.predictorVariableId == null : predictorVariableId.equals(userVariableRelationship.predictorVariableId)) &&
        (predictorUnitId == null ? userVariableRelationship.predictorUnitId == null : predictorUnitId.equals(userVariableRelationship.predictorUnitId)) &&
        (sinnRank == null ? userVariableRelationship.sinnRank == null : sinnRank.equals(userVariableRelationship.sinnRank)) &&
        (strengthLevel == null ? userVariableRelationship.strengthLevel == null : strengthLevel.equals(userVariableRelationship.strengthLevel)) &&
        (strengthScore == null ? userVariableRelationship.strengthScore == null : strengthScore.equals(userVariableRelationship.strengthScore)) &&
        (userId == null ? userVariableRelationship.userId == null : userId.equals(userVariableRelationship.userId)) &&
        (vote == null ? userVariableRelationship.vote == null : vote.equals(userVariableRelationship.vote)) &&
        (valuePredictingHighOutcome == null ? userVariableRelationship.valuePredictingHighOutcome == null : valuePredictingHighOutcome.equals(userVariableRelationship.valuePredictingHighOutcome)) &&
        (valuePredictingLowOutcome == null ? userVariableRelationship.valuePredictingLowOutcome == null : valuePredictingLowOutcome.equals(userVariableRelationship.valuePredictingLowOutcome));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (id == null ? 0: id.hashCode());
    result = 31 * result + (confidenceLevel == null ? 0: confidenceLevel.hashCode());
    result = 31 * result + (confidenceScore == null ? 0: confidenceScore.hashCode());
    result = 31 * result + (direction == null ? 0: direction.hashCode());
    result = 31 * result + (durationOfAction == null ? 0: durationOfAction.hashCode());
    result = 31 * result + (errorMessage == null ? 0: errorMessage.hashCode());
    result = 31 * result + (onsetDelay == null ? 0: onsetDelay.hashCode());
    result = 31 * result + (outcomeVariableId == null ? 0: outcomeVariableId.hashCode());
    result = 31 * result + (predictorVariableId == null ? 0: predictorVariableId.hashCode());
    result = 31 * result + (predictorUnitId == null ? 0: predictorUnitId.hashCode());
    result = 31 * result + (sinnRank == null ? 0: sinnRank.hashCode());
    result = 31 * result + (strengthLevel == null ? 0: strengthLevel.hashCode());
    result = 31 * result + (strengthScore == null ? 0: strengthScore.hashCode());
    result = 31 * result + (userId == null ? 0: userId.hashCode());
    result = 31 * result + (vote == null ? 0: vote.hashCode());
    result = 31 * result + (valuePredictingHighOutcome == null ? 0: valuePredictingHighOutcome.hashCode());
    result = 31 * result + (valuePredictingLowOutcome == null ? 0: valuePredictingLowOutcome.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserVariableRelationship {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  confidenceLevel: ").append(confidenceLevel).append("\n");
    sb.append("  confidenceScore: ").append(confidenceScore).append("\n");
    sb.append("  direction: ").append(direction).append("\n");
    sb.append("  durationOfAction: ").append(durationOfAction).append("\n");
    sb.append("  errorMessage: ").append(errorMessage).append("\n");
    sb.append("  onsetDelay: ").append(onsetDelay).append("\n");
    sb.append("  outcomeVariableId: ").append(outcomeVariableId).append("\n");
    sb.append("  predictorVariableId: ").append(predictorVariableId).append("\n");
    sb.append("  predictorUnitId: ").append(predictorUnitId).append("\n");
    sb.append("  sinnRank: ").append(sinnRank).append("\n");
    sb.append("  strengthLevel: ").append(strengthLevel).append("\n");
    sb.append("  strengthScore: ").append(strengthScore).append("\n");
    sb.append("  userId: ").append(userId).append("\n");
    sb.append("  vote: ").append(vote).append("\n");
    sb.append("  valuePredictingHighOutcome: ").append(valuePredictingHighOutcome).append("\n");
    sb.append("  valuePredictingLowOutcome: ").append(valuePredictingLowOutcome).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
