package DaChuang.service;

import DaChuang.pojo.Car;
import DaChuang.pojo.JsonCar;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface CarService {

    int addCar(Car car) throws IOException;

    int delCarById(Integer id);

    List<JsonCar> selectCar();
}
