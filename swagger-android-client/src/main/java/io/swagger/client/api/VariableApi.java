package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.ApiInvoker;
import io.swagger.client.Pair;

import io.swagger.client.SwaggerClient;
import io.swagger.client.model.*;

import java.util.*;

import io.swagger.client.model.InlineResponse20031;
import java.math.BigDecimal;
import io.swagger.client.model.Variable;
import io.swagger.client.model.InlineResponse20032;
import io.swagger.client.model.InlineResponse2002;

import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.util.Map;
import java.util.HashMap;
import java.io.File;

public class VariableApi {
  String basePath = SwaggerClient.getInstance().getAppBasePath();
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
   * Get all Variables
   * Get all Variables
   * @param accessToken User&#39;s OAuth2 access token
   * @param id id
   * @param clientId The ID of the client application which last created or updated this common variable
   * @param parentId ID of the parent variable if this variable has any parent
   * @param name User-defined variable display name
   * @param variableCategoryId Variable category ID
   * @param defaultUnitId ID of the default unit for the variable
   * @param combinationOperation How to combine values of this variable (for instance, to see a summary of the values over a month) SUM or MEAN
   * @param fillingValue Value for replacing null measurements
   * @param maximumAllowedValue Maximum reasonable value for this variable (uses default unit)
   * @param minimumAllowedValue Minimum reasonable value for this variable (uses default unit)
   * @param onsetDelay Estimated number of seconds that pass before a stimulus produces a perceivable effect
   * @param durationOfAction Estimated number of seconds following the onset delay in which a stimulus produces a perceivable effect
   * @param _public Is variable public
   * @param causeOnly A value of 1 indicates that this variable is generally a cause in a causal relationship.  An example of a causeOnly variable would be a variable such as Cloud Cover which would generally not be influenced by the behaviour of the user
   * @param mostCommonValue Most common value
   * @param mostCommonUnitId Most common Unit
   * @param standardDeviation Standard Deviation
   * @param variance Average variance for this variable based on all user data
   * @param mean Mean for this variable based on all user data
   * @param median Median for this variable based on all user data
   * @param numberOfMeasurements Number of measurements for this variable based on all user data
   * @param numberOfUniqueValues Number of unique values for this variable based on all user data
   * @param skewness Skewness for this variable based on all user data
   * @param kurtosis Kurtosis for this variable based on all user data
   * @param status status
   * @param errorMessage error_message
   * @param lastSuccessfulUpdateTime When this variable or its settings were last updated
   * @param createdAt When the record was first created. Use ISO 8601 datetime format
   * @param updatedAt When the record was last updated. Use ISO 8601 datetime format
   * @param productUrl Product URL
   * @param imageUrl Image URL
   * @param price Price
   * @param numberOfUserVariables Number of users who have data for this variable
   * @param outcome Outcome variables (those with `outcome` == 1) are variables for which a human would generally want to identify the influencing factors.  These include symptoms of illness, physique, mood, cognitive performance, etc.  Generally correlation calculations are only performed on outcome variables.
   * @param minimumRecordedValue Minimum recorded value of this variable based on all user data
   * @param maximumRecordedValue Maximum recorded value of this variable based on all user data
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records.
   * @param offset OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned.
   * @param sort Sort records by a given field name. If the field name is prefixed with &#39;-&#39;, it will sort in descending order.
   * @return InlineResponse20031
   */
  public InlineResponse20031  variablesGet (String accessToken, Integer id, String clientId, Integer parentId, String name, Integer variableCategoryId, Integer defaultUnitId, String combinationOperation, BigDecimal fillingValue, BigDecimal maximumAllowedValue, BigDecimal minimumAllowedValue, Integer onsetDelay, Integer durationOfAction, Integer _public, Boolean causeOnly, BigDecimal mostCommonValue, Integer mostCommonUnitId, BigDecimal standardDeviation, BigDecimal variance, BigDecimal mean, BigDecimal median, BigDecimal numberOfMeasurements, BigDecimal numberOfUniqueValues, BigDecimal skewness, BigDecimal kurtosis, String status, String errorMessage, String lastSuccessfulUpdateTime, String createdAt, String updatedAt, String productUrl, String imageUrl, BigDecimal price, Integer numberOfUserVariables, Boolean outcome, BigDecimal minimumRecordedValue, BigDecimal maximumRecordedValue, Integer limit, Integer offset, String sort) throws ApiException {
    Object postBody = null;
    

    // create path and map variables
    String path = "/variables".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();

    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "id", id));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "client_id", clientId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "parent_id", parentId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "name", name));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "variable_category_id", variableCategoryId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "default_unit_id", defaultUnitId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "combination_operation", combinationOperation));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "filling_value", fillingValue));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "maximum_allowed_value", maximumAllowedValue));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "minimum_allowed_value", minimumAllowedValue));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "onset_delay", onsetDelay));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "duration_of_action", durationOfAction));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "public", _public));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "cause_only", causeOnly));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "most_common_value", mostCommonValue));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "most_common_unit_id", mostCommonUnitId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "standard_deviation", standardDeviation));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "variance", variance));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "mean", mean));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "median", median));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "number_of_measurements", numberOfMeasurements));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "number_of_unique_values", numberOfUniqueValues));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "skewness", skewness));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "kurtosis", kurtosis));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "status", status));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "error_message", errorMessage));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "last_successful_update_time", lastSuccessfulUpdateTime));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "created_at", createdAt));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "updated_at", updatedAt));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "product_url", productUrl));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "image_url", imageUrl));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "price", price));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "number_of_user_variables", numberOfUserVariables));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "outcome", outcome));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "minimum_recorded_value", minimumRecordedValue));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "maximum_recorded_value", maximumRecordedValue));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "limit", limit));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "offset", offset));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "sort", sort));
    

    

    String[] contentTypes = {
      "application/json"
    };
    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder builder = MultipartEntityBuilder.create();
      

      HttpEntity httpEntity = builder.build();
      postBody = httpEntity;
    } else {
      // normal form params
      
    }

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType);
      if(response != null){
        return (InlineResponse20031) ApiInvoker.deserialize(response, "", InlineResponse20031.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Store Variable
   * Allows the client to create a new variable in the `variables` table.
   * @param accessToken User&#39;s OAuth2 access token
   * @param body Variable that should be stored
   * @return InlineResponse20032
   */
  public InlineResponse20032  variablesPost (String accessToken, Variable body) throws ApiException {
    Object postBody = body;
    

    // create path and map variables
    String path = "/variables".replaceAll("\\{format\\}","json");

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
      MultipartEntityBuilder builder = MultipartEntityBuilder.create();
      

      HttpEntity httpEntity = builder.build();
      postBody = httpEntity;
    } else {
      // normal form params
      
    }

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType);
      if(response != null){
        return (InlineResponse20032) ApiInvoker.deserialize(response, "", InlineResponse20032.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Get Variable
   * Get Variable
   * @param id id of Variable
   * @param accessToken User&#39;s OAuth2 access token
   * @return InlineResponse20032
   */
  public InlineResponse20032  variablesIdGet (Integer id, String accessToken) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
       throw new ApiException(400, "Missing the required parameter 'id' when calling variablesIdGet");
    }
    

    // create path and map variables
    String path = "/variables/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

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
      MultipartEntityBuilder builder = MultipartEntityBuilder.create();
      

      HttpEntity httpEntity = builder.build();
      postBody = httpEntity;
    } else {
      // normal form params
      
    }

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType);
      if(response != null){
        return (InlineResponse20032) ApiInvoker.deserialize(response, "", InlineResponse20032.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Update Variable
   * Update Variable
   * @param id id of Variable
   * @param accessToken User&#39;s OAuth2 access token
   * @param body Variable that should be updated
   * @return InlineResponse2002
   */
  public InlineResponse2002  variablesIdPut (Integer id, String accessToken, Variable body) throws ApiException {
    Object postBody = body;
    
    // verify the required parameter 'id' is set
    if (id == null) {
       throw new ApiException(400, "Missing the required parameter 'id' when calling variablesIdPut");
    }
    

    // create path and map variables
    String path = "/variables/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

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
      MultipartEntityBuilder builder = MultipartEntityBuilder.create();
      

      HttpEntity httpEntity = builder.build();
      postBody = httpEntity;
    } else {
      // normal form params
      
    }

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "PUT", queryParams, postBody, headerParams, formParams, contentType);
      if(response != null){
        return (InlineResponse2002) ApiInvoker.deserialize(response, "", InlineResponse2002.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Delete Variable
   * Delete Variable
   * @param id id of Variable
   * @param accessToken User&#39;s OAuth2 access token
   * @return InlineResponse2002
   */
  public InlineResponse2002  variablesIdDelete (Integer id, String accessToken) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
       throw new ApiException(400, "Missing the required parameter 'id' when calling variablesIdDelete");
    }
    

    // create path and map variables
    String path = "/variables/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

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
      MultipartEntityBuilder builder = MultipartEntityBuilder.create();
      

      HttpEntity httpEntity = builder.build();
      postBody = httpEntity;
    } else {
      // normal form params
      
    }

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "DELETE", queryParams, postBody, headerParams, formParams, contentType);
      if(response != null){
        return (InlineResponse2002) ApiInvoker.deserialize(response, "", InlineResponse2002.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
}
