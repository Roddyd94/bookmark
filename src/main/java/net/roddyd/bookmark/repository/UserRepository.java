package net.roddyd.bookmark.repository;

import net.roddyd.bookmark.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
