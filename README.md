# **Selenium-WebDriver**
## **Introduction & Why selenium?**
***
>Selenium WebDriver, a programming interface developed by Simon Stewart in 2006.

>Support all major 3 plateform (os) Window , Mac & linux.

>Support all top browser:- Chrome, MSEdge, FireFox, Safari.

>[Free] Support all major Top programming language:- Java, Javascriot, Python ,C#, Ruby

>[Free] Eclipse IDE to Develop test case.

>[Free] Support Jenkin as CI-CD tools.

>[Free] Maven build management tool.

>[Free] Git {Version control tool} & gitHub {free cloud host repositories enabling collaboration}

>[Free] TestNG framework.

>[Free] Support So many Plugins. anybody will be amazed with the variety of flavor of plugins.

>[Free] Html report by maven, testng, Extent report, and allure report.
***

## Download, Install and Setup.
#### Eclipse IDE Download 
>https://www.eclipse.org/downloads/packages/
#### Install TestNG in Eclipse  
>Help >> Eclipse Market place >> search >> testng >> Install.

#### Install Java
>Download Java JDK: https://www.oracle.com/java/technologies/downloads/#jdk21-windows
```
1. Install next .... finished
2. Setting JAVA_HOME:
3. R-click on "This PC" and select "Properties" >> Advanced system settings >> Environment Variables.
4. System Variable >> new >> Variable name = JAVA_HOME & Variable value = C:\Program Files\Java\jdk-21 >> OK
5. System variable >> path >> edit >> new >>  C:\Program Files\Java\jdk-21\bin >> OK
6. Command Prompt : java --version >> will display Java Version.
```
#### Install Apache Maven
> Download Apache maven: https://maven.apache.org/download.cgi
```
1. Install next .... finished
2. Setting MAVEN_HOME:
3. R-click on "This PC" and select "Properties" >> Advanced system settings >> Environment Variables.
4. User Variable >> new >> Variable name = MAVEN_HOME & Variable value = C:\Program Files\apache-maven-3.9.9 >> OK
5. System variable >> path >> edit >> new >>  C:\Program Files\apache-maven-3.9.9\bin
6. Command Prompt : mvn -v >> will display Maven Version.

```
#### For the pom.xml dependencies
> https://mvnrepository.com/

## Naming conventions for Selenium identifiers
```
+----------+----------------------------+--------+-----------------+
| Category |      UI/Control type       | Prefix |     Example     |
+----------+----------------------------+--------+-----------------+
| Basic    | Button                     | btn    | btnExit         |
| Basic    | Text box                   | txt    | txtLastName     |
| Basic    | Check box                  | chk    | chkReadOnly     |
| Basic    | Radio button / group       | rad    | radGender       |
| Basic    | Label                      | lbl    | lblHelpMessage  |
| Basic    | Date picker                | dtp    | dtpPublished    |
| Basic    | Links/Anchor Tags          | lnk    | lnkForgotPwd    |
| Basic    | Combo box                  | cbo    | cboEnglish      |
| Basic    | Menu                       | mnu    | mnuFileOpen     |
| Basic    | Sub Menu                   | sbmnu  | mnuFileOpen     |
| Basic    | Dropdown List / Select tag | ddl    | ddlCountry      |
| Basic    | Table                      | tbl    | tblCustomer     |
| Basic    | Form                       | frm    | frmEntry        |
| Basic    | Frame                      | fra    | fraLanguage     |
| Basic    | Image                      | img    | imgIcon         |
| Basic    | Common dialog              | dlg    | dlgFileOpen     |
| Basic    | List box                   | lst    | lstPolicyCodes  |
| Basic    | RichTextBox                | rtf    | rtfReport       |
| Basic    | TabStrip                   | tab    | tabOptions      |
| Basic    | Text Area                  | txa    | txaDescription  |
| Complex  | Spinner                    | spn    | spnPages        |
| Complex  | Chevron                    | chv    | chvProtocol     |
| Complex  | Data grid                  | dgd    | dgdTitles       |
| Complex  | Data list                  | dbl    | dblPublisher    |
| Complex  | Directory list box         | dir    | dirSource       |
| Complex  | Drive list box             | drv    | drvTarget       |
| Complex  | File list box              | fil    | filSource       |
| Complex  | Panel/Fieldset             | pnl    | pnlGroup        |
| Complex  | ProgressBar                | prg    | prgLoadFile     |
| Complex  | Slider                     | sld    | sldScale        |
| Complex  | StatusBar                  | sta    | staDateTime     |
| Complex  | Timer                      | tmr    | tmrAlarm        |
| Complex  | Toolbar                    | tlb    | tlbActions      |
| Complex  | TreeView                   | tre    | treOrganization |
+----------+----------------------------+--------+-----------------+
```
# Folder Structure
```
src/main/java
├── com.qa.utils
    └── Base.java
    └── CommonUtils.java
    └── ExcelUtils.java
    └── ExtendReportManager.java
    └── SeleniumUtils.java
    └── PdfReader.java
    └── log4j2.xml


src/test/java
├── tests
    └── LoginTest.java
├── pages
    └── LoginPage.java

Configurations
├── Config.properties

Data
├── TestData.json

Include
├── UploadFile.pdf, UploadFile.png, UploadFile.csv...
├── SelectorHub.crx (browser extension)
├── AutoIt

Logs
├── execution.logs

reports
├── extendReport.html

Screenshots
├── assertDemo0313_Failed_183355.png

target (Maven Report)
├── surefire-reports
    └──index.html

test-output(Testng Report)
├── index.html

Test Suites
├──TS_app_smoke.xml
├──TS_app_Regression.xml

README.md
```

# Selenium Java Framework Architecture Overview

This project is a structured Maven-based Selenium Java framework following a layered architecture for better modularity, scalability, and maintainability.

---

## ✅ 1. Directory Structure and Components

### 🔹 **src/main/java** – Contains main framework code (Core framework logic)
| Directory/File | Description |
|---------------|-------------|
| **com.qa.utils** | Stores utility and helper classes |
| `Base.java` | Base class for initializing WebDriver, managing browser setup, and teardown |
| `CommonUtils.java` | Reusable methods like wait handling, data formatting, etc. |
| `ExcelUtils.java` | Handles reading/writing data from Excel files |
| `ExtendReportManager.java` | Manages Extent Report generation for test execution |
| `SeleniumUtils.java` | Utility methods for handling Selenium operations (e.g., handling alerts, frames, windows) |
| `PdfReader.java` | Handles PDF file reading and verification |
| `log4j2.xml` | Log configuration file for logging using Log4j |

---

### 🔹 **src/test/java** – Contains test cases and Page Object classes
| Directory/File | Description |
|---------------|-------------|
| **tests** | Stores actual test cases |
| `LoginTest.java` | Test class for login functionality |
| **pages** | Stores Page Object classes |
| `LoginPage.java` | Page class using Page Object Model (POM) for login |

---

### 🔹 **Configurations** – Contains framework configuration files
| File | Description |
|------|-------------|
| `Config.properties` | Stores global configuration (e.g., browser type, URL, timeout) |

---

### 🔹 **Data** – Stores test data
| File | Description |
|------|-------------|
| `TestData.json` | Stores structured test data in JSON format |

---

### 🔹 **Include** – Stores external dependencies
| File | Description |
|------|-------------|
| `UploadFile.pdf, UploadFile.png, UploadFile.csv` | Test files for file upload scenarios |
| `SelectorHub.crx` | Browser extension for element inspection |
| `AutoIt` | Scripts for handling Windows-based popups |

---

### 🔹 **Logs** – Contains execution logs
| File | Description |
|------|-------------|
| `execution.logs` | Logs generated during test execution |

---

### 🔹 **Reports** – Stores test execution reports
| File | Description |
|------|-------------|
| `extendReport.html` | Extent Report file with test summary and results |

---

### 🔹 **Screenshots** – Contains screenshots of test execution
| File | Description |
|------|-------------|
| `assertDemo0313_Failed_183355.png` | Screenshot of failed test for debugging |

---

### 🔹 **target** – Stores compiled files and Maven reports
| Directory/File | Description |
|---------------|-------------|
| `surefire-reports/index.html` | Test execution report generated by Maven Surefire Plugin |

---

### 🔹 **test-output** – Stores TestNG-generated reports
| File | Description |
|------|-------------|
| `index.html` | TestNG report with execution summary |

---

### 🔹 **Test Suites** – Contains test suite files for TestNG execution
| File | Description |
|------|-------------|
| `TS_app_smoke.xml` | TestNG suite file for smoke tests |
| `TS_app_Regression.xml` | TestNG suite file for regression tests |

---

## ✅ 2. Framework Workflow
1. **Test Execution**  
   - TestNG reads the test suite file (`TS_app_smoke.xml` or `TS_app_Regression.xml`).  
   - Initializes WebDriver using `Base.java`.  

2. **Page Object Handling**  
   - `LoginTest.java` calls `LoginPage.java` methods.  
   - `LoginPage.java` uses locators and actions to interact with web elements.  

3. **Utilities and Configuration**  
   - `Config.properties` provides browser type, URL, and other environment settings.  
   - `CommonUtils`, `SeleniumUtils`, and `ExcelUtils` provide helper methods.  

4. **Data Handling**  
   - Test data is fetched from `TestData.json` or `ExcelUtils.java`.  

5. **Assertions and Reporting**  
   - Assert statements validate expected vs actual results.  
   - `ExtendReportManager.java` generates Extent Reports.  
   - Screenshots are captured for failed cases.  

6. **Logging**  
   - Logs are generated using `log4j2.xml`.  

7. **Teardown**  
   - Browser session is closed using `Base.java` cleanup methods.  

---

## ✅ 3. Design Patterns Used
| Pattern | Description |
|---------|-------------|
| **Page Object Model (POM)** | Separates UI element locators and actions from test cases |
| **Singleton Pattern** | Ensures a single instance of WebDriver |
| **Data-Driven Testing** | Fetches test data from JSON, Excel, or CSV files |
| **Factory Pattern** | Creates objects for WebDriver initialization |
| **Decorator Pattern** | Enhances Selenium functions (like waits, screenshots) |

---

## 🔥 **Summary**
✅ Follows layered architecture for better maintainability  
✅ Implements Page Object Model for clean separation of concerns  
✅ Supports data-driven testing using JSON and Excel  
✅ Provides logging and reporting with Log4j and Extent Reports  
✅ Enables parallel and cross-browser testing using TestNG and Maven  

---

### 🚀 **How to Execute**
1. Clone the repository.  
2. Configure `Config.properties` with the correct browser, URL, and timeout.  
3. Use `mvn clean test` to execute test cases.  
4. View reports in `target/surefire-reports/index.html` or `reports/extendReport.html` or `allure-results using command -- [allure serve allure-results]`.

---

### 👨‍💻 **Author**
[Bijaya Chhetri] – Automation Engineer  

---

### ✅ **License**
This project is licensed under the MIT License.




## This Demo Project cover Selenium Webdriver 3 and upto Selenium webdriver version 4.29
1. Basic selenium webdriver actions.
2. Read PDF Files using pdfbox 
```
    <dependency>
		<groupId>org.apache.pdfbox</groupId>
		<artifactId>pdfbox</artifactId>
		<version>2.0.21</version>
    </dependency> 
```
3. TestNG framework demo test case which cover all the aspect of the testNG.
4. Core java basic course.
5. ChromeOptions class methods demo Test cases.
6. ChromeDevTools demo Test cases.
7. Chrome Browser mobile emulator testing.
8. Datadriven Testing using
    * JSON File
    * Excel File
    * Properties File
    * Mysql Database
9. File Upload demo test case using:
    * Robert class &
    * AutoIT
10. Headless WebBrowser testing using:-
    * HtmlUnit Driver
    * ChromeDriver & FireFox
    * PhantomJsDriver
11. Log4j (Logging framework) Demo test cases.
```
    <dependency>
		<groupId>org.apache.logging.log4j</groupId>
		<artifactId>log4j-api</artifactId>
		<version>2.11.1</version>
	</dependency>
	<dependency>
		<groupId>org.apache.logging.log4j</groupId>
		<artifactId>log4j-core</artifactId>
		<version>2.11.1</version>
	</dependency>
```
12. Demo test case for page object model Design pattern in 2 different ways. 
    
    * Page factory design pattern with _@FindBy_ annoatation.
    * page object model
13. Singleton Test case Design Pattern demo.
14. Demo test case to Handle **Shadow Dom**.
15. Find Broken Links Using Selenium WebDriver
16. Relative or friendly locator.

```
    <dependency>
		<groupId>io.github.sukgu</groupId>
		<artifactId>automation</artifactId>
		<version>0.1.0</version>
    </dependency>
```


## How to run test suite

```
1. Open terminal go to project path & run this command:
	A. command is = mvn clean test -DtestngFile=RunPackages.xml
	B. Make sure you have this inside the pom.xml file
	C. If the testsuite.xml file are in root directory the Just this is fine = ${testngFile}
	D. And in the pom.xml for test change 
	<scope>test</scope> to <scope>compile</scope> so that it will run from CMD.
	
	<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.0</version>
				<configuration>
					<source>1.8</source>
					<target>1.8</target>
				</configuration>
			</plugin>
			
			<plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>2.22.0</version>
            <configuration>
               <suiteXmlFiles>
               <suiteXmlFile>./Test Suites/${testngFile}</suiteXmlFile>
               </suiteXmlFiles>
            </configuration>
        </plugin>
		</plugins>
	</build>

```
15. Parallel execution demo test case Test Suites/Parallel..*.


