# 4. Parameterized tests

A parameterized test runs the same test body with multiple inputs. This avoids
copying nearly identical methods and makes the set of examples obvious.

`@ValueSource` supplies a list of simple values. `@CsvSource` supplies several
columns per case; JUnit converts these strings to the method's declared types.
The method must use `@ParameterizedTest`, not `@Test`.
