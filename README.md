# ethpool_analyzer
Data extraction from ethpool.org

## Requirements
+ Maven 3.3.x
+ Java 1.8.x

## Usage
1. Run ``` mvn clean install ``` in root folder
2. Run ``` mvn spring-boot:run ```

## Configuration
Configuration can be changed via src/main/resources/application.yml:

+ ```spring.datasource``` - database configurations
+ ```spring.jpa.properties.hibernate.dialect``` - dialect to be used by Hibernate (default: PostgreSQL9Dialect). Adjust when changing database.
+ ```rest.url``` - url of the REST API of ethpool.org (do not change!)
+ ```logging``` - logging configuration (filepath, loglevel,...)

## Technology Stack
Language: Java 8

Frameworks: 
+ Spring-boot
+ Hibernate

Optional libs (included in pom.xml):
+ PostgreSQL (adjust when changing database)


