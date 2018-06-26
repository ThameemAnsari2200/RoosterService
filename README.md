# Rooster Service Spring Boot Web Application
This repository has the project files for a Rooster service assessment

In this part, I would like to demonstrate how a rooster sounds depending on language using Java 8, Spring-rest-api, Ajax, Thymeleaf templates, MockMVC and ExtentReport as a part of test reports.

Instructions on how to use

1. Download and open the project in eclipse. (Import--> Maven--> Existing Maven Project)
2. Locate the pom.xml of the project.
3. Select the project, Right Click--> Run As-->Maven Test (This will do a test run of MockMvc). Kindly proceed even if you have build failure since it happens if we have any test case failure, however test reports will show detailed information on the failed cases.
4. You can find the updated test reports on src/test/resources/test-reports/TestReport.html. I have added two cases to show case the test report

     a. Pass case - > How a rooster sounds in Tamil native
     
     b. Fail case -> How a rooster sounds in French native 
     
5. For failed cases the test reports will show reason for failure with the expect and actual values. You can also navigate on the test reports links to get more infomation.
6. Once you run the application Right Click--> Run As-->Run as Spring Boot App you can access using http://localhost:8080
7. The Interface will have a drop down and on select a particular language, it will display the corresponding rooster sound.
8. Added a new language of Tamil and how rooster sounds in the same language.
