package io.swagger.client.model;

import java.util.Date;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class Variable  {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("client_id")
  private String clientId = null;
  @SerializedName("parent_id")
  private Integer parentId = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("variable_category_id")
  private Integer variableCategoryId = null;
  @SerializedName("default_unit_id")
  private Integer defaultUnitId = null;
  @SerializedName("combination_operation")
  private String combinationOperation = null;
  @SerializedName("filling_value")
  private Float fillingValue = null;
  @SerializedName("maximum_allowed_value")
  private Float maximumAllowedValue = null;
  @SerializedName("minimum_allowed_value")
  private Float minimumAllowedValue = null;
  @SerializedName("onset_delay")
  private Integer onsetDelay = null;
  @SerializedName("duration_of_action")
  private Integer durationOfAction = null;
  @SerializedName("public")
  private Integer _public = null;
  @SerializedName("cause_only")
  private Boolean causeOnly = null;
  @SerializedName("most_common_value")
  private Float mostCommonValue = null;
  @SerializedName("most_common_unit_id")
  private Integer mostCommonUnitId = null;
  @SerializedName("standard_deviation")
  private Float standardDeviation = null;
  @SerializedName("variance")
  private Float variance = null;
  @SerializedName("mean")
  private Float mean = null;
  @SerializedName("median")
  private Float median = null;
  @SerializedName("number_of_measurements")
  private Float numberOfMeasurements = null;
  @SerializedName("number_of_unique_values")
  private Float numberOfUniqueValues = null;
  @SerializedName("skewness")
  private Float skewness = null;
  @SerializedName("kurtosis")
  private Float kurtosis = null;
  @SerializedName("status")
  private String status = null;
  @SerializedName("error_message")
  private String errorMessage = null;
  @SerializedName("last_successful_update_time")
  private Date lastSuccessfulUpdateTime = null;
  @SerializedName("created_at")
  private Date createdAt = null;
  @SerializedName("updated_at")
  private Date updatedAt = null;
  @SerializedName("product_url")
  private String productUrl = null;
  @SerializedName("image_url")
  private String imageUrl = null;
  @SerializedName("price")
  private Float price = null;
  @SerializedName("number_of_user_variables")
  private Integer numberOfUserVariables = null;
  @SerializedName("outcome")
  private Boolean outcome = null;
  @SerializedName("minimum_recorded_value")
  private Float minimumRecordedValue = null;
  @SerializedName("maximum_recorded_value")
  private Float maximumRecordedValue = null;

  
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
   * client_id
   **/
  @ApiModelProperty(value = "client_id")
  public String getClientId() {
    return clientId;
  }
  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  
  /**
   * parent_id
   **/
  @ApiModelProperty(value = "parent_id")
  public Integer getParentId() {
    return parentId;
  }
  public void setParentId(Integer parentId) {
    this.parentId = parentId;
  }

  
  /**
   * Name of the variable
   **/
  @ApiModelProperty(required = true, value = "Name of the variable")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   * Category of the variable
   **/
  @ApiModelProperty(required = true, value = "Category of the variable")
  public Integer getVariableCategoryId() {
    return variableCategoryId;
  }
  public void setVariableCategoryId(Integer variableCategoryId) {
    this.variableCategoryId = variableCategoryId;
  }

  
  /**
   * ID of the default unit of measurement to use for this variable
   **/
  @ApiModelProperty(required = true, value = "ID of the default unit of measurement to use for this variable")
  public Integer getDefaultUnitId() {
    return defaultUnitId;
  }
  public void setDefaultUnitId(Integer defaultUnitId) {
    this.defaultUnitId = defaultUnitId;
  }

  
  /**
   * How to combine values of this variable (for instance, to see a summary of the values over a month) 0 for sum OR 1 for mean
   **/
  @ApiModelProperty(value = "How to combine values of this variable (for instance, to see a summary of the values over a month) 0 for sum OR 1 for mean")
  public String getCombinationOperation() {
    return combinationOperation;
  }
  public void setCombinationOperation(String combinationOperation) {
    this.combinationOperation = combinationOperation;
  }

  
  /**
   * filling_value
   **/
  @ApiModelProperty(value = "filling_value")
  public Float getFillingValue() {
    return fillingValue;
  }
  public void setFillingValue(Float fillingValue) {
    this.fillingValue = fillingValue;
  }

  
  /**
   * maximum_allowed_value
   **/
  @ApiModelProperty(value = "maximum_allowed_value")
  public Float getMaximumAllowedValue() {
    return maximumAllowedValue;
  }
  public void setMaximumAllowedValue(Float maximumAllowedValue) {
    this.maximumAllowedValue = maximumAllowedValue;
  }

  
  /**
   * minimum_allowed_value
   **/
  @ApiModelProperty(value = "minimum_allowed_value")
  public Float getMinimumAllowedValue() {
    return minimumAllowedValue;
  }
  public void setMinimumAllowedValue(Float minimumAllowedValue) {
    this.minimumAllowedValue = minimumAllowedValue;
  }

  
  /**
   * onset_delay
   **/
  @ApiModelProperty(value = "onset_delay")
  public Integer getOnsetDelay() {
    return onsetDelay;
  }
  public void setOnsetDelay(Integer onsetDelay) {
    this.onsetDelay = onsetDelay;
  }

  
  /**
   * duration_of_action
   **/
  @ApiModelProperty(value = "duration_of_action")
  public Integer getDurationOfAction() {
    return durationOfAction;
  }
  public void setDurationOfAction(Integer durationOfAction) {
    this.durationOfAction = durationOfAction;
  }

  
  /**
   * public
   **/
  @ApiModelProperty(value = "public")
  public Integer getPublic() {
    return _public;
  }
  public void setPublic(Integer _public) {
    this._public = _public;
  }

  
  /**
   * cause_only
   **/
  @ApiModelProperty(value = "cause_only")
  public Boolean getCauseOnly() {
    return causeOnly;
  }
  public void setCauseOnly(Boolean causeOnly) {
    this.causeOnly = causeOnly;
  }

  
  /**
   * most_common_value
   **/
  @ApiModelProperty(value = "most_common_value")
  public Float getMostCommonValue() {
    return mostCommonValue;
  }
  public void setMostCommonValue(Float mostCommonValue) {
    this.mostCommonValue = mostCommonValue;
  }

  
  /**
   * most_common_unit_id
   **/
  @ApiModelProperty(value = "most_common_unit_id")
  public Integer getMostCommonUnitId() {
    return mostCommonUnitId;
  }
  public void setMostCommonUnitId(Integer mostCommonUnitId) {
    this.mostCommonUnitId = mostCommonUnitId;
  }

  
  /**
   * standard_deviation
   **/
  @ApiModelProperty(value = "standard_deviation")
  public Float getStandardDeviation() {
    return standardDeviation;
  }
  public void setStandardDeviation(Float standardDeviation) {
    this.standardDeviation = standardDeviation;
  }

  
  /**
   * variance
   **/
  @ApiModelProperty(value = "variance")
  public Float getVariance() {
    return variance;
  }
  public void setVariance(Float variance) {
    this.variance = variance;
  }

  
  /**
   * mean
   **/
  @ApiModelProperty(value = "mean")
  public Float getMean() {
    return mean;
  }
  public void setMean(Float mean) {
    this.mean = mean;
  }

  
  /**
   * median
   **/
  @ApiModelProperty(value = "median")
  public Float getMedian() {
    return median;
  }
  public void setMedian(Float median) {
    this.median = median;
  }

  
  /**
   * number_of_measurements
   **/
  @ApiModelProperty(value = "number_of_measurements")
  public Float getNumberOfMeasurements() {
    return numberOfMeasurements;
  }
  public void setNumberOfMeasurements(Float numberOfMeasurements) {
    this.numberOfMeasurements = numberOfMeasurements;
  }

  
  /**
   * number_of_unique_values
   **/
  @ApiModelProperty(value = "number_of_unique_values")
  public Float getNumberOfUniqueValues() {
    return numberOfUniqueValues;
  }
  public void setNumberOfUniqueValues(Float numberOfUniqueValues) {
    this.numberOfUniqueValues = numberOfUniqueValues;
  }

  
  /**
   * skewness
   **/
  @ApiModelProperty(value = "skewness")
  public Float getSkewness() {
    return skewness;
  }
  public void setSkewness(Float skewness) {
    this.skewness = skewness;
  }

  
  /**
   * kurtosis
   **/
  @ApiModelProperty(value = "kurtosis")
  public Float getKurtosis() {
    return kurtosis;
  }
  public void setKurtosis(Float kurtosis) {
    this.kurtosis = kurtosis;
  }

  
  /**
   * status
   **/
  @ApiModelProperty(value = "status")
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
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
   * last_successful_update_time
   **/
  @ApiModelProperty(value = "last_successful_update_time")
  public Date getLastSuccessfulUpdateTime() {
    return lastSuccessfulUpdateTime;
  }
  public void setLastSuccessfulUpdateTime(Date lastSuccessfulUpdateTime) {
    this.lastSuccessfulUpdateTime = lastSuccessfulUpdateTime;
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
   * product_url
   **/
  @ApiModelProperty(value = "product_url")
  public String getProductUrl() {
    return productUrl;
  }
  public void setProductUrl(String productUrl) {
    this.productUrl = productUrl;
  }

  
  /**
   * image_url
   **/
  @ApiModelProperty(value = "image_url")
  public String getImageUrl() {
    return imageUrl;
  }
  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  
  /**
   * price
   **/
  @ApiModelProperty(value = "price")
  public Float getPrice() {
    return price;
  }
  public void setPrice(Float price) {
    this.price = price;
  }

  
  /**
   * number_of_user_variables
   **/
  @ApiModelProperty(value = "number_of_user_variables")
  public Integer getNumberOfUserVariables() {
    return numberOfUserVariables;
  }
  public void setNumberOfUserVariables(Integer numberOfUserVariables) {
    this.numberOfUserVariables = numberOfUserVariables;
  }

  
  /**
   * outcome
   **/
  @ApiModelProperty(value = "outcome")
  public Boolean getOutcome() {
    return outcome;
  }
  public void setOutcome(Boolean outcome) {
    this.outcome = outcome;
  }

  
  /**
   * minimum_recorded_value
   **/
  @ApiModelProperty(value = "minimum_recorded_value")
  public Float getMinimumRecordedValue() {
    return minimumRecordedValue;
  }
  public void setMinimumRecordedValue(Float minimumRecordedValue) {
    this.minimumRecordedValue = minimumRecordedValue;
  }

  
  /**
   * maximum_recorded_value
   **/
  @ApiModelProperty(value = "maximum_recorded_value")
  public Float getMaximumRecordedValue() {
    return maximumRecordedValue;
  }
  public void setMaximumRecordedValue(Float maximumRecordedValue) {
    this.maximumRecordedValue = maximumRecordedValue;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Variable {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  clientId: ").append(clientId).append("\n");
    sb.append("  parentId: ").append(parentId).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  variableCategoryId: ").append(variableCategoryId).append("\n");
    sb.append("  defaultUnitId: ").append(defaultUnitId).append("\n");
    sb.append("  combinationOperation: ").append(combinationOperation).append("\n");
    sb.append("  fillingValue: ").append(fillingValue).append("\n");
    sb.append("  maximumAllowedValue: ").append(maximumAllowedValue).append("\n");
    sb.append("  minimumAllowedValue: ").append(minimumAllowedValue).append("\n");
    sb.append("  onsetDelay: ").append(onsetDelay).append("\n");
    sb.append("  durationOfAction: ").append(durationOfAction).append("\n");
    sb.append("  _public: ").append(_public).append("\n");
    sb.append("  causeOnly: ").append(causeOnly).append("\n");
    sb.append("  mostCommonValue: ").append(mostCommonValue).append("\n");
    sb.append("  mostCommonUnitId: ").append(mostCommonUnitId).append("\n");
    sb.append("  standardDeviation: ").append(standardDeviation).append("\n");
    sb.append("  variance: ").append(variance).append("\n");
    sb.append("  mean: ").append(mean).append("\n");
    sb.append("  median: ").append(median).append("\n");
    sb.append("  numberOfMeasurements: ").append(numberOfMeasurements).append("\n");
    sb.append("  numberOfUniqueValues: ").append(numberOfUniqueValues).append("\n");
    sb.append("  skewness: ").append(skewness).append("\n");
    sb.append("  kurtosis: ").append(kurtosis).append("\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("  errorMessage: ").append(errorMessage).append("\n");
    sb.append("  lastSuccessfulUpdateTime: ").append(lastSuccessfulUpdateTime).append("\n");
    sb.append("  createdAt: ").append(createdAt).append("\n");
    sb.append("  updatedAt: ").append(updatedAt).append("\n");
    sb.append("  productUrl: ").append(productUrl).append("\n");
    sb.append("  imageUrl: ").append(imageUrl).append("\n");
    sb.append("  price: ").append(price).append("\n");
    sb.append("  numberOfUserVariables: ").append(numberOfUserVariables).append("\n");
    sb.append("  outcome: ").append(outcome).append("\n");
    sb.append("  minimumRecordedValue: ").append(minimumRecordedValue).append("\n");
    sb.append("  maximumRecordedValue: ").append(maximumRecordedValue).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
