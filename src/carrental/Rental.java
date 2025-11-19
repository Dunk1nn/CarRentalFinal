package carrental;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Gryle Lamban
 */
import java.time.LocalDate;

public class Rental {
    private String rentalId;
    private Customer customer;
    private Car car;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalFee;
    private String status; // "Active", "Completed"

    public Rental(String rentalId, Customer customer, Car car, LocalDate startDate, LocalDate endDate) {
        this.rentalId = rentalId;
        this.customer = customer;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = "Active";
        calculateTotalFee();
    }

    // Getters and Setters
    public String getRentalId() { return rentalId; }
    public Customer getCustomer() { return customer; }
    public Car getCar() { return car; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public double getTotalFee() { return totalFee; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // Core logic: calculate fee based on days
    public void calculateTotalFee() {
        long days = java.time.temporal.ChronoUnit.DAYS.between(startDate, endDate);
        this.totalFee = days * car.getPricePerDay();
    }

    @Override
    public String toString() {
        return String.format("[RentalID: %s] Customer: %s | Car: %s %s | Days: %d | Total: ₱%.2f | Status: %s",
                rentalId, customer.getName(), car.getBrand(), car.getModel(),
                java.time.temporal.ChronoUnit.DAYS.between(startDate, endDate), totalFee, status);
    }
}
