# ApplicationEndpointsApi

All URIs are relative to *https://app.quantimo.do/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**v2ApplicationConnectionsGet**](ApplicationEndpointsApi.md#v2ApplicationConnectionsGet) | **GET** /v2/application/connections | Get all Connections
[**v2ApplicationCredentialsGet**](ApplicationEndpointsApi.md#v2ApplicationCredentialsGet) | **GET** /v2/application/credentials | Get all Credentials
[**v2ApplicationMeasurementsGet**](ApplicationEndpointsApi.md#v2ApplicationMeasurementsGet) | **GET** /v2/application/measurements | Get measurements for all users using your application
[**v2ApplicationTrackingRemindersGet**](ApplicationEndpointsApi.md#v2ApplicationTrackingRemindersGet) | **GET** /v2/application/trackingReminders | Get tracking reminders
[**v2ApplicationUpdatesGet**](ApplicationEndpointsApi.md#v2ApplicationUpdatesGet) | **GET** /v2/application/updates | Get all Updates
[**v2ApplicationUserVariableRelationshipsGet**](ApplicationEndpointsApi.md#v2ApplicationUserVariableRelationshipsGet) | **GET** /v2/application/userVariableRelationships | Get all UserVariableRelationships
[**v2ApplicationUserVariablesGet**](ApplicationEndpointsApi.md#v2ApplicationUserVariablesGet) | **GET** /v2/application/userVariables | Get all UserVariables
[**v2ApplicationVariableUserSourcesGet**](ApplicationEndpointsApi.md#v2ApplicationVariableUserSourcesGet) | **GET** /v2/application/variableUserSources | Get all VariableUserSources
[**v2ApplicationVotesGet**](ApplicationEndpointsApi.md#v2ApplicationVotesGet) | **GET** /v2/application/votes | Get all Votes


<a name="v2ApplicationConnectionsGet"></a>
# **v2ApplicationConnectionsGet**
> InlineResponse2003 v2ApplicationConnectionsGet(accessToken, connectorId, connectStatus, connectError, updateRequestedAt, updateStatus, updateError, lastSuccessfulUpdatedAt, createdAt, updatedAt, limit, offset, sort)

Get all Connections

Get all Connections

### Example
```java
// Import classes:
//import io.swagger.client.api.ApplicationEndpointsApi;

ApplicationEndpointsApi apiInstance = new ApplicationEndpointsApi();
String accessToken = "accessToken_example"; // String | Application's OAuth2 access token
Integer connectorId = 56; // Integer | The id for the connector data source for which the connection is connected
String connectStatus = "connectStatus_example"; // String | Indicates whether a connector is currently connected to a service for a user.
String connectError = "connectError_example"; // String | Error message if there is a problem with authorizing this connection.
String updateRequestedAt = "updateRequestedAt_example"; // String | Time at which an update was requested by a user.
String updateStatus = "updateStatus_example"; // String | Indicates whether a connector is currently updated.
String updateError = "updateError_example"; // String | Indicates if there was an error during the update.
String lastSuccessfulUpdatedAt = "lastSuccessfulUpdatedAt_example"; // String | The time at which the connector was last successfully updated.
String createdAt = "createdAt_example"; // String | When the record was first created. Use ISO 8601 datetime format 
String updatedAt = "updatedAt_example"; // String | When the record was last updated. Use ISO 8601 datetime format 
Integer limit = 56; // Integer | The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records.
Integer offset = 56; // Integer | OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned.
String sort = "sort_example"; // String | Sort by given field. If the field is prefixed with '-', it will sort in descending order.
try {
    InlineResponse2003 result = apiInstance.v2ApplicationConnectionsGet(accessToken, connectorId, connectStatus, connectError, updateRequestedAt, updateStatus, updateError, lastSuccessfulUpdatedAt, createdAt, updatedAt, limit, offset, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ApplicationEndpointsApi#v2ApplicationConnectionsGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accessToken** | **String**| Application&#39;s OAuth2 access token | [optional]
 **connectorId** | **Integer**| The id for the connector data source for which the connection is connected | [optional]
 **connectStatus** | **String**| Indicates whether a connector is currently connected to a service for a user. | [optional]
 **connectError** | **String**| Error message if there is a problem with authorizing this connection. | [optional]
 **updateRequestedAt** | **String**| Time at which an update was requested by a user. | [optional]
 **updateStatus** | **String**| Indicates whether a connector is currently updated. | [optional]
 **updateError** | **String**| Indicates if there was an error during the update. | [optional]
 **lastSuccessfulUpdatedAt** | **String**| The time at which the connector was last successfully updated. | [optional]
 **createdAt** | **String**| When the record was first created. Use ISO 8601 datetime format  | [optional]
 **updatedAt** | **String**| When the record was last updated. Use ISO 8601 datetime format  | [optional]
 **limit** | **Integer**| The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records. | [optional]
 **offset** | **Integer**| OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned. | [optional]
 **sort** | **String**| Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order. | [optional]

### Return type

[**InlineResponse2003**](InlineResponse2003.md)

### Authorization

[oauth2](../README.md#oauth2), [internalApiKey](../README.md#internalApiKey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v2ApplicationCredentialsGet"></a>
# **v2ApplicationCredentialsGet**
> InlineResponse2004 v2ApplicationCredentialsGet(accessToken, connectorId, attrKey, attrValue, createdAt, updatedAt, limit, offset, sort)

Get all Credentials

Get all Credentials

### Example
```java
// Import classes:
//import io.swagger.client.api.ApplicationEndpointsApi;

ApplicationEndpointsApi apiInstance = new ApplicationEndpointsApi();
String accessToken = "accessToken_example"; // String | Application's OAuth2 access token
Integer connectorId = 56; // Integer | The id for the connector data source from which the credential was obtained
String attrKey = "attrKey_example"; // String | Attribute name such as token, userid, username, or password
String attrValue = "attrValue_example"; // String | Encrypted value for the attribute specified
String createdAt = "createdAt_example"; // String | When the record was first created. Use ISO 8601 datetime format 
String updatedAt = "updatedAt_example"; // String | When the record was last updated. Use ISO 8601 datetime format 
Integer limit = 56; // Integer | The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records.
Integer offset = 56; // Integer | OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned.
String sort = "sort_example"; // String | Sort by given field. If the field is prefixed with '-', it will sort in descending order.
try {
    InlineResponse2004 result = apiInstance.v2ApplicationCredentialsGet(accessToken, connectorId, attrKey, attrValue, createdAt, updatedAt, limit, offset, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ApplicationEndpointsApi#v2ApplicationCredentialsGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accessToken** | **String**| Application&#39;s OAuth2 access token | [optional]
 **connectorId** | **Integer**| The id for the connector data source from which the credential was obtained | [optional]
 **attrKey** | **String**| Attribute name such as token, userid, username, or password | [optional]
 **attrValue** | **String**| Encrypted value for the attribute specified | [optional]
 **createdAt** | **String**| When the record was first created. Use ISO 8601 datetime format  | [optional]
 **updatedAt** | **String**| When the record was last updated. Use ISO 8601 datetime format  | [optional]
 **limit** | **Integer**| The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records. | [optional]
 **offset** | **Integer**| OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned. | [optional]
 **sort** | **String**| Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order. | [optional]

### Return type

[**InlineResponse2004**](InlineResponse2004.md)

### Authorization

[oauth2](../README.md#oauth2), [internalApiKey](../README.md#internalApiKey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v2ApplicationMeasurementsGet"></a>
# **v2ApplicationMeasurementsGet**
> InlineResponse2005 v2ApplicationMeasurementsGet(accessToken, clientId, connectorId, variableId, sourceId, startTime, value, unitId, originalValue, originalUnitId, duration, note, latitude, longitude, location, createdAt, updatedAt, error, limit, offset, sort)

Get measurements for all users using your application

Measurements are any value that can be recorded like daily steps, a mood rating, or apples eaten.

### Example
```java
// Import classes:
//import io.swagger.client.api.ApplicationEndpointsApi;

ApplicationEndpointsApi apiInstance = new ApplicationEndpointsApi();
String accessToken = "accessToken_example"; // String | Application's OAuth2 access token
String clientId = "clientId_example"; // String | The ID of the client application which originally stored the measurement
Integer connectorId = 56; // Integer | The id for the connector data source from which the measurement was obtained
Integer variableId = 56; // Integer | ID of the variable for which we are creating the measurement records
Integer sourceId = 56; // Integer | Application or device used to record the measurement values
String startTime = "startTime_example"; // String | start time for the measurement event. Use ISO 8601 datetime format 
BigDecimal value = new BigDecimal(); // BigDecimal | The value of the measurement after conversion to the default unit for that variable
Integer unitId = 56; // Integer | The default unit id for the variable
BigDecimal originalValue = new BigDecimal(); // BigDecimal | Unconverted value of measurement as originally posted (before conversion to default unit)
Integer originalUnitId = 56; // Integer | Unit id of the measurement as originally submitted
Integer duration = 56; // Integer | Duration of the event being measurement in seconds
String note = "note_example"; // String | An optional note the user may include with their measurement
BigDecimal latitude = new BigDecimal(); // BigDecimal | Latitude at which the measurement was taken
BigDecimal longitude = new BigDecimal(); // BigDecimal | Longitude at which the measurement was taken
String location = "location_example"; // String | Optional human readable name for the location where the measurement was recorded
String createdAt = "createdAt_example"; // String | When the record was first created. Use ISO 8601 datetime format 
String updatedAt = "updatedAt_example"; // String | When the record was last updated. Use ISO 8601 datetime format 
String error = "error_example"; // String | An error message if there is a problem with the measurement
Integer limit = 56; // Integer | The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records.
Integer offset = 56; // Integer | OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned.
String sort = "sort_example"; // String | Sort by given field. If the field is prefixed with '-', it will sort in descending order.
try {
    InlineResponse2005 result = apiInstance.v2ApplicationMeasurementsGet(accessToken, clientId, connectorId, variableId, sourceId, startTime, value, unitId, originalValue, originalUnitId, duration, note, latitude, longitude, location, createdAt, updatedAt, error, limit, offset, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ApplicationEndpointsApi#v2ApplicationMeasurementsGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accessToken** | **String**| Application&#39;s OAuth2 access token | [optional]
 **clientId** | **String**| The ID of the client application which originally stored the measurement | [optional]
 **connectorId** | **Integer**| The id for the connector data source from which the measurement was obtained | [optional]
 **variableId** | **Integer**| ID of the variable for which we are creating the measurement records | [optional]
 **sourceId** | **Integer**| Application or device used to record the measurement values | [optional]
 **startTime** | **String**| start time for the measurement event. Use ISO 8601 datetime format  | [optional]
 **value** | **BigDecimal**| The value of the measurement after conversion to the default unit for that variable | [optional]
 **unitId** | **Integer**| The default unit id for the variable | [optional]
 **originalValue** | **BigDecimal**| Unconverted value of measurement as originally posted (before conversion to default unit) | [optional]
 **originalUnitId** | **Integer**| Unit id of the measurement as originally submitted | [optional]
 **duration** | **Integer**| Duration of the event being measurement in seconds | [optional]
 **note** | **String**| An optional note the user may include with their measurement | [optional]
 **latitude** | **BigDecimal**| Latitude at which the measurement was taken | [optional]
 **longitude** | **BigDecimal**| Longitude at which the measurement was taken | [optional]
 **location** | **String**| Optional human readable name for the location where the measurement was recorded | [optional]
 **createdAt** | **String**| When the record was first created. Use ISO 8601 datetime format  | [optional]
 **updatedAt** | **String**| When the record was last updated. Use ISO 8601 datetime format  | [optional]
 **error** | **String**| An error message if there is a problem with the measurement | [optional]
 **limit** | **Integer**| The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records. | [optional]
 **offset** | **Integer**| OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned. | [optional]
 **sort** | **String**| Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order. | [optional]

### Return type

[**InlineResponse2005**](InlineResponse2005.md)

### Authorization

[oauth2](../README.md#oauth2), [internalApiKey](../README.md#internalApiKey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v2ApplicationTrackingRemindersGet"></a>
# **v2ApplicationTrackingRemindersGet**
> InlineResponse2001 v2ApplicationTrackingRemindersGet(accessToken, clientId, createdAt, updatedAt, limit, offset, sort)

Get tracking reminders

Get the variable id, frequency, and default value for the user tracking reminders 

### Example
```java
// Import classes:
//import io.swagger.client.api.ApplicationEndpointsApi;

ApplicationEndpointsApi apiInstance = new ApplicationEndpointsApi();
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
String clientId = "clientId_example"; // String | The ID of the client application which last created or updated this trackingReminder
String createdAt = "createdAt_example"; // String | When the record was first created. Use ISO 8601 datetime format 
String updatedAt = "updatedAt_example"; // String | When the record was last updated. Use ISO 8601 datetime format 
Integer limit = 56; // Integer | The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records.
Integer offset = 56; // Integer | OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned.
String sort = "sort_example"; // String | Sort by given field. If the field is prefixed with '-', it will sort in descending order.
try {
    InlineResponse2001 result = apiInstance.v2ApplicationTrackingRemindersGet(accessToken, clientId, createdAt, updatedAt, limit, offset, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ApplicationEndpointsApi#v2ApplicationTrackingRemindersGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]
 **clientId** | **String**| The ID of the client application which last created or updated this trackingReminder | [optional]
 **createdAt** | **String**| When the record was first created. Use ISO 8601 datetime format  | [optional]
 **updatedAt** | **String**| When the record was last updated. Use ISO 8601 datetime format  | [optional]
 **limit** | **Integer**| The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records. | [optional]
 **offset** | **Integer**| OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned. | [optional]
 **sort** | **String**| Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order. | [optional]

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

[oauth2](../README.md#oauth2), [internalApiKey](../README.md#internalApiKey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v2ApplicationUpdatesGet"></a>
# **v2ApplicationUpdatesGet**
> InlineResponse2006 v2ApplicationUpdatesGet(accessToken, connectorId, numberOfMeasurements, success, message, createdAt, updatedAt, limit, offset, sort)

Get all Updates

Get all Updates

### Example
```java
// Import classes:
//import io.swagger.client.api.ApplicationEndpointsApi;

ApplicationEndpointsApi apiInstance = new ApplicationEndpointsApi();
String accessToken = "accessToken_example"; // String | Application's OAuth2 access token
Integer connectorId = 56; // Integer | connector_id
Integer numberOfMeasurements = 56; // Integer | number_of_measurements
Boolean success = true; // Boolean | success
String message = "message_example"; // String | message
String createdAt = "createdAt_example"; // String | When the record was first created. Use ISO 8601 datetime format 
String updatedAt = "updatedAt_example"; // String | When the record was last updated. Use ISO 8601 datetime format 
Integer limit = 56; // Integer | The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records.
Integer offset = 56; // Integer | OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned.
String sort = "sort_example"; // String | Sort by given field. If the field is prefixed with '-', it will sort in descending order.
try {
    InlineResponse2006 result = apiInstance.v2ApplicationUpdatesGet(accessToken, connectorId, numberOfMeasurements, success, message, createdAt, updatedAt, limit, offset, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ApplicationEndpointsApi#v2ApplicationUpdatesGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accessToken** | **String**| Application&#39;s OAuth2 access token | [optional]
 **connectorId** | **Integer**| connector_id | [optional]
 **numberOfMeasurements** | **Integer**| number_of_measurements | [optional]
 **success** | **Boolean**| success | [optional]
 **message** | **String**| message | [optional]
 **createdAt** | **String**| When the record was first created. Use ISO 8601 datetime format  | [optional]
 **updatedAt** | **String**| When the record was last updated. Use ISO 8601 datetime format  | [optional]
 **limit** | **Integer**| The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records. | [optional]
 **offset** | **Integer**| OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned. | [optional]
 **sort** | **String**| Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order. | [optional]

### Return type

[**InlineResponse2006**](InlineResponse2006.md)

### Authorization

[oauth2](../README.md#oauth2), [internalApiKey](../README.md#internalApiKey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v2ApplicationUserVariableRelationshipsGet"></a>
# **v2ApplicationUserVariableRelationshipsGet**
> InlineResponse2007 v2ApplicationUserVariableRelationshipsGet(accessToken, id, confidenceLevel, confidenceScore, direction, durationOfAction, errorMessage, onsetDelay, outcomeVariableId, predictorVariableId, predictorUnitId, sinnRank, strengthLevel, strengthScore, vote, valuePredictingHighOutcome, valuePredictingLowOutcome, limit, offset, sort)

Get all UserVariableRelationships

Get all UserVariableRelationships

### Example
```java
// Import classes:
//import io.swagger.client.api.ApplicationEndpointsApi;

ApplicationEndpointsApi apiInstance = new ApplicationEndpointsApi();
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
Integer id = 56; // Integer | id
String confidenceLevel = "confidenceLevel_example"; // String | Our confidence that a consistent predictive relationship exists based on the amount of evidence, reproducibility, and other factors
BigDecimal confidenceScore = new BigDecimal(); // BigDecimal | A quantitative representation of our confidence that a consistent predictive relationship exists based on the amount of evidence, reproducibility, and other factors
String direction = "direction_example"; // String | Direction is positive if higher predictor values generally precede higher outcome values. Direction is negative if higher predictor values generally precede lower outcome values.
Integer durationOfAction = 56; // Integer | Estimated number of seconds following the onset delay in which a stimulus produces a perceivable effect
String errorMessage = "errorMessage_example"; // String | error_message
Integer onsetDelay = 56; // Integer | Estimated number of seconds that pass before a stimulus produces a perceivable effect
Integer outcomeVariableId = 56; // Integer | Variable ID for the outcome variable
Integer predictorVariableId = 56; // Integer | Variable ID for the predictor variable
Integer predictorUnitId = 56; // Integer | ID for default unit of the predictor variable
BigDecimal sinnRank = new BigDecimal(); // BigDecimal | A value representative of the relevance of this predictor relative to other predictors of this outcome.  Usually used for relevancy sorting.
String strengthLevel = "strengthLevel_example"; // String | Can be weak, medium, or strong based on the size of the effect which the predictor appears to have on the outcome relative to other variable relationship strength scores.
BigDecimal strengthScore = new BigDecimal(); // BigDecimal | A value represented to the size of the effect which the predictor appears to have on the outcome.
String vote = "vote_example"; // String | vote
BigDecimal valuePredictingHighOutcome = new BigDecimal(); // BigDecimal | Value for the predictor variable (in it's default unit) which typically precedes an above average outcome value
BigDecimal valuePredictingLowOutcome = new BigDecimal(); // BigDecimal | Value for the predictor variable (in it's default unit) which typically precedes a below average outcome value
Integer limit = 56; // Integer | The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records.
Integer offset = 56; // Integer | OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned.
String sort = "sort_example"; // String | Sort by given field. If the field is prefixed with '-', it will sort in descending order.
try {
    InlineResponse2007 result = apiInstance.v2ApplicationUserVariableRelationshipsGet(accessToken, id, confidenceLevel, confidenceScore, direction, durationOfAction, errorMessage, onsetDelay, outcomeVariableId, predictorVariableId, predictorUnitId, sinnRank, strengthLevel, strengthScore, vote, valuePredictingHighOutcome, valuePredictingLowOutcome, limit, offset, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ApplicationEndpointsApi#v2ApplicationUserVariableRelationshipsGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]
 **id** | **Integer**| id | [optional]
 **confidenceLevel** | **String**| Our confidence that a consistent predictive relationship exists based on the amount of evidence, reproducibility, and other factors | [optional]
 **confidenceScore** | **BigDecimal**| A quantitative representation of our confidence that a consistent predictive relationship exists based on the amount of evidence, reproducibility, and other factors | [optional]
 **direction** | **String**| Direction is positive if higher predictor values generally precede higher outcome values. Direction is negative if higher predictor values generally precede lower outcome values. | [optional]
 **durationOfAction** | **Integer**| Estimated number of seconds following the onset delay in which a stimulus produces a perceivable effect | [optional]
 **errorMessage** | **String**| error_message | [optional]
 **onsetDelay** | **Integer**| Estimated number of seconds that pass before a stimulus produces a perceivable effect | [optional]
 **outcomeVariableId** | **Integer**| Variable ID for the outcome variable | [optional]
 **predictorVariableId** | **Integer**| Variable ID for the predictor variable | [optional]
 **predictorUnitId** | **Integer**| ID for default unit of the predictor variable | [optional]
 **sinnRank** | **BigDecimal**| A value representative of the relevance of this predictor relative to other predictors of this outcome.  Usually used for relevancy sorting. | [optional]
 **strengthLevel** | **String**| Can be weak, medium, or strong based on the size of the effect which the predictor appears to have on the outcome relative to other variable relationship strength scores. | [optional]
 **strengthScore** | **BigDecimal**| A value represented to the size of the effect which the predictor appears to have on the outcome. | [optional]
 **vote** | **String**| vote | [optional]
 **valuePredictingHighOutcome** | **BigDecimal**| Value for the predictor variable (in it&#39;s default unit) which typically precedes an above average outcome value | [optional]
 **valuePredictingLowOutcome** | **BigDecimal**| Value for the predictor variable (in it&#39;s default unit) which typically precedes a below average outcome value | [optional]
 **limit** | **Integer**| The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records. | [optional]
 **offset** | **Integer**| OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned. | [optional]
 **sort** | **String**| Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order. | [optional]

### Return type

[**InlineResponse2007**](InlineResponse2007.md)

### Authorization

[oauth2](../README.md#oauth2), [internalApiKey](../README.md#internalApiKey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v2ApplicationUserVariablesGet"></a>
# **v2ApplicationUserVariablesGet**
> InlineResponse2008 v2ApplicationUserVariablesGet(accessToken, clientId, parentId, variableId, defaultUnitId, minimumAllowedValue, maximumAllowedValue, fillingValue, joinWith, onsetDelay, durationOfAction, variableCategoryId, updated, _public, causeOnly, fillingType, numberOfMeasurements, numberOfProcessedMeasurements, measurementsAtLastAnalysis, lastUnitId, lastOriginalUnitId, lastOriginalValue, lastValue, lastSourceId, numberOfCorrelations, status, errorMessage, lastSuccessfulUpdateTime, standardDeviation, variance, minimumRecordedValue, maximumRecordedValue, mean, median, mostCommonUnitId, mostCommonValue, numberOfUniqueDailyValues, numberOfChanges, skewness, kurtosis, latitude, longitude, location, createdAt, updatedAt, outcome, sources, earliestSourceTime, latestSourceTime, earliestMeasurementTime, latestMeasurementTime, earliestFillingTime, latestFillingTime, limit, offset, sort)

Get all UserVariables

Get all UserVariables

### Example
```java
// Import classes:
//import io.swagger.client.api.ApplicationEndpointsApi;

ApplicationEndpointsApi apiInstance = new ApplicationEndpointsApi();
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
String clientId = "clientId_example"; // String | The ID of the client application which last created or updated this user variable
Integer parentId = 56; // Integer | ID of the parent variable if this variable has any parent
Integer variableId = 56; // Integer | ID of variable
Integer defaultUnitId = 56; // Integer | D of unit to use for this variable
BigDecimal minimumAllowedValue = new BigDecimal(); // BigDecimal | Minimum reasonable value for this variable (uses default unit)
BigDecimal maximumAllowedValue = new BigDecimal(); // BigDecimal | Maximum reasonable value for this variable (uses default unit)
BigDecimal fillingValue = new BigDecimal(); // BigDecimal | Value for replacing null measurements
Integer joinWith = 56; // Integer | The Variable this Variable should be joined with. If the variable is joined with some other variable then it is not shown to user in the list of variables
Integer onsetDelay = 56; // Integer | Estimated number of seconds that pass before a stimulus produces a perceivable effect
Integer durationOfAction = 56; // Integer | Estimated duration of time following the onset delay in which a stimulus produces a perceivable effect
Integer variableCategoryId = 56; // Integer | ID of variable category
Integer updated = 56; // Integer | updated
Integer _public = 56; // Integer | Is variable public
Boolean causeOnly = true; // Boolean | A value of 1 indicates that this variable is generally a cause in a causal relationship.  An example of a causeOnly variable would be a variable such as Cloud Cover which would generally not be influenced by the behaviour of the user
String fillingType = "fillingType_example"; // String | 0 -> No filling, 1 -> Use filling-value
Integer numberOfMeasurements = 56; // Integer | Number of measurements
Integer numberOfProcessedMeasurements = 56; // Integer | Number of processed measurements
Integer measurementsAtLastAnalysis = 56; // Integer | Number of measurements at last analysis
Integer lastUnitId = 56; // Integer | ID of last Unit
Integer lastOriginalUnitId = 56; // Integer | ID of last original Unit
Integer lastOriginalValue = 56; // Integer | Last original value which is stored
BigDecimal lastValue = new BigDecimal(); // BigDecimal | Last Value
Integer lastSourceId = 56; // Integer | ID of last source
Integer numberOfCorrelations = 56; // Integer | Number of correlations for this variable
String status = "status_example"; // String | status
String errorMessage = "errorMessage_example"; // String | error_message
String lastSuccessfulUpdateTime = "lastSuccessfulUpdateTime_example"; // String | When this variable or its settings were last updated
BigDecimal standardDeviation = new BigDecimal(); // BigDecimal | Standard deviation
BigDecimal variance = new BigDecimal(); // BigDecimal | Variance
BigDecimal minimumRecordedValue = new BigDecimal(); // BigDecimal | Minimum recorded value of this variable
BigDecimal maximumRecordedValue = new BigDecimal(); // BigDecimal | Maximum recorded value of this variable
BigDecimal mean = new BigDecimal(); // BigDecimal | Mean
BigDecimal median = new BigDecimal(); // BigDecimal | Median
Integer mostCommonUnitId = 56; // Integer | Most common Unit ID
BigDecimal mostCommonValue = new BigDecimal(); // BigDecimal | Most common value
BigDecimal numberOfUniqueDailyValues = new BigDecimal(); // BigDecimal | Number of unique daily values
Integer numberOfChanges = 56; // Integer | Number of changes
BigDecimal skewness = new BigDecimal(); // BigDecimal | Skewness
BigDecimal kurtosis = new BigDecimal(); // BigDecimal | Kurtosis
BigDecimal latitude = new BigDecimal(); // BigDecimal | Latitude
BigDecimal longitude = new BigDecimal(); // BigDecimal | Longitude
String location = "location_example"; // String | Location
String createdAt = "createdAt_example"; // String | When the record was first created. Use ISO 8601 datetime format 
String updatedAt = "updatedAt_example"; // String | When the record was last updated. Use ISO 8601 datetime format 
Boolean outcome = true; // Boolean | Outcome variables (those with `outcome` == 1) are variables for which a human would generally want to identify the influencing factors.  These include symptoms of illness, physique, mood, cognitive performance, etc.  Generally correlation calculations are only performed on outcome variables
String sources = "sources_example"; // String | Comma-separated list of source names to limit variables to those sources
Integer earliestSourceTime = 56; // Integer | Earliest source time
Integer latestSourceTime = 56; // Integer | Latest source time
Integer earliestMeasurementTime = 56; // Integer | Earliest measurement time
Integer latestMeasurementTime = 56; // Integer | Latest measurement time
Integer earliestFillingTime = 56; // Integer | Earliest filling time
Integer latestFillingTime = 56; // Integer | Latest filling time
Integer limit = 56; // Integer | The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records.
Integer offset = 56; // Integer | OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned.
String sort = "sort_example"; // String | Sort by given field. If the field is prefixed with '-', it will sort in descending order.
try {
    InlineResponse2008 result = apiInstance.v2ApplicationUserVariablesGet(accessToken, clientId, parentId, variableId, defaultUnitId, minimumAllowedValue, maximumAllowedValue, fillingValue, joinWith, onsetDelay, durationOfAction, variableCategoryId, updated, _public, causeOnly, fillingType, numberOfMeasurements, numberOfProcessedMeasurements, measurementsAtLastAnalysis, lastUnitId, lastOriginalUnitId, lastOriginalValue, lastValue, lastSourceId, numberOfCorrelations, status, errorMessage, lastSuccessfulUpdateTime, standardDeviation, variance, minimumRecordedValue, maximumRecordedValue, mean, median, mostCommonUnitId, mostCommonValue, numberOfUniqueDailyValues, numberOfChanges, skewness, kurtosis, latitude, longitude, location, createdAt, updatedAt, outcome, sources, earliestSourceTime, latestSourceTime, earliestMeasurementTime, latestMeasurementTime, earliestFillingTime, latestFillingTime, limit, offset, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ApplicationEndpointsApi#v2ApplicationUserVariablesGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]
 **clientId** | **String**| The ID of the client application which last created or updated this user variable | [optional]
 **parentId** | **Integer**| ID of the parent variable if this variable has any parent | [optional]
 **variableId** | **Integer**| ID of variable | [optional]
 **defaultUnitId** | **Integer**| D of unit to use for this variable | [optional]
 **minimumAllowedValue** | **BigDecimal**| Minimum reasonable value for this variable (uses default unit) | [optional]
 **maximumAllowedValue** | **BigDecimal**| Maximum reasonable value for this variable (uses default unit) | [optional]
 **fillingValue** | **BigDecimal**| Value for replacing null measurements | [optional]
 **joinWith** | **Integer**| The Variable this Variable should be joined with. If the variable is joined with some other variable then it is not shown to user in the list of variables | [optional]
 **onsetDelay** | **Integer**| Estimated number of seconds that pass before a stimulus produces a perceivable effect | [optional]
 **durationOfAction** | **Integer**| Estimated duration of time following the onset delay in which a stimulus produces a perceivable effect | [optional]
 **variableCategoryId** | **Integer**| ID of variable category | [optional]
 **updated** | **Integer**| updated | [optional]
 **_public** | **Integer**| Is variable public | [optional]
 **causeOnly** | **Boolean**| A value of 1 indicates that this variable is generally a cause in a causal relationship.  An example of a causeOnly variable would be a variable such as Cloud Cover which would generally not be influenced by the behaviour of the user | [optional]
 **fillingType** | **String**| 0 -&gt; No filling, 1 -&gt; Use filling-value | [optional]
 **numberOfMeasurements** | **Integer**| Number of measurements | [optional]
 **numberOfProcessedMeasurements** | **Integer**| Number of processed measurements | [optional]
 **measurementsAtLastAnalysis** | **Integer**| Number of measurements at last analysis | [optional]
 **lastUnitId** | **Integer**| ID of last Unit | [optional]
 **lastOriginalUnitId** | **Integer**| ID of last original Unit | [optional]
 **lastOriginalValue** | **Integer**| Last original value which is stored | [optional]
 **lastValue** | **BigDecimal**| Last Value | [optional]
 **lastSourceId** | **Integer**| ID of last source | [optional]
 **numberOfCorrelations** | **Integer**| Number of correlations for this variable | [optional]
 **status** | **String**| status | [optional]
 **errorMessage** | **String**| error_message | [optional]
 **lastSuccessfulUpdateTime** | **String**| When this variable or its settings were last updated | [optional]
 **standardDeviation** | **BigDecimal**| Standard deviation | [optional]
 **variance** | **BigDecimal**| Variance | [optional]
 **minimumRecordedValue** | **BigDecimal**| Minimum recorded value of this variable | [optional]
 **maximumRecordedValue** | **BigDecimal**| Maximum recorded value of this variable | [optional]
 **mean** | **BigDecimal**| Mean | [optional]
 **median** | **BigDecimal**| Median | [optional]
 **mostCommonUnitId** | **Integer**| Most common Unit ID | [optional]
 **mostCommonValue** | **BigDecimal**| Most common value | [optional]
 **numberOfUniqueDailyValues** | **BigDecimal**| Number of unique daily values | [optional]
 **numberOfChanges** | **Integer**| Number of changes | [optional]
 **skewness** | **BigDecimal**| Skewness | [optional]
 **kurtosis** | **BigDecimal**| Kurtosis | [optional]
 **latitude** | **BigDecimal**| Latitude | [optional]
 **longitude** | **BigDecimal**| Longitude | [optional]
 **location** | **String**| Location | [optional]
 **createdAt** | **String**| When the record was first created. Use ISO 8601 datetime format  | [optional]
 **updatedAt** | **String**| When the record was last updated. Use ISO 8601 datetime format  | [optional]
 **outcome** | **Boolean**| Outcome variables (those with &#x60;outcome&#x60; &#x3D;&#x3D; 1) are variables for which a human would generally want to identify the influencing factors.  These include symptoms of illness, physique, mood, cognitive performance, etc.  Generally correlation calculations are only performed on outcome variables | [optional]
 **sources** | **String**| Comma-separated list of source names to limit variables to those sources | [optional]
 **earliestSourceTime** | **Integer**| Earliest source time | [optional]
 **latestSourceTime** | **Integer**| Latest source time | [optional]
 **earliestMeasurementTime** | **Integer**| Earliest measurement time | [optional]
 **latestMeasurementTime** | **Integer**| Latest measurement time | [optional]
 **earliestFillingTime** | **Integer**| Earliest filling time | [optional]
 **latestFillingTime** | **Integer**| Latest filling time | [optional]
 **limit** | **Integer**| The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records. | [optional]
 **offset** | **Integer**| OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned. | [optional]
 **sort** | **String**| Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order. | [optional]

### Return type

[**InlineResponse2008**](InlineResponse2008.md)

### Authorization

[oauth2](../README.md#oauth2), [internalApiKey](../README.md#internalApiKey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v2ApplicationVariableUserSourcesGet"></a>
# **v2ApplicationVariableUserSourcesGet**
> InlineResponse2009 v2ApplicationVariableUserSourcesGet(accessToken, variableId, timestamp, earliestMeasurementTime, latestMeasurementTime, createdAt, updatedAt, limit, offset, sort)

Get all VariableUserSources

Get all VariableUserSources

### Example
```java
// Import classes:
//import io.swagger.client.api.ApplicationEndpointsApi;

ApplicationEndpointsApi apiInstance = new ApplicationEndpointsApi();
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
Integer variableId = 56; // Integer | ID of variable
Integer timestamp = 56; // Integer | Time that this measurement occurred Uses epoch minute (epoch time divided by 60)
Integer earliestMeasurementTime = 56; // Integer | Earliest measurement time
Integer latestMeasurementTime = 56; // Integer | Latest measurement time
String createdAt = "createdAt_example"; // String | When the record was first created. Use ISO 8601 datetime format 
String updatedAt = "updatedAt_example"; // String | When the record was last updated. Use ISO 8601 datetime format 
Integer limit = 56; // Integer | The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records.
Integer offset = 56; // Integer | OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned.
String sort = "sort_example"; // String | Sort by given field. If the field is prefixed with '-', it will sort in descending order.
try {
    InlineResponse2009 result = apiInstance.v2ApplicationVariableUserSourcesGet(accessToken, variableId, timestamp, earliestMeasurementTime, latestMeasurementTime, createdAt, updatedAt, limit, offset, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ApplicationEndpointsApi#v2ApplicationVariableUserSourcesGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]
 **variableId** | **Integer**| ID of variable | [optional]
 **timestamp** | **Integer**| Time that this measurement occurred Uses epoch minute (epoch time divided by 60) | [optional]
 **earliestMeasurementTime** | **Integer**| Earliest measurement time | [optional]
 **latestMeasurementTime** | **Integer**| Latest measurement time | [optional]
 **createdAt** | **String**| When the record was first created. Use ISO 8601 datetime format  | [optional]
 **updatedAt** | **String**| When the record was last updated. Use ISO 8601 datetime format  | [optional]
 **limit** | **Integer**| The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records. | [optional]
 **offset** | **Integer**| OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned. | [optional]
 **sort** | **String**| Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order. | [optional]

### Return type

[**InlineResponse2009**](InlineResponse2009.md)

### Authorization

[oauth2](../README.md#oauth2), [internalApiKey](../README.md#internalApiKey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v2ApplicationVotesGet"></a>
# **v2ApplicationVotesGet**
> InlineResponse20010 v2ApplicationVotesGet(accessToken, clientId, causeId, effectId, value, createdAt, updatedAt, limit, offset, sort)

Get all Votes

Get all Votes

### Example
```java
// Import classes:
//import io.swagger.client.api.ApplicationEndpointsApi;

ApplicationEndpointsApi apiInstance = new ApplicationEndpointsApi();
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
String clientId = "clientId_example"; // String | The ID of the client application which last created or updated this vote
Integer causeId = 56; // Integer | ID of predictor variable
Integer effectId = 56; // Integer | ID of outcome variable
Integer value = 56; // Integer | Value of Vote. 1 is for upvote. 0 is for downvote.  Otherwise, there is no vote.
String createdAt = "createdAt_example"; // String | When the record was first created. Use ISO 8601 datetime format 
String updatedAt = "updatedAt_example"; // String | When the record was last updated. Use ISO 8601 datetime format 
Integer limit = 56; // Integer | The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records.
Integer offset = 56; // Integer | OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned.
String sort = "sort_example"; // String | Sort by given field. If the field is prefixed with '-', it will sort in descending order.
try {
    InlineResponse20010 result = apiInstance.v2ApplicationVotesGet(accessToken, clientId, causeId, effectId, value, createdAt, updatedAt, limit, offset, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ApplicationEndpointsApi#v2ApplicationVotesGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]
 **clientId** | **String**| The ID of the client application which last created or updated this vote | [optional]
 **causeId** | **Integer**| ID of predictor variable | [optional]
 **effectId** | **Integer**| ID of outcome variable | [optional]
 **value** | **Integer**| Value of Vote. 1 is for upvote. 0 is for downvote.  Otherwise, there is no vote. | [optional]
 **createdAt** | **String**| When the record was first created. Use ISO 8601 datetime format  | [optional]
 **updatedAt** | **String**| When the record was last updated. Use ISO 8601 datetime format  | [optional]
 **limit** | **Integer**| The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records. | [optional]
 **offset** | **Integer**| OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned. | [optional]
 **sort** | **String**| Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order. | [optional]

### Return type

[**InlineResponse20010**](InlineResponse20010.md)

### Authorization

[oauth2](../README.md#oauth2), [internalApiKey](../README.md#internalApiKey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

