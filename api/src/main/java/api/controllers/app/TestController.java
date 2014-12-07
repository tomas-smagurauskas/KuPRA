package api.controllers.app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import utils.RestUrls;


/**
 * Created by tomas on 14.10.7.
 */
@RequestMapping(value = RestUrls.APP_MAPPING)
@RestController
public class TestController {

    //TESTING PURPOSES

    @RequestMapping(value="/asd")
    public @ResponseBody String getAsd() {
        return "ssssss";
    }

    @RequestMapping(value="/qqwe")
    public String getQwe() {

        return "asd";
    }

    @RequestMapping(value = "/")
    public @ResponseBody String getAsdd() {

        return "donddde";
    }

}
