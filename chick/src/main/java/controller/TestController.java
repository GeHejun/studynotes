package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.TestService;

import javax.annotation.Resource;

/**
 * @author gehejun
 */
@Controller
public class TestController {

    @Resource
    TestService testService;

    @RequestMapping("/test")
    public void test() {
        testService.test();
    }
}
