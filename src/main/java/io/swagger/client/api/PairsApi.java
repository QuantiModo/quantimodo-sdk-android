package io.swagger.client.api;

import io.swagger.client.ApiInvoker;
import io.swagger.client.ApiException;
import io.swagger.client.Pair;

import io.swagger.client.model.*;

import java.util.*;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import io.swagger.client.model.Pairs;

import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class PairsApi {
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
  * Get pairs
  * Pairs cause measurements with effect measurements grouped over the duration of action after the onset delay.
   * @param cause Original variable name for the explanatory or independent variable
   * @param effect Original variable name for the outcome or dependent variable
   * @param accessToken User&#39;s OAuth2 access token
   * @param causeSource Name of data source that the cause measurements should come from
   * @param causeUnit Abbreviated name for the unit cause measurements to be returned in
   * @param delay Delay before onset of action (in seconds) from the cause variable settings.
   * @param duration Duration of action (in seconds) from the cause variable settings.
   * @param effectSource Name of data source that the effectmeasurements should come from
   * @param effectUnit Abbreviated name for the unit effect measurements to be returned in
   * @param endTime The most recent date (in epoch time) for which we should return measurements
   * @param startTime The earliest date (in epoch time) for which we should return measurements
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0.
   * @param offset Now suppose you wanted to show results 11-20. You&#39;d set the offset to 10 and the limit to 10.
   * @param sort Sort by given field. If the field is prefixed with &#x60;-, it will sort in descending order.
   * @return List<Pairs>
  */
  public List<Pairs> v1PairsCsvGet (String cause, String effect, String accessToken, String causeSource, String causeUnit, String delay, String duration, String effectSource, String effectUnit, String endTime, String startTime, Integer limit, Integer offset, Integer sort) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = null;
  
      // verify the required parameter 'cause' is set
      if (cause == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'cause' when calling v1PairsCsvGet",
      new ApiException(400, "Missing the required parameter 'cause' when calling v1PairsCsvGet"));
      }
  
      // verify the required parameter 'effect' is set
      if (effect == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'effect' when calling v1PairsCsvGet",
      new ApiException(400, "Missing the required parameter 'effect' when calling v1PairsCsvGet"));
      }
  

  // create path and map variables
  String path = "/v1/pairsCsv".replaceAll("\\{format\\}","json");

  // query params
  List<Pair> queryParams = new ArrayList<Pair>();
      // header params
      Map<String, String> headerParams = new HashMap<String, String>();
      // form params
      Map<String, String> formParams = new HashMap<String, String>();

          queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "cause", cause));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "causeSource", causeSource));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "causeUnit", causeUnit));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "delay", delay));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "duration", duration));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "effect", effect));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "effectSource", effectSource));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "effectUnit", effectUnit));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "endTime", endTime));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "startTime", startTime));
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
           return (List<Pairs>) ApiInvoker.deserialize(localVarResponse, "array", Pairs.class);
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
   * Get pairs
   * Pairs cause measurements with effect measurements grouped over the duration of action after the onset delay.
   * @param cause Original variable name for the explanatory or independent variable   * @param effect Original variable name for the outcome or dependent variable   * @param accessToken User&#39;s OAuth2 access token   * @param causeSource Name of data source that the cause measurements should come from   * @param causeUnit Abbreviated name for the unit cause measurements to be returned in   * @param delay Delay before onset of action (in seconds) from the cause variable settings.   * @param duration Duration of action (in seconds) from the cause variable settings.   * @param effectSource Name of data source that the effectmeasurements should come from   * @param effectUnit Abbreviated name for the unit effect measurements to be returned in   * @param endTime The most recent date (in epoch time) for which we should return measurements   * @param startTime The earliest date (in epoch time) for which we should return measurements   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0.   * @param offset Now suppose you wanted to show results 11-20. You&#39;d set the offset to 10 and the limit to 10.   * @param sort Sort by given field. If the field is prefixed with &#x60;-, it will sort in descending order.
  */
  public void v1PairsCsvGet (String cause, String effect, String accessToken, String causeSource, String causeUnit, String delay, String duration, String effectSource, String effectUnit, String endTime, String startTime, Integer limit, Integer offset, Integer sort, final Response.Listener<List<Pairs>> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = null;

  
    // verify the required parameter 'cause' is set
    if (cause == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'cause' when calling v1PairsCsvGet",
         new ApiException(400, "Missing the required parameter 'cause' when calling v1PairsCsvGet"));
    }
    
    // verify the required parameter 'effect' is set
    if (effect == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'effect' when calling v1PairsCsvGet",
         new ApiException(400, "Missing the required parameter 'effect' when calling v1PairsCsvGet"));
    }
    

    // create path and map variables
    String path = "/v1/pairsCsv".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();

    queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "cause", cause));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "causeSource", causeSource));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "causeUnit", causeUnit));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "delay", delay));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "duration", duration));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "effect", effect));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "effectSource", effectSource));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "effectUnit", effectUnit));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "endTime", endTime));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "startTime", startTime));
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
              responseListener.onResponse((List<Pairs>) ApiInvoker.deserialize(localVarResponse,  "array", Pairs.class));
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
  * Get pairs
  * Pairs cause measurements with effect measurements grouped over the duration of action after the onset delay.
   * @param cause Original variable name for the explanatory or independent variable
   * @param effect Original variable name for the outcome or dependent variable
   * @param accessToken User&#39;s OAuth2 access token
   * @param causeSource Name of data source that the cause measurements should come from
   * @param causeUnit Abbreviated name for the unit cause measurements to be returned in
   * @param delay Delay before onset of action (in seconds) from the cause variable settings.
   * @param duration Duration of action (in seconds) from the cause variable settings.
   * @param effectSource Name of data source that the effectmeasurements should come from
   * @param effectUnit Abbreviated name for the unit effect measurements to be returned in
   * @param endTime The most recent date (in epoch time) for which we should return measurements
   * @param startTime The earliest date (in epoch time) for which we should return measurements
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0.
   * @param offset Now suppose you wanted to show results 11-20. You&#39;d set the offset to 10 and the limit to 10.
   * @param sort Sort by given field. If the field is prefixed with &#x60;-, it will sort in descending order.
   * @return List<Pairs>
  */
  public List<Pairs> v1PairsGet (String cause, String effect, String accessToken, String causeSource, String causeUnit, String delay, String duration, String effectSource, String effectUnit, String endTime, String startTime, Integer limit, Integer offset, Integer sort) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = null;
  
      // verify the required parameter 'cause' is set
      if (cause == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'cause' when calling v1PairsGet",
      new ApiException(400, "Missing the required parameter 'cause' when calling v1PairsGet"));
      }
  
      // verify the required parameter 'effect' is set
      if (effect == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'effect' when calling v1PairsGet",
      new ApiException(400, "Missing the required parameter 'effect' when calling v1PairsGet"));
      }
  

  // create path and map variables
  String path = "/v1/pairs".replaceAll("\\{format\\}","json");

  // query params
  List<Pair> queryParams = new ArrayList<Pair>();
      // header params
      Map<String, String> headerParams = new HashMap<String, String>();
      // form params
      Map<String, String> formParams = new HashMap<String, String>();

          queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "cause", cause));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "causeSource", causeSource));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "causeUnit", causeUnit));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "delay", delay));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "duration", duration));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "effect", effect));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "effectSource", effectSource));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "effectUnit", effectUnit));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "endTime", endTime));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "startTime", startTime));
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
           return (List<Pairs>) ApiInvoker.deserialize(localVarResponse, "array", Pairs.class);
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
   * Get pairs
   * Pairs cause measurements with effect measurements grouped over the duration of action after the onset delay.
   * @param cause Original variable name for the explanatory or independent variable   * @param effect Original variable name for the outcome or dependent variable   * @param accessToken User&#39;s OAuth2 access token   * @param causeSource Name of data source that the cause measurements should come from   * @param causeUnit Abbreviated name for the unit cause measurements to be returned in   * @param delay Delay before onset of action (in seconds) from the cause variable settings.   * @param duration Duration of action (in seconds) from the cause variable settings.   * @param effectSource Name of data source that the effectmeasurements should come from   * @param effectUnit Abbreviated name for the unit effect measurements to be returned in   * @param endTime The most recent date (in epoch time) for which we should return measurements   * @param startTime The earliest date (in epoch time) for which we should return measurements   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0.   * @param offset Now suppose you wanted to show results 11-20. You&#39;d set the offset to 10 and the limit to 10.   * @param sort Sort by given field. If the field is prefixed with &#x60;-, it will sort in descending order.
  */
  public void v1PairsGet (String cause, String effect, String accessToken, String causeSource, String causeUnit, String delay, String duration, String effectSource, String effectUnit, String endTime, String startTime, Integer limit, Integer offset, Integer sort, final Response.Listener<List<Pairs>> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = null;

  
    // verify the required parameter 'cause' is set
    if (cause == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'cause' when calling v1PairsGet",
         new ApiException(400, "Missing the required parameter 'cause' when calling v1PairsGet"));
    }
    
    // verify the required parameter 'effect' is set
    if (effect == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'effect' when calling v1PairsGet",
         new ApiException(400, "Missing the required parameter 'effect' when calling v1PairsGet"));
    }
    

    // create path and map variables
    String path = "/v1/pairs".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();

    queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "cause", cause));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "causeSource", causeSource));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "causeUnit", causeUnit));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "delay", delay));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "duration", duration));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "effect", effect));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "effectSource", effectSource));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "effectUnit", effectUnit));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "endTime", endTime));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "startTime", startTime));
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
              responseListener.onResponse((List<Pairs>) ApiInvoker.deserialize(localVarResponse,  "array", Pairs.class));
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
