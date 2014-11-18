package api.services;

import api.domain.entities.authentication.User;

/**
 * Created by tomas on 14.10.13.
 */
public interface UserService {

    public User createUser(User user);
    public User getUser(String id);
}
