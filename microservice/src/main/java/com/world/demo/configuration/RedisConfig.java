package com.world.demo.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;


@Configuration
@ComponentScan( "com.world" )
public class RedisConfig
{
    @Value( "${spring.redis.host}" )
    private String hostName;
    @Value( "${spring.redis.port}" )
    private int port;


    @Bean
    JedisConnectionFactory jedisConnectionFactory()
    {
        RedisStandaloneConfiguration standaloneConfig = new RedisStandaloneConfiguration();
        standaloneConfig.setHostName( hostName );
        standaloneConfig.setPort( port );
        return new JedisConnectionFactory( standaloneConfig );
    }
}
