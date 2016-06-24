package io.swagger.client.api;

import io.swagger.client.ApiInvoker;
import io.swagger.client.ApiException;
import io.swagger.client.Pair;

import io.swagger.client.model.*;

import java.util.*;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import io.swagger.client.model.Variable;
import io.swagger.client.model.UserVariables;
import io.swagger.client.model.VariableCategory;
import io.swagger.client.model.VariablesNew;

import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class VariablesApi {
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
  * Get public variables
  * This endpoint retrieves an array of all public variables. Public variables are things like foods, medications, symptoms, conditions, and anything not unique to a particular user. For instance, a telephone number or name would not be a public variable.
   * @return Variable
  */
  public Variable v1PublicVariablesGet () throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = null;
  

  // create path and map variables
  String path = "/v1/public/variables".replaceAll("\\{format\\}","json");

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
           return (Variable) ApiInvoker.deserialize(localVarResponse, "", Variable.class);
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
   * Get public variables
   * This endpoint retrieves an array of all public variables. Public variables are things like foods, medications, symptoms, conditions, and anything not unique to a particular user. For instance, a telephone number or name would not be a public variable.

  */
  public void v1PublicVariablesGet (final Response.Listener<Variable> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = null;

  

    // create path and map variables
    String path = "/v1/public/variables".replaceAll("\\{format\\}","json");

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
              responseListener.onResponse((Variable) ApiInvoker.deserialize(localVarResponse,  "", Variable.class));
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
  * Get top 5 PUBLIC variables with the most correlations
  * Get top 5 PUBLIC variables with the most correlations containing the entered search characters. For example, search for &#39;mood&#39; as an effect. Since &#39;Overall Mood&#39; has a lot of correlations with other variables, it should be in the autocomplete list.&lt;br&gt;Supported filter parameters:&lt;br&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;category&lt;/b&gt; - Category of Variable&lt;/li&gt;&lt;/ul&gt;&lt;br&gt;
   * @param search Search query can be some fraction of a variable name.
   * @param accessToken User&#39;s OAuth2 access token
   * @param categoryName Filter variables by category name. The variable categories include Activity, Causes of Illness, Cognitive Performance, Conditions, Environment, Foods, Location, Miscellaneous, Mood, Nutrition, Physical Activity, Physique, Sleep, Social Interactions, Symptoms, Treatments, Vital Signs, and Work.
   * @param source Specify a data source name to only return variables from a specific data source.
   * @param effectOrCause Indicate if you only want variables that have user correlations.  Possible values are effect and cause.
   * @param publicEffectOrCause Indicate if you only want variables that have aggregated correlations.  Possible values are effect and cause.
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0.
   * @param offset Now suppose you wanted to show results 11-20. You&#39;d set the offset to 10 and the limit to 10.
   * @param sort Sort by given field. If the field is prefixed with &#x60;-, it will sort in descending order.
   * @return Variable
  */
  public Variable v1PublicVariablesSearchSearchGet (String search, String accessToken, String categoryName, String source, String effectOrCause, String publicEffectOrCause, Integer limit, Integer offset, Integer sort) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = null;
  
      // verify the required parameter 'search' is set
      if (search == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'search' when calling v1PublicVariablesSearchSearchGet",
      new ApiException(400, "Missing the required parameter 'search' when calling v1PublicVariablesSearchSearchGet"));
      }
  

  // create path and map variables
  String path = "/v1/public/variables/search/{search}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "search" + "\\}", apiInvoker.escapeString(search.toString()));

  // query params
  List<Pair> queryParams = new ArrayList<Pair>();
      // header params
      Map<String, String> headerParams = new HashMap<String, String>();
      // form params
      Map<String, String> formParams = new HashMap<String, String>();

          queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "categoryName", categoryName));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "source", source));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "effectOrCause", effectOrCause));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "publicEffectOrCause", publicEffectOrCause));
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
           return (Variable) ApiInvoker.deserialize(localVarResponse, "", Variable.class);
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
   * Get top 5 PUBLIC variables with the most correlations
   * Get top 5 PUBLIC variables with the most correlations containing the entered search characters. For example, search for &#39;mood&#39; as an effect. Since &#39;Overall Mood&#39; has a lot of correlations with other variables, it should be in the autocomplete list.&lt;br&gt;Supported filter parameters:&lt;br&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;category&lt;/b&gt; - Category of Variable&lt;/li&gt;&lt;/ul&gt;&lt;br&gt;
   * @param search Search query can be some fraction of a variable name.   * @param accessToken User&#39;s OAuth2 access token   * @param categoryName Filter variables by category name. The variable categories include Activity, Causes of Illness, Cognitive Performance, Conditions, Environment, Foods, Location, Miscellaneous, Mood, Nutrition, Physical Activity, Physique, Sleep, Social Interactions, Symptoms, Treatments, Vital Signs, and Work.   * @param source Specify a data source name to only return variables from a specific data source.   * @param effectOrCause Indicate if you only want variables that have user correlations.  Possible values are effect and cause.   * @param publicEffectOrCause Indicate if you only want variables that have aggregated correlations.  Possible values are effect and cause.   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0.   * @param offset Now suppose you wanted to show results 11-20. You&#39;d set the offset to 10 and the limit to 10.   * @param sort Sort by given field. If the field is prefixed with &#x60;-, it will sort in descending order.
  */
  public void v1PublicVariablesSearchSearchGet (String search, String accessToken, String categoryName, String source, String effectOrCause, String publicEffectOrCause, Integer limit, Integer offset, Integer sort, final Response.Listener<Variable> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = null;

  
    // verify the required parameter 'search' is set
    if (search == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'search' when calling v1PublicVariablesSearchSearchGet",
         new ApiException(400, "Missing the required parameter 'search' when calling v1PublicVariablesSearchSearchGet"));
    }
    

    // create path and map variables
    String path = "/v1/public/variables/search/{search}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "search" + "\\}", apiInvoker.escapeString(search.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();

    queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "categoryName", categoryName));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "source", source));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "effectOrCause", effectOrCause));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "publicEffectOrCause", publicEffectOrCause));
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
              responseListener.onResponse((Variable) ApiInvoker.deserialize(localVarResponse,  "", Variable.class));
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
  * Update User Settings for a Variable
  * Users can change the parameters used in analysis of that variable such as the expected duration of action for a variable to have an effect, the estimated delay before the onset of action. In order to filter out erroneous data, they are able to set the maximum and minimum reasonable daily values for a variable.
   * @param userVariables Variable user settings data
   * @return void
  */
  public void v1UserVariablesPost (UserVariables userVariables) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = userVariables;
  
      // verify the required parameter 'userVariables' is set
      if (userVariables == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'userVariables' when calling v1UserVariablesPost",
      new ApiException(400, "Missing the required parameter 'userVariables' when calling v1UserVariablesPost"));
      }
  

  // create path and map variables
  String path = "/v1/userVariables".replaceAll("\\{format\\}","json");

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
   * Update User Settings for a Variable
   * Users can change the parameters used in analysis of that variable such as the expected duration of action for a variable to have an effect, the estimated delay before the onset of action. In order to filter out erroneous data, they are able to set the maximum and minimum reasonable daily values for a variable.
   * @param userVariables Variable user settings data
  */
  public void v1UserVariablesPost (UserVariables userVariables, final Response.Listener<String> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = userVariables;

  
    // verify the required parameter 'userVariables' is set
    if (userVariables == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'userVariables' when calling v1UserVariablesPost",
         new ApiException(400, "Missing the required parameter 'userVariables' when calling v1UserVariablesPost"));
    }
    

    // create path and map variables
    String path = "/v1/userVariables".replaceAll("\\{format\\}","json");

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
  * Variable categories
  * The variable categories include Activity, Causes of Illness, Cognitive Performance, Conditions, Environment, Foods, Location, Miscellaneous, Mood, Nutrition, Physical Activity, Physique, Sleep, Social Interactions, Symptoms, Treatments, Vital Signs, and Work.
   * @return List<VariableCategory>
  */
  public List<VariableCategory> v1VariableCategoriesGet () throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = null;
  

  // create path and map variables
  String path = "/v1/variableCategories".replaceAll("\\{format\\}","json");

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
           return (List<VariableCategory>) ApiInvoker.deserialize(localVarResponse, "array", VariableCategory.class);
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
   * Variable categories
   * The variable categories include Activity, Causes of Illness, Cognitive Performance, Conditions, Environment, Foods, Location, Miscellaneous, Mood, Nutrition, Physical Activity, Physique, Sleep, Social Interactions, Symptoms, Treatments, Vital Signs, and Work.

  */
  public void v1VariableCategoriesGet (final Response.Listener<List<VariableCategory>> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = null;

  

    // create path and map variables
    String path = "/v1/variableCategories".replaceAll("\\{format\\}","json");

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
              responseListener.onResponse((List<VariableCategory>) ApiInvoker.deserialize(localVarResponse,  "array", VariableCategory.class));
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
  * Get variables by the category name
  * Get variables by the category name. &lt;br&gt;Supported filter parameters:&lt;br&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;name&lt;/b&gt; - Original name of the variable (supports exact name match only)&lt;/li&gt;&lt;li&gt;&lt;b&gt;lastUpdated&lt;/b&gt; - Filter by the last time any of the properties of the variable were changed. Uses UTC format \&quot;YYYY-MM-DDThh:mm:ss\&quot;&lt;/li&gt;&lt;li&gt;&lt;b&gt;source&lt;/b&gt; - The name of the data source that created the variable (supports exact name match only). So if you have a client application and you only want variables that were last updated by your app, you can include the name of your app here&lt;/li&gt;&lt;li&gt;&lt;b&gt;latestMeasurementTime&lt;/b&gt; - Filter variables based on the last time a measurement for them was created or updated in the UTC format \&quot;YYYY-MM-DDThh:mm:ss\&quot;&lt;/li&gt;&lt;li&gt;&lt;b&gt;numberOfMeasurements&lt;/b&gt; - Filter variables by the total number of measurements that they have. This could be used of you want to filter or sort by popularity.&lt;/li&gt;&lt;li&gt;&lt;b&gt;lastSource&lt;/b&gt; - Limit variables to those which measurements were last submitted by a specific source. So if you have a client application and you only want variables that were last updated by your app, you can include the name of your app here. (supports exact name match only)&lt;/li&gt;&lt;/ul&gt;&lt;br&gt;
   * @param accessToken User&#39;s OAuth2 access token
   * @param id Common variable id
   * @param userId User id
   * @param category Filter data by category
   * @param name Original name of the variable (supports exact name match only)
   * @param lastUpdated Filter by the last time any of the properties of the variable were changed. Uses UTC format \&quot;YYYY-MM-DDThh:mm:ss\&quot;
   * @param source The name of the data source that created the variable (supports exact name match only). So if you have a client application and you only want variables that were last updated by your app, you can include the name of your app here
   * @param latestMeasurementTime Filter variables based on the last time a measurement for them was created or updated in the UTC format \&quot;YYYY-MM-DDThh:mm:ss\&quot;
   * @param numberOfMeasurements Filter variables by the total number of measurements that they have. This could be used of you want to filter or sort by popularity.
   * @param lastSource Limit variables to those which measurements were last submitted by a specific source. So if you have a client application and you only want variables that were last updated by your app, you can include the name of your app here. (supports exact name match only)
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0.
   * @param offset Now suppose you wanted to show results 11-20. You&#39;d set the offset to 10 and the limit to 10.
   * @param sort Sort by given field. If the field is prefixed with &#x60;-, it will sort in descending order.
   * @return Variable
  */
  public Variable v1VariablesGet (String accessToken, Integer id, Integer userId, String category, String name, String lastUpdated, String source, String latestMeasurementTime, String numberOfMeasurements, String lastSource, Integer limit, Integer offset, Integer sort) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = null;
  

  // create path and map variables
  String path = "/v1/variables".replaceAll("\\{format\\}","json");

  // query params
  List<Pair> queryParams = new ArrayList<Pair>();
      // header params
      Map<String, String> headerParams = new HashMap<String, String>();
      // form params
      Map<String, String> formParams = new HashMap<String, String>();

          queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "id", id));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "userId", userId));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "category", category));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "name", name));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "lastUpdated", lastUpdated));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "source", source));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "latestMeasurementTime", latestMeasurementTime));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "numberOfMeasurements", numberOfMeasurements));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "lastSource", lastSource));
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

      String[] authNames = new String[] { "oauth2", "basicAuth" };

      try {
        String localVarResponse = apiInvoker.invokeAPI (basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames);
        if(localVarResponse != null){
           return (Variable) ApiInvoker.deserialize(localVarResponse, "", Variable.class);
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
   * Get variables by the category name
   * Get variables by the category name. &lt;br&gt;Supported filter parameters:&lt;br&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;name&lt;/b&gt; - Original name of the variable (supports exact name match only)&lt;/li&gt;&lt;li&gt;&lt;b&gt;lastUpdated&lt;/b&gt; - Filter by the last time any of the properties of the variable were changed. Uses UTC format \&quot;YYYY-MM-DDThh:mm:ss\&quot;&lt;/li&gt;&lt;li&gt;&lt;b&gt;source&lt;/b&gt; - The name of the data source that created the variable (supports exact name match only). So if you have a client application and you only want variables that were last updated by your app, you can include the name of your app here&lt;/li&gt;&lt;li&gt;&lt;b&gt;latestMeasurementTime&lt;/b&gt; - Filter variables based on the last time a measurement for them was created or updated in the UTC format \&quot;YYYY-MM-DDThh:mm:ss\&quot;&lt;/li&gt;&lt;li&gt;&lt;b&gt;numberOfMeasurements&lt;/b&gt; - Filter variables by the total number of measurements that they have. This could be used of you want to filter or sort by popularity.&lt;/li&gt;&lt;li&gt;&lt;b&gt;lastSource&lt;/b&gt; - Limit variables to those which measurements were last submitted by a specific source. So if you have a client application and you only want variables that were last updated by your app, you can include the name of your app here. (supports exact name match only)&lt;/li&gt;&lt;/ul&gt;&lt;br&gt;
   * @param accessToken User&#39;s OAuth2 access token   * @param id Common variable id   * @param userId User id   * @param category Filter data by category   * @param name Original name of the variable (supports exact name match only)   * @param lastUpdated Filter by the last time any of the properties of the variable were changed. Uses UTC format \&quot;YYYY-MM-DDThh:mm:ss\&quot;   * @param source The name of the data source that created the variable (supports exact name match only). So if you have a client application and you only want variables that were last updated by your app, you can include the name of your app here   * @param latestMeasurementTime Filter variables based on the last time a measurement for them was created or updated in the UTC format \&quot;YYYY-MM-DDThh:mm:ss\&quot;   * @param numberOfMeasurements Filter variables by the total number of measurements that they have. This could be used of you want to filter or sort by popularity.   * @param lastSource Limit variables to those which measurements were last submitted by a specific source. So if you have a client application and you only want variables that were last updated by your app, you can include the name of your app here. (supports exact name match only)   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0.   * @param offset Now suppose you wanted to show results 11-20. You&#39;d set the offset to 10 and the limit to 10.   * @param sort Sort by given field. If the field is prefixed with &#x60;-, it will sort in descending order.
  */
  public void v1VariablesGet (String accessToken, Integer id, Integer userId, String category, String name, String lastUpdated, String source, String latestMeasurementTime, String numberOfMeasurements, String lastSource, Integer limit, Integer offset, Integer sort, final Response.Listener<Variable> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = null;

  

    // create path and map variables
    String path = "/v1/variables".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();

    queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "id", id));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "userId", userId));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "category", category));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "name", name));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "lastUpdated", lastUpdated));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "source", source));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "latestMeasurementTime", latestMeasurementTime));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "numberOfMeasurements", numberOfMeasurements));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "lastSource", lastSource));
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

      String[] authNames = new String[] { "oauth2", "basicAuth" };

    try {
      apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames,
        new Response.Listener<String>() {
          @Override
          public void onResponse(String localVarResponse) {
            try {
              responseListener.onResponse((Variable) ApiInvoker.deserialize(localVarResponse,  "", Variable.class));
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
  * Create Variables
  * Allows the client to create a new variable in the &#x60;variables&#x60; table.
   * @param body Original name for the variable.
   * @param accessToken User&#39;s OAuth2 access token
   * @return void
  */
  public void v1VariablesPost (VariablesNew body, String accessToken) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = body;
  
      // verify the required parameter 'body' is set
      if (body == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'body' when calling v1VariablesPost",
      new ApiException(400, "Missing the required parameter 'body' when calling v1VariablesPost"));
      }
  

  // create path and map variables
  String path = "/v1/variables".replaceAll("\\{format\\}","json");

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
   * Create Variables
   * Allows the client to create a new variable in the &#x60;variables&#x60; table.
   * @param body Original name for the variable.   * @param accessToken User&#39;s OAuth2 access token
  */
  public void v1VariablesPost (VariablesNew body, String accessToken, final Response.Listener<String> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = body;

  
    // verify the required parameter 'body' is set
    if (body == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'body' when calling v1VariablesPost",
         new ApiException(400, "Missing the required parameter 'body' when calling v1VariablesPost"));
    }
    

    // create path and map variables
    String path = "/v1/variables".replaceAll("\\{format\\}","json");

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
  * Get variables by search query
  * Get variables containing the search characters for which the currently logged in user has measurements. Used to provide auto-complete function in variable search boxes.
   * @param search Search query which may be an entire variable name or a fragment of one.
   * @param accessToken User&#39;s OAuth2 access token
   * @param categoryName Filter variables by category name. The variable categories include Activity, Causes of Illness, Cognitive Performance, Conditions, Environment, Foods, Location, Miscellaneous, Mood, Nutrition, Physical Activity, Physique, Sleep, Social Interactions, Symptoms, Treatments, Vital Signs, and Work.
   * @param includePublic Set to true if you would like to include public variables when no user variables are found.
   * @param manualTracking Set to true if you would like to exlude variables like apps and website names.
   * @param source Specify a data source name to only return variables from a specific data source.
   * @param effectOrCause Indicate if you only want variables that have user correlations.  Possible values are effect and cause.
   * @param publicEffectOrCause Indicate if you only want variables that have aggregated correlations.  Possible values are effect and cause.
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0.
   * @param offset Now suppose you wanted to show results 11-20. You&#39;d set the offset to 10 and the limit to 10.
   * @return List<Variable>
  */
  public List<Variable> v1VariablesSearchSearchGet (String search, String accessToken, String categoryName, Boolean includePublic, Boolean manualTracking, String source, String effectOrCause, String publicEffectOrCause, Integer limit, Integer offset) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = null;
  
      // verify the required parameter 'search' is set
      if (search == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'search' when calling v1VariablesSearchSearchGet",
      new ApiException(400, "Missing the required parameter 'search' when calling v1VariablesSearchSearchGet"));
      }
  

  // create path and map variables
  String path = "/v1/variables/search/{search}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "search" + "\\}", apiInvoker.escapeString(search.toString()));

  // query params
  List<Pair> queryParams = new ArrayList<Pair>();
      // header params
      Map<String, String> headerParams = new HashMap<String, String>();
      // form params
      Map<String, String> formParams = new HashMap<String, String>();

          queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "categoryName", categoryName));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "includePublic", includePublic));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "manualTracking", manualTracking));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "source", source));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "effectOrCause", effectOrCause));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "publicEffectOrCause", publicEffectOrCause));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "limit", limit));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "offset", offset));


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
           return (List<Variable>) ApiInvoker.deserialize(localVarResponse, "array", Variable.class);
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
   * Get variables by search query
   * Get variables containing the search characters for which the currently logged in user has measurements. Used to provide auto-complete function in variable search boxes.
   * @param search Search query which may be an entire variable name or a fragment of one.   * @param accessToken User&#39;s OAuth2 access token   * @param categoryName Filter variables by category name. The variable categories include Activity, Causes of Illness, Cognitive Performance, Conditions, Environment, Foods, Location, Miscellaneous, Mood, Nutrition, Physical Activity, Physique, Sleep, Social Interactions, Symptoms, Treatments, Vital Signs, and Work.   * @param includePublic Set to true if you would like to include public variables when no user variables are found.   * @param manualTracking Set to true if you would like to exlude variables like apps and website names.   * @param source Specify a data source name to only return variables from a specific data source.   * @param effectOrCause Indicate if you only want variables that have user correlations.  Possible values are effect and cause.   * @param publicEffectOrCause Indicate if you only want variables that have aggregated correlations.  Possible values are effect and cause.   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0.   * @param offset Now suppose you wanted to show results 11-20. You&#39;d set the offset to 10 and the limit to 10.
  */
  public void v1VariablesSearchSearchGet (String search, String accessToken, String categoryName, Boolean includePublic, Boolean manualTracking, String source, String effectOrCause, String publicEffectOrCause, Integer limit, Integer offset, final Response.Listener<List<Variable>> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = null;

  
    // verify the required parameter 'search' is set
    if (search == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'search' when calling v1VariablesSearchSearchGet",
         new ApiException(400, "Missing the required parameter 'search' when calling v1VariablesSearchSearchGet"));
    }
    

    // create path and map variables
    String path = "/v1/variables/search/{search}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "search" + "\\}", apiInvoker.escapeString(search.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();

    queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "categoryName", categoryName));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "includePublic", includePublic));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "manualTracking", manualTracking));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "source", source));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "effectOrCause", effectOrCause));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "publicEffectOrCause", publicEffectOrCause));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "limit", limit));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "offset", offset));


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
              responseListener.onResponse((List<Variable>) ApiInvoker.deserialize(localVarResponse,  "array", Variable.class));
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
  * Get info about a variable
  * Get all of the settings and information about a variable by its name. If the logged in user has modified the settings for the variable, these will be provided instead of the default settings for that variable.
   * @param variableName Variable name
   * @param accessToken User&#39;s OAuth2 access token
   * @return Variable
  */
  public Variable v1VariablesVariableNameGet (String variableName, String accessToken) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = null;
  
      // verify the required parameter 'variableName' is set
      if (variableName == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'variableName' when calling v1VariablesVariableNameGet",
      new ApiException(400, "Missing the required parameter 'variableName' when calling v1VariablesVariableNameGet"));
      }
  

  // create path and map variables
  String path = "/v1/variables/{variableName}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "variableName" + "\\}", apiInvoker.escapeString(variableName.toString()));

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
        String localVarResponse = apiInvoker.invokeAPI (basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames);
        if(localVarResponse != null){
           return (Variable) ApiInvoker.deserialize(localVarResponse, "", Variable.class);
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
   * Get info about a variable
   * Get all of the settings and information about a variable by its name. If the logged in user has modified the settings for the variable, these will be provided instead of the default settings for that variable.
   * @param variableName Variable name   * @param accessToken User&#39;s OAuth2 access token
  */
  public void v1VariablesVariableNameGet (String variableName, String accessToken, final Response.Listener<Variable> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = null;

  
    // verify the required parameter 'variableName' is set
    if (variableName == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'variableName' when calling v1VariablesVariableNameGet",
         new ApiException(400, "Missing the required parameter 'variableName' when calling v1VariablesVariableNameGet"));
    }
    

    // create path and map variables
    String path = "/v1/variables/{variableName}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "variableName" + "\\}", apiInvoker.escapeString(variableName.toString()));

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
      apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames,
        new Response.Listener<String>() {
          @Override
          public void onResponse(String localVarResponse) {
            try {
              responseListener.onResponse((Variable) ApiInvoker.deserialize(localVarResponse,  "", Variable.class));
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
