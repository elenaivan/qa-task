# Setting it up on mobile

Prerequisites:
* the project is setup as in my example with Java, Selenium Webdriver, and Chrome
* I took Appium as a mobile automation framework 

Q1: Which parts of the code you provided would need to be adapted to run the same tests in an Android phone, using the same browser, in the tool you chose?

* we need to have Chrome browser installed on Android phone 
* chromedriver is already in the project
* since the existing setup of the tests runs the tests locally, we need to modify the configuration and make them run against the Appium server 
* this way, we can extend the DesiredCapabilities with a new DesiredCapability for Chrome using Android as platform name 

Q2: How could we run these tests in a physical Android phone connected to your laptop? Does the laptop need any extra software/hardware to run them properly?

* as far as I know from my current job, no special configuration is needed, because you just connect the device to the laptop and the framework recognizes that there is a device connected and starts the tests on this
* since we would have a real Android device connected to the laptop, it would be good to have installed the Android Debugger (adb) to connect to the device 
* adb comes usually with the Android SDK tools which are included in Android Studio, so I would install Android Studio on the laptop for debugging purposes - but it is not mandatory 
* the phone needs to allow also development mode (in the popup that shows up on the phone when connected to the phone, we should allow USB debugging) 
* for the questions below (if we have a hybrid app or native app), I think that installing Android Studio and all the tools that comes with it, would be required 

Q3: What would be the main changes if the website was now part of a hybrid Android app?

* we need to define the app we want to install on the device 
* further configuration changes are needed - the desired capabilities need to be extended - http://appium.io/docs/en/writing-running-appium/caps/index.html#general-capabilities - the capabilities from Appium for Android are: appActivity and appPackage) 
* these 2 steps apply also to native app
* but, being hybrid app, we have 2 different contexts on the app: WEB_VIEW and NATIVE_APP 
* if the current test scenarios we have are the same on the hybrid app, they do not need to be modified, they should work also on the hybrid app in the WEB_VIEW context 
* we might need to verify if the selectors are the same as on the website, and adapt them if needed
* for NATIVE_APP context, we would need to add new selectors specific to the native app part, also some flows might be different than on the website 
* Appium uses TouchAction for mobile specific actions, e.g. tap, double-tap, scroll, wait etc. - http://appium.io/docs/en/writing-running-appium/touch-actions/ 

Q4: And if it was a native app?

* all the PageObjects would be different and require different selectors for the mobile app 
* we would need to write methods to interact with these objects from the mobile pages 
* flows and available features might be different than on an website 
* the tests would have to be adapted 
