package ua.hillel.jpademo.repo;

import ua.hillel.jpademo.model.entity.Customer;
import ua.hillel.jpademo.model.entity.Item;
import ua.hillel.jpademo.model.entity.Order;

import java.util.List;

public interface OrderRepo {
    Order createOrder(Customer customer, List<Item> items);
}
