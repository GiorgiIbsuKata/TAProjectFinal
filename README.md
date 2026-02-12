# Automation Exercise – End‑to‑End Test Automation Framework

This project is an end‑to‑end automated testing framework for **AutomationExercise.com**, covering both **UI tests** (Selenium + TestNG) and **API tests** (Rest Assured).  
It follows the **Page Object Model (POM)** structure and includes full **Allure reporting** for clean, visual test results.

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

## 🧪 UI Test Notes (IMPORTANT)

### 🔐 Login & Logout Tests
**Login and logout tests require valid accounts.**  
Specifically:

- **Test 2** (Login Test)
- **Test 4** (Logout Test)

These tests depend on **real, existing emails**.  
Make sure the email you use **already exists** on AutomationExercise.com before running them.

---

### 📝 Registration Tests
During development, **many accounts were created** because the registration test generates random emails.

If the registration test fails, it is most likely because:

- The randomly generated email **already exists**
- An **advertisement popup** interfered with the test flow

Both are normal issues with this website.



