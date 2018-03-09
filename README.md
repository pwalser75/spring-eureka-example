# Spring Cloud/Eureka Example

Example project for service publication and discovery using **Netflix Eureka**,

## Modules

* **eureka-server** \
Eureka registry server


## Build / Start

Build with Gradle:

    gradlew
    
### Start the eureka-server:

    gradlew startEureka
    
The UI of the eureka-server is then avaliable on http://localhost:8761/ 
    
### Start the application-server:

    gradlew startApplicationServer
    
Hello endpoint: http://localhost:8080/api/hello
    
    {
        "timestamp":"2018-03-09T11:24:21.050",
        "message":"Aloha"
    }

