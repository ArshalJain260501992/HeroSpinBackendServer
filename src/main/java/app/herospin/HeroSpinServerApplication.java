package app.herospin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableCaching
@SpringBootApplication
public class HeroSpinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeroSpinServerApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		log.info("Rest template genrated");
		return builder.build();
	}

//	@Bean
//	JedisConnectionFactory jedisConnectionFactory() {
//		log.info("Jedis connection factory generated");
//		return new JedisConnectionFactory();
//	}
//
//	@Bean
//	public RedisTemplate<String, Object> redisTemplate() {
//		RedisTemplate<String, Object> template = new RedisTemplate<>();
//		template.setConnectionFactory(jedisConnectionFactory());
//		log.info("Redis template generated");
//		return template;
//	}

}
