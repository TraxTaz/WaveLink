package com.example.wavelink.Business.UserImpl;

import com.example.wavelink.Domain.User;
import com.example.wavelink.Domain.UserRR.CreateUserRequest;
import com.example.wavelink.Domain.UserRR.GetUsersResponse;
import com.example.wavelink.Persistence.Entity.UserEntity;
import com.example.wavelink.Persistence.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(SpringExtension.class)
class GetUsersUseCaseImplTest {

    @Mock
    private UserRepository userRepoMock;
    private GetUsersUseCaseImpl getUsersUseCase;
    private CreateUserUseCaseImpl createUserUseCase;

    @BeforeEach
    public void setUp(){
        getUsersUseCase = new GetUsersUseCaseImpl(userRepoMock);
        createUserUseCase = new CreateUserUseCaseImpl(userRepoMock);
    }

    @Test
    void getUsers(){

        CreateUserRequest request = new CreateUserRequest("Meda", "123762814");

        UserEntity savedUser = UserEntity.builder()
                .username(request.getUserName())
                .password(request.getPassword())
                .build();


        createUserUseCase.createUser(request);

        GetUsersResponse response = new GetUsersResponse(getUsersUseCase.getUsers().getUsers());

        when(userRepoMock.findAll()).thenReturn(List.of(savedUser));

        List<User> users = response.getUsers();

        assertEquals(1, users.size());

        verify(userRepoMock.findAll());
        verify(userRepoMock.save(savedUser));
    }

}