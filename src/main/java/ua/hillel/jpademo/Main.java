package ua.hillel.jpademo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import ua.hillel.jpademo.model.entity.Address;
import ua.hillel.jpademo.model.entity.Customer;
import ua.hillel.jpademo.model.entity.Item;
import ua.hillel.jpademo.repo.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("webstore");
        EntityManager entityManager = factory.createEntityManager();

        try {


            CustomerRepo repo = new CustomerJpaRepo(entityManager);

            ItemRepo itemRepo = new ItemJpaRepo(entityManager);
            OrderRepo orderRepo = new OrderJpaRepo(entityManager);


            Customer customer = new Customer();
            customer.setEmail("jane@mail.com");
            customer.setName("Jane Doe");

            Address address = new Address();
            address.setZipCode("04000");
            address.setNumber(12);
            address.setCity("Samplecity");
            address.setCountry("USA");
            address.setStreet("Samplestr.");
            customer.setAddress(address);
            repo.addCustomer(customer);

            Customer byId = repo.getById(1);

            List<Item> items = itemRepo.getAll();

            orderRepo.createOrder(byId, items);

            System.out.println();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            factory.close();
            entityManager.close();
        }

        System.out.println("Hello world!");
    }
}