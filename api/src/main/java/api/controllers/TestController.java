package api.controllers;

import api.domain.entities.User;
import api.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by tomas on 14.10.7.
 */
@RestController
public class TestController {

    //TESTING PURPOSES

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value="/")
    public @ResponseBody String getAsd() {
        return "ssssss";
    }

    @RequestMapping(value="/qqwe")
    public List<User> getQwe() {
        List<User> listux = userRepository.findByAsdLike("asd");

        return listux;
    }

    @RequestMapping(value = "/asd")
    public @ResponseBody String getAsdd() {
        User user = new User();
        user.setAsd("qqq");

        userRepository.save(user);

        User user2 = new User();
        user2.setAsd("asd");

        userRepository.save(user2);

        return "donddde";
    }

}
