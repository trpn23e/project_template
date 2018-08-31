package net.pis.config.mybatis;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Driver;

@Configuration
@PropertySource({ "classpath:application.properties" })
@MapperScan(value="net.pis.dao", sqlSessionFactoryRef="db1SqlSessionFactory")
//@MapperScan(value="net.pis.dao")
public class SqlSessionFactoryConfig {

    @Autowired
    private Environment env;

    @Autowired
    private ApplicationContext applicationContext;

    // 트랜잭션 Manager를 사용하려면 이거 쓰면 안됨
    // (Hikari CP)
    // @Bean(name = "db1DataSource", destroyMethod = "close")
    // @ConfigurationProperties(prefix = "spring.db1.datasource")
    // public DataSource db1DataSource() {
    //     return DataSourceBuilder.create().build();
    // }

    // 트랜잭션 Manager 사용시 사용
    @Bean(name = "db1DataSource", destroyMethod = "close")
    public DataSource db1DataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.db1.datasource.driverClassName"));
        dataSource.setUrl(env.getProperty("spring.db1.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.db1.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.db1.datasource.password"));

        return dataSource;
    }

    @Bean(name = "db1TransactionManager")
    public DataSourceTransactionManager transactionManager() throws Exception {
        return new DataSourceTransactionManager(db1DataSource());
    }

    @Bean(name = "db1SqlSessionFactory")
    // public SqlSessionFactory db1SqlSessionFactory(@Qualifier("db1DataSource") DataSource db1DataSource, ApplicationContext applicationContext) throws Exception {
    public SqlSessionFactory db1SqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(this.db1DataSource());
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:net/pis/mapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "db1SqlSessionTemplate", destroyMethod = "clearCache")
    // public SqlSessionTemplate db1SqlSessionTemplate(SqlSessionFactory db1SqlSessionFactory) throws Exception {
    public SqlSessionTemplate db1SqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(this.db1SqlSessionFactory());
    }
}
