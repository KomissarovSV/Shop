package shop.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany()
    @JoinColumn(name = "id")
    private List<Product> products;

    @ManyToOne
    private Order order;
}
