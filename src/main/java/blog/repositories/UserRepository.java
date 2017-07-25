package blog.repositories;

import blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by albertkurnia on 7/24/2017.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username);

    @Query(value = "SELECT p.username FROM Users p WHERE p.username=:username",nativeQuery = true)
    public String getUsernameExist(@Param("username") String username);
}
