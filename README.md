Car Hiring System  

This Java program represents a simple Car Hiring System implemented using Swing for the graphical user interface. The system includes two main classes, Car and Customer, which model cars and customers, respectively. The primary functionality is managed by the CarHiringSystem class, which extends JFrame to create a GUI for interacting with the car hiring system.

Classes
1. Car (Kendy)
Represents a car with a name and availability status.
Provides methods to get and set the availability of the car.
2. Customer(Jane)
Represents a customer with a name and the option to hire a car.
Provides methods to get and set the hired car, and return a hired car.
3. CarHiringSystem(Linet/Nygel)
Extends JFrame to create a graphical user interface for the car hiring system.
Manages the list of cars, customers, and GUI components.
Allows customers to hire and return cars through button actions.
Displays available cars and messages using a JTextArea.
GUI Components(Idris)
1. JTextArea
Displays information about available cars and system messages.
Set to non-editable for output-only purposes.
2. JScrollPane
Enables scrolling for the JTextArea.
3. JButton (Hire Car)
Triggers the hireCar() method when clicked.
Prompts the user for a customer name and allows them to hire an available car.
4. JButton (Return Car)
Triggers the returnCar() method when clicked.
Prompts the user for a customer name and allows them to return a hired car.
Methods
1. updateCarList()
Updates the JTextArea with the list of available cars.
2. hireCar()
Prompts the user for a customer name.
Checks if the customer exists and does not already have a hired car.
Assigns the first available car to the customer and updates the display.
3. returnCar()
Prompts the user for a customer name.
Checks if the customer exists and has a hired car.
Sets the hired car to available and updates the display.
4. displayMessage(String message)
Displays a message dialog with the provided message.
5. main(String[] args)
Launches the application by creating an instance of CarHiringSystem in the event dispatch thread.
How to Run
Compile the Java code.
Run the compiled code.
The GUI will appear, allowing users to hire and return cars.
Dependencies
This program uses the Swing library for creating the graphical user interface.                                                            OOP principals utilized                                                                 Creating set and get methods                                               Method Overidding                                                                         Creation of GUI
