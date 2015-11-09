package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.ApiInvoker;
import io.swagger.client.Pair;

import io.swagger.client.model.*;

import java.util.*;

import java.math.BigDecimal;
import io.swagger.client.model.InlineResponse2007;
import io.swagger.client.model.InlineResponse2008;
import io.swagger.client.model.Correlation;
import io.swagger.client.model.InlineResponse2002;

import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.util.Map;
import java.util.HashMap;
import java.io.File;

public class CorrelationApi {
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
   * Get all Correlations
   * Get all Correlations
   * @param timestamp timestamp
   * @param userId user_id
   * @param correlation correlation
   * @param causeId cause_id
   * @param effectId effect_id
   * @param onsetDelay onset_delay
   * @param durationOfAction duration_of_action
   * @param numberOfPairs number_of_pairs
   * @param valuePredictingHighOutcome value_predicting_high_outcome
   * @param valuePredictingLowOutcome value_predicting_low_outcome
   * @param optimalPearsonProduct optimal_pearson_product
   * @param vote vote
   * @param statisticalSignificance statistical_significance
   * @param causeUnit cause_unit
   * @param causeUnitId cause_unit_id
   * @param causeChanges cause_changes
   * @param effectChanges effect_changes
   * @param qmScore qm_score
   * @param error error
   * @param createdAt created_at
   * @param updatedAt updated_at
   * @param reversePearsonCorrelationCoefficient reverse_pearson_correlation_coefficient
   * @param predictivePearsonCorrelationCoefficient predictive_pearson_correlation_coefficient
   * @param limit limit
   * @param offset offset
   * @param sort sort
   * @return InlineResponse2007
   */
  public InlineResponse2007  correlationsGet (Integer timestamp, Integer userId, BigDecimal correlation, Integer causeId, Integer effectId, Integer onsetDelay, Integer durationOfAction, Integer numberOfPairs, BigDecimal valuePredictingHighOutcome, BigDecimal valuePredictingLowOutcome, BigDecimal optimalPearsonProduct, BigDecimal vote, BigDecimal statisticalSignificance, String causeUnit, Integer causeUnitId, Integer causeChanges, Integer effectChanges, BigDecimal qmScore, String error, String createdAt, String updatedAt, BigDecimal reversePearsonCorrelationCoefficient, BigDecimal predictivePearsonCorrelationCoefficient, Integer limit, Integer offset, String sort) throws ApiException {
    Object postBody = null;
    

    // create path and map variables
    String path = "/correlations".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();

    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "timestamp", timestamp));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "user_id", userId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "correlation", correlation));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "cause_id", causeId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "effect_id", effectId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "onset_delay", onsetDelay));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "duration_of_action", durationOfAction));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "number_of_pairs", numberOfPairs));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "value_predicting_high_outcome", valuePredictingHighOutcome));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "value_predicting_low_outcome", valuePredictingLowOutcome));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "optimal_pearson_product", optimalPearsonProduct));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "vote", vote));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "statistical_significance", statisticalSignificance));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "cause_unit", causeUnit));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "cause_unit_id", causeUnitId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "cause_changes", causeChanges));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "effect_changes", effectChanges));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "qm_score", qmScore));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "error", error));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "created_at", createdAt));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "updated_at", updatedAt));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "reverse_pearson_correlation_coefficient", reversePearsonCorrelationCoefficient));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "predictive_pearson_correlation_coefficient", predictivePearsonCorrelationCoefficient));
    
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
        return (InlineResponse2007) ApiInvoker.deserialize(response, "", InlineResponse2007.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Store Correlation
   * Store Correlation
   * @param body Correlation that should be stored
   * @return InlineResponse2008
   */
  public InlineResponse2008  correlationsPost (Correlation body) throws ApiException {
    Object postBody = body;
    

    // create path and map variables
    String path = "/correlations".replaceAll("\\{format\\}","json");

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
        return (InlineResponse2008) ApiInvoker.deserialize(response, "", InlineResponse2008.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Get Correlation
   * Get Correlation
   * @param id id of Correlation
   * @return InlineResponse2008
   */
  public InlineResponse2008  correlationsIdGet (Integer id) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
       throw new ApiException(400, "Missing the required parameter 'id' when calling correlationsIdGet");
    }
    

    // create path and map variables
    String path = "/correlations/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

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
        return (InlineResponse2008) ApiInvoker.deserialize(response, "", InlineResponse2008.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Update Correlation
   * Update Correlation
   * @param id id of Correlation
   * @param body Correlation that should be updated
   * @return InlineResponse2002
   */
  public InlineResponse2002  correlationsIdPut (Integer id, Correlation body) throws ApiException {
    Object postBody = body;
    
    // verify the required parameter 'id' is set
    if (id == null) {
       throw new ApiException(400, "Missing the required parameter 'id' when calling correlationsIdPut");
    }
    

    // create path and map variables
    String path = "/correlations/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

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
   * Delete Correlation
   * Delete Correlation
   * @param id id of Correlation
   * @return InlineResponse2002
   */
  public InlineResponse2002  correlationsIdDelete (Integer id) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
       throw new ApiException(400, "Missing the required parameter 'id' when calling correlationsIdDelete");
    }
    

    // create path and map variables
    String path = "/correlations/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

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
