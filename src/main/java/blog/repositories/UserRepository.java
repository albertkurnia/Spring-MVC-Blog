package blog.repositories;

import blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by albertkurnia on 7/24/2017.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
