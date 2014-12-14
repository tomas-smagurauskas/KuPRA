package api.services.implementations;

import api.domain.entities.authentication.User;
import api.domain.entities.authentication.enums.UserRole;
import api.domain.entities.fridge.Fridge;
import api.domain.repositories.FridgeRepository;
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

    @Autowired
    FridgeRepository fridgeRepository;

    @Override
    public User createUser(User user) {

        user.setRole(UserRole.USER);
        user = userRepository.saveAndFlush(user);

        Fridge fridge = new Fridge();
        fridge.setUser(user);
        fridgeRepository.saveAndFlush(fridge);

        return user;
    }
    @Override
    public User getUser(String id) {
        return userRepository.findOne(Integer.parseInt(id));
    }
}
