# MeasurementsApi

All URIs are relative to *https://app.quantimo.do/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**v1MeasurementSourcesGet**](MeasurementsApi.md#v1MeasurementSourcesGet) | **GET** /v1/measurementSources | Get measurement sources
[**v1MeasurementSourcesPost**](MeasurementsApi.md#v1MeasurementSourcesPost) | **POST** /v1/measurementSources | Add a data source
[**v1MeasurementsDailyGet**](MeasurementsApi.md#v1MeasurementsDailyGet) | **GET** /v1/measurements/daily | Get daily measurements for this user
[**v1MeasurementsDeletePost**](MeasurementsApi.md#v1MeasurementsDeletePost) | **POST** /v1/measurements/delete | Delete a measurement
[**v1MeasurementsGet**](MeasurementsApi.md#v1MeasurementsGet) | **GET** /v1/measurements | Get measurements for this user
[**v1MeasurementsPost**](MeasurementsApi.md#v1MeasurementsPost) | **POST** /v1/measurements | Post a new set or update existing measurements to the database
[**v1MeasurementsRangeGet**](MeasurementsApi.md#v1MeasurementsRangeGet) | **GET** /v1/measurementsRange | Get measurements range for this user
[**v2MeasurementsCsvGet**](MeasurementsApi.md#v2MeasurementsCsvGet) | **GET** /v2/measurements/csv | Get Measurements CSV
[**v2MeasurementsIdDelete**](MeasurementsApi.md#v2MeasurementsIdDelete) | **DELETE** /v2/measurements/{id} | Delete Measurement
[**v2MeasurementsIdGet**](MeasurementsApi.md#v2MeasurementsIdGet) | **GET** /v2/measurements/{id} | Get Measurement
[**v2MeasurementsIdPut**](MeasurementsApi.md#v2MeasurementsIdPut) | **PUT** /v2/measurements/{id} | Update Measurement
[**v2MeasurementsRequestCsvPost**](MeasurementsApi.md#v2MeasurementsRequestCsvPost) | **POST** /v2/measurements/request_csv | Post Request for Measurements CSV
[**v2MeasurementsRequestPdfPost**](MeasurementsApi.md#v2MeasurementsRequestPdfPost) | **POST** /v2/measurements/request_pdf | Post Request for Measurements PDF
[**v2MeasurementsRequestXlsPost**](MeasurementsApi.md#v2MeasurementsRequestXlsPost) | **POST** /v2/measurements/request_xls | Post Request for Measurements XLS


<a name="v1MeasurementSourcesGet"></a>
# **v1MeasurementSourcesGet**
> MeasurementSource v1MeasurementSourcesGet()

Get measurement sources

Returns a list of all the apps from which measurement data is obtained.

### Example
```java
// Import classes:
//import io.swagger.client.api.MeasurementsApi;

MeasurementsApi apiInstance = new MeasurementsApi();
try {
    MeasurementSource result = apiInstance.v1MeasurementSourcesGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MeasurementsApi#v1MeasurementSourcesGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**MeasurementSource**](MeasurementSource.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1MeasurementSourcesPost"></a>
# **v1MeasurementSourcesPost**
> v1MeasurementSourcesPost(body, accessToken)

Add a data source

Add a life-tracking app or device to the QuantiModo list of data sources.

### Example
```java
// Import classes:
//import io.swagger.client.api.MeasurementsApi;

MeasurementsApi apiInstance = new MeasurementsApi();
MeasurementSource body = new MeasurementSource(); // MeasurementSource | An array of names of data sources you want to add.
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
try {
    apiInstance.v1MeasurementSourcesPost(body, accessToken);
} catch (ApiException e) {
    System.err.println("Exception when calling MeasurementsApi#v1MeasurementSourcesPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**MeasurementSource**](MeasurementSource.md)| An array of names of data sources you want to add. |
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]

### Return type

null (empty response body)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1MeasurementsDailyGet"></a>
# **v1MeasurementsDailyGet**
> Measurement v1MeasurementsDailyGet(variableName, accessToken, abbreviatedUnitName, startTime, endTime, groupingWidth, groupingTimezone, limit, offset, sort)

Get daily measurements for this user

Measurements are any value that can be recorded like daily steps, a mood rating, or apples eaten. &lt;br&gt;Supported filter parameters:&lt;br&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;value&lt;/b&gt; - Value of measurement&lt;/li&gt;&lt;li&gt;&lt;b&gt;lastUpdated&lt;/b&gt; - The time that this measurement was created or last updated in the UTC format \&quot;YYYY-MM-DDThh:mm:ss\&quot;&lt;/li&gt;&lt;/ul&gt;&lt;br&gt;

### Example
```java
// Import classes:
//import io.swagger.client.api.MeasurementsApi;

MeasurementsApi apiInstance = new MeasurementsApi();
String variableName = "variableName_example"; // String | Name of the variable you want measurements for
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
String abbreviatedUnitName = "abbreviatedUnitName_example"; // String | The unit your want the measurements in
String startTime = "startTime_example"; // String | The lower limit of measurements returned (Iso8601)
String endTime = "endTime_example"; // String | The upper limit of measurements returned (Iso8601)
Integer groupingWidth = 56; // Integer | The time (in seconds) over which measurements are grouped together
String groupingTimezone = "groupingTimezone_example"; // String | The time (in seconds) over which measurements are grouped together
Integer limit = 56; // Integer | The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0.
Integer offset = 56; // Integer | Now suppose you wanted to show results 11-20. You'd set the offset to 10 and the limit to 10.
Integer sort = 56; // Integer | Sort by given field. If the field is prefixed with `-, it will sort in descending order.
try {
    Measurement result = apiInstance.v1MeasurementsDailyGet(variableName, accessToken, abbreviatedUnitName, startTime, endTime, groupingWidth, groupingTimezone, limit, offset, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MeasurementsApi#v1MeasurementsDailyGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **variableName** | **String**| Name of the variable you want measurements for |
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]
 **abbreviatedUnitName** | **String**| The unit your want the measurements in | [optional]
 **startTime** | **String**| The lower limit of measurements returned (Iso8601) | [optional]
 **endTime** | **String**| The upper limit of measurements returned (Iso8601) | [optional]
 **groupingWidth** | **Integer**| The time (in seconds) over which measurements are grouped together | [optional]
 **groupingTimezone** | **String**| The time (in seconds) over which measurements are grouped together | [optional]
 **limit** | **Integer**| The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. | [optional]
 **offset** | **Integer**| Now suppose you wanted to show results 11-20. You&#39;d set the offset to 10 and the limit to 10. | [optional]
 **sort** | **Integer**| Sort by given field. If the field is prefixed with &#x60;-, it will sort in descending order. | [optional]

### Return type

[**Measurement**](Measurement.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1MeasurementsDeletePost"></a>
# **v1MeasurementsDeletePost**
> CommonResponse v1MeasurementsDeletePost(body)

Delete a measurement

Delete a previously submitted measurement

### Example
```java
// Import classes:
//import io.swagger.client.api.MeasurementsApi;

MeasurementsApi apiInstance = new MeasurementsApi();
MeasurementDelete body = new MeasurementDelete(); // MeasurementDelete | The startTime and variableId of the measurement to be deleted.
try {
    CommonResponse result = apiInstance.v1MeasurementsDeletePost(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MeasurementsApi#v1MeasurementsDeletePost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**MeasurementDelete**](MeasurementDelete.md)| The startTime and variableId of the measurement to be deleted. |

### Return type

[**CommonResponse**](CommonResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1MeasurementsGet"></a>
# **v1MeasurementsGet**
> Measurement v1MeasurementsGet(accessToken, variableName, variableCategoryName, source, value, lastUpdated, unit, startTime, createdAt, updatedAt, endTime, groupingWidth, groupingTimezone, limit, offset, sort)

Get measurements for this user

Measurements are any value that can be recorded like daily steps, a mood rating, or apples eaten. &lt;br&gt;Supported filter parameters:&lt;br&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;value&lt;/b&gt; - Value of measurement&lt;/li&gt;&lt;li&gt;&lt;b&gt;lastUpdated&lt;/b&gt; - The time that this measurement was created or last updated in the UTC format \&quot;YYYY-MM-DDThh:mm:ss\&quot;&lt;/li&gt;&lt;/ul&gt;&lt;br&gt;

### Example
```java
// Import classes:
//import io.swagger.client.api.MeasurementsApi;

MeasurementsApi apiInstance = new MeasurementsApi();
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
String variableName = "variableName_example"; // String | Name of the variable you want measurements for
String variableCategoryName = "variableCategoryName_example"; // String | Name of the variable category you want measurements for
String source = "source_example"; // String | Name of the source you want measurements for (supports exact name match only)
String value = "value_example"; // String | Value of measurement
String lastUpdated = "lastUpdated_example"; // String | The time that this measurement was created or last updated in the format \"YYYY-MM-DDThh:mm:ss\"
String unit = "unit_example"; // String | The unit you want the measurements returned in
String startTime = "startTime_example"; // String | The lower limit of measurements returned (Epoch)
String createdAt = "createdAt_example"; // String | The time the measurement record was first created in the format YYYY-MM-DDThh:mm:ss. Time zone should be UTC and not local.
String updatedAt = "updatedAt_example"; // String | The time the measurement record was last changed in the format YYYY-MM-DDThh:mm:ss. Time zone should be UTC and not local.
String endTime = "endTime_example"; // String | The upper limit of measurements returned (Epoch)
Integer groupingWidth = 56; // Integer | The time (in seconds) over which measurements are grouped together
String groupingTimezone = "groupingTimezone_example"; // String | The time (in seconds) over which measurements are grouped together
Integer limit = 56; // Integer | The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0.
Integer offset = 56; // Integer | Now suppose you wanted to show results 11-20. You'd set the offset to 10 and the limit to 10.
Integer sort = 56; // Integer | Sort by given field. If the field is prefixed with `-, it will sort in descending order.
try {
    Measurement result = apiInstance.v1MeasurementsGet(accessToken, variableName, variableCategoryName, source, value, lastUpdated, unit, startTime, createdAt, updatedAt, endTime, groupingWidth, groupingTimezone, limit, offset, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MeasurementsApi#v1MeasurementsGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]
 **variableName** | **String**| Name of the variable you want measurements for | [optional]
 **variableCategoryName** | **String**| Name of the variable category you want measurements for | [optional]
 **source** | **String**| Name of the source you want measurements for (supports exact name match only) | [optional]
 **value** | **String**| Value of measurement | [optional]
 **lastUpdated** | **String**| The time that this measurement was created or last updated in the format \&quot;YYYY-MM-DDThh:mm:ss\&quot; | [optional]
 **unit** | **String**| The unit you want the measurements returned in | [optional]
 **startTime** | **String**| The lower limit of measurements returned (Epoch) | [optional]
 **createdAt** | **String**| The time the measurement record was first created in the format YYYY-MM-DDThh:mm:ss. Time zone should be UTC and not local. | [optional]
 **updatedAt** | **String**| The time the measurement record was last changed in the format YYYY-MM-DDThh:mm:ss. Time zone should be UTC and not local. | [optional]
 **endTime** | **String**| The upper limit of measurements returned (Epoch) | [optional]
 **groupingWidth** | **Integer**| The time (in seconds) over which measurements are grouped together | [optional]
 **groupingTimezone** | **String**| The time (in seconds) over which measurements are grouped together | [optional]
 **limit** | **Integer**| The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. | [optional]
 **offset** | **Integer**| Now suppose you wanted to show results 11-20. You&#39;d set the offset to 10 and the limit to 10. | [optional]
 **sort** | **Integer**| Sort by given field. If the field is prefixed with &#x60;-, it will sort in descending order. | [optional]

### Return type

[**Measurement**](Measurement.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1MeasurementsPost"></a>
# **v1MeasurementsPost**
> v1MeasurementsPost(body, accessToken)

Post a new set or update existing measurements to the database

You can submit or update multiple measurements in a \&quot;measurements\&quot; sub-array.  If the variable these measurements correspond to does not already exist in the database, it will be automatically added.  The request body should look something like [{\&quot;measurements\&quot;:[{\&quot;startTime\&quot;:1439389320,\&quot;value\&quot;:\&quot;3\&quot;}, {\&quot;startTime\&quot;:1439389319,\&quot;value\&quot;:\&quot;2\&quot;}],\&quot;name\&quot;:\&quot;Acne (out of 5)\&quot;,\&quot;source\&quot;:\&quot;QuantiModo\&quot;,\&quot;category\&quot;:\&quot;Symptoms\&quot;,\&quot;combinationOperation\&quot;:\&quot;MEAN\&quot;,\&quot;unit\&quot;:\&quot;/5\&quot;}]

### Example
```java
// Import classes:
//import io.swagger.client.api.MeasurementsApi;

MeasurementsApi apiInstance = new MeasurementsApi();
MeasurementSet body = new MeasurementSet(); // MeasurementSet | An array of measurements you want to insert.
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
try {
    apiInstance.v1MeasurementsPost(body, accessToken);
} catch (ApiException e) {
    System.err.println("Exception when calling MeasurementsApi#v1MeasurementsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**MeasurementSet**](MeasurementSet.md)| An array of measurements you want to insert. |
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]

### Return type

null (empty response body)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1MeasurementsRangeGet"></a>
# **v1MeasurementsRangeGet**
> MeasurementRange v1MeasurementsRangeGet(sources, user)

Get measurements range for this user

Get Unix time-stamp (epoch time) of the user&#39;s first and last measurements taken.

### Example
```java
// Import classes:
//import io.swagger.client.api.MeasurementsApi;

MeasurementsApi apiInstance = new MeasurementsApi();
String sources = "sources_example"; // String | Enter source name to limit to specific source (varchar)
Integer user = 56; // Integer | If not specified, uses currently logged in user (bigint)
try {
    MeasurementRange result = apiInstance.v1MeasurementsRangeGet(sources, user);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MeasurementsApi#v1MeasurementsRangeGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sources** | **String**| Enter source name to limit to specific source (varchar) | [optional]
 **user** | **Integer**| If not specified, uses currently logged in user (bigint) | [optional]

### Return type

[**MeasurementRange**](MeasurementRange.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v2MeasurementsCsvGet"></a>
# **v2MeasurementsCsvGet**
> File v2MeasurementsCsvGet(accessToken)

Get Measurements CSV

Download a CSV containing all user measurements

### Example
```java
// Import classes:
//import io.swagger.client.api.MeasurementsApi;

MeasurementsApi apiInstance = new MeasurementsApi();
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
try {
    File result = apiInstance.v2MeasurementsCsvGet(accessToken);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MeasurementsApi#v2MeasurementsCsvGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]

### Return type

[**File**](File.md)

### Authorization

[quantimodo_oauth2](../README.md#quantimodo_oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/csv

<a name="v2MeasurementsIdDelete"></a>
# **v2MeasurementsIdDelete**
> InlineResponse20012 v2MeasurementsIdDelete(id, accessToken)

Delete Measurement

Delete Measurement

### Example
```java
// Import classes:
//import io.swagger.client.api.MeasurementsApi;

MeasurementsApi apiInstance = new MeasurementsApi();
Integer id = 56; // Integer | id of Measurement
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
try {
    InlineResponse20012 result = apiInstance.v2MeasurementsIdDelete(id, accessToken);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MeasurementsApi#v2MeasurementsIdDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| id of Measurement |
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]

### Return type

[**InlineResponse20012**](InlineResponse20012.md)

### Authorization

[quantimodo_oauth2](../README.md#quantimodo_oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v2MeasurementsIdGet"></a>
# **v2MeasurementsIdGet**
> InlineResponse20011 v2MeasurementsIdGet(id, accessToken)

Get Measurement

Get Measurement

### Example
```java
// Import classes:
//import io.swagger.client.api.MeasurementsApi;

MeasurementsApi apiInstance = new MeasurementsApi();
Integer id = 56; // Integer | id of Measurement
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
try {
    InlineResponse20011 result = apiInstance.v2MeasurementsIdGet(id, accessToken);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MeasurementsApi#v2MeasurementsIdGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| id of Measurement |
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]

### Return type

[**InlineResponse20011**](InlineResponse20011.md)

### Authorization

[quantimodo_oauth2](../README.md#quantimodo_oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v2MeasurementsIdPut"></a>
# **v2MeasurementsIdPut**
> InlineResponse20012 v2MeasurementsIdPut(id, accessToken, body)

Update Measurement

Update Measurement

### Example
```java
// Import classes:
//import io.swagger.client.api.MeasurementsApi;

MeasurementsApi apiInstance = new MeasurementsApi();
Integer id = 56; // Integer | id of Measurement
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
Measurement body = new Measurement(); // Measurement | Measurement that should be updated
try {
    InlineResponse20012 result = apiInstance.v2MeasurementsIdPut(id, accessToken, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MeasurementsApi#v2MeasurementsIdPut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| id of Measurement |
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]
 **body** | [**Measurement**](Measurement.md)| Measurement that should be updated | [optional]

### Return type

[**InlineResponse20012**](InlineResponse20012.md)

### Authorization

[quantimodo_oauth2](../README.md#quantimodo_oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v2MeasurementsRequestCsvPost"></a>
# **v2MeasurementsRequestCsvPost**
> Integer v2MeasurementsRequestCsvPost(accessToken)

Post Request for Measurements CSV

Use this endpoint to schedule a CSV export containing all user measurements to be emailed to the user within 24 hours.

### Example
```java
// Import classes:
//import io.swagger.client.api.MeasurementsApi;

MeasurementsApi apiInstance = new MeasurementsApi();
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
try {
    Integer result = apiInstance.v2MeasurementsRequestCsvPost(accessToken);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MeasurementsApi#v2MeasurementsRequestCsvPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]

### Return type

**Integer**

### Authorization

[quantimodo_oauth2](../README.md#quantimodo_oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v2MeasurementsRequestPdfPost"></a>
# **v2MeasurementsRequestPdfPost**
> Integer v2MeasurementsRequestPdfPost(accessToken)

Post Request for Measurements PDF

Use this endpoint to schedule a PDF export containing all user measurements to be emailed to the user within 24 hours.

### Example
```java
// Import classes:
//import io.swagger.client.api.MeasurementsApi;

MeasurementsApi apiInstance = new MeasurementsApi();
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
try {
    Integer result = apiInstance.v2MeasurementsRequestPdfPost(accessToken);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MeasurementsApi#v2MeasurementsRequestPdfPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]

### Return type

**Integer**

### Authorization

[quantimodo_oauth2](../README.md#quantimodo_oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v2MeasurementsRequestXlsPost"></a>
# **v2MeasurementsRequestXlsPost**
> Integer v2MeasurementsRequestXlsPost(accessToken)

Post Request for Measurements XLS

Use this endpoint to schedule a XLS export containing all user measurements to be emailed to the user within 24 hours.

### Example
```java
// Import classes:
//import io.swagger.client.api.MeasurementsApi;

MeasurementsApi apiInstance = new MeasurementsApi();
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
try {
    Integer result = apiInstance.v2MeasurementsRequestXlsPost(accessToken);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MeasurementsApi#v2MeasurementsRequestXlsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]

### Return type

**Integer**

### Authorization

[quantimodo_oauth2](../README.md#quantimodo_oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

