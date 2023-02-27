package net.roddyd.bookmark.repository;

import net.roddyd.bookmark.entity.Bookmark;
import net.roddyd.bookmark.entity.BookmarkId;
import org.springframework.data.repository.CrudRepository;

public interface BookmarkRepository extends CrudRepository<Bookmark, BookmarkId> {
}
