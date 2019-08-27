package top.oyoung.springbootdemo.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
public class SwaggerConfigurer{
    @Bean
    public Docket petApi(){
        return new Docket(DocumentationType.SWAGGER_2)
            .groupName("package")
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("top.oyoung.springbootdemo.controller"))
            .paths(PathSelectors.any())
            .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("api文档")
            .description("restfun 风格接口")
            //服务条款网址
            .termsOfServiceUrl("http://blog.csdn.net/forezp")
            .version("1.0")
            .contact(new Contact("帅呆了", "url", "email"))
            .build();
    }

}
