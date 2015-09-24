QuantiModo-SDK-Android
======================

This is the software development kit for implementing enabling Android Applications to store or access user Quantified Self data in the QuantiModo database.

For detailed documenation, check out the [JavaDocs](http://quantimodo.github.io/QuantiModo-SDK-Android/javadoc/)!

###QuantiModo-Android
At QuantiModo, data from a variety of applications can be integrated and analyzed to help you discover hidden correlations between your mood, aspects of health, productivity and any of the countless variables that can affect them. 

An example application that QuantiModo supports is [MoodiModo for Android](https://play.google.com/store/apps/details?id=com.moodimodo&hl=en). MoodiModo allows users to easily track their mood on a regular basis using a unique pop-up interface. Feel free to [fork it](https://github.com/mikepsinn/MoodiModo-Android) and modify to track whatever you want!

Rooted users can also install [Quantimodo Sync for Android](https://play.google.com/store/apps/details?id=com.quantimodo.sync&hl=en).  Quantimodo Sync facilitates the uploading of life-tracking data from a wide array of Android life-tracking applications. 

### How to create a new Android project and build it using the QuantiModo SDK

* Install [Android Studio](https://developer.android.com/sdk/installing/studio.html)
1. Clone the repository using Android Studio (VCS -> Checkout from Version Control -> Github). Select your repository.
![](http://i.imgur.com/vyDGWPn.png)
2. Open the project, when prompted import the project from Gradle. Select "Use default gradle wrapper".
3. Open Gradle and run the "signingReport" Gradle task. 
4. Open the Gradle Console and copy the number after SHA1 (your debug signature generated from your keystore file).
5. Don't let anyone get your keystore file. 
![](http://i.imgur.com/NxuGs0a.png)
4. Add your debug signature to the "ALLOWED_COOKIE_SIGNATURES" array in TokenManager. Only apps signed with these key signatures can put or get cookies.  If you ever leak your keystore you have to remove its signature from that array.
5. Remove all the `:` and make all the letters lowercase or you'll get an exception.  
6. Add a comment next to your signature that indicates who's it is, and what it's for.
![](http://i.imgur.com/3yrNE6r.png)
7. Increase your versionCode and versionName in the /app/build/build.gradle file.
5. Run or Debug. (enjoy!!!)

### Testing
- Install your new APK.
- Create a new account in the QuantiModo app.
- Log into QuantiModo.
- Authorize your app to send measurements to QuantiMo.do.
- Send a measurement from your application.
- Check to see that it shows up here: https://quantipress.quantimo.do
- If you don't see it, debug or contact android@quantimo.do.
- If you do see your measurement, then you should be good to publish.

### Gradle SDK Distribution 
The SDK can be found in the [Sonatype Central Repository](https://oss.sonatype.org/#nexus-search;quick~quantimodo) for open-source software. 

[Guide To Publish An Aar To Maven Using Gradle](http://www.survivingwithandroid.com/2014/05/android-guide-to-publish-aar-to-maven-gradle.html)

### Instructions to Deploy and Release Updates to the QM-Android SDK
See http://central.sonatype.org/pages/ossrh-guide.html
