## How to Run


### Running as a packaged application
If you use the Spring Boot Maven or Gradle plugins to create an executable jar you can run your application using java -jar. For example:
~~~
mvn clean install
java -jar target/spring-boot-security-password-encoder-0.0.1-SNAPSHOT.jar
~~~

### Using the Maven plugin
The Spring Boot Maven plugin includes a run goal which can be used to quickly compile and run your application. Applications run in an exploded form just like in your IDE.
~~~
mvn spring-boot:run
~~~

### Using the Gradle plugin
The Spring Boot Gradle plugin also includes a bootRun task which can be used to run your application in an exploded form. The bootRun task is added whenever you import the spring-boot-gradle-plugin:
~~~
$ gradle bootRun
~~~
