Simple Item API

This small Spring Boot application exposes a minimal REST API to manage items in-memory.

How to run

- Using shipped wrapper (Windows):

```
./mvnw spring-boot:run
```

Or with Maven installed:

```
mvn spring-boot:run
```

API Endpoints

- POST /api/items
  - Description: Add a new item.
  - Body (JSON): { "name": "...", "description": "...", "imageUrl": "...", "price": 9.99 }
  - Validation: `name` (required), `price` (required, > 0)
  - Response: `201 Created` with created item and `Location` header.

- GET /api/items/{id}
  - Description: Retrieve item by id.
  - Response: `200 OK` with item JSON or `404 Not Found`.

Notes

- Data is stored in-memory and lost on restart.
- Validation errors return `400` with a JSON map of field -> message.

Swagger / OpenAPI

- After starting the application, open the Swagger UI at: `/swagger-ui/index.html`
- The OpenAPI JSON is available at: `/v3/api-docs`

Example:

```
# Start the app
./mvnw spring-boot:run

# Open in browser:
http://localhost:8080/swagger-ui/index.html

# OpenAPI JSON:
http://localhost:8080/v3/api-docs
```
