package DaChuang.service;

import DaChuang.pojo.Image;

import java.util.List;

public interface ImageService {
    int addImg(Image img);

    List<String> selectImgById(int carId);
}
