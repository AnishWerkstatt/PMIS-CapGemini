# 5. Nested tests and readable names

`@Nested` lets you group tests around a shared scenario. Here, the outer class
describes a validator and the nested classes describe valid and invalid input.
Nested classes make the test report read like a small specification.

`@DisplayName` changes the name shown in the IDE and test report without
changing the Java method name. Nested tests can also have their own lifecycle
methods when a scenario needs special setup.
