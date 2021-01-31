package com.sunday.otmt.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@PropertySource("classpath:persistence.properties")
public class DatabaseConfig {

    @Autowired
    private Environment env;

    @Bean
    public ComboPooledDataSource comboPooledDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        dataSource.setUser(env.getProperty("jdbc.user"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        dataSource.setDriverClass(env.getProperty("jdbc.driver"));
        dataSource.setJdbcUrl(env.getProperty("jdbc.url"));

        dataSource.setMinPoolSize(getIntegerValue(env.getProperty("connection.minPoolSize")));
        dataSource.setMaxPoolSize(getIntegerValue(env.getProperty("connection.maxPoolSize")));
        dataSource.setMaxIdleTime(getIntegerValue(env.getProperty("connection.maxIdleTime")));
        dataSource.setInitialPoolSize(getIntegerValue(env.getProperty("connection.initialPoolSize")));

        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean localSessionFactoryBean() throws PropertyVetoException {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

        Properties pros = new Properties();
        pros.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        pros.put("hibernate.packagesToScan", env.getProperty("hibernate.packagesToScan"));
        pros.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        pros.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        factoryBean.setHibernateProperties(pros);
        factoryBean.setDataSource(comboPooledDataSource());

        return factoryBean;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);

        return transactionManager;
    }

    public int getIntegerValue(String value){
        try {
            return Integer.valueOf(value);
        } catch (NumberFormatException exp){
            exp.printStackTrace();
            return 0;
        }
    }


}
