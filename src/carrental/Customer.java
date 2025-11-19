package carrental;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Gryle Lamban
 */
public class Customer {
    private String id;
    private String name;
    private String contactNumber;
    private String licenseNumber;

    public Customer(String id, String name, String contactNumber, String licenseNumber) {
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
        this.licenseNumber = licenseNumber;
    }

    // Getters and Setters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getContactNumber() { return contactNumber; }
    public String getLicenseNumber() { return licenseNumber; }
    public void setName(String name) { this.name = name; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }

    @Override
    public String toString() {
        return String.format("[CustomerID: %s] %s | Contact: %s | License: %s",
                id, name, contactNumber, licenseNumber);
    }
}
