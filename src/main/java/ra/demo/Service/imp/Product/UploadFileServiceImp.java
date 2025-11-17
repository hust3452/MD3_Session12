package ra.demo.Service.imp.Product;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ra.demo.Service.UploadFileService;

import java.util.Map;

@Service
public class UploadFileServiceImp implements UploadFileService {
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public String uploadFile(MultipartFile image) {
        String originalFilename = image.getOriginalFilename();

        if (originalFilename != null && originalFilename.contains(".")){
            originalFilename = originalFilename.substring(0,originalFilename.lastIndexOf("."));
        }

        Map cloudiaryParams = ObjectUtils.asMap("public_id",originalFilename);
        Map cloudResult = null;
        try{
            cloudResult = cloudinary.uploader().upload(image.getBytes(),cloudiaryParams);

        }catch (Exception e){
            e.printStackTrace();
        }
        return cloudResult.get("url").toString();
    }
}
