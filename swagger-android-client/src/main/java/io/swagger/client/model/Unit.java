package io.swagger.client.model;

import io.swagger.client.model.ConversionStep;
import java.util.*;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class Unit  {
  
  @SerializedName("name")
  private String name = null;
  @SerializedName("abbreviatedName")
  private String abbreviatedName = null;
  public enum CategoryEnum {
     Distance,  Duration,  Energy,  Frequency,  Miscellany,  Pressure,  Proportion,  Rating,  Temperature,  Volume,  Weight, 
  };
  @SerializedName("category")
  private CategoryEnum category = null;
  public enum MinimumEnum {
     Minus_Infinity,
  };
  @SerializedName("minimum")
  private MinimumEnum minimum = null;
  public enum MaximumEnum {
     Infinity, 
  };
  @SerializedName("maximum")
  private MaximumEnum maximum = null;
  @SerializedName("conversionSteps")
  private List<ConversionStep> conversionSteps = null;

  
  /**
   * Unit name
   **/
  @ApiModelProperty(required = true, value = "Unit name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   * Unit abbreviation
   **/
  @ApiModelProperty(required = true, value = "Unit abbreviation")
  public String getAbbreviatedName() {
    return abbreviatedName;
  }
  public void setAbbreviatedName(String abbreviatedName) {
    this.abbreviatedName = abbreviatedName;
  }

  
  /**
   * Unit category
   **/
  @ApiModelProperty(required = true, value = "Unit category")
  public CategoryEnum getCategory() {
    return category;
  }
  public void setCategory(CategoryEnum category) {
    this.category = category;
  }

  
  /**
   * Unit minimum value
   **/
  @ApiModelProperty(required = true, value = "Unit minimum value")
  public MinimumEnum getMinimum() {
    return minimum;
  }
  public void setMinimum(MinimumEnum minimum) {
    this.minimum = minimum;
  }

  
  /**
   * Unit maximum value
   **/
  @ApiModelProperty(required = true, value = "Unit maximum value")
  public MaximumEnum getMaximum() {
    return maximum;
  }
  public void setMaximum(MaximumEnum maximum) {
    this.maximum = maximum;
  }

  
  /**
   * Conversion steps list
   **/
  @ApiModelProperty(required = true, value = "Conversion steps list")
  public List<ConversionStep> getConversionSteps() {
    return conversionSteps;
  }
  public void setConversionSteps(List<ConversionStep> conversionSteps) {
    this.conversionSteps = conversionSteps;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Unit {\n");
    
    sb.append("  name: ").append(name).append("\n");
    sb.append("  abbreviatedName: ").append(abbreviatedName).append("\n");
    sb.append("  category: ").append(category).append("\n");
    sb.append("  minimum: ").append(minimum).append("\n");
    sb.append("  maximum: ").append(maximum).append("\n");
    sb.append("  conversionSteps: ").append(conversionSteps).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
