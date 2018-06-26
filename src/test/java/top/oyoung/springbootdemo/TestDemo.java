package top.oyoung.springbootdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import top.oyoung.springbootdemo.Constants.Constants;
import top.oyoung.springbootdemo.controller.TestController;
import top.oyoung.springbootdemo.dao.UserDao;
import top.oyoung.springbootdemo.entity.User;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestDemo {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithUserDetails("ya")
    public void demoTest2() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/test/3/1"))
//                .andExpect(MockMvcResultMatchers.status().is3xxRedirection());
    }
}
