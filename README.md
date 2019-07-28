# springbootjdbc
Sample Spring Boot JDBC API with Junit 5. The dao uses the following  
   <https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/jdbc/core/namedparam/NamedParameterJdbcTemplate.html>

This class delegates to a wrapped JdbcTemplate once the substitution from named parameters to JDBC style '?' placeholders is done at execution time. It also allows for expanding a List of values to the appropriate number of placeholders.

The underlying JdbcTemplate is exposed to allow for convenient access to the traditional JdbcTemplate methods.

##Database - H2
By default, Spring Boot will configure an H2 database for us. H2 is a  database to develop against because it has an Oracle compatibility mode. The application.properties initializes the datasource and the data.sql and schema.dql with initialize a sample demo_users db with a default user. To access the database. 

The h2 console can be accessed at the following location http://127.0.0.1:8080/h2-console with the following credentials

1. jbdc url = jdbc:h2:mem:userdb
2. username = sa
3. password =


##Postman scripts
To test using Postman the scripts are in the following location postman/demo - users.postman_collection.json. Simply import and start the application using the com.demo.jdbc.Application.java
