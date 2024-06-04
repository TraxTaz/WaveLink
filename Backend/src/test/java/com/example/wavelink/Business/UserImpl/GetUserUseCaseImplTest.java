package com.example.wavelink.Business.UserImpl;

import com.example.wavelink.Domain.User;
import com.example.wavelink.Domain.UserRR.CreateUserRequest;
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

class GetUserUseCaseImplTest {
    private UserRepository userRepoMock;
    private GetUserUseCaseImpl getUserUseCase;
    private CreateUserUseCaseImpl createUserUseCase;

    @BeforeEach
    public void setUp(){
        userRepoMock = mock (UserRepository.class);
        getUserUseCase = new GetUserUseCaseImpl(userRepoMock);
        createUserUseCase = new CreateUserUseCaseImpl(userRepoMock);
    }

    @Test
    void getUser(){

        CreateUserRequest request = new CreateUserRequest("Meda", "12345678");
        createUserUseCase.createUser(request);

        Optional<User> user = getUserUseCase.getUserByID(1L);

        assertEquals(1, user.get().getId());
    }
}