# Automated testing with Java, Selenium WebDriver and Maven

This is a first version of an automation testing suite with Java, Selenium WebDriver and Maven. 
The tests run locally at the moment, on Chrome. 

# Prerequisites 

- have JRE installed locally 
- have Maven installed locally
- have ChromeDriver installed locally

For Mac users, you can use homebrew to install the prerequisites:

homebrew install maven
homebrew install chromedriver 


# Future plans

Usually, tests run on a server. What is done in this project, is a basic automation testing functionality that only runs the tests on the ChromeDriver installed locally. 

In order to be run on a server, you need to add selenium-server as a Maven dependency, and change the configuration of the test suite. 

# More instructions can be found here:

https://maven.apache.org/download.cgi

https://maven.apache.org/install.html 

https://chromedriver.chromium.org/downloads


# Useful links

https://www.seleniumhq.org/docs/03_webdriver.jsp#setting-up-a-selenium-webdriver-project








