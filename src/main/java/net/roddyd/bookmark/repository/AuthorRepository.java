package net.roddyd.bookmark.repository;

import net.roddyd.bookmark.entity.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, String> {
}
