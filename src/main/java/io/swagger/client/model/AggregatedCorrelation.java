package io.swagger.client.model;

import java.util.Date;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class AggregatedCorrelation  {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("correlation")
  private Float correlation = null;
  @SerializedName("cause_id")
  private Integer causeId = null;
  @SerializedName("effect_id")
  private Integer effectId = null;
  @SerializedName("onset_delay")
  private Integer onsetDelay = null;
  @SerializedName("duration_of_action")
  private Integer durationOfAction = null;
  @SerializedName("number_of_pairs")
  private Integer numberOfPairs = null;
  @SerializedName("value_predicting_high_outcome")
  private Float valuePredictingHighOutcome = null;
  @SerializedName("value_predicting_low_outcome")
  private Float valuePredictingLowOutcome = null;
  @SerializedName("optimal_pearson_product")
  private Float optimalPearsonProduct = null;
  @SerializedName("vote")
  private Float vote = null;
  @SerializedName("number_of_users")
  private Integer numberOfUsers = null;
  @SerializedName("number_of_correlations")
  private Integer numberOfCorrelations = null;
  @SerializedName("statistical_significance")
  private Float statisticalSignificance = null;
  @SerializedName("cause_unit")
  private String causeUnit = null;
  @SerializedName("cause_unit_id")
  private Integer causeUnitId = null;
  @SerializedName("cause_changes")
  private Integer causeChanges = null;
  @SerializedName("effect_changes")
  private Integer effectChanges = null;
  @SerializedName("aggregate_qm_score")
  private Float aggregateQmScore = null;
  @SerializedName("created_at")
  private Date createdAt = null;
  @SerializedName("updated_at")
  private Date updatedAt = null;
  @SerializedName("status")
  private String status = null;
  @SerializedName("error_message")
  private String errorMessage = null;
  @SerializedName("last_successful_update_time")
  private Date lastSuccessfulUpdateTime = null;
  @SerializedName("reverse_pearson_correlation_coefficient")
  private Float reversePearsonCorrelationCoefficient = null;
  @SerializedName("predictive_pearson_correlation_coefficient")
  private Float predictivePearsonCorrelationCoefficient = null;

  
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
   * correlation
   **/
  @ApiModelProperty(required = true, value = "correlation")
  public Float getCorrelation() {
    return correlation;
  }
  public void setCorrelation(Float correlation) {
    this.correlation = correlation;
  }

  
  /**
   * cause_id
   **/
  @ApiModelProperty(required = true, value = "cause_id")
  public Integer getCauseId() {
    return causeId;
  }
  public void setCauseId(Integer causeId) {
    this.causeId = causeId;
  }

  
  /**
   * effect_id
   **/
  @ApiModelProperty(required = true, value = "effect_id")
  public Integer getEffectId() {
    return effectId;
  }
  public void setEffectId(Integer effectId) {
    this.effectId = effectId;
  }

  
  /**
   * onset_delay
   **/
  @ApiModelProperty(required = true, value = "onset_delay")
  public Integer getOnsetDelay() {
    return onsetDelay;
  }
  public void setOnsetDelay(Integer onsetDelay) {
    this.onsetDelay = onsetDelay;
  }

  
  /**
   * duration_of_action
   **/
  @ApiModelProperty(required = true, value = "duration_of_action")
  public Integer getDurationOfAction() {
    return durationOfAction;
  }
  public void setDurationOfAction(Integer durationOfAction) {
    this.durationOfAction = durationOfAction;
  }

  
  /**
   * number_of_pairs
   **/
  @ApiModelProperty(required = true, value = "number_of_pairs")
  public Integer getNumberOfPairs() {
    return numberOfPairs;
  }
  public void setNumberOfPairs(Integer numberOfPairs) {
    this.numberOfPairs = numberOfPairs;
  }

  
  /**
   * value_predicting_high_outcome
   **/
  @ApiModelProperty(required = true, value = "value_predicting_high_outcome")
  public Float getValuePredictingHighOutcome() {
    return valuePredictingHighOutcome;
  }
  public void setValuePredictingHighOutcome(Float valuePredictingHighOutcome) {
    this.valuePredictingHighOutcome = valuePredictingHighOutcome;
  }

  
  /**
   * value_predicting_low_outcome
   **/
  @ApiModelProperty(required = true, value = "value_predicting_low_outcome")
  public Float getValuePredictingLowOutcome() {
    return valuePredictingLowOutcome;
  }
  public void setValuePredictingLowOutcome(Float valuePredictingLowOutcome) {
    this.valuePredictingLowOutcome = valuePredictingLowOutcome;
  }

  
  /**
   * optimal_pearson_product
   **/
  @ApiModelProperty(required = true, value = "optimal_pearson_product")
  public Float getOptimalPearsonProduct() {
    return optimalPearsonProduct;
  }
  public void setOptimalPearsonProduct(Float optimalPearsonProduct) {
    this.optimalPearsonProduct = optimalPearsonProduct;
  }

  
  /**
   * vote
   **/
  @ApiModelProperty(required = true, value = "vote")
  public Float getVote() {
    return vote;
  }
  public void setVote(Float vote) {
    this.vote = vote;
  }

  
  /**
   * number_of_users
   **/
  @ApiModelProperty(required = true, value = "number_of_users")
  public Integer getNumberOfUsers() {
    return numberOfUsers;
  }
  public void setNumberOfUsers(Integer numberOfUsers) {
    this.numberOfUsers = numberOfUsers;
  }

  
  /**
   * number_of_correlations
   **/
  @ApiModelProperty(required = true, value = "number_of_correlations")
  public Integer getNumberOfCorrelations() {
    return numberOfCorrelations;
  }
  public void setNumberOfCorrelations(Integer numberOfCorrelations) {
    this.numberOfCorrelations = numberOfCorrelations;
  }

  
  /**
   * statistical_significance
   **/
  @ApiModelProperty(required = true, value = "statistical_significance")
  public Float getStatisticalSignificance() {
    return statisticalSignificance;
  }
  public void setStatisticalSignificance(Float statisticalSignificance) {
    this.statisticalSignificance = statisticalSignificance;
  }

  
  /**
   * cause_unit
   **/
  @ApiModelProperty(required = true, value = "cause_unit")
  public String getCauseUnit() {
    return causeUnit;
  }
  public void setCauseUnit(String causeUnit) {
    this.causeUnit = causeUnit;
  }

  
  /**
   * cause_unit_id
   **/
  @ApiModelProperty(required = true, value = "cause_unit_id")
  public Integer getCauseUnitId() {
    return causeUnitId;
  }
  public void setCauseUnitId(Integer causeUnitId) {
    this.causeUnitId = causeUnitId;
  }

  
  /**
   * cause_changes
   **/
  @ApiModelProperty(required = true, value = "cause_changes")
  public Integer getCauseChanges() {
    return causeChanges;
  }
  public void setCauseChanges(Integer causeChanges) {
    this.causeChanges = causeChanges;
  }

  
  /**
   * effect_changes
   **/
  @ApiModelProperty(required = true, value = "effect_changes")
  public Integer getEffectChanges() {
    return effectChanges;
  }
  public void setEffectChanges(Integer effectChanges) {
    this.effectChanges = effectChanges;
  }

  
  /**
   * aggregate_qm_score
   **/
  @ApiModelProperty(required = true, value = "aggregate_qm_score")
  public Float getAggregateQmScore() {
    return aggregateQmScore;
  }
  public void setAggregateQmScore(Float aggregateQmScore) {
    this.aggregateQmScore = aggregateQmScore;
  }

  
  /**
   * created_at
   **/
  @ApiModelProperty(value = "created_at")
  public Date getCreatedAt() {
    return createdAt;
  }
  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  
  /**
   * updated_at
   **/
  @ApiModelProperty(value = "updated_at")
  public Date getUpdatedAt() {
    return updatedAt;
  }
  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  
  /**
   * status
   **/
  @ApiModelProperty(required = true, value = "status")
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }

  
  /**
   * error_message
   **/
  @ApiModelProperty(required = true, value = "error_message")
  public String getErrorMessage() {
    return errorMessage;
  }
  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  
  /**
   * last_successful_update_time
   **/
  @ApiModelProperty(required = true, value = "last_successful_update_time")
  public Date getLastSuccessfulUpdateTime() {
    return lastSuccessfulUpdateTime;
  }
  public void setLastSuccessfulUpdateTime(Date lastSuccessfulUpdateTime) {
    this.lastSuccessfulUpdateTime = lastSuccessfulUpdateTime;
  }

  
  /**
   * reverse_pearson_correlation_coefficient
   **/
  @ApiModelProperty(required = true, value = "reverse_pearson_correlation_coefficient")
  public Float getReversePearsonCorrelationCoefficient() {
    return reversePearsonCorrelationCoefficient;
  }
  public void setReversePearsonCorrelationCoefficient(Float reversePearsonCorrelationCoefficient) {
    this.reversePearsonCorrelationCoefficient = reversePearsonCorrelationCoefficient;
  }

  
  /**
   * predictive_pearson_correlation_coefficient
   **/
  @ApiModelProperty(required = true, value = "predictive_pearson_correlation_coefficient")
  public Float getPredictivePearsonCorrelationCoefficient() {
    return predictivePearsonCorrelationCoefficient;
  }
  public void setPredictivePearsonCorrelationCoefficient(Float predictivePearsonCorrelationCoefficient) {
    this.predictivePearsonCorrelationCoefficient = predictivePearsonCorrelationCoefficient;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class AggregatedCorrelation {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  correlation: ").append(correlation).append("\n");
    sb.append("  causeId: ").append(causeId).append("\n");
    sb.append("  effectId: ").append(effectId).append("\n");
    sb.append("  onsetDelay: ").append(onsetDelay).append("\n");
    sb.append("  durationOfAction: ").append(durationOfAction).append("\n");
    sb.append("  numberOfPairs: ").append(numberOfPairs).append("\n");
    sb.append("  valuePredictingHighOutcome: ").append(valuePredictingHighOutcome).append("\n");
    sb.append("  valuePredictingLowOutcome: ").append(valuePredictingLowOutcome).append("\n");
    sb.append("  optimalPearsonProduct: ").append(optimalPearsonProduct).append("\n");
    sb.append("  vote: ").append(vote).append("\n");
    sb.append("  numberOfUsers: ").append(numberOfUsers).append("\n");
    sb.append("  numberOfCorrelations: ").append(numberOfCorrelations).append("\n");
    sb.append("  statisticalSignificance: ").append(statisticalSignificance).append("\n");
    sb.append("  causeUnit: ").append(causeUnit).append("\n");
    sb.append("  causeUnitId: ").append(causeUnitId).append("\n");
    sb.append("  causeChanges: ").append(causeChanges).append("\n");
    sb.append("  effectChanges: ").append(effectChanges).append("\n");
    sb.append("  aggregateQmScore: ").append(aggregateQmScore).append("\n");
    sb.append("  createdAt: ").append(createdAt).append("\n");
    sb.append("  updatedAt: ").append(updatedAt).append("\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("  errorMessage: ").append(errorMessage).append("\n");
    sb.append("  lastSuccessfulUpdateTime: ").append(lastSuccessfulUpdateTime).append("\n");
    sb.append("  reversePearsonCorrelationCoefficient: ").append(reversePearsonCorrelationCoefficient).append("\n");
    sb.append("  predictivePearsonCorrelationCoefficient: ").append(predictivePearsonCorrelationCoefficient).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
