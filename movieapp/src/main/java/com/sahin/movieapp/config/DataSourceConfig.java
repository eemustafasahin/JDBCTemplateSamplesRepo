package com.sahin.movieapp.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by M.Şahin on 29/11/2021
 */
@Configuration
public class DataSourceConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "app.datasource.main")
    public HikariDataSource hikariDataSource()
    {
        return DataSourceBuilder
                .create()
                .type(HikariDataSource.class)
                .build();
    }

    @Bean //this way we can with multiple datasource. just need to get new JdbcTemplate with new datasource
    public JdbcTemplate jdbcTemplate(HikariDataSource hikariDataSource)
    {
        return new JdbcTemplate(hikariDataSource);
    }
}
