package com.science.controller;

import com.science.service.PostService;
import com.science.vo.response.PostVo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: Post 控制层
 * @Author: Cauchy
 * @CreateTime: 2022/10/6
 */
@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("api/post")
public class PostController {

    PostService postService;

    /**
     * 热度前 20 榜单
     *
     * @return PostVo 列表
     */
    @RequestMapping("/getTop20HotPost")
    public ResponseEntity<List<PostVo>> getTop20HotPost() {
        List<PostVo> postVoList = postService.getTop20HotPost();
        return new ResponseEntity<>(postVoList, HttpStatus.OK);
    }
}
