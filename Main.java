
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

