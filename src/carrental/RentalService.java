package carrental;

import java.time.LocalDate;
import java.util.*;

public class RentalService {
    private List<Rental> rentals = new ArrayList<>();

    // CREATE (Rent a Car)
    public void rentCar(Rental rental) {
        rentals.add(rental);
        rental.getCar().setStatus("Rented");
        System.out.println("\nRental Created Successfully!");
        System.out.println("Rental ID: " + rental.getRentalId());
        System.out.printf("Total Cost: ₱%.2f\n", rental.getTotalFee());
        System.out.println("Car Status updated to RENTED");
    }

    // READ (By ID)
    public Rental findRentalById(String rentalId) {
        for (Rental r : rentals) {
            if (r.getRentalId().equalsIgnoreCase(rentalId)) {
                return r;
            }
        }
        return null;
    }

    // UPDATE (Return Car)
    public void returnCar(String rentalId) {
        Rental rental = findRentalById(rentalId);
        if (rental != null && rental.getStatus().equalsIgnoreCase("Active")) {
            rental.setStatus("Completed");
            rental.getCar().setStatus("Available");
            System.out.println("\nCar Returned Successfully!");
            System.out.printf("Total Fee Paid: ₱%.2f\n", rental.getTotalFee());
            System.out.println("Car Status updated to AVAILABLE");
        } else {
            System.out.println("✗ Rental not found or already completed.");
        }
    }

    // VIEW ACTIVE RENTALS
    public void viewActiveRentals() {
        System.out.println("\n--- ACTIVE RENTALS ---");
        boolean found = false;
        for (Rental r : rentals) {
            if (r.getStatus().equalsIgnoreCase("Active")) {
                System.out.println(r);
                found = true;
            }
        }
        if (!found) System.out.println("No active rentals.");
    }

    // VIEW ALL RENTALS (History)
    public void viewAllRentals() {
        if (rentals.isEmpty()) {
            System.out.println("No rental records found.");
            return;
        }
        System.out.println("\n--- RENTAL HISTORY ---");
        for (Rental r : rentals) {
            System.out.println(r);
        }
    }
}
