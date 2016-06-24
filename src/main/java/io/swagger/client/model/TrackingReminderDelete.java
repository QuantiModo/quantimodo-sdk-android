package io.swagger.client.model;


import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class TrackingReminderDelete  {
  
  @SerializedName("id")
  private Integer id = null;

  /**
   * Id of the PENDING reminder to be deleted
   **/
  @ApiModelProperty(required = true, value = "Id of the PENDING reminder to be deleted")
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TrackingReminderDelete trackingReminderDelete = (TrackingReminderDelete) o;
    return (id == null ? trackingReminderDelete.id == null : id.equals(trackingReminderDelete.id));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (id == null ? 0: id.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class TrackingReminderDelete {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
