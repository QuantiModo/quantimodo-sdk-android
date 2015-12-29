package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.ApiInvoker;
import io.swagger.client.Pair;

import io.swagger.client.SwaggerClient;
import io.swagger.client.model.*;

import java.util.*;

import io.swagger.client.model.InlineResponse2005;
import io.swagger.client.model.InlineResponse20011;
import io.swagger.client.model.InlineResponse20013;
import java.math.BigDecimal;
import io.swagger.client.model.InlineResponse20015;
import io.swagger.client.model.InlineResponse20016;
import io.swagger.client.model.InlineResponse20017;
import io.swagger.client.model.InlineResponse20018;
import io.swagger.client.model.InlineResponse20019;
import io.swagger.client.model.InlineResponse20020;

import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.util.Map;
import java.util.HashMap;
import java.io.File;

public class OrganizationApi {
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
   * Get all Connections
   * Get all Connections
   * @param accessToken Organization&#39;s OAuth2 access token
   * @param connectorId The id for the connector data source for which the connection is connected
   * @param connectStatus Indicates whether a connector is currently connected to a service for a user.
   * @param connectError Error message if there is a problem with authorizing this connection.
   * @param updateRequestedAt Time at which an update was requested by a user.
   * @param updateStatus Indicates whether a connector is currently updated.
   * @param updateError Indicates if there was an error during the update.
   * @param lastSuccessfulUpdatedAt The time at which the connector was last successfully updated.
   * @param createdAt When the record was first created. Use ISO 8601 datetime format
   * @param updatedAt When the record was last updated. Use ISO 8601 datetime format
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records.
   * @param offset OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned.
   * @param sort Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order.
   * @return InlineResponse2005
   */
  public InlineResponse2005  organizationConnectionsGet (String accessToken, Integer connectorId, String connectStatus, String connectError, String updateRequestedAt, String updateStatus, String updateError, String lastSuccessfulUpdatedAt, String createdAt, String updatedAt, Integer limit, Integer offset, String sort) throws ApiException {
    Object postBody = null;
    

    // create path and map variables
    String path = "/organization/connections".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();

    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "connector_id", connectorId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "connect_status", connectStatus));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "connect_error", connectError));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "update_requested_at", updateRequestedAt));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "update_status", updateStatus));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "update_error", updateError));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "last_successful_updated_at", lastSuccessfulUpdatedAt));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "created_at", createdAt));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "updated_at", updatedAt));
    
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
        return (InlineResponse2005) ApiInvoker.deserialize(response, "", InlineResponse2005.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Get all Credentials
   * Get all Credentials
   * @param accessToken Organization&#39;s OAuth2 access token
   * @param connectorId The id for the connector data source from which the credential was obtained
   * @param attrKey Attribute name such as token, userid, username, or password
   * @param attrValue Encrypted value for the attribute specified
   * @param createdAt When the record was first created. Use ISO 8601 datetime format
   * @param updatedAt When the record was last updated. Use ISO 8601 datetime format
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records.
   * @param offset OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned.
   * @param sort Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order.
   * @return InlineResponse20011
   */
  public InlineResponse20011  organizationCredentialsGet (String accessToken, Integer connectorId, String attrKey, String attrValue, String createdAt, String updatedAt, Integer limit, Integer offset, String sort) throws ApiException {
    Object postBody = null;
    

    // create path and map variables
    String path = "/organization/credentials".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();

    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "connector_id", connectorId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "attr_key", attrKey));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "attr_value", attrValue));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "created_at", createdAt));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "updated_at", updatedAt));
    
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
        return (InlineResponse20011) ApiInvoker.deserialize(response, "", InlineResponse20011.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Get measurements for all users using your application
   * Measurements are any value that can be recorded like daily steps, a mood rating, or apples eaten.
   * @param accessToken Organization&#39;s OAuth2 access token
   * @param clientId The ID of the client application which originally stored the measurement
   * @param connectorId The id for the connector data source from which the measurement was obtained
   * @param variableId ID of the variable for which we are creating the measurement records
   * @param sourceId Application or device used to record the measurement values
   * @param startTime start time for the measurement event. Use ISO 8601 datetime format
   * @param value The value of the measurement after conversion to the default unit for that variable
   * @param unitId The default unit id for the variable
   * @param originalValue Unconverted value of measurement as originally posted (before conversion to default unit)
   * @param originalUnitId Unit id of the measurement as originally submitted
   * @param duration Duration of the event being measurement in seconds
   * @param note An optional note the user may include with their measurement
   * @param latitude Latitude at which the measurement was taken
   * @param longitude Longitude at which the measurement was taken
   * @param location Optional human readable name for the location where the measurement was recorded
   * @param createdAt When the record was first created. Use ISO 8601 datetime format
   * @param updatedAt When the record was last updated. Use ISO 8601 datetime format
   * @param error An error message if there is a problem with the measurement
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records.
   * @param offset OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned.
   * @param sort Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order.
   * @return InlineResponse20013
   */
  public InlineResponse20013  organizationMeasurementsGet (String accessToken, String clientId, Integer connectorId, Integer variableId, Integer sourceId, String startTime, BigDecimal value, Integer unitId, BigDecimal originalValue, Integer originalUnitId, Integer duration, String note, BigDecimal latitude, BigDecimal longitude, String location, String createdAt, String updatedAt, String error, Integer limit, Integer offset, String sort) throws ApiException {
    Object postBody = null;
    

    // create path and map variables
    String path = "/organization/measurements".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();

    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "client_id", clientId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "connector_id", connectorId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "variable_id", variableId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "source_id", sourceId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "start_time", startTime));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "value", value));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "unit_id", unitId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "original_value", originalValue));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "original_unit_id", originalUnitId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "duration", duration));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "note", note));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "latitude", latitude));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "longitude", longitude));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "location", location));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "created_at", createdAt));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "updated_at", updatedAt));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "error", error));
    
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
        return (InlineResponse20013) ApiInvoker.deserialize(response, "", InlineResponse20013.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Get tracking reminders
   * Get the variable id, frequency, and default value for the user tracking reminders
   * @param accessToken User&#39;s OAuth2 access token
   * @param clientId The ID of the client application which last created or updated this trackingReminder
   * @param createdAt When the record was first created. Use ISO 8601 datetime format
   * @param updatedAt When the record was last updated. Use ISO 8601 datetime format
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records.
   * @param offset OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned.
   * @param sort Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order.
   * @return InlineResponse20015
   */
  public InlineResponse20015  organizationTrackingRemindersGet (String accessToken, String clientId, String createdAt, String updatedAt, Integer limit, Integer offset, String sort) throws ApiException {
    Object postBody = null;
    

    // create path and map variables
    String path = "/organization/trackingReminders".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();

    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "client_id", clientId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "created_at", createdAt));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "updated_at", updatedAt));
    
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
        return (InlineResponse20015) ApiInvoker.deserialize(response, "", InlineResponse20015.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Get all Updates
   * Get all Updates
   * @param accessToken Organization&#39;s OAuth2 access token
   * @param connectorId connector_id
   * @param numberOfMeasurements number_of_measurements
   * @param success success
   * @param message message
   * @param createdAt When the record was first created. Use ISO 8601 datetime format
   * @param updatedAt When the record was last updated. Use ISO 8601 datetime format
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records.
   * @param offset OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned.
   * @param sort Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order.
   * @return InlineResponse20016
   */
  public InlineResponse20016  organizationUpdatesGet (String accessToken, Integer connectorId, Integer numberOfMeasurements, Boolean success, String message, String createdAt, String updatedAt, Integer limit, Integer offset, String sort) throws ApiException {
    Object postBody = null;
    

    // create path and map variables
    String path = "/organization/updates".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();

    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "connector_id", connectorId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "number_of_measurements", numberOfMeasurements));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "success", success));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "message", message));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "created_at", createdAt));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "updated_at", updatedAt));
    
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
        return (InlineResponse20016) ApiInvoker.deserialize(response, "", InlineResponse20016.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Get all UserVariableRelationships
   * Get all UserVariableRelationships
   * @param accessToken User&#39;s OAuth2 access token
   * @param id id
   * @param confidenceLevel Our confidence that a consistent predictive relationship exists based on the amount of evidence, reproducibility, and other factors
   * @param confidenceScore A quantitative representation of our confidence that a consistent predictive relationship exists based on the amount of evidence, reproducibility, and other factors
   * @param direction Direction is positive if higher predictor values generally precede higher outcome values. Direction is negative if higher predictor values generally precede lower outcome values.
   * @param durationOfAction Estimated number of seconds following the onset delay in which a stimulus produces a perceivable effect
   * @param errorMessage error_message
   * @param onsetDelay Estimated number of seconds that pass before a stimulus produces a perceivable effect
   * @param outcomeVariableId Variable ID for the outcome variable
   * @param predictorVariableId Variable ID for the predictor variable
   * @param predictorUnitId ID for default unit of the predictor variable
   * @param sinnRank A value representative of the relevance of this predictor relative to other predictors of this outcome.  Usually used for relevancy sorting.
   * @param strengthLevel Can be weak, medium, or strong based on the size of the effect which the predictor appears to have on the outcome relative to other variable relationship strength scores.
   * @param strengthScore A value represented to the size of the effect which the predictor appears to have on the outcome.
   * @param vote vote
   * @param valuePredictingHighOutcome Value for the predictor variable (in it&#39;s default unit) which typically precedes an above average outcome value
   * @param valuePredictingLowOutcome Value for the predictor variable (in it&#39;s default unit) which typically precedes a below average outcome value
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records.
   * @param offset OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned.
   * @param sort Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order.
   * @return InlineResponse20017
   */
  public InlineResponse20017  organizationUserVariableRelationshipsGet (String accessToken, Integer id, String confidenceLevel, BigDecimal confidenceScore, String direction, Integer durationOfAction, String errorMessage, Integer onsetDelay, Integer outcomeVariableId, Integer predictorVariableId, Integer predictorUnitId, BigDecimal sinnRank, String strengthLevel, BigDecimal strengthScore, String vote, BigDecimal valuePredictingHighOutcome, BigDecimal valuePredictingLowOutcome, Integer limit, Integer offset, String sort) throws ApiException {
    Object postBody = null;
    

    // create path and map variables
    String path = "/organization/userVariableRelationships".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();

    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "id", id));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "confidence_level", confidenceLevel));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "confidence_score", confidenceScore));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "direction", direction));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "duration_of_action", durationOfAction));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "error_message", errorMessage));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "onset_delay", onsetDelay));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "outcome_variable_id", outcomeVariableId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "predictor_variable_id", predictorVariableId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "predictor_unit_id", predictorUnitId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "sinn_rank", sinnRank));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "strength_level", strengthLevel));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "strength_score", strengthScore));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "vote", vote));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "value_predicting_high_outcome", valuePredictingHighOutcome));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "value_predicting_low_outcome", valuePredictingLowOutcome));
    
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
        return (InlineResponse20017) ApiInvoker.deserialize(response, "", InlineResponse20017.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Get all UserVariables
   * Get all UserVariables
   * @param accessToken User&#39;s OAuth2 access token
   * @param clientId The ID of the client application which last created or updated this user variable
   * @param parentId ID of the parent variable if this variable has any parent
   * @param variableId ID of variable
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
   * @return InlineResponse20018
   */
  public InlineResponse20018  organizationUserVariablesGet (String accessToken, String clientId, Integer parentId, Integer variableId, Integer defaultUnitId, BigDecimal minimumAllowedValue, BigDecimal maximumAllowedValue, BigDecimal fillingValue, Integer joinWith, Integer onsetDelay, Integer durationOfAction, Integer variableCategoryId, Integer updated, Integer _public, Boolean causeOnly, String fillingType, Integer numberOfMeasurements, Integer numberOfProcessedMeasurements, Integer measurementsAtLastAnalysis, Integer lastUnitId, Integer lastOriginalUnitId, Integer lastOriginalValue, BigDecimal lastValue, BigDecimal lastOriginalValue2, Integer lastSourceId, Integer numberOfCorrelations, String status, String errorMessage, String lastSuccessfulUpdateTime, BigDecimal standardDeviation, BigDecimal variance, BigDecimal minimumRecordedValue, BigDecimal maximumRecordedValue, BigDecimal mean, BigDecimal median, Integer mostCommonUnitId, BigDecimal mostCommonValue, BigDecimal numberOfUniqueDailyValues, Integer numberOfChanges, BigDecimal skewness, BigDecimal kurtosis, BigDecimal latitude, BigDecimal longitude, String location, String createdAt, String updatedAt, Boolean outcome, String sources, Integer earliestSourceTime, Integer latestSourceTime, Integer earliestMeasurementTime, Integer latestMeasurementTime, Integer earliestFillingTime, Integer latestFillingTime, Integer limit, Integer offset, String sort) throws ApiException {
    Object postBody = null;
    

    // create path and map variables
    String path = "/organization/userVariables".replaceAll("\\{format\\}","json");

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
        return (InlineResponse20018) ApiInvoker.deserialize(response, "", InlineResponse20018.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Get all VariableUserSources
   * Get all VariableUserSources
   * @param accessToken User&#39;s OAuth2 access token
   * @param variableId ID of variable
   * @param timestamp Time that this measurement occurred Uses epoch minute (epoch time divided by 60)
   * @param earliestMeasurementTime Earliest measurement time
   * @param latestMeasurementTime Latest measurement time
   * @param createdAt When the record was first created. Use ISO 8601 datetime format
   * @param updatedAt When the record was last updated. Use ISO 8601 datetime format
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records.
   * @param offset OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned.
   * @param sort Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order.
   * @return InlineResponse20019
   */
  public InlineResponse20019  organizationVariableUserSourcesGet (String accessToken, Integer variableId, Integer timestamp, Integer earliestMeasurementTime, Integer latestMeasurementTime, String createdAt, String updatedAt, Integer limit, Integer offset, String sort) throws ApiException {
    Object postBody = null;
    

    // create path and map variables
    String path = "/organization/variableUserSources".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();

    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "variable_id", variableId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "timestamp", timestamp));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "earliest_measurement_time", earliestMeasurementTime));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "latest_measurement_time", latestMeasurementTime));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "created_at", createdAt));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "updated_at", updatedAt));
    
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
        return (InlineResponse20019) ApiInvoker.deserialize(response, "", InlineResponse20019.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Get all Votes
   * Get all Votes
   * @param accessToken User&#39;s OAuth2 access token
   * @param clientId The ID of the client application which last created or updated this vote
   * @param causeId ID of predictor variable
   * @param effectId ID of outcome variable
   * @param value Value of Vote. 1 is for upvote. 0 is for downvote.  Otherwise, there is no vote.
   * @param createdAt When the record was first created. Use ISO 8601 datetime format
   * @param updatedAt When the record was last updated. Use ISO 8601 datetime format
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records.
   * @param offset OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned.
   * @param sort Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order.
   * @return InlineResponse20020
   */
  public InlineResponse20020  organizationVotesGet (String accessToken, String clientId, Integer causeId, Integer effectId, Integer value, String createdAt, String updatedAt, Integer limit, Integer offset, String sort) throws ApiException {
    Object postBody = null;
    

    // create path and map variables
    String path = "/organization/votes".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();

    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "client_id", clientId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "cause_id", causeId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "effect_id", effectId));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "value", value));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "created_at", createdAt));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "updated_at", updatedAt));
    
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
        return (InlineResponse20020) ApiInvoker.deserialize(response, "", InlineResponse20020.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
}
