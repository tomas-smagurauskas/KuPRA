package api.services.implementations;

import api.domain.datatransferobjects.UserDTO;
import api.domain.entities.authentication.Session;
import api.domain.entities.authentication.User;
import api.domain.repositories.SessionRepository;
import api.exceptions.NotLoggedInException;
import api.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by tomas on 14.12.7.
 */
@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    SessionRepository sessionRepository;

    @Override
    public UserDTO getActiveUser(HttpServletRequest request) throws NotLoggedInException {

        UserDTO activeUser = new UserDTO();

        Cookie[] cookies = request.getCookies();
        String sessionToken = null;

        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if (name.compareTo("sessionToken") == 0) {
                sessionToken = cookie.getValue();
            }
        }

        if (sessionToken == null) {
            throw new NotLoggedInException();
        }

        ArrayList<Session> sessions = sessionRepository.findByToken(sessionToken);

        if (sessions.size() == 0) {
            throw new NotLoggedInException();
        }

        User user = sessions.get(0).getUser();

        if (user == null) {
            throw new NotLoggedInException();
        }

        activeUser.setRole(user.getRole());
        activeUser.setUsername(user.getUsername());

        return activeUser;
    }

}
