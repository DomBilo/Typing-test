# Object-Oriented Programming Concepts
## Classes and Objects:
#### -Classes are used to model entities in the program. Examples include Game, TypingTestGame, AuthenticationSystem, User, Admin, Result, TypingTestLevel, EasyLevel, MediumLevel, and HardLevel.

#### -Objects are instances of these classes. For instance, in the Game class, an object of the TypingTestGame class is created (TypingTestGame game = new TypingTestGame();).

## Encapsulation:
#### -Encapsulation is achieved by making use of access modifiers (private, protected, public) to control the access levels of fields and methods.

#### -Private fields in the TypingTestGame class, like authSystem, users, typedWords, correctWords, etc., can only be accessed within the same class.

## Inheritance:
#### -Inheritance is demonstrated by the User and Admin classes. The Admin class extends the User class, inheriting its attributes and methods. This helps in avoiding code duplication and establishing an "is-a" relationship between User and Admin.
## Polymorphism:
#### -Polymorphism is achieved through method overriding. For example, the toString() method is overridden in the Admin and User classes to provide specific implementations.

#### -The getRandomWord method in the TypingTestLevel, EasyLevel, MediumLevel, and HardLevel classes is another example of polymorphism. Each subclass provides its own implementation.

## Abstraction:
#### -Abstraction is demonstrated by abstract classes (TypingTestLevel). Abstract classes cannot be instantiated directly and may contain abstract methods that must be implemented by their subclasses (getRandomWord).
## Composition:
#### -Composition is seen in the TypingTestGame class, which has an instance variable authSystem of type AuthenticationSystem. This is an example of "has-a" relationship where one class has an object of another class.
## Encapsulation and Getter/Setter Methods:
#### -Encapsulation is maintained by providing getter and setter methods for private fields. For example, in the User class, getUsername(), getPassword(), addResult(), etc., are getter and setter methods.
## File I/O:
#### -The code demonstrates reading from and writing to files (loadUsers and saveUsers methods in AuthenticationSystem, writeUserResultsToFile method in TypingTestGame).



