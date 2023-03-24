package ua.hillel.jpademo.repo;

import ua.hillel.jpademo.model.entity.Item;

import java.util.List;

public interface ItemRepo {
    Item add(Item item);
    List<Item> getAll();
}
