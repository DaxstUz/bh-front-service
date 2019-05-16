package com.banghand.cloud.web;

import com.banghand.cloud.user.client.ResumeClient;
import com.banghand.cloud.user.dto.ResumeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author sunyz
 * @desc 用户信息
 * @create 2019-04-18 上午10:03
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private ResumeClient resumeClient;

    @GetMapping(value = "resume")
    public ResumeDto getResume(){
        return resumeClient.getById(1L);
    }

    @PostMapping(value = "resume")
    public ResumeDto addResume(@RequestBody ResumeDto obj){
        return resumeClient.addObject(obj);
    }


}
