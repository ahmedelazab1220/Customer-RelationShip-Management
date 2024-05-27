# Customer RelationShip Management.

This project is a comprehensive solution for managing customer relationships, built using modern technologies to ensure robust performance and security. It provides RESTful APIs for `creating`, `reading`, `updating`, and `deleting` customer-related data, along with secure access and validation features.



# Technologies Used

**`Spring Boot (lastest version 3.3.0)`**: A powerful, feature-rich framework for building Java applications.

**`Spring Data JPA`**: Simplifies database interactions by providing a robust data access layer.

**`MySQL`**: A reliable relational database management system used for storing the application's data.

**`Spring DevTools`**: Enhances development experience by providing hot reloading and other useful features.

**`Java 21`**: The latest long-term support (LTS) version of Java, offering new features and improvements.

# Features

**`CRUD Operations`**: Supports Create, Read, Update, and Delete operations for managing clothing store data.

**`Efficient Data Management`** : Utilizes Spring Data JPA for seamless interaction with the MySQL database.

**`Spring Validation`**: Implements validation logic using Spring's validation framework to ensure data integrity and enforce business rules.


# Project Structure

```

MyCustomerRelationShipManagment-Project
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── luv2code
│   │   │           └── demo
│   │   │               ├── CRMRestApiApplication.java
│   │   │               ├── controller
|   |   |               |   └── CustomerController  
|   |   |               |   └── CustomerRestExceptionHandler
│   │   │               ├── service
│   │   │               |   └── CustomerService
|   |   |               |   ├── impl
│   │   │               |       └── CustomerServiceImpl
│   │   │               ├── repository
│   │   │               |   └── CustomerRepository
│   │   │               ├── exc
│   │   │               |   └── CustomerErrorResponse
│   │   │               |   └── CustomerNotFoundException
│   │   │               ├── entity
│   │   │               |   └── Customer
│   │   └── resources
│   │       ├── application.properties
│   └── test
│       └── java
│           └── com
│               └── luv2code
│                   └── demo
│                       └── CRMRestApiApplication.java
└── pom.xml

```

# Installation

  - **`Clone the repository`**:
     
    - git clone https://github.com/ahmedelazab1220/Customer-RelationShip-Management.git
    - you can also download Zip file and extract.  
      

  - **`Set up the MySQL database`**:
    
    ```

      spring.datasource.url=jdbc:mysql://localhost:3306/[your_database_name]?useSSL=false
      spring.datasource.username=[your_username]
      spring.datasource.password=[your_password]
      spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
      spring.jpa.hibernate.ddl-auto=update
      spring.jpa.show-sql=true
      spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
      spring.jpa.properties.hibernate.format.sql=true
    
    ```
    ***`note`*** : if you need to create database automatically you can use this `spring.datasource.url=jdbc:mysql://localhost:3306/[your_database_name]?createDatabaseIfNotExist=true` instead of first line

  - **`Build and run the application`**:     
   
    - mvn clean install
    - mvn spring-boot:run


# Entity RelationShip Diagram

  ![ERD](https://github.com/ahmedelazab1220/Customer-RelationShip-Management/assets/105994948/1e5d096a-92a5-4a30-9b35-dde60cf58e60)
 
  also i make database optimization (`Database indexes`) 

# Testing Endpoints By Postman
   
   i make collection and called `Customer RelationShip Management` and make requests for each endpoint of `Customer Controller Class`

   ![Postman](https://github.com/ahmedelazab1220/Customer-RelationShip-Management/assets/105994948/94e98ff0-df9d-4538-8d17-aeeab6a933d8) 


# Example Request and Response

   **`Request ` Post ` | http://localhost:8080/api/v1/customers`**
   
   ```
    
    {
       "email" : "ahmed@gmail.com",
       "password" : "12345678", 
       "phoneNumber" : "025257975",
    } 

   ```

   **`Response`**
   
   ```

    {
       customer added successfully
    }

   ```



   **`Request ` Get ` | http://localhost:8080/api/v1/customers/1`**
   
   **`Response`**
   
   ```

    {
       "id" : 1,
       "email" : "ahmed@gmail.com",
       "password" : "12345678", 
       "phoneNumber" : "025257975",
    }

   ```

# License

This project is licensed under the MIT License - see the <a href = "https://github.com/ahmedelazab1220/Customer-RelationShip-Management/blob/main/LICENSE"> LICENSE </a> file for details.

# Conclusion

The Customer Relationship Management (CRM) System is designed to be a robust and secure solution for managing customer information and interactions. By leveraging Spring Boot, Spring Data JPA, MySQL, Spring Boot DevTools, and validation, this application ensures a seamless and efficient user experience. Whether you're looking to create, read, update, or delete customer records, this system provides the necessary endpoints and functionality to manage your customer data effectively. Contributions and feedback are welcome to continuously improve and extend the capabilities of this application.