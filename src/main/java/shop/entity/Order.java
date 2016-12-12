package shop.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "OrderTable")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST)
    private List<Position> orderPositions;

    @ManyToOne
    private User user;
}
