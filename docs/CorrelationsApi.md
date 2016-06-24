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
> List&lt;Correlation&gt; v1AggregatedCorrelationsGet(accessToken, effect, cause, correlationCoefficient, onsetDelay, durationOfAction, lastUpdated, limit, offset, sort)

Get aggregated correlations

Get correlations based on the anonymized aggregate data from all QuantiModo users.

### Example
```java
// Import classes:
//import io.swagger.client.api.CorrelationsApi;

CorrelationsApi apiInstance = new CorrelationsApi();
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
String effect = "effect_example"; // String | ORIGINAL variable name of the effect variable for which the user desires correlations
String cause = "cause_example"; // String | ORIGINAL variable name of the cause variable for which the user desires correlations
String correlationCoefficient = "correlationCoefficient_example"; // String | Pearson correlation coefficient between cause and effect after lagging by onset delay and grouping by duration of action
String onsetDelay = "onsetDelay_example"; // String | The number of seconds which pass following a cause measurement before an effect would likely be observed.
String durationOfAction = "durationOfAction_example"; // String | The time in seconds over which the cause would be expected to exert a measurable effect. We have selected a default value for each variable. This default value may be replaced by a user specified by adjusting their variable user settings.
String lastUpdated = "lastUpdated_example"; // String | The time that this measurement was last updated in the UTC format \"YYYY-MM-DDThh:mm:ss\"
Integer limit = 56; // Integer | The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0.
Integer offset = 56; // Integer | Now suppose you wanted to show results 11-20. You'd set the offset to 10 and the limit to 10.
Integer sort = 56; // Integer | Sort by given field. If the field is prefixed with `-, it will sort in descending order.
try {
    List<Correlation> result = apiInstance.v1AggregatedCorrelationsGet(accessToken, effect, cause, correlationCoefficient, onsetDelay, durationOfAction, lastUpdated, limit, offset, sort);
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
 **effect** | **String**| ORIGINAL variable name of the effect variable for which the user desires correlations | [optional]
 **cause** | **String**| ORIGINAL variable name of the cause variable for which the user desires correlations | [optional]
 **correlationCoefficient** | **String**| Pearson correlation coefficient between cause and effect after lagging by onset delay and grouping by duration of action | [optional]
 **onsetDelay** | **String**| The number of seconds which pass following a cause measurement before an effect would likely be observed. | [optional]
 **durationOfAction** | **String**| The time in seconds over which the cause would be expected to exert a measurable effect. We have selected a default value for each variable. This default value may be replaced by a user specified by adjusting their variable user settings. | [optional]
 **lastUpdated** | **String**| The time that this measurement was last updated in the UTC format \&quot;YYYY-MM-DDThh:mm:ss\&quot; | [optional]
 **limit** | **Integer**| The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. | [optional]
 **offset** | **Integer**| Now suppose you wanted to show results 11-20. You&#39;d set the offset to 10 and the limit to 10. | [optional]
 **sort** | **Integer**| Sort by given field. If the field is prefixed with &#x60;-, it will sort in descending order. | [optional]

### Return type

[**List&lt;Correlation&gt;**](Correlation.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1AggregatedCorrelationsPost"></a>
# **v1AggregatedCorrelationsPost**
> v1AggregatedCorrelationsPost(body, accessToken)

Store or Update a Correlation

Add correlation

### Example
```java
// Import classes:
//import io.swagger.client.api.CorrelationsApi;

CorrelationsApi apiInstance = new CorrelationsApi();
PostCorrelation body = new PostCorrelation(); // PostCorrelation | Provides correlation data
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
try {
    apiInstance.v1AggregatedCorrelationsPost(body, accessToken);
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

### Return type

null (empty response body)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1CorrelationsGet"></a>
# **v1CorrelationsGet**
> List&lt;Correlation&gt; v1CorrelationsGet(accessToken, effect, cause, correlationCoefficient, onsetDelay, durationOfAction, lastUpdated, limit, offset, sort)

Get correlations

Get correlations.&lt;br&gt;Supported filter parameters:&lt;br&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;correlationCoefficient&lt;/b&gt; - Pearson correlation coefficient between cause and effect after lagging by onset delay and grouping by duration of action&lt;/li&gt;&lt;li&gt;&lt;b&gt;onsetDelay&lt;/b&gt; - The number of seconds which pass following a cause measurement before an effect would likely be observed.&lt;/li&gt;&lt;li&gt;&lt;b&gt;durationOfAction&lt;/b&gt; - The time in seconds over which the cause would be expected to exert a measurable effect. We have selected a default value for each variable. This default value may be replaced by a user specified by adjusting their variable user settings.&lt;/li&gt;&lt;li&gt;&lt;b&gt;lastUpdated&lt;/b&gt; - The time that this measurement was last updated in the UTC format \&quot;YYYY-MM-DDThh:mm:ss\&quot;&lt;/li&gt;&lt;/ul&gt;&lt;br&gt;

### Example
```java
// Import classes:
//import io.swagger.client.api.CorrelationsApi;

CorrelationsApi apiInstance = new CorrelationsApi();
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
String effect = "effect_example"; // String | ORIGINAL variable name of the effect variable for which the user desires correlations
String cause = "cause_example"; // String | ORIGINAL variable name of the cause variable for which the user desires correlations
String correlationCoefficient = "correlationCoefficient_example"; // String | Pearson correlation coefficient between cause and effect after lagging by onset delay and grouping by duration of action
String onsetDelay = "onsetDelay_example"; // String | The number of seconds which pass following a cause measurement before an effect would likely be observed.
String durationOfAction = "durationOfAction_example"; // String | The time in seconds over which the cause would be expected to exert a measurable effect. We have selected a default value for each variable. This default value may be replaced by a user specified by adjusting their variable user settings.
String lastUpdated = "lastUpdated_example"; // String | The time that this measurement was last updated in the UTC format \"YYYY-MM-DDThh:mm:ss\"
Integer limit = 56; // Integer | The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0.
Integer offset = 56; // Integer | Now suppose you wanted to show results 11-20. You'd set the offset to 10 and the limit to 10.
Integer sort = 56; // Integer | Sort by given field. If the field is prefixed with `-, it will sort in descending order.
try {
    List<Correlation> result = apiInstance.v1CorrelationsGet(accessToken, effect, cause, correlationCoefficient, onsetDelay, durationOfAction, lastUpdated, limit, offset, sort);
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
 **effect** | **String**| ORIGINAL variable name of the effect variable for which the user desires correlations | [optional]
 **cause** | **String**| ORIGINAL variable name of the cause variable for which the user desires correlations | [optional]
 **correlationCoefficient** | **String**| Pearson correlation coefficient between cause and effect after lagging by onset delay and grouping by duration of action | [optional]
 **onsetDelay** | **String**| The number of seconds which pass following a cause measurement before an effect would likely be observed. | [optional]
 **durationOfAction** | **String**| The time in seconds over which the cause would be expected to exert a measurable effect. We have selected a default value for each variable. This default value may be replaced by a user specified by adjusting their variable user settings. | [optional]
 **lastUpdated** | **String**| The time that this measurement was last updated in the UTC format \&quot;YYYY-MM-DDThh:mm:ss\&quot; | [optional]
 **limit** | **Integer**| The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. | [optional]
 **offset** | **Integer**| Now suppose you wanted to show results 11-20. You&#39;d set the offset to 10 and the limit to 10. | [optional]
 **sort** | **Integer**| Sort by given field. If the field is prefixed with &#x60;-, it will sort in descending order. | [optional]

### Return type

[**List&lt;Correlation&gt;**](Correlation.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1OrganizationsOrganizationIdUsersUserIdVariablesVariableNameCausesGet"></a>
# **v1OrganizationsOrganizationIdUsersUserIdVariablesVariableNameCausesGet**
> List&lt;Correlation&gt; v1OrganizationsOrganizationIdUsersUserIdVariablesVariableNameCausesGet(organizationId, userId, variableName, organizationToken, accessToken, includePublic)

Search user correlations for a given cause

Returns average of all correlations and votes for all user cause variables for a given cause. If parameter \&quot;include_public\&quot; is used, it also returns public correlations. User correlation overwrites or supersedes public correlation.

### Example
```java
// Import classes:
//import io.swagger.client.api.CorrelationsApi;

CorrelationsApi apiInstance = new CorrelationsApi();
Integer organizationId = 56; // Integer | Organization ID
Integer userId = 56; // Integer | User id
String variableName = "variableName_example"; // String | Effect variable name
String organizationToken = "organizationToken_example"; // String | Organization access token
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
String includePublic = "includePublic_example"; // String | Include public correlations, Can be \"1\" or empty.
try {
    List<Correlation> result = apiInstance.v1OrganizationsOrganizationIdUsersUserIdVariablesVariableNameCausesGet(organizationId, userId, variableName, organizationToken, accessToken, includePublic);
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
 **userId** | **Integer**| User id |
 **variableName** | **String**| Effect variable name |
 **organizationToken** | **String**| Organization access token |
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]
 **includePublic** | **String**| Include public correlations, Can be \&quot;1\&quot; or empty. | [optional]

### Return type

[**List&lt;Correlation&gt;**](Correlation.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1OrganizationsOrganizationIdUsersUserIdVariablesVariableNameEffectsGet"></a>
# **v1OrganizationsOrganizationIdUsersUserIdVariablesVariableNameEffectsGet**
> List&lt;CommonResponse&gt; v1OrganizationsOrganizationIdUsersUserIdVariablesVariableNameEffectsGet(organizationId, userId, variableName, organizationToken, accessToken, includePublic)

Search user correlations for a given cause

Returns average of all correlations and votes for all user cause variables for a given effect. If parameter \&quot;include_public\&quot; is used, it also returns public correlations. User correlation overwrites or supersedes public correlation.

### Example
```java
// Import classes:
//import io.swagger.client.api.CorrelationsApi;

CorrelationsApi apiInstance = new CorrelationsApi();
Integer organizationId = 56; // Integer | Organization ID
Integer userId = 56; // Integer | User id
String variableName = "variableName_example"; // String | Cause variable name
String organizationToken = "organizationToken_example"; // String | Organization access token
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
String includePublic = "includePublic_example"; // String | Include public correlations, Can be \"1\" or empty.
try {
    List<CommonResponse> result = apiInstance.v1OrganizationsOrganizationIdUsersUserIdVariablesVariableNameEffectsGet(organizationId, userId, variableName, organizationToken, accessToken, includePublic);
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
 **userId** | **Integer**| User id |
 **variableName** | **String**| Cause variable name |
 **organizationToken** | **String**| Organization access token |
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]
 **includePublic** | **String**| Include public correlations, Can be \&quot;1\&quot; or empty. | [optional]

### Return type

[**List&lt;CommonResponse&gt;**](CommonResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1PublicCorrelationsSearchSearchGet"></a>
# **v1PublicCorrelationsSearchSearchGet**
> List&lt;Correlation&gt; v1PublicCorrelationsSearchSearchGet(search, effectOrCause, accessToken)

Get average correlations for variables containing search term

Returns the average correlations from all users for all public variables that contain the characters in the search query. Returns average of all users public variable correlations with a specified cause or effect.

### Example
```java
// Import classes:
//import io.swagger.client.api.CorrelationsApi;

CorrelationsApi apiInstance = new CorrelationsApi();
String search = "search_example"; // String | Name of the variable that you want to know the causes or effects of.
String effectOrCause = "effectOrCause_example"; // String | Setting this to effect indicates that the searched variable is the effect and that the causes of this variable should be returned.  cause indicates that the searched variable is the cause and the effects should be returned.
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
try {
    List<Correlation> result = apiInstance.v1PublicCorrelationsSearchSearchGet(search, effectOrCause, accessToken);
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
 **effectOrCause** | **String**| Setting this to effect indicates that the searched variable is the effect and that the causes of this variable should be returned.  cause indicates that the searched variable is the cause and the effects should be returned. |
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]

### Return type

[**List&lt;Correlation&gt;**](Correlation.md)

### Authorization

[oauth2](../README.md#oauth2)

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

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1VariablesVariableNameEffectsGet"></a>
# **v1VariablesVariableNameEffectsGet**
> List&lt;Correlation&gt; v1VariablesVariableNameEffectsGet(variableName, accessToken)

Search user correlations for a given cause

Returns average of all correlations and votes for all user effect variables for a given cause

### Example
```java
// Import classes:
//import io.swagger.client.api.CorrelationsApi;

CorrelationsApi apiInstance = new CorrelationsApi();
String variableName = "variableName_example"; // String | Cause variable name
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
try {
    List<Correlation> result = apiInstance.v1VariablesVariableNameEffectsGet(variableName, accessToken);
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

### Return type

[**List&lt;Correlation&gt;**](Correlation.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1VariablesVariableNamePublicCausesGet"></a>
# **v1VariablesVariableNamePublicCausesGet**
> List&lt;Correlation&gt; v1VariablesVariableNamePublicCausesGet(variableName, accessToken)

Search public correlations for a given effect

Returns average of all correlations and votes for all public cause variables for a given effect

### Example
```java
// Import classes:
//import io.swagger.client.api.CorrelationsApi;

CorrelationsApi apiInstance = new CorrelationsApi();
String variableName = "variableName_example"; // String | Effect variable name
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
try {
    List<Correlation> result = apiInstance.v1VariablesVariableNamePublicCausesGet(variableName, accessToken);
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

### Return type

[**List&lt;Correlation&gt;**](Correlation.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1VariablesVariableNamePublicEffectsGet"></a>
# **v1VariablesVariableNamePublicEffectsGet**
> List&lt;Correlation&gt; v1VariablesVariableNamePublicEffectsGet(variableName, accessToken)

Search public correlations for a given cause

Returns average of all correlations and votes for all public cause variables for a given cause

### Example
```java
// Import classes:
//import io.swagger.client.api.CorrelationsApi;

CorrelationsApi apiInstance = new CorrelationsApi();
String variableName = "variableName_example"; // String | Cause variable name
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
try {
    List<Correlation> result = apiInstance.v1VariablesVariableNamePublicEffectsGet(variableName, accessToken);
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

### Return type

[**List&lt;Correlation&gt;**](Correlation.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1VotesDeletePost"></a>
# **v1VotesDeletePost**
> CommonResponse v1VotesDeletePost(body, accessToken)

Delete vote

Delete previously posted vote

### Example
```java
// Import classes:
//import io.swagger.client.api.CorrelationsApi;

CorrelationsApi apiInstance = new CorrelationsApi();
VoteDelete body = new VoteDelete(); // VoteDelete | The cause and effect variable names for the predictor vote to be deleted.
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
try {
    CommonResponse result = apiInstance.v1VotesDeletePost(body, accessToken);
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

### Return type

[**CommonResponse**](CommonResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1VotesPost"></a>
# **v1VotesPost**
> CommonResponse v1VotesPost(body, accessToken)

Post or update vote

This is to enable users to indicate their opinion on the plausibility of a causal relationship between a treatment and outcome. QuantiModo incorporates crowd-sourced plausibility estimations into their algorithm. This is done allowing user to indicate their view of the plausibility of each relationship with thumbs up/down buttons placed next to each prediction.

### Example
```java
// Import classes:
//import io.swagger.client.api.CorrelationsApi;

CorrelationsApi apiInstance = new CorrelationsApi();
PostVote body = new PostVote(); // PostVote | Contains the cause variable, effect variable, and vote value.
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
try {
    CommonResponse result = apiInstance.v1VotesPost(body, accessToken);
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

### Return type

[**CommonResponse**](CommonResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

