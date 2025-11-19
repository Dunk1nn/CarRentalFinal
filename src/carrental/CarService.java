package carrental;

import java.util.*;

public class CarService {
    private List<Car> cars = new ArrayList<>();

    // CREATE
    public void addCar(Car car) {
        cars.add(car);
        System.out.println("✓ Car added successfully!");
    }

    // READ (All)
    public void viewAllCars() {
        if (cars.isEmpty()) {
            System.out.println("No cars available.");
            return;
        }
        System.out.println("\n--- LIST OF CARS ---");
        for (Car c : cars) {
            System.out.println(c);
        }
    }

    // READ (By ID)
    public Car findCarById(String id) {
        for (Car c : cars) {
            if (c.getId().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return null;
    }

    // UPDATE
    public void updateCar(String id, Car updatedCar) {
        Car existing = findCarById(id);
        if (existing != null) {
            existing.setStatus(updatedCar.getStatus());
            System.out.println("✓ Car updated successfully!");
        } else {
            System.out.println("✗ Car not found!");
        }
    }

    // DELETE
    public void deleteCar(String id) {
        Car car = findCarById(id);
        if (car != null && car.getStatus().equals("Available")) {
            cars.remove(car);
            System.out.println("✓ Car removed successfully!");
        } else {
            System.out.println("✗ Car not found or currently rented!");
        }
    }

    // EXTRA: Get Available Cars
    public List<Car> getAvailableCars() {
        List<Car> available = new ArrayList<>();
        for (Car c : cars) {
            if (c.getStatus().equalsIgnoreCase("Available")) {
                available.add(c);
            }
        }
        return available;
    }
    
    // Helper for reports
    public List<Car> getAllCars() {
        return cars;
    }
}