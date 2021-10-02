# Bank Credit System API
___
### Spring Boot Application

---
This project illustrates getting credit-loan from a bank.

### Summary
-- //TODO Write what we aimed in this project and what and how we are finishing this
 project  

#### Requirements
-- //TODO Write how we have achieved and  
##### EXAMPLE
```
• The API will expose an endpoint which accepts the user information (customerID,
initialCredit).

• Once the endpoint is called, a new account will be opened connected to the user whose ID is
customerID.

• Also, if initialCredit is not 0, a transaction will be sent to the new account.

• Another Endpoint will output the user information showing Name, Surname, balance, and
transactions of the accounts.
___
The application has 2 apis
* AccountAPI
* CustomerAPI

JUnit test coverage is 100% as well as integration tests are available.

```html
POST /v1/account - creates a new account for existing customer
GET /v1/customer/{customerId} - retrieves a customer
GET /v1/customer - retrieves all customers
```

### Tech Stack
---

-- //TODO Write what we have used 
```
- Java 11
- Spring Boot
- Spring Data JPA
- Kotlin 1.5.0
- Restful API
- OpenAPI documentation
- H2 In memory database  
- Docker
- Docker compose
- JUnit 5
- ReactJS for frontend
```

### Prerequisites
---
-- //TODO add postgre db
```
- Maven
- Docker
```

### Run & Build
---

-- //TODO explain how to start and use the app

```

There are 2 ways of run & build the application.

#### Docker Compose

For docker compose usage, docker images already push to docker.io

You just need to run `docker-compose up` command
___
*$PORT: 8080*
```ssh
$ cd account
$ docker-compose up


#### Maven

For maven usage, you need to change `proxy` value in the `account-fe/package.json` 
file by `"http://localhost:8080"` due to the default value has been settled for docker image network proxy.
___
*$PORT: 8080*

ssh
$ cd account/account-api
$ mvn clean install
$ mvn spring-boot:run

$ cd account/account-fe
$ npm install
$ npm start
```

### Swagger UI will be run on this url

-- //TODO activate the swagger ui 
```

`http://localhost:${PORT}/swagger-ui.html`

```
