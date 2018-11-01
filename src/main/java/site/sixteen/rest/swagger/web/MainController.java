package site.sixteen.rest.swagger.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * MainController
 *
 * @author panhainan
 * @version 1.0
 * @description 主控制器
 * @date 2018/11/1 22:00
 */
@RestController
public class MainController {

    @GetMapping("/hello")
    public String hello(@RequestParam(defaultValue = "world") String name) {
        return "hello, " + name + ".";
    }

    @GetMapping("/map")
    public Map<String, Object> map() {
        HashMap<String, Object> map = new HashMap<>(10);
        map.put("hello", "world");
        map.put("sixteen", 16);
        return map;
    }

}
