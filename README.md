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

>[Free] Git {Version control tool} & gitHib {free cloud host repositories enabling collaboration}

>[Free] TestNG framework.

>[Free] Support So many Plugins. any body will be amazed with the variety of flavor of plugins.
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
5. System variable >> path >> edit >> new >>  C:\Program Files\apache-maven-3.9.9\bin >> OK
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
15. Parallel execution demo test case in two different flavor.

# For Report
> TestNG Report 

> Maven Report

> Allure Report

> Extent Report

