# 6. Advanced JUnit 5 tools

This example introduces three tools that are useful after the basics:

- `@RepeatedTest(3)` runs the same test several times.
- `@TestFactory` creates dynamic tests at runtime. A factory returns a
  collection of `DynamicTest` objects.
- `@Timeout` fails a test if it takes too long. Use a small timeout only when
  the operation has a meaningful time requirement.

`@Tag` labels a test so build tools or IDEs can include or exclude groups. For
example, this class is tagged `advanced`; Maven can select tags when the
Surefire plugin is configured for that purpose.
