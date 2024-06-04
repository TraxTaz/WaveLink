package com.example.wavelink.Business.PostInterface;

import com.example.wavelink.Domain.Post;

import java.util.Optional;

public interface GetPostUseCase {
    Optional<Post> getPostByID(Long postID);
}
