# **Selenium-WebDriver-3**
## **Introduction & Why selenium?**
***
>Developed in 2004

>Open source & absolutely free.

>Huge community support. Nobody will never stuck there is always a solution.

>Support all major 3 plateform Window , Mac & linux.

>Support all major Top programming language:- Java, Javascriot, Python ,C#, Ruby

>Support all top browser:- Chrome, MSEdge, FireFox, Safari, IE, Opera

>Eclipse free Tool as IDE to Develop test case which is also Free.

>Server start not required.

>Support Jenkin as CI CD tools which is free too.

>What else we need we can use Apache Maven Project with TestNG framework.

>Last but no least it support So many Plugins. any body will be amazed with the variety of flavor of plugins which are also free.
***

## Maven LIfecycle
1. validate
2. compile
3. test
4. package
5. integration test
6. verify
7. install - install in local rep
8. deploy - install in remote rep to use by other project

This source code will provide all the demo test case using maven project for selenium webdriver 3 and 4.
Other demo test case are:-

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

# **Selenium-WebDriver-4**

1. How to take WebElement screenshot.
2. How to take screenshot of a group of WebElement.
3. GetRect Method.
4. Open new blank Tab.
5. ChromeDevtools demo.
6. Relative or friendly locator.

## Why should you check Broken Links?
1. Broken links are a big turn-off for the visitors who land on your website. 
2. Broken Links can hurt the user experience.
3. Removal of broken (or dead) links is essential for SEO (Search Engine Optimization), as it can affect the site’s rankings on search engines (e.g., Google).
4. Broken links testing can be done using Selenium WebDriver on a web page, which in turn can be used to remove the site’s dead links.

### How to Find Broken Links Using Selenium WebDriver?
1. Use the < a > tag to collect details of all the links present on the webpage.
2. Send an HTTP request for every link.
3. Verify the corresponding response code received in response to the request sent in the previous step.
4. Validate whether the link is broken or not based on the response code sent by the server.
5. Repeat steps (2-4) for every link present on the page.