package io.cherrytechnologies.springrestserge.beans;

import io.cherrytechnologies.springrestserge.SpringApplicationContext;
import io.cherrytechnologies.springrestserge.security.AppProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BeanHouse {
    @Bean
    public final BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public final SpringApplicationContext getApplicationContext() {
        return new SpringApplicationContext();
    }

    @Bean(name = "AppProperties")
    public final AppProperties getAppProperties() {
        return new AppProperties();
    }

}
