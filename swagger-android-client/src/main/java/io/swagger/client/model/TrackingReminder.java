package io.swagger.client.model;

import java.util.Date;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class TrackingReminder  {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("client_id")
  private String clientId = null;
  @SerializedName("user_id")
  private Integer userId = null;
  @SerializedName("variable_id")
  private Integer variableId = null;
  @SerializedName("default_value")
  private Float defaultValue = null;
  @SerializedName("reminder_start_time")
  private String reminderStartTime = null;
  @SerializedName("reminder_end_time")
  private String reminderEndTime = null;
  @SerializedName("reminder_sound")
  private String reminderSound = null;
  @SerializedName("reminder_frequency")
  private Integer reminderFrequency = null;
  @SerializedName("pop_up")
  private Boolean popUp = null;
  @SerializedName("sms")
  private Boolean sms = null;
  @SerializedName("email")
  private Boolean email = null;
  @SerializedName("notification_bar")
  private Boolean notificationBar = null;
  @SerializedName("last_reminded")
  private Date lastReminded = null;
  @SerializedName("last_tracked")
  private Date lastTracked = null;
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
   * ID of User
   **/
  @ApiModelProperty(value = "ID of User")
  public Integer getUserId() {
    return userId;
  }
  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  
  /**
   * Id for the variable to be tracked
   **/
  @ApiModelProperty(required = true, value = "Id for the variable to be tracked")
  public Integer getVariableId() {
    return variableId;
  }
  public void setVariableId(Integer variableId) {
    this.variableId = variableId;
  }

  
  /**
   * Default value to use for the measurement when tracking
   **/
  @ApiModelProperty(value = "Default value to use for the measurement when tracking")
  public Float getDefaultValue() {
    return defaultValue;
  }
  public void setDefaultValue(Float defaultValue) {
    this.defaultValue = defaultValue;
  }

  
  /**
   * Earliest time of day at which reminders should appear
   **/
  @ApiModelProperty(value = "Earliest time of day at which reminders should appear")
  public String getReminderStartTime() {
    return reminderStartTime;
  }
  public void setReminderStartTime(String reminderStartTime) {
    this.reminderStartTime = reminderStartTime;
  }

  
  /**
   * Latest time of day at which reminders should appear
   **/
  @ApiModelProperty(value = "Latest time of day at which reminders should appear")
  public String getReminderEndTime() {
    return reminderEndTime;
  }
  public void setReminderEndTime(String reminderEndTime) {
    this.reminderEndTime = reminderEndTime;
  }

  
  /**
   * String identifier for the sound to accompany the reminder
   **/
  @ApiModelProperty(value = "String identifier for the sound to accompany the reminder")
  public String getReminderSound() {
    return reminderSound;
  }
  public void setReminderSound(String reminderSound) {
    this.reminderSound = reminderSound;
  }

  
  /**
   * Number of seconds between one reminder and the next
   **/
  @ApiModelProperty(value = "Number of seconds between one reminder and the next")
  public Integer getReminderFrequency() {
    return reminderFrequency;
  }
  public void setReminderFrequency(Integer reminderFrequency) {
    this.reminderFrequency = reminderFrequency;
  }

  
  /**
   * True if the reminders should appear as a popup notification
   **/
  @ApiModelProperty(value = "True if the reminders should appear as a popup notification")
  public Boolean getPopUp() {
    return popUp;
  }
  public void setPopUp(Boolean popUp) {
    this.popUp = popUp;
  }

  
  /**
   * True if the reminders should be delivered via SMS
   **/
  @ApiModelProperty(value = "True if the reminders should be delivered via SMS")
  public Boolean getSms() {
    return sms;
  }
  public void setSms(Boolean sms) {
    this.sms = sms;
  }

  
  /**
   * True if the reminders should be delivered via email
   **/
  @ApiModelProperty(value = "True if the reminders should be delivered via email")
  public Boolean getEmail() {
    return email;
  }
  public void setEmail(Boolean email) {
    this.email = email;
  }

  
  /**
   * True if the reminders should appear in the notification bar
   **/
  @ApiModelProperty(value = "True if the reminders should appear in the notification bar")
  public Boolean getNotificationBar() {
    return notificationBar;
  }
  public void setNotificationBar(Boolean notificationBar) {
    this.notificationBar = notificationBar;
  }

  
  /**
   * ISO 8601 timestamp for the last time a reminder was sent
   **/
  @ApiModelProperty(value = "ISO 8601 timestamp for the last time a reminder was sent")
  public Date getLastReminded() {
    return lastReminded;
  }
  public void setLastReminded(Date lastReminded) {
    this.lastReminded = lastReminded;
  }

  
  /**
   * ISO 8601 timestamp for the last time a measurement was received for this user and variable
   **/
  @ApiModelProperty(value = "ISO 8601 timestamp for the last time a measurement was received for this user and variable")
  public Date getLastTracked() {
    return lastTracked;
  }
  public void setLastTracked(Date lastTracked) {
    this.lastTracked = lastTracked;
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
    sb.append("class TrackingReminder {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  clientId: ").append(clientId).append("\n");
    sb.append("  userId: ").append(userId).append("\n");
    sb.append("  variableId: ").append(variableId).append("\n");
    sb.append("  defaultValue: ").append(defaultValue).append("\n");
    sb.append("  reminderStartTime: ").append(reminderStartTime).append("\n");
    sb.append("  reminderEndTime: ").append(reminderEndTime).append("\n");
    sb.append("  reminderSound: ").append(reminderSound).append("\n");
    sb.append("  reminderFrequency: ").append(reminderFrequency).append("\n");
    sb.append("  popUp: ").append(popUp).append("\n");
    sb.append("  sms: ").append(sms).append("\n");
    sb.append("  email: ").append(email).append("\n");
    sb.append("  notificationBar: ").append(notificationBar).append("\n");
    sb.append("  lastReminded: ").append(lastReminded).append("\n");
    sb.append("  lastTracked: ").append(lastTracked).append("\n");
    sb.append("  createdAt: ").append(createdAt).append("\n");
    sb.append("  updatedAt: ").append(updatedAt).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
