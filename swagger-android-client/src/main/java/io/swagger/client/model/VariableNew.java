package io.swagger.client.model;


import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class VariableNew  {
  
  @SerializedName("name")
  private String name = null;
  @SerializedName("category")
  private String category = null;
  @SerializedName("unit")
  private String unit = null;
  public enum CombinationOperationEnum {
     MEAN,  SUM, 
  };
  @SerializedName("combinationOperation")
  private CombinationOperationEnum combinationOperation = null;
  @SerializedName("parent")
  private String parent = null;

  
  /**
   * User-defined variable display name.
   **/
  @ApiModelProperty(required = true, value = "User-defined variable display name.")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   * Variable category like Mood, Sleep, Physical Activity, Treatment, Symptom, etc.
   **/
  @ApiModelProperty(required = true, value = "Variable category like Mood, Sleep, Physical Activity, Treatment, Symptom, etc.")
  public String getCategory() {
    return category;
  }
  public void setCategory(String category) {
    this.category = category;
  }

  
  /**
   * Abbreviated name of the default unit for the variable
   **/
  @ApiModelProperty(required = true, value = "Abbreviated name of the default unit for the variable")
  public String getUnit() {
    return unit;
  }
  public void setUnit(String unit) {
    this.unit = unit;
  }

  
  /**
   * How to aggregate measurements over time.
   **/
  @ApiModelProperty(required = true, value = "How to aggregate measurements over time.")
  public CombinationOperationEnum getCombinationOperation() {
    return combinationOperation;
  }
  public void setCombinationOperation(CombinationOperationEnum combinationOperation) {
    this.combinationOperation = combinationOperation;
  }

  
  /**
   * Parent
   **/
  @ApiModelProperty(required = true, value = "Parent")
  public String getParent() {
    return parent;
  }
  public void setParent(String parent) {
    this.parent = parent;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class VariableNew {\n");
    
    sb.append("  name: ").append(name).append("\n");
    sb.append("  category: ").append(category).append("\n");
    sb.append("  unit: ").append(unit).append("\n");
    sb.append("  combinationOperation: ").append(combinationOperation).append("\n");
    sb.append("  parent: ").append(parent).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
