package top.oyoung.springbootdemo.controller;

//import org.springframework.data.redis.core.RedisTemplate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.constraints.Range;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.oyoung.springbootdemo.annotation.MyGate;
import top.oyoung.springbootdemo.dao.UserDao;
import top.oyoung.springbootdemo.entity.Person;
import top.oyoung.springbootdemo.entity.User;
import top.oyoung.springbootdemo.service.TestService;
import top.oyoung.springbootdemo.tool.RedisUtil;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @Method: top.oyoung.springbootdemo.controller
 * @Desc:
 * @Author: Yang Weixin
 * @Date: 2018/3/23 13:24
 */
@Api("test")
@Controller
@Validated
@RequestMapping("/test")
public class TestController {

    @Resource
    private TestService testService;
    @Resource
    private Person person;
//    @Resource
//    private ConcatStrService concatStrService;
    @Resource
    private RedisUtil redisUtil;
    @Resource
    private UserDao userDao;

//    @RequestMapping("1")
//    @ResponseBody
//    public String t1() {
//        System.out.println(person.toString());
//        return DateUtil.getToday(DateUtil.DATE_FORMAT_SHORT);
//    }

    @ApiOperation("index")
    @RequestMapping("")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("param","young");
        modelAndView.addObject("params",new ArrayList<>());
        return modelAndView;
    }

//    @RequestMapping("1")
//    @ResponseBody
//    public String t1() {
//        System.out.println(person.toString());
//        return DateUtil.getToday(DateUtil.DATE_FORMAT_SHORT);
//    }

//    @RequestMapping("2/{content}")
//    @ResponseBody
//    public String t2(@PathVariable("content")String content) {
//        return concatStrService.doConcat(content);
//    }

    @PreAuthorize("hasRole('NOMAL')")
//    @PostAuthorize("returnObject.account == 'y'")
    @RequestMapping("3/{id}")
    @ResponseBody
    public User t3(@Param("user") String user, @PathVariable("id")int id){
        return testService.getUserById(id);
    }

    @PostMapping("4/{id}/{account}")
    @ResponseBody
    public String t4(@PathVariable("id")int id,@PathVariable("account")String account){
        testService.updateUserById(id, account);
        return "success";
    }

    @RequestMapping("5/{id}")
    @ResponseBody
    public String t5(@PathVariable("id")int id){
        testService.deleteCache();
        return "success";
    }

    @RequestMapping("6/{key}/{value}")
    @ResponseBody
    public String t6(@PathVariable("key")String key, @PathVariable("value")String value){
        redisUtil.setValue(key, value);
        return redisUtil.getValue(key).toString();
    }

    @RequestMapping("/valid")
    @ResponseBody
    public String valid(
        @Range
        @MyGate(message = "必须数字哦",regexp = "\\d*")
        String name
    ){
        return "name";
    }
}
