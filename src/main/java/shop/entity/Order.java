package shop.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity(name = "OrderTable")
@ToString(exclude = "orderPositions")
@EqualsAndHashCode(exclude = "orderPositions")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime date;

    private Double cost;

    @OneToMany(mappedBy = "order",cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private Set<Position> orderPositions;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
