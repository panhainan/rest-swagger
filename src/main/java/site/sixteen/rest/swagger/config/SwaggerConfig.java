package site.sixteen.rest.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.*;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * site.sixteen.rest.swagger.config.SwaggerConfig
 *
 * @author panhainan
 * @version 1.0
 * @description Swagger配置
 * @date 2018/11/1 22:00
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String AUTH_SERVER = "swagger";
    private static final String CLIENT_ID = "app";
    private static final String CLIENT_SECRET = "swagger";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
            .apis(RequestHandlerSelectors.basePackage("site.sixteen.rest.swagger.web")).paths(PathSelectors.any())
            .build().apiInfo(apiInfo()).useDefaultResponseMessages(false).globalResponseMessage(RequestMethod.GET,
                new ArrayList<>(Arrays.asList(new ResponseMessageBuilder().code(500).message("500 message").build(),
                    new ResponseMessageBuilder().code(403).message("Forbidden!").build())));
        //.responseModel(new ModelRef("Error"))
        //.securitySchemes(Arrays.asList(securityScheme()))
        //.securityContexts(Arrays.asList(securityContext()));
    }

    private SecurityScheme securityScheme() {
        GrantType grantType =
            new AuthorizationCodeGrantBuilder().tokenEndpoint(new TokenEndpoint(AUTH_SERVER + "/token", "oauthtoken"))
                .tokenRequestEndpoint(new TokenRequestEndpoint(AUTH_SERVER + "/authorize", CLIENT_ID, CLIENT_SECRET))
                .build();
        SecurityScheme oauth =
            new OAuthBuilder().name("spring_oauth").grantTypes(Arrays.asList(grantType)).scopes(Arrays.asList(scopes()))
                .build();
        return oauth;
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
            .securityReferences(Arrays.asList(new SecurityReference("spring_oauth", scopes())))
            .forPaths(PathSelectors.regex("/blog.*")).build();
    }

    private AuthorizationScope[] scopes() {
        AuthorizationScope[] scopes = {new AuthorizationScope("read", "for read operations"),
            new AuthorizationScope("write", "for write operations"), new AuthorizationScope("blog", "Access blog API")};
        return scopes;
    }

    private SecurityConfiguration security() {
        return SecurityConfigurationBuilder.builder().clientId(CLIENT_ID).clientSecret(CLIENT_SECRET)
            .scopeSeparator(" ").useBasicAuthenticationWithAccessCodeGrant(true).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("Swagger使用示例", "示例的API描述", "1.0", "Terms of service",
            new Contact("Sixteen", "https://sixteen.site", "panhainan16@gmail.com"), "License of API",
            "API license URL", Collections.emptyList());
    }
}
