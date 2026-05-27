Microservices Assignment - Java Spring Boot

The system contains 3 microservices:
Service	Purpose	Database	Port
User Service	Manage users	H2	8081
Product Service	Manage products	MongoDB	8082
Order Service	Manage orders	MySQL	8083
________________________________________
Architecture Overview
User Service
Responsible for:
•	Create User
•	Get User
•	Update User
•	Delete User
•	Validation handling
•	Global exception handling
•	H2 In-Memory Database is used in this service
________________________________________
Product Service
Responsible for:
•	Create Product
•	Get Product
•	Update Product
•	Delete Product
•	Product validation
•	Stock validation no order can place more then stock quantity
•	MongoDB user in this service
________________________________________
Order Service
Responsible for:
•	Create Order
•	Get Orders
•	Update Order
•	Delete Order
•	User validation on order user id check before ordering
•	Product validation check product id before ordering
•	Quantity validation
•	MySQL used in this service
Service-to-service communication:
•	Order Service communicates with User Service
•	Order Service communicates with Product Service
________________________________________

Project Structure
microservices_assignmenrt
│
├── docker-compose.yml
├── pom.xml
│
├── user-service
│   └── user-service
│
├── product-service
│   └── product-service
│
└── order-service
    └── order-service
________________________________________
Prerequisites
Before running the project, make sure these are installed:
•	Java 17
•	Maven
•	Docker Desktop
•	Git
•	Eclipse or IntelliJ IDE
________________________________________
Clone Project
git clone <github-url>
Go inside project:
cd microservices_assignment
________________________________________
Build the Project
Build all services using Maven.
In Eclipse:
•	Right Click Parent Project
•	Run As
•	Maven Build
Goals:
clean package -DskipTests
This creates executable JAR files for all services.
________________________________________
Docker Setup
Step 1: Start Docker Desktop
Make sure Docker Desktop is running.
________________________________________
Step 2: Go to root folder of project:-> \microservices_assignment
Open terminal inside root project folder:
docker compose up –build

•	After running the build successfully, please open all three Swagger endpoints in separate browser tabs endpoints are below this page.
•	I have attached sample request body formats in the documentation below for reference. In case any API request does not work initially, please refer to those examples.
•	The APIs can also be tested using Postman.
•	I have created and included a complete Postman collection covering all available endpoints for easier testing.

Swagger API To Test Endpoints use all this below 3
User Service
http://localhost:8081/swagger-ui.html
Product Service
http://localhost:8082/swagger-ui.html
Order Service
http://localhost:8083/swagger-ui.html
________________________________________
Health Check APIs
User Service
http://localhost:8081/actuator/health
Product Service
http://localhost:8082/actuator/health
Order Service
http://localhost:8083/actuator/health
Expected response:
{
  "status": "UP"
}
________________________________________
API Testing Flow
The recommended testing order:
1.	Create User
2.	Create Product
3.	Create Order
________________________________________
User Service APIs
Base URL:
http://localhost:8081/api/users
Create User
POST /api/users
Request:
{
  "name": "Mayank",
  "email": "mayank@gmail.com",
  "phone": "9999999999"
}
________________________________________
Get All Users
GET /api/users
________________________________________
Get User By ID
GET /api/users/{id}
________________________________________
Update User
PUT /api/users/{id}
Request:
{
  "name": "Mayank Updated",
  "email": "mayank@gmail.com",
  "phone": "8888888888"
}
Note:
•	Email cannot be changed during updating validation handled.
________________________________________
Delete User
DELETE /api/users/{id}
________________________________________
Product Service APIs
Base URL:
http://localhost:8082/api/products
Create Product
POST /api/products
Request:
{
  "name": "Laptop",
  "description": "Dell Laptop",
  "price": 50000,
  "stock": 10
}
________________________________________
Get All Products
GET /api/products
________________________________________
Get Product By ID
GET /api/products/{id}
________________________________________
Update Product
PUT /api/products/{id}
Request:
{
  "name": "Laptop Updated",
  "description": "Dell i7 Laptop",
  "price": 70000,
  "stock": 5
}
________________________________________
Delete Product
DELETE /api/products/{id}
________________________________________
Order Service APIs
Base URL:
http://localhost:8083/api/orders
Create Order
POST /api/orders
Request:
{
  "userId": 1,
  "productId": "PRODUCT_ID",
  "quantity": 2,
  "totalAmount": 100000
}
Validation Included:
•	User must exist
•	Product must exist
•	Quantity must not exceed stock
•	Quantity cannot be negative
________________________________________
Get All Orders
GET /api/orders
________________________________________
Get Order By ID
GET /api/orders/{id}
________________________________________
Get Orders By User ID
GET /api/orders/user/{userId}
________________________________________
Update Order
PUT /api/orders/{id}
Request:
{
  "userId": 1,
  "productId": "PRODUCT_ID",
  "quantity": 1,
  "totalAmount": 50000,
  "status": "UPDATED"
}
________________________________________
Delete Order
DELETE /api/orders/{id}
________________________________________
Validation Features
User Service
•	Name required , Email required, Email validation, Unique email validation
Product Service
•	Product name required , Price must be positive, Stock must be positive
Order Service
•	Quantity must be positive, Product must exist, User must exist, Quantity should not exceed stock
________________________________________
