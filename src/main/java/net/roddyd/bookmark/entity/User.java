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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false)
    private String nickname;
    private String googleToken;
    private String naverToken;
    @OneToMany
    private Set<Bookmark> bookmarks;
}
