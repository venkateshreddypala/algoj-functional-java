# Functional Java Playground 🚀

[![Java Version](https://img.shields.io/badge/java-24-blue)](https://openjdk.org/projects/jdk/24/)
[![Build with Gradle](https://img.shields.io/badge/build-gradle-kotlin-blueviolet)](https://gradle.org)
[![Spring Boot](https://img.shields.io/badge/spring--boot-3.2.3-brightgreen)](https://spring.io/projects/spring-boot)
[![Kafka](https://img.shields.io/badge/kafka-event--streaming-orange)](https://kafka.apache.org)
[![License](https://img.shields.io/badge/license-MIT-green.svg)](LICENSE)

---

## 📚 Table of Contents

- [Overview](#functional-java-playground-)
- [Learning Tracks](#-learning-tracks)
- [Run Examples](#-run-any-example)
- [Kafka + Spring Boot REST API](#-spring-boot--kafka)
- [Interactive Jupyter + JShell](#-interactive-notebooks)
- [Docker & Kubernetes](#-docker--kubernetes)
- [CI/CD with GitHub Actions](#-cicd-pipeline)
- [Testing](#-testing)

---

## 🧠 Learning Tracks

### Functional Programming
Includes:
- Lambdas
- Streams
- Optionals
- Recursion
- Pattern Matching
- Pure Functions

### Object-Oriented Programming
Includes:
- Basics
- Inheritance
- Polymorphism
- Abstraction

---

## 🚀 Run Any Example

```bash
./gradlew run -Palgorithm=<package>.<ClassName>
```

---

## 🌐 Spring Boot + Kafka

Start the backend REST API:

```bash
./gradlew bootRun -PmainClass=springboot.kafka.KafkaRestApplication
```

Send a sample order:

```bash
curl -X POST http://localhost:8080/orders \
  -H "Content-Type: application/json" \
  -d '{"product":"Laptop", "quantity":2}'
```

Kafka is preconfigured to use `localhost:9092`.

---

## 💻 Interactive Notebooks

Launch Java 24 code notebooks:

```bash
jupyter notebook
```

Open any `.ipynb` under `/notebooks/` to explore functional programming live using JShell.

---

## 🐳 Docker & Kubernetes

### Docker

Start Kafka locally:

```bash
docker-compose up -d
```

Build and run Spring Boot app:

```bash
./gradlew bootJar
docker build -t kafka-rest-app .
docker run -p 8080:8080 kafka-rest-app
```

### Kubernetes

TBD: Kubernetes manifests are coming soon!

---

## ⚙️ CI/CD Pipeline

GitHub Actions pipeline builds and tests the app on every push.

### Sample Workflow

```yaml
name: Build and Dockerize

on:
  push:
    branches: [ main ]

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      - name: Set up JDK
        uses: actions/setup-java@v3
        with:
          java-version: 21
          distribution: temurin
      - name: Build with Gradle
        run: ./gradlew build

  docker:
    needs: build
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      - name: Build Docker Image
        run: |
          ./gradlew bootJar
          docker build -t kafka-rest-app .
```

Place this in `.github/workflows/build.yml`

---

## 🧪 Testing

Run tests with:

```bash
./gradlew test
```

---

Made with ❤️ using Java 24, Kafka, Spring Boot, and Gradle.