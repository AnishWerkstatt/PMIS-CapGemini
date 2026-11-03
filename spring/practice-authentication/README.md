# Spring Security practice examples

These are three separate, small Spring Boot projects. They are intentionally
independent of the main project so that each example can be run and changed
without affecting the others.

## What the existing project is doing

The main project already includes `spring-boot-starter-security`. Its
`/hello`, `/hi`, and `/hallo` controller methods do not define authorization
rules themselves, so Spring Boot applies its default security configuration.
The username and password are supplied through `application.properties`.
That is a useful first step, but it does not yet demonstrate users, roles, or a
custom login page.

## Examples

1. `01-default-security`: uses Spring Boot's generated login page and one
   configured user.
2. `02-users-and-roles`: defines two in-memory users and protects endpoints
   with `USER` and `ADMIN` roles.
3. `03-form-login`: enables a form-login flow and uses a custom
   `UserDetailsService` to load a practice user.

Run an example from its own directory with:

```text
.\mvnw.cmd spring-boot:run
```

The examples use `{noop}` passwords only to keep the first exercises easy to
read. Never use plain-text passwords in a real application.
