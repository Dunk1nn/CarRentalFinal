package carrental;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Gryle Lamban
 */
public class Car {
    private String id;
    private String plateNo;
    private String brand;
    private String model;
    private double pricePerDay;
    private String status; // "Available", "Rented", "Maintenance"

    public Car(String id, String plateNo, String brand, String model, double pricePerDay) {
        this.id = id;
        this.plateNo = plateNo;
        this.brand = brand;
        this.model = model;
        this.pricePerDay = pricePerDay;
        this.status = "Available"; // default status
    }

    // Getters and Setters
    public String getId() { return id; }
    public String getPlateNo() { return plateNo; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public double getPricePerDay() { return pricePerDay; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return String.format("[CarID: %s] %s %s | Plate: %s | ₱%.2f/day | Status: %s",
                id, brand, model, plateNo, pricePerDay, status);
    }
}