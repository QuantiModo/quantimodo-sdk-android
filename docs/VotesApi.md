# VotesApi

All URIs are relative to *https://app.quantimo.do/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**v1VotesDeletePost**](VotesApi.md#v1VotesDeletePost) | **POST** /v1/votes/delete | Delete vote
[**v1VotesPost**](VotesApi.md#v1VotesPost) | **POST** /v1/votes | Post or update vote


<a name="v1VotesDeletePost"></a>
# **v1VotesDeletePost**
> CommonResponse v1VotesDeletePost(body, accessToken)

Delete vote

Delete previously posted vote

### Example
```java
// Import classes:
//import io.swagger.client.api.VotesApi;

VotesApi apiInstance = new VotesApi();
VoteDelete body = new VoteDelete(); // VoteDelete | The cause and effect variable names for the predictor vote to be deleted.
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
try {
    CommonResponse result = apiInstance.v1VotesDeletePost(body, accessToken);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VotesApi#v1VotesDeletePost");
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
//import io.swagger.client.api.VotesApi;

VotesApi apiInstance = new VotesApi();
PostVote body = new PostVote(); // PostVote | Contains the cause variable, effect variable, and vote value.
String accessToken = "accessToken_example"; // String | User's OAuth2 access token
try {
    CommonResponse result = apiInstance.v1VotesPost(body, accessToken);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VotesApi#v1VotesPost");
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

