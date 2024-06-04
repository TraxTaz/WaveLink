package com.example.wavelink.Business.PostInterface;

import com.example.wavelink.Domain.PostRR.CreatePostRequest;
import com.example.wavelink.Domain.PostRR.CreatePostResponse;

public interface CreatePostUseCase {

    CreatePostResponse createPost(CreatePostRequest request5);
}
