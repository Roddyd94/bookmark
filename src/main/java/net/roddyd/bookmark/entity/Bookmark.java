package net.roddyd.bookmark.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Bookmark {
    @EmbeddedId
    private BookmarkId id;
    @Column(nullable = false)
    private Integer page;

    @UpdateTimestamp
    private LocalDateTime markdate;
}
