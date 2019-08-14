# Automated testing with Java, Selenium WebDriver and Maven

This is a first version of an automation testing suite with Java, Selenium WebDriver and Maven. The tests run locally at the moment, on Chrome browser.

# Prerequisites / Setup

- have JRE installed locally
- have Maven installed locally
- have ChromeDriver installed locally

For Mac users, you can use homebrew to install the prerequisites:

* `homebrew install maven`
* `homebrew install chromedriver`

This automatically adds them to the PATH.

For other operating systems, it is a bit more complicated: you need to install the dependencies locally and then add their location to the PATH, and make sure it was updated.

More instructions can be found here:

* https://maven.apache.org/download.cgi

* https://maven.apache.org/install.html

* https://chromedriver.chromium.org/downloads

# Running the tests on Selenium Grid server

Usually, tests run on a Selenium Grid server. What is done in this project, is a basic automation testing functionality that only runs the tests on the ChromeDriver installed locally.

In order to be run on a server, you need to:
* add selenium-server as a Maven dependency
* install it also locally
* add selenium-server as a Maven dependency
* start the local hub for the selenium server, e.g. `java -jar selenium-server-standalone-<version>.jar -role hub`
* start the node on which the tests will run, e.g. `java -jar selenium-server-standalone-<version>.jar -role node  -hub http://localhost:4444/grid/register`
* change the configuration of the tests to use this selenium server
* add Chrome for example in DesiredCapabilities, e.g. `DesiredCapabilities capability = DesiredCapabilities.chrome();`
* setup capabilities properties, such as browser version or platform

In this way, running the tests on different browsers is easier, because you set them up as different capabilities.


# Useful links

https://www.seleniumhq.org/docs/03_webdriver.jsp#setting-up-a-selenium-webdriver-project
