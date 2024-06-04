package com.example.wavelink.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.*;

@Data
@Builder
@AllArgsConstructor
public class Post {

    private Long id;
    private User user;
    private List<Comment> comments;
    private LocalDate date;
    private String description;
}
