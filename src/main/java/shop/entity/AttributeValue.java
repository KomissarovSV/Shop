package shop.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class AttributeValue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Attribute attribute;

    private String value;

    public AttributeValue(Attribute attribute, String value){
        this.attribute = attribute;
        this.value = value;
    }

}
