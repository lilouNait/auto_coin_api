# Garage Corner Rest API


## Introduction

* The Garage Corner is an application that allows the user to find the nearest garages around him or even more, to find the 
best garage for your car.
* In this application, there are two types of users, client or partner:
The Client is the type of user who is looking for garages and the Partner is the other type of user 
who is offering garages.
* The application is based on a front-end for the User Interface and a Back-End for the data which is exposed by a Rest 
API. 

## Technologies for the REST API

* We have chosen to use the Framework SpringBoot 2.1.4 to expose the REST API. All the data is stored using 
an h2 base. The particularity of the h2 base is that it is fully controlled by the Java Framework and does not require other installations.

## Technical Documentation

* All the technical documentation can be found in the documentation folder which is generated on the application maven install job. Three main technical documentations can be found in this folder:
1. A swagger.json, which is a json file, represents the global architecture of the exposed API
2. DocumentationAPI.html is a more friendly representation of the architecture of the API. 
3. The JavaDoc folder contains a basic javadoc rendered documentation that lists all the classes and functions used for the application.

##Geocode

A google framework called Geocode is used to convert Address to GPS Coordinates. The package geocode contains the implementation of this API. It also gives the possibility to find all the nearby Garages from an address (for example within 50 kilometers).
The use of this framework implies that the application needs to have access to the internet in order to work normally. 


##User manual 

* To install the application, if you have maven, you can simply use the command mvn install in an IDE and proceed to a maven install.
* To launch the application, you can directly run the GarageCornerApplication from your IDE. Or you can eventually run in the target folder the "garagecorner-0.0.1-SNAPSHOT.jar" with the command "java -jar garagecorner-0.0.1-SNAPSHOT.jar"

##Structure

* The application base path is "/api/v1"
* It uses a Basic Auth authentication. The User and Password can be found in the application.properties.



