# Setting it up on mobile

Prerequisites:
* the project is setup as in my example with Java, Selenium Webdriver, and Chrome
* as an example, I took Appium framework and we assume that it is already integrated and set up to run the tests using it 

Q1: Which parts of the code you provided would need to be adapted to run the same tests in an Android phone, using the same browser, in the tool you chose?

* we need to have Chrome browser installed on Android phone 
* chromedriver is already in the project
* since the existing setup of the tests runs the tests locally, we need to modify the configuration and make them run against the Appium server 
* this way, we can extend the DesiredCapabilities with a new DesiredCapability for Chrome browser using Android as platform name 

Q2: How could we run these tests in a physical Android phone connected to your laptop? Does the laptop need any extra software/hardware to run them properly?

* as far as I know from my current job, no special configuration is needed, because you just connect the device to the laptop and the framework recognizes that there is a device connected and starts the tests on this
* since we would have a real Android device connected to the laptop, it would be good to have installed the Android Debugger (adb) to connect to the device 
* adb comes usually with the Android SDK tools which are included in Android Studio, so I would install Android Studio on the laptop for debugging purpose 
* the phone needs to allow also development mode (in the popup that shows up on the phone when connected to the phone, we should allow USB debugging) 
* I think more things are needed in the case we run a native app on a real device 

Q3: What would be the main changes if the website was now part of a hybrid Android app?

* we need to define a path to the app we want to install on the device 
* being hybrid app, I also assume some selectors and flows might be different than on an website 
* we would also need to have mobile specific actions and methods defined, such as tapping or swiping 

Q4: And if it was a native app?

* all the PageObjects would be different and require different selectors for the mobile app 
* we would need to write methods to interact with these objects from the mobile pages (e.g. tap, wait, swipe, scroll etc.)
* flows and available features might be different than on an website 
* the tests would have to be adapted 
* to run the tests, we need to have the app installed previously on the device, and make sure it was launched 
* configuration changes might be needed 
