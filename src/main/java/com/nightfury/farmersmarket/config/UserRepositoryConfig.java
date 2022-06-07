package com.nightfury.farmersmarket.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "userDbEntityManagerFactory",
        transactionManagerRef = "userDbTransactionManager",
        basePackages = {"com.nightfury.farmersmarket.authentication"}
)
@EnableTransactionManagement
public class UserRepositoryConfig {

    @Bean(name = "userDbDataSource")
    @ConfigurationProperties(prefix = "user-database.datasource")
    public DataSource getDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "userDbEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder entityManagerFactoryBuilder) {
        HashMap<String,Object> additionalProperties = new HashMap<>();
        additionalProperties.put("hibernate.hbm2ddl.auto","create-drop");
        additionalProperties.put("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
        additionalProperties.put("hibernate.show_sql","true");
        additionalProperties.put("hibernate.format_sql","true");
        return entityManagerFactoryBuilder
                .dataSource(getDataSource())
                .packages("com.nightfury.farmersmarket.authentication")
                .persistenceUnit("farmers-market-users")
                .properties(additionalProperties)
                .build();
    }

    @Bean(name = "userDbTransactionManager")
    public PlatformTransactionManager platformTransactionManager(
            @Qualifier("userDbEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }


}