package com.example.wavelink.Business.UserImpl;

import com.example.wavelink.Business.UserInterface.DeleteUserUseCase;
import com.example.wavelink.Persistence.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class DeleteUserUseCaseImpl implements DeleteUserUseCase {
    private UserRepository userRepo;

    @Transactional
    @Override
    public void deleteUserByID(Long id) {
        this.userRepo.deleteById(id);
    }
}
