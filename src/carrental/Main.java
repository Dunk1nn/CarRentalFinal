package carrental;


import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static CarService carService = new CarService();
    private static CustomerService customerService = new CustomerService();
    private static RentalService rentalService = new RentalService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=====================================");
        System.out.println("  CAR RENTAL SYSTEM - MAIN MENU");
        System.out.println("=====================================");
        
        while (true) {
            showMainMenu();
        }
    }

    private static void showMainMenu() {
        System.out.println("\n[1] Manage Customers");
        System.out.println("[2] Manage Cars");
        System.out.println("[3] Manage Rentals");
        System.out.println("[4] Reports");
        System.out.println("[0] Exit");
        System.out.print("Enter your choice: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1: customerMenu(); break;
            case 2: carMenu(); break;
            case 3: rentalMenu(); break;
            case 4: reportsMenu(); break;
            case 0: 
                System.out.println("Thank you for using the system!");
                System.exit(0);
            default: System.out.println("✗ Invalid choice. Try again.");
        }
    }

    // ========== CUSTOMER MENU ==========
    private static void customerMenu() {
        System.out.println("\n=====================================");
        System.out.println("  CUSTOMER MANAGEMENT");
        System.out.println("=====================================");
        System.out.println("[1] Add New Customer");
        System.out.println("[2] View Customers");
        System.out.println("[3] Update Customer");
        System.out.println("[4] Delete Customer");
        System.out.println("[0] Back to Main Menu");
        System.out.print("Enter your choice: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1: addCustomer(); break;
            case 2: customerService.viewAllCustomers(); break;
            case 3: updateCustomer(); break;
            case 4: deleteCustomer(); break;
            case 0: return;
            default: System.out.println("✗ Invalid choice.");
        }
    }

    private static void addCustomer() {
        System.out.print("Enter Customer ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Contact Number: ");
        String contact = scanner.nextLine();
        System.out.print("Enter License Number: ");
        String license = scanner.nextLine();
        
        Customer customer = new Customer(id, name, contact, license);
        customerService.addCustomer(customer);
    }

    private static void updateCustomer() {
        System.out.print("Enter Customer ID to update: ");
        String id = scanner.nextLine();
        System.out.print("Enter New Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter New Contact: ");
        String contact = scanner.nextLine();
        System.out.print("Enter New License: ");
        String license = scanner.nextLine();
        
        Customer updated = new Customer(id, name, contact, license);
        customerService.updateCustomer(id, updated);
    }

    private static void deleteCustomer() {
        System.out.print("Enter Customer ID to delete: ");
        String id = scanner.nextLine();
        customerService.deleteCustomer(id);
    }

    // ========== CAR MENU ==========
    private static void carMenu() {
        System.out.println("\n=====================================");
        System.out.println("  CAR MANAGEMENT");
        System.out.println("=====================================");
        System.out.println("[1] Add New Car");
        System.out.println("[2] View Cars");
        System.out.println("[3] Update Car");
        System.out.println("[4] Remove Car");
        System.out.println("[0] Back to Main Menu");
        System.out.print("Enter your choice: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1: addCar(); break;
            case 2: carService.viewAllCars(); break;
            case 3: updateCar(); break;
            case 4: deleteCar(); break;
            case 0: return;
            default: System.out.println("✗ Invalid choice.");
        }
    }

    private static void addCar() {
        System.out.print("Enter Car ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Plate No: ");
        String plate = scanner.nextLine();
        System.out.print("Enter Brand: ");
        String brand = scanner.nextLine();
        System.out.print("Enter Model: ");
        String model = scanner.nextLine();
        System.out.print("Enter Price/Day: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        
        Car car = new Car(id, plate, brand, model, price);
        carService.addCar(car);
    }

    private static void updateCar() {
        System.out.print("Enter Car ID to update: ");
        String id = scanner.nextLine();
        Car car = carService.findCarById(id);
        if (car != null) {
            System.out.print("Enter New Status (Available/Rented/Maintenance): ");
            String status = scanner.nextLine();
            car.setStatus(status);
            System.out.println("✓ Car updated successfully!");
        } else {
            System.out.println("✗ Car not found!");
        }
    }

    private static void deleteCar() {
        System.out.print("Enter Car ID to delete: ");
        String id = scanner.nextLine();
        carService.deleteCar(id);
    }

    // ========== RENTAL MENU ==========
    private static void rentalMenu() {
        System.out.println("\n=====================================");
        System.out.println("  RENTAL MANAGEMENT");
        System.out.println("=====================================");
        System.out.println("[1] Rent a Car");
        System.out.println("[2] Return a Car");
        System.out.println("[3] View Active Rentals");
        System.out.println("[0] Back to Main Menu");
        System.out.print("Enter your choice: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1: rentCar(); break;
            case 2: returnCar(); break;
            case 3: rentalService.viewActiveRentals(); break;
            case 0: return;
            default: System.out.println("✗ Invalid choice.");
        }
    }

    private static void rentCar() {
        System.out.print("Enter Customer ID: ");
        String custId = scanner.nextLine();
        Customer customer = customerService.findCustomerById(custId);
        if (customer == null) {
            System.out.println("✗ Customer not found!");
            return;
        }

        System.out.print("Enter Car ID: ");
        String carId = scanner.nextLine();
        Car car = carService.findCarById(carId);
        if (car == null || !car.getStatus().equalsIgnoreCase("Available")) {
            System.out.println("✗ Car not available or not found!");
            return;
        }

        System.out.print("Enter Start Date (YYYY-MM-DD): ");
        LocalDate startDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Enter End Date (YYYY-MM-DD): ");
        LocalDate endDate = LocalDate.parse(scanner.nextLine());

        String rentalId = "R-" + System.currentTimeMillis();
        Rental rental = new Rental(rentalId, customer, car, startDate, endDate);
        rentalService.rentCar(rental);
    }

    private static void returnCar() {
        System.out.print("Enter Rental ID: ");
        String rentalId = scanner.nextLine();
        rentalService.returnCar(rentalId);
    }

    // ========== REPORTS MENU ==========
    private static void reportsMenu() {
        System.out.println("\n=====================================");
        System.out.println("  REPORTS");
        System.out.println("=====================================");
        System.out.println("[1] List of Available Cars");
        System.out.println("[2] List of Rented Cars");
        System.out.println("[3] Rental History");
        System.out.println("[0] Back to Main Menu");
        System.out.print("Enter your choice: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("\n--- AVAILABLE CARS ---");
                for (Car c : carService.getAvailableCars()) {
                    System.out.println(c);
                }
                break;
            case 2:
                System.out.println("\n--- RENTED CARS ---");
                for (Car c : carService.getAllCars()) {
                    if (c.getStatus().equalsIgnoreCase("Rented")) {
                        System.out.println(c);
                    }
                }
                break;
            case 3:
                rentalService.viewAllRentals();
                break;
            case 0:
                return;
            default:
                System.out.println("✗ Invalid choice.");
        }
    }
}
