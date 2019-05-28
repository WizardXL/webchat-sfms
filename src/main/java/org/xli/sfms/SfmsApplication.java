package org.xli.sfms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan(basePackages = "org.xli")
@tk.mybatis.spring.annotation.MapperScan(basePackages = "org.xli.sfms.dao")
@SpringBootApplication
@EnableTransactionManagement
public class SfmsApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(SfmsApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SfmsApplication.class);
    }
}

