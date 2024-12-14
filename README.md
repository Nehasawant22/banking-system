# **banking-system Backend Application**
End-to-end implementation of web application by using java, Spring Boot, Microservices
### References:
- https://spring.io/guides/gs/spring-boot

### Working with banking system in your IDE
**Prerequisites :**

The following items should be installed in your system:
- Java 17 or newer (full JDK, not a JRE)
- Git command line tool
-	Your preferred IDE
-	Eclipse with the m2e plugin. Note: when m2e is available, there is an m2 icon in Help -> About dialog. If m2e is not there, follow the install process here
-	Spring Tools Suite (STS)
-	IntelliJ IDEA
-	VS Code

 **Steps to run:**

-	On the command line run:
git clone https://github.com/Nehasawant22/banking-system.git
-	Inside Eclipse or STS:
Open the project via File -> Import -> Maven -> Existing Maven project, then select the root directory of the cloned repo.

-	Then either build on the command line ./mvnw generate-resources or use the Eclipse launcher (right-click on project and Run As -> Maven install) to generate the CSS. Run the application's main method by right-clicking on it and choosing Run As -> Java Application.
-	Inside IntelliJ IDEA:
In the main menu, choose File -> Open and select the banking-system pom.xml. Click on the Open button.
-	CSS files are generated from the Maven build. You can build them on the command line ./mvnw generate-resources or right-click on the banking-system project then Maven -> Generates sources and Update Folders.
-	A run configuration named BankingSystemApplication should have been created for you if you're using a recent Ultimate version. Otherwise, run the application by right-clicking on the BankingSystemApplication main class and choosing Run BankingSystemApplication.
-	Navigate to the Banking System Application
  Visit **http://localhost:8080** in your browser.



