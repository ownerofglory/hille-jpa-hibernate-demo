package ua.hillel.jpademo.repo;

import jakarta.persistence.EntityManager;
import ua.hillel.jpademo.model.entity.Customer;

public class CustomerJpaRepo implements CustomerRepo {

    private EntityManager entityManager;

    public CustomerJpaRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addCustomer(Customer customer) {
        entityManager.getTransaction().begin();

        entityManager.persist(customer);
        entityManager.flush();

        entityManager.getTransaction().commit();
    }

    @Override
    public Customer getById(Integer id) {
        entityManager.getTransaction().begin();

        Customer customer = entityManager.find(Customer.class, id);

        entityManager.getTransaction().commit();

        return customer;
    }
}
