package com.arc.springbootblogarc.controller;

import com.arc.springbootblogarc.dto.PostDTO;
import com.arc.springbootblogarc.service.PostService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("admin/posts/{postId}/edit")
    public String editPostForm(@PathVariable("postId") Long postId,
                               Model model) {
        PostDTO postDTO = postService.findPostById(postId);
        model.addAttribute("post", postDTO);
        return "admin/edit_post";
    }

    @PostMapping("/admin/posts/{postId}")
    public String updatePost(@PathVariable("postId") Long postId,
                             @Valid @ModelAttribute("post") PostDTO post,
                             BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            model.addAttribute("post", post);
            return "admin/edit_post";
        }

        post.setId(postId);
        postService.updatePost(post);
        return "redirect:/admin/posts";
    }

    @GetMapping("admin/posts/{postId}/delete")
    public String deletePost(@PathVariable("postId") Long postId) {
        postService.deletePost(postId);
        return "redirect:/admin/posts";
    }

    @GetMapping("admin/posts/{postUrl}/view")
    public String viewPost(@PathVariable("postUrl") String postUrl,
                           Model model) {
        PostDTO postDTO = postService.findPostByUrl(postUrl);
        model.addAttribute("post", postDTO);
        return "admin/view_post";
    }

    @GetMapping("/admin/posts/search")
    public String searchPosts(@RequestParam(value = "query") String query,
                              Model model) {
        List<PostDTO> posts = postService.searchPosts(query);
        model.addAttribute("posts", posts);
        return "admin/posts";
    }

}
