<div align="center">

# 🚀 Edureka Automation Testing Framework

### BDD test automation framework built with Selenium 4, Cucumber 7 & TestNG

[![Java](https://img.shields.io/badge/Java-17%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com)
[![Selenium](https://img.shields.io/badge/Selenium-4.38.0-43B02A?style=for-the-badge&logo=selenium&logoColor=white)](https://www.selenium.dev)
[![Cucumber](https://img.shields.io/badge/Cucumber-7.28.2-23D96C?style=for-the-badge&logo=cucumber&logoColor=white)](https://cucumber.io)
[![TestNG](https://img.shields.io/badge/TestNG-Latest-FF6600?style=for-the-badge)](https://testng.org)
[![Maven](https://img.shields.io/badge/Maven-3.x-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)](https://maven.apache.org)

<br/>

> **Automate. Validate. Ship with Confidence.**  
> End-to-end UI test automation for the Edureka learning portal — written in plain English,  
> powered by Selenium.

</div>

---

## 📑 Table of Contents

- [About the Project](#-about-the-project)
- [Tech Stack](#-tech-stack)
- [Framework Architecture](#-framework-architecture)
- [Project Structure](#-project-structure)
- [Prerequisites](#-prerequisites)
- [Getting Started](#-getting-started)
- [Running Tests](#-running-tests)
- [Test Reports](#-test-reports)
- [Configuration](#-configuration)
- [Design Patterns](#-design-patterns)
- [Author](#-author)

---

## 📌 About the Project

This framework automates end-to-end UI testing for the **Edureka e-learning portal** (`https://www.edureka.co`) using a **Behaviour-Driven Development (BDD)** approach. Test scenarios are written in plain English using **Gherkin syntax**, making them readable by developers, testers, and non-technical stakeholders alike.

### Key Highlights

| Feature | Detail |
|---|---|
| **BDD Approach** | Gherkin feature files — readable by all stakeholders |
| **Page Object Model** | Clean separation of locators and test logic |
| **Data-Driven Testing** | External test data via Apache POI (Excel `.xlsx`) |
| **Dependency Injection** | PicoContainer for shared state across step definitions |
| **Rich Reporting** | ExtentReports 5 — HTML dashboards with screenshots on failure |
| **CI/CD Ready** | Maven Surefire plugin with `testng.xml` suite configuration |

---

## 🛠 Tech Stack

| Layer | Technology | Version |
|---|---|---|
| Language | Java | 17+ |
| Browser Automation | Selenium WebDriver | 4.38.0 |
| BDD Framework | Cucumber (Core + Java + TestNG) | 7.28.2 |
| Test Runner | TestNG via `cucumber-testng` | 7.28.2 |
| Dependency Injection | Cucumber PicoContainer | 7.28.2 |
| Data Handling | Apache POI (OOXML) | 5.4.1 |
| Reporting | ExtentReports | 5.1.2 |
| Build Tool | Apache Maven | 3.x |
| IDE | Eclipse / IntelliJ IDEA | — |

---

## 🏗 Framework Architecture

```
┌──────────────────────────────────────────────────────────┐
│                    TestNG Runner                         │
│              testng.xml + @CucumberOptions               │
└──────────────────────┬───────────────────────────────────┘
                       │ triggers
          ┌────────────┴─────────────┐
          ▼                          ▼
┌─────────────────┐       ┌───────────────────────┐
│  Feature Files  │◄─────►│   Step Definitions    │
│  (Gherkin BDD)  │  glue │  (@Given @When @Then) │
└─────────────────┘       └──────────┬────────────┘
                                     │ calls
                          ┌──────────▼─────────────┐
                          │    Page Objects (POM)  │
                          │  Locators + UI Actions │
                          └──────────┬─────────────┘
                                     │ extends
                    ┌────────────────▼────────────────────┐
                    │            Base Class               │
                    │  Driver init · Waits · Teardown     │
                    └──────────┬────────────────┬─────────┘
                               │                │ uses
                   ┌───────────▼───┐   ┌────────▼───────────┐
                   │  Utilities    │   │  External Sources  │
                   │  Screenshots  │   │  Excel · Config    │
                   │  Config Reader│   │  .properties files │
                   └───────────────┘   └────────────────────┘
                               │
                    ┌──────────▼──────────┐
                    │      Reports        │
                    │    ExtentReports    │
                    │  TestNG test-output │
                    └─────────────────────┘
```

---

## 📁 Project Structure

```
Edureka_Automation_Testing/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/edureka/
│   │           ├── com.edureka.pages/             # Page Object classes (POM)
│   │           └── com.edureka.utility/           # Utilities — Excel reader, screenshots, config, Extent Report
│   │
│   └── test/
│       ├─── java/
│       │   └── com/edureka/
│       │       ├── com.edureka.testRunner/                 # TestRunner.java (@CucumberOptions)
│       │       ├── com.edureka.stepDefinition/             # Step Definition classes
│       │       └── com.edureka.featureFile/                # .feature files (Gherkin scenarios)
│       └─── resources/
│           └── edureka.propertires                         # Properties file 
│           └── edureka.xlsx                                # Excel files for data-driven testing
│
├── test-output/                       # TestNG generated HTML & XML reports
├── testng.xml                         # TestNG suite configuration
├── pom.xml                            # Maven dependencies & build config
└── README.md
```

---

## ✅ Prerequisites

Ensure the following are installed before running the framework:

- **Java JDK** 17 or higher
- **IDE** Eclipse / IntelliJ

---

## 🚀 Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/Sanjai451/Edureka_Automation_Testing.git
cd Edureka_Automation_Testing
```

### 2. Install dependencies

```bash
mvn clean install -DskipTests
```

---

## ▶ Running Tests

### Run the full test suite (via Maven)

```bash
mvn clean test
```

### Run using a specific TestNG suite

```bash
mvn test -DsuiteXmlFile=testng.xml
```

### Run a specific feature file

```bash
mvn test -Dcucumber.filter.tags="@smoke"
```

### Run by tag

```bash
# Run only smoke tests
mvn test -Dcucumber.filter.tags="@smoke"

# Run only regression tests
mvn test -Dcucumber.filter.tags="@regression"

# Exclude a tag
mvn test -Dcucumber.filter.tags="not @wip"
```
---

## 📊 Test Reports

After execution, reports are generated in two locations:

### ExtentReports 
```
target/ExtentReports.html
```
Open in any browser. Includes:
- Pass / Fail / Skip summary
- Step-level details with timestamps
- Automatic screenshots on failure
- Environment metadata

### TestNG Default Report
```
test-output/index.html
test-output/emailable-report.html
```

### Cucumber Report 
```
target/cucumber-report.html
```

---

## 🧩 Modules Covered

This framework covers **12 functional modules** of the [Edureka](https://www.edureka.co) e-learning portal,
organised into **4 domain groups** with a total of **40+ automated scenarios** across positive, negative, and edge cases.

---

### 🗂️ Module Overview

| # | Module | Domain | Scenarios |
|---|---|---|---|
| 1 | Authentication | 🔐 User Access | Login, Logout, Registration |
| 2 | Profile | 🔐 User Access | View, Edit, Avatar |
| 3 | Home Page | 🌐 Discovery | Banner, Navigation, Search |
| 4 | All Courses | 🌐 Discovery | Browse, Filter, Sort |
| 5 | Search & Filter | 🌐 Discovery | Keyword, Category, Price |
| 6 | Blogs | 📝 Content | List, Read, Category filter |
| 7 | Webinar | 📝 Content | List, Register, Details |
| 8 | Community | 📝 Content | Feed, Post, Interaction |
| 9 | Become an Instructor | 🎓 Instructor | Apply, Form validation |
| 10 | Become a Partner | 🎓 Instructor | Apply, Form validation |
| 11 | Post a Job | 💼 Career | Create, Validate, Submit |
| 12 | Corporate Training | 💼 Career | Enquiry, Form, Validation |

---

### 🔐 User Access

<details>
<summary><strong>1 · Authentication</strong></summary>

<br/>

> Covers the complete entry and exit lifecycle of a user on the Edureka platform.


</details>

---

<details>
<summary><strong>2 · Profile</strong></summary>

<br/>

> Validates that a logged-in user can view and manage their personal profile information.


</details>

---

### 🌐 Discovery

<details>
<summary><strong>3 · Home Page</strong></summary>

<br/>

> Validates the landing experience and primary navigation paths a user encounters on first visit.


</details>

---

<details>
<summary><strong>4 · All Courses</strong></summary>

<br/>

> Validates the course listing page — the primary conversion surface of the Edureka platform.


</details>

---

<details>
<summary><strong>5 · Search & Filter</strong></summary>

<br/>

> Validates the platform's global search capability and multi-filter combinations.


</details>

---

### 📝 Content

<details>
<summary><strong>6 · Blogs</strong></summary>

<br/>

> Validates the Edureka blog portal.


</details>

---

<details>
<summary><strong>7 · Webinar</strong></summary>

<br/>

> Validates the webinar discovery and registration flow.


</details>

---

<details>
<summary><strong>8 · Community</strong></summary>

<br/>

> Validates the Edureka community forum — where learners interact and post questions.


</details>

---

### 🎓 Instructor

<details>
<summary><strong>9 · Become an Instructor</strong></summary>

<br/>

> Validates the instructor application flow.


</details>

---

<details>
<summary><strong>10 · Become a Partner</strong></summary>

<br/>

> Validates the partner application flow .


</details>

---

### 💼 Career

<details>
<summary><strong>11 · Post a Job</strong></summary>

<br/>

> Validates the job posting feature — allowing companies to list positions on the Edureka platform.


</details>

---

<details>
<summary><strong>12 · Corporate Training</strong></summary>

<br/>

> Validates the B2B corporate training enquiry form.


</details>

---

### 📊 Test Coverage Summary

```
Total Modules        : 12
Domain Groups        : 4  (User Access · Discovery · Content · Career & Instructor)
Total Scenarios      : 55+
Positive Scenarios   : 35+
```


---

## ⚙ Configuration

All environment-specific values are externalised. Edit `src/test/resources/edureka.properties`:

```properties
# Application URL
url=https://www.edureka.co

# Credentials
username=your_email
password=your_password

# Browser (chrome | firefox | edge)
broswer=edge

# Timeouts (in seconds)
implicitTime=10

```

---

## 🎨 Design Patterns

### Page Object Model (POM)
Each page of the application is represented as a Java class. Locators and user actions are encapsulated within the page class, keeping step definitions clean and free of Selenium code.

### Behaviour-Driven Development (BDD)
Test scenarios live in `.feature` files written in Gherkin. This creates a single source of truth that developers, testers, and business analysts can all understand.

### Dependency Injection via PicoContainer
`cucumber-picocontainer` enables shared state between step definition classes without static variables, ensuring thread-safety and clean test isolation.

### Data-Driven Testing via Apache POI
Test data is read from external Excel (`.xlsx`) files at runtime. Adding new test data requires zero code changes.

---

## 👤 Authors

**Sanjai Kumar R**

[![GitHub](https://img.shields.io/badge/GitHub-Sanjai451-181717?style=flat&logo=github)](https://github.com/sanjai451)

**Ramana K S**

[![GitHub](https://img.shields.io/badge/GitHub-RamanaKS-181717?style=flat&logo=github)](https://github.com/RamanaKS)

**Sathyasreee**

[![GitHub](https://img.shields.io/badge/GitHub-Sathyasreee07-181717?style=flat&logo=github)](https://github.com/Sathyasreee07)

**Jaysree**

[![GitHub](https://img.shields.io/badge/GitHub-jaysree11-181717?style=flat&logo=github)](https://github.com/jaysree11)

**Madheswari G B**

[![GitHub](https://img.shields.io/badge/GitHub-MadheswariGB-181717?style=flat&logo=github)](https://github.com/MadheswariGB)


---
