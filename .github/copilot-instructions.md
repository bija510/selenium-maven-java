# GitHub Copilot Instructions for Selenium Maven Java Framework

## 1. Project Overview
This repository is a Selenium WebDriver automation framework using:
- Java 17
- Maven
- TestNG
- Page Object Model (POM)
- Data-driven tests (JSON / Excel)
- ExtentReports
- Log4j2 logging

All tests are under `src/test/java` and framework utilities under `src/main/java`.

---

## 2. Package & Folder Structure
- Use **package-based naming** with dots in code and matching folders:
  - Page objects → `com.qa.pages` (`src/test/java/com/qa/pages`)
  - Test classes → `com.qa.tests` (`src/test/java/com/qa/tests`)
  - Utilities → `com.qa.utils` (`src/main/java/com/qa/utils`)
  - Base classes → `com.qa.base` (`src/test/java/com/qa/base`)
  - TestNG listeners → `com.qa.listeners` (`src/test/java/com/qa/listeners`)
  - Test data → `com.qa.data` (`src/test/java/com/qa/data`)
- Avoid flat folder names; always mirror package names with folders.

---

## 3. Framework Rules
- Follow **Page Object Model** strictly.
- Do **not** use `PageFactory` or inline `driver.findElement()` in test classes.
- Use **Base.java** for WebDriver setup; never create drivers in test classes.
- Tests should call **page object methods only**.
- Assertions go in **test classes**, not page objects.
- Use TestNG annotations (`@Test`, `@BeforeMethod`, `@AfterMethod`, etc.).
- Support **parallel execution** via TestNG XML suites.
- Use reusable utility methods instead of duplicating code.

---

## 4. Locators & WebDriver Interaction
- Keep all locators inside **page classes**.
- Use **explicit waits** from utilities (`SeleniumUtils` or `CommonUtils`) instead of `Thread.sleep()`.
- Avoid hard-coded selectors in tests.

---

## 5. Reporting & Logging
- Use **ExtentReports** for test reports.
- Use **Log4j2** for logging.
- Capture screenshots automatically on test failure using framework utilities.

---

## 6. Test Data
- Read test data from `src/test/java/com/qa/data` (JSON / Excel).
- Do not hardcode test data in test classes.

---

## 7. AI Coding Behavior
When generating new code:
- Respect existing **package & folder structure**.
- Maintain **naming conventions** (camelCase for methods, PascalCase for classes).
- Use **existing utilities** rather than writing new helper methods.
- Prefer **Page Object methods** for interactions in tests.
- Follow **AAA test pattern** (Arrange, Act, Assert).
- Keep test classes **clean and readable**.
- Generate imports automatically matching package paths.
- Follow the framework rules above strictly.

---

## 8. Workspace Context
- Use `@workspace` to reference existing repo files.
- When generating code, read **src/main/java** and **src/test/java**.
- Always prioritize **framework standards and existing project structure**.