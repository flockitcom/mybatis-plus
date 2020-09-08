package configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * SwaggerConfig
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {
//
    @Value("${swaggerui.isEnable}")
    private boolean isEnable;

    /**
     * 可以定义多个组
     * （访问页面就可以看到效果了）
     * 最后访问http://localhost:8009/swagger-ui.html
     */
    @Bean
    public Docket testApi() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        //添加头部参数，供拦截器验证
        tokenPar.name("abc").description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("project")
                .enable(isEnable)
                .genericModelSubstitutes(DeferredResult.class)
//                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("/")// base，最终调用接口后会和paths拼接在一起
                .select()
              //  .paths(or(regex("/api/.*")))//过滤的接口
                .paths(or(regex("/.*")))//过滤的接口
                .build()
                .globalOperationParameters(pars)
                .apiInfo(testApiInfo());
    }


    private ApiInfo testApiInfo() {
        return new ApiInfoBuilder()
                .title("mybatis-plus")//大标题
                .description("REST API.")//详细描述
                .version("1.0")//版本
                .termsOfServiceUrl("")
                .contact(new Contact("", "", ""))//作者
                .license("The Apache License, Version 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }

}