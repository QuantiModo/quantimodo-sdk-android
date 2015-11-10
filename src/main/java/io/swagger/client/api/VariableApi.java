package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.ApiInvoker;
import io.swagger.client.Pair;

import io.swagger.client.model.*;

import java.util.*;

import io.swagger.client.model.InlineResponse20027;
import java.math.BigDecimal;
import io.swagger.client.model.InlineResponse20028;
import io.swagger.client.model.Variable;
import io.swagger.client.model.InlineResponse2002;

import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.util.Map;
import java.util.HashMap;
import java.io.File;

public class VariableApi {
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
   * Get all Variables
   * Get all Variables
   * @param id id
   * @param clientId client_id
   * @param parentId parent_id
   * @param name name
   * @param variableCategoryId variable_category_id
   * @param defaultUnitId default_unit_id
   * @param combinationOperation combination_operation
   * @param fillingValue filling_value
   * @param maximumAllowedValue maximum_allowed_value
   * @param minimumAllowedValue minimum_allowed_value
   * @param onsetDelay onset_delay
   * @param durationOfAction duration_of_action
   * @param _public public
   * @param causeOnly cause_only
   * @param mostCommonValue most_common_value
   * @param mostCommonUnitId most_common_unit_id
   * @param standardDeviation standard_deviation
   * @param variance variance
   * @param mean mean
   * @param median median
   * @param numberOfMeasurements number_of_measurements
   * @param numberOfUniqueValues number_of_unique_values
   * @param skewness skewness
   * @param kurtosis kurtosis
   * @param latitude latitude
   * @param longitude longitude
   * @param location location
   * @param status status
   * @param errorMessage error_message
   * @param lastSuccessfulUpdateTime last_successful_update_time
   * @param createdAt created_at
   * @param updatedAt updated_at
   * @param productUrl product_url
   * @param imageUrl image_url
   * @param price price
   * @param numberOfUserVariables number_of_user_variables
   * @param outcome outcome
   * @param minimumRecordedValue minimum_recorded_value
   * @param maximumRecordedValue maximum_recorded_value
   * @param limit limit
   * @param offset offset
   * @param sort sort
   * @return InlineResponse20027
   */
  public InlineResponse20027  variablesGet (Integer id, String clientId, Integer parentId, String name, Integer variableCategoryId, Integer defaultUnitId, String combinationOperation, BigDecimal fillingValue, BigDecimal maximumAllowedValue, BigDecimal minimumAllowedValue, Integer onsetDelay, Integer durationOfAction, Integer _public, Boolean causeOnly, BigDecimal mostCommonValue, Integer mostCommonUnitId, BigDecimal standardDeviation, BigDecimal variance, BigDecimal mean, BigDecimal median, BigDecimal numberOfMeasurements, BigDecimal numberOfUniqueValues, BigDecimal skewness, BigDecimal kurtosis, BigDecimal latitude, BigDecimal longitude, String location, String status, String errorMessage, String lastSuccessfulUpdateTime, String createdAt, String updatedAt, String productUrl, String imageUrl, BigDecimal price, Integer numberOfUserVariables, Boolean outcome, BigDecimal minimumRecordedValue, BigDecimal maximumRecordedValue, Integer limit, Integer offset, String sort) throws ApiException {
    Object postBody = null;
    

    // create path and map variables
    String path = "/variables".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();

    
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
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "latitude", latitude));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "longitude", longitude));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "location", location));
    
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
        return (InlineResponse20027) ApiInvoker.deserialize(response, "", InlineResponse20027.class);
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
   * Store Variable
   * @param body Variable that should be stored
   * @return InlineResponse20028
   */
  public InlineResponse20028  variablesPost (Variable body) throws ApiException {
    Object postBody = body;
    

    // create path and map variables
    String path = "/variables".replaceAll("\\{format\\}","json");

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
        return (InlineResponse20028) ApiInvoker.deserialize(response, "", InlineResponse20028.class);
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
   * @return InlineResponse20028
   */
  public InlineResponse20028  variablesIdGet (Integer id) throws ApiException {
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
        return (InlineResponse20028) ApiInvoker.deserialize(response, "", InlineResponse20028.class);
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
   * @param body Variable that should be updated
   * @return InlineResponse2002
   */
  public InlineResponse2002  variablesIdPut (Integer id, Variable body) throws ApiException {
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
   * @return InlineResponse2002
   */
  public InlineResponse2002  variablesIdDelete (Integer id) throws ApiException {
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
