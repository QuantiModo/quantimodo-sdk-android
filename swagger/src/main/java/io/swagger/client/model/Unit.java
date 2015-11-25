package io.swagger.client.model;

import java.util.Date;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class Unit  {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("client_id")
  private String clientId = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("abbreviated_name")
  private String abbreviatedName = null;
  @SerializedName("unit_category_id")
  private Integer unitCategoryId = null;
  @SerializedName("minimum_value")
  private Float minimumValue = null;
  @SerializedName("maximum_value")
  private Float maximumValue = null;
  @SerializedName("updated")
  private Integer updated = null;
  @SerializedName("default_unit_id")
  private Integer defaultUnitId = null;
  @SerializedName("multiply")
  private Float multiply = null;
  @SerializedName("add")
  private Float add = null;
  @SerializedName("created_at")
  private Date createdAt = null;
  @SerializedName("updated_at")
  private Date updatedAt = null;

  
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
   * Unit category ID
   **/
  @ApiModelProperty(value = "Unit category ID")
  public Integer getUnitCategoryId() {
    return unitCategoryId;
  }
  public void setUnitCategoryId(Integer unitCategoryId) {
    this.unitCategoryId = unitCategoryId;
  }

  
  /**
   * Minimum value permitted for this unit
   **/
  @ApiModelProperty(value = "Minimum value permitted for this unit")
  public Float getMinimumValue() {
    return minimumValue;
  }
  public void setMinimumValue(Float minimumValue) {
    this.minimumValue = minimumValue;
  }

  
  /**
   * Maximum value permitted for this unit
   **/
  @ApiModelProperty(value = "Maximum value permitted for this unit")
  public Float getMaximumValue() {
    return maximumValue;
  }
  public void setMaximumValue(Float maximumValue) {
    this.maximumValue = maximumValue;
  }

  
  /**
   * updated
   **/
  @ApiModelProperty(value = "updated")
  public Integer getUpdated() {
    return updated;
  }
  public void setUpdated(Integer updated) {
    this.updated = updated;
  }

  
  /**
   * ID of default unit for this units category
   **/
  @ApiModelProperty(value = "ID of default unit for this units category")
  public Integer getDefaultUnitId() {
    return defaultUnitId;
  }
  public void setDefaultUnitId(Integer defaultUnitId) {
    this.defaultUnitId = defaultUnitId;
  }

  
  /**
   * Value multiplied to convert to default unit in this unit category
   **/
  @ApiModelProperty(value = "Value multiplied to convert to default unit in this unit category")
  public Float getMultiply() {
    return multiply;
  }
  public void setMultiply(Float multiply) {
    this.multiply = multiply;
  }

  
  /**
   * Value which should be added to convert to default unit
   **/
  @ApiModelProperty(value = "Value which should be added to convert to default unit")
  public Float getAdd() {
    return add;
  }
  public void setAdd(Float add) {
    this.add = add;
  }

  
  /**
   * When the record was first created. Use ISO 8601 datetime format
   **/
  @ApiModelProperty(value = "When the record was first created. Use ISO 8601 datetime format")
  public Date getCreatedAt() {
    return createdAt;
  }
  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  
  /**
   * When the record in the database was last updated. Use ISO 8601 datetime format
   **/
  @ApiModelProperty(value = "When the record in the database was last updated. Use ISO 8601 datetime format")
  public Date getUpdatedAt() {
    return updatedAt;
  }
  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Unit {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  clientId: ").append(clientId).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  abbreviatedName: ").append(abbreviatedName).append("\n");
    sb.append("  unitCategoryId: ").append(unitCategoryId).append("\n");
    sb.append("  minimumValue: ").append(minimumValue).append("\n");
    sb.append("  maximumValue: ").append(maximumValue).append("\n");
    sb.append("  updated: ").append(updated).append("\n");
    sb.append("  defaultUnitId: ").append(defaultUnitId).append("\n");
    sb.append("  multiply: ").append(multiply).append("\n");
    sb.append("  add: ").append(add).append("\n");
    sb.append("  createdAt: ").append(createdAt).append("\n");
    sb.append("  updatedAt: ").append(updatedAt).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
