package onlineShop;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Damian Bartos on 20.06.2016.
 */

@RestController
public class Controller {

    @RequestMapping("/")
    @ResponseBody
    public String hello(){
        return "Spring hello";
    }
}
