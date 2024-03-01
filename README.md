************************************************PROJECT DESCRIPTION************************************************

**Project Statement:**
    **1. Login with Google**
        Attempt to log in using a Google account.
        Provide invalid account details to capture the error message.
    **2. Upcoming Bikes**
        Display the details of upcoming bikes, including the bike name, price, and expected launch date in India.
        The manufacturer should be Honda.
        The bike price should be less than 4 lakhs.
    **3. Upcoming Cars**
        Display the details of upcoming cars, including the car name, price, and expected launch date in India.
        The manufacturer should be Tata.
    **4. Used Cars in Chennai**
        Extract the popular models of used cars in Chennai and display their details.
    **5. Health Insurance**
        Display the brand names and plans of health insurance policies.

**Detailed Description:**
    1. Launch the desired browser.
    2. Open the "https://zigwheels.com" website.
    3. Click on the Login/Signup button.
    4. Click on the Google option and provide invalid credentials.
    5. Capture the error message displayed.
    6. Hover over the "New Bikes" section.
    7. Click on the "Upcoming Bikes" option.
    8. Select Honda as the manufacturer name.
    9. Extract all upcoming Honda bikes with a price less than 4 lakhs.
    10. Hover over the "New Cars" section.
    11. Click on the "Upcoming Cars" option.
    12. Select Tata as the manufacturer name.
    13. Extract all upcoming Tata cars.
    14. Hover over the "Used Cars" section and click on Chennai as the city.
    15. Display all popular models in a list.
    16. Click on each popular model checkbox and extract all the details of the used car.
    17. Hover over the "More" section and click on "Health Insurance".
    18. Fill in all the required details.
    19. Extract all Health Insurance brand names and plans.
    20. Close the browser.

**Key Automation Scope:** 
    1. Handling windows & frames
    2. Filling simple form, Capture warning message
    3. Extract menu items from frames & store in collections
    4. Navigating back to home page

************************************************STEPS TO EXECUTE************************************************

To execute the project and obtain the expected output, please follow the steps below:
    1. Clone the repository to your local machine.
        command: ```git clone "https://github.com/anandkumar01/Hackathon_TestNG_Project.git```
    2. Open the project in you prefered IDE.
    3. Install TestNG plugin in your local machine.
    4. Open the testng.xml file
    5. Run the testng.xml file as TestNG suite.

************************************************FILES DESCRIPTION************************************************
 
**1. src/test/java**
    **a. factory package:**
        Contains the implementation of browser factory. properties file handling and logger functionalities.
    **b. pageObjects package:**
        Contains BasePage, and classes representing page objects specific to the project, extending the BasePage.
    **c. testCases package:**
        Contains actual test cases for the project. All test cases extends CrossBrowsing class from the factory package.
    **d. utilitis package:**
        Contains WriteExcelData class to write all the data into the Apache excel file.
     
**2.src/test/resources**
    config.properties: Configuration file containing data used in the pageObjects package.
    log4j2.xml: Configuration file for Log4j2. which manages project logs.
    testdata.xlsx: Apache excel file that contains all extracted data of projects.
 
**3. Maven Dependencies:**
    In this File we have all the directory on the local machine, where all the project artifacts are stored. when a Maven build is executed,
    Maven automatically downloads all the dependency jars into the local repository. Usually, this directory is named.

**4. test-output:**
    It is a spark report created every times project is executed.

**5. pom.xml:**
    The pom.xml file contains information of project and configuration for the maven to build the project such as dependencies,
    build directory, source directory, plugin etc.

**6. testng.xml:**
    Configuration file for executing the project as a TestNG suite.
    It specifies the test classes and their execution order.

