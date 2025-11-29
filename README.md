## persistence-jdbc

### QuickStart Guide
Welcome to the documentation, it is a quick guide to get you up and running. Before beginning please complete [Setting Up Your Windows](https://github.com/morrisoncm/documentation/wiki/2.-Setting-Up-Your-Windows). The [repositories](https://github.com/morrisoncm/documentation/wiki/1.-Home#repositories) below can be viewed and cloned from [morrisoncm](https://github.com/morrisoncm?tab=repositories).

### Running the application

- Clone or download the project
- To build the application from Terminal / Command Prompt
- Change directory to the project root directory and type `gradle build` and press enter
- To run the application and type `gradle bootRun` and press enter
- To run the application and output console logs to a file type `gradle bootRun > console.log 2>&1`

### Testing the application

- To run the tests alone in the root directory type `gradle test` and press enter
- Download and install postman <https://www.getpostman.com/downloads/>
- Import the test scripts in the root directory under the folder postman

## Database - h2

- By default, Spring Boot will configure an H2 database for us
- H2 is a database to develop against because it has an Oracle compatibility mode
- The application.properties initializes the datasource, data and schema
- The h2 console can be accessed at the following location http://127.0.0.1:8080/h2-console
- To sign onto the console the credentials are in the following directory
  /src/main/resources/application.properties

### Official Documentation

- [GitHub](https://docs.github.com/en/get-started)
- [OpenJDK](https://openjdk.org/install/)
- [Spring Topical Guides](https://spring.io/guides#topical-guides)
- [Gradle](https://gradle.org/install/)
- [Gradle Guildes](https://gradle.org/guides/)
- [PostmanAPI](https://gradle.org/install/)