package io.swagger.client.model;


import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class ConversionStep  {
  
  public enum OperationEnum {
     MULTIPLY,  ADD, 
  };
  @SerializedName("operation")
  private OperationEnum operation = null;
  @SerializedName("value")
  private Double value = null;

  /**
   * ADD or MULTIPLY
   **/
  @ApiModelProperty(required = true, value = "ADD or MULTIPLY")
  public OperationEnum getOperation() {
    return operation;
  }
  public void setOperation(OperationEnum operation) {
    this.operation = operation;
  }

  /**
   * This specifies the order of conversion steps starting with 0
   **/
  @ApiModelProperty(required = true, value = "This specifies the order of conversion steps starting with 0")
  public Double getValue() {
    return value;
  }
  public void setValue(Double value) {
    this.value = value;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConversionStep conversionStep = (ConversionStep) o;
    return (operation == null ? conversionStep.operation == null : operation.equals(conversionStep.operation)) &&
        (value == null ? conversionStep.value == null : value.equals(conversionStep.value));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (operation == null ? 0: operation.hashCode());
    result = 31 * result + (value == null ? 0: value.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConversionStep {\n");
    
    sb.append("  operation: ").append(operation).append("\n");
    sb.append("  value: ").append(value).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
