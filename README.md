## Forms

Application for creating requests


---

## What you need:


- Java 11
- Maven
- PostgresSQL

- ES6
- React
- [Superagent](https://github.com/visionmedia/superagent)
- [Bootstrap](https://react-bootstrap.github.io/getting-started/introduction/)


---

## Before you run app:

Do these steps or modify an existing application configuration.

#### Configure PostgresSQL:

- username:  postgres
- password:  admin

#### Create database:
``CREATE DATABASE FORMS;``

#### Create tables:
```
CREATE TABLE request_type(
    id SERIAL PRIMARY KEY,
    name VARCHAR(30) NOT NULL
 );
```

```
CREATE table request (
	id BIGSERIAL PRIMARY KEY,
	name VARCHAR(30) NOT NULL,
	surname VARCHAR(30) NOT NULL,
	policy_number VARCHAR(30) NOT NULL,
	note VARCHAR(5000),
	request_type_id INT,
	CONSTRAINT fk_request_type
	FOREIGN KEY(request_type_id)
REFERENCES request_type(id)
);
```

#### Insert request types:
```
INSERT INTO request_type(name) VALUES ('Constract Adjustment');
INSERT INTO request_type(name) VALUES ('Damage Case');
INSERT INTO request_type(name) VALUES ('Complaint');
```

#### App actual configuration:

- FrontEnd: https://localhost:3000
- BackEnd: https://localhost:8080
- PostgresSQL: https://localhost:5432



---
## Run app!





