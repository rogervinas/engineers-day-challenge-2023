plugins {
  id("org.jetbrains.kotlin.jvm") version "2.2.21"
  application
}

repositories {
  mavenCentral()
}

dependencies {
  testImplementation(platform("org.junit:junit-bom:6.0.1"))
  testImplementation("org.junit.jupiter:junit-jupiter-engine")
  testImplementation("org.junit.jupiter:junit-jupiter-params")

  testImplementation("org.assertj:assertj-core:3.27.6")
}

application {
  mainClass.set("engineers.day.challenge.AppKt")
}

tasks.withType<Test> {
  useJUnitPlatform()
  testLogging {
    events(
      org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED,
      org.gradle.api.tasks.testing.logging.TestLogEvent.SKIPPED,
      org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED
    )
    exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
    showExceptions = true
    showCauses = true
    showStackTraces = true
  }
}
