# Feature Flag Demo Using Togglz 
 
- https://www.togglz.org/ 
- https://www.togglz.org/documentation/spring-boot-starter

## Introduction
This Java-based project provides a simple yet effective demonstration of feature toggling in a product management context. The core functionality revolves around the `ProductService` class, which manages a list of products and applies discounts based on feature toggles.

## Features
- **Product Management**: Basic management of a product catalog.
- **Feature Toggle**: Use of feature flags to apply discounts to products dynamically.

## Prerequisites
- Java JDK 21 or higher
- Maven (for dependency management and project build)
- An IDE like IntelliJ IDEA

## Setup and Installation
1. **Clone the Repository**
2. **Open Project in IntelliJ IDEA**
- Open IntelliJ IDEA.
- Choose 'Open' and select the project directory.

3. **Resolve Maven Dependencies**
- IntelliJ should automatically start downloading the required Maven dependencies. If not, trigger this manually from the Maven tab.

## Project Structure
- `src/main/java/com/yourorganization/ProductService.java`: Main service class managing products and discounts.
- `src/main/resources/`: Contains resource files if any.
- `pom.xml`: Maven configuration file with project dependencies.

## Usage
The `ProductService` class provides methods to retrieve a list of products and apply discounts to them if the feature flag `DISCOUNT_APPLIED` is active.

- To change the products or discount logic, modify the `ProductService` class.
- Feature flags are managed via the `FeatureManager` interface, which should be implemented as per your feature flagging tool or framework.
## Running the Application
1. **Using an IDE (IntelliJ IDEA)**
- Use IntelliJ's run configuration to start the application.
- Navigate to `FeatureFlagApplication.java` and run the main method.

2. **Using the Command Line**
- Navigate to the root directory of the project.
- Run the following command:
  ```
  mvn spring-boot:run
  ```
- The application will start, and by default, it will be available on `http://localhost:8080`.

## Accessing the Application
Once the application is running, you can access it via a web browser or API testing tools like Postman at `http://localhost:8080/products`.

## Enable & Disable Feature Flag Using Admin Panel
Once the application is running, you can access Togglz admin Panel http://localhost:8080/custom-togglz-path/index

