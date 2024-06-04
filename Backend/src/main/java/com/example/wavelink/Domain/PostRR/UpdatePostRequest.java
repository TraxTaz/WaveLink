package com.example.wavelink.Domain.PostRR;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class UpdatePostRequest {
    private String Description;
}
