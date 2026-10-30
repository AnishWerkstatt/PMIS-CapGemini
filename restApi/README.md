# Course REST API learning example

This project contains one small example for each HTTP method shown in the
course application diagram. The data is kept in memory, so no database setup
is needed. Restarting the application resets the sample courses.

## Directory structure

```text
src/main/java/com/anishAISaaS/restApi/
├── RestApiApplication.java       # Starts Spring Boot
├── controller/
│   ├── GetAllCoursesController.java
│   ├── GetCourseController.java
│   ├── CreateCourseController.java
│   ├── UpdateCourseController.java
│   └── DeleteCourseController.java
├── entity/Course.java             # Course data
├── repository/CourseRepository.java # In-memory storage
└── service/CourseService.java     # Application logic
```

## Run the application

Run `RestApiApplication.java` from your IDE, or run this command from the
`restApi` directory:

```text
.\mvnw.cmd spring-boot:run
```

The application starts at `http://localhost:8080`.

## Try each operation

### GET all courses

Run `GetAllCoursesController.java` only to study the controller file. Start
the application by running `RestApiApplication.java`, then call:

```text
GET http://localhost:8080/courses
```

### GET one course

```text
GET http://localhost:8080/courses/1
```

### POST a new course

```text
POST http://localhost:8080/courses
Content-Type: application/json

{
  "title": "REST APIs",
  "description": "Learn HTTP methods with Spring Boot"
}
```

### PUT an existing course

```text
PUT http://localhost:8080/courses/1
Content-Type: application/json

{
  "title": "Advanced Java",
  "description": "Update an existing course"
}
```

### DELETE a course

```text
DELETE http://localhost:8080/courses/1
```
