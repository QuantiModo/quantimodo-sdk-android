# TagsApi

All URIs are relative to *https://app.quantimo.do/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**v1UserTagsDeletePost**](TagsApi.md#v1UserTagsDeletePost) | **POST** /v1/userTags/delete | Delete user tag or ingredient
[**v1UserTagsPost**](TagsApi.md#v1UserTagsPost) | **POST** /v1/userTags | Post or update user tags or ingredients


<a name="v1UserTagsDeletePost"></a>
# **v1UserTagsDeletePost**
> CommonResponse v1UserTagsDeletePost(taggedVariableId, tagVariableId)

Delete user tag or ingredient

Delete previously created user tags or ingredients.

### Example
```java
// Import classes:
//import io.swagger.client.api.TagsApi;

TagsApi apiInstance = new TagsApi();
Integer taggedVariableId = 56; // Integer | This is the id of the variable being tagged with an ingredient or something.
Integer tagVariableId = 56; // Integer | This is the id of the ingredient variable whose value is determined based on the value of the tagged variable.
try {
    CommonResponse result = apiInstance.v1UserTagsDeletePost(taggedVariableId, tagVariableId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TagsApi#v1UserTagsDeletePost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **taggedVariableId** | **Integer**| This is the id of the variable being tagged with an ingredient or something. |
 **tagVariableId** | **Integer**| This is the id of the ingredient variable whose value is determined based on the value of the tagged variable. |

### Return type

[**CommonResponse**](CommonResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="v1UserTagsPost"></a>
# **v1UserTagsPost**
> CommonResponse v1UserTagsPost(body, accessToken)

Post or update user tags or ingredients

This endpoint allows users to tag foods with their ingredients.  This information will then be used to infer the user intake of the different ingredients by just entering the foods. The inferred intake levels will then be used to determine the effects of different nutrients on the user during analysis.

### Example
```java
// Import classes:
//import io.swagger.client.api.TagsApi;

TagsApi apiInstance = new TagsApi();
UserTag body = new UserTag(); // UserTag | Contains the new user tag data
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
try {
    CommonResponse result = apiInstance.v1UserTagsPost(body, accessToken);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TagsApi#v1UserTagsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**UserTag**](UserTag.md)| Contains the new user tag data |
 **accessToken** | **String**| User&#39;s OAuth2 access token | [optional]

### Return type

[**CommonResponse**](CommonResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

