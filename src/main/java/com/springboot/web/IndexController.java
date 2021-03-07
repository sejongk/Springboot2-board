package com.springboot.web;

import com.springboot.services.posts.PostsService;
import com.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor // final이 붙은 변수들을 초기화해주는 내용을 가지는 IndexController 생성자 주입
@Controller
public class IndexController {

    private final PostsService postsService;

    //RequiredArgsConstructor 어노테이션 사용 시 아래 생성자가 자동 주입
    /*
    public IndexController(PostsService postsService){
        this.postsService = postsService;
    }
     */

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }
    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }
}