
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

 class Car {


    private String name;
    private boolean available;

    public Car(String name) {
        this.name = name;
        this.available = true;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
class Customer {
    private String name;
    private Car hiredCar;

    public Customer(String name) {
        this.name = name;
        this.hiredCar = null;
    }

    public String getName() {
        return name;
    }

    public Car getHiredCar() {
        return hiredCar;
    }

    public void setHiredCar(Car hiredCar) {
        this.hiredCar = hiredCar;
    }

    public void returnCar() {
        this.hiredCar=null;
}
}

class CarHiringSystem extends JFrame {
    private ArrayList<Car> cars;
    private Map<String, Customer> customers;
    private JTextArea outputTextArea;

    public CarHiringSystem() {
        // Initialize cars
        cars = new ArrayList<>();
        cars.add(new Car("Tesla Model S 2019"));
        cars.add(new Car("Ford Ranger 2020"));
        cars.add(new Car("Mercedes S550"));

        // Initialize customers
        customers = new HashMap<>();
        customers.put("idris", new Customer("Idris"));
        customers.put("Sophia", new Customer("Sophia"));

        // Set up GUI components
        setTitle("Car Hiring System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);

        JButton hireButton = new JButton("Hire Car");
        hireButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hireCar();
            }
        });

        JButton returnButton = new JButton("Return Car");
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                returnCar();
            }
        });

        JPanel panel = new JPanel();
        panel.add(scrollPane);
        panel.add(hireButton);
        panel.add(returnButton);

        add(panel);

        updateCarList();

        setVisible(true);
    }

    private void updateCarList() {
        outputTextArea.setText("Available Cars:\n");
        for (Car car : cars) {
            if (car.isAvailable()) {
                outputTextArea.append(car.getName() + "\n");
            }
        }
    }




private void hireCar() {
        String customerName = JOptionPane.showInputDialog("Enter customer name:");
        if (customerName == null || customerName.isEmpty()) {
        displayMessage("Invalid customer name.");
        return;
        }

        if (!customers.containsKey(customerName)) {
        displayMessage("Customer not found.");
        return;
        }

        Customer customer = customers.get(customerName);

        if (customer.getHiredCar() != null) {
        displayMessage(customerName + " already has a hired car.");
        return;
        }

        for (Car car : cars) {
        if (car.isAvailable()) {
        car.setAvailable(false);
        customer.setHiredCar(car);
        displayMessage(customerName + " has hired " + car.getName());
        updateCarList();
        return;
        }
        }

        displayMessage("All cars are currentlyhired.");
 }
private void returnCar() {
        String customerName = JOptionPane.showInputDialog("Enter customer name:");
        if (customerName == null || customerName.isEmpty()) {
        displayMessage("Invalid customer name.");
        return;
        }

        if (!customers.containsKey(customerName)) {
        displayMessage("Customer not found.");
        return;
        }

        Customer customer = customers.get(customerName);

        if (customer.getHiredCar() == null) {
        displayMessage(customerName + " has no hired car to return.");
        return;
        }

        Car returnedCar = customer.getHiredCar();
        returnedCar.setAvailable(true);
        customer.returnCar();

        displayMessage(customerName + " has returned " + returnedCar.getName());
        updateCarList();
        }

private void displayMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
        }

public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
@Override
public void run() {
        new CarHiringSystem();
        }
        });
        }
        }

