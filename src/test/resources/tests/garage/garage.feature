Feature: Garage feature

Background:
* def data = read('../../data_garage.json')
* configure headers = { Accept: 'application/json' }

Scenario: Import several data at once
Given url 'http://localhost:8083/api/v1/users'
And request data[4]
When method POST
Then status 201
Given url 'http://localhost:8083/api/v1/garages'
And request data[0]
When method POST
Then status 201
Given url 'http://localhost:8083/api/v1/garages'
And request data[1]
When method POST
Then status 201
Given url 'http://localhost:8083/api/v1/garages'
And request data[2]
When method POST
Then status 201

Scenario: GET all the user partners
Given url 'http://localhost:8083/api/v1/users'
When method GET
Then status 200

Scenario: GET all the garages
Given url 'http://localhost:8083/api/v1/garages'
When method GET
Then status 200

Scenario: Delete an existing garage
Given url 'http://localhost:8083/api/v1/garages/2'
When method DELETE
Then status 200

Scenario: Delete a non-existing garage
Given url 'http://localhost:8083/api/v1/garages/95'
When method DELETE
Then status 404

Scenario: GET an existing garage
Given url 'http://localhost:8083/api/v1/garages/4'
When method GET
Then status 200

Scenario: GET a non-existing garage
Given url 'http://localhost:8083/api/v1/garages/101'
When method GET
Then status 404

Scenario: Testing the response if the size of the table corresponds to the real one
Given url 'http://localhost:8083/api/v1/garages'
When method GET
Then status 200
And match $.data == '#[2]'

Scenario: Testing the Address Filter of GET
Given url 'http://localhost:8083/api/v1/garages?address=Bordeaux%20France'
When method GET
Then status 200
And match $.data == '#[1]'


Scenario: Testing the POST of an invalid partner
Given url 'http://localhost:8083/api/v1/garages'
And request data[3]
When method POST
Then status 404

Scenario: Basic update on an existing garage
Given url 'http://localhost:8083/api/v1/garages/4'
And request data[5]
When method PUT
Then status 200

Scenario: Basic update on a garage which does not exist
Given url 'http://localhost:8083/api/v1/garages/10'
And request data[5]
When method PUT
Then status 404

