package com.example.wavelink.Business.UserImpl;

import com.example.wavelink.Business.UserInterface.GetUserUseCase;
import com.example.wavelink.Domain.User;
import com.example.wavelink.Domain.UserRR.GetUsersResponse;
import com.example.wavelink.Persistence.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GetUserUseCaseImpl implements GetUserUseCase {

    private UserRepository userRepo;

    @Transactional
    @Override
    public Optional<User> getUserByID(Long userID) {
        return userRepo.findById(userID).map(UserConverter:: convert);
    }
}
