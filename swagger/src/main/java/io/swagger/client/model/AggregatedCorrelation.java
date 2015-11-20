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
  @SerializedName("data_source")
  private String dataSource = null;

  
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
   * Pearson correlation coefficient between cause and effect measurements
   **/
  @ApiModelProperty(required = true, value = "Pearson correlation coefficient between cause and effect measurements")
  public Float getCorrelation() {
    return correlation;
  }
  public void setCorrelation(Float correlation) {
    this.correlation = correlation;
  }

  
  /**
   * variable ID of the cause variable for which the user desires correlations
   **/
  @ApiModelProperty(required = true, value = "variable ID of the cause variable for which the user desires correlations")
  public Integer getCauseId() {
    return causeId;
  }
  public void setCauseId(Integer causeId) {
    this.causeId = causeId;
  }

  
  /**
   * variable ID of the effect variable for which the user desires correlations
   **/
  @ApiModelProperty(required = true, value = "variable ID of the effect variable for which the user desires correlations")
  public Integer getEffectId() {
    return effectId;
  }
  public void setEffectId(Integer effectId) {
    this.effectId = effectId;
  }

  
  /**
   * User estimated or default time after cause measurement before a perceivable effect is observed
   **/
  @ApiModelProperty(required = true, value = "User estimated or default time after cause measurement before a perceivable effect is observed")
  public Integer getOnsetDelay() {
    return onsetDelay;
  }
  public void setOnsetDelay(Integer onsetDelay) {
    this.onsetDelay = onsetDelay;
  }

  
  /**
   * Time over which the cause is expected to produce a perceivable effect following the onset delay
   **/
  @ApiModelProperty(required = true, value = "Time over which the cause is expected to produce a perceivable effect following the onset delay")
  public Integer getDurationOfAction() {
    return durationOfAction;
  }
  public void setDurationOfAction(Integer durationOfAction) {
    this.durationOfAction = durationOfAction;
  }

  
  /**
   * Number of points that went into the correlation calculation
   **/
  @ApiModelProperty(required = true, value = "Number of points that went into the correlation calculation")
  public Integer getNumberOfPairs() {
    return numberOfPairs;
  }
  public void setNumberOfPairs(Integer numberOfPairs) {
    this.numberOfPairs = numberOfPairs;
  }

  
  /**
   * cause value that predicts an above average effect value (in default unit for cause variable)
   **/
  @ApiModelProperty(required = true, value = "cause value that predicts an above average effect value (in default unit for cause variable)")
  public Float getValuePredictingHighOutcome() {
    return valuePredictingHighOutcome;
  }
  public void setValuePredictingHighOutcome(Float valuePredictingHighOutcome) {
    this.valuePredictingHighOutcome = valuePredictingHighOutcome;
  }

  
  /**
   * cause value that predicts a below average effect value (in default unit for cause variable)
   **/
  @ApiModelProperty(required = true, value = "cause value that predicts a below average effect value (in default unit for cause variable)")
  public Float getValuePredictingLowOutcome() {
    return valuePredictingLowOutcome;
  }
  public void setValuePredictingLowOutcome(Float valuePredictingLowOutcome) {
    this.valuePredictingLowOutcome = valuePredictingLowOutcome;
  }

  
  /**
   * Optimal Pearson Product
   **/
  @ApiModelProperty(required = true, value = "Optimal Pearson Product")
  public Float getOptimalPearsonProduct() {
    return optimalPearsonProduct;
  }
  public void setOptimalPearsonProduct(Float optimalPearsonProduct) {
    this.optimalPearsonProduct = optimalPearsonProduct;
  }

  
  /**
   * Vote
   **/
  @ApiModelProperty(required = true, value = "Vote")
  public Float getVote() {
    return vote;
  }
  public void setVote(Float vote) {
    this.vote = vote;
  }

  
  /**
   * Number of Users by which correlation is aggregated
   **/
  @ApiModelProperty(required = true, value = "Number of Users by which correlation is aggregated")
  public Integer getNumberOfUsers() {
    return numberOfUsers;
  }
  public void setNumberOfUsers(Integer numberOfUsers) {
    this.numberOfUsers = numberOfUsers;
  }

  
  /**
   * Number of Correlations by which correlation is aggregated
   **/
  @ApiModelProperty(required = true, value = "Number of Correlations by which correlation is aggregated")
  public Integer getNumberOfCorrelations() {
    return numberOfCorrelations;
  }
  public void setNumberOfCorrelations(Integer numberOfCorrelations) {
    this.numberOfCorrelations = numberOfCorrelations;
  }

  
  /**
   * A function of the effect size and sample size
   **/
  @ApiModelProperty(required = true, value = "A function of the effect size and sample size")
  public Float getStatisticalSignificance() {
    return statisticalSignificance;
  }
  public void setStatisticalSignificance(Float statisticalSignificance) {
    this.statisticalSignificance = statisticalSignificance;
  }

  
  /**
   * Unit of the predictor variable
   **/
  @ApiModelProperty(required = true, value = "Unit of the predictor variable")
  public String getCauseUnit() {
    return causeUnit;
  }
  public void setCauseUnit(String causeUnit) {
    this.causeUnit = causeUnit;
  }

  
  /**
   * Unit ID of the predictor variable
   **/
  @ApiModelProperty(required = true, value = "Unit ID of the predictor variable")
  public Integer getCauseUnitId() {
    return causeUnitId;
  }
  public void setCauseUnitId(Integer causeUnitId) {
    this.causeUnitId = causeUnitId;
  }

  
  /**
   * Cause changes
   **/
  @ApiModelProperty(required = true, value = "Cause changes")
  public Integer getCauseChanges() {
    return causeChanges;
  }
  public void setCauseChanges(Integer causeChanges) {
    this.causeChanges = causeChanges;
  }

  
  /**
   * Effect changes
   **/
  @ApiModelProperty(required = true, value = "Effect changes")
  public Integer getEffectChanges() {
    return effectChanges;
  }
  public void setEffectChanges(Integer effectChanges) {
    this.effectChanges = effectChanges;
  }

  
  /**
   * Aggregated QM Score
   **/
  @ApiModelProperty(required = true, value = "Aggregated QM Score")
  public Float getAggregateQmScore() {
    return aggregateQmScore;
  }
  public void setAggregateQmScore(Float aggregateQmScore) {
    this.aggregateQmScore = aggregateQmScore;
  }

  
  /**
   * When the measurement record was first created in ISO 8601 datetime format
   **/
  @ApiModelProperty(value = "When the measurement record was first created in ISO 8601 datetime format")
  public Date getCreatedAt() {
    return createdAt;
  }
  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  
  /**
   * When the measurement record in the database was last updated. Use ISO 8601 datetime format
   **/
  @ApiModelProperty(value = "When the measurement record in the database was last updated. Use ISO 8601 datetime format")
  public Date getUpdatedAt() {
    return updatedAt;
  }
  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  
  /**
   * Status
   **/
  @ApiModelProperty(required = true, value = "Status")
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }

  
  /**
   * Error Message
   **/
  @ApiModelProperty(required = true, value = "Error Message")
  public String getErrorMessage() {
    return errorMessage;
  }
  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  
  /**
   * Last Successful update time
   **/
  @ApiModelProperty(required = true, value = "Last Successful update time")
  public Date getLastSuccessfulUpdateTime() {
    return lastSuccessfulUpdateTime;
  }
  public void setLastSuccessfulUpdateTime(Date lastSuccessfulUpdateTime) {
    this.lastSuccessfulUpdateTime = lastSuccessfulUpdateTime;
  }

  
  /**
   * Correlation when cause and effect are reversed. For any causal relationship, the forward correlation should exceed the reverse correlation
   **/
  @ApiModelProperty(required = true, value = "Correlation when cause and effect are reversed. For any causal relationship, the forward correlation should exceed the reverse correlation")
  public Float getReversePearsonCorrelationCoefficient() {
    return reversePearsonCorrelationCoefficient;
  }
  public void setReversePearsonCorrelationCoefficient(Float reversePearsonCorrelationCoefficient) {
    this.reversePearsonCorrelationCoefficient = reversePearsonCorrelationCoefficient;
  }

  
  /**
   * Predictive Pearson Correlation Coefficient
   **/
  @ApiModelProperty(required = true, value = "Predictive Pearson Correlation Coefficient")
  public Float getPredictivePearsonCorrelationCoefficient() {
    return predictivePearsonCorrelationCoefficient;
  }
  public void setPredictivePearsonCorrelationCoefficient(Float predictivePearsonCorrelationCoefficient) {
    this.predictivePearsonCorrelationCoefficient = predictivePearsonCorrelationCoefficient;
  }

  
  /**
   * Source of data for this correlation
   **/
  @ApiModelProperty(value = "Source of data for this correlation")
  public String getDataSource() {
    return dataSource;
  }
  public void setDataSource(String dataSource) {
    this.dataSource = dataSource;
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
    sb.append("  dataSource: ").append(dataSource).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
