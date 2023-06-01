package com.arc.springbootblogarc.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private Long id;

    @NotEmpty(message = "Please enter a title.")
    private String title;

    private String url;

    @NotEmpty(message = "Please enter some content for the post.")
    private String content;

    @NotEmpty(message = "Please enter a short description.")
    private String shortDescription;

    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
