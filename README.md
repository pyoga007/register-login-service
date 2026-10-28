# register-service

A minimal Spring Boot project configured for **JDK 21**.
This service Registers and Login a user.

## Requirements
- JDK 21
- Maven 3.6.3+ (or use your IDE's Maven support)

## Run
From this project directory:

```bash
mvn spring-boot:run
```

Or build and run the JAR:

```bash
mvn clean package
java -jar target/register-service-0.0.1-SNAPSHOT.jar
```

Open http://localhost:8080/ to verify the service. It returns:

```text
register-service is running
```

## Dependency
Only `spring-boot-starter-web` is declared as an application dependency.
