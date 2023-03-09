package DaChuang.mapper;

import DaChuang.pojo.Car;
import DaChuang.pojo.JsonCar;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CarMapper {

    int addCar(Car car);

    int delCarById(Integer id);

    List<JsonCar> selectCar();
}
