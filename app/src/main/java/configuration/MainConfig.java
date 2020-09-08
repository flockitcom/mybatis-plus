package configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.zq", useDefaultFilters = true)
@Import({MyBatisPlusConfig.class,SwaggerConfig.class,RedisConfig.class,HttpSessionConfig.class,FastDfsConfig.class})
public class MainConfig {
}
