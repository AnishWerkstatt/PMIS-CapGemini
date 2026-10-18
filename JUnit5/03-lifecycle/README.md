# 3. Lifecycle and test fixtures

`ShoppingCartTest` shows when setup and cleanup methods run. `@BeforeEach`
creates a new cart before every test, so one test cannot accidentally reuse
another test's items. `@AfterEach` is the place for per-test cleanup.

The messages printed by `@BeforeAll` and `@AfterAll` make the order visible in
the Maven output. Console output is for learning here; production tests should
usually assert behavior instead of relying on printed text.
