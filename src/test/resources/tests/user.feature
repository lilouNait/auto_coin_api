Scenario: Testing the exact response of a GET endpoint
Given url 'http://localhost:8080/user/get'
When method GET
Then status 200
And match $ == {id:"4",username:"toto"}

Scenario: Testing that GET response checks specifically for the value of the id field
Given url 'http://localhost:8080/user/get'
When method GET
Then status 200
And match $.id == "6"

Scenario: Testing that GET response contains specific field
Given url 'http://localhost:8080/user/get'
When method GET
Then status 200
And match $ contains {id:"11"}

Scenario: Testing that the id field is not empty
Given url 'http://localhost:8080/user/get'
When method GET
Then status 200
And match $ == {id:"#notnull",first_name:"john"}

