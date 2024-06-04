package com.example.wavelink.Business.UserImpl;

import com.example.wavelink.Business.UserInterface.GetUsersUseCase;
import com.example.wavelink.Domain.User;
import com.example.wavelink.Domain.UserRR.GetUsersResponse;
import com.example.wavelink.Persistence.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import static java.util.Arrays.stream;

@Service
@AllArgsConstructor
public class GetUsersUseCaseImpl implements GetUsersUseCase {
    private UserRepository userRepo;

    @Transactional
    @Override
    public GetUsersResponse getUsers() {
        List<User> users = userRepo.findAll()
                .stream()
                .map(UserConverter:: convert)
                .toList();
        return GetUsersResponse.builder()
                .users(users)
                .build();
    }
}
