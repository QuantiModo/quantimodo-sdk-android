package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.ApiInvoker;
import io.swagger.client.Pair;

import io.swagger.client.model.*;

import java.util.*;

import io.swagger.client.model.InlineResponse20025;
import java.math.BigDecimal;
import io.swagger.client.model.InlineResponse20026;
import io.swagger.client.model.UserVariable;
import io.swagger.client.model.InlineResponse2002;

import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.util.Map;
import java.util.HashMap;
import java.io.File;

public class UserVariableApi {
  String basePath = "https://app.quantimo.do/api/v2";
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
   * Get all UserVariables
   * Get all UserVariables
   * @param accessToken User&#39;s OAuth2 access token
   * @param clientId The ID of the client application which last created or updated this user variable
   * @param parentId ID of the parent variable if this variable has any parent
   * @param variableId ID of variable
   * @param userId User ID
   * @param defaultUnitId D of unit to use for this variable
   * @param minimumAllowedValue Minimum reasonable value for this variable (uses default unit)
   * @param maximumAllowedValue Maximum reasonable value for this variable (uses default unit)
   * @param fillingValue Value for replacing null measurements
   * @param joinWith The Variable this Variable should be joined with. If the variable is joined with some other variable then it is not shown to user in the list of variables
   * @param onsetDelay Estimated number of seconds that pass before a stimulus produces a perceivable effect
   * @param durationOfAction Estimated duration of time following the onset delay in which a stimulus produces a perceivable effect
   * @param variableCategoryId ID of variable category
   * @param updated updated
   * @param _public Is variable public
   * @param causeOnly A value of 1 indicates that this variable is generally a cause in a causal relationship.  An example of a causeOnly variable would be a variable such as Cloud Cover which would generally not be influenced by the behaviour of the user
   * @param fillingType 0 -&gt; No filling, 1 -&gt; Use filling-value
   * @param numberOfMeasurements Number of measurements
   * @param numberOfProcessedMeasurements Number of processed measurements
   * @param measurementsAtLastAnalysis Number of measurements at last analysis
   * @param lastUnitId ID of last Unit
   * @param lastOriginalUnitId ID of last original Unit
   * @param lastOriginalValue Last original value which is stored
   * @param lastValue Last Value
   * @param lastOriginalValue2 Last original value which is stored
   * @param lastSourceId ID of last source
   * @param numberOfCorrelations Number of correlations for this variable
   * @param status status
   * @param errorMessage error_message
   * @param lastSuccessfulUpdateTime When this variable or its settings were last updated
   * @param standardDeviation Standard deviation
   * @param variance Variance
   * @param minimumRecordedValue Minimum recorded value of this variable
   * @param maximumRecordedValue Maximum recorded value of this variable
   * @param mean Mean
   * @param median Median
   * @param mostCommonUnitId Most common Unit ID
   * @param mostCommonValue Most common value
   * @param numberOfUniqueDailyValues Number of unique daily values
   * @param numberOfChanges Number of changes
   * @param skewness Skewness
   * @param kurtosis Kurtosis
   * @param latitude Latitude
   * @param longitude Longitude
   * @param location Location
   * @param createdAt When the record was first created. Use ISO 8601 datetime format
   * @param updatedAt When the record was last updated. Use ISO 8601 datetime format
   * @param outcome Outcome variables (those with `outcome` == 1) are variables for which a human would generally want to identify the influencing factors.  These include symptoms of illness, physique, mood, cognitive performance, etc.  Generally correlation calculations are only performed on outcome variables
   * @param sources Comma-separated list of source names to limit variables to those sources
   * @param earliestSourceTime Earliest source time
   * @param latestSourceTime Latest source time
   * @param earliestMeasurementTime Earliest measurement time
   * @param latestMeasurementTime Latest measurement time
   * @param earliestFillingTime Earliest filling time
   * @param latestFillingTime Latest filling time
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records.
   * @param offset OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned.
   * @param sort Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order.
   * @return InlineResponse20025
   */
  public InlineResponse20025  userVariablesGet (String accessToken, String clientId, Integer parentId, Integer variableId, Integer userId, Integer defaultUnitId, BigDecimal minimumAllowedValue, BigDecimal maximumAllowedValue, BigDecimal fillingValue, Integer joinWith, Integer onsetDelay, Integer durationOfAction, Integer variableCategoryId, Integer updated, Integer _public, Boolean causeOnly, String fillingType, Integer numberOfMeasurements, Integer numberOfProcessedMeasurements, Integer measurementsAtLastAnalysis, Integer lastUnitId, Integer lastOriginalUnitId, Integer lastOriginalValue, BigDecimal lastValue, BigDecimal lastOriginalValue2, Integer lastSourceId, Integer numberOfCorrelations, String status, String errorMessage, String lastSuccessfulUpdateTime, BigDecimal standardDeviation, BigDecimal variance, BigDecimal minimumRecordedValue, BigDecimal maximumRecordedValue, BigDecimal mean, BigDecimal median, Integer mostCommonUnitId, BigDecimal mostCommonValue, BigDecimal numberOfUniqueDailyValues, Integer numberOfChanges, BigDecimal skewness, BigDecimal kurtosis, BigDecimal latitude, BigDecimal longitude, String location, String createdAt, String updatedAt, Boolean outcome, String sources, Integer earliestSourceTime, Integer latestSourceTime, Integer earliestMeasurementTime, Integer latestMeasurementTime, Integer earliestFillingTime, Integer latestFillingTime, Integer limit, Integer offset, String sort) throws ApiException {
    Object postBody = null;
    

    // create path and map variables
    String path = "/userVariables".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();

    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "client_id", clientId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "parent_id", parentId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "variable_id", variableId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "user_id", userId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "default_unit_id", defaultUnitId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "minimum_allowed_value", minimumAllowedValue));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "maximum_allowed_value", maximumAllowedValue));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "filling_value", fillingValue));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "join_with", joinWith));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "onset_delay", onsetDelay));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "duration_of_action", durationOfAction));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "variable_category_id", variableCategoryId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "updated", updated));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "public", _public));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "cause_only", causeOnly));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "filling_type", fillingType));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "number_of_measurements", numberOfMeasurements));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "number_of_processed_measurements", numberOfProcessedMeasurements));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "measurements_at_last_analysis", measurementsAtLastAnalysis));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "last_unit_id", lastUnitId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "last_original_unit_id", lastOriginalUnitId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "last_original_value", lastOriginalValue));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "last_value", lastValue));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "last_original_value", lastOriginalValue2));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "last_source_id", lastSourceId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "number_of_correlations", numberOfCorrelations));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "status", status));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "error_message", errorMessage));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "last_successful_update_time", lastSuccessfulUpdateTime));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "standard_deviation", standardDeviation));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "variance", variance));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "minimum_recorded_value", minimumRecordedValue));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "maximum_recorded_value", maximumRecordedValue));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "mean", mean));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "median", median));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "most_common_unit_id", mostCommonUnitId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "most_common_value", mostCommonValue));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "number_of_unique_daily_values", numberOfUniqueDailyValues));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "number_of_changes", numberOfChanges));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "skewness", skewness));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "kurtosis", kurtosis));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "latitude", latitude));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "longitude", longitude));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "location", location));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "created_at", createdAt));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "updated_at", updatedAt));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "outcome", outcome));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "sources", sources));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "earliest_source_time", earliestSourceTime));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "latest_source_time", latestSourceTime));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "earliest_measurement_time", earliestMeasurementTime));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "latest_measurement_time", latestMeasurementTime));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "earliest_filling_time", earliestFillingTime));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "latest_filling_time", latestFillingTime));
    
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
        return (InlineResponse20025) ApiInvoker.deserialize(response, "", InlineResponse20025.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Store UserVariable
   * Users can change things like the display name for a variable. They can also change the parameters used in analysis of that variable such as the expected duration of action for a variable to have an effect, the estimated delay before the onset of action. In order to filter out erroneous data, they are able to set the maximum and minimum reasonable daily values for a variable.
   * @param accessToken User&#39;s OAuth2 access token
   * @param body UserVariable that should be stored
   * @return InlineResponse20026
   */
  public InlineResponse20026  userVariablesPost (String accessToken, UserVariable body) throws ApiException {
    Object postBody = body;
    

    // create path and map variables
    String path = "/userVariables".replaceAll("\\{format\\}","json");

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
        return (InlineResponse20026) ApiInvoker.deserialize(response, "", InlineResponse20026.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Get UserVariable
   * Get UserVariable
   * @param id id of UserVariable
   * @param accessToken User&#39;s OAuth2 access token
   * @return InlineResponse20026
   */
  public InlineResponse20026  userVariablesIdGet (Integer id, String accessToken) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
       throw new ApiException(400, "Missing the required parameter 'id' when calling userVariablesIdGet");
    }
    

    // create path and map variables
    String path = "/userVariables/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

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
        return (InlineResponse20026) ApiInvoker.deserialize(response, "", InlineResponse20026.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Update UserVariable
   * Update UserVariable
   * @param id id of UserVariable
   * @param accessToken User&#39;s OAuth2 access token
   * @param body UserVariable that should be updated
   * @return InlineResponse2002
   */
  public InlineResponse2002  userVariablesIdPut (Integer id, String accessToken, UserVariable body) throws ApiException {
    Object postBody = body;
    
    // verify the required parameter 'id' is set
    if (id == null) {
       throw new ApiException(400, "Missing the required parameter 'id' when calling userVariablesIdPut");
    }
    

    // create path and map variables
    String path = "/userVariables/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

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
   * Delete UserVariable
   * Delete UserVariable
   * @param id id of UserVariable
   * @param accessToken User&#39;s OAuth2 access token
   * @return InlineResponse2002
   */
  public InlineResponse2002  userVariablesIdDelete (Integer id, String accessToken) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
       throw new ApiException(400, "Missing the required parameter 'id' when calling userVariablesIdDelete");
    }
    

    // create path and map variables
    String path = "/userVariables/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

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
