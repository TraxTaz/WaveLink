package com.example.wavelink.Business.UserImpl;

import com.example.wavelink.Business.Exceptions.UserExistsException;
import com.example.wavelink.Business.UserInterface.CreateUserUseCase;
import com.example.wavelink.Domain.UserRR.CreateUserRequest;
import com.example.wavelink.Domain.UserRR.CreateUserResponse;
import com.example.wavelink.Persistence.Entity.UserEntity;
import com.example.wavelink.Persistence.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@AllArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private final UserRepository userRepo;

    @Transactional
    @Override
    public CreateUserResponse createUser(CreateUserRequest request) {
        if (userRepo.existsByUsername(request.getUserName())){
            throw new UserExistsException();
        }

        UserEntity newUser = UserEntity.builder()
                .username(request.getUserName())
                .password(request.getPassword())
                .build();

        userRepo.save(newUser);

        return CreateUserResponse.builder()
                .id(newUser.getId())
                .build();
    }
}
