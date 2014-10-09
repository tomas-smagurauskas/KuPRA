package api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tomas on 14.10.7.
 */
@Controller
public class TestController {

    @RequestMapping(value="/")
    public @ResponseBody String getAsd() {
        return "aaaaaaaaaaaaaaaaaa";
    }

    @RequestMapping(value="/qqwe")
    public @ResponseBody String getQwe() {
        return "wqeoashid aoisdh ahsdioasd";
    }

}
