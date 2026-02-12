# Automation Exercise – End‑to‑End Test Automation Framework

This project is an end‑to‑end automated testing framework for **AutomationExercise.com**, covering both **UI tests** (Selenium + TestNG) and **API tests** (Rest Assured).  
It follows the **Page Object Model (POM)** structure and includes full **Allure reporting** for clean, visual test results.

This entire project — including **UI tests 1–10** and **API tests 1–10** — was created by **Giorgi Katamadze**.

---

## 🚀 Technologies Used
- Java 25
- Maven
- Selenium WebDriver
- TestNG
- Rest Assured
- Allure Reports
- Page Object Model (POM)

---
## ▶️ How to Run Tests & Generate Allure Reports

To execute the full test suite and generate Allure results, run the following commands from the project root:

### **1. Run all tests**

mvn clean test

This command executes **all UI and API tests** and automatically generates the Allure results folder: target/allure-results


### **2. Generate and open the Allure report**

mvn allure:serve or allure serve target/allure-results

This launches an interactive Allure dashboard in your browser with:
- Test results
- Steps
- Logs
- Attachments
- Screenshots (for failed tests)

---

## 🧪 UI Test Notes (IMPORTANT)

### 🔐 Login & Logout Tests
Login and logout tests require **correct, existing emails** to be created **before running the tests**.  
Specifically:

- **Test 2** – Login Test
- **Test 4** – Logout Test

These tests will fail if the email does not exist on AutomationExercise.com.

In the Login Test, I included a **valid account**, and it *should* work — however, AutomationExercise sometimes **deletes accounts randomly**, so the login may fail even with correct credentials.  
If this happens, simply **create a new account manually** and update the test data.
---

### 📝 Registration Tests
During development, **many accounts were created** because the registration test generates random emails.

If the registration test fails, it is most likely because:

- The randomly generated email **was already created earlier**, or
- An **advertisement popup** interfered with the test flow

Both issues are common on this website.

---

### ⚠️ Random Advertisement Popups
Some UI tests may fail due to **random ads** appearing on the website.  
Because of this, I recommend running the tests **one by one** to verify that they work correctly.

All tests have been individually validated and **pass when run alone**, but running them in parallel increases the chance of an ad interrupting the flow, which may cause false failures even though the tests themselves are correct.

---

## 🔐 API Login Test Notes

### API Task 7 – `postVerifyLoginValid`
For **API task 7**, you may need to **create an account first**.

The email/password in the code *should* work, i tested it many times and its fine. But AutomationExercise sometimes **deletes accounts under certain conditions**, so you might need to create a new account before running this test.
