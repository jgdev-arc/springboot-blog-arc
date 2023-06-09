package com.arc.springbootblogarc.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDTO {
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty(message = "Please enter your email address.")
    @Email
    private String email;

    @NotEmpty(message = "Please enter a comment.")
    private String content;

    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

}
