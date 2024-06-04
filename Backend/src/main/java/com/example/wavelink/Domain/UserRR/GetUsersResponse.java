package com.example.wavelink.Domain.UserRR;

import com.example.wavelink.Domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class GetUsersResponse {
    private List<User> users;
}
