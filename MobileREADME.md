Setting it up on mobile

Q1: Which parts of the code you provided would need to be adapted to run the same tests in an Android phone, using the same browser, in the tool you chose?

* we need to connect the Appium framework to the configuration of the tests  
* we need to have Chrome browser installed on Android phone 
* chromedriver is already there, so we don't need to install it again 
* the setup should be modified to run against a server, and not locally
* this way, we can extend the DesiredCapabilities with a new DesiredCapability for Chrome browser using Android as platform 

Q2: How could we run these tests in a physical Android phone connected to your laptop? Does the laptop need any extra software/hardware to run them properly?

* we need to have Android Studio installed on our laptop 



Q3: What would be the main changes if the website was now part of a hybrid Android app?

Q4: And if it was a native app?

* the PageObjects would be different and require different selectors for the mobile app 
* to run the tests, we need to have the app installed previously on the device, and make sure it was launched 
* the capabilities for running have to be changed 
