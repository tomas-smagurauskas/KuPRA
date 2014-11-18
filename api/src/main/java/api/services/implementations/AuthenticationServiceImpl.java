package api.services.implementations;

import api.domain.entities.authentication.Session;
import api.domain.entities.authentication.User;
import api.domain.repositories.SessionRepository;
import api.domain.repositories.UserRepository;
import api.services.AuthenticationService;
import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.ArrayList;

/**
 * Created by tomas on 14.11.12.
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SessionRepository sessionRepository;

    TimeBasedGenerator generator = Generators.timeBasedGenerator(EthernetAddress.fromInterface());

    @Override
    public Session login(String username, String password) {
        Session session = new Session();

        User user = userRepository.findByUsernameAndPassword(username, password);

        if (user == null) {
            throw new InvalidParameterException();
        }

        session.setUser(userRepository.findByUsername(username));
        session.setToken(username + generator.generate().toString());

        sessionRepository.saveAndFlush(session);

        return session;
    }

    @Override
    public Boolean logout(String token) {
        try {
            ArrayList<Session> sessions = sessionRepository.findByToken(token);

            for (Session session : sessions) {
                sessionRepository.delete(session.getId());
            }

            sessionRepository.flush();
        }
        catch (Exception ex) {
            return false;
        }

        return true;
    }

}
