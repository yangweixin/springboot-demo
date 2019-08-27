package top.oyoung.springbootdemo;


import org.junit.Test;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

public class RedissonTest extends BaseTest {

    @Resource
    private RedissonClient redissonClient;

    @Test
    public void testRedisson() throws InterruptedException {
        RLock rLock = redissonClient.getLock("mylock");
        Boolean rs = rLock.tryLock(1000, 20000, TimeUnit.MILLISECONDS);
        System.out.println(rs);
    }
}
