package com.arc.springbootblogarc.mapper;

import com.arc.springbootblogarc.dto.PostDTO;
import com.arc.springbootblogarc.entity.Post;

public class PostMapper {

    public static PostDTO mapToPostDTO(Post post) {
        return PostDTO.builder()
                .id(post.getId())
                .title(post.getTitle())
                .url(post.getUrl())
                .content(post.getContent())
                .shortDescription(post.getShortDescription())
                .createdOn(post.getCreatedOn())
                .updatedOn(post.getUpdatedOn())
                .build();
    }

    public static Post mapToPost(PostDTO postDTO) {
        return Post.builder()
                .id(postDTO.getId())
                .title(postDTO.getTitle())
                .content(postDTO.getContent())
                .url(postDTO.getUrl())
                .shortDescription(postDTO.getShortDescription())
                .createdOn(postDTO.getCreatedOn())
                .updatedOn(postDTO.getUpdatedOn())
                .build();
    }
}
