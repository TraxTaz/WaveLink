package com.example.wavelink.Business.UserInterface;

import com.example.wavelink.Domain.UserRR.CreateUserRequest;
import com.example.wavelink.Domain.UserRR.CreateUserResponse;

public interface CreateUserUseCase {

    CreateUserResponse createUser (CreateUserRequest request);
}
