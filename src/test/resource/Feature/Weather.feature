Feature: Weather comparison from different sources

Scenario: Compare temperature between different source and if its within the range its successful else its not
Given user launches weather application to find weather for "Coimbatore" city
And user invokes get API of weather service to find weather for "Coimbatore" city
When compare the temperature within "1°C" variance range
Then comparison between source is successful else unsuccessful