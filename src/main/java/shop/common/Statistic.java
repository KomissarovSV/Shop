package shop.common;

import lombok.Data;
import shop.entity.Product;

@Data
public class Statistic {

    private Product product;

    private int count;

    private double cost;
}
