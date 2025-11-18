# SENG 300 – Assignment 2: Design and Design Patterns

## Group Members:

Bolu Alagbe - 30207736

Zaine Ancheta - 30214484

Mark Bacay - 30205710

## Description:
This project implements a self-checkout system with three core design patterns:

- **Strategy** for payments (CashPayment, CardPayment, CryptocurrencyPayment via PaymentProcessor/PaymentStrategy)
- **Observer** for bagging alerts (BaggingArea notifies SessionBlocker, VisualAlert, etc.)
- **Singleton** for ProductDatabase

It also includes unit tests using JUnit 5 and a simple Main demo.

## Instructions:
- Open IntelliJ
- Select File → Open and choose the project folder
- Ensure:
  - src/main/java is marked as Sources Root
  - src/test/java is marked as Test Sources Root
  - To check project builds, select the 'Main' class file and run it.


- Run tests through IntelliJ
- Right-click the test folder
- Select Run 'All Tests'