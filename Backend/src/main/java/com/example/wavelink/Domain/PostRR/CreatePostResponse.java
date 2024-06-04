package com.example.wavelink.Domain.PostRR;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class CreatePostResponse {

    @NotNull
    @NotBlank
    private Long id;
}
