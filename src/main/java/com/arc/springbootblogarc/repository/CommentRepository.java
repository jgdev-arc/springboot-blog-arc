package com.arc.springbootblogarc.repository;

import com.arc.springbootblogarc.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
