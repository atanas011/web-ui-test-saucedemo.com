### Saucedemo Test

Java (JDK) and Maven should be installed and added to System variables.  
Tests were written to run with Microsoft Edge browser.

- Clone repo to local dir and open cmd.exe in it
- To get results and HTML report, run: mvn test
- Report is created in: target/surefire-reports/index.html

User story:

1. Go to https://www.saucedemo.com
2. Try logging in, first with invalid and then with valid credentials, and check if the user is on the appropriate page
   after that. Read the credentials from the data.xlsx file.
3. On page: https://www.saucedemo.com/inventory.html sort the products by price (from lowest to highest).
4. Check if the sorting is correct.

Test should be in line with Page Object Model.