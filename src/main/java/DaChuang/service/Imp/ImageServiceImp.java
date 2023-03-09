package DaChuang.service.Imp;

import DaChuang.mapper.ImageMapper;
import DaChuang.pojo.Image;
import DaChuang.service.ImageService;

import java.util.List;

public class ImageServiceImp implements ImageService {

    private ImageMapper imageMapper;

    public void setImageMapper(ImageMapper imageMapper) {
        this.imageMapper = imageMapper;
    }

    @Override
    public int addImg(Image img) {
        return imageMapper.addImg(img);
    }

    @Override
    public List<String> selectImgById(int carId) {
        return imageMapper.selectImgById(carId);
    }
}
