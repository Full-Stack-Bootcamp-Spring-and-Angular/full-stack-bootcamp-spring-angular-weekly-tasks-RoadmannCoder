    package com.springmvc.config;

    import com.mchange.v2.c3p0.ComboPooledDataSource;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.ComponentScan;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.orm.hibernate4.HibernateTransactionManager;
    import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
    import org.springframework.transaction.annotation.EnableTransactionManagement;
    import org.springframework.web.servlet.ViewResolver;
    import org.springframework.web.servlet.config.annotation.EnableWebMvc;
    import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
    import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
    import org.springframework.web.servlet.view.InternalResourceViewResolver;

    import javax.sql.DataSource;
    import java.beans.PropertyVetoException;
    import java.util.Properties;

    @Configuration
    @EnableWebMvc
    @EnableTransactionManagement
    @ComponentScan("com.springmvc")
    public class WebConfig extends WebMvcConfigurerAdapter {

        @Bean
        public ViewResolver viewResolver() {
            InternalResourceViewResolver resolver = new InternalResourceViewResolver();
            resolver.setPrefix("/WEB-INF/views/");
            resolver.setSuffix(".jsp");
            return resolver;
        }

        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/resources/**")
                    .addResourceLocations("/resources/");
        }

        @Bean
        public DataSource dataSource() {
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            try {
                dataSource.setDriverClass("com.mysql.jdbc.Driver");
            } catch (PropertyVetoException e) {
                throw new RuntimeException("Failed to load MySQL Driver", e);
            }
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/amazonly?createDatabaseIfNotExist=true");
            dataSource.setUser("root");
            dataSource.setPassword("0000");
            dataSource.setMinPoolSize(5);
            dataSource.setMaxPoolSize(20);
            dataSource.setMaxIdleTime(30000);

            return dataSource;
        }

        @Bean
        public LocalSessionFactoryBean sessionFactory() {
            LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
            sessionFactory.setDataSource(dataSource());
            sessionFactory.setPackagesToScan("com.springmvc.models");
            Properties hibernateProperties = new Properties();
            hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            hibernateProperties.setProperty("hibernate.show_sql", "true");
            hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
            sessionFactory.setHibernateProperties(hibernateProperties);
            return sessionFactory;
        }

        @Bean
        public HibernateTransactionManager transactionManager() {
            HibernateTransactionManager transactionManager = new HibernateTransactionManager();
            transactionManager.setSessionFactory(sessionFactory().getObject());
            return transactionManager;
        }


    }