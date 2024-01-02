# Classes 
## Game Class (Game.java):

#### The Game class contains the main method that initiates and runs the typing test game. It creates an instance of the TypingTestGame class and starts the game by calling its runGame method.
## TypingTestGame Class (TypingTestGame.java):

#### The TypingTestGame class manages the overall functionality of the typing test game. It handles user authentication, registration, level selection, and gameplay. It also keeps track of user results and writes them to a file.
## AuthenticationSystem Class (AuthenticationSystem.java):

#### The AuthenticationSystem class is responsible for user authentication, registration, and managing user data. It uses a file to store user information and provides methods for login, registration, and user data manipulation.
## Admin Class (Admin.java):

#### The Admin class extends the User class and represents an administrator user. It has additional functionality specific to administrators.
## User Class (User.java):

#### The User class represents a regular user in the typing test game. It stores user credentials, results for different levels, and provides methods for result management.
## Result Class (Result.java):

#### The Result class encapsulates the results of a typing test, including typed words, correct words, wrong words, accuracy percentage, and typing speed.
## TypingTestLevel Class (TypingTestLevel.java):

#### The abstract TypingTestLevel class defines the structure for different levels of the typing test. It includes an abstract method to get a random word from the level's word list.
## EasyLevel Class (EasyLevel.java):

#### The EasyLevel class extends TypingTestLevel and represents the easy level of the typing test. It defines a specific word list for this level.
## MediumLevel Class (MediumLevel.java):

#### The MediumLevel class extends TypingTestLevel and represents the medium level of the typing test. It has its own word list.
## HardLevel Class (HardLevel.java):

#### The HardLevel class extends TypingTestLevel and represents the hard level of the typing test. It defines a unique word list for this challenging level.
