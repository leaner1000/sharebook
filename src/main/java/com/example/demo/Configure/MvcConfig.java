package com.example.demo.Configure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@PropertySource("classpath:mypath.properties")
public class MvcConfig implements WebMvcConfigurer {

    @Value("${zhangxile.top.path}")
    public String path;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String os = System.getProperty("os.name");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        if(os.toLowerCase().startsWith("win")) {
            registry.addResourceHandler("/img/**").addResourceLocations("file:"+path);
            registry.addResourceHandler("/**").addResourceLocations("file:"+path);
        }else{
            registry.addResourceHandler("/img/**").addResourceLocations("file:"+path);
        }
    }
}
