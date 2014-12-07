package api.controllers;

import api.domain.entities.authentication.User;
import api.domain.response.ServiceResponse;
import api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import utils.RestUrls;

/**
 * Created by tomas on 14.11.17.
 */
@RestController
public class RegistrationController {

    @Autowired
    UserService userService;

    @RequestMapping(value = RestUrls.REGISTER)
    @ResponseBody
    public ServiceResponse register(@RequestBody User user) {
        ServiceResponse response = new ServiceResponse();

        try {
            user = userService.createUser(user);
            user.setPassword(null);
            response.setResult(user);
        }
        catch (Exception ex) {
            response.setError("ERROR CREATING USER");
        }

        return response;
    }

}
