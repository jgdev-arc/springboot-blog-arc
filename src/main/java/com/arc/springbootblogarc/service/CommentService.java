package com.arc.springbootblogarc.service;

import com.arc.springbootblogarc.dto.CommentDTO;

public interface CommentService {

    void createComment(String postUrl, CommentDTO commentDTO);
}
