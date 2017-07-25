package blog.services;

import org.omg.CORBA.Object;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Created by albertkurnia on 7/24/2017.
 */
@Service
public class UserServiceStubImpl implements UserServices {

    @Override
    public boolean authenticate(String username, String password) {
        return Objects.equals(username,password);
    }
}
