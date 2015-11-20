package io.swagger.client.model;

import java.util.Date;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class Correlation  {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("timestamp")
  private Integer timestamp = null;
  @SerializedName("user_id")
  private Integer userId = null;
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
  @SerializedName("qm_score")
  private Float qmScore = null;
  @SerializedName("error")
  private String error = null;
  @SerializedName("created_at")
  private Date createdAt = null;
  @SerializedName("updated_at")
  private Date updatedAt = null;
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
   * Time at which correlation was calculated
   **/
  @ApiModelProperty(required = true, value = "Time at which correlation was calculated")
  public Integer getTimestamp() {
    return timestamp;
  }
  public void setTimestamp(Integer timestamp) {
    this.timestamp = timestamp;
  }

  
  /**
   * ID of user that owns this correlation
   **/
  @ApiModelProperty(required = true, value = "ID of user that owns this correlation")
  public Integer getUserId() {
    return userId;
  }
  public void setUserId(Integer userId) {
    this.userId = userId;
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
   * QM Score
   **/
  @ApiModelProperty(required = true, value = "QM Score")
  public Float getQmScore() {
    return qmScore;
  }
  public void setQmScore(Float qmScore) {
    this.qmScore = qmScore;
  }

  
  /**
   * error
   **/
  @ApiModelProperty(required = true, value = "error")
  public String getError() {
    return error;
  }
  public void setError(String error) {
    this.error = error;
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

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Correlation {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  timestamp: ").append(timestamp).append("\n");
    sb.append("  userId: ").append(userId).append("\n");
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
    sb.append("  statisticalSignificance: ").append(statisticalSignificance).append("\n");
    sb.append("  causeUnit: ").append(causeUnit).append("\n");
    sb.append("  causeUnitId: ").append(causeUnitId).append("\n");
    sb.append("  causeChanges: ").append(causeChanges).append("\n");
    sb.append("  effectChanges: ").append(effectChanges).append("\n");
    sb.append("  qmScore: ").append(qmScore).append("\n");
    sb.append("  error: ").append(error).append("\n");
    sb.append("  createdAt: ").append(createdAt).append("\n");
    sb.append("  updatedAt: ").append(updatedAt).append("\n");
    sb.append("  reversePearsonCorrelationCoefficient: ").append(reversePearsonCorrelationCoefficient).append("\n");
    sb.append("  predictivePearsonCorrelationCoefficient: ").append(predictivePearsonCorrelationCoefficient).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
