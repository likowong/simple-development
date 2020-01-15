package com.spring.simple.development.core.component.swagger;

import com.spring.simple.development.support.constant.SystemProperties;
import com.spring.simple.development.support.properties.PropertyConfigurer;
import com.spring.simple.development.support.utils.GroovyClassLoaderUtils;
import com.xxl.job.core.handler.IJobHandler;
import groovy.lang.GroovyClassLoader;
import org.apache.ibatis.annotations.Arg;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author liko.wang
 * @Date 2020/1/15/015 10:11
 * @Description SwaggerConfig
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

    public SwaggerConfig() throws Exception {
        String code = "package com.spring.simple.development.demo.controller;\n" +
                "\n" +
                "import io.swagger.annotations.Api;\n" +
                "import io.swagger.annotations.ApiOperation;\n" +
                "import org.springframework.web.bind.annotation.*;\n" +
                "\n" +
                "@RestController\n" +
                "@RequestMapping(\"test\")\n" +
                "@Api(value = \"Test\")\n" +
                "public class DemoSwaggerController {\n" +
                "\n" +
                "    @RequestMapping(value = \"index\",method = RequestMethod.POST)\n" +
                "    @ApiOperation(value = \"进入首页面1\")\n" +
                "    public String index1() {\n" +
                "        return \"index1\";\n" +
                "    }\n" +
                "}\n";
        Class aClass = GroovyClassLoaderUtils.loadNewInstance(code);
        DynamicControllerMapping.addMapping(aClass);
    }
    private String title = PropertyConfigurer.getProperty(SystemProperties.APPLICATION_SWAGGER_TITLE);
    private String description = PropertyConfigurer.getProperty(SystemProperties.APPLICATION_SWAGGER_DESCRIPTION);
    private String contact = PropertyConfigurer.getProperty(SystemProperties.APPLICATION_SWAGGER_CONTACT);
    private String version = PropertyConfigurer.getProperty(SystemProperties.APPLICATION_SWAGGER_VERSION);
    private String url = PropertyConfigurer.getProperty(SystemProperties.APPLICATION_SWAGGER_URL);

    @Bean
    public Docket buildDocket() {
        Docket build = new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any()) // and by paths
                .build();
        return build;

    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 解决静态资源无法访问
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
        // 解决swagger无法访问
        registry.addResourceHandler("/swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        // 解决swagger的js文件无法访问
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .termsOfServiceUrl(url)
                .contact(contact)
                .version(version)
                .build();
    }
}