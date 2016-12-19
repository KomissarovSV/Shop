package shop.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import shop.entity.Position;
import java.util.Set;

@Data
@JsonIgnoreProperties
public class BookBody {

    private String phone;
    private Set<Position> positions;
}
