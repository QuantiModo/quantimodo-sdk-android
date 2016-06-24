# UnitsApi

All URIs are relative to *https://app.quantimo.do/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**v1UnitCategoriesGet**](UnitsApi.md#v1UnitCategoriesGet) | **GET** /v1/unitCategories | Get unit categories
[**v1UnitsGet**](UnitsApi.md#v1UnitsGet) | **GET** /v1/units | Get all available units
[**v1UnitsVariableGet**](UnitsApi.md#v1UnitsVariableGet) | **GET** /v1/unitsVariable | Units for Variable


<a name="v1UnitCategoriesGet"></a>
# **v1UnitCategoriesGet**
> UnitCategory v1UnitCategoriesGet()

Get unit categories

Get a list of the categories of measurement units such as &#39;Distance&#39;, &#39;Duration&#39;, &#39;Energy&#39;, &#39;Frequency&#39;, &#39;Miscellany&#39;, &#39;Pressure&#39;, &#39;Proportion&#39;, &#39;Rating&#39;, &#39;Temperature&#39;, &#39;Volume&#39;, and &#39;Weight&#39;.

### Example
```java
// Import classes:
//import io.swagger.client.api.UnitsApi;

UnitsApi apiInstance = new UnitsApi();
try {
    UnitCategory result = apiInstance.v1UnitCategoriesGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UnitsApi#v1UnitCategoriesGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**UnitCategory**](UnitCategory.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1UnitsGet"></a>
# **v1UnitsGet**
> List&lt;Unit&gt; v1UnitsGet(accessToken, id, unitName, abbreviatedUnitName, categoryName)

Get all available units

Get all available units

### Example
```java
// Import classes:
//import io.swagger.client.api.UnitsApi;

UnitsApi apiInstance = new UnitsApi();
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
Integer id = 56; // Integer | Unit id
String unitName = "unitName_example"; // String | Unit name
String abbreviatedUnitName = "abbreviatedUnitName_example"; // String | Restrict the results to a specific unit by providing the unit abbreviation.
String categoryName = "categoryName_example"; // String | Restrict the results to a specific unit category by providing the unit category name.
try {
    List<Unit> result = apiInstance.v1UnitsGet(accessToken, id, unitName, abbreviatedUnitName, categoryName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UnitsApi#v1UnitsGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]
 **id** | **Integer**| Unit id | [optional]
 **unitName** | **String**| Unit name | [optional]
 **abbreviatedUnitName** | **String**| Restrict the results to a specific unit by providing the unit abbreviation. | [optional]
 **categoryName** | **String**| Restrict the results to a specific unit category by providing the unit category name. | [optional]

### Return type

[**List&lt;Unit&gt;**](Unit.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1UnitsVariableGet"></a>
# **v1UnitsVariableGet**
> List&lt;Unit&gt; v1UnitsVariableGet(accessToken, unitName, abbreviatedUnitName, categoryName, variable)

Units for Variable

Get a list of all possible units to use for a given variable

### Example
```java
// Import classes:
//import io.swagger.client.api.UnitsApi;

UnitsApi apiInstance = new UnitsApi();
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
String unitName = "unitName_example"; // String | Name of Unit you want to retrieve
String abbreviatedUnitName = "abbreviatedUnitName_example"; // String | Abbreviated Unit Name of the unit you want
String categoryName = "categoryName_example"; // String | Name of the category you want units for
String variable = "variable_example"; // String | Name of the variable you want units for
try {
    List<Unit> result = apiInstance.v1UnitsVariableGet(accessToken, unitName, abbreviatedUnitName, categoryName, variable);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UnitsApi#v1UnitsVariableGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]
 **unitName** | **String**| Name of Unit you want to retrieve | [optional]
 **abbreviatedUnitName** | **String**| Abbreviated Unit Name of the unit you want | [optional]
 **categoryName** | **String**| Name of the category you want units for | [optional]
 **variable** | **String**| Name of the variable you want units for | [optional]

### Return type

[**List&lt;Unit&gt;**](Unit.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

