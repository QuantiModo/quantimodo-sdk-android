# ConnectorsApi

All URIs are relative to *https://app.quantimo.do/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**v1ConnectJsGet**](ConnectorsApi.md#v1ConnectJsGet) | **GET** /v1/connect.js | Get embeddable connect javascript
[**v1ConnectMobileGet**](ConnectorsApi.md#v1ConnectMobileGet) | **GET** /v1/connect/mobile | Mobile connect page
[**v1ConnectorsConnectorConnectGet**](ConnectorsApi.md#v1ConnectorsConnectorConnectGet) | **GET** /v1/connectors/{connector}/connect | Obtain a token from 3rd party data source
[**v1ConnectorsConnectorConnectInstructionsGet**](ConnectorsApi.md#v1ConnectorsConnectorConnectInstructionsGet) | **GET** /v1/connectors/{connector}/connectInstructions | Connection Instructions
[**v1ConnectorsConnectorConnectParameterGet**](ConnectorsApi.md#v1ConnectorsConnectorConnectParameterGet) | **GET** /v1/connectors/{connector}/connectParameter | Connect Parameter
[**v1ConnectorsConnectorDisconnectGet**](ConnectorsApi.md#v1ConnectorsConnectorDisconnectGet) | **GET** /v1/connectors/{connector}/disconnect | Delete stored connection info
[**v1ConnectorsConnectorInfoGet**](ConnectorsApi.md#v1ConnectorsConnectorInfoGet) | **GET** /v1/connectors/{connector}/info | Get connector info for user
[**v1ConnectorsConnectorUpdateGet**](ConnectorsApi.md#v1ConnectorsConnectorUpdateGet) | **GET** /v1/connectors/{connector}/update | Sync with data source
[**v1ConnectorsListGet**](ConnectorsApi.md#v1ConnectorsListGet) | **GET** /v1/connectors/list | List of Connectors


<a name="v1ConnectJsGet"></a>
# **v1ConnectJsGet**
> v1ConnectJsGet(accessToken)

Get embeddable connect javascript

Get embeddable connect javascript. Usage:    - Embedding in applications with popups for 3rd-party authentication windows.      Use &#x60;qmSetupInPopup&#x60; function after connecting &#x60;connect.js&#x60;.    - Embedding in applications with popups for 3rd-party authentication windows.      Requires a selector to block. It will be embedded in this block.      Use &#x60;qmSetupOnPage&#x60; function after connecting &#x60;connect.js&#x60;.    - Embedding in mobile applications without popups for 3rd-party authentication.      Use &#x60;qmSetupOnMobile&#x60; function after connecting &#x60;connect.js&#x60;.      if using the MoodiModo Clones, Use &#x60;qmSetupOnIonic&#x60; function after connecting &#x60;connect.js&#x60;. 

### Example
```java
// Import classes:
//import io.swagger.client.api.ConnectorsApi;

ConnectorsApi apiInstance = new ConnectorsApi();
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
try {
    apiInstance.v1ConnectJsGet(accessToken);
} catch (ApiException e) {
    System.err.println("Exception when calling ConnectorsApi#v1ConnectJsGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]

### Return type

null (empty response body)

### Authorization

[oauth2](../README.md#oauth2), [internalApiKey](../README.md#internalApiKey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/x-javascript

<a name="v1ConnectMobileGet"></a>
# **v1ConnectMobileGet**
> v1ConnectMobileGet(accessToken)

Mobile connect page

This page is designed to be opened in a webview.  Instead of using popup authentication boxes, it uses redirection. You can include the user&#39;s access_token as a URL parameter like https://app.quantimo.do/api/v1/connect/mobile?access_token&#x3D;123

### Example
```java
// Import classes:
//import io.swagger.client.api.ConnectorsApi;

ConnectorsApi apiInstance = new ConnectorsApi();
String accessToken = "accessToken_example"; // String | User OAuth access token
try {
    apiInstance.v1ConnectMobileGet(accessToken);
} catch (ApiException e) {
    System.err.println("Exception when calling ConnectorsApi#v1ConnectMobileGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accessToken** | **String**| User OAuth access token |

### Return type

null (empty response body)

### Authorization

[oauth2](../README.md#oauth2), [internalApiKey](../README.md#internalApiKey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/html

<a name="v1ConnectorsConnectorConnectGet"></a>
# **v1ConnectorsConnectorConnectGet**
> v1ConnectorsConnectorConnectGet(connector, accessToken)

Obtain a token from 3rd party data source

Attempt to obtain a token from the data provider, store it in the database. With this, the connector to continue to obtain new user data until the token is revoked.

### Example
```java
// Import classes:
//import io.swagger.client.api.ConnectorsApi;

ConnectorsApi apiInstance = new ConnectorsApi();
String connector = "connector_example"; // String | Lowercase system name of the source application or device. Get a list of available connectors from the /connectors/list endpoint.
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
try {
    apiInstance.v1ConnectorsConnectorConnectGet(connector, accessToken);
} catch (ApiException e) {
    System.err.println("Exception when calling ConnectorsApi#v1ConnectorsConnectorConnectGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **connector** | **String**| Lowercase system name of the source application or device. Get a list of available connectors from the /connectors/list endpoint. |
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]

### Return type

null (empty response body)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1ConnectorsConnectorConnectInstructionsGet"></a>
# **v1ConnectorsConnectorConnectInstructionsGet**
> v1ConnectorsConnectorConnectInstructionsGet(connector, parameters, url, usePopup, accessToken)

Connection Instructions

Returns instructions that describe what parameters and endpoint to use to connect to the given data provider.

### Example
```java
// Import classes:
//import io.swagger.client.api.ConnectorsApi;

ConnectorsApi apiInstance = new ConnectorsApi();
String connector = "connector_example"; // String | Lowercase system name of the source application or device. Get a list of available connectors from the /connectors/list endpoint.
String parameters = "parameters_example"; // String | JSON Array of Parameters for the request to enable connector.
String url = "url_example"; // String | URL which should be used to enable the connector.
Boolean usePopup = true; // Boolean | Should use popup when enabling connector
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
try {
    apiInstance.v1ConnectorsConnectorConnectInstructionsGet(connector, parameters, url, usePopup, accessToken);
} catch (ApiException e) {
    System.err.println("Exception when calling ConnectorsApi#v1ConnectorsConnectorConnectInstructionsGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **connector** | **String**| Lowercase system name of the source application or device. Get a list of available connectors from the /connectors/list endpoint. |
 **parameters** | **String**| JSON Array of Parameters for the request to enable connector. |
 **url** | **String**| URL which should be used to enable the connector. |
 **usePopup** | **Boolean**| Should use popup when enabling connector |
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]

### Return type

null (empty response body)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1ConnectorsConnectorConnectParameterGet"></a>
# **v1ConnectorsConnectorConnectParameterGet**
> ConnectorInstruction v1ConnectorsConnectorConnectParameterGet(connector, displayName, key, placeholder, type, usePopup, accessToken, defaultValue)

Connect Parameter

Returns instructions that describe what parameters and endpoint to use to connect to the given data provider.

### Example
```java
// Import classes:
//import io.swagger.client.api.ConnectorsApi;

ConnectorsApi apiInstance = new ConnectorsApi();
String connector = "connector_example"; // String | Lowercase system name of the source application or device. Get a list of available connectors from the /connectors/list endpoint.
String displayName = "displayName_example"; // String | Name of the parameter that is user visible in the form
String key = "key_example"; // String | Name of the property that the user has to enter such as username or password Connector (used in HTTP request)
String placeholder = "placeholder_example"; // String | Placeholder hint value for the parameter input tag.
String type = "type_example"; // String | Type of input field such as those found here http://www.w3schools.com/tags/tag_input.asp
Boolean usePopup = true; // Boolean | Should use popup when enabling connector
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
String defaultValue = "defaultValue_example"; // String | Default parameter value
try {
    ConnectorInstruction result = apiInstance.v1ConnectorsConnectorConnectParameterGet(connector, displayName, key, placeholder, type, usePopup, accessToken, defaultValue);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConnectorsApi#v1ConnectorsConnectorConnectParameterGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **connector** | **String**| Lowercase system name of the source application or device. Get a list of available connectors from the /connectors/list endpoint. |
 **displayName** | **String**| Name of the parameter that is user visible in the form |
 **key** | **String**| Name of the property that the user has to enter such as username or password Connector (used in HTTP request) |
 **placeholder** | **String**| Placeholder hint value for the parameter input tag. |
 **type** | **String**| Type of input field such as those found here http://www.w3schools.com/tags/tag_input.asp |
 **usePopup** | **Boolean**| Should use popup when enabling connector |
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]
 **defaultValue** | **String**| Default parameter value | [optional]

### Return type

[**ConnectorInstruction**](ConnectorInstruction.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1ConnectorsConnectorDisconnectGet"></a>
# **v1ConnectorsConnectorDisconnectGet**
> v1ConnectorsConnectorDisconnectGet(connector)

Delete stored connection info

The disconnect method deletes any stored tokens or connection information from the connectors database.

### Example
```java
// Import classes:
//import io.swagger.client.api.ConnectorsApi;

ConnectorsApi apiInstance = new ConnectorsApi();
String connector = "connector_example"; // String | Lowercase system name of the source application or device. Get a list of available connectors from the /connectors/list endpoint.
try {
    apiInstance.v1ConnectorsConnectorDisconnectGet(connector);
} catch (ApiException e) {
    System.err.println("Exception when calling ConnectorsApi#v1ConnectorsConnectorDisconnectGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **connector** | **String**| Lowercase system name of the source application or device. Get a list of available connectors from the /connectors/list endpoint. |

### Return type

null (empty response body)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1ConnectorsConnectorInfoGet"></a>
# **v1ConnectorsConnectorInfoGet**
> ConnectorInfo v1ConnectorsConnectorInfoGet(connector, accessToken)

Get connector info for user

Returns information about the connector such as the connector id, whether or not is connected for this user (i.e. we have a token or credentials), and its update history for the user.

### Example
```java
// Import classes:
//import io.swagger.client.api.ConnectorsApi;

ConnectorsApi apiInstance = new ConnectorsApi();
String connector = "connector_example"; // String | Lowercase system name of the source application or device. Get a list of available connectors from the /connectors/list endpoint.
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
try {
    ConnectorInfo result = apiInstance.v1ConnectorsConnectorInfoGet(connector, accessToken);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConnectorsApi#v1ConnectorsConnectorInfoGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **connector** | **String**| Lowercase system name of the source application or device. Get a list of available connectors from the /connectors/list endpoint. |
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]

### Return type

[**ConnectorInfo**](ConnectorInfo.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1ConnectorsConnectorUpdateGet"></a>
# **v1ConnectorsConnectorUpdateGet**
> v1ConnectorsConnectorUpdateGet(connector, accessToken)

Sync with data source

The update method tells the QM Connector Framework to check with the data provider (such as Fitbit or MyFitnessPal) and retrieve any new measurements available.

### Example
```java
// Import classes:
//import io.swagger.client.api.ConnectorsApi;

ConnectorsApi apiInstance = new ConnectorsApi();
String connector = "connector_example"; // String | Lowercase system name of the source application or device
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
try {
    apiInstance.v1ConnectorsConnectorUpdateGet(connector, accessToken);
} catch (ApiException e) {
    System.err.println("Exception when calling ConnectorsApi#v1ConnectorsConnectorUpdateGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **connector** | **String**| Lowercase system name of the source application or device |
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]

### Return type

null (empty response body)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1ConnectorsListGet"></a>
# **v1ConnectorsListGet**
> List&lt;Connector&gt; v1ConnectorsListGet()

List of Connectors

A connector pulls data from other data providers using their API or a screenscraper. Returns a list of all available connectors and information about them such as their id, name, whether the user has provided access, logo url, connection instructions, and the update history.

### Example
```java
// Import classes:
//import io.swagger.client.api.ConnectorsApi;

ConnectorsApi apiInstance = new ConnectorsApi();
try {
    List<Connector> result = apiInstance.v1ConnectorsListGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConnectorsApi#v1ConnectorsListGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Connector&gt;**](Connector.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

