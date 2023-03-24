package ua.hillel.jpademo.repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import ua.hillel.jpademo.model.entity.Item;

import java.util.List;

public class ItemJpaRepo implements ItemRepo {
    private EntityManager entityManager;

    public ItemJpaRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Item add(Item item) {
        entityManager.getTransaction().begin();
        entityManager.persist(item);

        entityManager.flush();
        entityManager.getTransaction().commit();
        return item;
    }

    @Override
    public List<Item> getAll() {
        TypedQuery<Item> query = entityManager.createQuery("SELECT i FROM Item i", Item.class);
        List<Item> resultList = query.getResultList();
        return resultList;
    }
}
