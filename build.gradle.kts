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

dependencies {
    implementation("org.apache.kafka:kafka-clients:3.7.0")
    implementation("com.google.code.gson:gson:2.10.1")
}


dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:3.2.3")
    implementation("org.springframework.kafka:spring-kafka:3.1.1")
}
