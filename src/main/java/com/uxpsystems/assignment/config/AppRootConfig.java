package com.uxpsystems.assignment.config;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "com.uxpsystems.assignment")
@PropertySource(value = {"classpath:application.properties"})

public class AppRootConfig {
    private static Logger logger = Logger.getLogger("AppRootConfig.class");
    @Autowired
    Environment env;

    @Bean
    public LocalSessionFactoryBean localSessionFactoryBean() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(resetDataSource());
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        sessionFactoryBean.setPackagesToScan(new String[]{"com.uxpsystems.assignment.controller"});
        logger.debug("localSessionFactoryBean created..");
        return sessionFactoryBean;
    }

    @Bean
    public DataSource resetDataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        driverManagerDataSource.setUrl(env.getProperty("jdbc.url"));
        driverManagerDataSource.setUsername(env.getProperty("jdbc.user"));
        driverManagerDataSource.setPassword(env.getProperty("jdbc.password"));
        logger.debug("resetDataSource created..");
        return driverManagerDataSource;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        logger.debug("HibernateTransactionManagement created..");
        return transactionManager;
    }

    @Bean
    public Properties hibernateProperties() {
        Properties prop = new Properties();
        prop.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        prop.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        prop.setProperty("hibernate.globally_quoted_identifiers", "true");
        prop.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        prop.setProperty("hibernate.cache.use_second_level_cache", env.getProperty("hibernate.cache.use_second_level_cache"));
        prop.setProperty("hibernate.cache.region.factory_class", env.getProperty("hibernate.cache.region.factory_class"));
        //prop.setProperty("hibernate.cache.provider_class",env.getProperty("hibernate.cache.provider_class"));
        logger.debug("hibernateProperties settled while creating Transaction Managemet instanece..");
        return prop;
    }

}
