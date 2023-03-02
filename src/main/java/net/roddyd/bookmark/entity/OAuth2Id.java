package net.roddyd.bookmark.entity;

import jakarta.persistence.Column;
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
public class OAuth2Id implements Serializable {
    @ManyToOne
    private User user;
    @Column(nullable = false)
    private String sub;
    
    @Override
    public  boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof OAuth2Id)) return false;
        OAuth2Id that = (OAuth2Id) o;
        return Objects.equals(getUser().getId(), that.getUser().getId()) &&
                Objects.equals(getSub(), that.getSub());
    }
    @Override
    public int hashCode(){
        return Objects.hash(getUser().getId(),
                getSub());
    }
}
