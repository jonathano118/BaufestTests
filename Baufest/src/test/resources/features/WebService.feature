Feature: Testing of the request of the Rest API https://petstore.swagger.io/ .

Scenario: POST a new pet
Given a new pet
When I try to add it to the DB
Then I should succesfully save it

