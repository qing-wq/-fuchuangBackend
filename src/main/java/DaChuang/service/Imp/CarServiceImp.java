package DaChuang.service.Imp;

import DaChuang.mapper.CarMapper;
import DaChuang.mapper.ImageMapper;
import DaChuang.pojo.Car;
import DaChuang.pojo.JsonCar;
import DaChuang.service.CarService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImp implements CarService {

    private CarMapper carMapper;

    public void setCarMapper(CarMapper carMapper) {
        this.carMapper = carMapper;
    }

    @Override
    public int addCar(Car car) {

        return carMapper.addCar(car);
    }

    @Override
    public int delCarById(Integer id) {
        return 0;
    }

    @Override
    public List<JsonCar> selectCar() {
        return carMapper.selectCar();
    }
}

