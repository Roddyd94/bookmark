package net.roddyd.bookmark.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BookmarkId implements Serializable {
    @ManyToOne
    private User user;
    @ManyToOne
    private Book book;
    
    @Override
    public  boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof BookmarkId)) return false;
        BookmarkId that = (BookmarkId) o;
        return Objects.equals(getUser().getId(), that.getUser().getId()) &&
                Objects.equals(getBook().getIsbn(), that.getBook().getIsbn());
    }
    @Override
    public int hashCode(){
        return Objects.hash(getUser().getId(),
                getBook().getIsbn());
    }
}
