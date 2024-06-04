package com.example.wavelink.Business.UserImpl;

import com.example.wavelink.Domain.User;
import com.example.wavelink.Persistence.Entity.UserEntity;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserConverter {

    public static User convert(UserEntity user){
        return User.builder()
                .id(user.getId())
                .password(user.getPassword())
                .userName(user.getUsername())
                .build();
    }
}
