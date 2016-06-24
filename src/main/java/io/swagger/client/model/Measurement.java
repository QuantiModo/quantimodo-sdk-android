package io.swagger.client.model;

import io.swagger.client.model.HumanTime;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class Measurement  {
  
  @SerializedName("variable")
  private String variable = null;
  @SerializedName("source")
  private String source = null;
  @SerializedName("startTime")
  private String startTime = null;
  @SerializedName("humanTime")
  private HumanTime humanTime = null;
  @SerializedName("value")
  private Double value = null;
  @SerializedName("unit")
  private String unit = null;
  @SerializedName("originalValue")
  private Integer originalValue = null;
  @SerializedName("storedValue")
  private Double storedValue = null;
  @SerializedName("storedAbbreviatedUnitName")
  private String storedAbbreviatedUnitName = null;
  @SerializedName("originalAbbreviatedUnitName")
  private String originalAbbreviatedUnitName = null;
  @SerializedName("abbreviatedUnitName")
  private String abbreviatedUnitName = null;
  @SerializedName("note")
  private String note = null;

  /**
   * ORIGINAL Name of the variable for which we are creating the measurement records
   **/
  @ApiModelProperty(required = true, value = "ORIGINAL Name of the variable for which we are creating the measurement records")
  public String getVariable() {
    return variable;
  }
  public void setVariable(String variable) {
    this.variable = variable;
  }

  /**
   * Application or device used to record the measurement values
   **/
  @ApiModelProperty(required = true, value = "Application or device used to record the measurement values")
  public String getSource() {
    return source;
  }
  public void setSource(String source) {
    this.source = source;
  }

  /**
   * Start Time for the measurement event in ISO 8601
   **/
  @ApiModelProperty(required = true, value = "Start Time for the measurement event in ISO 8601")
  public String getStartTime() {
    return startTime;
  }
  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  /**
   * Start Time for the measurement event in ISO 8601
   **/
  @ApiModelProperty(value = "Start Time for the measurement event in ISO 8601")
  public HumanTime getHumanTime() {
    return humanTime;
  }
  public void setHumanTime(HumanTime humanTime) {
    this.humanTime = humanTime;
  }

  /**
   * Converted measurement value in requested unit
   **/
  @ApiModelProperty(required = true, value = "Converted measurement value in requested unit")
  public Double getValue() {
    return value;
  }
  public void setValue(Double value) {
    this.value = value;
  }

  /**
   * Unit of measurement as requested in GET request
   **/
  @ApiModelProperty(required = true, value = "Unit of measurement as requested in GET request")
  public String getUnit() {
    return unit;
  }
  public void setUnit(String unit) {
    this.unit = unit;
  }

  /**
   * Original value
   **/
  @ApiModelProperty(value = "Original value")
  public Integer getOriginalValue() {
    return originalValue;
  }
  public void setOriginalValue(Integer originalValue) {
    this.originalValue = originalValue;
  }

  /**
   * Measurement value in the unit as orignally submitted
   **/
  @ApiModelProperty(value = "Measurement value in the unit as orignally submitted")
  public Double getStoredValue() {
    return storedValue;
  }
  public void setStoredValue(Double storedValue) {
    this.storedValue = storedValue;
  }

  /**
   * Unit of measurement as originally submitted
   **/
  @ApiModelProperty(value = "Unit of measurement as originally submitted")
  public String getStoredAbbreviatedUnitName() {
    return storedAbbreviatedUnitName;
  }
  public void setStoredAbbreviatedUnitName(String storedAbbreviatedUnitName) {
    this.storedAbbreviatedUnitName = storedAbbreviatedUnitName;
  }

  /**
   * Original Unit of measurement as originally submitted
   **/
  @ApiModelProperty(value = "Original Unit of measurement as originally submitted")
  public String getOriginalAbbreviatedUnitName() {
    return originalAbbreviatedUnitName;
  }
  public void setOriginalAbbreviatedUnitName(String originalAbbreviatedUnitName) {
    this.originalAbbreviatedUnitName = originalAbbreviatedUnitName;
  }

  /**
   * Unit of measurement as originally submitted
   **/
  @ApiModelProperty(value = "Unit of measurement as originally submitted")
  public String getAbbreviatedUnitName() {
    return abbreviatedUnitName;
  }
  public void setAbbreviatedUnitName(String abbreviatedUnitName) {
    this.abbreviatedUnitName = abbreviatedUnitName;
  }

  /**
   * Note of measurement
   **/
  @ApiModelProperty(value = "Note of measurement")
  public String getNote() {
    return note;
  }
  public void setNote(String note) {
    this.note = note;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Measurement measurement = (Measurement) o;
    return (variable == null ? measurement.variable == null : variable.equals(measurement.variable)) &&
        (source == null ? measurement.source == null : source.equals(measurement.source)) &&
        (startTime == null ? measurement.startTime == null : startTime.equals(measurement.startTime)) &&
        (humanTime == null ? measurement.humanTime == null : humanTime.equals(measurement.humanTime)) &&
        (value == null ? measurement.value == null : value.equals(measurement.value)) &&
        (unit == null ? measurement.unit == null : unit.equals(measurement.unit)) &&
        (originalValue == null ? measurement.originalValue == null : originalValue.equals(measurement.originalValue)) &&
        (storedValue == null ? measurement.storedValue == null : storedValue.equals(measurement.storedValue)) &&
        (storedAbbreviatedUnitName == null ? measurement.storedAbbreviatedUnitName == null : storedAbbreviatedUnitName.equals(measurement.storedAbbreviatedUnitName)) &&
        (originalAbbreviatedUnitName == null ? measurement.originalAbbreviatedUnitName == null : originalAbbreviatedUnitName.equals(measurement.originalAbbreviatedUnitName)) &&
        (abbreviatedUnitName == null ? measurement.abbreviatedUnitName == null : abbreviatedUnitName.equals(measurement.abbreviatedUnitName)) &&
        (note == null ? measurement.note == null : note.equals(measurement.note));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (variable == null ? 0: variable.hashCode());
    result = 31 * result + (source == null ? 0: source.hashCode());
    result = 31 * result + (startTime == null ? 0: startTime.hashCode());
    result = 31 * result + (humanTime == null ? 0: humanTime.hashCode());
    result = 31 * result + (value == null ? 0: value.hashCode());
    result = 31 * result + (unit == null ? 0: unit.hashCode());
    result = 31 * result + (originalValue == null ? 0: originalValue.hashCode());
    result = 31 * result + (storedValue == null ? 0: storedValue.hashCode());
    result = 31 * result + (storedAbbreviatedUnitName == null ? 0: storedAbbreviatedUnitName.hashCode());
    result = 31 * result + (originalAbbreviatedUnitName == null ? 0: originalAbbreviatedUnitName.hashCode());
    result = 31 * result + (abbreviatedUnitName == null ? 0: abbreviatedUnitName.hashCode());
    result = 31 * result + (note == null ? 0: note.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Measurement {\n");
    
    sb.append("  variable: ").append(variable).append("\n");
    sb.append("  source: ").append(source).append("\n");
    sb.append("  startTime: ").append(startTime).append("\n");
    sb.append("  humanTime: ").append(humanTime).append("\n");
    sb.append("  value: ").append(value).append("\n");
    sb.append("  unit: ").append(unit).append("\n");
    sb.append("  originalValue: ").append(originalValue).append("\n");
    sb.append("  storedValue: ").append(storedValue).append("\n");
    sb.append("  storedAbbreviatedUnitName: ").append(storedAbbreviatedUnitName).append("\n");
    sb.append("  originalAbbreviatedUnitName: ").append(originalAbbreviatedUnitName).append("\n");
    sb.append("  abbreviatedUnitName: ").append(abbreviatedUnitName).append("\n");
    sb.append("  note: ").append(note).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
