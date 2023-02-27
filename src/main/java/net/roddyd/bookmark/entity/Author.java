package net.roddyd.bookmark.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false)
    private String name;
    @ManyToMany
    private Set<Book> books;
}
