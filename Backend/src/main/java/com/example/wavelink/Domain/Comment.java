package com.example.wavelink.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.*;


@Data
@AllArgsConstructor
@Builder
public class Comment {

    private Long id;
    private User user;
    private String message;
    private Date date;
}
