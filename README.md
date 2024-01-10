# Typing Test Game

## Introduction
We're developing a typing test game because typing speed is an essential skill in today's digital world. Whether we're a student, a professional, or simply someone who spends a significant amount of time typing, having good typing speed and accuracy is crucial. In this blog post, we will explore how to create a Java console application that measures typing speed and accuracy.The project incorporates different typing levels, providing users with a varied and challenging experience.
## Features
**1. Authentication**<br/>
- **Log In:** Users can log in with their existing credentials.
- **Register:** New users can register to create an account.

**2. Typing Test Game**<br/>
- **Play Typing Test:** Users can select from three difficulty levels (Easy, Medium, Hard) and participate in a timed typing test.
- **Performance Tracking:** The system tracks the number of typed words, correct words, wrong words, accuracy, and typing speed during the test.
- **Results Display:** After the test, users receive a detailed summary of their performance, including typed words, correct words, wrong words, accuracy percentage, and typing speed.

**3. User Management**<br/>
- **Admin and Regular User Roles:** The system differentiates between regular users and administrators (admins).
- **Admin Features:** Admins have additional features like checking and managing user results.

**4. **<br/>
## Object-Oriented Features

### Classes & Objects

We have a total of 10 classes:
- Authenticate: Run log in and register 
- Book: creating a book list, storing the data for book, and verify the book
- Customer: identifying the customer and store the customer
- Employee: cast to manager or seller 
- Login: Logging employee in and verify existing employee ID
- Manager: identifying the user to be a manager
- Operation: manager the operation to the manager or seller
- OperationManager: Includes all the functions that the manager can perform
- OperationSeller: Includes all the functions that the seller can perform
- Register: Register new employee
- Seller: identity the seller, add purchase info, and verify the purchase 

### Inheritance

Inheritance is employed to create a hierarchy of classes. We have 2 Super classes:
- **Employee** serves as **SuperClass**, while both **Manager** class and **Seller** class are **sub-classes** that inherit the constructor of **Employee**.
In this case, we use inheritance for better code structure as seller and manager are both Employee. It is also for code reusability such as the getSalary method, and for specialization because even if seller and manager are both employee, they have different salary, and different function available to them.
- **OperationManager** and **OperationSeller** are also **sub-classes** extended from the **Operation**. 
We use inheritance for this because it can provide reusable code for addCustomer method, as both the operationManager and operationSeller need it.

### Polymorphism

**Casting**

We create manager as an employee first before casting it into manager because at the start, we only know that the user is employee, and after we get the position, we can cast them to specific class.

    Employee tmp2 = new Manager(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], parts[4]);
    mList.add((Manager)tmp2);

We cast the employee into manager so that it can access specific methods that only available in Manger class and not available in the superclass, employee.
    

### Encapsulation

-**public**: Can be accessed from any other class or package. We use public on methods so that it can be use in other classes.

    public int getEmployeeID(){
        return employeeID;
    }

We use public for any method that doesn't have any restriction and can be called from anywhere without causing any problems. 

-**private**: Can only be accessible within the same class and not visible to subclasses or other classes. We use private on every field to ensure their the value can only be changed inside that class and cannot be modified by any external classes.

    private int bookID, bookCount;
    private String title;
    private double salePrice, importPrice;
    
We use private on these fields because these fields are the properties of the class, so we only want their value to be modified from within the class and not allowed any external inteference.

We also use private on some methods as well:

    private JPanel registerUser() {

We use private on this method because it is exclusive to the class it is in and we do not want any other class to access it.

-**protected**: Can be accessible within its own package and by subclasses, whether they are in the same package or not.</br>
We use it in method in **Operation.java**

    protected JPanel addCustomer() {

and **Employee.java**

    protected static boolean addCustomer(int tmpCutomerID, String name, String phoneNumber){

We use protected for this 2 methods because we only want those methods to be called from class in the same package or subclass, and prevent it from being called from outside classes. We use it on addcustomer because the operation super class which it allow the subclass can able to access it as well

### Abstraction

We have 1 abstract class that is implemented in **Operation.java**

    abstract class Operation {
    
We use abstract class because we want to prevent the creation of the object for Operation class as we do not need them. We use abstract class instead of interface because we need this class to include both concrete and abstract method.

and 1 abstract method:

    public abstract void runOperation();

We create the abstract method to ensure the implementation of that method in each subclass because this method is the main method for Operation. We use abstract method instead of interface because we only want to use that method in the subclasses of Operation class.
### Exception Handling
Exception handling is incorporated to gracefully manage unexpected errors. This ensures the system can recover or gracefully terminate, we implement this to ensure the **file is not found** issue and the **mistype input** issue by using **'try'** and **'catch'**
- **file is not found**: We use the try and catch IOException to check whether the file that we need to open exist.<br/>

      try {
          // Create a FileWriter in append mode by passing true as the second parameter
          FileWriter fileWriter = new FileWriter(filePath, true);
      
          // Wrap the FileWriter in a BufferedWriter for efficient writing
          BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
      
          // Append the data to the file
          bufferedWriter.write(WritingContent);
          bufferedWriter.newLine(); // Add a new line for clarity
      
          // Close the BufferedWriter to ensure all data is flushed to the file
          bufferedWriter.close();
      
          finish = true;
      } catch (IOException e) {
          // Handle IO exceptions, e.g., if the file cannot be created or written to
          e.printStackTrace();
      }
  
- **mistype input**: We use try and catch NumberFormatException to check whether the user input the correct type of data format<br/>

      try {
          int tmpID = Integer.parseInt(idField.getText());
          String tmpName = nameField.getText();
          String tmpPhoneNumber = phoneNumberField.getText();
          if (Customer.VerifyCustomerID(tmpID))
          {
              JOptionPane.showMessageDialog(frame, "Customer ID Already Existed");
          }
          else {
              boolean e1 = Employee.addCustomer(tmpID, tmpName, tmpPhoneNumber);
              if (e1){
                  JOptionPane.showMessageDialog(frame, "Customer Added completed.");
              } else{
                  JOptionPane.showMessageDialog(frame, "Error during addition. Please try again.");
              }
          }
      } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(frame, "Wrong input data type. Please try again.");
          idField.setText(""); // Clear the field
          nameField.setText("");
          phoneNumberField.setText("");
      }


### File I/O

We have 4 files:
- **Book.txt:** to store bookID, book title, sale price, import price, import date
- **Customer.txt:** to store customerID, name, phone number
- **EmployeeInfo.txt:** to store employeeID, name, password, email, start date, position
- **Purchase.txt:** to store purchaseID, customerID, sellerID, bookID, quantity, total price, purchase date

We use these 4 files separately because we want each file to store specific data, so that it won't create any issue when we read it.

### Lambda Expression
Lambda expressions enhance the system's flexibility and conciseness. We also implement **'filter'** and **'max'**.
- **'filter'** is a function we use to simplify the process of selecting elements that meet certain criteria. For a certain reason, **filter** can help narrow down the elements in a stream based on a specific condition. In this project, we use the **filter** operation to find a specific book in the list of book purchases a seller makes.
- We use the function **'max'** to find the maximum element in a collection. Using the **max** operation is more more readable and expressive when the intention is to find the maximum element based on a specific property. In the case of Book.java, we use the **max** operation to find the maximum element of the **bookList1** stream which compares the books based on their counts **(Book::getBookCount)**

      Book popularBook = bookList1.stream()
              .max(Comparator.comparingInt(Book::getBookCount))
              .orElse(null);

### Static method
**'static'** method we use to access the class without creating an instance of the class. In the project, we use **21** static methods. We use the static method is for an easy way to call out the function in other class and also call in within class.

    public static Manager getManager(Employee loginUser)
    public static Seller getSeller(Employee loginUser)

The getManager function use as a static method to provide a function which it not associated with login object and make an instance of different class
