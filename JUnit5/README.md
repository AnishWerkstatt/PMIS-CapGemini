# Learning JUnit 5 from the beginning

This project is a step-by-step introduction to testing Java code with **JUnit 5**.
You do not need to know testing already. Read the folders in number order, change
the production code, and observe which test fails.

## Prerequisites

- Java Development Kit (JDK) 17 or newer
- Apache Maven 3.8 or newer
- A Java editor such as VS Code with the Extension Pack for Java

Check the installations:

```text
java --version
mvn --version
```

## Open the project correctly in VS Code

Open the `JUnit5` folder itself, or open `JUnit5.code-workspace`. If you open
the parent `Java` folder, its `.vscode/settings.json` already points to all six
module source folders. Do not open only one `src` folder. The project contains six Maven modules, and the Java
extension needs to import the parent `pom.xml` to recognize each
`src/main/java` and `src/test/java` directory as a source root. If a package
line is still red after opening the project, run **Java: Clean Java Language
Server Workspace**, restart VS Code, and allow Maven to finish importing.

## What is a test?

A test is a small Java program that checks whether another piece of code behaves
as expected. A useful test has three parts:

1. **Arrange** - prepare the input and objects.
2. **Act** - call the method being tested.
3. **Assert** - compare the actual result with the expected result.

For example:

```java
int actual = calculator.add(2, 3);
assertEquals(5, actual);
```

The test is not the same thing as the application. Application code goes in
`src/main/java`; test code goes in `src/test/java`. Maven compiles and runs the
test classes automatically.

## Run the examples

From this folder:

```text
mvn test
```

Run one module:

```text
mvn -pl 01-first-test test
```

Run a single test method:

```text
mvn -pl 02-assertions -Dtest=CalculatorTest#addsTwoNumbers test
```

All examples use the `org.junit.jupiter` API. JUnit Jupiter is the JUnit 5
programming model; its engine discovers and executes the tests.

## Learning path

| Folder | Main idea | What to learn |
| --- | --- | --- |
| `01-first-test` | Your first test | `@Test`, assertions, test naming |
| `02-assertions` | Checking behavior | `assertEquals`, `assertTrue`, `assertAll`, `assertThrows` |
| `03-lifecycle` | Test setup and cleanup | `@BeforeAll`, `@BeforeEach`, `@AfterEach`, `@AfterAll` |
| `04-parameterized-tests` | Reusing one test | `@ParameterizedTest`, `@ValueSource`, `@CsvSource` |
| `05-nested-tests` | Organizing scenarios | `@Nested`, `@DisplayName`, readable test groups |
| `06-advanced-tests` | More JUnit tools | dynamic tests, repeated tests, tags, timeouts |

Each folder contains its own README with the code's explanation.

## JUnit 5 architecture

JUnit 5 is a platform made from three important parts:

```text
JUnit Platform
├── Test Engine API       - contract for discovering and running tests
├── JUnit Jupiter         - JUnit 5 programming model and engine
└── JUnit Vintage         - optional engine for older JUnit 3/4 tests
```

- **JUnit Platform** is the foundation. Build tools and IDEs use it to launch
  test runs.
- **JUnit Jupiter** provides the annotations and API used in these examples,
  such as `@Test`, `@BeforeEach`, and `Assertions.assertEquals`.
- **JUnit Vintage** is optional and allows older JUnit 3 or JUnit 4 tests to
  run on the platform. This project only uses Jupiter.
- **JUnit Platform Launcher** coordinates discovery and execution.
- **Surefire** is the Maven plugin that connects Maven to the JUnit Platform.

When you run `mvn test`, the flow is approximately:

```text
Maven -> Surefire -> JUnit Platform -> Jupiter Engine
      -> discover test classes -> execute tests -> report results
```

## JUnit 5 test lifecycle

For a test class, the usual lifecycle is:

```text
@BeforeAll
  @BeforeEach -> @Test -> @AfterEach
  @BeforeEach -> @Test -> @AfterEach
@AfterAll
```

- `@BeforeAll` runs once before all tests in a class. It must normally be
  `static` because JUnit has not created a test object yet.
- `@BeforeEach` runs before every test. Use it to create fresh test data.
- `@Test` marks a method as a test case.
- `@AfterEach` runs after every test, even when the test fails. Use it for
  cleanup.
- `@AfterAll` runs once after every test in the class.

JUnit creates a new test-class instance for every test method by default. This
helps tests stay independent. Do not make one test depend on another test's
execution order.

## Important beginner rules

- Test one behavior at a time.
- Give tests names that describe the expected behavior.
- Prefer testing public behavior instead of private implementation details.
- Keep tests independent and repeatable.
- A green test means the observed behavior matched the assertion; it does not
  prove that every possible input is correct.
- A red test is useful feedback. Read the expected value, actual value, and
  stack trace before changing the test.

After completing these examples, continue with test doubles (stubs, fakes, and
mocks), test-driven development, and integration testing.
