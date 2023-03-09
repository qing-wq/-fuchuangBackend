package DaChuang.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Car implements Serializable {
    String stat;
    Integer carId;
    String carNum;
    Integer carTime;
    String points;
}
