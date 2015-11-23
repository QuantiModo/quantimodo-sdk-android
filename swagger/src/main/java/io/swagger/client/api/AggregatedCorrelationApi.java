package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.ApiInvoker;
import io.swagger.client.Pair;

import io.swagger.client.model.*;

import java.util.*;

import java.math.BigDecimal;
import io.swagger.client.model.InlineResponse200;
import io.swagger.client.model.AggregatedCorrelation;
import io.swagger.client.model.InlineResponse2001;
import io.swagger.client.model.InlineResponse2002;

import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.util.Map;
import java.util.HashMap;
import java.io.File;

public class AggregatedCorrelationApi {
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
   * Get all AggregatedCorrelations
   * Get all AggregatedCorrelations
   * @param accessToken User&#39;s OAuth2 access token
   * @param correlation Pearson correlation coefficient between cause and effect measurements
   * @param causeId Variable ID of the predictor variable for which the user desires correlations
   * @param effectId Variable ID of the outcome variable for which the user desires correlations
   * @param onsetDelay User estimated (or default number of seconds) after cause measurement before a perceivable effect is observed
   * @param durationOfAction Number of seconds over which the predictor variable event is expected to produce a perceivable effect following the onset delay
   * @param numberOfPairs Number of predictor/outcome data points used in the analysis
   * @param valuePredictingHighOutcome Predictor daily aggregated measurement value that predicts an above average effect measurement value (in default unit for predictor variable)
   * @param valuePredictingLowOutcome Predictor daily aggregated measurement value that predicts a below average effect measurement value (in default unit for outcome variable)
   * @param optimalPearsonProduct Optimal Pearson Product
   * @param numberOfUsers Number of users whose data was used in this aggregation
   * @param numberOfCorrelations Number of correlational analyses used in this aggregation
   * @param statisticalSignificance A function of the effect size and sample size
   * @param causeUnit Abbreviated unit name for the predictor variable
   * @param causeUnitId Unit ID for the predictor variable
   * @param causeChanges Number of times that the predictor time series changes
   * @param effectChanges Number of times that the predictor time series changes
   * @param aggregateQmScore Aggregated QM Score which is directly proportional with the relevance of each predictor or outcome
   * @param createdAt Date at which the analysis was first performed
   * @param updatedAt Date at which the analysis was last updated
   * @param status Indicates whether an analysis is up to date (UPDATED), needs to be updated (WAITING), or had an error (ERROR)
   * @param errorMessage Message describing any problems encountered during the analysis
   * @param lastSuccessfulUpdateTime Last Successful update time
   * @param reversePearsonCorrelationCoefficient Correlation when cause and effect are reversed. For any causal relationship, the forward correlation should exceed the reverse correlation
   * @param predictivePearsonCorrelationCoefficient Predictive Pearson Correlation Coefficient
   * @param limit Limit the number of results returned
   * @param offset Records from give Offset
   * @param sort Sort records by given field
   * @return InlineResponse200
   */
  public InlineResponse200  aggregatedCorrelationsGet (String accessToken, BigDecimal correlation, Integer causeId, Integer effectId, Integer onsetDelay, Integer durationOfAction, Integer numberOfPairs, BigDecimal valuePredictingHighOutcome, BigDecimal valuePredictingLowOutcome, BigDecimal optimalPearsonProduct, Integer numberOfUsers, Integer numberOfCorrelations, BigDecimal statisticalSignificance, String causeUnit, Integer causeUnitId, Integer causeChanges, Integer effectChanges, BigDecimal aggregateQmScore, String createdAt, String updatedAt, String status, String errorMessage, String lastSuccessfulUpdateTime, BigDecimal reversePearsonCorrelationCoefficient, BigDecimal predictivePearsonCorrelationCoefficient, Integer limit, Integer offset, String sort) throws ApiException {
    Object postBody = null;
    

    // create path and map variables
    String path = "/aggregatedCorrelations".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();

    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "correlation", correlation));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "cause_id", causeId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "effect_id", effectId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "onset_delay", onsetDelay));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "duration_of_action", durationOfAction));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "number_of_pairs", numberOfPairs));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "value_predicting_high_outcome", valuePredictingHighOutcome));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "value_predicting_low_outcome", valuePredictingLowOutcome));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "optimal_pearson_product", optimalPearsonProduct));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "number_of_users", numberOfUsers));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "number_of_correlations", numberOfCorrelations));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "statistical_significance", statisticalSignificance));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "cause_unit", causeUnit));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "cause_unit_id", causeUnitId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "cause_changes", causeChanges));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "effect_changes", effectChanges));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "aggregate_qm_score", aggregateQmScore));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "created_at", createdAt));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "updated_at", updatedAt));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "status", status));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "error_message", errorMessage));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "last_successful_update_time", lastSuccessfulUpdateTime));
    
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
        return (InlineResponse200) ApiInvoker.deserialize(response, "", InlineResponse200.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Store AggregatedCorrelation
   * Store AggregatedCorrelation
   * @param accessToken User&#39;s OAuth2 access token
   * @param body AggregatedCorrelation that should be stored
   * @return InlineResponse2001
   */
  public InlineResponse2001  aggregatedCorrelationsPost (String accessToken, AggregatedCorrelation body) throws ApiException {
    Object postBody = body;
    

    // create path and map variables
    String path = "/aggregatedCorrelations".replaceAll("\\{format\\}","json");

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
        return (InlineResponse2001) ApiInvoker.deserialize(response, "", InlineResponse2001.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Get AggregatedCorrelation
   * Get AggregatedCorrelation
   * @param id id of AggregatedCorrelation
   * @param accessToken User&#39;s OAuth2 access token
   * @return InlineResponse2001
   */
  public InlineResponse2001  aggregatedCorrelationsIdGet (Integer id, String accessToken) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
       throw new ApiException(400, "Missing the required parameter 'id' when calling aggregatedCorrelationsIdGet");
    }
    

    // create path and map variables
    String path = "/aggregatedCorrelations/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

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
        return (InlineResponse2001) ApiInvoker.deserialize(response, "", InlineResponse2001.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Update AggregatedCorrelation
   * Update AggregatedCorrelation
   * @param id id of AggregatedCorrelation
   * @param accessToken User&#39;s OAuth2 access token
   * @param body AggregatedCorrelation that should be updated
   * @return InlineResponse2002
   */
  public InlineResponse2002  aggregatedCorrelationsIdPut (Integer id, String accessToken, AggregatedCorrelation body) throws ApiException {
    Object postBody = body;
    
    // verify the required parameter 'id' is set
    if (id == null) {
       throw new ApiException(400, "Missing the required parameter 'id' when calling aggregatedCorrelationsIdPut");
    }
    

    // create path and map variables
    String path = "/aggregatedCorrelations/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

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
   * Delete AggregatedCorrelation
   * Delete AggregatedCorrelation
   * @param id id of AggregatedCorrelation
   * @param accessToken User&#39;s OAuth2 access token
   * @return InlineResponse2002
   */
  public InlineResponse2002  aggregatedCorrelationsIdDelete (Integer id, String accessToken) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
       throw new ApiException(400, "Missing the required parameter 'id' when calling aggregatedCorrelationsIdDelete");
    }
    

    // create path and map variables
    String path = "/aggregatedCorrelations/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

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
