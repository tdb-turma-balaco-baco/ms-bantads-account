package br.net.dac.account.Infrastructure.Persistence.Configurations;

import java.util.HashMap;
import java.util.Objects;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
    basePackages = "br.net.dac.account.Infrastructure.Persistence.RepositoriesRead",
    entityManagerFactoryRef = "accountReadEntityManager",
    transactionManagerRef = "accountReadTransactionManager")
public class AccountReadDataBase {

    @Autowired
    private Environment env;

    @Bean
    @ConfigurationProperties("spring.datasource.account-read")
    public DataSourceProperties readDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource accountReadDataSource() {
        return readDataSourceProperties()
          .initializeDataSourceBuilder()
          .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean accountReadEntityManager(
      @Qualifier("accountReadDataSource") DataSource dataSource,
      EntityManagerFactoryBuilder builder
    ) {
        final HashMap<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
        properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));

        return builder
          .dataSource(dataSource)
          .packages("br.net.dac.account.Domain.Entities.Read")
          .properties(properties)
          .build();
    }

    @Bean
    public PlatformTransactionManager accountReadTransactionManager(
      @Qualifier("accountReadEntityManager") LocalContainerEntityManagerFactoryBean accountReadEntityManager) {
        return new JpaTransactionManager(Objects.requireNonNull(accountReadEntityManager.getObject()));
    }

}
