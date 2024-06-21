# FastFixQA
Overview:

A test automation framework for a web application FastFix. Using Java, Rest Assured, TestNG and Logback for testing functionalities and performance. 

Prerequisites:

Java 11 or higher

Gradle

ChromeDriver (for Selenium WebDriver)

Directory Structure:

The repository is organized into the following directories:

src/test: Contains the test classes and resources.

java: Java test classes organized by feature or endpoint.

resources: Test data and configuration files.

Test Classes:

The test classes are organized by feature or endpoint, and are named accordingly. Each test class contains multiple test methods, which are annotated with @Test and use Rest Assured to send requests to the API endpoints.

TestNG

The framework uses TestNG as the testing framework. TestNG provides features such as parallel testing, data-driven testing, and reporting.

Configuration:

The framework uses a config.properties file to store configuration settings, such as the base URL of the API and authentication credentials.

Contributing:

We welcome contributions to improve the FastFixQA project. Please fork the repository, create a feature branch, and submit a pull request.
