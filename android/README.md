# swagger-android-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-android-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-android-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-android-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import io.swagger.client.api.AuthenticationApi;

public class AuthenticationApiExample {

    public static void main(String[] args) {
        AuthenticationApi apiInstance = new AuthenticationApi();
        String code = "code_example"; // String | Authorization code obtained from the provider.
        String provider = "provider_example"; // String | The current options are `google` and `facebook`.
        try {
            apiInstance.v2AuthSocialAuthorizeCodeGet(code, provider);
        } catch (ApiException e) {
            System.err.println("Exception when calling AuthenticationApi#v2AuthSocialAuthorizeCodeGet");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://app.quantimo.do/api*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*AuthenticationApi* | [**v2AuthSocialAuthorizeCodeGet**](docs/AuthenticationApi.md#v2AuthSocialAuthorizeCodeGet) | **GET** /v2/auth/social/authorizeCode | Second Step in Social Authentication flow with JWT Token
*AuthenticationApi* | [**v2AuthSocialAuthorizeTokenGet**](docs/AuthenticationApi.md#v2AuthSocialAuthorizeTokenGet) | **GET** /v2/auth/social/authorizeToken | Native Social Authentication
*AuthenticationApi* | [**v2AuthSocialLoginGet**](docs/AuthenticationApi.md#v2AuthSocialLoginGet) | **GET** /v2/auth/social/login | First Setp in Social Authentication flow with JWT Token
*AuthenticationApi* | [**v2Oauth2AccessTokenGet**](docs/AuthenticationApi.md#v2Oauth2AccessTokenGet) | **GET** /v2/oauth2/access_token | Get a user access token
*AuthenticationApi* | [**v2OauthAuthorizeGet**](docs/AuthenticationApi.md#v2OauthAuthorizeGet) | **GET** /v2/oauth/authorize | Request Authorization Code
*ConnectorsApi* | [**v1ConnectMobileGet**](docs/ConnectorsApi.md#v1ConnectMobileGet) | **GET** /v1/connect/mobile | Mobile connect page
*ConnectorsApi* | [**v1ConnectorsConnectorNameConnectGet**](docs/ConnectorsApi.md#v1ConnectorsConnectorNameConnectGet) | **GET** /v1/connectors/{connectorName}/connect | Obtain a token from 3rd party data source
*ConnectorsApi* | [**v1ConnectorsConnectorNameConnectInstructionsGet**](docs/ConnectorsApi.md#v1ConnectorsConnectorNameConnectInstructionsGet) | **GET** /v1/connectors/{connectorName}/connectInstructions | Connection Instructions
*ConnectorsApi* | [**v1ConnectorsConnectorNameConnectParameterGet**](docs/ConnectorsApi.md#v1ConnectorsConnectorNameConnectParameterGet) | **GET** /v1/connectors/{connectorName}/connectParameter | Connect Parameter
*ConnectorsApi* | [**v1ConnectorsConnectorNameDisconnectGet**](docs/ConnectorsApi.md#v1ConnectorsConnectorNameDisconnectGet) | **GET** /v1/connectors/{connectorName}/disconnect | Delete stored connection info
*ConnectorsApi* | [**v1ConnectorsConnectorNameInfoGet**](docs/ConnectorsApi.md#v1ConnectorsConnectorNameInfoGet) | **GET** /v1/connectors/{connectorName}/info | Get connector info for user
*ConnectorsApi* | [**v1ConnectorsConnectorNameUpdateGet**](docs/ConnectorsApi.md#v1ConnectorsConnectorNameUpdateGet) | **GET** /v1/connectors/{connectorName}/update | Sync with data source
*ConnectorsApi* | [**v1ConnectorsListGet**](docs/ConnectorsApi.md#v1ConnectorsListGet) | **GET** /v1/connectors/list | List of Connectors
*ConnectorsApi* | [**v1IntegrationJsGet**](docs/ConnectorsApi.md#v1IntegrationJsGet) | **GET** /v1/integration.js | Get embeddable connect javascript
*CorrelationsApi* | [**v1AggregatedCorrelationsGet**](docs/CorrelationsApi.md#v1AggregatedCorrelationsGet) | **GET** /v1/aggregatedCorrelations | Get aggregated correlations
*CorrelationsApi* | [**v1AggregatedCorrelationsPost**](docs/CorrelationsApi.md#v1AggregatedCorrelationsPost) | **POST** /v1/aggregatedCorrelations | Store or Update a Correlation
*CorrelationsApi* | [**v1CorrelationsGet**](docs/CorrelationsApi.md#v1CorrelationsGet) | **GET** /v1/correlations | Get correlations
*CorrelationsApi* | [**v1OrganizationsOrganizationIdUsersUserIdVariablesVariableNameCausesGet**](docs/CorrelationsApi.md#v1OrganizationsOrganizationIdUsersUserIdVariablesVariableNameCausesGet) | **GET** /v1/organizations/{organizationId}/users/{userId}/variables/{variableName}/causes | Search user correlations for a given cause
*CorrelationsApi* | [**v1OrganizationsOrganizationIdUsersUserIdVariablesVariableNameEffectsGet**](docs/CorrelationsApi.md#v1OrganizationsOrganizationIdUsersUserIdVariablesVariableNameEffectsGet) | **GET** /v1/organizations/{organizationId}/users/{userId}/variables/{variableName}/effects | Search user correlations for a given cause
*CorrelationsApi* | [**v1PublicCorrelationsSearchSearchGet**](docs/CorrelationsApi.md#v1PublicCorrelationsSearchSearchGet) | **GET** /v1/public/correlations/search/{search} | Get average correlations for variables containing search term
*CorrelationsApi* | [**v1VariablesVariableNameCausesGet**](docs/CorrelationsApi.md#v1VariablesVariableNameCausesGet) | **GET** /v1/variables/{variableName}/causes | Search user correlations for a given effect
*CorrelationsApi* | [**v1VariablesVariableNameEffectsGet**](docs/CorrelationsApi.md#v1VariablesVariableNameEffectsGet) | **GET** /v1/variables/{variableName}/effects | Search user correlations for a given cause
*CorrelationsApi* | [**v1VariablesVariableNamePublicCausesGet**](docs/CorrelationsApi.md#v1VariablesVariableNamePublicCausesGet) | **GET** /v1/variables/{variableName}/public/causes | Search public correlations for a given effect
*CorrelationsApi* | [**v1VariablesVariableNamePublicEffectsGet**](docs/CorrelationsApi.md#v1VariablesVariableNamePublicEffectsGet) | **GET** /v1/variables/{variableName}/public/effects | Search public correlations for a given cause
*CorrelationsApi* | [**v1VotesDeletePost**](docs/CorrelationsApi.md#v1VotesDeletePost) | **POST** /v1/votes/delete | Delete vote
*CorrelationsApi* | [**v1VotesPost**](docs/CorrelationsApi.md#v1VotesPost) | **POST** /v1/votes | Post or update vote
*MeasurementsApi* | [**v1MeasurementSourcesGet**](docs/MeasurementsApi.md#v1MeasurementSourcesGet) | **GET** /v1/measurementSources | Get measurement sources
*MeasurementsApi* | [**v1MeasurementSourcesPost**](docs/MeasurementsApi.md#v1MeasurementSourcesPost) | **POST** /v1/measurementSources | Add a data source
*MeasurementsApi* | [**v1MeasurementsDailyGet**](docs/MeasurementsApi.md#v1MeasurementsDailyGet) | **GET** /v1/measurements/daily | Get daily measurements for this user
*MeasurementsApi* | [**v1MeasurementsDeletePost**](docs/MeasurementsApi.md#v1MeasurementsDeletePost) | **POST** /v1/measurements/delete | Delete a measurement
*MeasurementsApi* | [**v1MeasurementsGet**](docs/MeasurementsApi.md#v1MeasurementsGet) | **GET** /v1/measurements | Get measurements for this user
*MeasurementsApi* | [**v1MeasurementsPost**](docs/MeasurementsApi.md#v1MeasurementsPost) | **POST** /v1/measurements | Post a new set or update existing measurements to the database
*MeasurementsApi* | [**v1MeasurementsRangeGet**](docs/MeasurementsApi.md#v1MeasurementsRangeGet) | **GET** /v1/measurementsRange | Get measurements range for this user
*MeasurementsApi* | [**v1MeasurementsUpdatePost**](docs/MeasurementsApi.md#v1MeasurementsUpdatePost) | **POST** /v1/measurements/update | Update a measurement
*MeasurementsApi* | [**v2MeasurementsCsvGet**](docs/MeasurementsApi.md#v2MeasurementsCsvGet) | **GET** /v2/measurements/csv | Get Measurements CSV
*MeasurementsApi* | [**v2MeasurementsRequestCsvPost**](docs/MeasurementsApi.md#v2MeasurementsRequestCsvPost) | **POST** /v2/measurements/request_csv | Post Request for Measurements CSV
*MeasurementsApi* | [**v2MeasurementsRequestPdfPost**](docs/MeasurementsApi.md#v2MeasurementsRequestPdfPost) | **POST** /v2/measurements/request_pdf | Post Request for Measurements PDF
*MeasurementsApi* | [**v2MeasurementsRequestXlsPost**](docs/MeasurementsApi.md#v2MeasurementsRequestXlsPost) | **POST** /v2/measurements/request_xls | Post Request for Measurements XLS
*OrganizationsApi* | [**v1OrganizationsOrganizationIdUsersPost**](docs/OrganizationsApi.md#v1OrganizationsOrganizationIdUsersPost) | **POST** /v1/organizations/{organizationId}/users | Get user tokens for existing users, create new users
*PairsApi* | [**v1PairsCsvGet**](docs/PairsApi.md#v1PairsCsvGet) | **GET** /v1/pairsCsv | Get pairs
*PairsApi* | [**v1PairsGet**](docs/PairsApi.md#v1PairsGet) | **GET** /v1/pairs | Get pairs
*RemindersApi* | [**v1TrackingReminderNotificationsGet**](docs/RemindersApi.md#v1TrackingReminderNotificationsGet) | **GET** /v1/trackingReminderNotifications | Get specific pending tracking reminders
*RemindersApi* | [**v1TrackingReminderNotificationsSkipPost**](docs/RemindersApi.md#v1TrackingReminderNotificationsSkipPost) | **POST** /v1/trackingReminderNotifications/skip | Skip a pending tracking reminder
*RemindersApi* | [**v1TrackingReminderNotificationsSnoozePost**](docs/RemindersApi.md#v1TrackingReminderNotificationsSnoozePost) | **POST** /v1/trackingReminderNotifications/snooze | Snooze a pending tracking reminder
*RemindersApi* | [**v1TrackingReminderNotificationsTrackPost**](docs/RemindersApi.md#v1TrackingReminderNotificationsTrackPost) | **POST** /v1/trackingReminderNotifications/track | Track a pending tracking reminder
*RemindersApi* | [**v1TrackingRemindersDeletePost**](docs/RemindersApi.md#v1TrackingRemindersDeletePost) | **POST** /v1/trackingReminders/delete | Delete tracking reminder
*RemindersApi* | [**v1TrackingRemindersGet**](docs/RemindersApi.md#v1TrackingRemindersGet) | **GET** /v1/trackingReminders | Get repeating tracking reminder settings
*RemindersApi* | [**v1TrackingRemindersPost**](docs/RemindersApi.md#v1TrackingRemindersPost) | **POST** /v1/trackingReminders | Store a Tracking Reminder
*TagsApi* | [**v1UserTagsDeletePost**](docs/TagsApi.md#v1UserTagsDeletePost) | **POST** /v1/userTags/delete | Delete user tag or ingredient
*TagsApi* | [**v1UserTagsPost**](docs/TagsApi.md#v1UserTagsPost) | **POST** /v1/userTags | Post or update user tags or ingredients
*UnitsApi* | [**v1UnitCategoriesGet**](docs/UnitsApi.md#v1UnitCategoriesGet) | **GET** /v1/unitCategories | Get unit categories
*UnitsApi* | [**v1UnitsGet**](docs/UnitsApi.md#v1UnitsGet) | **GET** /v1/units | Get all available units
*UnitsApi* | [**v1UnitsVariableGet**](docs/UnitsApi.md#v1UnitsVariableGet) | **GET** /v1/unitsVariable | Units for Variable
*UserApi* | [**v1OrganizationsOrganizationIdUsersPost**](docs/UserApi.md#v1OrganizationsOrganizationIdUsersPost) | **POST** /v1/organizations/{organizationId}/users | Get user tokens for existing users, create new users
*UserApi* | [**v1UserMeGet**](docs/UserApi.md#v1UserMeGet) | **GET** /v1/user/me | Get all available units for variableGet authenticated user
*VariablesApi* | [**v1PublicVariablesGet**](docs/VariablesApi.md#v1PublicVariablesGet) | **GET** /v1/public/variables | Get public variables
*VariablesApi* | [**v1PublicVariablesSearchSearchGet**](docs/VariablesApi.md#v1PublicVariablesSearchSearchGet) | **GET** /v1/public/variables/search/{search} | Get top 5 PUBLIC variables with the most correlations
*VariablesApi* | [**v1UserVariablesDeletePost**](docs/VariablesApi.md#v1UserVariablesDeletePost) | **POST** /v1/userVariables/delete | Delete All Measurements For Variable
*VariablesApi* | [**v1UserVariablesPost**](docs/VariablesApi.md#v1UserVariablesPost) | **POST** /v1/userVariables | Update User Settings for a Variable
*VariablesApi* | [**v1UserVariablesResetPost**](docs/VariablesApi.md#v1UserVariablesResetPost) | **POST** /v1/userVariables/reset | Reset user settings for a variable to defaults
*VariablesApi* | [**v1VariableCategoriesGet**](docs/VariablesApi.md#v1VariableCategoriesGet) | **GET** /v1/variableCategories | Variable categories
*VariablesApi* | [**v1VariablesGet**](docs/VariablesApi.md#v1VariablesGet) | **GET** /v1/variables | Get variables with user&#39;s settings
*VariablesApi* | [**v1VariablesPost**](docs/VariablesApi.md#v1VariablesPost) | **POST** /v1/variables | Create Variables
*VariablesApi* | [**v1VariablesSearchSearchGet**](docs/VariablesApi.md#v1VariablesSearchSearchGet) | **GET** /v1/variables/search/{search} | Get variables by search query
*VariablesApi* | [**v1VariablesVariableNameGet**](docs/VariablesApi.md#v1VariablesVariableNameGet) | **GET** /v1/variables/{variableName} | Get info about a variable
*VotesApi* | [**v1VotesDeletePost**](docs/VotesApi.md#v1VotesDeletePost) | **POST** /v1/votes/delete | Delete vote
*VotesApi* | [**v1VotesPost**](docs/VotesApi.md#v1VotesPost) | **POST** /v1/votes | Post or update vote


## Documentation for Models

 - [CommonResponse](docs/CommonResponse.md)
 - [Connection](docs/Connection.md)
 - [Connector](docs/Connector.md)
 - [ConnectorInfo](docs/ConnectorInfo.md)
 - [ConnectorInfoHistoryItem](docs/ConnectorInfoHistoryItem.md)
 - [ConnectorInstruction](docs/ConnectorInstruction.md)
 - [ConversionStep](docs/ConversionStep.md)
 - [Correlation](docs/Correlation.md)
 - [HumanTime](docs/HumanTime.md)
 - [InlineResponse200](docs/InlineResponse200.md)
 - [InlineResponse2001](docs/InlineResponse2001.md)
 - [InlineResponse2002](docs/InlineResponse2002.md)
 - [JsonErrorResponse](docs/JsonErrorResponse.md)
 - [Measurement](docs/Measurement.md)
 - [MeasurementDelete](docs/MeasurementDelete.md)
 - [MeasurementRange](docs/MeasurementRange.md)
 - [MeasurementSet](docs/MeasurementSet.md)
 - [MeasurementSource](docs/MeasurementSource.md)
 - [MeasurementUpdate](docs/MeasurementUpdate.md)
 - [Pairs](docs/Pairs.md)
 - [Permission](docs/Permission.md)
 - [PostCorrelation](docs/PostCorrelation.md)
 - [PostVote](docs/PostVote.md)
 - [TrackingReminder](docs/TrackingReminder.md)
 - [TrackingReminderDelete](docs/TrackingReminderDelete.md)
 - [TrackingReminderNotification](docs/TrackingReminderNotification.md)
 - [TrackingReminderNotificationSkip](docs/TrackingReminderNotificationSkip.md)
 - [TrackingReminderNotificationSnooze](docs/TrackingReminderNotificationSnooze.md)
 - [TrackingReminderNotificationTrack](docs/TrackingReminderNotificationTrack.md)
 - [Unit](docs/Unit.md)
 - [UnitCategory](docs/UnitCategory.md)
 - [Update](docs/Update.md)
 - [User](docs/User.md)
 - [UserTag](docs/UserTag.md)
 - [UserTokenFailedResponse](docs/UserTokenFailedResponse.md)
 - [UserTokenRequest](docs/UserTokenRequest.md)
 - [UserTokenRequestInnerUserField](docs/UserTokenRequestInnerUserField.md)
 - [UserTokenSuccessfulResponse](docs/UserTokenSuccessfulResponse.md)
 - [UserTokenSuccessfulResponseInnerUserField](docs/UserTokenSuccessfulResponseInnerUserField.md)
 - [UserVariable](docs/UserVariable.md)
 - [UserVariableDelete](docs/UserVariableDelete.md)
 - [UserVariableRelationship](docs/UserVariableRelationship.md)
 - [UserVariables](docs/UserVariables.md)
 - [ValueObject](docs/ValueObject.md)
 - [Variable](docs/Variable.md)
 - [VariableCategory](docs/VariableCategory.md)
 - [VariableNew](docs/VariableNew.md)
 - [VariablesNew](docs/VariablesNew.md)
 - [Vote](docs/Vote.md)
 - [VoteDelete](docs/VoteDelete.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### access_token

- **Type**: API key
- **API key parameter name**: access_token
- **Location**: URL query string

### quantimodo_oauth2

- **Type**: OAuth
- **Flow**: accessCode
- **Authorizatoin URL**: https://app.quantimo.do/api/v2/oauth/authorize
- **Scopes**: 
  - basic: Allows you to read user info (displayname, email, etc).
  - readmeasurements: Allows one to read a user&#39;s data
  - writemeasurements: Allows you to write user data


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



