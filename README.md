# Automated tests for Jetbrains.com
[Jetbrains.com](https://www.jetbrains.com/) is official website of Jetbrains company which provides tools for software developers and teams. Automated tests were developed as part of a training project.  


## Tools and technologies

![This is an image](icons/Java.png)![This is an image](icons/Gradle.png)![This is an image](icons/Intelij_IDEA.png)![This is an image](icons/Selenide.png)![This is an image](icons/Selenoid.png)![This is an image](icons/JUnit5.png)![This is an image](icons/Rest-Assured.png)![This is an image](icons/Github.png)![This is an image](icons/Jenkins.png)![This is an image](icons/Allure_Report.png)![This is an image](icons/AllureTestOps.png)![This is an image](icons/Telegram.png)![This is an image](icons/Jira.png)


## What's interesting?
* ```PageObject```
* Part of UI tests was decomposed with API tests
* Parametrized build
* Parametrized tests
* Configuration with ```Owner``` library
* Allure TestOps integration
* Jira integration
* Telegram notifications

## Test-cases
- [x] Login as user
- [x] Logout
- [x] Going to password recovery page
- [x] Checking tabs on the main page
- [x] Checking the selected chip in filter tags
- [x] Checking tabs in profile menu

## How to run :runner:
Local run with default properties (example for PowerShell):

```$env:USERNAME="<your jetbrains login>";$env:PASSWORD="<your jetbrains password>"```

```gradle clean test```

Remote run (Jenkins):


