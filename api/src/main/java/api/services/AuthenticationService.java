package api.services;


import api.domain.entities.authentication.Session;

/**
 * Created by tomas on 14.11.12.
 */
public interface AuthenticationService {

    public Session login(String username, String password);
    public Boolean logout(String token);
}
