package api.interceptors;

import api.domain.entities.authentication.Session;
import api.domain.entities.authentication.User;
import api.domain.repositories.SessionRepository;
import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Created by tomas on 14.10.13.
 */
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    TimeBasedGenerator generator = Generators.timeBasedGenerator(EthernetAddress.fromInterface());

    @Autowired
    SessionRepository sessionRepository;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        try {
            Cookie[] cookies = request.getCookies();
            String sessionToken = null;

            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if (name.compareTo("sessionToken") == 0) {
                    sessionToken = cookie.getValue();
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }

            if (sessionToken == null) {
                response.setStatus(401);
                return false;
            }

            ArrayList<Session> sessions = sessionRepository.findByToken(sessionToken);

            if (sessions.size() == 0) {
                response.setStatus(401);
                return false;
            }

            User activeUser = sessions.get(0).getUser();

            for (Session session : sessions) {
                sessionRepository.delete(session);
            }
            sessionRepository.flush();

            String newToken = null;
            Session newSession = new Session();
            newSession.setUser(activeUser);
            newToken = activeUser.getUsername() + generator.generate().toString();
            newSession.setToken(newToken);

            Cookie newCookie = new Cookie("sessionToken", newToken);
            newCookie.setPath("/");

            response.addCookie(newCookie);

            sessionRepository.saveAndFlush(newSession);

            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
            response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
            response.setHeader("Access-Control-Expose-Headers", "x-requested-with");
        }
        catch (Exception ex) {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
            response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
            response.setHeader("Access-Control-Expose-Headers", "x-requested-with");
            response.setStatus(401);
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        response.setHeader("Access-Control-Expose-Headers", "x-requested-with");
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }
}
