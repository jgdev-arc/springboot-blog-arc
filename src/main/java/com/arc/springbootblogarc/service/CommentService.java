package com.arc.springbootblogarc.service;

import com.arc.springbootblogarc.dto.CommentDTO;

import java.util.List;

public interface CommentService {

    void createComment(String postUrl, CommentDTO commentDTO);

    List<CommentDTO> findAllComments();

    void deleteComment(Long commentId);
}
