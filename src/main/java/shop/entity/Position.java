package shop.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import shop.common.PositionDeserializer;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer count;

    private Double cost;

    @OneToOne
    private Product product;

    @ManyToOne
    @JoinColumn
    private Order order;
}
