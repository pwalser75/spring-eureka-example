# Spring Cloud/Eureka Example

Example project for service publication and discovery using **Netflix Eureka**,

## Modules

* **eureka-server** \
Eureka registry server
* **application-api** \
Example application API (DTOs)
* **application-server** \
Example application server, provides REST web services and registers itself on Eureka
* **application-client** \
Example application client, consumes REST web services and looks them up on Eureka

## Build / Start

Build with Gradle:

    gradlew
    
### Start the eureka-server:

    gradlew startEureka
    
The UI of the eureka-server will be avaliable on `http://localhost:8761/`
    
### Start the application-server:


    gradlew startApplicationServer
    
Hello endpoint: `http://localhost:8080/api/hello`
    
    {
        "timestamp":"2018-03-09T11:24:21.050",
        "message":"Aloha"
    }

### Start the application-client:

    gradlew startApplicationClient
    
The application client will resolve the application server over Eureka, and invoke the `GET /api/hello` 
endpoint to obtain a hello message.