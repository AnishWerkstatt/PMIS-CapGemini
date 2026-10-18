# 1. Your first JUnit 5 test

`GreetingTest` uses `@Test` to tell JUnit that a method is a test. The test
arranges a `Greeting` object, calls `sayHello`, and asserts the returned text.
`assertEquals(expected, actual)` gives a clear failure when the values differ.

Try changing `"Hello, Ada!"` to another value and run `mvn test` to see a
failing test. The test should describe the intended behavior, so restore the
correct expectation afterward.
