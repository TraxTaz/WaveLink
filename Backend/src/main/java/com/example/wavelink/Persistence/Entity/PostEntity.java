package com.example.wavelink.Persistence.Entity;

import com.example.wavelink.Domain.Comment;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "Posts")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private UserEntity user;

    @OneToMany(mappedBy = "post")
    private List<CommentEntity> comments;

    @NotNull
    @Column(name = "date")
    private LocalDate date;

    @NotBlank
    @Length(min = 2, max = 1000)
    @Column(name = "description")
    private String description;
}
