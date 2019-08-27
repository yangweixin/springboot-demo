package top.oyoung.springbootdemo.configure;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonConfig {

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.useClusterServers()
            .setScanInterval(2000) // 集群状态扫描间隔时间，单位是毫秒
            //可以用"rediss://"来启用SSL连接
            .addNodeAddress(
                "redis://127.0.0.1:6380",
                "redis://127.0.0.1:6381",
                "redis://127.0.0.1:6382",
                "redis://127.0.0.1:6383",
                "redis://127.0.0.1:6384",
                "redis://127.0.0.1:6385"
            );

        return  Redisson.create(config);
    }
}
