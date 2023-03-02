package net.roddyd.bookmark.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
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
    private String nickname;
    @OneToMany
    private Set<Bookmark> bookmarks;
    @UpdateTimestamp
    private LocalDateTime lastLogin;
}
