package com.phaetonet.unicorn.shiro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by Administrator on 2017/5/29.
 */

@Configuration
public class ShiroPropertiesConfig {

    @Bean
    public PropertySourcesPlaceholderConfigurer createPropertySourcesPlaceholderConfigurer() {
        ClassPathResource resource = new ClassPathResource("shiro.properties");
        PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        propertyPlaceholderConfigurer.setLocation(resource);
        return propertyPlaceholderConfigurer;
    }
}
