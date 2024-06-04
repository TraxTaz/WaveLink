package com.example.wavelink.Persistence;

import com.example.wavelink.Persistence.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<UserEntity, Long> {
    boolean existsByUsername(String userName);
    UserEntity findByUsername(String userName);

    

}
