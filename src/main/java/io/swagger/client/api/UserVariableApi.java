package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.ApiInvoker;
import io.swagger.client.Pair;

import io.swagger.client.model.*;

import java.util.*;

import io.swagger.client.model.InlineResponse20021;
import java.math.BigDecimal;
import io.swagger.client.model.InlineResponse20022;
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
   * @param clientId client_id
   * @param variableId variable_id
   * @param defaultUnitId default_unit_id
   * @param minimumAllowedValue minimum_allowed_value
   * @param maximumAllowedValue maximum_allowed_value
   * @param fillingValue filling_value
   * @param joinWith join_with
   * @param onsetDelay onset_delay
   * @param durationOfAction duration_of_action
   * @param variableCategoryId variable_category_id
   * @param updated updated
   * @param _public public
   * @param causeOnly cause_only
   * @param fillingType filling_type
   * @param numberOfMeasurements number_of_measurements
   * @param numberOfProcessedMeasurements number_of_processed_measurements
   * @param measurementsAtLastAnalysis measurements_at_last_analysis
   * @param lastUnitId last_unit_id
   * @param lastOriginalUnitId last_original_unit_id
   * @param lastOriginalValue last_original_value
   * @param lastValue last_value
   * @param lastSourceId last_source_id
   * @param numberOfCorrelations number_of_correlations
   * @param status status
   * @param errorMessage error_message
   * @param lastSuccessfulUpdateTime last_successful_update_time
   * @param standardDeviation standard_deviation
   * @param variance variance
   * @param minimumRecordedDailyValue minimum_recorded_daily_value
   * @param maximumRecordedDailyValue maximum_recorded_daily_value
   * @param mean mean
   * @param median median
   * @param mostCommonUnitId most_common_unit_id
   * @param mostCommonValue most_common_value
   * @param numberOfUniqueDailyValues number_of_unique_daily_values
   * @param numberOfChanges number_of_changes
   * @param skewness skewness
   * @param kurtosis kurtosis
   * @param latitude latitude
   * @param longitude longitude
   * @param location location
   * @param createdAt created_at
   * @param updatedAt updated_at
   * @param outcome outcome
   * @param sources sources
   * @param earliestSourceTime earliest_source_time
   * @param latestSourceTime latest_source_time
   * @param earliestMeasurementTime earliest_measurement_time
   * @param latestMeasurementTime latest_measurement_time
   * @param earliestFillingTime earliest_filling_time
   * @param latestFillingTime latest_filling_time
   * @param limit limit
   * @param offset offset
   * @param sort sort
   * @return InlineResponse20021
   */
  public InlineResponse20021  userVariablesGet (String clientId, Integer variableId, Integer defaultUnitId, BigDecimal minimumAllowedValue, BigDecimal maximumAllowedValue, BigDecimal fillingValue, Integer joinWith, Integer onsetDelay, Integer durationOfAction, Integer variableCategoryId, Integer updated, Integer _public, Boolean causeOnly, String fillingType, Integer numberOfMeasurements, Integer numberOfProcessedMeasurements, Integer measurementsAtLastAnalysis, Integer lastUnitId, Integer lastOriginalUnitId, Integer lastOriginalValue, BigDecimal lastValue, Integer lastSourceId, Integer numberOfCorrelations, String status, String errorMessage, String lastSuccessfulUpdateTime, BigDecimal standardDeviation, BigDecimal variance, BigDecimal minimumRecordedDailyValue, BigDecimal maximumRecordedDailyValue, BigDecimal mean, BigDecimal median, Integer mostCommonUnitId, BigDecimal mostCommonValue, BigDecimal numberOfUniqueDailyValues, Integer numberOfChanges, BigDecimal skewness, BigDecimal kurtosis, BigDecimal latitude, BigDecimal longitude, String location, String createdAt, String updatedAt, Boolean outcome, String sources, Integer earliestSourceTime, Integer latestSourceTime, Integer earliestMeasurementTime, Integer latestMeasurementTime, Integer earliestFillingTime, Integer latestFillingTime, Integer limit, Integer offset, String sort) throws ApiException {
    Object postBody = null;
    

    // create path and map variables
    String path = "/userVariables".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();

    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "client_id", clientId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "variable_id", variableId));
    
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
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "last_source_id", lastSourceId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "number_of_correlations", numberOfCorrelations));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "status", status));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "error_message", errorMessage));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "last_successful_update_time", lastSuccessfulUpdateTime));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "standard_deviation", standardDeviation));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "variance", variance));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "minimum_recorded_daily_value", minimumRecordedDailyValue));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "maximum_recorded_daily_value", maximumRecordedDailyValue));
    
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
        return (InlineResponse20021) ApiInvoker.deserialize(response, "", InlineResponse20021.class);
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
   * Store UserVariable
   * @param body UserVariable that should be stored
   * @return InlineResponse20022
   */
  public InlineResponse20022  userVariablesPost (UserVariable body) throws ApiException {
    Object postBody = body;
    

    // create path and map variables
    String path = "/userVariables".replaceAll("\\{format\\}","json");

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
      MultipartEntityBuilder builder = MultipartEntityBuilder.create();
      

      HttpEntity httpEntity = builder.build();
      postBody = httpEntity;
    } else {
      // normal form params
      
    }

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType);
      if(response != null){
        return (InlineResponse20022) ApiInvoker.deserialize(response, "", InlineResponse20022.class);
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
   * @return InlineResponse20022
   */
  public InlineResponse20022  userVariablesIdGet (Integer id) throws ApiException {
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
        return (InlineResponse20022) ApiInvoker.deserialize(response, "", InlineResponse20022.class);
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
   * @param body UserVariable that should be updated
   * @return InlineResponse2002
   */
  public InlineResponse2002  userVariablesIdPut (Integer id, UserVariable body) throws ApiException {
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
   * @return InlineResponse2002
   */
  public InlineResponse2002  userVariablesIdDelete (Integer id) throws ApiException {
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
