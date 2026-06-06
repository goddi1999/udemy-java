Here's a short Markdown summary of both links:

***

## [Link 1 – Gradle Init Tutorial (Part 1)](https://docs.gradle.org/current/userguide/part1_gradle_init.html#part1_begin)

Step-by-step guide to create a Java application from scratch using `gradle init`.[1]

### What you do:
```bash
mkdir myproject && cd myproject
gradle init --type java-application --dsl groovy
```

### Generated structure:
```
myproject/
├── gradle/wrapper/         # Gradle wrapper files
├── gradlew                 # run builds on macOS/Linux
├── gradlew.bat             # run builds on Windows
├── settings.gradle         # defines root + subprojects
└── app/
    ├── build.gradle        # dependencies, plugins, main class
    └── src/
        ├── main/java/      # your app code
        └── test/java/      # your tests
```

### Key commands:
```bash
./gradlew build     # compile + test
./gradlew run       # run the app
./gradlew test      # run tests only
```

***

## [Link 2 – Build Init Plugin (java-application + JUnit 4)](https://docs.gradle.org/current/userguide/build_init_plugin.html#sec:java_application)

Documents all `gradle init` options and the `java-application` type specifically.[1]

### `java-application` type uses by default:
- `application` plugin → builds a runnable Java app
- **JUnit 4** for testing (default!)
- `mavenCentral()` as dependency repo
- Generates a sample `App.java` + test class

### To switch test framework:
```bash
# JUnit 4 (default)
gradle init --type java-application --dsl groovy

# JUnit Jupiter (JUnit 5) - recommended for new projects
gradle init --type java-application --dsl groovy --test-framework junit-jupiter

# Specify Java version too
gradle init --type java-application --dsl groovy --test-framework junit-jupiter --java-version 21
```

### For your Vocab Trainer project:
```bash
gradle init \
  --type java-application \
  --dsl groovy \
  --test-framework junit-jupiter \
  --package org.reutlingenuniversity.vocabtrainer \
  --project-name VokabelTrainer \
  --java-version 21
```

> **Note:** Your assignment requires JUnit (80% test coverage), and the default `java-application` type already sets up JUnit 4 automatically. Use `--test-framework junit-jupiter` for JUnit 5 if preferred.[2][1]
