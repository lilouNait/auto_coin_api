Feature: User feature

Background:
* def data = read('../data.json')
* configure headers = { Accept: 'application/json' }

Scenario: Import several data at once
Given url 'http://localhost:9090/api/v1/users'
And request data[0]
When method POST
Then status 201
Given url 'http://localhost:9090/api/v1/users'
And request data[2]
When method POST
Then status 201
Given url 'http://localhost:9090/api/v1/users'
And request data[3]
When method POST
Then status 201
Given url 'http://localhost:9090/api/v1/users'
And request data[5]
When method POST
Then status 201
Given url 'http://localhost:9090/api/v1/users'
And request data[6]
When method POST
Then status 201
Given url 'http://localhost:9090/api/v1/users'
And request data[7]
When method POST
Then status 201

Scenario: Testing a wrong data for "status"
Given url 'http://localhost:9090/api/v1/users'
And request data[4]
When method POST
Then status 400

Scenario: Testing that the password is not displayed in its real format
Given url 'http://localhost:9090/api/v1/users'
And request data[1]
When method POST
Then status 201
And match $.password != "chat"

Scenario: Post a new user with the same username
Given url 'http://localhost:9090/api/v1/users'
And request data[1]
When method POST
Then status 400

Scenario: Testing the response of a GET endpoint
Given url 'http://localhost:9090/api/v1/users/4'
When method GET
Then status 200
And match $.data contains {id:4,username:"amajohn"}

Scenario: Testing the response of a GET point of a non-existing data
Given url 'http://localhost:9090/api/v1/users/15'
When method GET
Then status 404

Scenario: Testing the response if the size of the table corresponds to the real one
Given url 'http://localhost:9090/api/v1/users'
When method GET
Then status 200
And match $.data == '#[7]'

Scenario: Deleting a user who exists
Given url 'http://localhost:9090/api/v1/users/5'
When method DELETE
Then status 200

Scenario: Deleting a user who does not exist
Given url 'http://localhost:9090/api/v1/users/15'
When method DELETE
Then status 404

Scenario: Basic update on an existing user
Given url 'http://localhost:9090/api/v1/users/1'
And request data[8]
When method PUT
Then status 200

Scenario: Basic update on a user which does not exist
Given url 'http://localhost:9090/api/v1/users/17'
And request data[8]
When method PUT
Then status 404

Scenario: Basic update on an existing username
Given url 'http://localhost:9090/api/v1/users/1'
And request data[9]
When method PUT
Then status 400

Scenario: Testing the login of an existing user
Given url 'http://localhost:9090/api/v1/login'
And request data[5]
When method POST
Then status 200

Scenario: Testing the login of a non-existing user
Given url 'http://localhost:9090/api/v1/login'
And request data[4]
When method POST
Then status 401
