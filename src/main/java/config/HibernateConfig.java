package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan({"data" , "services"})
@PropertySource("classpath:database.properties")
public class HibernateConfig {

    @Autowired
    private Environment env;

    @Bean("sessionFactory")
    public LocalSessionFactoryBean getSessionFactory(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        sessionFactory.setDataSource(getDataSource());
        sessionFactory.setPackagesToScan("entities.*");
        sessionFactory.setHibernateProperties(hibernateProperties());



        return sessionFactory;
    }

    private Properties hibernateProperties() {
        Properties hbProperties = new Properties();
        hbProperties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        hbProperties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
        hbProperties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
        hbProperties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
        return hbProperties;
    }

    @Bean("dataSource")
    public DataSource getDataSource(){

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));

        return dataSource;


    }

}
