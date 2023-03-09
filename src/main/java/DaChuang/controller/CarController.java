package DaChuang.controller;

import DaChuang.pojo.Car;
import DaChuang.pojo.Image;
import DaChuang.pojo.JsonCar;
import DaChuang.service.Imp.CarServiceImp;
import DaChuang.service.Imp.ImageServiceImp;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarServiceImp carService;

    @Autowired
    private ImageServiceImp imageService;

    // 将json数据存入数据库
    @RequestMapping("/add")
    public void add() {
        // 读取json文件
        File jsonFile = new File("/home/qing/JavaProject/reermake/src/main/resources/testData2.json");
        StringBuilder content = new StringBuilder();
        BufferedReader bufferedReader = null;
        String jsonStr = "";
        JsonCar jsonCar;
        try {
            bufferedReader = new BufferedReader(new FileReader(jsonFile));
            String tempStr = "";
            while ((tempStr = bufferedReader.readLine()) != null) {
                content.append(tempStr);
            }
            jsonStr = content.toString();
            bufferedReader.close();
            ObjectMapper mapper = new ObjectMapper();
            // 获取json数据
            jsonCar = mapper.readValue(jsonStr, JsonCar.class);
            Car car = mapper.readValue(jsonStr, Car.class);
            // 存入car
            int i = carService.addCar(car);
            System.out.println(i > 0 ? "car insert success" : "car insert false");
            int imgSize = jsonCar.getImg().size();
            if (imgSize != 0) {
                for (String imgStr : jsonCar.getImg()) {
                    Image image = new Image(imgStr, jsonCar.getCarId());
                    // 存入img
                    int j = imageService.addImg(image);
                    System.out.println(j > 0 ? "image insert success" : "image insert false");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 查询数据
    @RequestMapping("/img")
    @ResponseBody
    public String json(){
        List<JsonCar> jsonCars = carService.selectCar();
        ObjectMapper mapper = new ObjectMapper();
        String str = "";
        try {
            str = mapper.writeValueAsString(jsonCars);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return str;
    }
}

