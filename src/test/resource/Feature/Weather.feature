Feature: Weather comparison from different sources

Scenario: Compare temperature between different source and if its within the range its successful else its not
Given user launches weather application to find weather for "Coimbatore" city
And user invokes get API of weather service to find weather for "Coimbatore" city
When compare the temperature within "5C" variance range
Then comparison between source is successful else unsuccessful 



#
#Problem Statement
#Create a test automation project that validates weatherinformation from differentsources and enables a comparison between them
#
#UI Layer
#Usehttps://www.accuweather.com/as the UI sourceand get weather information forany city
#
#API layer
#
#Use any rest-client to automate the API listed athttps://openweathermap.org/current
#toget current weather information for any city. 
#Use“7fe67bf08c80ded756e598d6f8fedaea'” as the API key
#
#Comparator
#
#1.Create acomparator logicthat matches the temperatureinformation from theUI against that from the API
#2.Add avariancelogic that returns a success if temperaturedifference between 2sources is within a specified range,
# else return acustom exception