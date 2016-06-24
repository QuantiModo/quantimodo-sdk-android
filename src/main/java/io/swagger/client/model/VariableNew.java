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
   * Way to aggregate measurements over time. Options are \"MEAN\" or \"SUM\".  SUM should be used for things like minutes of exercise.  If you use MEAN for exercise, then a person might exercise more minutes in one day but add separate measurements that were smaller.  So when we are doing correlational analysis, we would think that the person exercised less that day even though they exercised more.  Conversely, we must use MEAN for things such as ratings which cannot be SUMMED.
   **/
  @ApiModelProperty(required = true, value = "Way to aggregate measurements over time. Options are \"MEAN\" or \"SUM\".  SUM should be used for things like minutes of exercise.  If you use MEAN for exercise, then a person might exercise more minutes in one day but add separate measurements that were smaller.  So when we are doing correlational analysis, we would think that the person exercised less that day even though they exercised more.  Conversely, we must use MEAN for things such as ratings which cannot be SUMMED.")
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
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VariableNew variableNew = (VariableNew) o;
    return (name == null ? variableNew.name == null : name.equals(variableNew.name)) &&
        (category == null ? variableNew.category == null : category.equals(variableNew.category)) &&
        (unit == null ? variableNew.unit == null : unit.equals(variableNew.unit)) &&
        (combinationOperation == null ? variableNew.combinationOperation == null : combinationOperation.equals(variableNew.combinationOperation)) &&
        (parent == null ? variableNew.parent == null : parent.equals(variableNew.parent));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (name == null ? 0: name.hashCode());
    result = 31 * result + (category == null ? 0: category.hashCode());
    result = 31 * result + (unit == null ? 0: unit.hashCode());
    result = 31 * result + (combinationOperation == null ? 0: combinationOperation.hashCode());
    result = 31 * result + (parent == null ? 0: parent.hashCode());
    return result;
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
