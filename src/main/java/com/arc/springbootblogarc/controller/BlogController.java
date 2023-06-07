package com.arc.springbootblogarc.controller;

import com.arc.springbootblogarc.dto.PostDTO;
import com.arc.springbootblogarc.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BlogController {

    private PostService postService;

    @Autowired
    public BlogController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String viewBlogPosts(Model model) {
        List<PostDTO> postsResponse = postService.findAllPosts();
        model.addAttribute("postsResponse", postsResponse);
        return "blog/view_posts";
    }

    @GetMapping("/post/{postUrl}")
    private String showPost(@PathVariable("postUrl") String postUrl,
                            Model model) {
        PostDTO post = postService.findPostByUrl(postUrl);
        model.addAttribute("post", post);
        return "blog/blog_post";
    }

    @GetMapping("/page/search")
    public String searchPosts(@RequestParam(value = "query") String query,
                              Model model) {
        List<PostDTO> postsResponse = postService.searchPosts(query);
        model.addAttribute("postsResponse", postsResponse);
        return "blog/view_posts";
    }
}
