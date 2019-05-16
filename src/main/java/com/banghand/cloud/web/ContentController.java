package com.banghand.cloud.web;

import com.banghand.cloud.contentservice.client.ContentClient;
import com.banghand.cloud.contentservice.dto.ContentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author sunyz
 * @desc
 * @create 2019-05-16 上午9:24
 */
@RestController
public class ContentController {


    @Autowired
    private ContentClient contentClient;

    @PostMapping(value = "content")
    public ContentDto create(ContentDto contentDto) {
        return contentClient.create(contentDto);
    }

    @PutMapping(value = "content")
    public ContentDto update(ContentDto contentDto) {
        return contentClient.update(contentDto);
    }

    @GetMapping(value = "content/list")
    public List<ContentDto> list(){
        return contentClient.list();
    }
}
