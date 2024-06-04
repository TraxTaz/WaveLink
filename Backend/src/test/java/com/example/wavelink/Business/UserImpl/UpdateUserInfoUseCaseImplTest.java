package com.example.wavelink.Business.UserImpl;

import com.example.wavelink.Domain.User;
import com.example.wavelink.Domain.UserRR.CreateUserRequest;
import com.example.wavelink.Domain.UserRR.UpdateUserRequest;
import com.example.wavelink.Persistence.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class UpdateUserInfoUseCaseImplTest {
    private UserRepository userRepoMock;
    private CreateUserUseCaseImpl createUserUseCase;
    private UpdateUserInfoUseCaseImpl updateUserInfoUseCase;
    private GetUserUseCaseImpl getUserUseCase;

    @BeforeEach
    public void setUp(){
        userRepoMock = mock (UserRepository.class);
        createUserUseCase = new CreateUserUseCaseImpl(userRepoMock);
        updateUserInfoUseCase = new UpdateUserInfoUseCaseImpl(userRepoMock);
        getUserUseCase = new GetUserUseCaseImpl(userRepoMock);
    }

    @Test
    void updateUserInfo(){
        CreateUserRequest request = new CreateUserRequest("Dimi", "098");
        createUserUseCase.createUser(request);

        Optional<User> user = getUserUseCase.getUserByID(1L);

        UpdateUserRequest updateUserRequest = new UpdateUserRequest(1L, "Dimitar", "098765");

        updateUserInfoUseCase.updateUser(updateUserRequest);

        assertEquals(getUserUseCase.getUserByID(1L).get().getUserName(), updateUserRequest.getUserName());
    }
}