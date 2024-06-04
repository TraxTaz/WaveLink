package com.example.wavelink.Domain.PostRR;

import com.example.wavelink.Domain.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class GetPostsResponse {
    private List<Post> posts;
}
