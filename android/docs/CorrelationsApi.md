# CorrelationsApi

All URIs are relative to *https://app.quantimo.do/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**v1AggregatedCorrelationsGet**](CorrelationsApi.md#v1AggregatedCorrelationsGet) | **GET** /v1/aggregatedCorrelations | Get aggregated correlations
[**v1AggregatedCorrelationsPost**](CorrelationsApi.md#v1AggregatedCorrelationsPost) | **POST** /v1/aggregatedCorrelations | Store or Update a Correlation
[**v1CorrelationsGet**](CorrelationsApi.md#v1CorrelationsGet) | **GET** /v1/correlations | Get correlations
[**v1OrganizationsOrganizationIdUsersUserIdVariablesVariableNameCausesGet**](CorrelationsApi.md#v1OrganizationsOrganizationIdUsersUserIdVariablesVariableNameCausesGet) | **GET** /v1/organizations/{organizationId}/users/{userId}/variables/{variableName}/causes | Search user correlations for a given cause
[**v1OrganizationsOrganizationIdUsersUserIdVariablesVariableNameEffectsGet**](CorrelationsApi.md#v1OrganizationsOrganizationIdUsersUserIdVariablesVariableNameEffectsGet) | **GET** /v1/organizations/{organizationId}/users/{userId}/variables/{variableName}/effects | Search user correlations for a given cause
[**v1PublicCorrelationsSearchSearchGet**](CorrelationsApi.md#v1PublicCorrelationsSearchSearchGet) | **GET** /v1/public/correlations/search/{search} | Get average correlations for variables containing search term
[**v1VariablesVariableNameCausesGet**](CorrelationsApi.md#v1VariablesVariableNameCausesGet) | **GET** /v1/variables/{variableName}/causes | Search user correlations for a given effect
[**v1VariablesVariableNameEffectsGet**](CorrelationsApi.md#v1VariablesVariableNameEffectsGet) | **GET** /v1/variables/{variableName}/effects | Search user correlations for a given cause
[**v1VariablesVariableNamePublicCausesGet**](CorrelationsApi.md#v1VariablesVariableNamePublicCausesGet) | **GET** /v1/variables/{variableName}/public/causes | Search public correlations for a given effect
[**v1VariablesVariableNamePublicEffectsGet**](CorrelationsApi.md#v1VariablesVariableNamePublicEffectsGet) | **GET** /v1/variables/{variableName}/public/effects | Search public correlations for a given cause
[**v1VotesDeletePost**](CorrelationsApi.md#v1VotesDeletePost) | **POST** /v1/votes/delete | Delete vote
[**v1VotesPost**](CorrelationsApi.md#v1VotesPost) | **POST** /v1/votes | Post or update vote


<a name="v1AggregatedCorrelationsGet"></a>
# **v1AggregatedCorrelationsGet**
> List&lt;Correlation&gt; v1AggregatedCorrelationsGet(accessToken, userId, effect, cause, correlationCoefficient, onsetDelay, durationOfAction, updatedAt, limit, offset, sort, outcomesOfInterest)

Get aggregated correlations

Get correlations based on the anonymized aggregate data from all QuantiModo users.

### Example
```java
// Import classes:
//import io.swagger.client.api.CorrelationsApi;

CorrelationsApi apiInstance = new CorrelationsApi();
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
Integer userId = 56; // Integer | User's id
String effect = "effect_example"; // String | Variable name of the effect variable for which the user desires correlations
String cause = "cause_example"; // String | Variable name of the cause variable for which the user desires correlations
String correlationCoefficient = "correlationCoefficient_example"; // String | Pearson correlation coefficient between cause and effect after lagging by onset delay and grouping by duration of action
String onsetDelay = "onsetDelay_example"; // String | The amount of time in seconds that elapses after the predictor/stimulus event before the outcome as perceived by a self-tracker is known as the “onset delay”. For example, the “onset delay” between the time a person takes an aspirin (predictor/stimulus event) and the time a person perceives a change in their headache severity (outcome) is approximately 30 minutes.
String durationOfAction = "durationOfAction_example"; // String | The amount of time over which a predictor/stimulus event can exert an observable influence on an outcome variable’s value. For instance, aspirin (stimulus/predictor) typically decreases headache severity for approximately four hours (duration of action) following the onset delay.
String updatedAt = "updatedAt_example"; // String | The time that this measurement was last updated in the UTC format \"YYYY-MM-DDThh:mm:ss\".  Generally, you'll be retrieving new or updated user data. To avoid unnecessary API calls, you'll want to store your last refresh time locally. Then whenever you make a request to get new data, you should limit the returned results to those updated since your last refresh by appending append `?updatedAt=(ge)2013-01-D01T01:01:01 to your request.
Integer limit = 56; // Integer | The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0.
Integer offset = 56; // Integer | Since the maximum limit is 200 records, to get more than that you'll have to make multiple API calls and page through the results. To retrieve all the data, you can iterate through data by using the `limit` and `offset` query parameters.  For example, if you want to retrieve data from 61-80 then you can use a query with the following parameters, `imit=20&offset=60`.
Integer sort = 56; // Integer | Sort by given field. If the field is prefixed with `-, it will sort in descending order.
Boolean outcomesOfInterest = true; // Boolean | Only include correlations for which the effect is an outcome of interest for the user
try {
    List<Correlation> result = apiInstance.v1AggregatedCorrelationsGet(accessToken, userId, effect, cause, correlationCoefficient, onsetDelay, durationOfAction, updatedAt, limit, offset, sort, outcomesOfInterest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CorrelationsApi#v1AggregatedCorrelationsGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]
 **userId** | **Integer**| User&#39;s id | [optional]
 **effect** | **String**| Variable name of the effect variable for which the user desires correlations | [optional]
 **cause** | **String**| Variable name of the cause variable for which the user desires correlations | [optional]
 **correlationCoefficient** | **String**| Pearson correlation coefficient between cause and effect after lagging by onset delay and grouping by duration of action | [optional]
 **onsetDelay** | **String**| The amount of time in seconds that elapses after the predictor/stimulus event before the outcome as perceived by a self-tracker is known as the “onset delay”. For example, the “onset delay” between the time a person takes an aspirin (predictor/stimulus event) and the time a person perceives a change in their headache severity (outcome) is approximately 30 minutes. | [optional]
 **durationOfAction** | **String**| The amount of time over which a predictor/stimulus event can exert an observable influence on an outcome variable’s value. For instance, aspirin (stimulus/predictor) typically decreases headache severity for approximately four hours (duration of action) following the onset delay. | [optional]
 **updatedAt** | **String**| The time that this measurement was last updated in the UTC format \&quot;YYYY-MM-DDThh:mm:ss\&quot;.  Generally, you&#39;ll be retrieving new or updated user data. To avoid unnecessary API calls, you&#39;ll want to store your last refresh time locally. Then whenever you make a request to get new data, you should limit the returned results to those updated since your last refresh by appending append &#x60;?updatedAt&#x3D;(ge)2013-01-D01T01:01:01 to your request. | [optional]
 **limit** | **Integer**| The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. | [optional]
 **offset** | **Integer**| Since the maximum limit is 200 records, to get more than that you&#39;ll have to make multiple API calls and page through the results. To retrieve all the data, you can iterate through data by using the &#x60;limit&#x60; and &#x60;offset&#x60; query parameters.  For example, if you want to retrieve data from 61-80 then you can use a query with the following parameters, &#x60;imit&#x3D;20&amp;offset&#x3D;60&#x60;. | [optional]
 **sort** | **Integer**| Sort by given field. If the field is prefixed with &#x60;-, it will sort in descending order. | [optional]
 **outcomesOfInterest** | **Boolean**| Only include correlations for which the effect is an outcome of interest for the user | [optional]

### Return type

[**List&lt;Correlation&gt;**](Correlation.md)

### Authorization

[access_token](../README.md#access_token), [quantimodo_oauth2](../README.md#quantimodo_oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1AggregatedCorrelationsPost"></a>
# **v1AggregatedCorrelationsPost**
> v1AggregatedCorrelationsPost(body, accessToken, userId)

Store or Update a Correlation

Add correlation

### Example
```java
// Import classes:
//import io.swagger.client.api.CorrelationsApi;

CorrelationsApi apiInstance = new CorrelationsApi();
PostCorrelation body = new PostCorrelation(); // PostCorrelation | Provides correlation data
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
Integer userId = 56; // Integer | User's id
try {
    apiInstance.v1AggregatedCorrelationsPost(body, accessToken, userId);
} catch (ApiException e) {
    System.err.println("Exception when calling CorrelationsApi#v1AggregatedCorrelationsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**PostCorrelation**](PostCorrelation.md)| Provides correlation data |
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]
 **userId** | **Integer**| User&#39;s id | [optional]

### Return type

null (empty response body)

### Authorization

[access_token](../README.md#access_token), [quantimodo_oauth2](../README.md#quantimodo_oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1CorrelationsGet"></a>
# **v1CorrelationsGet**
> List&lt;Correlation&gt; v1CorrelationsGet(accessToken, userId, effect, cause, correlationCoefficient, onsetDelay, durationOfAction, updatedAt, limit, offset, sort, outcomesOfInterest)

Get correlations

Get correlations based on data from a single user.

### Example
```java
// Import classes:
//import io.swagger.client.api.CorrelationsApi;

CorrelationsApi apiInstance = new CorrelationsApi();
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
Integer userId = 56; // Integer | User's id
String effect = "effect_example"; // String | Variable name of the effect variable for which the user desires correlations
String cause = "cause_example"; // String | Variable name of the cause variable for which the user desires correlations
String correlationCoefficient = "correlationCoefficient_example"; // String | Pearson correlation coefficient between cause and effect after lagging by onset delay and grouping by duration of action
String onsetDelay = "onsetDelay_example"; // String | The amount of time in seconds that elapses after the predictor/stimulus event before the outcome as perceived by a self-tracker is known as the “onset delay”. For example, the “onset delay” between the time a person takes an aspirin (predictor/stimulus event) and the time a person perceives a change in their headache severity (outcome) is approximately 30 minutes.
String durationOfAction = "durationOfAction_example"; // String | The amount of time over which a predictor/stimulus event can exert an observable influence on an outcome variable’s value. For instance, aspirin (stimulus/predictor) typically decreases headache severity for approximately four hours (duration of action) following the onset delay.
String updatedAt = "updatedAt_example"; // String | The time that this measurement was last updated in the UTC format \"YYYY-MM-DDThh:mm:ss\".  Generally, you'll be retrieving new or updated user data. To avoid unnecessary API calls, you'll want to store your last refresh time locally. Then whenever you make a request to get new data, you should limit the returned results to those updated since your last refresh by appending append `?updatedAt=(ge)2013-01-D01T01:01:01 to your request.
Integer limit = 56; // Integer | The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0.
Integer offset = 56; // Integer | Since the maximum limit is 200 records, to get more than that you'll have to make multiple API calls and page through the results. To retrieve all the data, you can iterate through data by using the `limit` and `offset` query parameters.  For example, if you want to retrieve data from 61-80 then you can use a query with the following parameters, `imit=20&offset=60`.
Integer sort = 56; // Integer | Sort by given field. If the field is prefixed with `-, it will sort in descending order.
Boolean outcomesOfInterest = true; // Boolean | Only include correlations for which the effect is an outcome of interest for the user
try {
    List<Correlation> result = apiInstance.v1CorrelationsGet(accessToken, userId, effect, cause, correlationCoefficient, onsetDelay, durationOfAction, updatedAt, limit, offset, sort, outcomesOfInterest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CorrelationsApi#v1CorrelationsGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]
 **userId** | **Integer**| User&#39;s id | [optional]
 **effect** | **String**| Variable name of the effect variable for which the user desires correlations | [optional]
 **cause** | **String**| Variable name of the cause variable for which the user desires correlations | [optional]
 **correlationCoefficient** | **String**| Pearson correlation coefficient between cause and effect after lagging by onset delay and grouping by duration of action | [optional]
 **onsetDelay** | **String**| The amount of time in seconds that elapses after the predictor/stimulus event before the outcome as perceived by a self-tracker is known as the “onset delay”. For example, the “onset delay” between the time a person takes an aspirin (predictor/stimulus event) and the time a person perceives a change in their headache severity (outcome) is approximately 30 minutes. | [optional]
 **durationOfAction** | **String**| The amount of time over which a predictor/stimulus event can exert an observable influence on an outcome variable’s value. For instance, aspirin (stimulus/predictor) typically decreases headache severity for approximately four hours (duration of action) following the onset delay. | [optional]
 **updatedAt** | **String**| The time that this measurement was last updated in the UTC format \&quot;YYYY-MM-DDThh:mm:ss\&quot;.  Generally, you&#39;ll be retrieving new or updated user data. To avoid unnecessary API calls, you&#39;ll want to store your last refresh time locally. Then whenever you make a request to get new data, you should limit the returned results to those updated since your last refresh by appending append &#x60;?updatedAt&#x3D;(ge)2013-01-D01T01:01:01 to your request. | [optional]
 **limit** | **Integer**| The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. | [optional]
 **offset** | **Integer**| Since the maximum limit is 200 records, to get more than that you&#39;ll have to make multiple API calls and page through the results. To retrieve all the data, you can iterate through data by using the &#x60;limit&#x60; and &#x60;offset&#x60; query parameters.  For example, if you want to retrieve data from 61-80 then you can use a query with the following parameters, &#x60;imit&#x3D;20&amp;offset&#x3D;60&#x60;. | [optional]
 **sort** | **Integer**| Sort by given field. If the field is prefixed with &#x60;-, it will sort in descending order. | [optional]
 **outcomesOfInterest** | **Boolean**| Only include correlations for which the effect is an outcome of interest for the user | [optional]

### Return type

[**List&lt;Correlation&gt;**](Correlation.md)

### Authorization

[access_token](../README.md#access_token), [quantimodo_oauth2](../README.md#quantimodo_oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1OrganizationsOrganizationIdUsersUserIdVariablesVariableNameCausesGet"></a>
# **v1OrganizationsOrganizationIdUsersUserIdVariablesVariableNameCausesGet**
> List&lt;Correlation&gt; v1OrganizationsOrganizationIdUsersUserIdVariablesVariableNameCausesGet(organizationId, userId2, variableName, organizationToken, accessToken, userId, includePublic)

Search user correlations for a given cause

Returns average of all correlations and votes for all user cause variables for a given cause. If parameter \&quot;include_public\&quot; is used, it also returns public correlations. User correlation overwrites or supersedes public correlation.

### Example
```java
// Import classes:
//import io.swagger.client.api.CorrelationsApi;

CorrelationsApi apiInstance = new CorrelationsApi();
Integer organizationId = 56; // Integer | Organization ID
Integer userId2 = 56; // Integer | User id
String variableName = "variableName_example"; // String | Effect variable name
String organizationToken = "organizationToken_example"; // String | Organization access token
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
Integer userId = 56; // Integer | User's id
String includePublic = "includePublic_example"; // String | Include public correlations, Can be \"1\" or empty.
try {
    List<Correlation> result = apiInstance.v1OrganizationsOrganizationIdUsersUserIdVariablesVariableNameCausesGet(organizationId, userId2, variableName, organizationToken, accessToken, userId, includePublic);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CorrelationsApi#v1OrganizationsOrganizationIdUsersUserIdVariablesVariableNameCausesGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **organizationId** | **Integer**| Organization ID |
 **userId2** | **Integer**| User id |
 **variableName** | **String**| Effect variable name |
 **organizationToken** | **String**| Organization access token |
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]
 **userId** | **Integer**| User&#39;s id | [optional]
 **includePublic** | **String**| Include public correlations, Can be \&quot;1\&quot; or empty. | [optional]

### Return type

[**List&lt;Correlation&gt;**](Correlation.md)

### Authorization

[access_token](../README.md#access_token), [quantimodo_oauth2](../README.md#quantimodo_oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1OrganizationsOrganizationIdUsersUserIdVariablesVariableNameEffectsGet"></a>
# **v1OrganizationsOrganizationIdUsersUserIdVariablesVariableNameEffectsGet**
> List&lt;CommonResponse&gt; v1OrganizationsOrganizationIdUsersUserIdVariablesVariableNameEffectsGet(organizationId, userId2, variableName, organizationToken, accessToken, userId, includePublic)

Search user correlations for a given cause

Returns average of all correlations and votes for all user cause variables for a given effect. If parameter \&quot;include_public\&quot; is used, it also returns public correlations. User correlation overwrites or supersedes public correlation.

### Example
```java
// Import classes:
//import io.swagger.client.api.CorrelationsApi;

CorrelationsApi apiInstance = new CorrelationsApi();
Integer organizationId = 56; // Integer | Organization ID
Integer userId2 = 56; // Integer | User id
String variableName = "variableName_example"; // String | Cause variable name
String organizationToken = "organizationToken_example"; // String | Organization access token
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
Integer userId = 56; // Integer | User's id
String includePublic = "includePublic_example"; // String | Include public correlations, Can be \"1\" or empty.
try {
    List<CommonResponse> result = apiInstance.v1OrganizationsOrganizationIdUsersUserIdVariablesVariableNameEffectsGet(organizationId, userId2, variableName, organizationToken, accessToken, userId, includePublic);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CorrelationsApi#v1OrganizationsOrganizationIdUsersUserIdVariablesVariableNameEffectsGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **organizationId** | **Integer**| Organization ID |
 **userId2** | **Integer**| User id |
 **variableName** | **String**| Cause variable name |
 **organizationToken** | **String**| Organization access token |
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]
 **userId** | **Integer**| User&#39;s id | [optional]
 **includePublic** | **String**| Include public correlations, Can be \&quot;1\&quot; or empty. | [optional]

### Return type

[**List&lt;CommonResponse&gt;**](CommonResponse.md)

### Authorization

[access_token](../README.md#access_token), [quantimodo_oauth2](../README.md#quantimodo_oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1PublicCorrelationsSearchSearchGet"></a>
# **v1PublicCorrelationsSearchSearchGet**
> List&lt;Correlation&gt; v1PublicCorrelationsSearchSearchGet(search, effectOrCause, accessToken, userId, outcomesOfInterest)

Get average correlations for variables containing search term

Returns the average correlations from all users for all public variables that contain the characters in the search query. Returns average of all users public variable correlations with a specified cause or effect.

### Example
```java
// Import classes:
//import io.swagger.client.api.CorrelationsApi;

CorrelationsApi apiInstance = new CorrelationsApi();
String search = "search_example"; // String | Name of the variable that you want to know the causes or effects of.
String effectOrCause = "effectOrCause_example"; // String | Setting this to effect indicates that the searched variable is the effect and that the causes of this variable should be returned. cause indicates that the searched variable is the cause and the effects should be returned.
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
Integer userId = 56; // Integer | User's id
Boolean outcomesOfInterest = true; // Boolean | Only include correlations for which the effect is an outcome of interest for the user
try {
    List<Correlation> result = apiInstance.v1PublicCorrelationsSearchSearchGet(search, effectOrCause, accessToken, userId, outcomesOfInterest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CorrelationsApi#v1PublicCorrelationsSearchSearchGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **search** | **String**| Name of the variable that you want to know the causes or effects of. |
 **effectOrCause** | **String**| Setting this to effect indicates that the searched variable is the effect and that the causes of this variable should be returned. cause indicates that the searched variable is the cause and the effects should be returned. |
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]
 **userId** | **Integer**| User&#39;s id | [optional]
 **outcomesOfInterest** | **Boolean**| Only include correlations for which the effect is an outcome of interest for the user | [optional]

### Return type

[**List&lt;Correlation&gt;**](Correlation.md)

### Authorization

[access_token](../README.md#access_token), [quantimodo_oauth2](../README.md#quantimodo_oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1VariablesVariableNameCausesGet"></a>
# **v1VariablesVariableNameCausesGet**
> List&lt;Correlation&gt; v1VariablesVariableNameCausesGet(variableName)

Search user correlations for a given effect

Returns average of all correlations and votes for all user cause variables for a given effect

### Example
```java
// Import classes:
//import io.swagger.client.api.CorrelationsApi;

CorrelationsApi apiInstance = new CorrelationsApi();
String variableName = "variableName_example"; // String | Effect variable name
try {
    List<Correlation> result = apiInstance.v1VariablesVariableNameCausesGet(variableName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CorrelationsApi#v1VariablesVariableNameCausesGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **variableName** | **String**| Effect variable name |

### Return type

[**List&lt;Correlation&gt;**](Correlation.md)

### Authorization

[access_token](../README.md#access_token), [quantimodo_oauth2](../README.md#quantimodo_oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1VariablesVariableNameEffectsGet"></a>
# **v1VariablesVariableNameEffectsGet**
> List&lt;Correlation&gt; v1VariablesVariableNameEffectsGet(variableName, accessToken, userId, correlationCoefficient)

Search user correlations for a given cause

Returns average of all correlations and votes for all user effect variables for a given cause

### Example
```java
// Import classes:
//import io.swagger.client.api.CorrelationsApi;

CorrelationsApi apiInstance = new CorrelationsApi();
String variableName = "variableName_example"; // String | Cause variable name
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
Integer userId = 56; // Integer | User's id
String correlationCoefficient = "correlationCoefficient_example"; // String | You can use this to get effects with correlations greater than or less than 0
try {
    List<Correlation> result = apiInstance.v1VariablesVariableNameEffectsGet(variableName, accessToken, userId, correlationCoefficient);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CorrelationsApi#v1VariablesVariableNameEffectsGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **variableName** | **String**| Cause variable name |
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]
 **userId** | **Integer**| User&#39;s id | [optional]
 **correlationCoefficient** | **String**| You can use this to get effects with correlations greater than or less than 0 | [optional]

### Return type

[**List&lt;Correlation&gt;**](Correlation.md)

### Authorization

[access_token](../README.md#access_token), [quantimodo_oauth2](../README.md#quantimodo_oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1VariablesVariableNamePublicCausesGet"></a>
# **v1VariablesVariableNamePublicCausesGet**
> List&lt;Correlation&gt; v1VariablesVariableNamePublicCausesGet(variableName, accessToken, userId, correlationCoefficient)

Search public correlations for a given effect

Returns average of all correlations and votes for all public cause variables for a given effect

### Example
```java
// Import classes:
//import io.swagger.client.api.CorrelationsApi;

CorrelationsApi apiInstance = new CorrelationsApi();
String variableName = "variableName_example"; // String | Effect variable name
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
Integer userId = 56; // Integer | User's id
String correlationCoefficient = "correlationCoefficient_example"; // String | You can use this to get causes with correlations greater than or less than 0
try {
    List<Correlation> result = apiInstance.v1VariablesVariableNamePublicCausesGet(variableName, accessToken, userId, correlationCoefficient);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CorrelationsApi#v1VariablesVariableNamePublicCausesGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **variableName** | **String**| Effect variable name |
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]
 **userId** | **Integer**| User&#39;s id | [optional]
 **correlationCoefficient** | **String**| You can use this to get causes with correlations greater than or less than 0 | [optional]

### Return type

[**List&lt;Correlation&gt;**](Correlation.md)

### Authorization

[access_token](../README.md#access_token), [quantimodo_oauth2](../README.md#quantimodo_oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1VariablesVariableNamePublicEffectsGet"></a>
# **v1VariablesVariableNamePublicEffectsGet**
> List&lt;Correlation&gt; v1VariablesVariableNamePublicEffectsGet(variableName, accessToken, userId)

Search public correlations for a given cause

Returns average of all correlations and votes for all public cause variables for a given cause

### Example
```java
// Import classes:
//import io.swagger.client.api.CorrelationsApi;

CorrelationsApi apiInstance = new CorrelationsApi();
String variableName = "variableName_example"; // String | Cause variable name
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
Integer userId = 56; // Integer | User's id
try {
    List<Correlation> result = apiInstance.v1VariablesVariableNamePublicEffectsGet(variableName, accessToken, userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CorrelationsApi#v1VariablesVariableNamePublicEffectsGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **variableName** | **String**| Cause variable name |
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]
 **userId** | **Integer**| User&#39;s id | [optional]

### Return type

[**List&lt;Correlation&gt;**](Correlation.md)

### Authorization

[access_token](../README.md#access_token), [quantimodo_oauth2](../README.md#quantimodo_oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1VotesDeletePost"></a>
# **v1VotesDeletePost**
> CommonResponse v1VotesDeletePost(body, accessToken, userId)

Delete vote

Delete previously posted vote

### Example
```java
// Import classes:
//import io.swagger.client.api.CorrelationsApi;

CorrelationsApi apiInstance = new CorrelationsApi();
VoteDelete body = new VoteDelete(); // VoteDelete | The cause and effect variable names for the predictor vote to be deleted.
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
Integer userId = 56; // Integer | User's id
try {
    CommonResponse result = apiInstance.v1VotesDeletePost(body, accessToken, userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CorrelationsApi#v1VotesDeletePost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**VoteDelete**](VoteDelete.md)| The cause and effect variable names for the predictor vote to be deleted. |
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]
 **userId** | **Integer**| User&#39;s id | [optional]

### Return type

[**CommonResponse**](CommonResponse.md)

### Authorization

[access_token](../README.md#access_token), [quantimodo_oauth2](../README.md#quantimodo_oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1VotesPost"></a>
# **v1VotesPost**
> CommonResponse v1VotesPost(body, accessToken, userId)

Post or update vote

This is to enable users to indicate their opinion on the plausibility of a causal relationship between a treatment and outcome. QuantiModo incorporates crowd-sourced plausibility estimations into their algorithm. This is done allowing user to indicate their view of the plausibility of each relationship with thumbs up/down buttons placed next to each prediction.

### Example
```java
// Import classes:
//import io.swagger.client.api.CorrelationsApi;

CorrelationsApi apiInstance = new CorrelationsApi();
PostVote body = new PostVote(); // PostVote | Contains the cause variable, effect variable, and vote value.
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
Integer userId = 56; // Integer | User's id
try {
    CommonResponse result = apiInstance.v1VotesPost(body, accessToken, userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CorrelationsApi#v1VotesPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**PostVote**](PostVote.md)| Contains the cause variable, effect variable, and vote value. |
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]
 **userId** | **Integer**| User&#39;s id | [optional]

### Return type

[**CommonResponse**](CommonResponse.md)

### Authorization

[access_token](../README.md#access_token), [quantimodo_oauth2](../README.md#quantimodo_oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

