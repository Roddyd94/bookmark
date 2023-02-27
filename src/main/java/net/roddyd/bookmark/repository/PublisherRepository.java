package net.roddyd.bookmark.repository;

import net.roddyd.bookmark.entity.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, String> {
}
