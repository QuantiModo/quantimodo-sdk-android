package io.swagger.client.model;

import io.swagger.client.model.ValueObject;
import java.util.*;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class MeasurementSet  {
  
  @SerializedName("measurements")
  private List<ValueObject> measurements = null;
  @SerializedName("variableName")
  private String variableName = null;
  @SerializedName("sourceName")
  private String sourceName = null;
  @SerializedName("variableCategoryName")
  private String variableCategoryName = null;
  public enum CombinationOperationEnum {
     MEAN,  SUM, 
  };
  @SerializedName("combinationOperation")
  private CombinationOperationEnum combinationOperation = null;
  @SerializedName("abbreviatedUnitName")
  private String abbreviatedUnitName = null;

  /**
   * Array of timestamps, values, and optional notes
   **/
  @ApiModelProperty(required = true, value = "Array of timestamps, values, and optional notes")
  public List<ValueObject> getMeasurements() {
    return measurements;
  }
  public void setMeasurements(List<ValueObject> measurements) {
    this.measurements = measurements;
  }

  /**
   * ORIGINAL name of the variable for which we are creating the measurement records
   **/
  @ApiModelProperty(required = true, value = "ORIGINAL name of the variable for which we are creating the measurement records")
  public String getVariableName() {
    return variableName;
  }
  public void setVariableName(String variableName) {
    this.variableName = variableName;
  }

  /**
   * Name of the application or device used to record the measurement values
   **/
  @ApiModelProperty(required = true, value = "Name of the application or device used to record the measurement values")
  public String getSourceName() {
    return sourceName;
  }
  public void setSourceName(String sourceName) {
    this.sourceName = sourceName;
  }

  /**
   * Variable category name
   **/
  @ApiModelProperty(value = "Variable category name")
  public String getVariableCategoryName() {
    return variableCategoryName;
  }
  public void setVariableCategoryName(String variableCategoryName) {
    this.variableCategoryName = variableCategoryName;
  }

  /**
   * Way to aggregate measurements over time. Options are \"MEAN\" or \"SUM\".  SUM should be used for things like minutes of exercise.  If you use MEAN for exercise, then a person might exercise more minutes in one day but add separate measurements that were smaller.  So when we are doing correlational analysis, we would think that the person exercised less that day even though they exercised more.  Conversely, we must use MEAN for things such as ratings which cannot be SUMMED.
   **/
  @ApiModelProperty(value = "Way to aggregate measurements over time. Options are \"MEAN\" or \"SUM\".  SUM should be used for things like minutes of exercise.  If you use MEAN for exercise, then a person might exercise more minutes in one day but add separate measurements that were smaller.  So when we are doing correlational analysis, we would think that the person exercised less that day even though they exercised more.  Conversely, we must use MEAN for things such as ratings which cannot be SUMMED.")
  public CombinationOperationEnum getCombinationOperation() {
    return combinationOperation;
  }
  public void setCombinationOperation(CombinationOperationEnum combinationOperation) {
    this.combinationOperation = combinationOperation;
  }

  /**
   * Unit of measurement
   **/
  @ApiModelProperty(required = true, value = "Unit of measurement")
  public String getAbbreviatedUnitName() {
    return abbreviatedUnitName;
  }
  public void setAbbreviatedUnitName(String abbreviatedUnitName) {
    this.abbreviatedUnitName = abbreviatedUnitName;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MeasurementSet measurementSet = (MeasurementSet) o;
    return (measurements == null ? measurementSet.measurements == null : measurements.equals(measurementSet.measurements)) &&
        (variableName == null ? measurementSet.variableName == null : variableName.equals(measurementSet.variableName)) &&
        (sourceName == null ? measurementSet.sourceName == null : sourceName.equals(measurementSet.sourceName)) &&
        (variableCategoryName == null ? measurementSet.variableCategoryName == null : variableCategoryName.equals(measurementSet.variableCategoryName)) &&
        (combinationOperation == null ? measurementSet.combinationOperation == null : combinationOperation.equals(measurementSet.combinationOperation)) &&
        (abbreviatedUnitName == null ? measurementSet.abbreviatedUnitName == null : abbreviatedUnitName.equals(measurementSet.abbreviatedUnitName));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (measurements == null ? 0: measurements.hashCode());
    result = 31 * result + (variableName == null ? 0: variableName.hashCode());
    result = 31 * result + (sourceName == null ? 0: sourceName.hashCode());
    result = 31 * result + (variableCategoryName == null ? 0: variableCategoryName.hashCode());
    result = 31 * result + (combinationOperation == null ? 0: combinationOperation.hashCode());
    result = 31 * result + (abbreviatedUnitName == null ? 0: abbreviatedUnitName.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class MeasurementSet {\n");
    
    sb.append("  measurements: ").append(measurements).append("\n");
    sb.append("  variableName: ").append(variableName).append("\n");
    sb.append("  sourceName: ").append(sourceName).append("\n");
    sb.append("  variableCategoryName: ").append(variableCategoryName).append("\n");
    sb.append("  combinationOperation: ").append(combinationOperation).append("\n");
    sb.append("  abbreviatedUnitName: ").append(abbreviatedUnitName).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
