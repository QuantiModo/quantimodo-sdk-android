package io.swagger.client.api;

import io.swagger.client.ApiInvoker;
import io.swagger.client.ApiException;
import io.swagger.client.Pair;

import io.swagger.client.model.*;

import java.util.*;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import io.swagger.client.model.ConnectorInstruction;
import io.swagger.client.model.ConnectorInfo;
import io.swagger.client.model.Connector;

import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class ConnectorsApi {
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
  * Get embeddable connect javascript
  * Get embeddable connect javascript. Usage:    - Embedding in applications with popups for 3rd-party authentication windows.      Use &#x60;qmSetupInPopup&#x60; function after connecting &#x60;connect.js&#x60;.    - Embedding in applications with popups for 3rd-party authentication windows.      Requires a selector to block. It will be embedded in this block.      Use &#x60;qmSetupOnPage&#x60; function after connecting &#x60;connect.js&#x60;.    - Embedding in mobile applications without popups for 3rd-party authentication.      Use &#x60;qmSetupOnMobile&#x60; function after connecting &#x60;connect.js&#x60;.      if using the MoodiModo Clones, Use &#x60;qmSetupOnIonic&#x60; function after connecting &#x60;connect.js&#x60;. 
   * @param accessToken User&#39;s OAuth2 access token
   * @return void
  */
  public void v1ConnectJsGet (String accessToken) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = null;
  

  // create path and map variables
  String path = "/v1/connect.js".replaceAll("\\{format\\}","json");

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

      String[] authNames = new String[] { "oauth2", "internalApiKey" };

      try {
        String localVarResponse = apiInvoker.invokeAPI (basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames);
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
   * Get embeddable connect javascript
   * Get embeddable connect javascript. Usage:    - Embedding in applications with popups for 3rd-party authentication windows.      Use &#x60;qmSetupInPopup&#x60; function after connecting &#x60;connect.js&#x60;.    - Embedding in applications with popups for 3rd-party authentication windows.      Requires a selector to block. It will be embedded in this block.      Use &#x60;qmSetupOnPage&#x60; function after connecting &#x60;connect.js&#x60;.    - Embedding in mobile applications without popups for 3rd-party authentication.      Use &#x60;qmSetupOnMobile&#x60; function after connecting &#x60;connect.js&#x60;.      if using the MoodiModo Clones, Use &#x60;qmSetupOnIonic&#x60; function after connecting &#x60;connect.js&#x60;. 
   * @param accessToken User&#39;s OAuth2 access token
  */
  public void v1ConnectJsGet (String accessToken, final Response.Listener<String> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = null;

  

    // create path and map variables
    String path = "/v1/connect.js".replaceAll("\\{format\\}","json");

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

      String[] authNames = new String[] { "oauth2", "internalApiKey" };

    try {
      apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames,
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
  * Mobile connect page
  * This page is designed to be opened in a webview.  Instead of using popup authentication boxes, it uses redirection. You can include the user&#39;s access_token as a URL parameter like https://app.quantimo.do/api/v1/connect/mobile?access_token&#x3D;123
   * @param accessToken User OAuth access token
   * @return void
  */
  public void v1ConnectMobileGet (String accessToken) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = null;
  
      // verify the required parameter 'accessToken' is set
      if (accessToken == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'accessToken' when calling v1ConnectMobileGet",
      new ApiException(400, "Missing the required parameter 'accessToken' when calling v1ConnectMobileGet"));
      }
  

  // create path and map variables
  String path = "/v1/connect/mobile".replaceAll("\\{format\\}","json");

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

      String[] authNames = new String[] { "oauth2", "internalApiKey" };

      try {
        String localVarResponse = apiInvoker.invokeAPI (basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames);
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
   * Mobile connect page
   * This page is designed to be opened in a webview.  Instead of using popup authentication boxes, it uses redirection. You can include the user&#39;s access_token as a URL parameter like https://app.quantimo.do/api/v1/connect/mobile?access_token&#x3D;123
   * @param accessToken User OAuth access token
  */
  public void v1ConnectMobileGet (String accessToken, final Response.Listener<String> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = null;

  
    // verify the required parameter 'accessToken' is set
    if (accessToken == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'accessToken' when calling v1ConnectMobileGet",
         new ApiException(400, "Missing the required parameter 'accessToken' when calling v1ConnectMobileGet"));
    }
    

    // create path and map variables
    String path = "/v1/connect/mobile".replaceAll("\\{format\\}","json");

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

      String[] authNames = new String[] { "oauth2", "internalApiKey" };

    try {
      apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames,
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
  * Obtain a token from 3rd party data source
  * Attempt to obtain a token from the data provider, store it in the database. With this, the connector to continue to obtain new user data until the token is revoked.
   * @param connector Lowercase system name of the source application or device. Get a list of available connectors from the /connectors/list endpoint.
   * @param accessToken User&#39;s OAuth2 access token
   * @return void
  */
  public void v1ConnectorsConnectorConnectGet (String connector, String accessToken) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = null;
  
      // verify the required parameter 'connector' is set
      if (connector == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'connector' when calling v1ConnectorsConnectorConnectGet",
      new ApiException(400, "Missing the required parameter 'connector' when calling v1ConnectorsConnectorConnectGet"));
      }
  

  // create path and map variables
  String path = "/v1/connectors/{connector}/connect".replaceAll("\\{format\\}","json").replaceAll("\\{" + "connector" + "\\}", apiInvoker.escapeString(connector.toString()));

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
   * Obtain a token from 3rd party data source
   * Attempt to obtain a token from the data provider, store it in the database. With this, the connector to continue to obtain new user data until the token is revoked.
   * @param connector Lowercase system name of the source application or device. Get a list of available connectors from the /connectors/list endpoint.   * @param accessToken User&#39;s OAuth2 access token
  */
  public void v1ConnectorsConnectorConnectGet (String connector, String accessToken, final Response.Listener<String> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = null;

  
    // verify the required parameter 'connector' is set
    if (connector == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'connector' when calling v1ConnectorsConnectorConnectGet",
         new ApiException(400, "Missing the required parameter 'connector' when calling v1ConnectorsConnectorConnectGet"));
    }
    

    // create path and map variables
    String path = "/v1/connectors/{connector}/connect".replaceAll("\\{format\\}","json").replaceAll("\\{" + "connector" + "\\}", apiInvoker.escapeString(connector.toString()));

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
  * Connection Instructions
  * Returns instructions that describe what parameters and endpoint to use to connect to the given data provider.
   * @param connector Lowercase system name of the source application or device. Get a list of available connectors from the /connectors/list endpoint.
   * @param parameters JSON Array of Parameters for the request to enable connector.
   * @param url URL which should be used to enable the connector.
   * @param usePopup Should use popup when enabling connector
   * @param accessToken User&#39;s OAuth2 access token
   * @return void
  */
  public void v1ConnectorsConnectorConnectInstructionsGet (String connector, String parameters, String url, Boolean usePopup, String accessToken) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = null;
  
      // verify the required parameter 'connector' is set
      if (connector == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'connector' when calling v1ConnectorsConnectorConnectInstructionsGet",
      new ApiException(400, "Missing the required parameter 'connector' when calling v1ConnectorsConnectorConnectInstructionsGet"));
      }
  
      // verify the required parameter 'parameters' is set
      if (parameters == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'parameters' when calling v1ConnectorsConnectorConnectInstructionsGet",
      new ApiException(400, "Missing the required parameter 'parameters' when calling v1ConnectorsConnectorConnectInstructionsGet"));
      }
  
      // verify the required parameter 'url' is set
      if (url == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'url' when calling v1ConnectorsConnectorConnectInstructionsGet",
      new ApiException(400, "Missing the required parameter 'url' when calling v1ConnectorsConnectorConnectInstructionsGet"));
      }
  
      // verify the required parameter 'usePopup' is set
      if (usePopup == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'usePopup' when calling v1ConnectorsConnectorConnectInstructionsGet",
      new ApiException(400, "Missing the required parameter 'usePopup' when calling v1ConnectorsConnectorConnectInstructionsGet"));
      }
  

  // create path and map variables
  String path = "/v1/connectors/{connector}/connectInstructions".replaceAll("\\{format\\}","json").replaceAll("\\{" + "connector" + "\\}", apiInvoker.escapeString(connector.toString()));

  // query params
  List<Pair> queryParams = new ArrayList<Pair>();
      // header params
      Map<String, String> headerParams = new HashMap<String, String>();
      // form params
      Map<String, String> formParams = new HashMap<String, String>();

          queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "parameters", parameters));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "url", url));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "usePopup", usePopup));


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
   * Connection Instructions
   * Returns instructions that describe what parameters and endpoint to use to connect to the given data provider.
   * @param connector Lowercase system name of the source application or device. Get a list of available connectors from the /connectors/list endpoint.   * @param parameters JSON Array of Parameters for the request to enable connector.   * @param url URL which should be used to enable the connector.   * @param usePopup Should use popup when enabling connector   * @param accessToken User&#39;s OAuth2 access token
  */
  public void v1ConnectorsConnectorConnectInstructionsGet (String connector, String parameters, String url, Boolean usePopup, String accessToken, final Response.Listener<String> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = null;

  
    // verify the required parameter 'connector' is set
    if (connector == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'connector' when calling v1ConnectorsConnectorConnectInstructionsGet",
         new ApiException(400, "Missing the required parameter 'connector' when calling v1ConnectorsConnectorConnectInstructionsGet"));
    }
    
    // verify the required parameter 'parameters' is set
    if (parameters == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'parameters' when calling v1ConnectorsConnectorConnectInstructionsGet",
         new ApiException(400, "Missing the required parameter 'parameters' when calling v1ConnectorsConnectorConnectInstructionsGet"));
    }
    
    // verify the required parameter 'url' is set
    if (url == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'url' when calling v1ConnectorsConnectorConnectInstructionsGet",
         new ApiException(400, "Missing the required parameter 'url' when calling v1ConnectorsConnectorConnectInstructionsGet"));
    }
    
    // verify the required parameter 'usePopup' is set
    if (usePopup == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'usePopup' when calling v1ConnectorsConnectorConnectInstructionsGet",
         new ApiException(400, "Missing the required parameter 'usePopup' when calling v1ConnectorsConnectorConnectInstructionsGet"));
    }
    

    // create path and map variables
    String path = "/v1/connectors/{connector}/connectInstructions".replaceAll("\\{format\\}","json").replaceAll("\\{" + "connector" + "\\}", apiInvoker.escapeString(connector.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();

    queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "parameters", parameters));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "url", url));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "usePopup", usePopup));


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
  * Connect Parameter
  * Returns instructions that describe what parameters and endpoint to use to connect to the given data provider.
   * @param connector Lowercase system name of the source application or device. Get a list of available connectors from the /connectors/list endpoint.
   * @param displayName Name of the parameter that is user visible in the form
   * @param key Name of the property that the user has to enter such as username or password Connector (used in HTTP request)
   * @param placeholder Placeholder hint value for the parameter input tag.
   * @param type Type of input field such as those found here http://www.w3schools.com/tags/tag_input.asp
   * @param usePopup Should use popup when enabling connector
   * @param accessToken User&#39;s OAuth2 access token
   * @param defaultValue Default parameter value
   * @return ConnectorInstruction
  */
  public ConnectorInstruction v1ConnectorsConnectorConnectParameterGet (String connector, String displayName, String key, String placeholder, String type, Boolean usePopup, String accessToken, String defaultValue) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = null;
  
      // verify the required parameter 'connector' is set
      if (connector == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'connector' when calling v1ConnectorsConnectorConnectParameterGet",
      new ApiException(400, "Missing the required parameter 'connector' when calling v1ConnectorsConnectorConnectParameterGet"));
      }
  
      // verify the required parameter 'displayName' is set
      if (displayName == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'displayName' when calling v1ConnectorsConnectorConnectParameterGet",
      new ApiException(400, "Missing the required parameter 'displayName' when calling v1ConnectorsConnectorConnectParameterGet"));
      }
  
      // verify the required parameter 'key' is set
      if (key == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'key' when calling v1ConnectorsConnectorConnectParameterGet",
      new ApiException(400, "Missing the required parameter 'key' when calling v1ConnectorsConnectorConnectParameterGet"));
      }
  
      // verify the required parameter 'placeholder' is set
      if (placeholder == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'placeholder' when calling v1ConnectorsConnectorConnectParameterGet",
      new ApiException(400, "Missing the required parameter 'placeholder' when calling v1ConnectorsConnectorConnectParameterGet"));
      }
  
      // verify the required parameter 'type' is set
      if (type == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'type' when calling v1ConnectorsConnectorConnectParameterGet",
      new ApiException(400, "Missing the required parameter 'type' when calling v1ConnectorsConnectorConnectParameterGet"));
      }
  
      // verify the required parameter 'usePopup' is set
      if (usePopup == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'usePopup' when calling v1ConnectorsConnectorConnectParameterGet",
      new ApiException(400, "Missing the required parameter 'usePopup' when calling v1ConnectorsConnectorConnectParameterGet"));
      }
  

  // create path and map variables
  String path = "/v1/connectors/{connector}/connectParameter".replaceAll("\\{format\\}","json").replaceAll("\\{" + "connector" + "\\}", apiInvoker.escapeString(connector.toString()));

  // query params
  List<Pair> queryParams = new ArrayList<Pair>();
      // header params
      Map<String, String> headerParams = new HashMap<String, String>();
      // form params
      Map<String, String> formParams = new HashMap<String, String>();

          queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "defaultValue", defaultValue));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "displayName", displayName));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "key", key));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "placeholder", placeholder));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "type", type));
          queryParams.addAll(ApiInvoker.parameterToPairs("", "usePopup", usePopup));


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
           return (ConnectorInstruction) ApiInvoker.deserialize(localVarResponse, "", ConnectorInstruction.class);
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
   * Connect Parameter
   * Returns instructions that describe what parameters and endpoint to use to connect to the given data provider.
   * @param connector Lowercase system name of the source application or device. Get a list of available connectors from the /connectors/list endpoint.   * @param displayName Name of the parameter that is user visible in the form   * @param key Name of the property that the user has to enter such as username or password Connector (used in HTTP request)   * @param placeholder Placeholder hint value for the parameter input tag.   * @param type Type of input field such as those found here http://www.w3schools.com/tags/tag_input.asp   * @param usePopup Should use popup when enabling connector   * @param accessToken User&#39;s OAuth2 access token   * @param defaultValue Default parameter value
  */
  public void v1ConnectorsConnectorConnectParameterGet (String connector, String displayName, String key, String placeholder, String type, Boolean usePopup, String accessToken, String defaultValue, final Response.Listener<ConnectorInstruction> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = null;

  
    // verify the required parameter 'connector' is set
    if (connector == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'connector' when calling v1ConnectorsConnectorConnectParameterGet",
         new ApiException(400, "Missing the required parameter 'connector' when calling v1ConnectorsConnectorConnectParameterGet"));
    }
    
    // verify the required parameter 'displayName' is set
    if (displayName == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'displayName' when calling v1ConnectorsConnectorConnectParameterGet",
         new ApiException(400, "Missing the required parameter 'displayName' when calling v1ConnectorsConnectorConnectParameterGet"));
    }
    
    // verify the required parameter 'key' is set
    if (key == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'key' when calling v1ConnectorsConnectorConnectParameterGet",
         new ApiException(400, "Missing the required parameter 'key' when calling v1ConnectorsConnectorConnectParameterGet"));
    }
    
    // verify the required parameter 'placeholder' is set
    if (placeholder == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'placeholder' when calling v1ConnectorsConnectorConnectParameterGet",
         new ApiException(400, "Missing the required parameter 'placeholder' when calling v1ConnectorsConnectorConnectParameterGet"));
    }
    
    // verify the required parameter 'type' is set
    if (type == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'type' when calling v1ConnectorsConnectorConnectParameterGet",
         new ApiException(400, "Missing the required parameter 'type' when calling v1ConnectorsConnectorConnectParameterGet"));
    }
    
    // verify the required parameter 'usePopup' is set
    if (usePopup == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'usePopup' when calling v1ConnectorsConnectorConnectParameterGet",
         new ApiException(400, "Missing the required parameter 'usePopup' when calling v1ConnectorsConnectorConnectParameterGet"));
    }
    

    // create path and map variables
    String path = "/v1/connectors/{connector}/connectParameter".replaceAll("\\{format\\}","json").replaceAll("\\{" + "connector" + "\\}", apiInvoker.escapeString(connector.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();

    queryParams.addAll(ApiInvoker.parameterToPairs("", "access_token", accessToken));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "defaultValue", defaultValue));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "displayName", displayName));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "key", key));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "placeholder", placeholder));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "type", type));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "usePopup", usePopup));


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
              responseListener.onResponse((ConnectorInstruction) ApiInvoker.deserialize(localVarResponse,  "", ConnectorInstruction.class));
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
  * Delete stored connection info
  * The disconnect method deletes any stored tokens or connection information from the connectors database.
   * @param connector Lowercase system name of the source application or device. Get a list of available connectors from the /connectors/list endpoint.
   * @return void
  */
  public void v1ConnectorsConnectorDisconnectGet (String connector) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = null;
  
      // verify the required parameter 'connector' is set
      if (connector == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'connector' when calling v1ConnectorsConnectorDisconnectGet",
      new ApiException(400, "Missing the required parameter 'connector' when calling v1ConnectorsConnectorDisconnectGet"));
      }
  

  // create path and map variables
  String path = "/v1/connectors/{connector}/disconnect".replaceAll("\\{format\\}","json").replaceAll("\\{" + "connector" + "\\}", apiInvoker.escapeString(connector.toString()));

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
   * Delete stored connection info
   * The disconnect method deletes any stored tokens or connection information from the connectors database.
   * @param connector Lowercase system name of the source application or device. Get a list of available connectors from the /connectors/list endpoint.
  */
  public void v1ConnectorsConnectorDisconnectGet (String connector, final Response.Listener<String> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = null;

  
    // verify the required parameter 'connector' is set
    if (connector == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'connector' when calling v1ConnectorsConnectorDisconnectGet",
         new ApiException(400, "Missing the required parameter 'connector' when calling v1ConnectorsConnectorDisconnectGet"));
    }
    

    // create path and map variables
    String path = "/v1/connectors/{connector}/disconnect".replaceAll("\\{format\\}","json").replaceAll("\\{" + "connector" + "\\}", apiInvoker.escapeString(connector.toString()));

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
  * Get connector info for user
  * Returns information about the connector such as the connector id, whether or not is connected for this user (i.e. we have a token or credentials), and its update history for the user.
   * @param connector Lowercase system name of the source application or device. Get a list of available connectors from the /connectors/list endpoint.
   * @param accessToken User&#39;s OAuth2 access token
   * @return ConnectorInfo
  */
  public ConnectorInfo v1ConnectorsConnectorInfoGet (String connector, String accessToken) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = null;
  
      // verify the required parameter 'connector' is set
      if (connector == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'connector' when calling v1ConnectorsConnectorInfoGet",
      new ApiException(400, "Missing the required parameter 'connector' when calling v1ConnectorsConnectorInfoGet"));
      }
  

  // create path and map variables
  String path = "/v1/connectors/{connector}/info".replaceAll("\\{format\\}","json").replaceAll("\\{" + "connector" + "\\}", apiInvoker.escapeString(connector.toString()));

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
           return (ConnectorInfo) ApiInvoker.deserialize(localVarResponse, "", ConnectorInfo.class);
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
   * Get connector info for user
   * Returns information about the connector such as the connector id, whether or not is connected for this user (i.e. we have a token or credentials), and its update history for the user.
   * @param connector Lowercase system name of the source application or device. Get a list of available connectors from the /connectors/list endpoint.   * @param accessToken User&#39;s OAuth2 access token
  */
  public void v1ConnectorsConnectorInfoGet (String connector, String accessToken, final Response.Listener<ConnectorInfo> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = null;

  
    // verify the required parameter 'connector' is set
    if (connector == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'connector' when calling v1ConnectorsConnectorInfoGet",
         new ApiException(400, "Missing the required parameter 'connector' when calling v1ConnectorsConnectorInfoGet"));
    }
    

    // create path and map variables
    String path = "/v1/connectors/{connector}/info".replaceAll("\\{format\\}","json").replaceAll("\\{" + "connector" + "\\}", apiInvoker.escapeString(connector.toString()));

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
              responseListener.onResponse((ConnectorInfo) ApiInvoker.deserialize(localVarResponse,  "", ConnectorInfo.class));
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
  * Sync with data source
  * The update method tells the QM Connector Framework to check with the data provider (such as Fitbit or MyFitnessPal) and retrieve any new measurements available.
   * @param connector Lowercase system name of the source application or device
   * @param accessToken User&#39;s OAuth2 access token
   * @return void
  */
  public void v1ConnectorsConnectorUpdateGet (String connector, String accessToken) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = null;
  
      // verify the required parameter 'connector' is set
      if (connector == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'connector' when calling v1ConnectorsConnectorUpdateGet",
      new ApiException(400, "Missing the required parameter 'connector' when calling v1ConnectorsConnectorUpdateGet"));
      }
  

  // create path and map variables
  String path = "/v1/connectors/{connector}/update".replaceAll("\\{format\\}","json").replaceAll("\\{" + "connector" + "\\}", apiInvoker.escapeString(connector.toString()));

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
   * Sync with data source
   * The update method tells the QM Connector Framework to check with the data provider (such as Fitbit or MyFitnessPal) and retrieve any new measurements available.
   * @param connector Lowercase system name of the source application or device   * @param accessToken User&#39;s OAuth2 access token
  */
  public void v1ConnectorsConnectorUpdateGet (String connector, String accessToken, final Response.Listener<String> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = null;

  
    // verify the required parameter 'connector' is set
    if (connector == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'connector' when calling v1ConnectorsConnectorUpdateGet",
         new ApiException(400, "Missing the required parameter 'connector' when calling v1ConnectorsConnectorUpdateGet"));
    }
    

    // create path and map variables
    String path = "/v1/connectors/{connector}/update".replaceAll("\\{format\\}","json").replaceAll("\\{" + "connector" + "\\}", apiInvoker.escapeString(connector.toString()));

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
  * List of Connectors
  * A connector pulls data from other data providers using their API or a screenscraper. Returns a list of all available connectors and information about them such as their id, name, whether the user has provided access, logo url, connection instructions, and the update history.
   * @return List<Connector>
  */
  public List<Connector> v1ConnectorsListGet () throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = null;
  

  // create path and map variables
  String path = "/v1/connectors/list".replaceAll("\\{format\\}","json");

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
           return (List<Connector>) ApiInvoker.deserialize(localVarResponse, "array", Connector.class);
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
   * List of Connectors
   * A connector pulls data from other data providers using their API or a screenscraper. Returns a list of all available connectors and information about them such as their id, name, whether the user has provided access, logo url, connection instructions, and the update history.

  */
  public void v1ConnectorsListGet (final Response.Listener<List<Connector>> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = null;

  

    // create path and map variables
    String path = "/v1/connectors/list".replaceAll("\\{format\\}","json");

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
              responseListener.onResponse((List<Connector>) ApiInvoker.deserialize(localVarResponse,  "array", Connector.class));
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
