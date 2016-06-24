# VariablesApi

All URIs are relative to *https://app.quantimo.do/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**v1PublicVariablesGet**](VariablesApi.md#v1PublicVariablesGet) | **GET** /v1/public/variables | Get public variables
[**v1PublicVariablesSearchSearchGet**](VariablesApi.md#v1PublicVariablesSearchSearchGet) | **GET** /v1/public/variables/search/{search} | Get top 5 PUBLIC variables with the most correlations
[**v1UserVariablesPost**](VariablesApi.md#v1UserVariablesPost) | **POST** /v1/userVariables | Update User Settings for a Variable
[**v1VariableCategoriesGet**](VariablesApi.md#v1VariableCategoriesGet) | **GET** /v1/variableCategories | Variable categories
[**v1VariablesGet**](VariablesApi.md#v1VariablesGet) | **GET** /v1/variables | Get variables by the category name
[**v1VariablesPost**](VariablesApi.md#v1VariablesPost) | **POST** /v1/variables | Create Variables
[**v1VariablesSearchSearchGet**](VariablesApi.md#v1VariablesSearchSearchGet) | **GET** /v1/variables/search/{search} | Get variables by search query
[**v1VariablesVariableNameGet**](VariablesApi.md#v1VariablesVariableNameGet) | **GET** /v1/variables/{variableName} | Get info about a variable


<a name="v1PublicVariablesGet"></a>
# **v1PublicVariablesGet**
> Variable v1PublicVariablesGet()

Get public variables

This endpoint retrieves an array of all public variables. Public variables are things like foods, medications, symptoms, conditions, and anything not unique to a particular user. For instance, a telephone number or name would not be a public variable.

### Example
```java
// Import classes:
//import io.swagger.client.api.VariablesApi;

VariablesApi apiInstance = new VariablesApi();
try {
    Variable result = apiInstance.v1PublicVariablesGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VariablesApi#v1PublicVariablesGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Variable**](Variable.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1PublicVariablesSearchSearchGet"></a>
# **v1PublicVariablesSearchSearchGet**
> Variable v1PublicVariablesSearchSearchGet(search, accessToken, categoryName, source, effectOrCause, publicEffectOrCause, limit, offset, sort)

Get top 5 PUBLIC variables with the most correlations

Get top 5 PUBLIC variables with the most correlations containing the entered search characters. For example, search for &#39;mood&#39; as an effect. Since &#39;Overall Mood&#39; has a lot of correlations with other variables, it should be in the autocomplete list.&lt;br&gt;Supported filter parameters:&lt;br&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;category&lt;/b&gt; - Category of Variable&lt;/li&gt;&lt;/ul&gt;&lt;br&gt;

### Example
```java
// Import classes:
//import io.swagger.client.api.VariablesApi;

VariablesApi apiInstance = new VariablesApi();
String search = "search_example"; // String | Search query can be some fraction of a variable name.
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
String categoryName = "categoryName_example"; // String | Filter variables by category name. The variable categories include Activity, Causes of Illness, Cognitive Performance, Conditions, Environment, Foods, Location, Miscellaneous, Mood, Nutrition, Physical Activity, Physique, Sleep, Social Interactions, Symptoms, Treatments, Vital Signs, and Work.
String source = "source_example"; // String | Specify a data source name to only return variables from a specific data source.
String effectOrCause = "effectOrCause_example"; // String | Indicate if you only want variables that have user correlations.  Possible values are effect and cause.
String publicEffectOrCause = "publicEffectOrCause_example"; // String | Indicate if you only want variables that have aggregated correlations.  Possible values are effect and cause.
Integer limit = 56; // Integer | The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0.
Integer offset = 56; // Integer | Now suppose you wanted to show results 11-20. You'd set the offset to 10 and the limit to 10.
Integer sort = 56; // Integer | Sort by given field. If the field is prefixed with `-, it will sort in descending order.
try {
    Variable result = apiInstance.v1PublicVariablesSearchSearchGet(search, accessToken, categoryName, source, effectOrCause, publicEffectOrCause, limit, offset, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VariablesApi#v1PublicVariablesSearchSearchGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **search** | **String**| Search query can be some fraction of a variable name. |
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]
 **categoryName** | **String**| Filter variables by category name. The variable categories include Activity, Causes of Illness, Cognitive Performance, Conditions, Environment, Foods, Location, Miscellaneous, Mood, Nutrition, Physical Activity, Physique, Sleep, Social Interactions, Symptoms, Treatments, Vital Signs, and Work. | [optional]
 **source** | **String**| Specify a data source name to only return variables from a specific data source. | [optional]
 **effectOrCause** | **String**| Indicate if you only want variables that have user correlations.  Possible values are effect and cause. | [optional]
 **publicEffectOrCause** | **String**| Indicate if you only want variables that have aggregated correlations.  Possible values are effect and cause. | [optional]
 **limit** | **Integer**| The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. | [optional]
 **offset** | **Integer**| Now suppose you wanted to show results 11-20. You&#39;d set the offset to 10 and the limit to 10. | [optional]
 **sort** | **Integer**| Sort by given field. If the field is prefixed with &#x60;-, it will sort in descending order. | [optional]

### Return type

[**Variable**](Variable.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1UserVariablesPost"></a>
# **v1UserVariablesPost**
> v1UserVariablesPost(userVariables)

Update User Settings for a Variable

Users can change the parameters used in analysis of that variable such as the expected duration of action for a variable to have an effect, the estimated delay before the onset of action. In order to filter out erroneous data, they are able to set the maximum and minimum reasonable daily values for a variable.

### Example
```java
// Import classes:
//import io.swagger.client.api.VariablesApi;

VariablesApi apiInstance = new VariablesApi();
UserVariables userVariables = new UserVariables(); // UserVariables | Variable user settings data
try {
    apiInstance.v1UserVariablesPost(userVariables);
} catch (ApiException e) {
    System.err.println("Exception when calling VariablesApi#v1UserVariablesPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userVariables** | [**UserVariables**](UserVariables.md)| Variable user settings data |

### Return type

null (empty response body)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1VariableCategoriesGet"></a>
# **v1VariableCategoriesGet**
> List&lt;VariableCategory&gt; v1VariableCategoriesGet()

Variable categories

The variable categories include Activity, Causes of Illness, Cognitive Performance, Conditions, Environment, Foods, Location, Miscellaneous, Mood, Nutrition, Physical Activity, Physique, Sleep, Social Interactions, Symptoms, Treatments, Vital Signs, and Work.

### Example
```java
// Import classes:
//import io.swagger.client.api.VariablesApi;

VariablesApi apiInstance = new VariablesApi();
try {
    List<VariableCategory> result = apiInstance.v1VariableCategoriesGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VariablesApi#v1VariableCategoriesGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;VariableCategory&gt;**](VariableCategory.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1VariablesGet"></a>
# **v1VariablesGet**
> Variable v1VariablesGet(accessToken, id, userId, category, name, lastUpdated, source, latestMeasurementTime, numberOfMeasurements, lastSource, limit, offset, sort)

Get variables by the category name

Get variables by the category name. &lt;br&gt;Supported filter parameters:&lt;br&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;name&lt;/b&gt; - Original name of the variable (supports exact name match only)&lt;/li&gt;&lt;li&gt;&lt;b&gt;lastUpdated&lt;/b&gt; - Filter by the last time any of the properties of the variable were changed. Uses UTC format \&quot;YYYY-MM-DDThh:mm:ss\&quot;&lt;/li&gt;&lt;li&gt;&lt;b&gt;source&lt;/b&gt; - The name of the data source that created the variable (supports exact name match only). So if you have a client application and you only want variables that were last updated by your app, you can include the name of your app here&lt;/li&gt;&lt;li&gt;&lt;b&gt;latestMeasurementTime&lt;/b&gt; - Filter variables based on the last time a measurement for them was created or updated in the UTC format \&quot;YYYY-MM-DDThh:mm:ss\&quot;&lt;/li&gt;&lt;li&gt;&lt;b&gt;numberOfMeasurements&lt;/b&gt; - Filter variables by the total number of measurements that they have. This could be used of you want to filter or sort by popularity.&lt;/li&gt;&lt;li&gt;&lt;b&gt;lastSource&lt;/b&gt; - Limit variables to those which measurements were last submitted by a specific source. So if you have a client application and you only want variables that were last updated by your app, you can include the name of your app here. (supports exact name match only)&lt;/li&gt;&lt;/ul&gt;&lt;br&gt;

### Example
```java
// Import classes:
//import io.swagger.client.api.VariablesApi;

VariablesApi apiInstance = new VariablesApi();
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
Integer id = 56; // Integer | Common variable id
Integer userId = 56; // Integer | User id
String category = "category_example"; // String | Filter data by category
String name = "name_example"; // String | Original name of the variable (supports exact name match only)
String lastUpdated = "lastUpdated_example"; // String | Filter by the last time any of the properties of the variable were changed. Uses UTC format \"YYYY-MM-DDThh:mm:ss\"
String source = "source_example"; // String | The name of the data source that created the variable (supports exact name match only). So if you have a client application and you only want variables that were last updated by your app, you can include the name of your app here
String latestMeasurementTime = "latestMeasurementTime_example"; // String | Filter variables based on the last time a measurement for them was created or updated in the UTC format \"YYYY-MM-DDThh:mm:ss\"
String numberOfMeasurements = "numberOfMeasurements_example"; // String | Filter variables by the total number of measurements that they have. This could be used of you want to filter or sort by popularity.
String lastSource = "lastSource_example"; // String | Limit variables to those which measurements were last submitted by a specific source. So if you have a client application and you only want variables that were last updated by your app, you can include the name of your app here. (supports exact name match only)
Integer limit = 56; // Integer | The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0.
Integer offset = 56; // Integer | Now suppose you wanted to show results 11-20. You'd set the offset to 10 and the limit to 10.
Integer sort = 56; // Integer | Sort by given field. If the field is prefixed with `-, it will sort in descending order.
try {
    Variable result = apiInstance.v1VariablesGet(accessToken, id, userId, category, name, lastUpdated, source, latestMeasurementTime, numberOfMeasurements, lastSource, limit, offset, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VariablesApi#v1VariablesGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]
 **id** | **Integer**| Common variable id | [optional]
 **userId** | **Integer**| User id | [optional]
 **category** | **String**| Filter data by category | [optional]
 **name** | **String**| Original name of the variable (supports exact name match only) | [optional]
 **lastUpdated** | **String**| Filter by the last time any of the properties of the variable were changed. Uses UTC format \&quot;YYYY-MM-DDThh:mm:ss\&quot; | [optional]
 **source** | **String**| The name of the data source that created the variable (supports exact name match only). So if you have a client application and you only want variables that were last updated by your app, you can include the name of your app here | [optional]
 **latestMeasurementTime** | **String**| Filter variables based on the last time a measurement for them was created or updated in the UTC format \&quot;YYYY-MM-DDThh:mm:ss\&quot; | [optional]
 **numberOfMeasurements** | **String**| Filter variables by the total number of measurements that they have. This could be used of you want to filter or sort by popularity. | [optional]
 **lastSource** | **String**| Limit variables to those which measurements were last submitted by a specific source. So if you have a client application and you only want variables that were last updated by your app, you can include the name of your app here. (supports exact name match only) | [optional]
 **limit** | **Integer**| The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. | [optional]
 **offset** | **Integer**| Now suppose you wanted to show results 11-20. You&#39;d set the offset to 10 and the limit to 10. | [optional]
 **sort** | **Integer**| Sort by given field. If the field is prefixed with &#x60;-, it will sort in descending order. | [optional]

### Return type

[**Variable**](Variable.md)

### Authorization

[oauth2](../README.md#oauth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1VariablesPost"></a>
# **v1VariablesPost**
> v1VariablesPost(body, accessToken)

Create Variables

Allows the client to create a new variable in the &#x60;variables&#x60; table.

### Example
```java
// Import classes:
//import io.swagger.client.api.VariablesApi;

VariablesApi apiInstance = new VariablesApi();
VariablesNew body = new VariablesNew(); // VariablesNew | Original name for the variable.
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
try {
    apiInstance.v1VariablesPost(body, accessToken);
} catch (ApiException e) {
    System.err.println("Exception when calling VariablesApi#v1VariablesPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**VariablesNew**](VariablesNew.md)| Original name for the variable. |
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]

### Return type

null (empty response body)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1VariablesSearchSearchGet"></a>
# **v1VariablesSearchSearchGet**
> List&lt;Variable&gt; v1VariablesSearchSearchGet(search, accessToken, categoryName, includePublic, manualTracking, source, effectOrCause, publicEffectOrCause, limit, offset)

Get variables by search query

Get variables containing the search characters for which the currently logged in user has measurements. Used to provide auto-complete function in variable search boxes.

### Example
```java
// Import classes:
//import io.swagger.client.api.VariablesApi;

VariablesApi apiInstance = new VariablesApi();
String search = "search_example"; // String | Search query which may be an entire variable name or a fragment of one.
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
String categoryName = "categoryName_example"; // String | Filter variables by category name. The variable categories include Activity, Causes of Illness, Cognitive Performance, Conditions, Environment, Foods, Location, Miscellaneous, Mood, Nutrition, Physical Activity, Physique, Sleep, Social Interactions, Symptoms, Treatments, Vital Signs, and Work.
Boolean includePublic = true; // Boolean | Set to true if you would like to include public variables when no user variables are found.
Boolean manualTracking = true; // Boolean | Set to true if you would like to exlude variables like apps and website names.
String source = "source_example"; // String | Specify a data source name to only return variables from a specific data source.
String effectOrCause = "effectOrCause_example"; // String | Indicate if you only want variables that have user correlations.  Possible values are effect and cause.
String publicEffectOrCause = "publicEffectOrCause_example"; // String | Indicate if you only want variables that have aggregated correlations.  Possible values are effect and cause.
Integer limit = 56; // Integer | The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0.
Integer offset = 56; // Integer | Now suppose you wanted to show results 11-20. You'd set the offset to 10 and the limit to 10.
try {
    List<Variable> result = apiInstance.v1VariablesSearchSearchGet(search, accessToken, categoryName, includePublic, manualTracking, source, effectOrCause, publicEffectOrCause, limit, offset);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VariablesApi#v1VariablesSearchSearchGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **search** | **String**| Search query which may be an entire variable name or a fragment of one. |
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]
 **categoryName** | **String**| Filter variables by category name. The variable categories include Activity, Causes of Illness, Cognitive Performance, Conditions, Environment, Foods, Location, Miscellaneous, Mood, Nutrition, Physical Activity, Physique, Sleep, Social Interactions, Symptoms, Treatments, Vital Signs, and Work. | [optional]
 **includePublic** | **Boolean**| Set to true if you would like to include public variables when no user variables are found. | [optional]
 **manualTracking** | **Boolean**| Set to true if you would like to exlude variables like apps and website names. | [optional]
 **source** | **String**| Specify a data source name to only return variables from a specific data source. | [optional]
 **effectOrCause** | **String**| Indicate if you only want variables that have user correlations.  Possible values are effect and cause. | [optional]
 **publicEffectOrCause** | **String**| Indicate if you only want variables that have aggregated correlations.  Possible values are effect and cause. | [optional]
 **limit** | **Integer**| The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. | [optional]
 **offset** | **Integer**| Now suppose you wanted to show results 11-20. You&#39;d set the offset to 10 and the limit to 10. | [optional]

### Return type

[**List&lt;Variable&gt;**](Variable.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1VariablesVariableNameGet"></a>
# **v1VariablesVariableNameGet**
> Variable v1VariablesVariableNameGet(variableName, accessToken)

Get info about a variable

Get all of the settings and information about a variable by its name. If the logged in user has modified the settings for the variable, these will be provided instead of the default settings for that variable.

### Example
```java
// Import classes:
//import io.swagger.client.api.VariablesApi;

VariablesApi apiInstance = new VariablesApi();
String variableName = "variableName_example"; // String | Variable name
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
try {
    Variable result = apiInstance.v1VariablesVariableNameGet(variableName, accessToken);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VariablesApi#v1VariablesVariableNameGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **variableName** | **String**| Variable name |
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]

### Return type

[**Variable**](Variable.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

