package com.banghand.cloud.web;

import com.banghand.cloud.contentservice.client.ContentClient;
import com.banghand.cloud.contentservice.dto.ContentDto;
import com.banghand.cloud.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ContentDto create(@RequestBody ContentDto contentDto) {
        return contentClient.create(contentDto);
    }

    @PutMapping(value = "content")
    public ContentDto update(@RequestBody ContentDto contentDto) {
        return contentClient.update(contentDto);
    }

    @GetMapping(value = "content/list")
    public List<ContentDto> list(){
        return contentClient.list();
    }

    @DeleteMapping(value = "content")
    public void del(@RequestParam(value = "id") Long id) {
        contentClient.del(id);
    }

    @GetMapping(value = "content/page")
    public Page<ContentDto> page(@RequestParam(value = "title",required = false) String title,@RequestParam(value = "status",required = false) String status ,@RequestParam(value = "page",defaultValue = "1") Integer page, @RequestParam(value = "row",defaultValue = "10") Integer row){
        return contentClient.page(title,status,page,row);
    }

}
