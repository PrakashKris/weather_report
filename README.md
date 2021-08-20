# weather_report
#Project Overview
1. Maven project
2. Behavior driven development using cucumber
	a. Feature files are kept under test resource folder
	b. Runner class and Step definition files are kept under Cucumber package in test/java.
3. Model package has page object model for each page. Have used Page object factory design


#To run the test
1. Open runner class and run as Junit test
2. Or using Maven goal we can run the test.

#Improvements
1. Logs are not added
2. Reporting needs to be added 

#Note:
Consider following approach to automate the scenario
1. Identified UI temperature for a particular city using selenium webDriver
2. Identified API temperature for a particular city using RestAssured Library
3. With the help range passed from feature file comparatore logic is implemented for the celsius.
