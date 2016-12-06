package shop.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer count;

    private Double cost;

    @OneToMany(mappedBy = "order")
    private List<OrderProduct> orderProducts;
}
