Feature: Testing of the primary functionalities of the webpage www.demoblaze.com

Scenario: Sign up a new user
Given a new user opening the webpage
When I try to register with a username and a password
Then I should succesfully signup


Scenario: Log in as the new user
Given a registered user that is not logged in
When I enter the username and a password
Then I should be able to log in


Scenario: add a new laptop
Given a registered user searching for laptops
When I add a new one to the cart
Then I should see it on the cart page

Scenario: Log out from page
Given a logged in user
When I click on log out button
Then I should succesfully log out from page
