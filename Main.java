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

        displayMessage("All cars are currently hired.");
            }
