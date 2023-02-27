package net.roddyd.bookmark.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

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
    @CreationTimestamp
    @UpdateTimestamp
    private Date markdate;
}
