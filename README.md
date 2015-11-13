QuantiModo-SDK-Android
======================

This is the software development kit for implementing enabling Android Applications to store or access user Quantified Self data in the QuantiModo database.

## Modules
* [SDK](#about-sdk)
* [Quantimodo-Tools](#about-quantimodo-tools)

## Install
Library can be obtained from OSS Sonatype repository.

### SDK

Maven:
```
<dependency>
  <groupId>com.quantimodo.android</groupId>
  <artifactId>sdk</artifactId>
  <version>2.2.4</version>
  <type>aar</type>
</dependency>
```

Gradle:
```
compile 'com.quantimodo.android:sdk:2.2.4'
```

### Quantimodo-Tools

Maven:
```
<dependency>
  <groupId>com.quantimodo.android</groupId>
  <artifactId>sdk-tools</artifactId>
  <version>1.0</version>
  <type>aar</type>
</dependency>
```

Gradle:
```
compile 'com.quantimodo.android:sdk-tools:1.0'
```


## About SDK

This SDK contains model classes and API client for QuantiModo web-service.

### How to create a new Android project and build it using the QuantiModo SDK

Create regular Android project, and add SDK as [dependency](#sdk).

#### Configure

To use SDK you need to obtain [OAuth2 token](https://app.quantimo.do/api/docs/#oauth2-authentication).
After that you can get instance of QuantimodoApiV2

```
String token = "oauth_token";
QuantimodoApiV2 api = QuantimodoApiV2.getInstance(null);
SdkResponse<User> response = api.getUser(ctx,token);
```

#### Use

After configuration you can start using SDK.
All requests return [SdkResponse<T>](http://quantimodo.github.io/QuantiModo-SDK-Android/javadoc/sdk/index.html?com/quantimodo/android/sdk/SdkResponse.html) , which contain all info about response. 
For example to submit measurement to QuantiModo service for variable "Overall Mood"

```
//Variable Category : Mood
//Variable : Overall Mood
//Unit : /5 ( from 1 to 5 )
//Source name : Sample application
MeasurementSet sets = new MeasurementSet("Overall Mood", null, "Mood", "/5", MeasurementSet.COMBINE_MEAN, "Sample application");

//Measurement with Overall Mood, with 5 out of 5 rating, that submitted right now
Measurement measurement = new Measurement(System.currentTimeMillis() / 1000, 5.0d);

//Adding measurement into set
sets.getMeasurements().add(measurement);

String token = "oauth_token";
QuantimodoApiV2 api = QuantimodoApiV2.getInstance(null);

SdkResponse<Integer> result = api.putMeasurements(ctx,token,sets);
if (result.isSuccessful() && ((Integer) 1).equals(result.getData())){
  Log.i("sample","sent");
}
```

For more info, please check [JavaDocs](http://quantimodo.github.io/QuantiModo-SDK-Android/javadoc/sdk/).
Or you can find examples in [tests](https://github.com/QuantiModo/QuantiModo-SDK-Android/tree/develop/sdk/src/androidTest/).

## About Quantimodo-Tools

Quantimodo Tools , set of components to create application that would work with QuantiModo.

This tools handles:

- Auth and token management
- Sync helper ( to handle sync with QuantiModo )
- Network interaction using [RoboSpice](https://github.com/stephanenicolas/robospice) 

### How to create a new Android project and build it using the Quantimodo-Tools

Create regular Android project, and add QuantiModo tools as [dependency](#quantimodo-tools).

#### Configure

App uses DI to initialize components, there are several components that should be initialized in order to use tools:

- [Module](http://square.github.io/dagger/#using) that would provide dependencies
- ToolsPrefs , that contain info about endpoint ( base URL, application source, permissions )
- SpiceService, in order to configure caching
- SyncService , if data should be synced
- [QApplication](http://quantimodo.github.io/QuantiModo-SDK-Android/javadoc/qm-tools/index.html?com/quantimodo/tools/QApplication.html) interface, which would provide dependencies to other components

First you need to implement [QApplication](http://quantimodo.github.io/QuantiModo-SDK-Android/javadoc/qm-tools/index.html?com/quantimodo/tools/QApplication.html) interface,
or you can extend [QBaseApplication](http://quantimodo.github.io/QuantiModo-SDK-Android/javadoc/qm-tools/index.html?com/quantimodo/tools/QApplication.html).

To do that you need to create a Module, that would provide dependency injection, example can be found in [tests sources](https://github.com/QuantiModo/QuantiModo-SDK-Android/blob/master/quantimodo-sdk-tools/src/androidTest/java/com/quantimodo/tools/testhelpers/TestModule.java)

Configuration stored in ToolsPrefs class instance, which should be created
```
ToolsPrefs prefs = new ToolsPrefs("https://app.quantimo.do/","readmeasurements writemeasurements","QuantimodoTest");
```
Then you need to create AuthHelper component
```
mAuthHelper = new AuthHelper(applicationContext,prefs);
```

Please refer to [test sources](https://github.com/QuantiModo/QuantiModo-SDK-Android/blob/master/quantimodo-sdk-tools/src/androidTest/java/com/quantimodo/tools/testhelpers/), to see how configure application.

#### Use

Most useful components could be :

- [QuantimodoWebAuthenticatorActivity](http://quantimodo.github.io/QuantiModo-SDK-Android/javadoc/qm-tools/index.html?com/quantimodo/tools/activities/QuantimodoWebAuthenticatorActivity.html) , to handle auth. Just launch this activity and it would handle whole auth process, from auth till getting access token
- [AuthHelper](http://quantimodo.github.io/QuantiModo-SDK-Android/javadoc/qm-tools/index.html?com/quantimodo/tools/sdk/AuthHelper.html), can provide and refresh access token
- [TrackingFragment](http://quantimodo.github.io/QuantiModo-SDK-Android/javadoc/qm-tools/index.html?com/quantimodo/tools/fragments/TrackingFragment.html), would help you to submit tokens, could be configurated to show/submit to one category or to any
- [FactorsFragment](http://quantimodo.github.io/QuantiModo-SDK-Android/javadoc/qm-tools/index.html?com/quantimodo/tools/fragments/FactorsFragment.html), shows positive or negative correlations for effect
- [ImportWebFragment](http://quantimodo.github.io/QuantiModo-SDK-Android/javadoc/qm-tools/index.html?com/quantimodo/tools/fragments/ImportWebFragment.html), helps create connections with 3rd-party services
- [SyncHelper](http://quantimodo.github.io/QuantiModo-SDK-Android/javadoc/qm-tools/index.html?com/quantimodo/tools/sync/SyncHelper.html), would help configure sync

## Running tests

Connect device and run in project root

```
./gradlew cAT
```

## Gradle SDK Distribution
The SDK can be found in the [Sonatype Central Repository](https://oss.sonatype.org/#nexus-search;quick~quantimodo) for open-source software. 

[Guide To Publish An Aar To Maven Using Gradle](http://www.survivingwithandroid.com/2014/05/android-guide-to-publish-aar-to-maven-gradle.html)

## Instructions to Deploy and Release Updates to the QM-Android SDK
See http://central.sonatype.org/pages/ossrh-guide.html

## Working with the SDK itself
To work with the SDK you can add it manually as a folder inside your project. You have to do the following:

- Create libs/qm-sdk folder
- Create a file callaed .gitmodules on the root of your project and write the following code:

```
[submodule "libs/qm-sdk"]
	path = libs/qm-sdk
	url = git@github.com:QuantiModo/QuantiModo-SDK-Android.git
```

- Then execute the following commands on the terminal (at the root of the project):

```
git submodule init
git submodule sync
git submodule update
```