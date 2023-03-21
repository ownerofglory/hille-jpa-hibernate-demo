package ua.hillel.jpademo.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "order")
public class Order {
    @Id
    private Integer id;
    private LocalDateTime dateTime;
}
