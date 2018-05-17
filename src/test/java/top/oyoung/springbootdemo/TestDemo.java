package top.oyoung.springbootdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import top.oyoung.springbootdemo.entity.User;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestDemo {

//    @Resource
//    private WebTestClient webClient;

    @Resource
    private TestRestTemplate restTemplate;

//    @Test
//    public void demoTest1(){
//        Object returnOjb = this.webClient.
//            get()
//            .uri("/test/3/1")
//            .exchange()
//                .expectStatus().isOk()
//                .expectBody(User.class)
//                .returnResult();
//
//        System.out.println(returnOjb);
//    }

    @Test
    public void demoTest2(){
        this.restTemplate.getForEntity("/test/3/1",Object.class);
    }
}
