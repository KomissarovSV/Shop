package shop.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Double cost;

    private String description;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinTable(joinColumns={ @JoinColumn(name="att_id", referencedColumnName="id") },
            inverseJoinColumns={ @JoinColumn(name="product_id", referencedColumnName="id") }
            )
    private List<AttributeValue> attributeValues;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

}
