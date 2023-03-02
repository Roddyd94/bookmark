package net.roddyd.bookmark.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class OAuth2 {
    @EmbeddedId
    private OAuth2Id id;
    @Column(unique = true, nullable = false)
    private String email;
}
