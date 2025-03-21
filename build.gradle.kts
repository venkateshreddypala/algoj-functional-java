plugins {
    java
    application
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(23))
    }
}

tasks.withType<JavaCompile> {
    options.compilerArgs.add("--enable-preview")
}

tasks.withType<JavaExec> {
    jvmArgs("--enable-preview")
}

application {
    // Default fallback
    mainClass.set("Main")
}

val algorithmClass: String? by project

tasks.named<JavaExec>("run") {
    if (algorithmClass != null) {
        mainClass.set(algorithmClass)
    }
}