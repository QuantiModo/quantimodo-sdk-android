# PairsApi

All URIs are relative to *https://app.quantimo.do/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**v1PairsCsvGet**](PairsApi.md#v1PairsCsvGet) | **GET** /v1/pairsCsv | Get pairs
[**v1PairsGet**](PairsApi.md#v1PairsGet) | **GET** /v1/pairs | Get pairs


<a name="v1PairsCsvGet"></a>
# **v1PairsCsvGet**
> List&lt;Pairs&gt; v1PairsCsvGet(cause, effect, accessToken, causeSource, causeUnit, delay, duration, effectSource, effectUnit, endTime, startTime, limit, offset, sort)

Get pairs

Pairs cause measurements with effect measurements grouped over the duration of action after the onset delay.

### Example
```java
// Import classes:
//import io.swagger.client.api.PairsApi;

PairsApi apiInstance = new PairsApi();
String cause = "cause_example"; // String | Original variable name for the explanatory or independent variable
String effect = "effect_example"; // String | Original variable name for the outcome or dependent variable
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
String causeSource = "causeSource_example"; // String | Name of data source that the cause measurements should come from
String causeUnit = "causeUnit_example"; // String | Abbreviated name for the unit cause measurements to be returned in
String delay = "delay_example"; // String | Delay before onset of action (in seconds) from the cause variable settings.
String duration = "duration_example"; // String | Duration of action (in seconds) from the cause variable settings.
String effectSource = "effectSource_example"; // String | Name of data source that the effectmeasurements should come from
String effectUnit = "effectUnit_example"; // String | Abbreviated name for the unit effect measurements to be returned in
String endTime = "endTime_example"; // String | The most recent date (in epoch time) for which we should return measurements
String startTime = "startTime_example"; // String | The earliest date (in epoch time) for which we should return measurements
Integer limit = 56; // Integer | The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0.
Integer offset = 56; // Integer | Now suppose you wanted to show results 11-20. You'd set the offset to 10 and the limit to 10.
Integer sort = 56; // Integer | Sort by given field. If the field is prefixed with `-, it will sort in descending order.
try {
    List<Pairs> result = apiInstance.v1PairsCsvGet(cause, effect, accessToken, causeSource, causeUnit, delay, duration, effectSource, effectUnit, endTime, startTime, limit, offset, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PairsApi#v1PairsCsvGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **cause** | **String**| Original variable name for the explanatory or independent variable |
 **effect** | **String**| Original variable name for the outcome or dependent variable |
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]
 **causeSource** | **String**| Name of data source that the cause measurements should come from | [optional]
 **causeUnit** | **String**| Abbreviated name for the unit cause measurements to be returned in | [optional]
 **delay** | **String**| Delay before onset of action (in seconds) from the cause variable settings. | [optional]
 **duration** | **String**| Duration of action (in seconds) from the cause variable settings. | [optional]
 **effectSource** | **String**| Name of data source that the effectmeasurements should come from | [optional]
 **effectUnit** | **String**| Abbreviated name for the unit effect measurements to be returned in | [optional]
 **endTime** | **String**| The most recent date (in epoch time) for which we should return measurements | [optional]
 **startTime** | **String**| The earliest date (in epoch time) for which we should return measurements | [optional]
 **limit** | **Integer**| The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. | [optional]
 **offset** | **Integer**| Now suppose you wanted to show results 11-20. You&#39;d set the offset to 10 and the limit to 10. | [optional]
 **sort** | **Integer**| Sort by given field. If the field is prefixed with &#x60;-, it will sort in descending order. | [optional]

### Return type

[**List&lt;Pairs&gt;**](Pairs.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1PairsGet"></a>
# **v1PairsGet**
> List&lt;Pairs&gt; v1PairsGet(cause, effect, accessToken, causeSource, causeUnit, delay, duration, effectSource, effectUnit, endTime, startTime, limit, offset, sort)

Get pairs

Pairs cause measurements with effect measurements grouped over the duration of action after the onset delay.

### Example
```java
// Import classes:
//import io.swagger.client.api.PairsApi;

PairsApi apiInstance = new PairsApi();
String cause = "cause_example"; // String | Original variable name for the explanatory or independent variable
String effect = "effect_example"; // String | Original variable name for the outcome or dependent variable
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
String causeSource = "causeSource_example"; // String | Name of data source that the cause measurements should come from
String causeUnit = "causeUnit_example"; // String | Abbreviated name for the unit cause measurements to be returned in
String delay = "delay_example"; // String | Delay before onset of action (in seconds) from the cause variable settings.
String duration = "duration_example"; // String | Duration of action (in seconds) from the cause variable settings.
String effectSource = "effectSource_example"; // String | Name of data source that the effectmeasurements should come from
String effectUnit = "effectUnit_example"; // String | Abbreviated name for the unit effect measurements to be returned in
String endTime = "endTime_example"; // String | The most recent date (in epoch time) for which we should return measurements
String startTime = "startTime_example"; // String | The earliest date (in epoch time) for which we should return measurements
Integer limit = 56; // Integer | The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0.
Integer offset = 56; // Integer | Now suppose you wanted to show results 11-20. You'd set the offset to 10 and the limit to 10.
Integer sort = 56; // Integer | Sort by given field. If the field is prefixed with `-, it will sort in descending order.
try {
    List<Pairs> result = apiInstance.v1PairsGet(cause, effect, accessToken, causeSource, causeUnit, delay, duration, effectSource, effectUnit, endTime, startTime, limit, offset, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PairsApi#v1PairsGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **cause** | **String**| Original variable name for the explanatory or independent variable |
 **effect** | **String**| Original variable name for the outcome or dependent variable |
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]
 **causeSource** | **String**| Name of data source that the cause measurements should come from | [optional]
 **causeUnit** | **String**| Abbreviated name for the unit cause measurements to be returned in | [optional]
 **delay** | **String**| Delay before onset of action (in seconds) from the cause variable settings. | [optional]
 **duration** | **String**| Duration of action (in seconds) from the cause variable settings. | [optional]
 **effectSource** | **String**| Name of data source that the effectmeasurements should come from | [optional]
 **effectUnit** | **String**| Abbreviated name for the unit effect measurements to be returned in | [optional]
 **endTime** | **String**| The most recent date (in epoch time) for which we should return measurements | [optional]
 **startTime** | **String**| The earliest date (in epoch time) for which we should return measurements | [optional]
 **limit** | **Integer**| The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. | [optional]
 **offset** | **Integer**| Now suppose you wanted to show results 11-20. You&#39;d set the offset to 10 and the limit to 10. | [optional]
 **sort** | **Integer**| Sort by given field. If the field is prefixed with &#x60;-, it will sort in descending order. | [optional]

### Return type

[**List&lt;Pairs&gt;**](Pairs.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

