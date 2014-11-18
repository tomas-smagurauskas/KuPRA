package api.services.implementations;

import api.domain.entities.authentication.User;
import api.domain.repositories.UserRepository;
import api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tomas on 14.10.13.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User createUser(User user) {
        userRepository.saveAndFlush(user);
        return user;
    }
    @Override
    public User getUser(String id) {
        return userRepository.findOne(Integer.parseInt(id));
    }
}
