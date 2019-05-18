Feature: User feature

Background:
* def data = read('../data.json')
* configure headers = { Accept: 'application/json' }

Scenario: Testing the exact response of a GET endpoint
Given url 'http://localhost:9090/api/v1/users'
When method GET
Then status 200
And match $ == {id:"4",username:"toto"}

Scenario: Testing that GET response checks specifically for the value of the id field
Given url 'http://localhost:9090/api/v1/users'
When method GET
Then status 200
And match $.id == "6"

Scenario: Testing that GET response contains specific field
Given url 'http://localhost:9090/api/v1/users'
When method GET
Then status 200
And match $ contains {id:"11"}

Scenario: Testing that the id field is not empty
Given url 'http://localhost:9090/api/v1/users'
When method GET
Then status 200
And match $ == {id:"#notnull",first_name:"john"}

Scenario: Testing that the phone field consists only of numeric values
Given url 'http://localhost:9090/api/v1/users'
When method GET
Then status 200
And match $ == {phone:"#number"}

Scenario: Testing a POST endpoint with request body
Given url 'http://localhost:9090/api/v1/users'
And request data[1]
When method POST
Then status 201
And match $ contains {id:"#notnull"}