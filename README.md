# Learning Selenium "a pelo"

## Description
Project to test Selenium framework without any additional libraries, to learn how Selenium works "under the hood".

## Local development

### Browser tests
These tests start a Firefox via Selenium (you will need Firefox installed locally).

### Java version
**This project requires Java 25** (toolchain `languageVersion = 25`).

#### Where to get Java 25 (macOS / Linux / Windows)
Pick any JDK vendor that provides Java 25 builds (e.g., Eclipse Temurin https://adoptium.net/temurin/releases/)

Install tips by OS:
- **macOS**:
    - Option A (Homebrew): `brew install openjdk@25` (if available in your Homebrew) and ensure Homebrew's JDK is on your `PATH`.
    - Option B: install from Adoptium.
- **Linux**:
    - Preferred: download a tarball/package from Adoptium and install system-wide.
    - Some distros may provide JDK 25 via the package manager.
- **Windows**:
    - Download and install from Adoptium and ensure `JAVA_HOME` and `PATH` are set (the installer can do this).

Check your Java installation:

```sh
java -version
```

### Build & run tests
This project is built with the Gradle wrapper.

**macOS / Linux**
```sh
./gradlew clean test
```

**Windows (PowerShell)**
```powershell
.\gradlew.bat clean test
```

## Links
* **Git**:  [See the Git best practices](docs/git-best-practices.md).
* **Java Development Kit**: [See the Java best practices](docs/java-best-practices.md).
* **Gradle**: Use gradle wrapper.
* **IDE**: see [intelliJ](docs/intelliJ.md)/[eclipse](docs/eclipse.md), depending on your prefered IDE.
* **Gherkin**: [Gherkin - best practices & tips](https://rochewiki.roche.com/confluence/pages/viewpage.action?pageId=332479506)
* [Selenium webdriver](https://www.selenium.dev/ecosystem/)
* [Selenium tests practices](https://www.selenium.dev/documentation/test_practices)
* [Practical-test-pyramid.](https://martinfowler.com/articles/practical-test-pyramid.html)
* [Page Object](https://martinfowler.com/bliki/PageObject.html#footnote-panel-object)
