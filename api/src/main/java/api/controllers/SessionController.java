package api.controllers;

import api.domain.datatransferobjects.UserDTO;
import api.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by tomas on 14.12.7.
 */
@RestController
public class SessionController {

    @Autowired
    SessionService sessionService;

    @RequestMapping(value = "/activeUser")
    @ResponseBody
    public UserDTO getActiveUser(HttpServletRequest request, HttpServletResponse response) {

        UserDTO activeUser = null;

        try {
            activeUser = sessionService.getActiveUser(request);
        }
        catch (Exception e) {
            response.setStatus(401);
            return null;
        }

        return activeUser;
    }

}
