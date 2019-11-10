# springbootjdbc
Sample Spring Boot JDBC API with Junit 5. The project is based on the following  
<https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/jdbc/core/namedparam/NamedParameterJdbcTemplate.html>  
<https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/jdbc/core/namedparam/MapSqlParameterSource.html> 

## Running the application
To run the application from the command line chang to the project root directory and simply type gradle bootRun.
To run the application inside Eclipse.
Simply clone or download the project. 
The main starting point for the application is  <https://github.com/morrisoncm/springbootjdbc/blob/master/src/main/java/com/demo/jdbc/Application.java>.
Right click the Application.java  and select Run As ->Java Application.

## Postman Scripts
To test using Postman the scripts are in the following location <https://github.com/morrisoncm/springbootjdbc/tree/master/postman>.

## Database - h2
By default, Spring Boot will configure an H2 database for us. H2 is a  database to develop against because it has an Oracle compatibility mode. The application.properties initializes the datasource and the data.sql and schema.dql with initialize a sample demo_users db with a default user. To access the database. 

The h2 console can be accessed at the following location http://127.0.0.1:8080/h2-console. To sign onto the console the credentials are in the following directory
<https://github.com/morrisoncm/springbootjdbc/blob/master/src/main/resources/application.properties>
