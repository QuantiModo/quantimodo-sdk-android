
# TrackingReminder

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **Integer** | id |  [optional]
**clientId** | **String** | clientId |  [optional]
**userId** | **Integer** | ID of User |  [optional]
**variableId** | **Integer** | Id for the variable to be tracked | 
**defaultValue** | **Float** | Default value to use for the measurement when tracking |  [optional]
**reminderStartTime** | **String** | Earliest time of day at which reminders should appear in UTC HH:MM:SS format |  [optional]
**reminderEndTime** | **String** | Latest time of day at which reminders should appear in UTC HH:MM:SS format |  [optional]
**reminderSound** | **String** | String identifier for the sound to accompany the reminder |  [optional]
**reminderFrequency** | **Integer** | Number of seconds between one reminder and the next |  [optional]
**popUp** | **Boolean** | True if the reminders should appear as a popup notification |  [optional]
**sms** | **Boolean** | True if the reminders should be delivered via SMS |  [optional]
**email** | **Boolean** | True if the reminders should be delivered via email |  [optional]
**notificationBar** | **Boolean** | True if the reminders should appear in the notification bar |  [optional]
**lastReminded** | [**Date**](Date.md) | ISO 8601 timestamp for the last time a reminder was sent |  [optional]
**lastTracked** | [**Date**](Date.md) | ISO 8601 timestamp for the last time a measurement was received for this user and variable |  [optional]
**firstDailyReminderTime** | **String** | Specific first time of day that the user should be reminded to track in UTC HH:MM:SS format |  [optional]
**secondDailyReminderTime** | **String** | Specific second time of day that the user should be reminded to track in UTC HH:MM:SS format |  [optional]
**thirdDailyReminderTime** | **String** | Specific third time of day that the user should be reminded to track in UTC HH:MM:SS format |  [optional]
**startTrackingDate** | **String** | Earliest date on which the user should be reminded to track in YYYY-MM-DD format |  [optional]
**stopTrackingDate** | **String** | Latest date on which the user should be reminded to track in YYYY-MM-DD format |  [optional]
**updatedAt** | [**Date**](Date.md) | When the record in the database was last updated. Use ISO 8601 datetime format. Time zone should be UTC and not local. |  [optional]
**variableName** | **String** | Name of the variable to be used when sending measurements |  [optional]
**variableCategoryName** | **String** | Name of the variable category to be used when sending measurements |  [optional]
**abbreviatedUnitName** | **String** | Abbreviated name of the unit to be used when sending measurements |  [optional]
**combinationOperation** | [**CombinationOperationEnum**](#CombinationOperationEnum) | The way multiple measurements are aggregated over time |  [optional]


<a name="CombinationOperationEnum"></a>
## Enum: CombinationOperationEnum
Name | Value
---- | -----



