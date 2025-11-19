package carrental;

import java.util.*;

public class CustomerService {
    private List<Customer> customers = new ArrayList<>();

    // CREATE
    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("✓ Customer added successfully!");
    }

    // READ (All)
    public void viewAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }
        System.out.println("\n--- LIST OF CUSTOMERS ---");
        for (Customer c : customers) {
            System.out.println(c);
        }
    }

    // READ (By ID)
    public Customer findCustomerById(String id) {
        for (Customer c : customers) {
            if (c.getId().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return null;
    }

    // UPDATE
    public void updateCustomer(String id, Customer updated) {
        Customer existing = findCustomerById(id);
        if (existing != null) {
            existing.setName(updated.getName());
            existing.setContactNumber(updated.getContactNumber());
            existing.setLicenseNumber(updated.getLicenseNumber());
            System.out.println("✓ Customer updated successfully!");
        } else {
            System.out.println("✗ Customer not found!");
        }
    }

    // DELETE
    public void deleteCustomer(String id) {
        Customer c = findCustomerById(id);
        if (c != null) {
            customers.remove(c);
            System.out.println("✓ Customer removed successfully!");
        } else {
            System.out.println("✗ Customer not found!");
        }
    }
}