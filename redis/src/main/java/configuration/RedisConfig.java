package configuration;


import com.zq.property.RedisProperties;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.MapPropertySource;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceClusterConnection;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableConfigurationProperties(RedisProperties.class)//com.eiisys.property 加了 @Component 这个可以不加
public class RedisConfig {

    @Resource
    RedisProperties redisProperties;

    @Bean(name = "redisClusterConfiguration")
    public RedisClusterConfiguration getRedisClusterConfiguration(){

        Map<String, Object> source = new HashMap<>();
        source.put("spring.redis.cluster.nodes", redisProperties.getCluster().getNodes());
        source.put("spring.redis.cluster.max-redirects", redisProperties.getCluster().getMaxRedirects());
        source.put("spring.redis.password",redisProperties.getPassword());
        return new RedisClusterConfiguration(new MapPropertySource("RedisClusterConfiguration", source));
    }

    @Bean(name = "lettuceConnectionFactory")
    public LettuceConnectionFactory lettuceConnectionFactory(@Qualifier(value = "redisClusterConfiguration") RedisClusterConfiguration configuration){
        LettuceConnectionFactory lettuceConnectionFactory=new LettuceConnectionFactory(configuration);
        return lettuceConnectionFactory;
    }
    @Bean(name = "lettuceClusterConnection")
    public LettuceClusterConnection lettuceClusterConnection(@Qualifier(value = "lettuceConnectionFactory") RedisConnectionFactory factory){
        return (LettuceClusterConnection) factory.getConnection();
    }

    /**
     * 实例化 RedisTemplate 对象
     *
     * @return
     */
    @Bean(name = "redisTemplate")
    public RedisTemplate<Object, Object> functionDomainRedisTemplate(
            @Qualifier(value = "lettuceConnectionFactory") RedisConnectionFactory factory) {

        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);

        // JdkSerializationRedisSerializer jdkSerializationRedisSerializer = new JdkSerializationRedisSerializer();// redis 默认序列化
        //GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer();
        // 设置值（value）的序列化采用FastJsonRedisSerializer。
        RedisSerializer serializer = new StringRedisSerializer();
        template.setValueSerializer(serializer);
        //        redisTemplate.setHashValueSerializer(fastJsonRedisSerializer);
        // 设置键（key）的序列化采用StringRedisSerializer。
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.afterPropertiesSet();
        return template;
    }
}
