package net.pis.config.jpa;

import org.hibernate.dialect.SQLServerDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import javax.sql.DataSource;
import java.util.HashMap;

/**
 * JPA 설정 (datasource, transaction manager등..)
 *
 */
@Configuration
@PropertySource({ "classpath:application.properties" })
@EnableJpaRepositories(
        basePackages = "net.pis.repository",
        entityManagerFactoryRef = "demoEntityManager",
        transactionManagerRef = "demoTransactionManager"
)
public class DemoJpaConfiguration {

    @Autowired
    private Environment env;


    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean demoEntityManager(){

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setPersistenceUnitName("DEMO");
        em.setDataSource(demoDataSource());
        em.setPackagesToScan(
                new String[] { "net.pis.orm.domain" });

        HibernateJpaVendorAdapter vendorAdapter
                = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto","none");
        properties.put("hibernate.dialect", new SQLServerDialect());
        em.setJpaPropertyMap(properties);

        return em;

    }


    @Primary
    @Bean
    public DataSource demoDataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName( env.getProperty("demo.datasource.driverClassName"));
        dataSource.setUrl(env.getProperty("demo.datasource.url"));
        dataSource.setUsername(env.getProperty("demo.datasource.username"));
        dataSource.setPassword(env.getProperty("demo.datasource.password"));

        return dataSource;
    }


    @Primary
    @Bean
    public PlatformTransactionManager demoTransactionManager() {

        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(demoEntityManager().getObject());
        return transactionManager;

    }
}
