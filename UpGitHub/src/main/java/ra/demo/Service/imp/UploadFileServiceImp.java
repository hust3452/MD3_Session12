package ra.demo.Service.imp;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ra.demo.Service.UploadFileService;

import java.io.IOException;
import java.util.Map;

@Service
public class UploadFileServiceImp implements UploadFileService {
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public String uploadFile(MultipartFile travelImage) {
//        String originalFilename = travelImage.getOriginalFilename();
//
//        if (originalFilename != null && !originalFilename.contains(".")) {
//            originalFilename = originalFilename.substring(0, originalFilename.lastIndexOf("."));
//
//        }
//            Map cloudiaryParams = ObjectUtils.asMap("public_id", originalFilename);
//            Map cloudResult = null;
//            try {
//                cloudResult = cloudinary.uploader().upload(travelImage.getBytes(), cloudiaryParams);
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return cloudResult.get("url").toString();
//        }
        try {
            Map<String,Object> rs = cloudinary.uploader().upload(travelImage.getBytes(), ObjectUtils.emptyMap());
            return rs.get("url").toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    }
