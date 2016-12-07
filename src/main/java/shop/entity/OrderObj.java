package shop.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class OrderObj {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "order")
    private List<Position> orderPositions;
}
