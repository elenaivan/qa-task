Setting it up on mobile

Q1: Which parts of the code you provided would need to be adapted to run the same tests in an Android phone, using the same browser, in the tool you chose?

* we need to connect the mobile framework (Appium or Calabash) to the configuration of the tests  
* we need to have Chrome browser installed on Android phone 
* chromedriver is already there, so we don't need to install it again 
* the setup should be modified to run against a server, and not locally
* this way, we can extend the DesiredCapabilities with a new DesiredCapability for Chrome browser using Android as platform 

Q2: How could we run these tests in a physical Android phone connected to your laptop? Does the laptop need any extra software/hardware to run them properly?

* we need to install on our laptop either Android Studio, or Android SDK tools (they are included in the Android studio), to be able to access the Android debugger (adb)
* the phone needs to be connected to the laptop in development mode 
* we need to define the connected device in the configuration of the tests, as a DesiredCapability, to be able for the tests to recognize it, same as above and same as we would define a new browser 
* we need to set up a device name and we also need to know the device IP 
* the device's IP can be retrieved by connecting to the device in development mode, using an adb command

Q3: What would be the main changes if the website was now part of a hybrid Android app?

* we need to define a path to the app we want to install on the device 
* being hybrid app, I also assume some selectors and flows might be different than on an website 
* we would also need to have mobile specific actions and methods defined, such as tapping or swiping 

Q4: And if it was a native app?

* all the PageObjects would be different and require different selectors for the mobile app 
* flows might be different
* to run the tests, we need to have the app installed previously on the device, and make sure it was launched 
* the capabilities for running have to be changed 
