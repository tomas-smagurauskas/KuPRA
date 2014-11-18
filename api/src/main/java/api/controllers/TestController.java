package api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by tomas on 14.10.7.
 */
@RestController
public class TestController {

    //TESTING PURPOSES

    @RequestMapping(value="/asd/asd")
    public @ResponseBody String getAsd() {
        return "ssssss";
    }

    @RequestMapping(value="/qqwe")
    public String getQwe() {

        return "asd";
    }

    @RequestMapping(value = "/asd")
    public @ResponseBody String getAsdd() {

        return "donddde";
    }

}
