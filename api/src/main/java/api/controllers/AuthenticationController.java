package api.controllers;

import api.domain.entities.authentication.Session;
import api.domain.entities.authentication.User;
import api.domain.response.ServiceResponse;
import api.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utils.RestUrls;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by tomas on 14.11.17.
 */
@RestController
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(value = RestUrls.LOGIN)
    @ResponseBody
    public void login(@RequestBody User user, HttpServletResponse httpServletResponse,
                                 HttpServletRequest httpServletRequest) {
        ServiceResponse response = new ServiceResponse();

        try {
            Session session = authenticationService.login(user.getUsername(), user.getPassword());

            if (httpServletRequest.getCookies() != null) {
                for (Cookie cookie : httpServletRequest.getCookies()) {
                    cookie.setMaxAge(0);
                    httpServletResponse.addCookie(cookie);
                }
            }

            httpServletResponse.addCookie(new Cookie("sessionToken", session.getToken()));
        }
        catch (Exception ex) {
            httpServletResponse.setStatus(400);
            return;
        }

        return;
    }

    @RequestMapping(value = RestUrls.LOGOUT)
    @ResponseBody
    public void logout(@CookieValue("sessionToken") String token,
                                  HttpServletResponse httpServletResponse) {

        try {
            authenticationService.logout(token);
            Cookie nullCookie = new Cookie("sessionToken", "");
            nullCookie.setMaxAge(0);
            httpServletResponse.addCookie(nullCookie);
        }
        catch (Exception ex) {
            httpServletResponse.setStatus(400);
            return;
        }

        return;
    }


}