package shop.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer count;

    private Double cost;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns={ @JoinColumn(name="product_id", referencedColumnName="id") },
            inverseJoinColumns={ @JoinColumn(name="position_id", referencedColumnName="id")})
    private List<Product> products;

    @ManyToOne
    @JoinColumn
    private Order order;
}
