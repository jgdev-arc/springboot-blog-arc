package com.arc.springbootblogarc.service.implementation;

import com.arc.springbootblogarc.dto.PostDTO;
import com.arc.springbootblogarc.entity.Post;
import com.arc.springbootblogarc.mapper.PostMapper;
import com.arc.springbootblogarc.repository.PostRepository;
import com.arc.springbootblogarc.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<PostDTO> findAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(PostMapper::mapToPostDTO)
                .collect(Collectors.toList());
    }
}