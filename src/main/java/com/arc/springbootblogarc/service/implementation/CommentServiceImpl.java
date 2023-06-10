package com.arc.springbootblogarc.service.implementation;

import com.arc.springbootblogarc.dto.CommentDTO;
import com.arc.springbootblogarc.entity.Comment;
import com.arc.springbootblogarc.entity.Post;
import com.arc.springbootblogarc.mapper.CommentMapper;
import com.arc.springbootblogarc.repository.CommentRepository;
import com.arc.springbootblogarc.repository.PostRepository;
import com.arc.springbootblogarc.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void createComment(String postUrl, CommentDTO commentDTO) {

        Post post = postRepository.findByUrl(postUrl).get();
        Comment comment = CommentMapper.mapToComment(commentDTO);
        comment.setPost(post);
        commentRepository.save(comment);

    }

    @Override
    public List<CommentDTO> findAllComments() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream()
                .map(CommentMapper::mapToCommentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
