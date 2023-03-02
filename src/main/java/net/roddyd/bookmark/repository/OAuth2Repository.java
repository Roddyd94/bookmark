package net.roddyd.bookmark.repository;

import net.roddyd.bookmark.entity.OAuth2;
import net.roddyd.bookmark.entity.OAuth2Id;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OAuth2Repository extends CrudRepository<OAuth2, OAuth2Id> {
    List<OAuth2> findByIdSub(String sub);
}
