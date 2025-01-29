package com.example.Hello.configs;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

//Enable WSL and Install Ubuntu ,Install Redis on WSL

@Configuration
public class RedisConfig
{
    @Bean
    public RedisTemplate<String,Object> getRedisTemplate(RedisConnectionFactory redisConnectionFactory)
    {
        RedisTemplate<String,Object> Template=new RedisTemplate<>();
        Template.setConnectionFactory(redisConnectionFactory);
        return Template;
    }
}
