package blog.services;

import blog.models.User;

import java.util.List;

/**
 * Created by albertkurnia on 7/24/2017.
 */
public interface UserService {

    List<User> findAll();
    User findById(Long id);
    User create(User user);
    User edit(User user);
    void deleteById(Long id);
}
