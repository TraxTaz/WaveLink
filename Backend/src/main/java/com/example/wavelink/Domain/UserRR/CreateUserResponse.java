package com.example.wavelink.Domain.UserRR;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.web.service.annotation.GetExchange;

@Getter
@Data
@Builder
public class CreateUserResponse {
    private Long id;
}
