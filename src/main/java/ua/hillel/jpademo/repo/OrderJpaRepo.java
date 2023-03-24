package ua.hillel.jpademo.repo;

import jakarta.persistence.EntityManager;
import ua.hillel.jpademo.model.entity.Customer;
import ua.hillel.jpademo.model.entity.Item;
import ua.hillel.jpademo.model.entity.Order;

import java.util.List;

public class OrderJpaRepo implements OrderRepo {
    public OrderJpaRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private EntityManager entityManager;

    @Override
    public Order createOrder(Customer customer, List<Item> items) {
        entityManager.getTransaction().begin();

        Order order = new Order();
        order.setCustomer(customer);
        order.setItems(items);

        entityManager.persist(order);
        entityManager.flush();

        entityManager.getTransaction().commit();
        return null;
    }
}
