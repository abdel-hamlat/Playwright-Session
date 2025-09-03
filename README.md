# Playwright Automation Framework (Java)

This repository contains a scalable UI automation framework built with Playwright and Java.  
It demonstrates my ability to design, implement, and maintain automation solutions for modern web applications.

---

## 🔹 Key Highlights
- **Language & Tools:** Java, Playwright, JUnit 5, Maven  
- **Cross-Browser Coverage:** Chromium, Firefox, and WebKit  
- **Framework Design:**
  - Page Object Model (POM) for maintainability  
  - Reusable utility methods and locators  
  - Configurable test execution (headed/headless)  
- **Assertions & Reporting:**
  - Validations using JUnit  
  - Integration-ready for CI/CD pipelines (e.g., Jenkins, GitHub Actions)  

---
## 🔄 GitHub Actions & Merge Conflicts
This project uses GitHub Actions for CI/CD. Workflows are triggered on both **pushes** and **pull requests**.

- When you create or update a Pull Request, GitHub Actions runs the workflow on the PR branch.  
- If the PR has **merge conflicts**, the workflow still runs on the PR branch, but **no run is triggered on `main`** until the conflicts are resolved.  
- GitHub will show a warning:  
  > "This branch has conflicts that must be resolved before merging."  

### ✅ Best Practices
- Always pull the latest changes from `main` before opening a PR.  
- Resolve conflicts locally, then push the updated branch.  
- Once conflicts are fixed, the Actions workflow will re-run and merging can proceed.  
