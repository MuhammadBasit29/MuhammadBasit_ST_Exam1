

## Exam Description

This exam implements and tests an **Eco-Friendly Vehicle Toll Discount System** using Java and JUnit 5.

The system calculates a vehicle's toll discount percentage based on:

- Vehicle weight
- Whether the vehicle is electric (EV)
- Whether the vehicle is part of a carpool

The exam demonstrates software testing techniques including:

- Equivalence Partitioning (EP)
- Boundary Value Analysis (BVA)
- Decision Table Testing (DT)
- Code Coverage (CC)
- Branch Coverage (BC)

The project contains **21 unique functional test cases**. Duplicate test cases are not repeated when the same input is used by multiple testing techniques.

---

## Technologies Used

- Java
- Maven
- JUnit 5
- IntelliJ IDEA
- Git
- GitHub

---

# System Rules

The `TollCalculator` calculates a discount percentage based on vehicle weight and vehicle characteristics.

### 1. Invalid Weight

If:

```text
weight <= 0
```

the system throws:

```text
IllegalArgumentException
```

### 2. Tier 1

For:

```text
0 < weight <= 1200
```

the discount is:

```text
0%
```

regardless of EV or carpool status.

### 3. Tier 2

For:

```text
1200 < weight <= 3500
```

the discount is:

| EV | Carpool | Discount |
|---|---|---:|
| No | No | 0% |
| Yes | No | 10% |
| No | Yes | 10% |
| Yes | Yes | 15% |

### 4. Tier 3

For:

```text
weight > 3500
```

the discount is:

| EV | Carpool | Discount |
|---|---|---:|
| No | No | 5% |
| Yes | No | 5% |
| No | Yes | 5% |
| Yes | Yes | 25% |

---

# Project Structure

```text
MuhammadBasir_ST_Exam1/
│
├── README.md
├── pom.xml
│
└── src/
    ├── main/
    │   └── java/
    │       └── TollCalculator.java
    │
    └── test/
        └── java/
            └── TollCalculatorTest.java
```

---

# Prerequisites

Before running the project, install:

### Java

The project is configured to use Java 26.

Check your Java installation:

```bash
java -version
```

### Maven

Check Maven:

```bash
mvn -version
```

The project uses Maven to compile the Java source code and run the JUnit tests.

---

# How to Run the Project

## Step 1: Clone the Repository

Clone this GitHub repository:

```bash
git clone <https://github.com/MuhammadBasit29/MuhammadBasit_ST_Exam1>
```

Then move into the project directory:

```bash
cd MuhammadBasir_ST_Exam1
```

---

## Step 2: Verify Java

Run:

```bash
java -version
```

Make sure Java is installed and available through the command line.

---

## Step 3: Verify Maven

Run:

```bash
mvn -version
```

Maven should display its version and the Java version being used.

---

## Step 4: Run the Tests

Run:

```bash
mvn test
```

Maven will:

1. Compile the main Java source code.
2. Compile the JUnit test code.
3. Execute all test cases.
4. Display the test results.

The final correct implementation should result in:

```text
Tests run: 21
Failures: 0
Errors: 0
Skipped: 0
```

and:

```text
BUILD SUCCESS
```

---

# Running Tests in IntelliJ IDEA

The tests can also be executed directly from IntelliJ IDEA.

1. Open the project in IntelliJ IDEA.
2. Open:
   ```text
   src/test/java/TollCalculatorTest.java
   ```
3. Right-click inside the file.
4. Select:
   ```text
   Run 'TollCalculatorTest'
   ```
5. IntelliJ will display the test results.

A successful run should show all **21 tests passing**.

---

# Test Design

The project uses three functional test-design techniques:

## 1. Equivalence Partitioning

Equivalence Partitioning divides the input domain into groups where values are expected to behave similarly.

The following partitions are represented:

- Invalid weight
- Tier 1
- Tier 2 with neither EV nor carpool
- Tier 2 with EV only
- Tier 2 with carpool only
- Tier 2 with both EV and carpool
- Tier 3 with neither EV nor carpool
- Tier 3 with EV only
- Tier 3 with carpool only
- Tier 3 with both EV and carpool

---

## 2. Boundary Value Analysis

Boundary Value Analysis tests values around important boundaries.

The project tests the boundaries around:

### Weight = 0

```text
-1
 0
 1
```

### Weight = 1200

```text
1199
1200
1201
```

### Weight = 3500

```text
3499
3500
3501
```

These values test the behavior immediately below, at, and immediately above each important boundary.

---

## 3. Decision Table Testing

Decision Table Testing is used to test combinations of conditions.

The decision table considers:

- Weight category
- EV status
- Carpool status

All **13 decision rules** are represented by the test cases.

| Rule | Weight Category | EV | Carpool | Expected |
|---|---|:---:|:---:|---:|
| R1 | Invalid | F | F | Exception |
| R2 | Tier 1 | F | F | 0% |
| R3 | Tier 1 | T | F | 0% |
| R4 | Tier 1 | F | T | 0% |
| R5 | Tier 1 | T | T | 0% |
| R6 | Tier 2 | F | F | 0% |
| R7 | Tier 2 | T | F | 10% |
| R8 | Tier 2 | F | T | 10% |
| R9 | Tier 2 | T | T | 15% |
| R10 | Tier 3 | F | F | 5% |
| R11 | Tier 3 | T | F | 5% |
| R12 | Tier 3 | F | T | 5% |
| R13 | Tier 3 | T | T | 25% |

---

# Final Test Cases

The project contains **21 unique test cases**.

Repeated inputs are not duplicated when the same test case is useful for multiple testing techniques.

| ID | Technique | Weight | EV | Carpool | Expected Result |
|---|---|---:|:---:|:---:|---|
| TC01 | EP / DT | 0 | F | F | Exception |
| TC02 | BVA | -1 | F | F | Exception |
| TC03 | BVA | 1 | F | F | 0% |
| TC04 | EP / DT | 600 | F | F | 0% |
| TC05 | DT | 600 | T | F | 0% |
| TC06 | DT | 600 | F | T | 0% |
| TC07 | DT | 600 | T | T | 0% |
| TC08 | BVA | 1199 | F | F | 0% |
| TC09 | BVA | 1200 | T | T | 0% |
| TC10 | BVA | 1201 | F | F | 0% |
| TC11 | EP / DT | 2000 | F | F | 0% |
| TC12 | DT | 2000 | T | F | 10% |
| TC13 | DT | 2000 | F | T | 10% |
| TC14 | EP / DT | 2000 | T | T | 15% |
| TC15 | BVA | 3499 | T | T | 15% |
| TC16 | BVA | 3500 | T | T | 15% |
| TC17 | BVA | 3501 | T | T | 25% |
| TC18 | EP / DT | 4000 | F | F | 5% |
| TC19 | DT | 4000 | T | F | 5% |
| TC20 | DT | 4000 | F | T | 5% |
| TC21 | EP / DT | 4000 | T | T | 25% |

---

# Hypothetical Faults

The assignment also demonstrates why different testing techniques are useful.

**Important:** Code Coverage and Branch Coverage are demonstrated through hypothetical faults rather than additional test cases.

## Fault 1 — Equivalence Partitioning

Changed:

```java
if (weight <= 0)
```

to:

```java
if (weight < 0)
```

The EP test for `weight = 0` detects the fault.

**Result:** EP catches Fault 1.

---

## Fault 2 — Boundary Value Analysis

Changed:

```java
if (weight > 1200 && weight <= 3500)
```

to:

```java
if (weight >= 1200 && weight <= 3500)
```

The representative EP values do not include exactly 1200, but the BVA test at 1200 detects the fault.

**Result:** EP misses Fault 2; BVA catches Fault 2.

---

## Fault 3 — Decision Table

Changed:

```java
else if (isEV || isCarpool)
```

to:

```java
else if (isEV && isCarpool)
```

The EV-only and carpool-only combinations in the Decision Table detect the incorrect behavior.

**Result:** EP and BVA miss Fault 3; Decision Table catches Fault 3.

---

## Fault 4 — Code Coverage

A hypothetical statement is added:

```java
if (weight == 5000) {
    discountPercent = 0.20;
}
```

None of the existing 21 test cases uses a weight of 5000, so the statement remains unexecuted.

**Result:** Code Coverage identifies the unexecuted statement.

No additional test case is added for Code Coverage.

---

## Fault 5 — Branch Coverage

The Tier-3 condition is hypothetically changed from:

```java
if (isEV && isCarpool)
```

to:

```java
if (isEV || isCarpool)
```

This changes the decision behavior for EV-only and carpool-only vehicles.

**Result:** Branch Coverage demonstrates the importance of exercising the alternative outcomes of the decision.

No additional Branch Coverage test case is added.

---

# JUnit 5

The project uses JUnit 5 for automated testing.

The JUnit dependency is defined in `pom.xml`:

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.13.4</version>
    <scope>test</scope>
</dependency>
```

Tests use:

```java
@Test
```

for test methods and:

```java
assertEquals()
```

for expected results.

For invalid weights, the tests use:

```java
assertThrows()
```

to verify that the required exception is generated.

---

# Expected Final Result

With the original, correct `TollCalculator.java` implementation:

```text
21 tests
0 failures
0 errors
```

The project should finish with:

```text
BUILD SUCCESS
```

The five hypothetical faults are documented separately and should **not remain in the final production implementation**.

---

# Author

**Muhammad Basit**

Master of Science in Computer Science  
University of Central Arkansas

