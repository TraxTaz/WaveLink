package com.example.wavelink.Business.UserImpl;

import com.example.wavelink.Business.Exceptions.UserNotFoundException;
import com.example.wavelink.Business.UserInterface.UpdateUserInfoUseCase;
import com.example.wavelink.Domain.UserRR.UpdateUserRequest;
import com.example.wavelink.Persistence.Entity.UserEntity;
import com.example.wavelink.Persistence.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UpdateUserInfoUseCaseImpl implements UpdateUserInfoUseCase {

    private UserRepository userRepo;

    @Transactional
    @Override
    public void updateUser(UpdateUserRequest request) {
        Optional<UserEntity> optionalUser = userRepo.findById(request.getId());

        if (optionalUser.isEmpty()){
            throw new UserNotFoundException("User Not Found");
        }

        UserEntity user = optionalUser.get();
        updateFields(request, user);

    }

    private void updateFields(UpdateUserRequest request, UserEntity user){
        Optional<UserEntity> optionalUser = userRepo.findById(request.getId());

        user.setUsername(request.getUserName());

        userRepo.save(user);
    }
}
