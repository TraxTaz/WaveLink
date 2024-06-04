package com.example.wavelink.Business.UserInterface;

import com.example.wavelink.Domain.User;

import java.util.Optional;

public interface GetUserUseCase {
    Optional<User> getUserByID(Long userID);
}
