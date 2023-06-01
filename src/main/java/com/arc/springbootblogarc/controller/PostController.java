package com.arc.springbootblogarc.controller;

import com.arc.springbootblogarc.dto.PostDTO;
import com.arc.springbootblogarc.service.PostService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/admin/posts")
    public String posts(Model model) {
        List<PostDTO> posts = postService.findAllPosts();
        model.addAttribute("posts", posts);
        return "/admin/posts";
    }

    @GetMapping("admin/posts/newpost")
    public String newPostForm(Model model) {
        PostDTO postDTO = new PostDTO();
        model.addAttribute("post", postDTO);
        return "/admin/create_post";
    }

    @PostMapping("/admin/posts")
    public String createPost(@Valid @ModelAttribute("post") PostDTO postDTO,
                             BindingResult bindingResult,
                             Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("post", postDTO);
            return "admin/create_post";
        }
        postDTO.setUrl(getUrl(postDTO.getTitle()));
        postService.createPost(postDTO);
        return "redirect:/admin/posts";
    }

    private static String getUrl(String postTitle) {
        String title = postTitle.trim().toLowerCase();
        String url = title.replaceAll("\\s+", "-");
        url = url.replaceAll("[^A-Za-z0-0]", "-");
        return url;
    }
}
