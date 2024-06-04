package com.example.wavelink.Business.UserImpl;

import com.example.wavelink.Business.Exceptions.UserExistsException;
import com.example.wavelink.Domain.User;
import com.example.wavelink.Domain.UserRR.CreateUserRequest;
import com.example.wavelink.Domain.UserRR.CreateUserResponse;
import com.example.wavelink.Persistence.Entity.UserEntity;
import com.example.wavelink.Persistence.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class CreateUserUseCaseImplTest {

    @Mock
    private UserRepository userRepoMock;
    private CreateUserUseCaseImpl createUserUseCase;

    @BeforeEach
    public void setUp(){
        createUserUseCase = new CreateUserUseCaseImpl(userRepoMock);
    }
    @Test
    void createUser(){

        CreateUserRequest request = new CreateUserRequest(1L, "Meda", "12345678");
        UserEntity savedUser = UserEntity
                .builder()
                .id(1L)
                .username(request.getUserName())
                .password(request.getPassword())
                .build();

        when(userRepoMock.save(savedUser)).thenReturn(savedUser);

        CreateUserResponse response = createUserUseCase.createUser(request);

        assertEquals(1, response.getId());
    }
    @Test
    void createUserButUserExists(){
        CreateUserRequest request = new CreateUserRequest("cool", "23532523");

        UserEntity mockedSavedUser = UserEntity.builder()
                .username(request.getUserName())
                .password(request.getPassword())
                .build();

        when(userRepoMock.save(mockedSavedUser)).thenReturn(mockedSavedUser);

        createUserUseCase.createUser(request);

        CreateUserRequest request2 = new CreateUserRequest("cool", "434256");

        assertThrows(UserExistsException.class, () -> createUserUseCase.createUser(request2));
    }
}
