package com.example.wavelink.Repository;


import com.example.wavelink.Persistence.Entity.UserEntity;
import com.example.wavelink.Persistence.UserRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    void save_shouldSaveUserWithAllFields(){
        UserEntity user = UserEntity.builder()
                .username("Meda")
                .password("12341234")
                .build();

        UserEntity savedUser = userRepository.save(user);
        assertNotNull(savedUser.getId());

        savedUser = entityManager.find(UserEntity.class, savedUser.getId());

        UserEntity expectedUser = UserEntity.builder()
                .id(savedUser.getId())
                .username("Meda")
                .password("12341234")
                .build();

        assertEquals(expectedUser, savedUser);
    }

    @Test
    void findByUsername_shouldFindUserByUsername(){
        UserEntity user = UserEntity.builder()
                .username("Trax")
                .password("123456789")
                .build();

        UserEntity savedUser = userRepository.save(user);
        assertNotNull(savedUser.getId());

        UserEntity expectedUser = userRepository.findByUsername("Trax");

        assertEquals(expectedUser, savedUser);
    }

    @Test
    void findAll_findsAllUsers(){

        UserEntity user = UserEntity.builder()
                .username("Trax")
                .password("123456789")
                .build();

        userRepository.save(user);

        UserEntity newUser = UserEntity.builder()
                .username("Meda")
                .password("12341234")
                .build();

        userRepository.save(newUser);

        List<UserEntity> users = new ArrayList<UserEntity>();

        users = userRepository.findAll();

        int lengthOfList = users.size();

        assertEquals(2, lengthOfList);
    }
}
