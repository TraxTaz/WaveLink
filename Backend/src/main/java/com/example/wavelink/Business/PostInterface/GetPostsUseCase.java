package com.example.wavelink.Business.PostInterface;

import com.example.wavelink.Domain.Post;
import com.example.wavelink.Domain.PostRR.GetPostsResponse;

import java.util.Optional;

public interface GetPostsUseCase {
    GetPostsResponse getPosts();
}
