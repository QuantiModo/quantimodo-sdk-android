# RemindersApi

All URIs are relative to *https://app.quantimo.do/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**v1TrackingReminderNotificationsGet**](RemindersApi.md#v1TrackingReminderNotificationsGet) | **GET** /v1/trackingReminderNotifications | Get specific pending tracking reminders
[**v1TrackingReminderNotificationsSkipPost**](RemindersApi.md#v1TrackingReminderNotificationsSkipPost) | **POST** /v1/trackingReminderNotifications/skip | Skip a pending tracking reminder
[**v1TrackingReminderNotificationsSnoozePost**](RemindersApi.md#v1TrackingReminderNotificationsSnoozePost) | **POST** /v1/trackingReminderNotifications/snooze | Snooze a pending tracking reminder
[**v1TrackingReminderNotificationsTrackPost**](RemindersApi.md#v1TrackingReminderNotificationsTrackPost) | **POST** /v1/trackingReminderNotifications/track | Track a pending tracking reminder
[**v1TrackingRemindersDeletePost**](RemindersApi.md#v1TrackingRemindersDeletePost) | **POST** /v1/trackingReminders/delete | Delete tracking reminder
[**v1TrackingRemindersGet**](RemindersApi.md#v1TrackingRemindersGet) | **GET** /v1/trackingReminders | Get repeating tracking reminder settings
[**v1TrackingRemindersPost**](RemindersApi.md#v1TrackingRemindersPost) | **POST** /v1/trackingReminders | Store a Tracking Reminder


<a name="v1TrackingReminderNotificationsGet"></a>
# **v1TrackingReminderNotificationsGet**
> InlineResponse2002 v1TrackingReminderNotificationsGet(accessToken, userId, variableCategoryName, createdAt, updatedAt, limit, offset, sort)

Get specific pending tracking reminders

Specfic pending reminder instances that still need to be tracked.  

### Example
```java
// Import classes:
//import io.swagger.client.api.RemindersApi;

RemindersApi apiInstance = new RemindersApi();
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
Integer userId = 56; // Integer | User's id
String variableCategoryName = "variableCategoryName_example"; // String | Limit tracking reminder notifications to a specific variable category
String createdAt = "createdAt_example"; // String | When the record was first created. Use UTC ISO 8601 \"YYYY-MM-DDThh:mm:ss\"  datetime format. Time zone should be UTC and not local.
String updatedAt = "updatedAt_example"; // String | When the record was last updated. Use UTC ISO 8601 \"YYYY-MM-DDThh:mm:ss\"  datetime format. Time zone should be UTC and not local.
Integer limit = 56; // Integer | The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records.
Integer offset = 56; // Integer | OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned.
String sort = "sort_example"; // String | Sort by given field. If the field is prefixed with '-', it will sort in descending order.
try {
    InlineResponse2002 result = apiInstance.v1TrackingReminderNotificationsGet(accessToken, userId, variableCategoryName, createdAt, updatedAt, limit, offset, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RemindersApi#v1TrackingReminderNotificationsGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]
 **userId** | **Integer**| User&#39;s id | [optional]
 **variableCategoryName** | **String**| Limit tracking reminder notifications to a specific variable category | [optional]
 **createdAt** | **String**| When the record was first created. Use UTC ISO 8601 \&quot;YYYY-MM-DDThh:mm:ss\&quot;  datetime format. Time zone should be UTC and not local. | [optional]
 **updatedAt** | **String**| When the record was last updated. Use UTC ISO 8601 \&quot;YYYY-MM-DDThh:mm:ss\&quot;  datetime format. Time zone should be UTC and not local. | [optional]
 **limit** | **Integer**| The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records. | [optional]
 **offset** | **Integer**| OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned. | [optional]
 **sort** | **String**| Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order. | [optional]

### Return type

[**InlineResponse2002**](InlineResponse2002.md)

### Authorization

[access_token](../README.md#access_token), [quantimodo_oauth2](../README.md#quantimodo_oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1TrackingReminderNotificationsSkipPost"></a>
# **v1TrackingReminderNotificationsSkipPost**
> CommonResponse v1TrackingReminderNotificationsSkipPost(body, accessToken, userId)

Skip a pending tracking reminder

Deletes the pending tracking reminder

### Example
```java
// Import classes:
//import io.swagger.client.api.RemindersApi;

RemindersApi apiInstance = new RemindersApi();
TrackingReminderNotificationSkip body = new TrackingReminderNotificationSkip(); // TrackingReminderNotificationSkip | Id of the pending reminder to be skipped or deleted
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
Integer userId = 56; // Integer | User's id
try {
    CommonResponse result = apiInstance.v1TrackingReminderNotificationsSkipPost(body, accessToken, userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RemindersApi#v1TrackingReminderNotificationsSkipPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**TrackingReminderNotificationSkip**](TrackingReminderNotificationSkip.md)| Id of the pending reminder to be skipped or deleted |
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]
 **userId** | **Integer**| User&#39;s id | [optional]

### Return type

[**CommonResponse**](CommonResponse.md)

### Authorization

[access_token](../README.md#access_token), [quantimodo_oauth2](../README.md#quantimodo_oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1TrackingReminderNotificationsSnoozePost"></a>
# **v1TrackingReminderNotificationsSnoozePost**
> CommonResponse v1TrackingReminderNotificationsSnoozePost(body, accessToken, userId)

Snooze a pending tracking reminder

Changes the reminder time to now plus one hour

### Example
```java
// Import classes:
//import io.swagger.client.api.RemindersApi;

RemindersApi apiInstance = new RemindersApi();
TrackingReminderNotificationSnooze body = new TrackingReminderNotificationSnooze(); // TrackingReminderNotificationSnooze | Id of the pending reminder to be snoozed
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
Integer userId = 56; // Integer | User's id
try {
    CommonResponse result = apiInstance.v1TrackingReminderNotificationsSnoozePost(body, accessToken, userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RemindersApi#v1TrackingReminderNotificationsSnoozePost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**TrackingReminderNotificationSnooze**](TrackingReminderNotificationSnooze.md)| Id of the pending reminder to be snoozed |
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]
 **userId** | **Integer**| User&#39;s id | [optional]

### Return type

[**CommonResponse**](CommonResponse.md)

### Authorization

[access_token](../README.md#access_token), [quantimodo_oauth2](../README.md#quantimodo_oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1TrackingReminderNotificationsTrackPost"></a>
# **v1TrackingReminderNotificationsTrackPost**
> CommonResponse v1TrackingReminderNotificationsTrackPost(body, accessToken, userId)

Track a pending tracking reminder

Adds the default measurement for the pending tracking reminder with the reminder time as the measurment start time

### Example
```java
// Import classes:
//import io.swagger.client.api.RemindersApi;

RemindersApi apiInstance = new RemindersApi();
TrackingReminderNotificationTrack body = new TrackingReminderNotificationTrack(); // TrackingReminderNotificationTrack | Id of the pending reminder to be tracked
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
Integer userId = 56; // Integer | User's id
try {
    CommonResponse result = apiInstance.v1TrackingReminderNotificationsTrackPost(body, accessToken, userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RemindersApi#v1TrackingReminderNotificationsTrackPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**TrackingReminderNotificationTrack**](TrackingReminderNotificationTrack.md)| Id of the pending reminder to be tracked |
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]
 **userId** | **Integer**| User&#39;s id | [optional]

### Return type

[**CommonResponse**](CommonResponse.md)

### Authorization

[access_token](../README.md#access_token), [quantimodo_oauth2](../README.md#quantimodo_oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1TrackingRemindersDeletePost"></a>
# **v1TrackingRemindersDeletePost**
> CommonResponse v1TrackingRemindersDeletePost(body, accessToken, userId)

Delete tracking reminder

Delete previously created tracking reminder

### Example
```java
// Import classes:
//import io.swagger.client.api.RemindersApi;

RemindersApi apiInstance = new RemindersApi();
TrackingReminderDelete body = new TrackingReminderDelete(); // TrackingReminderDelete | Id of reminder to be deleted
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
Integer userId = 56; // Integer | User's id
try {
    CommonResponse result = apiInstance.v1TrackingRemindersDeletePost(body, accessToken, userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RemindersApi#v1TrackingRemindersDeletePost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**TrackingReminderDelete**](TrackingReminderDelete.md)| Id of reminder to be deleted |
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]
 **userId** | **Integer**| User&#39;s id | [optional]

### Return type

[**CommonResponse**](CommonResponse.md)

### Authorization

[access_token](../README.md#access_token), [quantimodo_oauth2](../README.md#quantimodo_oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1TrackingRemindersGet"></a>
# **v1TrackingRemindersGet**
> InlineResponse200 v1TrackingRemindersGet(accessToken, userId, variableCategoryName, createdAt, updatedAt, limit, offset, sort)

Get repeating tracking reminder settings

Users can be reminded to track certain variables at a specified frequency with a default value.

### Example
```java
// Import classes:
//import io.swagger.client.api.RemindersApi;

RemindersApi apiInstance = new RemindersApi();
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
Integer userId = 56; // Integer | User's id
String variableCategoryName = "variableCategoryName_example"; // String | Limit tracking reminders to a specific variable category
String createdAt = "createdAt_example"; // String | When the record was first created. Use UTC ISO 8601 \"YYYY-MM-DDThh:mm:ss\"  datetime format. Time zone should be UTC and not local.
String updatedAt = "updatedAt_example"; // String | When the record was last updated. Use UTC ISO 8601 \"YYYY-MM-DDThh:mm:ss\"  datetime format. Time zone should be UTC and not local.
Integer limit = 56; // Integer | The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records.
Integer offset = 56; // Integer | OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned.
String sort = "sort_example"; // String | Sort by given field. If the field is prefixed with '-', it will sort in descending order.
try {
    InlineResponse200 result = apiInstance.v1TrackingRemindersGet(accessToken, userId, variableCategoryName, createdAt, updatedAt, limit, offset, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RemindersApi#v1TrackingRemindersGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]
 **userId** | **Integer**| User&#39;s id | [optional]
 **variableCategoryName** | **String**| Limit tracking reminders to a specific variable category | [optional]
 **createdAt** | **String**| When the record was first created. Use UTC ISO 8601 \&quot;YYYY-MM-DDThh:mm:ss\&quot;  datetime format. Time zone should be UTC and not local. | [optional]
 **updatedAt** | **String**| When the record was last updated. Use UTC ISO 8601 \&quot;YYYY-MM-DDThh:mm:ss\&quot;  datetime format. Time zone should be UTC and not local. | [optional]
 **limit** | **Integer**| The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records. | [optional]
 **offset** | **Integer**| OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned. | [optional]
 **sort** | **String**| Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order. | [optional]

### Return type

[**InlineResponse200**](InlineResponse200.md)

### Authorization

[access_token](../README.md#access_token), [quantimodo_oauth2](../README.md#quantimodo_oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1TrackingRemindersPost"></a>
# **v1TrackingRemindersPost**
> InlineResponse2001 v1TrackingRemindersPost(accessToken, userId, body)

Store a Tracking Reminder

This is to enable users to create reminders to track a variable with a default value at a specified frequency

### Example
```java
// Import classes:
//import io.swagger.client.api.RemindersApi;

RemindersApi apiInstance = new RemindersApi();
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
Integer userId = 56; // Integer | User's id
TrackingReminder body = new TrackingReminder(); // TrackingReminder | TrackingReminder that should be stored
try {
    InlineResponse2001 result = apiInstance.v1TrackingRemindersPost(accessToken, userId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RemindersApi#v1TrackingRemindersPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]
 **userId** | **Integer**| User&#39;s id | [optional]
 **body** | [**TrackingReminder**](TrackingReminder.md)| TrackingReminder that should be stored | [optional]

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

[access_token](../README.md#access_token), [quantimodo_oauth2](../README.md#quantimodo_oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

