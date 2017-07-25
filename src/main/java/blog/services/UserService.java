package blog.services;

import blog.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by albertkurnia on 7/24/2017.
 */
public interface UserService {

    List<User> findAll();
    User findById(Long id);
    User create(User user);
    User edit(User user);
    User findByUsername(String username);
    void deleteById(Long id);

    boolean authenticate(String username, String password);
    boolean checkIfUsernameExist(String username);
}
