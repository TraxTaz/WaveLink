package com.example.wavelink.Persistence;

import com.example.wavelink.Persistence.Entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
