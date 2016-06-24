
# TrackingReminderNotification

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **Integer** | id for the specific PENDING tracking remidner | 
**trackingReminderId** | **Integer** | id for the repeating tracking remidner | 
**clientId** | **String** | clientId |  [optional]
**userId** | **Integer** | ID of User |  [optional]
**variableId** | **Integer** | Id for the variable to be tracked |  [optional]
**pendingReminderTime** | [**Date**](Date.md) | ISO 8601 timestamp for the specific time the variable should be tracked in UTC.  This will be used for the measurement startTime if the track endpoint is used. |  [optional]
**defaultValue** | **Float** | Default value to use for the measurement when tracking |  [optional]
**reminderSound** | **String** | String identifier for the sound to accompany the reminder |  [optional]
**popUp** | **Boolean** | True if the reminders should appear as a popup notification |  [optional]
**sms** | **Boolean** | True if the reminders should be delivered via SMS |  [optional]
**email** | **Boolean** | True if the reminders should be delivered via email |  [optional]
**notificationBar** | **Boolean** | True if the reminders should appear in the notification bar |  [optional]
**updatedAt** | [**Date**](Date.md) | When the record in the database was last updated. Use ISO 8601 datetime format. Time zone should be UTC and not local. |  [optional]
**variableName** | **String** | Name of the variable to be used when sending measurements |  [optional]
**variableCategoryName** | **String** | Name of the variable category to be used when sending measurements |  [optional]
**abbreviatedUnitName** | **String** | Abbreviated name of the unit to be used when sending measurements |  [optional]
**combinationOperation** | [**CombinationOperationEnum**](#CombinationOperationEnum) | The way multiple measurements are aggregated over time |  [optional]


<a name="CombinationOperationEnum"></a>
## Enum: CombinationOperationEnum
Name | Value
---- | -----



