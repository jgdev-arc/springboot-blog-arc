package com.arc.springbootblogarc.service;

import com.arc.springbootblogarc.dto.PostDTO;

import java.util.List;

public interface PostService {
    List<PostDTO> findAllPosts();
}
