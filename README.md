🚀Opencart_Administration_V1.0_Cucumber_Java (BDD Cucumber Automation Framework )


🔍 Overview
This framework leverages the power of Behavior-Driven Development (BDD) using Cucumber and Selenium WebDriver with Java, following the principles of clean code, reusability, and extensibility.

It supports:

Hybrid-driven architecture (Data + Keyword + BDD)

Cross-browser execution

Parallel execution via TestNG

Detailed reporting (ExtentReports)

🛠️ Tech Stack
Technology	Version
Java	11+
Maven	3.6+
Selenium	4.x
Cucumber	7.x
TestNG	7.x
ExtentReports	5.x
Jenkins	(Optional)
GIT and GITHUB

📦 Project Structure
bash
Copy
Edit
├── src
│   ├── main/java
│   │   └── (Core utilities, drivers, base classes)
│   ├── test/java
│   │   ├── stepDefinitions
│   │   ├── runners
│   │   ├── pages
│   │   └── utils
│   └── resources
│       ├── features
│       └── config.properties
├── pom.xml
└── extent-config.xml
🧩 Key Features
🔗 BDD with Cucumber: Write test scenarios in simple Gherkin syntax.

🧪 TestNG Integration: Control execution flow and parallelism.

🌐 Selenium WebDriver: Automate browser interactions.

📊 ExtentReports: Interactive, visual, and customizable test reports.

🔄 Reusable Page Object Model (POM): Maintainable and scalable design pattern.

⚙️ Config-driven execution: Switch environments and browsers via property files.

🤖 CI/CD Ready: Seamless Jenkins integration.

🚀 How to Run
1. Pre-requisites
Install Java 11+, Maven, and a modern IDE (like IntelliJ IDEA / Eclipse).

Chrome / Edge browsers.

2. Run via Maven
nginx
Copy
Edit
mvn clean install
3. Run Specific Tags
nginx
Copy
Edit
mvn test -Dcucumber.filter.tags="@Smoke"
📝 Sample Feature File (Gherkin)
gherkin
Copy
Edit
Feature: Login Functionality

  @Smoke @Regression
  Scenario: Valid Login
    Given User is on the Login page
    When User enters valid credentials
    Then User is redirected to the Dashboard
📊 Reporting
All execution reports will be available under:

bash
Copy
Edit
/test-output/ExtentReports/ExtentReport.html
Fully customizable via extent-config.xml.

🏗️ Framework Design Principles
Hybrid-Driven: Combination of Data-Driven + Keyword + BDD.

Single Responsibility: Every class has a clear purpose.

Loose Coupling: Minimized dependency across components.

Scalability First: Easy to extend with new modules.

🔗 CI/CD Integration (Optional)
This framework is designed for Jenkins pipelines with easy parameterization to run smoke/regression suites on-demand or via scheduled triggers.

🤝 Contributing
Fork this repo.

Create your feature branch (git checkout -b feature/AmazingFeature).

Commit changes (git commit -m 'Add amazing feature').

Push to the branch (git push origin feature/AmazingFeature).

Create a pull request.

📬 Contact & Support
For any queries, feel free to reach out:
📧 madhukar19996@gmail.com

##Screenshots:

![Cucumber_Report](https://github.com/user-attachments/assets/b926d20c-ff69-4752-90fd-9302d39721c3)

![Jenkins2](https://github.com/user-attachments/assets/581dcfe8-5333-4078-bd6b-6195416313de)
b89)


![Cucumber_report2](https://github.com/user-attachments/assets/15c9618f-70f6-467d-b930-69a95ee1b121)



⚠️ Disclaimer
This is a sample automation framework built for educational and professional development purposes.
