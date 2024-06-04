package com.example.wavelink.Controller;

import com.example.wavelink.Business.UserInterface.*;
import com.example.wavelink.Domain.User;
import com.example.wavelink.Domain.UserRR.CreateUserRequest;
import com.example.wavelink.Domain.UserRR.CreateUserResponse;
import com.example.wavelink.Domain.UserRR.GetUsersResponse;
import com.example.wavelink.Domain.UserRR.UpdateUserRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/users")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:5174")
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final GetUsersUseCase getUsersUseCase;
    private final GetUserUseCase getUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private final UpdateUserInfoUseCase updateUserInfoUseCase;

    @PostMapping
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody @Valid CreateUserRequest request){
        CreateUserResponse response = createUserUseCase.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<GetUsersResponse> getUsers(){
        return ResponseEntity.ok(getUsersUseCase.getUsers());
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUser(@PathVariable(value = "id") Long id){
        Optional<User> userOptional = getUserUseCase.getUserByID(id);
        return ResponseEntity.ok().body(userOptional.get());
    }

    @DeleteMapping({"id"})
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        deleteUserUseCase.deleteUserByID(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateUser(@PathVariable(value = "id") @Valid Long id,@RequestBody UpdateUserRequest request){
        request.setId(id);
        updateUserInfoUseCase.updateUser(request);

        return ResponseEntity.noContent().build();
    }
}
