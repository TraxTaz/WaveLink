package com.example.wavelink.Persistence;

import com.example.wavelink.Persistence.Entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
}
