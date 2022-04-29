package mz.zapps.services.customer.controller;

import mz.zapps.services.customer.model.Customer;
import mz.zapps.services.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    // INITIALIZE CUSTOMER SERVICE
    @Autowired
    private CustomerService customerService;

    // CONSTRUCTOR
    public CustomerController(CustomerService customerService) {
        super();
        this.customerService = customerService;
    }

    // SETTERS & GETTERS
    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    // CREATE CUSTOMER
    @PostMapping("/addCustomer")
    public void addCustomer(@RequestBody Customer customer) {
        customerService.add(customer);

    }

    // FIND ALL CUSTOMERS
    @GetMapping("/")	// localhost:8088/categories/allProducts
    public List<Customer> getAllCustomers(){
        return customerService.findAll();
    }

    // FIND SPECIFIC CUSTOMER
    @GetMapping("/findSpecificCustomer/{customerId}")
    public Customer findSpecificCustomer(@PathVariable("customerId") Long customerId) {
        return customerService.findSpecificCustomer(customerId);
    }

    // UPDATE CUSTOMER
    @PutMapping("/updateCustomer/{customerId}")
    public void updateCustomer(@PathVariable("customerId") Long customerId, String username, String password, String street, String city, String state, int zipcode) {
        customerService.update(customerId, username, password, street, city, state, zipcode);
    }

    // DELETE CUSTOMER
    @DeleteMapping("/deleteCustomer/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Long customerId) {
        customerService.delete(customerId);
    }
}
