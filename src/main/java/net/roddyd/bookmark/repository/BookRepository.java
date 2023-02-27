package net.roddyd.bookmark.repository;

import net.roddyd.bookmark.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, String> {
}
