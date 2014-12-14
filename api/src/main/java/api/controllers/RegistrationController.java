package api.controllers;

import api.domain.datatransferobjects.UserDTO;
import api.domain.entities.authentication.User;
import api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import utils.RestUrls;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by tomas on 14.11.17.
 */
@RestController
public class RegistrationController {

    @Autowired
    UserService userService;

    @RequestMapping(value = RestUrls.REGISTER)
    @ResponseBody
    public UserDTO register(@RequestBody User user, HttpServletResponse httpServletResponse) {

        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        httpServletResponse.setHeader("Access-Control-Expose-Headers", "x-requested-with");

        try {
            user = userService.createUser(user);
            user.setPassword(null);
            return UserDTO.fromEntity(user);
        }
        catch (Exception ex) {
            httpServletResponse.setStatus(500);
            return null;
        }

    }

}
