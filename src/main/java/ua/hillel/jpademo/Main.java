package ua.hillel.jpademo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import ua.hillel.jpademo.model.entity.Address;
import ua.hillel.jpademo.model.entity.Customer;
import ua.hillel.jpademo.repo.CustomerJpaRepo;
import ua.hillel.jpademo.repo.CustomerRepo;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("webstore");
        EntityManager entityManager = factory.createEntityManager();

        try {


            CustomerRepo repo = new CustomerJpaRepo(entityManager);

            Customer customer = new Customer();
            customer.setEmail("mail@maiul.com");
            customer.setName("John Doe");

            Address address = new Address();
            address.setZipCode("04000");
            address.setNumber(1);
            address.setCity("City");
            address.setCountry("Country");
            address.setStreet("Stere");

            repo.addCustomer(customer);

            Customer byId = repo.getById(1);
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