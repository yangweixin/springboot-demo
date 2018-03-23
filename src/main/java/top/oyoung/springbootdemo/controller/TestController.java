package top.oyoung.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Method: top.oyoung.springbootdemo.controller
 * @Desc:
 * @Author: Yang Weixin
 * @Date: 2018/3/23 13:24
 */
@RestController("/test")
public class TestController {

    @RequestMapping("t1")
    public String t1(){
        return "t1";
    }
}
