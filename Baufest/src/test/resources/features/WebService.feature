Feature: Testing of the request of the Rest API https://petstore.swagger.io/ .

Scenario: POST a new pet
Given a new pet
When I try to add it to the server
Then I should succesfully save it

Scenario: GET a pet
Given a known pet on the server
When I ask for an existing pet
Then I should succesfully get it

Scenario: PUT on an existing pet
Given a known server of pets
When I try to edit it
Then I should succesfully change it