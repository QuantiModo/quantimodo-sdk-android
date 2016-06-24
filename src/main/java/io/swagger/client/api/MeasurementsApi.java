package io.swagger.client.api;

import io.swagger.client.ApiInvoker;
import io.swagger.client.ApiException;
import io.swagger.client.Pair;

import io.swagger.client.model.*;

import java.util.*;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import io.swagger.client.model.MeasurementSource;
import io.swagger.client.model.Measurement;
import io.swagger.client.model.MeasurementDelete;
import io.swagger.client.model.CommonResponse;
import io.swagger.client.model.MeasurementSet;
import io.swagger.client.model.MeasurementRange;
import java.io.File;
import io.swagger.client.model.InlineResponse20012;
import io.swagger.client.model.InlineResponse20011;

import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class MeasurementsApi {
  String basePath = "https://app.quantimo.do/api";
  ApiInvoker apiInvoker = ApiInvoker.getInstance();

  public void addHeader(String key, String value) {
    getInvoker().addDefaultHeader(key, value);
  }

  public ApiInvoker getInvoker() {
    return apiInvoker;
  }

  public void setBasePath(String basePath) {
    this.basePath = basePath;
  }

  public String getBasePath() {
    return basePath;
  }

  /**
  * Get measurement sources
  * Returns a list of all the apps from which measurement data is obtained.
   * @return MeasurementSource
  */
  public MeasurementSource v1MeasurementSourcesGet () throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = null;
  

  // create path and map variables
  String path = "/v1/measurementSources".replaceAll("\\{format\\}","json");

  // query params
  List<Pair> queryParams = new ArrayList<Pair>();
      // header params
      Map<String, String> headerParams = new HashMap<String, String>();
      // form params
      Map<String, String> formParams = new HashMap<String, String>();



      String[] contentTypes = {
  "application/json"
      };
      String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

      if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
  

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
      } else {
      // normal form params
        }

      String[] authNames = new String[] { "oauth2" };

      try {
        String localVarResponse = apiInvoker.invokeAPI (basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames);
        if(localVarResponse != null){
           return (MeasurementSource) ApiInvoker.deserialize(localVarResponse, "", MeasurementSource.class);
        } else {
           return null;
        }
      } catch (ApiException ex) {
         throw ex;
      } catch (InterruptedException ex) {
         throw ex;
      } catch (ExecutionException ex) {
         if(ex.getCause() instanceof VolleyError) {
	    VolleyError volleyError = (VolleyError)ex.getCause();
	    if (volleyError.networkResponse != null) {
	       throw new ApiException(volleyError.networkResponse.statusCode, volleyError.getMessage());
	    }
         }
         throw ex;
      } catch (TimeoutException ex) {
         throw ex;
      }
  }

      /**
   * Get measurement sources
   * Returns a list of all the apps from which measurement data is obtained.

  */
  public void v1MeasurementSourcesGet (final Response.Listener<MeasurementSource> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = null;

  

    // create path and map variables
    String path = "/v1/measurementSources".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();



    String[] contentTypes = {
      "application/json"
    };
    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
      

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
    } else {
      // normal form params
          }

      String[] authNames = new String[] { "oauth2" };

    try {
      apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames,
        new Response.Listener<String>() {
          @Override
          public void onResponse(String localVarResponse) {
            try {
              responseListener.onResponse((MeasurementSource) ApiInvoker.deserialize(localVarResponse,  "", MeasurementSource.class));
            } catch (ApiException exception) {
               errorListener.onErrorResponse(new VolleyError(exception));
            }
          }
      }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
            errorListener.onErrorResponse(error);
          }
      });
    } catch (ApiException ex) {
      errorListener.onErrorResponse(new VolleyError(ex));
    }
  }
  /**
  * Add a data source
  * Add a life-tracking app or device to the QuantiModo list of data sources.
   * @param body An array of names of data sources you want to add.
   * @param accessToken User&#39;s OAuth2 access token
   * @return void
  */
  public void v1MeasurementSourcesPost (MeasurementSource body, String accessToken) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = body;
  
      // verify the required parameter 'body' is set
      if (body == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'body' when calling v1MeasurementSourcesPost",
      new ApiException(400, "Missing the required parameter 'body' when calling v1MeasurementSourcesPost"));
      }
  

  // create path and map variables
  String path = "/v1/measurementSources".replaceAll("\\{format\\}","json");

  // query params
  List<Pair> queryParams = new ArrayList<Pair>();
      // header params
      Map<String, String> headerParams = new HashMap<String, String>();
      // form params
      Map<String, String> formParams = new HashMap<String, String>();

          queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));


      String[] contentTypes = {
  "application/json"
      };
      String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

      if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
  

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
      } else {
      // normal form params
        }

      String[] authNames = new String[] { "oauth2" };

      try {
        String localVarResponse = apiInvoker.invokeAPI (basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType, authNames);
        if(localVarResponse != null){
           return ;
        } else {
           return ;
        }
      } catch (ApiException ex) {
         throw ex;
      } catch (InterruptedException ex) {
         throw ex;
      } catch (ExecutionException ex) {
         if(ex.getCause() instanceof VolleyError) {
	    VolleyError volleyError = (VolleyError)ex.getCause();
	    if (volleyError.networkResponse != null) {
	       throw new ApiException(volleyError.networkResponse.statusCode, volleyError.getMessage());
	    }
         }
         throw ex;
      } catch (TimeoutException ex) {
         throw ex;
      }
  }

      /**
   * Add a data source
   * Add a life-tracking app or device to the QuantiModo list of data sources.
   * @param body An array of names of data sources you want to add.   * @param accessToken User&#39;s OAuth2 access token
  */
  public void v1MeasurementSourcesPost (MeasurementSource body, String accessToken, final Response.Listener<String> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = body;

  
    // verify the required parameter 'body' is set
    if (body == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'body' when calling v1MeasurementSourcesPost",
         new ApiException(400, "Missing the required parameter 'body' when calling v1MeasurementSourcesPost"));
    }
    

    // create path and map variables
    String path = "/v1/measurementSources".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();

    queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));


    String[] contentTypes = {
      "application/json"
    };
    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
      

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
    } else {
      // normal form params
          }

      String[] authNames = new String[] { "oauth2" };

    try {
      apiInvoker.invokeAPI(basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType, authNames,
        new Response.Listener<String>() {
          @Override
          public void onResponse(String localVarResponse) {
              responseListener.onResponse(localVarResponse);
          }
      }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
            errorListener.onErrorResponse(error);
          }
      });
    } catch (ApiException ex) {
      errorListener.onErrorResponse(new VolleyError(ex));
    }
  }
  /**
  * Get daily measurements for this user
  * Measurements are any value that can be recorded like daily steps, a mood rating, or apples eaten. &lt;br&gt;Supported filter parameters:&lt;br&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;value&lt;/b&gt; - Value of measurement&lt;/li&gt;&lt;li&gt;&lt;b&gt;lastUpdated&lt;/b&gt; - The time that this measurement was created or last updated in the UTC format \&quot;YYYY-MM-DDThh:mm:ss\&quot;&lt;/li&gt;&lt;/ul&gt;&lt;br&gt;
   * @param variableName Name of the variable you want measurements for
   * @param accessToken User&#39;s OAuth2 access token
   * @param abbreviatedUnitName The unit your want the measurements in
   * @param startTime The lower limit of measurements returned (Iso8601)
   * @param endTime The upper limit of measurements returned (Iso8601)
   * @param groupingWidth The time (in seconds) over which measurements are grouped together
   * @param groupingTimezone The time (in seconds) over which measurements are grouped together
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0.
   * @param offset Now suppose you wanted to show results 11-20. You&#39;d set the offset to 10 and the limit to 10.
   * @param sort Sort by given field. If the field is prefixed with &#x60;-, it will sort in descending order.
   * @return Measurement
  */
  public Measurement v1MeasurementsDailyGet (String variableName, String accessToken, String abbreviatedUnitName, String startTime, String endTime, Integer groupingWidth, String groupingTimezone, Integer limit, Integer offset, Integer sort) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = null;
  
      // verify the required parameter 'variableName' is set
      if (variableName == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'variableName' when calling v1MeasurementsDailyGet",
      new ApiException(400, "Missing the required parameter 'variableName' when calling v1MeasurementsDailyGet"));
      }
  

  // create path and map variables
  String path = "/v1/measurements/daily".replaceAll("\\{format\\}","json");

  // query params
  List<Pair> queryParams = new ArrayList<Pair>();
      // header params
      Map<String, String> headerParams = new HashMap<String, String>();
      // form params
      Map<String, String> formParams = new HashMap<String, String>();

          queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "variableName", variableName));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "abbreviatedUnitName", abbreviatedUnitName));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "startTime", startTime));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "endTime", endTime));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "groupingWidth", groupingWidth));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "groupingTimezone", groupingTimezone));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "limit", limit));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "offset", offset));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "sort", sort));


      String[] contentTypes = {
  "application/json"
      };
      String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

      if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
  

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
      } else {
      // normal form params
        }

      String[] authNames = new String[] { "oauth2" };

      try {
        String localVarResponse = apiInvoker.invokeAPI (basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames);
        if(localVarResponse != null){
           return (Measurement) ApiInvoker.deserialize(localVarResponse, "", Measurement.class);
        } else {
           return null;
        }
      } catch (ApiException ex) {
         throw ex;
      } catch (InterruptedException ex) {
         throw ex;
      } catch (ExecutionException ex) {
         if(ex.getCause() instanceof VolleyError) {
	    VolleyError volleyError = (VolleyError)ex.getCause();
	    if (volleyError.networkResponse != null) {
	       throw new ApiException(volleyError.networkResponse.statusCode, volleyError.getMessage());
	    }
         }
         throw ex;
      } catch (TimeoutException ex) {
         throw ex;
      }
  }

      /**
   * Get daily measurements for this user
   * Measurements are any value that can be recorded like daily steps, a mood rating, or apples eaten. &lt;br&gt;Supported filter parameters:&lt;br&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;value&lt;/b&gt; - Value of measurement&lt;/li&gt;&lt;li&gt;&lt;b&gt;lastUpdated&lt;/b&gt; - The time that this measurement was created or last updated in the UTC format \&quot;YYYY-MM-DDThh:mm:ss\&quot;&lt;/li&gt;&lt;/ul&gt;&lt;br&gt;
   * @param variableName Name of the variable you want measurements for   * @param accessToken User&#39;s OAuth2 access token   * @param abbreviatedUnitName The unit your want the measurements in   * @param startTime The lower limit of measurements returned (Iso8601)   * @param endTime The upper limit of measurements returned (Iso8601)   * @param groupingWidth The time (in seconds) over which measurements are grouped together   * @param groupingTimezone The time (in seconds) over which measurements are grouped together   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0.   * @param offset Now suppose you wanted to show results 11-20. You&#39;d set the offset to 10 and the limit to 10.   * @param sort Sort by given field. If the field is prefixed with &#x60;-, it will sort in descending order.
  */
  public void v1MeasurementsDailyGet (String variableName, String accessToken, String abbreviatedUnitName, String startTime, String endTime, Integer groupingWidth, String groupingTimezone, Integer limit, Integer offset, Integer sort, final Response.Listener<Measurement> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = null;

  
    // verify the required parameter 'variableName' is set
    if (variableName == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'variableName' when calling v1MeasurementsDailyGet",
         new ApiException(400, "Missing the required parameter 'variableName' when calling v1MeasurementsDailyGet"));
    }
    

    // create path and map variables
    String path = "/v1/measurements/daily".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();

    queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "variableName", variableName));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "abbreviatedUnitName", abbreviatedUnitName));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "startTime", startTime));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "endTime", endTime));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "groupingWidth", groupingWidth));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "groupingTimezone", groupingTimezone));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "limit", limit));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "offset", offset));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "sort", sort));


    String[] contentTypes = {
      "application/json"
    };
    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
      

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
    } else {
      // normal form params
          }

      String[] authNames = new String[] { "oauth2" };

    try {
      apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames,
        new Response.Listener<String>() {
          @Override
          public void onResponse(String localVarResponse) {
            try {
              responseListener.onResponse((Measurement) ApiInvoker.deserialize(localVarResponse,  "", Measurement.class));
            } catch (ApiException exception) {
               errorListener.onErrorResponse(new VolleyError(exception));
            }
          }
      }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
            errorListener.onErrorResponse(error);
          }
      });
    } catch (ApiException ex) {
      errorListener.onErrorResponse(new VolleyError(ex));
    }
  }
  /**
  * Delete a measurement
  * Delete a previously submitted measurement
   * @param body The startTime and variableId of the measurement to be deleted.
   * @return CommonResponse
  */
  public CommonResponse v1MeasurementsDeletePost (MeasurementDelete body) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = body;
  
      // verify the required parameter 'body' is set
      if (body == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'body' when calling v1MeasurementsDeletePost",
      new ApiException(400, "Missing the required parameter 'body' when calling v1MeasurementsDeletePost"));
      }
  

  // create path and map variables
  String path = "/v1/measurements/delete".replaceAll("\\{format\\}","json");

  // query params
  List<Pair> queryParams = new ArrayList<Pair>();
      // header params
      Map<String, String> headerParams = new HashMap<String, String>();
      // form params
      Map<String, String> formParams = new HashMap<String, String>();



      String[] contentTypes = {
  "application/json"
      };
      String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

      if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
  

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
      } else {
      // normal form params
        }

      String[] authNames = new String[] { "oauth2" };

      try {
        String localVarResponse = apiInvoker.invokeAPI (basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType, authNames);
        if(localVarResponse != null){
           return (CommonResponse) ApiInvoker.deserialize(localVarResponse, "", CommonResponse.class);
        } else {
           return null;
        }
      } catch (ApiException ex) {
         throw ex;
      } catch (InterruptedException ex) {
         throw ex;
      } catch (ExecutionException ex) {
         if(ex.getCause() instanceof VolleyError) {
	    VolleyError volleyError = (VolleyError)ex.getCause();
	    if (volleyError.networkResponse != null) {
	       throw new ApiException(volleyError.networkResponse.statusCode, volleyError.getMessage());
	    }
         }
         throw ex;
      } catch (TimeoutException ex) {
         throw ex;
      }
  }

      /**
   * Delete a measurement
   * Delete a previously submitted measurement
   * @param body The startTime and variableId of the measurement to be deleted.
  */
  public void v1MeasurementsDeletePost (MeasurementDelete body, final Response.Listener<CommonResponse> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = body;

  
    // verify the required parameter 'body' is set
    if (body == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'body' when calling v1MeasurementsDeletePost",
         new ApiException(400, "Missing the required parameter 'body' when calling v1MeasurementsDeletePost"));
    }
    

    // create path and map variables
    String path = "/v1/measurements/delete".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();



    String[] contentTypes = {
      "application/json"
    };
    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
      

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
    } else {
      // normal form params
          }

      String[] authNames = new String[] { "oauth2" };

    try {
      apiInvoker.invokeAPI(basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType, authNames,
        new Response.Listener<String>() {
          @Override
          public void onResponse(String localVarResponse) {
            try {
              responseListener.onResponse((CommonResponse) ApiInvoker.deserialize(localVarResponse,  "", CommonResponse.class));
            } catch (ApiException exception) {
               errorListener.onErrorResponse(new VolleyError(exception));
            }
          }
      }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
            errorListener.onErrorResponse(error);
          }
      });
    } catch (ApiException ex) {
      errorListener.onErrorResponse(new VolleyError(ex));
    }
  }
  /**
  * Get measurements for this user
  * Measurements are any value that can be recorded like daily steps, a mood rating, or apples eaten. &lt;br&gt;Supported filter parameters:&lt;br&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;value&lt;/b&gt; - Value of measurement&lt;/li&gt;&lt;li&gt;&lt;b&gt;lastUpdated&lt;/b&gt; - The time that this measurement was created or last updated in the UTC format \&quot;YYYY-MM-DDThh:mm:ss\&quot;&lt;/li&gt;&lt;/ul&gt;&lt;br&gt;
   * @param accessToken User&#39;s OAuth2 access token
   * @param variableName Name of the variable you want measurements for
   * @param variableCategoryName Name of the variable category you want measurements for
   * @param source Name of the source you want measurements for (supports exact name match only)
   * @param value Value of measurement
   * @param lastUpdated The time that this measurement was created or last updated in the format \&quot;YYYY-MM-DDThh:mm:ss\&quot;
   * @param unit The unit you want the measurements returned in
   * @param startTime The lower limit of measurements returned (Epoch)
   * @param createdAt The time the measurement record was first created in the format YYYY-MM-DDThh:mm:ss. Time zone should be UTC and not local.
   * @param updatedAt The time the measurement record was last changed in the format YYYY-MM-DDThh:mm:ss. Time zone should be UTC and not local.
   * @param endTime The upper limit of measurements returned (Epoch)
   * @param groupingWidth The time (in seconds) over which measurements are grouped together
   * @param groupingTimezone The time (in seconds) over which measurements are grouped together
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0.
   * @param offset Now suppose you wanted to show results 11-20. You&#39;d set the offset to 10 and the limit to 10.
   * @param sort Sort by given field. If the field is prefixed with &#x60;-, it will sort in descending order.
   * @return Measurement
  */
  public Measurement v1MeasurementsGet (String accessToken, String variableName, String variableCategoryName, String source, String value, String lastUpdated, String unit, String startTime, String createdAt, String updatedAt, String endTime, Integer groupingWidth, String groupingTimezone, Integer limit, Integer offset, Integer sort) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = null;
  

  // create path and map variables
  String path = "/v1/measurements".replaceAll("\\{format\\}","json");

  // query params
  List<Pair> queryParams = new ArrayList<Pair>();
      // header params
      Map<String, String> headerParams = new HashMap<String, String>();
      // form params
      Map<String, String> formParams = new HashMap<String, String>();

          queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "variableName", variableName));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "variableCategoryName", variableCategoryName));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "source", source));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "value", value));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "lastUpdated", lastUpdated));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "unit", unit));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "startTime", startTime));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "createdAt", createdAt));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "updatedAt", updatedAt));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "endTime", endTime));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "groupingWidth", groupingWidth));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "groupingTimezone", groupingTimezone));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "limit", limit));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "offset", offset));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "sort", sort));


      String[] contentTypes = {
  "application/json"
      };
      String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

      if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
  

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
      } else {
      // normal form params
        }

      String[] authNames = new String[] { "oauth2" };

      try {
        String localVarResponse = apiInvoker.invokeAPI (basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames);
        if(localVarResponse != null){
           return (Measurement) ApiInvoker.deserialize(localVarResponse, "", Measurement.class);
        } else {
           return null;
        }
      } catch (ApiException ex) {
         throw ex;
      } catch (InterruptedException ex) {
         throw ex;
      } catch (ExecutionException ex) {
         if(ex.getCause() instanceof VolleyError) {
	    VolleyError volleyError = (VolleyError)ex.getCause();
	    if (volleyError.networkResponse != null) {
	       throw new ApiException(volleyError.networkResponse.statusCode, volleyError.getMessage());
	    }
         }
         throw ex;
      } catch (TimeoutException ex) {
         throw ex;
      }
  }

      /**
   * Get measurements for this user
   * Measurements are any value that can be recorded like daily steps, a mood rating, or apples eaten. &lt;br&gt;Supported filter parameters:&lt;br&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;value&lt;/b&gt; - Value of measurement&lt;/li&gt;&lt;li&gt;&lt;b&gt;lastUpdated&lt;/b&gt; - The time that this measurement was created or last updated in the UTC format \&quot;YYYY-MM-DDThh:mm:ss\&quot;&lt;/li&gt;&lt;/ul&gt;&lt;br&gt;
   * @param accessToken User&#39;s OAuth2 access token   * @param variableName Name of the variable you want measurements for   * @param variableCategoryName Name of the variable category you want measurements for   * @param source Name of the source you want measurements for (supports exact name match only)   * @param value Value of measurement   * @param lastUpdated The time that this measurement was created or last updated in the format \&quot;YYYY-MM-DDThh:mm:ss\&quot;   * @param unit The unit you want the measurements returned in   * @param startTime The lower limit of measurements returned (Epoch)   * @param createdAt The time the measurement record was first created in the format YYYY-MM-DDThh:mm:ss. Time zone should be UTC and not local.   * @param updatedAt The time the measurement record was last changed in the format YYYY-MM-DDThh:mm:ss. Time zone should be UTC and not local.   * @param endTime The upper limit of measurements returned (Epoch)   * @param groupingWidth The time (in seconds) over which measurements are grouped together   * @param groupingTimezone The time (in seconds) over which measurements are grouped together   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0.   * @param offset Now suppose you wanted to show results 11-20. You&#39;d set the offset to 10 and the limit to 10.   * @param sort Sort by given field. If the field is prefixed with &#x60;-, it will sort in descending order.
  */
  public void v1MeasurementsGet (String accessToken, String variableName, String variableCategoryName, String source, String value, String lastUpdated, String unit, String startTime, String createdAt, String updatedAt, String endTime, Integer groupingWidth, String groupingTimezone, Integer limit, Integer offset, Integer sort, final Response.Listener<Measurement> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = null;

  

    // create path and map variables
    String path = "/v1/measurements".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();

    queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "variableName", variableName));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "variableCategoryName", variableCategoryName));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "source", source));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "value", value));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "lastUpdated", lastUpdated));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "unit", unit));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "startTime", startTime));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "createdAt", createdAt));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "updatedAt", updatedAt));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "endTime", endTime));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "groupingWidth", groupingWidth));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "groupingTimezone", groupingTimezone));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "limit", limit));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "offset", offset));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "sort", sort));


    String[] contentTypes = {
      "application/json"
    };
    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
      

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
    } else {
      // normal form params
          }

      String[] authNames = new String[] { "oauth2" };

    try {
      apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames,
        new Response.Listener<String>() {
          @Override
          public void onResponse(String localVarResponse) {
            try {
              responseListener.onResponse((Measurement) ApiInvoker.deserialize(localVarResponse,  "", Measurement.class));
            } catch (ApiException exception) {
               errorListener.onErrorResponse(new VolleyError(exception));
            }
          }
      }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
            errorListener.onErrorResponse(error);
          }
      });
    } catch (ApiException ex) {
      errorListener.onErrorResponse(new VolleyError(ex));
    }
  }
  /**
  * Post a new set or update existing measurements to the database
  * You can submit or update multiple measurements in a \&quot;measurements\&quot; sub-array.  If the variable these measurements correspond to does not already exist in the database, it will be automatically added.  The request body should look something like [{\&quot;measurements\&quot;:[{\&quot;startTime\&quot;:1439389320,\&quot;value\&quot;:\&quot;3\&quot;}, {\&quot;startTime\&quot;:1439389319,\&quot;value\&quot;:\&quot;2\&quot;}],\&quot;name\&quot;:\&quot;Acne (out of 5)\&quot;,\&quot;source\&quot;:\&quot;QuantiModo\&quot;,\&quot;category\&quot;:\&quot;Symptoms\&quot;,\&quot;combinationOperation\&quot;:\&quot;MEAN\&quot;,\&quot;unit\&quot;:\&quot;/5\&quot;}]
   * @param body An array of measurements you want to insert.
   * @param accessToken User&#39;s OAuth2 access token
   * @return void
  */
  public void v1MeasurementsPost (MeasurementSet body, String accessToken) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = body;
  
      // verify the required parameter 'body' is set
      if (body == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'body' when calling v1MeasurementsPost",
      new ApiException(400, "Missing the required parameter 'body' when calling v1MeasurementsPost"));
      }
  

  // create path and map variables
  String path = "/v1/measurements".replaceAll("\\{format\\}","json");

  // query params
  List<Pair> queryParams = new ArrayList<Pair>();
      // header params
      Map<String, String> headerParams = new HashMap<String, String>();
      // form params
      Map<String, String> formParams = new HashMap<String, String>();

          queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));


      String[] contentTypes = {
  "application/json"
      };
      String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

      if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
  

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
      } else {
      // normal form params
        }

      String[] authNames = new String[] { "oauth2" };

      try {
        String localVarResponse = apiInvoker.invokeAPI (basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType, authNames);
        if(localVarResponse != null){
           return ;
        } else {
           return ;
        }
      } catch (ApiException ex) {
         throw ex;
      } catch (InterruptedException ex) {
         throw ex;
      } catch (ExecutionException ex) {
         if(ex.getCause() instanceof VolleyError) {
	    VolleyError volleyError = (VolleyError)ex.getCause();
	    if (volleyError.networkResponse != null) {
	       throw new ApiException(volleyError.networkResponse.statusCode, volleyError.getMessage());
	    }
         }
         throw ex;
      } catch (TimeoutException ex) {
         throw ex;
      }
  }

      /**
   * Post a new set or update existing measurements to the database
   * You can submit or update multiple measurements in a \&quot;measurements\&quot; sub-array.  If the variable these measurements correspond to does not already exist in the database, it will be automatically added.  The request body should look something like [{\&quot;measurements\&quot;:[{\&quot;startTime\&quot;:1439389320,\&quot;value\&quot;:\&quot;3\&quot;}, {\&quot;startTime\&quot;:1439389319,\&quot;value\&quot;:\&quot;2\&quot;}],\&quot;name\&quot;:\&quot;Acne (out of 5)\&quot;,\&quot;source\&quot;:\&quot;QuantiModo\&quot;,\&quot;category\&quot;:\&quot;Symptoms\&quot;,\&quot;combinationOperation\&quot;:\&quot;MEAN\&quot;,\&quot;unit\&quot;:\&quot;/5\&quot;}]
   * @param body An array of measurements you want to insert.   * @param accessToken User&#39;s OAuth2 access token
  */
  public void v1MeasurementsPost (MeasurementSet body, String accessToken, final Response.Listener<String> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = body;

  
    // verify the required parameter 'body' is set
    if (body == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'body' when calling v1MeasurementsPost",
         new ApiException(400, "Missing the required parameter 'body' when calling v1MeasurementsPost"));
    }
    

    // create path and map variables
    String path = "/v1/measurements".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();

    queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));


    String[] contentTypes = {
      "application/json"
    };
    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
      

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
    } else {
      // normal form params
          }

      String[] authNames = new String[] { "oauth2" };

    try {
      apiInvoker.invokeAPI(basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType, authNames,
        new Response.Listener<String>() {
          @Override
          public void onResponse(String localVarResponse) {
              responseListener.onResponse(localVarResponse);
          }
      }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
            errorListener.onErrorResponse(error);
          }
      });
    } catch (ApiException ex) {
      errorListener.onErrorResponse(new VolleyError(ex));
    }
  }
  /**
  * Get measurements range for this user
  * Get Unix time-stamp (epoch time) of the user&#39;s first and last measurements taken.
   * @param sources Enter source name to limit to specific source (varchar)
   * @param user If not specified, uses currently logged in user (bigint)
   * @return MeasurementRange
  */
  public MeasurementRange v1MeasurementsRangeGet (String sources, Integer user) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = null;
  

  // create path and map variables
  String path = "/v1/measurementsRange".replaceAll("\\{format\\}","json");

  // query params
  List<Pair> queryParams = new ArrayList<Pair>();
      // header params
      Map<String, String> headerParams = new HashMap<String, String>();
      // form params
      Map<String, String> formParams = new HashMap<String, String>();

          queryParams.addAll(ApiInvoker.parameterToPairs("", "sources", sources));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "user", user));


      String[] contentTypes = {
  "application/json"
      };
      String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

      if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
  

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
      } else {
      // normal form params
        }

      String[] authNames = new String[] { "oauth2" };

      try {
        String localVarResponse = apiInvoker.invokeAPI (basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames);
        if(localVarResponse != null){
           return (MeasurementRange) ApiInvoker.deserialize(localVarResponse, "", MeasurementRange.class);
        } else {
           return null;
        }
      } catch (ApiException ex) {
         throw ex;
      } catch (InterruptedException ex) {
         throw ex;
      } catch (ExecutionException ex) {
         if(ex.getCause() instanceof VolleyError) {
	    VolleyError volleyError = (VolleyError)ex.getCause();
	    if (volleyError.networkResponse != null) {
	       throw new ApiException(volleyError.networkResponse.statusCode, volleyError.getMessage());
	    }
         }
         throw ex;
      } catch (TimeoutException ex) {
         throw ex;
      }
  }

      /**
   * Get measurements range for this user
   * Get Unix time-stamp (epoch time) of the user&#39;s first and last measurements taken.
   * @param sources Enter source name to limit to specific source (varchar)   * @param user If not specified, uses currently logged in user (bigint)
  */
  public void v1MeasurementsRangeGet (String sources, Integer user, final Response.Listener<MeasurementRange> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = null;

  

    // create path and map variables
    String path = "/v1/measurementsRange".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();

    queryParams.addAll(ApiInvoker.parameterToPairs("", "sources", sources));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "user", user));


    String[] contentTypes = {
      "application/json"
    };
    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
      

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
    } else {
      // normal form params
          }

      String[] authNames = new String[] { "oauth2" };

    try {
      apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames,
        new Response.Listener<String>() {
          @Override
          public void onResponse(String localVarResponse) {
            try {
              responseListener.onResponse((MeasurementRange) ApiInvoker.deserialize(localVarResponse,  "", MeasurementRange.class));
            } catch (ApiException exception) {
               errorListener.onErrorResponse(new VolleyError(exception));
            }
          }
      }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
            errorListener.onErrorResponse(error);
          }
      });
    } catch (ApiException ex) {
      errorListener.onErrorResponse(new VolleyError(ex));
    }
  }
  /**
  * Get Measurements CSV
  * Download a CSV containing all user measurements
   * @param accessToken User&#39;s OAuth2 access token
   * @return File
  */
  public File v2MeasurementsCsvGet (String accessToken) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = null;
  

  // create path and map variables
  String path = "/v2/measurements/csv".replaceAll("\\{format\\}","json");

  // query params
  List<Pair> queryParams = new ArrayList<Pair>();
      // header params
      Map<String, String> headerParams = new HashMap<String, String>();
      // form params
      Map<String, String> formParams = new HashMap<String, String>();

          queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));


      String[] contentTypes = {
  "application/json"
      };
      String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

      if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
  

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
      } else {
      // normal form params
        }

      String[] authNames = new String[] { "quantimodo_oauth2" };

      try {
        String localVarResponse = apiInvoker.invokeAPI (basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames);
        if(localVarResponse != null){
           return (File) ApiInvoker.deserialize(localVarResponse, "", File.class);
        } else {
           return null;
        }
      } catch (ApiException ex) {
         throw ex;
      } catch (InterruptedException ex) {
         throw ex;
      } catch (ExecutionException ex) {
         if(ex.getCause() instanceof VolleyError) {
	    VolleyError volleyError = (VolleyError)ex.getCause();
	    if (volleyError.networkResponse != null) {
	       throw new ApiException(volleyError.networkResponse.statusCode, volleyError.getMessage());
	    }
         }
         throw ex;
      } catch (TimeoutException ex) {
         throw ex;
      }
  }

      /**
   * Get Measurements CSV
   * Download a CSV containing all user measurements
   * @param accessToken User&#39;s OAuth2 access token
  */
  public void v2MeasurementsCsvGet (String accessToken, final Response.Listener<File> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = null;

  

    // create path and map variables
    String path = "/v2/measurements/csv".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();

    queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));


    String[] contentTypes = {
      "application/json"
    };
    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
      

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
    } else {
      // normal form params
          }

      String[] authNames = new String[] { "quantimodo_oauth2" };

    try {
      apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames,
        new Response.Listener<String>() {
          @Override
          public void onResponse(String localVarResponse) {
            try {
              responseListener.onResponse((File) ApiInvoker.deserialize(localVarResponse,  "", File.class));
            } catch (ApiException exception) {
               errorListener.onErrorResponse(new VolleyError(exception));
            }
          }
      }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
            errorListener.onErrorResponse(error);
          }
      });
    } catch (ApiException ex) {
      errorListener.onErrorResponse(new VolleyError(ex));
    }
  }
  /**
  * Delete Measurement
  * Delete Measurement
   * @param id id of Measurement
   * @param accessToken User&#39;s OAuth2 access token
   * @return InlineResponse20012
  */
  public InlineResponse20012 v2MeasurementsIdDelete (Integer id, String accessToken) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = null;
  
      // verify the required parameter 'id' is set
      if (id == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'id' when calling v2MeasurementsIdDelete",
      new ApiException(400, "Missing the required parameter 'id' when calling v2MeasurementsIdDelete"));
      }
  

  // create path and map variables
  String path = "/v2/measurements/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

  // query params
  List<Pair> queryParams = new ArrayList<Pair>();
      // header params
      Map<String, String> headerParams = new HashMap<String, String>();
      // form params
      Map<String, String> formParams = new HashMap<String, String>();

          queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));


      String[] contentTypes = {
  "application/json"
      };
      String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

      if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
  

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
      } else {
      // normal form params
        }

      String[] authNames = new String[] { "quantimodo_oauth2" };

      try {
        String localVarResponse = apiInvoker.invokeAPI (basePath, path, "DELETE", queryParams, postBody, headerParams, formParams, contentType, authNames);
        if(localVarResponse != null){
           return (InlineResponse20012) ApiInvoker.deserialize(localVarResponse, "", InlineResponse20012.class);
        } else {
           return null;
        }
      } catch (ApiException ex) {
         throw ex;
      } catch (InterruptedException ex) {
         throw ex;
      } catch (ExecutionException ex) {
         if(ex.getCause() instanceof VolleyError) {
	    VolleyError volleyError = (VolleyError)ex.getCause();
	    if (volleyError.networkResponse != null) {
	       throw new ApiException(volleyError.networkResponse.statusCode, volleyError.getMessage());
	    }
         }
         throw ex;
      } catch (TimeoutException ex) {
         throw ex;
      }
  }

      /**
   * Delete Measurement
   * Delete Measurement
   * @param id id of Measurement   * @param accessToken User&#39;s OAuth2 access token
  */
  public void v2MeasurementsIdDelete (Integer id, String accessToken, final Response.Listener<InlineResponse20012> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = null;

  
    // verify the required parameter 'id' is set
    if (id == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'id' when calling v2MeasurementsIdDelete",
         new ApiException(400, "Missing the required parameter 'id' when calling v2MeasurementsIdDelete"));
    }
    

    // create path and map variables
    String path = "/v2/measurements/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();

    queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));


    String[] contentTypes = {
      "application/json"
    };
    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
      

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
    } else {
      // normal form params
          }

      String[] authNames = new String[] { "quantimodo_oauth2" };

    try {
      apiInvoker.invokeAPI(basePath, path, "DELETE", queryParams, postBody, headerParams, formParams, contentType, authNames,
        new Response.Listener<String>() {
          @Override
          public void onResponse(String localVarResponse) {
            try {
              responseListener.onResponse((InlineResponse20012) ApiInvoker.deserialize(localVarResponse,  "", InlineResponse20012.class));
            } catch (ApiException exception) {
               errorListener.onErrorResponse(new VolleyError(exception));
            }
          }
      }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
            errorListener.onErrorResponse(error);
          }
      });
    } catch (ApiException ex) {
      errorListener.onErrorResponse(new VolleyError(ex));
    }
  }
  /**
  * Get Measurement
  * Get Measurement
   * @param id id of Measurement
   * @param accessToken User&#39;s OAuth2 access token
   * @return InlineResponse20011
  */
  public InlineResponse20011 v2MeasurementsIdGet (Integer id, String accessToken) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = null;
  
      // verify the required parameter 'id' is set
      if (id == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'id' when calling v2MeasurementsIdGet",
      new ApiException(400, "Missing the required parameter 'id' when calling v2MeasurementsIdGet"));
      }
  

  // create path and map variables
  String path = "/v2/measurements/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

  // query params
  List<Pair> queryParams = new ArrayList<Pair>();
      // header params
      Map<String, String> headerParams = new HashMap<String, String>();
      // form params
      Map<String, String> formParams = new HashMap<String, String>();

          queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));


      String[] contentTypes = {
  "application/json"
      };
      String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

      if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
  

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
      } else {
      // normal form params
        }

      String[] authNames = new String[] { "quantimodo_oauth2" };

      try {
        String localVarResponse = apiInvoker.invokeAPI (basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames);
        if(localVarResponse != null){
           return (InlineResponse20011) ApiInvoker.deserialize(localVarResponse, "", InlineResponse20011.class);
        } else {
           return null;
        }
      } catch (ApiException ex) {
         throw ex;
      } catch (InterruptedException ex) {
         throw ex;
      } catch (ExecutionException ex) {
         if(ex.getCause() instanceof VolleyError) {
	    VolleyError volleyError = (VolleyError)ex.getCause();
	    if (volleyError.networkResponse != null) {
	       throw new ApiException(volleyError.networkResponse.statusCode, volleyError.getMessage());
	    }
         }
         throw ex;
      } catch (TimeoutException ex) {
         throw ex;
      }
  }

      /**
   * Get Measurement
   * Get Measurement
   * @param id id of Measurement   * @param accessToken User&#39;s OAuth2 access token
  */
  public void v2MeasurementsIdGet (Integer id, String accessToken, final Response.Listener<InlineResponse20011> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = null;

  
    // verify the required parameter 'id' is set
    if (id == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'id' when calling v2MeasurementsIdGet",
         new ApiException(400, "Missing the required parameter 'id' when calling v2MeasurementsIdGet"));
    }
    

    // create path and map variables
    String path = "/v2/measurements/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();

    queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));


    String[] contentTypes = {
      "application/json"
    };
    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
      

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
    } else {
      // normal form params
          }

      String[] authNames = new String[] { "quantimodo_oauth2" };

    try {
      apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames,
        new Response.Listener<String>() {
          @Override
          public void onResponse(String localVarResponse) {
            try {
              responseListener.onResponse((InlineResponse20011) ApiInvoker.deserialize(localVarResponse,  "", InlineResponse20011.class));
            } catch (ApiException exception) {
               errorListener.onErrorResponse(new VolleyError(exception));
            }
          }
      }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
            errorListener.onErrorResponse(error);
          }
      });
    } catch (ApiException ex) {
      errorListener.onErrorResponse(new VolleyError(ex));
    }
  }
  /**
  * Update Measurement
  * Update Measurement
   * @param id id of Measurement
   * @param accessToken User&#39;s OAuth2 access token
   * @param body Measurement that should be updated
   * @return InlineResponse20012
  */
  public InlineResponse20012 v2MeasurementsIdPut (Integer id, String accessToken, Measurement body) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = body;
  
      // verify the required parameter 'id' is set
      if (id == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'id' when calling v2MeasurementsIdPut",
      new ApiException(400, "Missing the required parameter 'id' when calling v2MeasurementsIdPut"));
      }
  

  // create path and map variables
  String path = "/v2/measurements/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

  // query params
  List<Pair> queryParams = new ArrayList<Pair>();
      // header params
      Map<String, String> headerParams = new HashMap<String, String>();
      // form params
      Map<String, String> formParams = new HashMap<String, String>();

          queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));


      String[] contentTypes = {
  "application/json"
      };
      String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

      if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
  

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
      } else {
      // normal form params
        }

      String[] authNames = new String[] { "quantimodo_oauth2" };

      try {
        String localVarResponse = apiInvoker.invokeAPI (basePath, path, "PUT", queryParams, postBody, headerParams, formParams, contentType, authNames);
        if(localVarResponse != null){
           return (InlineResponse20012) ApiInvoker.deserialize(localVarResponse, "", InlineResponse20012.class);
        } else {
           return null;
        }
      } catch (ApiException ex) {
         throw ex;
      } catch (InterruptedException ex) {
         throw ex;
      } catch (ExecutionException ex) {
         if(ex.getCause() instanceof VolleyError) {
	    VolleyError volleyError = (VolleyError)ex.getCause();
	    if (volleyError.networkResponse != null) {
	       throw new ApiException(volleyError.networkResponse.statusCode, volleyError.getMessage());
	    }
         }
         throw ex;
      } catch (TimeoutException ex) {
         throw ex;
      }
  }

      /**
   * Update Measurement
   * Update Measurement
   * @param id id of Measurement   * @param accessToken User&#39;s OAuth2 access token   * @param body Measurement that should be updated
  */
  public void v2MeasurementsIdPut (Integer id, String accessToken, Measurement body, final Response.Listener<InlineResponse20012> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = body;

  
    // verify the required parameter 'id' is set
    if (id == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'id' when calling v2MeasurementsIdPut",
         new ApiException(400, "Missing the required parameter 'id' when calling v2MeasurementsIdPut"));
    }
    

    // create path and map variables
    String path = "/v2/measurements/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();

    queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));


    String[] contentTypes = {
      "application/json"
    };
    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
      

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
    } else {
      // normal form params
          }

      String[] authNames = new String[] { "quantimodo_oauth2" };

    try {
      apiInvoker.invokeAPI(basePath, path, "PUT", queryParams, postBody, headerParams, formParams, contentType, authNames,
        new Response.Listener<String>() {
          @Override
          public void onResponse(String localVarResponse) {
            try {
              responseListener.onResponse((InlineResponse20012) ApiInvoker.deserialize(localVarResponse,  "", InlineResponse20012.class));
            } catch (ApiException exception) {
               errorListener.onErrorResponse(new VolleyError(exception));
            }
          }
      }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
            errorListener.onErrorResponse(error);
          }
      });
    } catch (ApiException ex) {
      errorListener.onErrorResponse(new VolleyError(ex));
    }
  }
  /**
  * Post Request for Measurements CSV
  * Use this endpoint to schedule a CSV export containing all user measurements to be emailed to the user within 24 hours.
   * @param accessToken User&#39;s OAuth2 access token
   * @return Integer
  */
  public Integer v2MeasurementsRequestCsvPost (String accessToken) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = null;
  

  // create path and map variables
  String path = "/v2/measurements/request_csv".replaceAll("\\{format\\}","json");

  // query params
  List<Pair> queryParams = new ArrayList<Pair>();
      // header params
      Map<String, String> headerParams = new HashMap<String, String>();
      // form params
      Map<String, String> formParams = new HashMap<String, String>();

          queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));


      String[] contentTypes = {
  "application/json"
      };
      String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

      if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
  

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
      } else {
      // normal form params
        }

      String[] authNames = new String[] { "quantimodo_oauth2" };

      try {
        String localVarResponse = apiInvoker.invokeAPI (basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType, authNames);
        if(localVarResponse != null){
           return (Integer) ApiInvoker.deserialize(localVarResponse, "", Integer.class);
        } else {
           return null;
        }
      } catch (ApiException ex) {
         throw ex;
      } catch (InterruptedException ex) {
         throw ex;
      } catch (ExecutionException ex) {
         if(ex.getCause() instanceof VolleyError) {
	    VolleyError volleyError = (VolleyError)ex.getCause();
	    if (volleyError.networkResponse != null) {
	       throw new ApiException(volleyError.networkResponse.statusCode, volleyError.getMessage());
	    }
         }
         throw ex;
      } catch (TimeoutException ex) {
         throw ex;
      }
  }

      /**
   * Post Request for Measurements CSV
   * Use this endpoint to schedule a CSV export containing all user measurements to be emailed to the user within 24 hours.
   * @param accessToken User&#39;s OAuth2 access token
  */
  public void v2MeasurementsRequestCsvPost (String accessToken, final Response.Listener<Integer> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = null;

  

    // create path and map variables
    String path = "/v2/measurements/request_csv".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();

    queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));


    String[] contentTypes = {
      "application/json"
    };
    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
      

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
    } else {
      // normal form params
          }

      String[] authNames = new String[] { "quantimodo_oauth2" };

    try {
      apiInvoker.invokeAPI(basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType, authNames,
        new Response.Listener<String>() {
          @Override
          public void onResponse(String localVarResponse) {
            try {
              responseListener.onResponse((Integer) ApiInvoker.deserialize(localVarResponse,  "", Integer.class));
            } catch (ApiException exception) {
               errorListener.onErrorResponse(new VolleyError(exception));
            }
          }
      }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
            errorListener.onErrorResponse(error);
          }
      });
    } catch (ApiException ex) {
      errorListener.onErrorResponse(new VolleyError(ex));
    }
  }
  /**
  * Post Request for Measurements PDF
  * Use this endpoint to schedule a PDF export containing all user measurements to be emailed to the user within 24 hours.
   * @param accessToken User&#39;s OAuth2 access token
   * @return Integer
  */
  public Integer v2MeasurementsRequestPdfPost (String accessToken) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = null;
  

  // create path and map variables
  String path = "/v2/measurements/request_pdf".replaceAll("\\{format\\}","json");

  // query params
  List<Pair> queryParams = new ArrayList<Pair>();
      // header params
      Map<String, String> headerParams = new HashMap<String, String>();
      // form params
      Map<String, String> formParams = new HashMap<String, String>();

          queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));


      String[] contentTypes = {
  "application/json"
      };
      String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

      if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
  

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
      } else {
      // normal form params
        }

      String[] authNames = new String[] { "quantimodo_oauth2" };

      try {
        String localVarResponse = apiInvoker.invokeAPI (basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType, authNames);
        if(localVarResponse != null){
           return (Integer) ApiInvoker.deserialize(localVarResponse, "", Integer.class);
        } else {
           return null;
        }
      } catch (ApiException ex) {
         throw ex;
      } catch (InterruptedException ex) {
         throw ex;
      } catch (ExecutionException ex) {
         if(ex.getCause() instanceof VolleyError) {
	    VolleyError volleyError = (VolleyError)ex.getCause();
	    if (volleyError.networkResponse != null) {
	       throw new ApiException(volleyError.networkResponse.statusCode, volleyError.getMessage());
	    }
         }
         throw ex;
      } catch (TimeoutException ex) {
         throw ex;
      }
  }

      /**
   * Post Request for Measurements PDF
   * Use this endpoint to schedule a PDF export containing all user measurements to be emailed to the user within 24 hours.
   * @param accessToken User&#39;s OAuth2 access token
  */
  public void v2MeasurementsRequestPdfPost (String accessToken, final Response.Listener<Integer> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = null;

  

    // create path and map variables
    String path = "/v2/measurements/request_pdf".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();

    queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));


    String[] contentTypes = {
      "application/json"
    };
    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
      

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
    } else {
      // normal form params
          }

      String[] authNames = new String[] { "quantimodo_oauth2" };

    try {
      apiInvoker.invokeAPI(basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType, authNames,
        new Response.Listener<String>() {
          @Override
          public void onResponse(String localVarResponse) {
            try {
              responseListener.onResponse((Integer) ApiInvoker.deserialize(localVarResponse,  "", Integer.class));
            } catch (ApiException exception) {
               errorListener.onErrorResponse(new VolleyError(exception));
            }
          }
      }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
            errorListener.onErrorResponse(error);
          }
      });
    } catch (ApiException ex) {
      errorListener.onErrorResponse(new VolleyError(ex));
    }
  }
  /**
  * Post Request for Measurements XLS
  * Use this endpoint to schedule a XLS export containing all user measurements to be emailed to the user within 24 hours.
   * @param accessToken User&#39;s OAuth2 access token
   * @return Integer
  */
  public Integer v2MeasurementsRequestXlsPost (String accessToken) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = null;
  

  // create path and map variables
  String path = "/v2/measurements/request_xls".replaceAll("\\{format\\}","json");

  // query params
  List<Pair> queryParams = new ArrayList<Pair>();
      // header params
      Map<String, String> headerParams = new HashMap<String, String>();
      // form params
      Map<String, String> formParams = new HashMap<String, String>();

          queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));


      String[] contentTypes = {
  "application/json"
      };
      String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

      if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
  

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
      } else {
      // normal form params
        }

      String[] authNames = new String[] { "quantimodo_oauth2" };

      try {
        String localVarResponse = apiInvoker.invokeAPI (basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType, authNames);
        if(localVarResponse != null){
           return (Integer) ApiInvoker.deserialize(localVarResponse, "", Integer.class);
        } else {
           return null;
        }
      } catch (ApiException ex) {
         throw ex;
      } catch (InterruptedException ex) {
         throw ex;
      } catch (ExecutionException ex) {
         if(ex.getCause() instanceof VolleyError) {
	    VolleyError volleyError = (VolleyError)ex.getCause();
	    if (volleyError.networkResponse != null) {
	       throw new ApiException(volleyError.networkResponse.statusCode, volleyError.getMessage());
	    }
         }
         throw ex;
      } catch (TimeoutException ex) {
         throw ex;
      }
  }

      /**
   * Post Request for Measurements XLS
   * Use this endpoint to schedule a XLS export containing all user measurements to be emailed to the user within 24 hours.
   * @param accessToken User&#39;s OAuth2 access token
  */
  public void v2MeasurementsRequestXlsPost (String accessToken, final Response.Listener<Integer> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = null;

  

    // create path and map variables
    String path = "/v2/measurements/request_xls".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();

    queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));


    String[] contentTypes = {
      "application/json"
    };
    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
      

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
    } else {
      // normal form params
          }

      String[] authNames = new String[] { "quantimodo_oauth2" };

    try {
      apiInvoker.invokeAPI(basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType, authNames,
        new Response.Listener<String>() {
          @Override
          public void onResponse(String localVarResponse) {
            try {
              responseListener.onResponse((Integer) ApiInvoker.deserialize(localVarResponse,  "", Integer.class));
            } catch (ApiException exception) {
               errorListener.onErrorResponse(new VolleyError(exception));
            }
          }
      }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
            errorListener.onErrorResponse(error);
          }
      });
    } catch (ApiException ex) {
      errorListener.onErrorResponse(new VolleyError(ex));
    }
  }
}
