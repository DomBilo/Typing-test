# Typing Test Game
[Introduction](#introduction)

[How the game work](#how-the-game-work)
- [Registration and Login](#registration-and-login)
- [Selecting Typing Test Level](#selecting-typing-test-level)
- [Playing the Typing Test](#playing-the-typing-test)
- [Result Display](#result-display)

[Features](#features)
- [1.Authentication](#1-authentication)
- [2.Typing Test Game](2-typing-test-game)
- [3.User Management](3-user-management)
- [4.Graphical User Interface](#graphical-user-interface)

[Object-Oriented Programming Concepts](#object-oriented-programming-concepts)
- [Classes & Objects](#class-and-objects)
- [Inheritance](#inheritance)
- [Polymorphism](#polymorphism)
- 

## Introduction
We're developing a typing test game because typing speed is an essential skill in today's digital world. Whether we're a student, a professional, or simply someone who spends a significant amount of time typing, having good typing speed and accuracy is crucial. In this blog post, we will explore how to create a Java console application that measures typing speed and accuracy.The project incorporates different typing levels, providing users with a varied and challenging experience. The project incorporates principles of Object-Oriented Programming (OOP), including Classes & Objects, Inheritance, Polymorphism, Encapsulation, Abstraction, Exception Handling, File I/O, and Anonymous Inner Class.
## How the game work
#### **Upon launching the program, users are presented with a menu offering various options:**<br/> 
- Login: Users can log in with existing credentials.
- Register: New users can create an account.
- Play Typing Test: Users can engage in typing tests after logging in.
- Exit: Exit the program.
   
#### **Registration and Login**<br/>
- Users can register as regular users or administrators.
- Administrators have additional privileges.
- Users need to log in to access the typing test.

#### **Selecting Typing Test Level**<br/>
- Users are prompted to choose a difficulty level (Easy, Medium, or Hard).
- The selected level determines the complexity of words to be typed.

#### **Playing the Typing Test**<br/>
- Users are informed to get ready to type and to enter the words exactly as shown.
- A random word from the chosen level is displayed, and users must type it accurately.
- The program records the number of typed words, correct words, and wrong words.
- The typing speed is calculated based on the time taken to type the words.
- Results, including typed words, correct words, wrong words, accuracy percentage, and typing speed, are displayed at the end of the test.

#### **Result Display**<br/>
- Typed Words: Total number of words typed.
- Correct Words: Number of words typed accurately.
- Wrong Words: Number of words with errors.
- Accuracy: Percentage of correctly typed words.
- Typing Speed: Speed in words per second or minute, depending on the mode.

## Features
#### **1. Authentication**<br/>
- **Log In:** Users can log in with their existing credentials.
- **Register:** New users can register to create an account.

#### **2. Typing Test Game**<br/>
- **Play Typing Test:** Users can select from three difficulty levels (Easy, Medium, Hard) and participate in a timed typing test.
- **Performance Tracking:** The system tracks the number of typed words, correct words, wrong words, accuracy, and typing speed during the test.
- **Results Display:** After the test, users receive a detailed summary of their performance, including typed words, correct words, wrong words, accuracy percentage, and typing speed.

#### **3. User Management**<br/>
- **Admin and Regular User Roles:** The system differentiates between regular users and administrators (admins).
- **Admin Features:** Admins have additional features like checking and managing user results.
  
#### **4.Graphical User Interface**<br/>
- **Login and Registration Forms:** The system provides user-friendly forms for logging in and registering.
- **Level Selection:** Users can easily choose the desired difficulty level for the typing test.
- **Results Display:** Performance results are presented in a clear and visually appealing format.

## Object-Oriented Programming Concepts

### Classes and Objects

We have a total of 10 classes:
- **AuthenticationSystem:** Manages user authentication, login, and registration.
- **TypingTestGame:** Main class orchestrating the entire game, including UI setup, level selection, and test execution.
- **User:** Represents a user with details such as username, password, and typing test results.
- **Admin:** Extends the User class, providing admin-specific functionality.
- **Result:** Captures the results of a typing test, including typed words, correct words, wrong words, accuracy, and typing speed.
- **TypingTestLevel:** Abstract class representing different difficulty levels for the typing test (Easy, Medium, Hard).
- **EasyLevel, MediumLevel, HardLevel:** Subclasses of TypingTestLevel, each with its set of words for the typing test.
- **AuthenticationSystem, Book, Customer, Employee, Login, Manager, Operation, OperationManager, OperationSeller, Register, Seller:** Classes managing various aspects of the application.

### Inheritance
 - **`Admin`** and **`User`** classes demonstrate inheritance. For example, **`public class Admin extends User`**.

### Polymorphism
- Polymorphism is shown through method overriding, e.g., **`@Override public String toString()`**.
- Casting is not explicitly used in the provided code.

### Encapsulation
 - Private fields like **`private Map<String, User> loginInfo;`** use encapsulation.
- Getter methods provide controlled access, e.g., **`public User getCurrentUser()`**.

### Abstraction
- **`TypingTestLevel`** is an abstract class with an abstract method: **`public abstract String getRandomWord(Random random);`**.
### Exception Handling
- Various try-catch blocks handle exceptions, e.g., in the **`loadUsers`** method.
### File I/O
- File reading and writing in **`AuthenticationSystem`**, e.g., **`BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE_PATH))`**.

### Anonymous Inner Class
- Anonymous inner classes are used for action listeners, e.g., **`loginButton.addActionListener(new ActionListener() { ... });`**.
### Static Method
- **`SwingUtilities.invokeLater`** is a static method, e.g., **`SwingUtilities.invokeLater(new Runnable() { ... });`**.
