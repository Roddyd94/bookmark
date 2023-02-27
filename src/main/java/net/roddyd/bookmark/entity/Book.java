package net.roddyd.bookmark.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Book {
    @Id
    private String isbn;
    @Column(nullable = false)
    private String title;
    @ManyToMany
    private Set<Author> authors;
    private String image;
    private String link;
    @ManyToOne
    private Publisher publisher;
    private Date pubdate;
}
