package DaChuang.pojo;

import lombok.Data;

import java.util.List;

@Data
public class JsonCar {
    String stat;
    Integer carId;
    String carNum;
    String points;
    Integer carTime;
    List<String> img;
}
