package com.example.wavelink.Business.UserImpl;

import com.example.wavelink.Domain.User;
import com.example.wavelink.Domain.UserRR.CreateUserRequest;
import com.example.wavelink.Persistence.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class DeleteUserUseCaseImplTest {

    private UserRepository userRepoMock;
    private DeleteUserUseCaseImpl deleteUserUseCase;
    private CreateUserUseCaseImpl createUserUseCase;
    private GetUsersUseCaseImpl getUsersUseCase;

    @BeforeEach
    public void setUp(){
        userRepoMock = mock (UserRepository.class);
        deleteUserUseCase = new DeleteUserUseCaseImpl(userRepoMock);
        createUserUseCase = new CreateUserUseCaseImpl(userRepoMock);
        getUsersUseCase = new GetUsersUseCaseImpl(userRepoMock);
    }

    @Test
    void deleteUser() {
        userRepoMock.deleteAll();
        CreateUserRequest request = new CreateUserRequest("Meda", "123123123");
        CreateUserRequest request2 = new CreateUserRequest("Colin", "234234291");
        createUserUseCase.createUser(request);
        createUserUseCase.createUser(request2);

        deleteUserUseCase.deleteUserByID(2L);

        List<User> users = getUsersUseCase.getUsers().getUsers();

        assertEquals(1, users.size());
    }
}