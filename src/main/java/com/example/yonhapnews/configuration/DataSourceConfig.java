package com.example.yonhapnews.configuration;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Log4j2
@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource(){
        log.info("[DataSourceConfig] DriverManagerDataSource SET..");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");;
        dataSource.setUsername("[SECURITY]");
        dataSource.setPassword("[SECURITY]");
        dataSource.setUrl(
                "[SECURITY]"
        );
        return dataSource;
    }

}
