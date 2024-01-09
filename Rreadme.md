# Typing Test Game
[Introduction](#introduction)

[How to Play](#how-to-play)
- [Registration and Login](#registration-and-login)
- [Selecting Typing Test Level](#selecting-typing-test-level)
- [Playing the Typing Test](#playing-the-typing-test)
- [Result Display](#result-display)

[Object-Oriented Programming Concepts](#object-oriented-programming-concepts)
- [Classes and Objects](#classes-and-objects)
- [Encapsulation](#encapsulation)
- [Inheritance](#inheritance)
- [Polymorphism](#polymorphism)
- [Abstraction](#abstraction)
- [Composition](#composition)
- [Encapsulation and Getter/Setter Methods](#encapsulation-and-gettersetter-methods)
- [File I/O](#file-io)

## Introduction: 
##### We're developing a typing test game because typing speed is an essential skill in today's digital world. Whether we're a student, a professional, or simply someone who spends a significant amount of time typing, having good typing speed and accuracy is crucial. In this blog post, we will explore how to create a Java console application that measures typing speed and accuracy.The project incorporates different typing levels, providing users with a varied and challenging experience.
## How to Play:
### Upon launching the program, users are presented with a menu offering various options:

##### -Login: Users can log in with existing credentials.
##### -Register: New users can create an account.
##### -Play Typing Test: Users can engage in typing tests after logging in.
##### -Exit: Exit the program.
### Registration and Login:

##### -Users can register as regular users or administrators.
##### -Administrators have additional privileges.
##### -Users need to log in to access the typing test.

#### +After logging in, users can select the "Play Typing Test" option and further choose a typing test level - Easy, Medium, or Hard. The typing test involves typing randomly generated words within a specified time limit.

### Selecting Typing Test Level:

##### -Users are prompted to choose a difficulty level (Easy, Medium, or Hard).
##### -The selected level determines the complexity of words to be typed.
### Playing the Typing Test:

##### -Users are informed to get ready to type and to enter the words exactly as shown.
##### -A random word from the chosen level is displayed, and users must type it accurately.
##### -The program records the number of typed words, correct words, and wrong words.
##### -The typing speed is calculated based on the time taken to type the words.
##### -Results, including typed words, correct words, wrong words, accuracy percentage, and typing speed, are displayed at the end of the test.
### Result Display:

##### -Typed Words: Total number of words typed.
##### -Correct Words: Number of words typed accurately.
##### -Wrong Words: Number of words with errors.
##### -Accuracy: Percentage of correctly typed words.
##### -Typing Speed: Speed in words per second or minute, depending on the mode.

## Object-Oriented Programming Concepts
### Classes and Objects:
#### -Classes are used to model entities in the program. 
- Examples include Game, TypingTestGame, AuthenticationSystem, User, Admin, Result, TypingTestLevel, EasyLevel, MediumLevel, and HardLevel.

#### -Objects are instances of these classes. For instance, in the Game class, an object of the TypingTestGame class is created (TypingTestGame game = new TypingTestGame();).

### Encapsulation:
#### -Encapsulation is achieved by making use of access modifiers (private, protected, public) to control the access levels of fields and methods.
  
  public class User {
      // Fields are private
      private String username;
      private String password;
      private Map<String, List<Result>> resultsByLevel;


#### -Private fields in the TypingTestGame class, like authSystem, users, typedWords, correctWords, etc., can only be accessed within the same class.

### Inheritance:
#### -Inheritance is demonstrated by the User and Admin classes. The Admin class extends the User class, inheriting its attributes and methods. This helps in avoiding code duplication and establishing an "is-a" relationship between User and Admin.
## Polymorphism:
#### -Polymorphism is achieved through method overriding. For example, the toString() method is overridden in the Admin and User classes to provide specific implementations.

#### -The getRandomWord method in the TypingTestLevel, EasyLevel, MediumLevel, and HardLevel classes is another example of polymorphism. Each subclass provides its own implementation.

### Abstraction:
#### -Abstraction is demonstrated by abstract classes (TypingTestLevel). Abstract classes cannot be instantiated directly and may contain abstract methods that must be implemented by their subclasses (getRandomWord).
## Composition:
#### -Composition is seen in the TypingTestGame class, which has an instance variable authSystem of type AuthenticationSystem. This is an example of "has-a" relationship where one class has an object of another class.
## Encapsulation and Getter/Setter Methods:
#### -Encapsulation is maintained by providing getter and setter methods for private fields. For example, in the User class, getUsername(), getPassword(), addResult(), etc., are getter and setter methods.
### File I/O:
#### -The code demonstrates reading from and writing to files (loadUsers and saveUsers methods in AuthenticationSystem, writeUserResultsToFile method in TypingTestGame).




