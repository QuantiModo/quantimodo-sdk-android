
# Connection

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **Integer** | id |  [optional]
**userId** | **Integer** | ID of user that owns this correlation |  [optional]
**connectorId** | **Integer** | The id for the connector data source for which the connection is connected | 
**connectStatus** | **String** | Indicates whether a connector is currently connected to a service for a user. |  [optional]
**connectError** | **String** | Error message if there is a problem with authorizing this connection. |  [optional]
**updateRequestedAt** | [**Date**](Date.md) | Time at which an update was requested by a user. |  [optional]
**updateStatus** | **String** | Indicates whether a connector is currently updated. |  [optional]
**updateError** | **String** | Indicates if there was an error during the update. |  [optional]
**lastSuccessfulUpdatedAt** | [**Date**](Date.md) | The time at which the connector was last successfully updated. |  [optional]
**createdAt** | [**Date**](Date.md) | When the record was first created. Use UTC ISO 8601 \&quot;YYYY-MM-DDThh:mm:ss\&quot;  datetime format |  [optional]
**updatedAt** | [**Date**](Date.md) | When the record in the database was last updated. Use UTC ISO 8601 \&quot;YYYY-MM-DDThh:mm:ss\&quot;  datetime format |  [optional]



