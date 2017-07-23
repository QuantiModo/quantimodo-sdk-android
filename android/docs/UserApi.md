# UserApi

All URIs are relative to *https://app.quantimo.do/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**v1OrganizationsOrganizationIdUsersPost**](UserApi.md#v1OrganizationsOrganizationIdUsersPost) | **POST** /v1/organizations/{organizationId}/users | Get user tokens for existing users, create new users
[**v1UserMeGet**](UserApi.md#v1UserMeGet) | **GET** /v1/user/me | Get all available units for variableGet authenticated user


<a name="v1OrganizationsOrganizationIdUsersPost"></a>
# **v1OrganizationsOrganizationIdUsersPost**
> UserTokenSuccessfulResponse v1OrganizationsOrganizationIdUsersPost(organizationId, body, accessToken, userId)

Get user tokens for existing users, create new users

Get user tokens for existing users, create new users

### Example
```java
// Import classes:
//import io.swagger.client.api.UserApi;

UserApi apiInstance = new UserApi();
Integer organizationId = 56; // Integer | Organization ID
UserTokenRequest body = new UserTokenRequest(); // UserTokenRequest | Provides organization token and user ID
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
Integer userId = 56; // Integer | User's id
try {
    UserTokenSuccessfulResponse result = apiInstance.v1OrganizationsOrganizationIdUsersPost(organizationId, body, accessToken, userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#v1OrganizationsOrganizationIdUsersPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **organizationId** | **Integer**| Organization ID |
 **body** | [**UserTokenRequest**](UserTokenRequest.md)| Provides organization token and user ID |
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]
 **userId** | **Integer**| User&#39;s id | [optional]

### Return type

[**UserTokenSuccessfulResponse**](UserTokenSuccessfulResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1UserMeGet"></a>
# **v1UserMeGet**
> User v1UserMeGet()

Get all available units for variableGet authenticated user

Returns user info for the currently authenticated user.

### Example
```java
// Import classes:
//import io.swagger.client.api.UserApi;

UserApi apiInstance = new UserApi();
try {
    User result = apiInstance.v1UserMeGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#v1UserMeGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**User**](User.md)

### Authorization

[access_token](../README.md#access_token), [quantimodo_oauth2](../README.md#quantimodo_oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

