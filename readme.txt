======================================
AppDirect Selenium Automated Test Exam
======================================

Suggested system requirements:
=============================
- Chrome Browser Version 65
- Apache Maven 3.3.9
- Java version: 1.8
- Intellij 2017.2

Project Structure:
=================
-base:
	-BasePage: base page class
	-BaseTestSetup: base test setup class
-pages (BasePage subclasses):
	-ActivateAccountPage
	-HomePage
	-LandingPage
	-LoginPage
	-MailPage
	-SignUpPage
	-ThanksPage
-tests (BaseTestSetup subclasses):
	-SignUpTests
-resources:
	-chromedriver (latest chrome driver version up to date)
	-log4testng.properties (testng logger config)
	
"How to run" instructions:
=========================
a). From command line (simply run):
	./run_test.sh	
	
b). From IDE (Intellij suggested):
	1). Right click on test/SignUpTests
	2). Select 'Run SignUpTests'
	
	Intellij project structure setup:
		-Source        : ./seleniumtests/src
		-Tests         : ./seleniumtests/src/test
		-Test Resources: ./seleniumtests/src/test/resources

A brief explanation about SignUpTests class:
It contains 4 basic "@Test" methods, they will run in sequence when the class is invoked:

1). signUpTest: create a Mailinator email account and perform sign up
              "Assert that the thanks/confirmation page is displayed"

2). activateAccountTest: activate the account created on [signUpTest]
                       "Assert: the flow reaches the Home Page after activation"
                       "Assert: logout is performed correctly"

3). failLoginTest: with the account activated on [activateAccountTest] send a wrong password
                 "Assert: wrong user name/pass is displayed when sending wrong password"

4). successfulLoginTest: with the account activated on [activateAccountTest]
                       "Assert: login and logout are performed correctly"