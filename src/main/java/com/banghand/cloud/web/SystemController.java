package com.banghand.cloud.web;

import com.banghand.cloud.vo.LoginParam;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author sunyz
 * @desc
 * @create 2019-05-27 上午11:03
 */
@RestController
@RequestMapping(value = "system")
public class SystemController {

    @PostMapping(value = "login")
    public LoginParam login(@RequestBody LoginParam param) {
        System.out.println("login : " + param.getUserName());
        return param;
    }

    @PostMapping(value = "upload")
    public List<String> upload(HttpServletRequest request) {

        List<String> filePaths=new ArrayList<>();

        StandardMultipartHttpServletRequest sRequest = (StandardMultipartHttpServletRequest) request;

        Iterator<String> iterator = sRequest.getFileNames();

        while (iterator.hasNext()) {

            MultipartFile file = sRequest.getFile(iterator.next());

            if (file != null) {
                String filename = file.getOriginalFilename();
                Configuration configuration = new Configuration(Zone.autoZone());
                UploadManager uploadManager = new UploadManager(configuration);
                Auth auth = Auth.create("n0vld1P3Kntj0k0HWF6RWoQBVmqxwvBA2RnWUod4", "8JV4YAzE8LW2900R3QaXm0jGFosInArpxzjuRQBD");
                String token = auth.uploadToken("bh-cloud");
                try {
                    Response r = uploadManager.put(file.getBytes(), file.getOriginalFilename(), token);
                } catch (QiniuException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String filePath = "http://img.banghand.com/" + filename;
                filePaths.add(filePath);
            }
        }

        return filePaths;
    }

}
