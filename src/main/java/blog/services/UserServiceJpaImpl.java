package blog.services;

import blog.models.User;
import blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by albertkurnia on 7/24/2017.
 */
public class UserServiceJpaImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return this.userRepository.findOne(id);
    }

    @Override
    public User create(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User edit(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        this.userRepository.delete(id);
    }
}
