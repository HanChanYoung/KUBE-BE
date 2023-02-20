package kube.kubecamp.config;

import io.lettuce.core.ReadFrom;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;


@Configuration
public class RedisConfiguration {


//    @Bean
//    public RedisConnectionFactory redisConnectionFactory(){
//        LettuceClientConfiguration clientConfiguration = LettuceClientConfiguration.builder()
//                .readFrom(ReadFrom.MASTER_PREFERRED)
//                .build();
//        // 모든 클러스터(master, slave) 정보를 적는다. (해당 서버중 접속되는 서버에서 cluster nodes 명령어를 통해 모든 클러스터 정보를 읽어오기에 다운 됐을 경우를 대비하여 모든 노드 정보를 적어두는편이 좋다.)
//        RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration()
//                .clusterNode("172.16.67.158", 6379)
//                .clusterNode("172.16.67.158", 6380)
//                .clusterNode("172.16.67.158", 6381)
//                .clusterNode("172.16.67.158", 6382)
//                .clusterNode("172.16.67.158", 6383)
//                .clusterNode("172.16.67.158", 6384);
//        LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(redisClusterConfiguration, clientConfiguration);
//        return lettuceConnectionFactory;
//    }

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory("172.16.67.158", 6379);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.setConnectionFactory(redisConnectionFactory());

        return redisTemplate;
    }
}
