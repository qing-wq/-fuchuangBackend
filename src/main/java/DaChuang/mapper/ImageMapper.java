package DaChuang.mapper;

import DaChuang.pojo.Image;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ImageMapper {
    int addImg(Image img);

    List<String> selectImgById(int carId);
}
