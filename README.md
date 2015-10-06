QuantiModo-SDK-Android
======================

This is the software development kit for implementing enabling Android Applications to store or access user Quantified Self data in the QuantiModo database.

## Modules
* SDK
* Swagger generated sdk
* Quantimodo-Tools

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

### Swagger generated sdk

Maven:
```
<dependency>
  <groupId>com.quantimodo.android</groupId>
  <artifactId>sdk-swagger</artifactId>
  <version>1.0</version>
  <type>aar</type>
</dependency>
```

Gradle:
```
compile 'com.quantimodo.android:sdk-swagger:1.0'
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



### How to create a new Android project and build it using the QuantiModo SDK


#### Configure

To use SDK you need to obtain [OAuth2 token](https://app.quantimo.do/api/docs/#oauth2-authentication).
After that you can get instance of QuantimodoApiV2

```
String token = "oauth_token";
QuantimodoApiV2 api = QuantimodoApiV2.getInstance(null);
SdkResponse<User> response = api.getUser(ctx,token);
```

Or if you prefer to use swagger-client

```
//Setup token
String token = "oauth_token";
ApiInvoker apiInvoker = ApiInvoker.getInstance();
apiInvoker.addDefaultHeader("Authorization", "Bearer " + token);

//Create API instance
UserApi api = new UserApi();
```

#### Use

## About Quantimodo-Tools

### How to create a new Android project and build it using the Quantimodo-Tools

## Running tests

##QuantiModo-Android
The [QuantiModo for Android app](https://play.google.com/store/apps/details?id=com.quantimodo.android&hl=en) must also be installed for your users to upload life-tracking data to our free cloud storage system.  At QuantiModo, data from a variety of applications can be integrated and analyzed to help you discover hidden correlations between your mood, aspects of health, productivity and any of the countless variables that can affect them. 

An example open-source application that QuantiModo supports is [MoodiModo for Android](https://play.google.com/store/apps/details?id=com.moodimodo&hl=en). MoodiModo allows users to easily track their mood on a regular basis using a unique pop-up interface. Feel free to [fork it](https://github.com/mikepsinn/MoodiModo-Android) and modify to track whatever you want!

Rooted users can also install [Quantimodo Sync for Android](https://play.google.com/store/apps/details?id=com.quantimodo.sync&hl=en).  Quantimodo Sync facilitates the uploading of life-tracking data from a wide array of Android life-tracking applications. 



### Testing
- Uninstall all QM apps from your phone.
- Install your new APK.
- If QuantiModo for Android is not installed, your app should direct users to the [Play Store](https://play.google.com/store/apps/details?id=com.quantimodo.android&hl=en)
- Create a new account in the QuantiModo app.
- Log into QuantiModo.
- Authorize your app to send measurements to QuantiMo.do.
- Send a measurement from your application.
- Check to see that it shows up here: https://quantimo.do/analyze/
- If you don't see it, debug.
- If you do see your measurement, then you should be good to publish.


## Gradle SDK Distribution
The SDK can be found in the [Sonatype Central Repository](https://oss.sonatype.org/#nexus-search;quick~quantimodo) for open-source software. 

[Guide To Publish An Aar To Maven Using Gradle](http://www.survivingwithandroid.com/2014/05/android-guide-to-publish-aar-to-maven-gradle.html)

## Instructions to Deploy and Release Updates to the QM-Android SDK
See http://central.sonatype.org/pages/ossrh-guide.html