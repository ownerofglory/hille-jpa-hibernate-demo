package ua.hillel.jpademo.repo;

import ua.hillel.jpademo.model.entity.Customer;

public interface CustomerRepo {
    void addCustomer(Customer customer);
    Customer getById(Integer id);
}
